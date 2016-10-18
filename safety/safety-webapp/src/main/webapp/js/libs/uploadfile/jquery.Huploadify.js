
(function($){
$.fn.Huploadify = function(opts){
	var itemTemp = '<div id="{fileID}" class="uploadify-queue-item" name="uploadify-queue-item"><div class="uploadify-progress" name="uploadify-progress"><div class="uploadify-progress-bar" name="uploadify-progress-bar"></div></div><span class="up_filename">{fileName}</span><span class="uploadbtn" name="coverbtn">覆盖</span><span class="uploadbtn" name="continuebtn">续传</span><span class="uploadbtn" name="uploadbtn">上传</span><span class="delfilebtn" name="delfilebtn">取消</span><span class="progressnum" name="showuploadsize"><span class="uploadedsize" name="uploadedsize">  </span>/<span class="totalsize" name="totalsize"></span></span><span class="up_percent" name="up_percent"></span></div>';
	var defaults = {
		fileTypeExts:'*.*',//允许上传的文件类型，格式'*.jpg;*.doc'
		uploader:'',//文件提交的地址
		queryfileInfoUrl:"",//查询文件信息
		auto:true,//是否开启自动上传
		method:'post',//发送请求的方式，get或post
		multi:true,//是否允许选择多个文件
		formData:{},//发送给服务端的参数，格式：{key1:value1,key2:value2}
		fileObjName:'file',//在后端接受文件的参数名称，如PHP中的$_FILES['file']
		fileSizeLimit:20*1024,//允许上传的文件大小，单位KB 0:不限制
		showUploadedPercent:true,//是否实时显示上传的百分比，如20%
		showUploadedSize:true,//是否实时显示已上传的文件大小，如1M/2M
		buttonText:'选择文件',//上传按钮上的文字
		buttonTemplate:"",//自定义上传按钮模板
		itemTemplate:itemTemp,//上传队列显示的模板
		uploadProcessClass:"",//进度条样式名称
		uploadProcess:"",//进度条位置
		removeTimeout: 1000,//上传完成后进度条的消失时间
		breakPoints:true,//是否开启断点续传
		fileSplitSize:1024*1024,//断点续传的文件块大小，单位Byte，默认1M
		getUploadedSize:null,//类型：function，自定义获取已上传文件的大小函数，用于开启断点续传模式，可传入一个参数file，即当前上传的文件对象，需返回number类型
		saveUploadedSize:null,//类型：function，自定义保存已上传文件的大小函数，用于开启断点续传模式，可传入两个参数：file：当前上传的文件对象，value：已上传文件的大小，单位Byte
		saveInfoLocal:false,//用于开启断点续传模式，是否使用localStorage存储已上传文件大小
		onUploadStart:null,//上传开始时的动作
		onUploadSuccess:null,//上传成功的动作
		onUploadComplete:null,//上传完成的动作
		onUploadError:null, //上传失败的动作
		onInit:null,//初始化时的动作
		onCancel:null,//删除掉某个文件后的回调函数，可传入参数file
		onSelect:null//选择文件后执行的动作，可传入参数files，文件列表
		
	}

	var option = $.extend(defaults,opts);	
	
	//将文件的单位由bytes转换为KB或MB，若第二个参数指定为true，则永远转换为KB
	var formatFileSize = function(size,byKB){
		if (size> 1024 * 1024&&!byKB){
			size = (Math.round(size * 100 / (1024 * 1024)) / 100).toString() + 'MB';
		}
		else{
			size = (Math.round(size * 100 / 1024) / 100).toString() + 'KB';
		}
		return size;
	}
	//根据文件序号获取文件
	var getFile = function(index,files){
		for(var i=0;i<files.length;i++){	   
		  if(files[i].index == index){
			  return files[i];
			}
		}
		return false;
	}
	
	//将输入的文件类型字符串转化为数组,原格式为*.jpg;*.png
	var getFileTypes = function(str){
		var result = [];
		var arr1 = str.split(";");
		for(var i=0,len=arr1.length;i<len;i++){
			result.push(arr1[i].split(".").pop());
		}
		return result;
	}

	var mimetypeMap = {
		zip : ['application/x-zip-compressed'],
		jpg : ['image/jpeg'],
		png : ['image/png'],
		gif : ['image/gif'],
		doc : ['application/msword'],
		xls : ['application/msexcel'],
		docx : ['application/vnd.openxmlformats-officedocument.wordprocessingml.document'],
		xlsx : ['application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'],
		ppt : ['application/vnd.ms-powerpoint '],
		pptx : ['application/vnd.openxmlformats-officedocument.presentationml.presentation'],
		mp3 : ['audio/mp3'],
		mp4 : ['video/mp4'],
		pdf : ['application/pdf']
	};

	//根据后缀名获得文件的mime类型
	var getMimetype = function(name){
		return mimetypeMap[name];
	}

	//根据配置的字符串，获得上传组件accept的值
	var getAcceptString = function(str){
		var types = getFileTypes(str);
		var result = [];
		for(var i=0,len=types.length;i<len;i++){
			var mime = getMimetype(types[i]);
			if(mime){
				result.push(mime);				
			}
		}
		return result.join(',');
	}

	//发送文件块函数
	var sendBlob = function(url,xhr,file,formdata,opertor){
	 	xhr.open(option.method, url, true);
		xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
		var fd = new FormData();
		fd.append(option.fileObjName,file);
		if(formdata){
	  	for(key in formdata){
	  		fd.append(key,formdata[key]);
	  	}
	  	
	  	if(opertor!=null && opertor!=""){
	  		fd.append("operator",opertor);
	  	}
	  }
		xhr.send(fd);
	}

	var fileObj = null;
	var  instanceNumber = 0;
	this.each(function(){
		var _this = $(this);
		//先添加上file按钮和上传列表
		instanceNumber++;
		var inputStr = '<input id="select_btn_'+instanceNumber+'" class="selectbtn" style="display:none;" type="file" name="fileselect[]"';
		inputStr += option.multi ? ' multiple' : '';
		inputStr += ' accept="';
		inputStr += getAcceptString(option.fileTypeExts);
		inputStr += '"/>';
		//按钮
		if(option.buttonTemplate != ""){
			inputStr += '<a id="file_upload_'+instanceNumber+'-button" name="uploadify-button" href="javascript:void(0)">';
			inputStr += option.buttonTemplate;
			inputStr += '</a>';
		}else{
			inputStr += '<a id="file_upload_'+instanceNumber+'-button" href="javascript:void(0)" name="uploadify-button" class="uploadify-button">';
			inputStr += option.buttonText;
			inputStr += '</a>';
		}
		
		//按钮
		_this.find("#uploadfilebutton").first().append(inputStr);
		

		//创建文件对象
	  fileObj = {
		  fileCount:0,  //文件个数
	      uploadAllowed: true,
		  fileInput: _this.find('.selectbtn'),				//html input type=file 
		  uploadFileList : function(){
			 return  _this.find("[name=file_upload_queue]");
		  },
		  container : _this, //上传控件的外层div引用
		  url: option.uploader,						//ajax地址
		  fileFilter: [],					//过滤后的文件数组
		  uploadOver:false, //一次上传是否真正结束，用于断点续传的情况
		  filter: function(files) {		//选择文件组的过滤方法
			  var arr = [];
			  var typeArray = getFileTypes(option.fileTypeExts);
			  if(typeArray.length>0){
				  for(var i=0,len=files.length;i<len;i++){
				  	var thisFile = files[i];
				  	if(option.fileSizeLimit != 0){
				  		//文件大小限制
				  		if(parseInt(formatFileSize(thisFile.size,true))>option.fileSizeLimit){
				  			alert('文件'+thisFile.name+'大小超出限制  20M!');
				  			continue;
				  		}
				  	}
			  		
					if($.inArray(thisFile.name.split('.').pop().toLowerCase(),typeArray)>=0 || $.inArray('*', typeArray)>=0){
							arr.push(thisFile);	
					}
					else{
						alert('文件'+thisFile.name+'类型不允许！');
						continue;
					}  	
				}	
			}
			 return arr;  	
		  },
		  queryFileInfo:function(filename,filesize){
			  var fileInfo = null;
			  var formDate = _.extend(option.formData,{"FILE_NAME":filename,"FILE_SIZE":filesize});
				 $.ajax({
					  url:option.queryfileInfoUrl,
					  type:"POST",
					  async:false,
					  data:JSON.stringify(formDate),
					  contentType:"application/json",
					  dataType:"JSON",
					  success:function(data){
						  if(data.rspCode == "success"){
							  fileInfo = data;
						  } 
					  },
					  error:function(){
						  console.log("queryFileInfo error");
					  }
				  })
				  return fileInfo  
		  },
		  //文件选择后
		  funSelect: function(files){
				for(var i=0,len=files.length;i<len;i++){
					var file = files[i];
		
					//处理模板中使用的变量
					var $html = $(option.itemTemplate.replace(/\{fileID}/g,'fileupload_'+instanceNumber+'_'+file.index).replace(/\{fileName}/g,file.name).replace(/\{fileSize}/g,formatFileSize(file.size)).replace(/\{instanceID}/g,_this.attr('id')));
					var uploadedSize = 0; //以上传文件大小
					var fileStatus = ""; //unexist，uncomplete complete
					//是否续传
					if(option.breakPoints){

						//查询文件在库里的信息
						var queryFileInfo = this.queryFileInfo(file.name,file.size);
						if(queryFileInfo == null){
							alert("获取文件信息异常");
							return;
						}
						
						
						//文件是否已经存在+上传完毕  提示是否    覆盖   取消
						if(queryFileInfo.IsExist=="T" && queryFileInfo.IsComplete=="T"){
							fileStatus = "complete"; 
							$html.find('[name=continuebtn]').remove();
							$html.find('[name=uploadbtn]').remove();
						}
						//文件已经存在+未上传完毕 提示  覆盖 or 续传  取消
						else if(queryFileInfo.IsExist=="T" && queryFileInfo.IsComplete=="F"){
							fileStatus = "uncomplete";
							uploadedSize = queryFileInfo.uploadedSize;
							$html.find('[name=uploadbtn]').remove();
						}
						//文件不存在  上传  取消
						else{
							fileStatus = "unexist";
							$html.find('[name=coverbtn]').remove();
							$html.find('[name=continuebtn]').remove();
							//如果是自动上传，去掉上传按钮
							if(option.auto){
								$html.find('[name=uploadbtn]').remove();
							}
						}
					
					}
					//上传不续传
					else{
						//查询文件在库里的信息
						var queryFileInfo = this.queryFileInfo(file.name,file.size);
						if(queryFileInfo == null){
							alert("获取文件信息异常");
							return;
						}
						$html.find('[name=continuebtn]').remove();
						
						if(queryFileInfo.IsExist!="T"){
							fileStatus = "unexist"; 
							$html.find('[name=coverbtn]').remove();
							//如果是自动上传，去掉上传按钮
							if(option.auto){
								$html.find('[name=uploadbtn]').remove();
							}
						}else{
							fileStatus = "complete"; 
							$html.find('[name=uploadbtn]').remove();
							
						}
						
						
						
					}
					
					//如果开启断点续传，先初始化原来上传的文件大小
					var initWidth = 0,initFileSize = '0KB',initUppercent = '0%';
					
					if(option.breakPoints){
							
					  	//先设置进度条为原来已上传的文件大小
					  	//矫正计算误差出现的大于100%问题
					  	if(uploadedSize>=file.size){
					  		initWidth = initUppercent = '100%';
					  		initFileSize = formatFileSize(file.size);
					  	}
					  	else{
					  		initWidth = (uploadedSize / file.size * 100) + '%';
					  		initFileSize = formatFileSize(uploadedSize);
					  		initUppercent = (uploadedSize / file.size * 100).toFixed(2) + '%';
					  	}	
					}
					
					$html.find('[name=uploadify-progress-bar]').css('width',initWidth);
					fileObj.uploadFileList().append($html);
					
					//判断是否显示已上传文件大小
					if(option.showUploadedSize){
						//var num = '<span class="progressnum"><span class="uploadedsize">'+initFileSize+'</span>/<span class="totalsize">{fileSize}</span></span>'.replace(/\{fileSize}/g,formatFileSize(file.size));
						$html.find('[name=uploadedsize]').first().text(initFileSize);
						$html.find('[name=totalsize]').first().text(formatFileSize(file.size));
					}
					
					//判断是否显示上传百分比	
					if(option.showUploadedPercent){
						//var percentText = '<span class="up_percent">'+initUppercent+'</span>';
						$html.find('[name=up_percent]').first().text(initUppercent);
					}

					option.onSelect&&option.onSelect(files);
					
					if(option.breakPoints){
						// //unexist，uncomplete complete
						if(fileStatus=="unexist"){
							//判断是否是自动上传
							if(option.auto){
								this.funUploadFile(file);
							}else{
								//如果配置非自动上传，绑定上传事件
							 	$html.find('[name=uploadbtn]').on('click',(function(file){
							 			return function(){fileObj.funUploadFile(file);}
							 		})(file));
							}
						}
						else if(fileStatus=="uncomplete"){
							//绑定覆盖 = 上传
							$html.find("[name=coverbtn]").bind("click",(function(file){
					 			return function(){fileObj.funUploadFile(file,0,"cover");}
					 		})(file));
							
							//续传
							$html.find("[name=continuebtn]").bind("click",(function(file){
					 			return function(){fileObj.funUploadFile(file,uploadedSize);}
					 		})(file));
						}
						else if(fileStatus=="complete"){
							//重新上传
							$html.find("[name=coverbtn]").bind("click",(function(file){
					 			return function(){fileObj.funUploadFile(file,0,"cover");}
					 		})(file));
							
							
						}
						
						
						
					}else{
						if(fileStatus=="unexist"){
							//判断是否是自动上传
							if(option.auto){
								this.funUploadFile(file);
							}else{
								//如果配置非自动上传，绑定上传事件
							 	$html.find('[name=uploadbtn]').on('click',(function(file){
							 			return function(){fileObj.funUploadFile(file);}
							 		})(file));
							}
						}else if(fileStatus=="complete"){
							//重新上传
							$html.find("[name=coverbtn]").bind("click",(function(file){
					 			return function(){fileObj.funUploadFile(file,0,"cover");}
					 		})(file));
						}
						
					}
					
					
					
					//为删除文件按钮绑定删除文件事件
			 		$html.find('[name=delfilebtn]').on('click',(function(file){
					 			return function(){fileObj.funDeleteFile(file.index);}
					 		})(file));
			 	}

			 
			},				
		  onProgress: function(file, loaded, total) {
				var eleProgress = fileObj.uploadFileList().find('#fileupload_'+instanceNumber+'_'+file.index+' [name=uploadify-progress]');
				var progressBar = eleProgress.find('[name=uploadify-progress-bar]');
				
				if(!option.breakPoints){
					var percent = (loaded / total * 100).toFixed(2) +'%';
					var percentText = percent > 100 ? '99.99%' : percent+'%';//校正四舍五入的计算误差
					
					if(option.showUploadedSize){
						fileObj.uploadFileList().find('[name=uploadedsize]').text(formatFileSize(loaded));
						fileObj.uploadFileList().find('[name=totalsize]').text(formatFileSize(total));
					}
					if(option.showUploadedPercent){
						fileObj.uploadFileList().find('[name=up_percent]').text(percentText);
					}
					progressBar.css('width',percentText);
					return;
				}
				
				var thisLoaded = loaded;
				//已上传
				var uploadedSize = progressBar.attr("uploadedSize") || 0;
				
				//根据上一次触发progress时上传的大小，得到本次的增量
				var lastLoaded = progressBar.attr('lastLoaded') || 0;
				loaded -= parseInt(lastLoaded);
				
				progressBar.attr("uploadedSize",parseInt(uploadedSize)+loaded);
				
				var oldWidth = option.breakPoints ? parseFloat(progressBar.get(0)==null?0:progressBar.get(0).style.width || 0) : 0;
				var percent = (loaded / total * 100 + oldWidth).toFixed(2);

				var percentText = percent > 100 ? '99.99%' : percent+'%';//校正四舍五入的计算误差
				if(option.showUploadedSize){
					fileObj.uploadFileList().find('[name=uploadedsize]').text(formatFileSize(progressBar.attr("uploadedSize")));
					fileObj.uploadFileList().find('[name=totalsize]').text(formatFileSize(total));
					/*eleProgress.nextAll('.progressnum .uploadedsize').text(formatFileSize(loaded));
					eleProgress.nextAll('.progressnum .totalsize').text(formatFileSize(total));*/
				}
				if(option.showUploadedPercent){
					//eleProgress.nextAll('.up_percent').text(percentText);	
					fileObj.uploadFileList().find('[name=up_percent]').text(percentText);
				}

				progressBar.css('width',percentText);

				//记录本次触发progress时已上传的大小，用来计算下次需增加的数量
				if(thisLoaded<option.fileSplitSize){
					progressBar.attr('lastLoaded',thisLoaded);
				}
				else{
					progressBar.removeAttr('lastLoaded');	
				}
				

	  	},		//文件上传进度

		  /* 开发参数和内置方法分界线 */

		  //获取当前进度条的宽度，返回字符串如90%
		  funGetProgressWidth: function(index){
		  	var eleProgressBar = _this.find('#fileupload_'+instanceNumber+'_'+index+' .uploadify-progress-bar');
		  	return eleProgressBar.get(0).style.width || '';
		  },

		  //获取已上传的文件片大小，当开启断点续传模式
		  funGetUploadedSize: function(file){
		  	if(option.getUploadedSize){
		  		return option.getUploadedSize(file);
		  	}
		  	else{
		  		if(option.saveInfoLocal){
		  			return parseInt(localStorage.getItem(file.name)) || 0;	
		  		}
		  	}
		  },

		  funSaveUploadedSize: function(file,value){
		  	if(option.saveUploadedSize){
		  		option.saveUploadedSize(file,value);
		  	}
		  	else{
		  		if(option.saveInfoLocal){
		  			localStorage.setItem(file.name,value);		
		  		}
		  	}
		  },
		  
		  //获取选择文件，file控件
		  funGetFiles: function(e) {	  
			  // 获取文件列表对象
			  var files = e.target.files;
			  //过滤添加文件
			  files = this.filter(files);
			  var arr = [];
			  //队列中文件正在上传
			  for(var i=0; i<files.length ;i++ ){
				 var isExistQueue = false;
				 
				 //文件名判断是否在队列中
				 var queueItem = fileObj.uploadFileList().find('[name=uploadify-queue-item]');
				 for(var j = 0; j<queueItem.length;j++){
					var queueFileName = $.trim($(queueItem[j]).find("[name=up_filename]").first().text());
					if(files[i].name==queueFileName){
						alert(files[i].name+"正在上传队列中");
						isExistQueue = true;
						break;
					}
				 }
				 if(!isExistQueue){
					 arr.push(files[i]);
				 }
			  }
			  
			  for(var i=0,len=arr.length;i<len;i++){
			  	this.fileFilter.push(arr[i]);	
			  }
			  
			  this.funDealFiles(arr);
			  return this;
		  },
		  
		  //选中文件的处理与回调
		  funDealFiles: function(files) {
			  //var fileCount = uploadFileList.find('[name=uploadify-queue-item]').length;//队列中已经有的文件个数  
			  for(var i=0,len=files.length;i<len;i++){ 
				  files[i].index = ++this.fileCount;
				  files[i].id = 'fileupload_'+instanceNumber+'_'+files[i].index;
				  }
			  //执行选择回调
			  this.funSelect(files);
			  
			  return this;
		  },
		  
		  //删除对应的文件
		  funDeleteFile: function(index) {
			  for (var i = 0,len=this.fileFilter.length; i<len; i++) {
					  var file = this.fileFilter[i];
					  if (file.index == index) {
					  	if(option.breakPoints){
					  		this.uploadAllowed = false;
					  	}
						  this.fileFilter.splice(i,1);
						  fileObj.uploadFileList().find('#fileupload_'+instanceNumber+'_'+index).remove();
						  fileObj.fileInput.val('');
						  option.onCancel&&option.onCancel(file);	
						  break;
					  }
			  }
			  return this;
		  },
		  
		  //文件上传
		  funUploadFile: function(file,uploadedSizeParam,operator) {
			  var xhr = false;
			  var originalFile = file;//保存原始为切割的文件
			  var thisfile = fileObj.uploadFileList().find('#fileupload_'+instanceNumber+'_'+file.index);
			  //清除按钮
			  	$(thisfile).find("[name=coverbtn]").remove(); 
				$(thisfile).find("[name=continuebtn]").remove(); 
				$(thisfile).find("[name=uploadbtn]").remove(); 
			  
			  var regulateView = function(){
			  	if(fileObj.uploadOver){
			  		thisfile.find('[name=uploadify-progress-bar]').css('width','100%');
						option.showUploadedSize&&thisfile.find('[name=uploadedsize]').text(thisfile.find('[name=totalsize]').text());
						option.showUploadedPercent&&thisfile.find('[name=up_percent]').text('100%');
						
						//所有按钮清除
						$(thisfile).find("[name=coverbtn]").remove(); 
						$(thisfile).find("[name=continuebtn]").remove(); 
						$(thisfile).find("[name=uploadbtn]").remove(); 
						$(thisfile).find("[name=delfilebtn]").remove(); 
			  	}
			  }//校正进度条和上传比例的误差
			  
			  var failView = function(errormsg){
				  fileObj.fileInput.val('');
				  thisfile.find('[name=uploadify-progress-bar]').css('width','0%');
				  thisfile.find('[name=uploadedsize]').text(0);
				  thisfile.find('[name=up_percent]').text('0%');
				  thisfile.find('[name=error_mesg]').text(errormsg);
				  
				  //所有按钮清除
				  $(thisfile).find("[name=coverbtn]").remove(); 
				  $(thisfile).find("[name=continuebtn]").remove(); 
				  $(thisfile).find("[name=uploadbtn]").remove(); 
				  $(thisfile).find("[name=delfilebtn]").remove(); 
				  
				  setTimeout(function(){
					  fileObj.uploadFileList().find('#fileupload_'+instanceNumber+'_'+originalFile.index).remove();
				  },2000);	
			  }
			  
			  try{
				 xhr=new XMLHttpRequest();//尝试创建 XMLHttpRequest 对象，除 IE 外的浏览器都支持这个方法。
			  }catch(e){	  
				xhr=ActiveXobject("Msxml12.XMLHTTP");//使用较新版本的 IE 创建 IE 兼容的对象（Msxml2.XMLHTTP）。
			  }
			  
			  //覆盖 页面初始化
			  if(operator!=null && operator=="cover"){
				  option.showUploadedSize&&thisfile.find('[name=uploadedsize]').text(0);
				 option.showUploadedPercent&&thisfile.find('[name=up_percent]').text('0%');
				 
				 thisfile.find('[name=uploadify-progress-bar]').css('width','0%');
				 thisfile.find('[name=uploadify-progress-bar]').removeAttr("uploadedSize");
				 thisfile.find('[name=uploadify-progress-bar]').removeAttr("lastLoaded");
			  }
			  
			  if(option.breakPoints){
			  	var fileName = file.name,fileId = file.id,fileIndex = file.index, fileSize = file.size;//先保存原来的文件名称
			  	if(uploadedSizeParam == null || uploadedSizeParam ==""){
			  		uploadedSizeParam = 0;
			  	}
			  	var uploadedSize = uploadedSizeParam;  /* parseInt(this.funGetUploadedSize(originalFile));*/
			  	//如果已完全上传文件，退出函数	
			  	if(uploadedSize>=fileSize){
			  		return;
			  	}
			  	
			  	if(uploadedSizeParam >0 ){
			  		 thisfile.find('[name=uploadify-progress-bar]').attr({"uploadedSize":uploadedSizeParam});
			  	}
			  	//对文件进行切割，并保留原来的信息			  	
			  	file = originalFile.slice(uploadedSize,uploadedSize + option.fileSplitSize);
			  	file.name = fileName;file.id = fileId;file.index = fileIndex;
			  }
			  
			  var paramData = {};
			  paramData.fileName=originalFile.name;
			  paramData.totalSize = originalFile.size; //总大小
			  paramData.lastModifiedDate = originalFile.lastModifiedDate.getTime();
			  
			  $.extend(paramData,option.formData);		  
			  if (xhr.upload/* && uploadedSize !== false*/) {
				  // 上传中
				  xhr.upload.addEventListener("progress", function(e) {
					  fileObj.onProgress(file, e.loaded, originalFile.size);
				  }, false);
	  
				  // 文件上传成功或是失败
				  xhr.onreadystatechange = function(e) {
					  if (xhr.readyState == 4) {
					  	fileObj.uploadOver = true;
						  if (xhr.status == 200) {
								var returnData = xhr.responseText ? JSON.parse(xhr.responseText) : {} ;
								if(returnData.rspCode=="error"){
									//文件上传失败
									//alert("error"+returnData.rspDesc);
									failView(returnData.rspDesc)
									return;
								}
								
								
								//将文件块数据更新到本地记录
								if(option.breakPoints){
									//更新已上传文件大小，保存到本地
									uploadedSize += option.fileSplitSize;
									//fileObj.funSaveUploadedSize(originalFile,uploadedSize);	
									//继续上传其他片段
									if(uploadedSize<fileSize){
										fileObj.uploadOver = false;
										if(fileObj.uploadAllowed){
											file = originalFile.slice(uploadedSize,uploadedSize + option.fileSplitSize);
											file.name = fileName;file.id = fileId;file.index = fileIndex;file.size = fileSize;
									  	
											sendBlob(fileObj.url,xhr,file,paramData,"");	
										}
									}
									else{
										regulateView();
									}
								}
								else{
									regulateView();
								}
									
								if(fileObj.uploadOver){
									option.onUploadSuccess&&option.onUploadSuccess(originalFile, xhr.responseText);
								  //在指定的间隔时间后删掉进度条
								  setTimeout(function(){
									  fileObj.uploadFileList().find('#fileupload_'+instanceNumber+'_'+originalFile.index).remove();
								  },option.removeTimeout);	
								}
							  
						  } else {
							  failView("服务异常");
							  //失败
							  fileObj.uploadOver&&option.onUploadError&&option.onUploadError(originalFile, xhr.responseText);		
						  }

						  if (fileObj.uploadOver) {
						  	option.onUploadComplete&&option.onUploadComplete(originalFile,xhr.responseText);
							  //清除文件选择框中的已有值
							  fileObj.fileInput.val('');	
						  };
						  
					  }
				  };
	  
	  			option.onUploadStart&&option.onUploadStart();	
				  // 开始上传

				  fileObj.uploadAllowed = true;//重置允许上传为true

				  sendBlob(this.url,xhr,file,paramData,operator);
			  }	
		  },
		  
		  init: function() {	  
			  //文件选择控件选择
			  if (this.fileInput.length>0) {
				  this.fileInput.change(function(e) { 
				  	fileObj.funGetFiles(e); 
				  });	
			  }
			  
			  //点击上传按钮时触发file的click事件
			  _this.find('[name=uploadify-button]').on('click',function(){
				  _this.find('.selectbtn').trigger('click');
				});
			  
			  option.onInit&&option.onInit();
		  }
  	};
		//初始化文件对象
		fileObj.init();

	}); 

	var returnObj =  {
		stop : function(){
  		fileObj.uploadOver = false;
			fileObj.uploadAllowed = false;
		},
		upload : function(fileIndex){
			if(fileIndex === '*'){
				for(var i=0,len=fileObj.fileFilter.length;i<len;i++){
					fileObj.funUploadFile(fileObj.fileFilter[i]);
				}
			}
			else{
				var file = getFile(fileIndex,fileObj.fileFilter);
				file && fileObj.funUploadFile(file);	
			}
		},
		cancel : function(fileIndex){
			if(fileIndex === '*'){
				for(var i=0,len=fileObj.fileFilter.length;i<len;i++){
					fileObj.funDeleteFile(++i);
				}
			}
			else{
				fileObj.funDeleteFile(fileIndex);	
			}
		},
		disable : function(instanceID){
			var parent = instanceID ? $('file_upload_'+instanceID+'-button') : $('body');
			parent.find('.uploadify-button').css('background-color','#888').off('click');
		},
		ennable : function(instanceID){
			//点击上传按钮时触发file的click事件
			var parent = instanceID ? $('file_upload_'+instanceID+'-button') : $('body');
		  	parent.find('.uploadify-button').css('background-color','#707070').on('click',function(){
			parent.find('.selectbtn').trigger('click');
			});
		},
		destroy : function(){
			fileObj.container.html('');
		},
		settings : function(name,value){
			if(arguments.length==1){
				return option[name];
			}
			else{
				if(name=='formData'){
					option.formData = $.extend(option.formData, value);
				}
				else{
					option[name] = value;
				}
			}
		},
		Huploadify : function(){
			var method = arguments[0];
			if(method in this){
				Array.prototype.splice.call(arguments, 0, 1);
				this[method].apply(this[method], arguments);
			}
		}
	};
	
	return returnObj;
}	

})(jQuery)