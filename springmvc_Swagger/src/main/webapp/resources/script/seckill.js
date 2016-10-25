//存放js交互
var seckill = {

	URL : {
		now : function(zone) {
			return '/seckill/time/now/' + zone;
		},
		exposer : function(seckillId) {
			return '/seckill/' + seckillId + '/exposer';
		},
		execution : function(seckillId, md5) {
			return '/seckill/' + seckillId + '/' + md5 + '/execution'
		}
	},

	// 手机号验证
	validatePhone : function(phone){
		if (phone && phone.length == 11 && !isNaN(phone)) {
			return true
		}
		return false;
	},

	// 秒杀逻辑
	handleSeckill : function(seckillId,node){
		node.hide().html('<button class="btn btn-primary btn-lg" id="killbtn">开始秒杀</button>');
		$.post(seckill.URL.exposer(seckillId), {}, function(result) {
			if (result && result['success']) {
				var exposer = result['data'];
				if (exposer['exposed']) {

					var md5 = exposer['md5'];
					var killUrl = seckill.URL.execution(seckillId, md5);
					$("#killbtn").one('click', function() {
						$(this).addClass('disabled');
						$.post(killUrl, {}, function(result) {
							if (result && result['success']) {
								var killResult = result['data'];
								var state = killResult['state']
								var stateInfo = killResult['stateInfo']
								node.html('<span class="label label-success">'+ stateInfo + '<span>')
							}
						});
					});

					node.show();
				} else {
					seckill.countDown(seckillId, exposer['now'], exposer['start'],
							exposer['end']);
				}
			} else {
				console.log("result:" + result);
			}
		});
	},
	countDown : function(seckillId, nowtime, startTime, endTime) {
		var seckillBox = $("#seckill_box");
		if (nowtime > endTime) {
			// 秒杀结束
			seckillBox.html('秒杀结束！');
		} else if (nowtime < startTime) {
			// 秒杀未开始
			var killTime = new Date(startTime);
			seckillBox.countdown(killTime, function(ecent) {
				// 控制时间格式
				var format = event('秒杀倒计时 ： %D天 %时 %M分 %S秒');
				seckillBoxhtml(format);
			}).on('finish.countdown', function() {
				// 秒杀开始杀
				seckill.handleSeckill(seckillId, seckillBox);
			});
		} else {
			// 秒杀开始
			seckill.handleSeckill(seckillId, seckillBox);
		}
	},

	detail : {

		init : function(params) {
			// 获取初始化数据
			var killPhone = $.cookie("killPhone");
			var seckillId = params['seckillId'];
			var endTime = params['endTime'];
			var startTime = params['startTime'];

			// 验证手机号
			if (seckill.validatePhone(killPhone)) {
				var zone = 'china';
				// 计时交互
				$.get(seckill.URL.now(zone), {}, function(result) {
					if (result && result['success']) {

						// 计时交互
						var nowTime = result['data'];
						seckill.countDown(seckillId, nowTime, startTime,
								endTime);
					} else {
						console.log('result:' + result);
					}
				});

			} else {
				// 未登陆

				var killphonemddal = $("#killphonemodal");
				// 显示弹出层
				killphonemddal.modal({
					show : true,
					backdrop : 'static',
					keyboard : false
				});

				// 绑定单击事件
				$("#killphonebtn")
						.click(
								function() {
									var inputPhone = $("#killphonekey").val();
									if (seckill.validatePhone(inputPhone)) {
										// 写入
										$.cookie("killPhone", inputPhone, {
											expires : 7,
											path : '/seckill'
										});
										// 刷新页面
										window.location.reload();
									} else {
										$("#killphonemessage")
												.hide()
												.html(
														'<lable class="label label-danger">手机号错误！</lable>')
												.show(300);
									}
								});
			}
		}
	}
};