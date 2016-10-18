/**
 * Created by 00194550 on 2016/6/3.
 */

(function($){
    $.fn.coverLay = function(){
        this.each(function () {
            $(this).find("div.cover-lay").remove();
            var width = $(this).width();
            var height = $(this).height();
            var obj = $('<div class="cover-lay"></div>');
            obj.css({
                "width":width,
                "height":height
            });
            $(this).prepend(obj);

        });
    };

    $.fn.removeCoverLay =function(){
        this.each(function(){
            $(this).find("div.cover-lay").remove();
        });
    }
})(jQuery);

