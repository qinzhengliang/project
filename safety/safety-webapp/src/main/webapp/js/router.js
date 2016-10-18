/**
 * Created by 10115916 on 2016/7/14 0014.
 */
define(['jquery', 'underscore', 'backbone'
        ,'views/login/LoginView'
        ,'views/home/HomeView'
        //, 'views/video/VideoView'
        //, 'views/inspection/InspectionListView'
        //, 'views/inspection/InspectionAddView'
        //, 'views/inspection/InspectionRectView'
        //, 'views/inspection/InspectionBaseView'
        //, 'views/inspection/InspectionCountView'
        ],
    function ($, _, Backbone
        , LoginView
        , HomeView
        //, VideoView
        //, InspectionListView
        //, InspectionAddView
        //, InspectionRectView
        //, InspectionBaseView
        //, InspectionCountView
    ) {
        AppRouter = Backbone.Router.extend({
            viewArray: [],
            menuView: null,
            routes: {
                "": "login",
                "login":"login",
                "home": "home",
                "inspection":"inspection"
            },
            "login":function(){
                this.removeViews();
                var view = null;
                view = new LoginView();
                $('#content').html(view.el);
            },
            "home": function () {
                this.removeViews();
                var view = null;
                view = new HomeView();
                $('#content').html(view.el);
            },
            "inspection":function(){
                this.removeViews();
                var view = null;
                view = new InspectionListView();
                $('#homeRight').html(view.el);
            },
            removeViews: function () {
                if (this.viewArray.length > 0) {
                    for (var v in this.viewArray) {
                        this.viewArray[v].remove();
                    }
                    this.viewArray = [];
                }
            }
        });
        return AppRouter;
    });