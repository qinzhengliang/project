(function(){
	almCookie = {
			setItem: function (name, value, expiredate) {
				if (expiredate < 0) {
                    var expire = new Date();
                    expire.setTime(expire.getTime() - 1000);
                    document.cookie = name + "=" + escape(value) + ";expires=" + expire.toUTCString();
                    return;
                }
                //默认path 根路径
                if (expiredate > 0) {
                    var expire = new Date();
                    expire.setTime(expire.getTime() + expiredate * 24 * 3600 * 1000);
                    document.cookie = name + "=" + escape(value) + ";expires=" + expire.toUTCString() + ";path=/";
                } else {
                    document.cookie = name + "=" + escape(value) + ";path=/";
                }
			},
			
			getItem:function (name) {
				if (document.cookie.length > 0) {
	                var cookieStr = document.cookie;
	                var nameidnex = cookieStr.indexOf(name);
	                if (nameidnex == -1) {
	                    return "";
	                }
	                var lastIndex = cookieStr.indexOf(";", nameidnex);
	                if (lastIndex = -1) {
	                    lastIndex = cookieStr.length;
	                }
	                ;
	                return unescape(cookieStr.substring(nameidnex + name.length + 1, lastIndex));
	            }
	            return "";
			},
			
			removeItem:function (name){
				 	var value = this.getItem(name);
		            if (value == "") {
		                return;
		            }
		            this.setItem(name, value, -1);
			},
			clear:function(){
				if (document.cookie.length > 0) {
	                var cookieStr = document.cookie;
	                var cookieArray = cookieStr.split(";");
	                for (var c in cookieArray) {
	                    var arr = cookieArray[c].split("=");
	                    this.setItem(arr[0], arr[1], -1);
	                }
	            }
			},
			showStorage:function(){
				return document.cookie;
			}
	}
})();