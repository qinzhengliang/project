/**
 * Created by 10115916 on 2016/7/15 0015.
 */
define(['jquery', 'underscore', 'backbone'
        ,'utility/DataService'
        , 'text!templates/home/home.html'
    ],
    function ($, _, Backbone
        , DataService
        , homeTemplate) {
        HomeView = Backbone.View.extend({
            templates: {
                "homeTemplate": _.template(homeTemplate)
            },
            initialize: function (option) {
                this.render();
                return this;
            },
            render: function () {
                this.$el.html(this.templates.homeTemplate());
            },
            events: {
                "click #btnLogout": "logout",
                "click #inspection": "inspection"
            },
            "logout":function(){
                DataService.logout(this.logoutSuccess, this.logoutFail);
            },
            "inspection":function(){
                window.location.href = "#inspection";
            },
            "logoutSuccess":function(data){
                alert("sucess:" + JSON.stringify(data));
                window.location.href = "#login";
            },
            "logoutFail":function(err){
                alert("fail:" + JSON.stringify(err));
            }
        });
        return HomeView;
    });
