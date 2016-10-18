/**
 * Created by 10115916 on 2016/7/14 0014.
 */
define(['jquery', 'underscore', 'backbone'
        ,'utility/DataService'
        , 'text!templates/login/login.html'
    ],
    function ($, _, Backbone
        , DataService
        , loginTemplate) {
        LoginView = Backbone.View.extend({
            templates: {
                "loginTemplate": _.template(loginTemplate)
            },
            initialize: function (option) {
                this.render();
                return this;
            },
            render: function () {
                this.$el.html(this.templates.loginTemplate());
            },
            events: {
                "click #btnLogin": "login"
            },
            "login": function () {
                var user = {
                    "name":$('#name').val(),
                    "password":$('#password').val()
                };
                DataService.login(user,this.loginSucess,this.loginFail);
            },
            "loginSucess":function(data){
                if(data.get("status")=="S"){
                    window.location.href="#home";
                }else{
                    alert(data.get("errorMessage"));
                }
            },
            "loginFail":function(err){
                //登陆失败
                alert("error:" + JSON.stringify(err));
            }
        });
        return LoginView;
    });
