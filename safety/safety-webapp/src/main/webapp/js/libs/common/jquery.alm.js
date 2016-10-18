;(function($){
	AlmAfter = function(time,fun,self){
		return function(){
			
			if(--time == 0){
				fun.apply(self);
			}
		}
	}
	
})(jQuery)