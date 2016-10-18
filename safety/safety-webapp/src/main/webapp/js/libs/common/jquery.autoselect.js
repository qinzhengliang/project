;(function($){
	$.fn.autoselect = function(opts){
		var defaults = {
				source:"",
				label:null,
				value:null,
				id:"id",
				searchParam:"",
				limit:50,
				FormData:{}
		};
		var option = $.extend(defaults,opts);
		this.each(function(){
			//清空数据
			$(this).val("");
			$(this).removeProp("inputid");
			var autoinstance = $(this).autoselectcomplete({
				minLength:0,
				delay: 10,
				source:function( request, response ){
					var term = request.term;
					var dataStr = $.extend({},option.FormData);
					dataStr["limit"] = option.limit;
					
					if(term==null || term == ""){
						dataStr[option.searchParam]="";
//						dataStr[option.FormData] = "";
					}
					dataStr[option.searchParam]=term;

					$.ajax({
						url:option.source,
						type:"POST",
						dataType:"JSON",
						contentType:"application/json",
						data:JSON.stringify(dataStr),
						success:function(data){
							if(data.rspCode == 'success'){
								var entity = data.entity;
								var normData = $.map( entity, function( item ){
									var labelArray = new Array();
									$.each(option.label,function(i,labelitem){
										labelArray.push(item[labelitem]);
									});
									
									return {
										"label":labelArray.join(" "),
										"value":labelArray.join(" "),
										"id":item[option.id]
									}
								});
								response( normData );
							}
							
							
							
						}
						
					})
				},
				select:function(event, ui){
					$(this).attr("inputid",ui.item.id);
					$(this).attr("name",ui.item.value);
					$(this).val(ui.item.value);
					$(this).trigger("selectevent");
					return true;
				}
			});
		});
		
	}
})(jQuery)