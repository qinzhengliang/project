define(['jquery', 'underscore','AlmCookie'
        , 'text!templates/common/errorvalid.html'],
    function ($, _,AlmCookie
        , errorvalidTemplate) {
        /*$("#username").AlmValidate({
         required:true,
         maxlength:10
         })*/
        return (function ($) {
            $.fn.unAlmValidate = function () {
                this.each(function () {
                    $(this).unbind("blur.validate");
                    var errorvalid = $(this).next("[name=errorvalid]");
                    if (errorvalid.length > 0) {
                        $(errorvalid).remove();
                    }
                });

            };
            $.fn.AlmValidate = function (option) {
                var defaults = {
                    required: null,
                    email: null,
                    date: null,  //必须输入正确格式的日期
                    number: null, //必须输入合法的数字(负数，小数)
                    digits: null, //必须输入整数
                    maxlength: null, //最大长度
                    minlength: null,//最小长度
                    rangelength: null, //[5,10]输入长度必须介于 5 和 10 之间的字符串")(汉字算一个字符)
                    min: null,   //输入值不能小于
                    max: null, //输入值不能大于
                    rules: null,
                    maxdate:null //输入的值不能大于时间
                };

                var opt = $.extend(defaults, option || {});
                var message_zh = {
                    required: "不能为空,必填",
                    email: "格式不正确",
                    date: "格式不正确",
                    number: "请输入数字",
                    digits: "请输入正整数",
                    maxlength: "不能超过最大长度" + opt.maxlength,
                    minlength: "不能小于最小长度" + opt.minlength,
                    rangelength: opt.rangelength != null ? ("输入长度必须介于" + opt.rangelength[0] + " 和" + opt.rangelength[1] + "之间的字符串") : "", //[5,10]输入长度必须介于 5 和 10 之间的字符串")(汉字算一个字符)
                    min: "输入值不能小于" + opt.min,   //输入值不能小于
                    max: "输入值不能大于 " + opt.max, //输入值不能大于
                    maxdate:"时间不能大于 "+opt.maxdate //输入值不能大于
                };
                var message_en = {
                    required: "This field is required.",
                    email: "Please enter a valid email address.",
                    date: "Please enter a valid date.",
                    number: "Please enter a valid number.",
                    digits: "Please enter only digits.",
                    maxlength: "Please enter no more than " + opt.maxlength+" characters",
                    minlength: "Please enter at least " + opt.minlength +" characters",
                    rangelength: opt.rangelength != null ? ("Please enter a value between " + opt.rangelength[0] + " and " + opt.rangelength[1] + "characters long.") : "", //[5,10]输入长度必须介于 5 和 10 之间的字符串")(汉字算一个字符)
                    min: "Please enter a value greater than or equal to " + opt.min,   //输入值不能小于
                    max: "Please enter a value less than or equal to " + opt.max, //输入值不能大于
                    maxdate:"Please enter a value less than or equal to " + opt.maxdate
                };
                var message ={};
                if(almCookie.getItem("Language")=="en"){
                    message = $.extend({},message_en);
                }else{
                    message = $.extend({},message_zh);
                };
                var templates = {
                    "errorvalidTemplate": _.template(errorvalidTemplate)
                };
                var showError = function (obj, message) {
                    $(obj).parent().find("[name=errorvalid]").remove();
                    var errorValid = $(templates.errorvalidTemplate({"msg": message}));
                    var width = message.length * 14 + 23 + 15;
                    console.log($(errorValid).find(".text-tip-content").first().width());
                    $(errorValid).css({"width": width + "px"});
                    $(obj).after($(errorValid));
                };
                var showSuccess = function (obj) {
                    $(obj).parent().find("[name=errorvalid]").remove();
                };
                var checkRequired = function (value) {
                    if (value == null || $.trim(value).length == 0) {
                        return false;
                    }
                    return true;
                };

                var checkEmail = function (value) {
                    return /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/.test(value)

                };

                var checkDate = function (value) {
                    return !/Invalid|NaN/.test(new Date(value).toString());
                }
                var checkNumber = function (value) {
                    return /^(?:-?\d+|-?\d{1,3}(?:,\d{3})+)?(?:\.\d+)?$/.test(value);
                };

                var checkDigits = function (value) {
                    return /^\d+$/.test(value);
                };
                var checkMaxlength = function (value, len) {
                    if (value == null) {
                        value = "";
                    }
                    return $.trim(value).length <= len;

                };

                var checkMinlength = function (value, len) {
                    if (value == null) {
                        value = "";
                    }
                    return $.trim(value).length >= len;
                };

                var checkRangelength = function (value, param) {
                    if (value == null) {
                        value = "";
                    }
                    var len = $.trim(value).length;
                    return len >= param[0] && len <= param[1];
                };

                var checkMin = function (value, param) {
                    if (value == null) {
                        value = "";
                    }
                    value = $.trim(value);
                    return value >= param;
                };

                var checkMax = function (value, param) {
                    if (value == null) {
                        value = "";
                    }
                    value = $.trim(value);
                    return value <= param;
                };
                var checkMaxDate = function (value, param) {
                    if (value == null) {
                        value = "";
                    }
                    value = $.trim(value);

                    return new Date(value) <= new Date(param);
                };
                var self = this;

                this.each(function () {
                    var _this = $(this);
                    //绑定blur
                    $(this).unbind("blur.validate").bind("blur.validate", function (e) {
                        var val = $.trim($(this).val());
                        if (!isNaN(val)) {//是数字 不是数字则忽略
                            if (val.indexOf("0") > -1) {
                                $(e.currentTarget).val(parseInt($(this).val()));
                            }
                        }

                        checkValue($(this).val());
                    });

                    //校验
                    var value = $(this).val();
                    var checkValue = function (val) {
                        $.each(opt, function (key, item) {
                            if (key == "required" && item == true) {
                                if (checkRequired(val)) {
                                    showSuccess(_this);
                                } else {
                                    showError(_this, message.required);
                                    return false;
                                }
                                return;
                            }

                            if (key == "email" && item == true) {
                                if (checkEmail(val)) {
                                    showSuccess(_this);
                                } else {
                                    showError(_this, message.email);
                                    return false;
                                }
                                return;
                            }

                            if (key == "date" && item == true) {

                                if (checkDate(val)) {
                                    showSuccess(_this);
                                } else {
                                    showError(_this, message.date);
                                    return false;
                                }
                                return;
                            }


                            if (key == "number" && item == true) {
                                if (checkNumber(val)) {
                                    showSuccess(_this);
                                } else {
                                    showError(_this, message.number);
                                    return false;
                                }
                                return;
                            }

                            if (key == "digits" && item == true) {
                                if (checkDigits(val)) {
                                    showSuccess(_this);
                                } else {
                                    showError(_this, message.digits);
                                    return false;
                                }
                                return;
                            }


                            if (key == "maxlength" && item != null) {
                                if (checkMaxlength(val, item)) {
                                    showSuccess(_this);
                                } else {
                                    showError(_this, message.maxlength);
                                    return false;
                                }
                                return;

                            }

                            if (key == "minlength" && item != null) {
                                if (checkMinlength(val, item)) {
                                    showSuccess(_this);
                                } else {
                                    showError(_this, message.minlength);
                                    return false;
                                }
                                return;

                            }

                            if (key == "rangelength" && item != null) {
                                if (checkRangelength(val, item)) {
                                    showSuccess(_this);
                                } else {
                                    showError(_this, message.rangelength);
                                    return false;
                                }
                                return;
                            }

                            if (key == "min" && item != null) {
                                if (checkMin(val, item)) {
                                    showSuccess(_this);
                                } else {
                                    showError(_this, message.min);
                                    return false;
                                }
                                return;
                            }

                            if (key == "max" && item != null) {
                                if (checkMax(val, item)) {
                                    showSuccess(_this);
                                } else {
                                    showError(_this, message.max);
                                    return false;
                                }
                                return;
                            }
                            if (key == "maxdate" && item != null) {
                                if (checkMaxDate(val, item)) {
                                    showSuccess(_this);
                                } else {
                                    showError(_this, message.maxdate);
                                    return false;
                                }
                                return;
                            }

                        });
                    }

                    checkValue(value);
                });

                return {
                    unAlmValidate: function () {
                        self.each(function () {
                            $(this).unbind("blur.validate");
                        });

                    }
                }
            };

            /*	$("#xx").AlmValid({
             roles:[{
             ele:xxx,
             required:true
             url:true
             },{
             ele:xxx,
             required:true
             url:true
             }

             ]
             })*/

            $.fn.unAlmValid = function (opt) {
                this.each(function () {
                    var _this = $(this);
                    $.each(opt.rules, function (i, item) {
                        _this.find(item).unAlmValidate();
                    });
                });
            };

            $.fn.AlmValid = function (option) {
                var defaults = {
                    rules: null
                };

                var opt = $.extend(defaults, option || {});

                if (opt.rules == null || opt.rules.length == 0) {
                    return;
                }
                var self = this;
                var validateArray = new Array();
                this.each(function () {
                    var _this = $(this);
                    $.each(opt.rules, function (i, item) {
                        $.each(item, function (key, value) {
                            if (key == "ele") {
                                validateArray.push(_this.find(value).AlmValidate(item));
                            }
                        });
                    });
                });

                return {
                    unAlmValid: function () {
                        $.each(validateArray, function (i, item) {
                            item.unAlmValidate();
                        });
                    }
                }
            }

        })(jQuery);
    })
    
