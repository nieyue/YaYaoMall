/**
 * *工具包
 */
var myUtils = {
	// 自动a标签滑过透明
	ahover : function() {
		for (var int = 0; int < document.getElementsByTagName('a').length; int++) {
			// var divthis=document.getElementsByTagName('div')[int];
			// console.log(divthis)
			(function(int) {
				document.getElementsByTagName('a')[int].addEventListener(
						'mouseover', function aaa() {
							this.style.opacity = 0.5;
						});
				document.getElementsByTagName('a')[int].addEventListener(
						'mouseout', function aaa() {
							this.style.opacity = 1;
						});
			})(int);
		}
	},
	//弹性滑动
	elasticSlide:function(attrValue){
		var startY,moveY;
			$(attrValue).on(myTouchEvents.touchstart,function(event){
				event.stopPropagation();
				//event.preventDefault();
				//  console.log(event.originalEvent.touches[0].pageX);
	           // console.log(event.originalEvent.targetTouches);
	           // console.log(event.originalEvent.changedTouches);
				startY=event.originalEvent.targetTouches[0].pageY;
				thismove();
			});
			function thismove(){
		$(attrValue).on(myTouchEvents.touchmove,function(event){
			event.stopPropagation();
			moveY=event.originalEvent.targetTouches[0].pageY;
			event.preventDefault();
			if(moveY-startY<100&&moveY-startY>0){
				if(myUtils.isScrollTop()){
					//console.log(myUtils.isScrollTop());
					$(attrValue).css("margin-top",(moveY-startY));
				}else {
					$(attrValue).unbind(myTouchEvents.touchmove);
				}
			}
			else if(moveY-startY<0&&moveY-startY>-100){
				//window.event.preventDefault();
				if(myUtils.isScrollBottom(attrValue)){
				$(attrValue).css("margin-top",(moveY-startY));
				}else{
					$(attrValue).unbind(myTouchEvents.touchmove);
				}
			}
		});
			}
		$(attrValue).on(myTouchEvents.touchend,function(event){
			//event.preventDefault();
			event.stopPropagation();
			$(attrValue).css("margin-top",0);
			//$(this).unbind(myTouchEvents.touchmove);
		});
	},
	//判断是否滑动到顶部
	isScrollTop:function(){
			var isscrolltop=false;
			var scrollTop = $(window).scrollTop();
			if(scrollTop == 0){
				isscrolltop=true;
			}
			return isscrolltop;
	},
	//判断是否滑动到底部
	isScrollBottom:function(element){
		var isscrollbottom=false;
	      	　　var scrollTop = $(window).scrollTop();
	      	　　var scrollHeight = $(document).height();
	      	   var elementHeight = $(element).height();
	      	　　var windowHeight = $(window).height();
	      	　　if((scrollTop + windowHeight == scrollHeight)||(elementHeight<=windowHeight)){
	      		isscrollbottom=true;
	      		//console.log((scrollTop + windowHeight == scrollHeight)||(elementHeight<=windowHeight))
	      	　　}
	      	return isscrollbottom;
},
	// 实现闪现闪退的的toast
	myToast : function(value) {
		$("body")
				.append(
						"<div id='toast' style='display:none;width:100%;max-width:640px;height:30px;position:fixed;color:white;top:200px;'><div style='background-color:black;text-align:center;line-height:30px;border:1px solid black;border-radius:5px;height:30px;width:100px;margin:0 auto;'>"
						+ value + "</div></div>");
		$("#toast").fadeIn();
		setTimeout(function() {
			$("#toast").fadeOut('slow');
			$("#toast").remove();
			}, 1000);
	},
	// 实现事件执行前的toast
	myPrevToast : function(value, fn) {
		$("body")
				.append(
						"<div id='toast' style='display:none;width:100%;max-width:640px;height:30px;position:fixed;color:white;top:200px;'><div style='background-color:black;text-align:center;line-height:30px;border:1px solid black;border-radius:5px;height:30px;width:100px;margin:0 auto;'>"
								+ value + "</div></div>");
		$("#toast").fadeIn();
		setTimeout(function() {
			$("#toast").fadeOut('slow');
			$("#toast").remove();
			fn();
			}, 1000);
	},
	// 实现事件执行中的toast
	myLoadingToast : function(value, fn) {
		$("body")
				.append(
						"<div id='toast' style='display:none;width:100px;height:30px;background-color:black;color:white;margin:-50% auto;text-align:center;line-height:30px;border:1px solid black;border-radius:5px;z-index:999;'>"
								+ value + "</div>");
		$("#toast").fadeIn();
		$("#toast").fadeOut(function() {
			setTimeout(function() {
				$("#toast").remove();
				fn();
			}, 1000);
		});
	},
	// 截取文字为...
	

};
/**
 * *设置全局变量事件
 */
var myTouchEvents = {
	touchstart : "touchstart",
	touchmove : "touchmove",
	touchend : "touchend",
	/**
	 * 判断手机还是PC
	 */
	isPC : function() {
		var userAgentInfo = navigator.userAgent;
		var Agents = [ "Android", "iPhone", "SymbianOS", "Windows Phone",
				"iPad", "iPod" ];
		var flag = true;
		for (var v = 0; v < Agents.length; v++) {
			if (userAgentInfo.indexOf(Agents[v]) > 0) {
				flag = false;
				break;
			}
		}
		return flag;
	},
	/**
	 * 判断手机还是PC,更改touch为鼠标事件
	 */
	initTouchEvents : function() {
		if (this.isPC()) {
			this.touchstart = "mousedown";
			this.touchmove = "mousemove";
			this.touchend = "mouseup";

		}
	}

};

/**
 * 数据
 * 
 */
var userData = {
	// 用户数据初始化
	userInit : {
		userName : 'nieyue',
		userPassword : hex_sha1('123456'),
		userIMG : 'resources/img/preLoding.jpg',
		userNiceName : '添加昵称',
		userSignature : '把你爱好留在这里！',
		userEmail : '邮箱认证后可以用它登陆',
		userPhone : '手机号认证后可以用它登陆',
		userIdentity : '点击认证',
		userReceiptAddress : '添加收货地址',
		init : function() {
			localStorage.getItem("userName", userName);
		}

	},
	// 用户数据
	userPerson : {
		userName : 'nieyue',
		userNiceName : '聂跃',
		userPassword : hex_sha1('123456'),
		userIMG : 'http://img.mukewang.com/user/54859e4f00019f2a01000100-40-40.jpg',
		userSignature : '我是一直笑笑笑!',
		userEmail : '278076545@qq.com',
		userPhone : '15488654845',
		userIdentity : '430504194705050468',
		userReceiptAddress : '湖南长沙岳麓区晟通城',
		init : function() {
			localStorage.getItem("userName", userName);
		}
	},
	// 商品数据
	merchandiseData : [
			{
				itemid : 1,
				itemurl : 'http://weidian.com/item.html?itemID=1739996534&pc=1',
				itemname : '【包邮】 湘丰茶叶湖南安化黑茶金花茯砖茶茯砖颗粒罐装95g',
				itemstock : 20,// 库存
				itemolderprice : '69.00',// 原始价格
				itemprice : '52.00',// 价格
				itemsold : 10,// 销量
				itemcode : 'sdfsdf111',// 商品编号
				itemcates : {// 商品分类
					cateid : 1,
					catename : '黑茶',
				},
				imgs : [
						'http://wd.geilicdn.com/vshop333816149-1458877311461-2160561.jpg?w=1080&h=0',
						'http://wd.geilicdn.com/vshop333816149-1458877311929-4423713.jpg?w=1080&h=0' ]

			},
			{
				itemid : 2,
				itemurl : 'http://weidian.com/item.html?itemID=1740002761&p=2',
				itemname : '【包邮】 湘丰红茶 锡兰红茶 斯里兰卡高山茶 100g',
				itemstock : 30,// 库存
				itemolderprice : '99.00',// 原始价格
				itemprice : '52.00',// 价格
				itemsold : 15,// 销量
				itemcode : 'sdafj56',// 商品编号
				itemcates : {// 商品分类
					cateid : 2,
					catename : '红茶',
				},
				imgs : [
						'http://wd.geilicdn.com/vshop333816149-1455854586461-7295261.jpg?w=1080&h=0',
						'http://wd.geilicdn.com/vshop333816149-1455854586924-6141394.jpg?w=1080&h=0' ]

			},
			{
				itemid : 3,
				itemurl : 'http://weidian.com/item.html?itemID=1740002173&pc=1',
				itemname : '【包邮】 湖南湘丰茶叶2015年新茶红茶红颜罐装60g',
				itemstock : 50,// 库存
				itemolderprice : '79.00',// 原始价格
				itemprice : '52.00',// 价格
				itemsold : 52,// 销量
				itemcode : 'sdsf',// 商品编号
				itemcates : {// 商品分类
					cateid : 3,
					catename : '红茶',
				},
				imgs : [
						'http://wd.geilicdn.com/vshop333816149-1458809124374-7162726.jpg?w=1080&h=0',
						'http://wd.geilicdn.com/vshop333816149-1458809124543-1175562.jpg?w=1080&h=0' ]

			},
			{
				itemid : 4,
				itemurl : 'http://weidian.com/item.html?itemID=1750072037&pc=1',
				itemname : '【头采】 “惠茶” 2016头采春茶 清香型绿茶 100克',
				itemstock : 340,// 库存
				itemolderprice : '69.00',// 原始价格
				itemprice : '0.01',// 价格
				itemsold : 134,// 销量
				itemcode : 'sdafdfsj56',// 商品编号
				itemcates : {// 商品分类
					cateid : 3,
					catename : '绿茶',
				},
				imgs : [
						'http://wd.geilicdn.com/vshop333816149-1458727545439-7139065.jpg?w=1080&h=0',
						'http://wd.geilicdn.com/vshop333816149-1458727545563-1679299.jpg?w=1080&h=0' ]
			} ],

};

/**
 * 初始化
 * 
 */

myTouchEvents.initTouchEvents();
