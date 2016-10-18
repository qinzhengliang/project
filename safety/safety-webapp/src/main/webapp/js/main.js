/**
 * Created by 10115916 on 2016/7/14 0014.
 */
//执行require配置
require.config({
    // The shim config allows us to configure dependencies for
    // scripts that do not call define() to register a module
    baseUrl : 'js',
    shim: {
        underscore: {
            deps:['jquery'],
            exports: '_'
        },
        backbone: {
            deps: [
                'underscore',
                'jquery'
            ],
            exports: 'Backbone'
        },
        Huploadify: {
            deps: [
                'jquery'
            ],
            exports: 'Huploadify'
        },
        pagination:{
            deps: [
                'jquery'
            ],
            exports: 'pagination'
        },
        jqueryui:{
            deps: [
                'jquery'
            ],
            exports: 'jqueryui'
        },
        autoselectcomplete:{
            deps: [
                'jqueryui'
            ],
            exports: 'autoselectcomplete'
        }
    },
    paths : {
        jquery : 'libs/jquery/jquery-1.12.4',
        underscore : 'libs/underscore/underscore',
        backbone : 'libs/backbone/backbone',
        text : 'libs/require/text', // 引入插件，用于引入网页模板
        Huploadify:"libs/uploadfile/jquery.Huploadify",
        pagination:'libs/pagination/jquery.pagination',
        jqueryui:'libs/jqueryui/jquery-ui',
        autoselectcomplete:'libs/jqueryui/autoselectcomplete'
    }
});

require(['router'],
    function(AppRouter) {
        var appRouter = new AppRouter;
        Backbone.history.start();
    });



