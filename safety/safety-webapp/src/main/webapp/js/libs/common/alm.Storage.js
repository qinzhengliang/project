(function(){
	almLocalStorage = {
	        supportLoaclStorage: function () {
	            if (window.localStorage) {
	                return true;
	            }
	            return false;
	        },
	        setItem: function (name, value, expiredate) {
	            if (this.supportLoaclStorage()) {
	            	 if(expiredate==null || expiredate==0){
	                     window.localStorage.setItem(name, value);
	                 } else {
	                    var v = null;
	                    try{
	                        v = JSON.parse(value);
	                    }catch(e){
	                        v = {"defaultname": value};
	                    }
	                    var expire = new Date();
	                    expire.setTime(expire.getTime() + expiredate * 24 * 3600 * 1000);
	                    v.expires=expire.getTime();
	                    window.localStorage.setItem(name,JSON.stringify(v));
	                    return;
	                }
	              
	            } else {
	            	almCookie.setItem(name, value, expiredate);
	            }


	        },
	        getItem: function (name) {
	            if (this.supportLoaclStorage()) {
	                var v = window.localStorage.getItem(name);
	                if(v!=null && v!=""){
	                    try{
	                        var value = JSON.parse(v);
	                       var expires = value.expires;
	                        if(expires!=null && expires!= ""){
	                           if(new Date().getTime()-expires>0){
	                               window.localStorage.removeItem(name);
	                               return "";
	                           }
	                        }

	                        if(value.defaultname==null ||value.defaultname==""){
	                            return v;
	                        }else{
	                            return value.defaultname;
	                        }
	                    }catch(e){

	                    }
	                }
	                return v;
	            }else{
	            	
	            	return almCookie.getItem(name);
	            }
	            
	        },
	        removeItem: function (name) {
	            if (this.supportLoaclStorage()) {
	                window.localStorage.removeItem(name);
	                return;
	            }
	            almCookie.removeItem(name);
	        },
	        clear: function () {
	            if (this.supportLoaclStorage()) {
	                window.localStorage.clear();
	                return;
	            }
	            almCookie.clear();
	        },
	        showStorage: function () {
	            if (this.supportLoaclStorage()) {
	                var localStorage = window.localStorage;
	                var len = localStorage.length;
	                var storyArray = new Array();
	                for (var i = 0; i < len; i++) {
	                    storyArray.push(localStorage.key(i) + "=" + localStorage.getItem(localStorage.key(i)));
	                }
	                return storyArray.join(";");
	            }
	            return almCookie.showStorage;
	        }


	    };
})();
