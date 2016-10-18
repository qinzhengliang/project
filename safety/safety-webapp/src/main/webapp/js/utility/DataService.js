/**
 * Created by 10115916 on 2016/7/15 0015.
 */
define(['jquery','underscore','backbone'],
    function ($, _, Backbone) {
        DataService = {
            "baseUrl":"",
            "login":function(user,success,error){
                var queryModel = new Backbone.Model;
                var option = {
                    url:this.baseUrl + "api/login",
                    data:JSON.stringify(user),
                    contentType: "application/json; charset=utf-8",
                    success:success,
                    error:error
                };
                var key={};
                queryModel.fetchEx(key,option);
            },
            "logout":function(success,error){
                var queryModel = new Backbone.Model;
                var option = {
                    url:this.baseUrl + "api/login/logout",
                    success:success,
                    error:error
                };
                queryModel.fetch(option);
            }
        };
        return DataService;
    });