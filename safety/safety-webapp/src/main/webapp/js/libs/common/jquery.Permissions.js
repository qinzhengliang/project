(function($){
	$.extend({
		pUserId:null,
		pUserCode:null,
		pUserName:null,
		pUserGroupNameList:null,
		isPermitted:function(permissStr){
			var _this = this;
			var isPermitted = "";
			if(_this.pUserGroupNameList == null){
				_this.heart_currentUser();
			}
			//业务管理权限最大
			if(_this.pUserGroupNameList != null && _this.pUserGroupNameList.indexOf("业务管理员") != -1){
				isPermitted = "T";
			}else{
				$.ajax({
					type: 'post',
					async:false,
					url:'api/permission/isPermitted',
					dataType:'json',
					contentType:"application/json",
					data:JSON.stringify({"permissionStr":permissStr}),
					success:function(data){
						if(data.rspCode == "success"){
							isPermitted = data.isPermitted;
						}

					},
					error:function(){

					}
				});
			}

			return isPermitted;
		},

		heart_isPermit:function(){
			$.ajax({
				type: 'post',
				async:false,
				url:'api/permission/isPermitted',
				dataType:'json',
				contentType:"application/json",
				data:JSON.stringify({"permissionStr":"test:test"}),
				success:function(data){

				},
				error:function(){

				}
			});

		},
		heart_currentUser: function () {
			var _this = this;
			this.heart_isPermit();
			$.ajax({
				type: 'post',
				async:false,
				url:'api/user/getCurrentUser',
				dataType:'json',
				contentType:"application/json",
				success:function(data){
					if(data.rspCode == "success"){
						_this.pUserId = data.entity.id;
						_this.pUserName= data.entity.userName;
						_this.pUserCode = data.entity.loginName;
						_this.pUserGroupNameList = data.entity.groupNameList;
						almLocalStorage.setItem("userId",_this.pUserId);
						almLocalStorage.setItem("userName",_this.pUserName);
						almLocalStorage.setItem("userCode",_this.pUserCode);
						almLocalStorage.setItem("groupNameList",_this.pUserGroupNameList);
					}

				}
			});
		},
		userId:function(){
			return this.currentUser("userId");
			
		},
		userCode:function(){
			return this.currentUser("userCode");
		},
		userName:function(){
			return this.currentUser("userName");
		},
		userGroupNameList:function(){
			return this.currentUser("groupNameList");
		},
		currentUser:function(user){
			var _this = this;
			var userId = "";
			var userName = "";
			var userCode = "";
			var groupNameList = null;
			if(_this.pUserId == null ||_this.pUserName==null || _this.pUserCode==null || _this.pUserGroupNameList==null){
				this.heart_isPermit();
				$.ajax({
					type: 'post',
					async:false,
					url:'api/user/getCurrentUser',
					dataType:'json',
					contentType:"application/json",
					success:function(data){
						if(data.rspCode == "success"){
							_this.pUserId = data.entity.id;
							_this.pUserName= data.entity.userName;
							_this.pUserCode = data.entity.loginName;
							_this.pUserGroupNameList = data.entity.groupNameList;
							almLocalStorage.setItem("userId",_this.pUserId);
							almLocalStorage.setItem("userName",_this.pUserName);
							almLocalStorage.setItem("userCode",_this.pUserCode);
							almLocalStorage.setItem("groupNameList",_this.pUserGroupNameList);
						}
							
					}
				});
			}
			
			
			if(user=="userId"){
				return this.pUserId;
			}
			
			if(user=="userName"){
				return this.pUserName;
			}
			
			if(user=="userCode"){
				return this.pUserCode;
			}
			if(user == "groupNameList"){
				return this.pUserGroupNameList;
			}
		}
		
	});
	
})(jQuery);