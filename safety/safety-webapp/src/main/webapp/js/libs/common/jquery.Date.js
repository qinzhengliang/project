;(function($) {
	$.Date = {
		formatCSTDate:function(cst,formatStr){
			if(cst == null || $.trim(cst) == ""){
				return "";
			}
			var date = new Date(cst);
			var year = date.getFullYear();
			var month = parseInt(date.getMonth())+1;
		    if(month<10){
		        month="0"+month;
		    }
		    var day = parseInt(date.getDate());
		    if(day<10){
		        day = "0"+day;
		    }
		    var hours = parseInt(date.getHours());
		    if(hours<10){
		        hours = "0"+hours;
		    }
		    var min = parseInt(date.getMinutes());
		    if(min<10){
		        min = "0"+min;
		    }
		    var sed = parseInt(date.getSeconds());
		    if(sed<10){
		        sed = "0"+sed;
		    }
		    
		    if(formatStr == null || formatStr == ""){
		    	formatStr = 'yyyy-mm-dd hh:mi:ss';
		    }
		    
		   return formatStr.replace(/yyyy/,year).replace(/mm/,month).replace(/dd/,day).replace(/hh/,hours).replace(/mi/,min).replace(/ss/,sed);

		},
		formatDate:function(millsecond,formatStr){
			if(millsecond == null || $.trim(millsecond) == ""){
				return "";
			}
			var date = new Date();
			date.setTime(millsecond);
			var year = date.getFullYear();
			var month = parseInt(date.getMonth())+1;
		    if(month<10){
		        month="0"+month;
		    }
		    var day = parseInt(date.getDate());
		    if(day<10){
		        day = "0"+day;
		    }
		    var hours = parseInt(date.getHours());
		    if(hours<10){
		        hours = "0"+hours;
		    }
		    var min = parseInt(date.getMinutes());
		    if(min<10){
		        min = "0"+min;
		    }
		    var sed = parseInt(date.getSeconds());
		    if(sed<10){
		        sed = "0"+sed;
		    }
		    
		    if(formatStr == null || formatStr == ""){
		    	formatStr = 'yyyy-mm-dd hh:mi:ss';
		    }
		    
		   return formatStr.replace(/yyyy/,year).replace(/mm/,month).replace(/dd/,day).replace(/hh/,hours).replace(/mi/,min).replace(/ss/,sed);
		
		},
		getLastDayOfMonth : function(y, m) {
			// 月的最后一天
			if (typeof y == 'undefined') {
				y = (new Date()).getFullYear();
			}
			if (typeof Mm == 'undefined') {
				Mm = (new Date()).getMonth();
			}
			var Feb = (y % 4 == 0) ? 29 : 28;
			var aM = new Array(31, Feb, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
			return aM[Mm];
		},
		getDateOfPreMonth : function(dt) {
			// 查询上个月
			if (typeof dt == 'undefined') {
				dt = (new Date());
			}

			var y = (dt.getMonth() == 0) ? (dt.getFullYear() - 1) : dt
					.getFullYear();
			var m = (dt.getMonth() == 0) ? 11 : dt.getMonth() - 1;
			var lastDay = this.getLastDayOfMonth(y, m);
			var d = (lastDay < dt.getDate()) ? lastDay : dt.getDate();
			return new Date(y,m,d);
		},
		getDateOfPreMonthString:function(dt){
			var date = this.getDateOfPreMonth(dt);
			var m = date.getMonth()+1;
			return date.getFullYear()+"-"+m+"-"+date.getDate();
		},
		//当前日期
		getDateOfNow : function(){
			var d = new Date();
			var vYear = d.getFullYear();
			var vMon = d.getMonth() + 1;
			var vDay = d.getDate(); 
			var str = vYear+"-"+(vMon<10 ? "0" + vMon : vMon)+"-"+(vDay<10 ? "0"+ vDay : vDay);
			return str;
		}
		
	}

})(jQuery)