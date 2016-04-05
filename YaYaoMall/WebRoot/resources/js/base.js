/**
 * *工具包
 */
var myUtils = {
	/**
	 * 验证规则
	 */	
	userVerification:{
		catNum:/^\+?[1-9][0-9]*$/,//非零正整数
		nicename: /^[^\s]{1,10}$/,//1-10位,不包含空格。
		signature:/^[^\s]{1,15}$/,//1-15位,不包含空格.
		email:/^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+(\.[a-zA-Z]{2,3})+$/, //邮箱
		phone:/^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/, //手机
		identity:/^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/ //15位和18位身份证号码
	},
	/**
	 * 修改一行的组件
	 * clickDiv:点击的对象
	 * modalTitle:模型的标题
	 * userInfoOne:数据库实际的值
	 * userInfoOneModal:修改的值
	 * errorMessage:错误信息
	 */
	updateOne:function(clickDiv,modalTitle,userInfoOne,userInfoOneModal,errorMessage){
		$(clickDiv).click(function(){
				$("#errorInfo").text('');
	  			$('#mymodal').click();
	  			console.log(userInfoOneModal.slice(1))
	  			$('#myModalLabel').text(modalTitle);
	  			$('.modal-body').html("<input type='text' class='form-control' placeholder='"+$(userInfoOne).text()+"' id='"+userInfoOneModal.slice(1)+"'/>");
	  			$('#submit').unbind('click');
	  		$('#submit').click(function(){
	  			var uiom=$(userInfoOneModal).val();
	  			if(userInfoOne.indexOf('NiceName')>-1){
	  				if(!myUtils.userVerification.nicename.test(uiom)){
		  				$("#errorInfo").text(errorMessage);
		  				return;
		  			}
	  			}else if(userInfoOne.indexOf('Signature')>-1){
	  				if(!myUtils.userVerification.signature.test(uiom)){
		  				$("#errorInfo").text(errorMessage);
		  				return;
		  			}
  			}else if(userInfoOne.indexOf('Email')>-1){
  				if(!myUtils.userVerification.email.test(uiom)){
	  				$("#errorInfo").text(errorMessage);
	  				return;
	  			}
	  		}else if(userInfoOne.indexOf('Phone')>-1){
	  			if(!myUtils.userVerification.phone.test(uiom)){
	  				$("#errorInfo").text(errorMessage);
	  				return;
	  			}
	  		}else if(userInfoOne.indexOf('Identity')>-1){
	  			if(!myUtils.userVerification.identity.test(uiom)){
	  				$("#errorInfo").text(errorMessage);
	  				return;
	  			}
	  		}
	  		$(userInfoOne).text(uiom);
	  		$('#closeModal').click();
	  		myUtils.myToast("修改成功");
	  		});
	  		});
	},
	/**
	 * 文件上传组件
	 */
	fileUpload:function(file,imgelement){
			var file=document.querySelector(file);
		  photoExt=file.value.substr(file.value.lastIndexOf(".")).toLowerCase();//获得文件后缀名
		//判断照片格式
		  if(photoExt!='.jpg'&&photoExt!='.png'){
		     alert("请上传后缀名为jpg/png的照片!");
		      return false;
		  }
		  var fileSize = 0;
		  var isIE = /msie/i.test(navigator.userAgent) && !window.opera;            
		  if (isIE && !file.files) {          
		       var filePath = file.value;            
		       var fileSystem = new ActiveXObject("Scripting.FileSystemObject");   
		       var file = fileSystem.GetFile (filePath);               
		       fileSize = file.Size;         
		  }else {  
		       fileSize = file.files[0].size;     
		  } 
		  fileSize=Math.round(fileSize/1024*100/1024)/100; //单位为MB
		  if(fileSize>=2){
		      alert("图片大小为"+fileSize+"MB，超过最大尺寸为2MB，请重新上传!");
		      return false;
		  }		  
	    	if (file.files && file.files[0])  
	    	 {
	         var reader = new FileReader(); 
	      	reader.onload = function(e){
	      		console.log(e.target.result);
	      		myUtils.myPrevToast("上传中···",function(){
	      		$(imgelement).attr("src",e.target.result);
	      		});
	    	}
	      	reader.readAsDataURL(file.files[0]);
		  console.log(file.files[0]);
	      }else{
	    	$(imgelement).attr("src",file.value);
	      }
			},
	/**
	* 自动a标签滑过透明
	*/
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
	/**
	 * 弹性滑动
	 */
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
	/**
	 * 判断是否滑动到顶部
	 */
	isScrollTop:function(){
			var isscrolltop=false;
			var scrollTop = $(window).scrollTop();
			if(scrollTop == 0){
				isscrolltop=true;
			}
			return isscrolltop;
	},
	/**
	 * 判断是否滑动到底部
	 */
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
	/**
	 * 实现事件执行前的toast
	 */
	myPrevToast : function(value, fn) {
		$("body")
				.append(
						"<div id='toast' style='display:none;color:#fff;background-color:black;text-align:center;line-height:30px;border:1px solid black;border-radius:5px;height:30px;width:100px;margin:-15px -50px;top:50%;left:50%;position:fixed;'>"
								+ value + "</div>");
		$("#toast").fadeIn();
		setTimeout(function() {
			$("#toast").fadeOut('slow');
			$("#toast").remove();
			if(fn){
				fn();
			}
			}, 1000);
	},
	/**
	 * 实现事件执行中的toast
	 */
	myLoadingToast : function(value, fn) {
		$("body")
				.append(
						"<div id='toast' style='display:none;color:#fff;background-color:black;text-align:center;line-height:30px;border:1px solid black;border-radius:5px;height:30px;width:100px;margin:-15px -50px;top:50%;left:50%;position:fixed;'>"
						+ value + "</div>");
		$("#toast").fadeIn();
		$("#toast").fadeOut(function() {
			setTimeout(function() {
				$("#toast").remove();
				fn();
			}, 1000);
		});
	},
	/**
	 * 自定义confirm
	 */
	myConfirm : function(value,fn) {
		$("body")
		.append(
				"<div id='confirmDiv' style='position:fixed;width:100%;height:100%;background-color:#ccc;opacity:0.5;left:0;top:0;'></div><div id='confirm' style='color:#fff;background-color:black;text-align:center;line-height:30px;border:1px solid black;border-radius:5px;height:200px;width:200px;margin:-100px -100px;top:50%;left:50%;position:fixed;font-size:20px;'>"
				+ "<div class='glyphicon glyphicon-trash' style='text-align:center;width:50%;height:50%;font-size:66px;margin-top:10px;'></div><div style='position:absolute;top:100px;width:100%;text-align:center;'>"+value+"</div><div class='btn btn-primary' style='position:absolute;left:15px;bottom:15px;width:80px;' id='confirmYes'>确定</div><div class='btn btn-default' style='position:absolute;right:15px;bottom:15px;width:80px;' id='confirmNo'>取消</div></div>");
	$('#confirmYes').click(function(){
		$('#confirmDiv').remove();
		$('#confirm').remove();
		if(fn){
			fn();
		}
	});
	$('#confirmNo').click(function(){
		$('#confirmDiv').remove();
		$('#confirm').remove();
		
	});
	},
	/**
	 * 自定义登录退出
	 */
	myLoginOut : function(value,fn) {
		$("body")
		.append(
				"<div id='confirmDiv' style='position:fixed;width:100%;height:100%;background-color:#ccc;opacity:0.5;left:0;top:0;'></div><div id='confirm' style='color:#fff;background-color:black;text-align:center;line-height:30px;border:1px solid black;border-radius:5px;height:200px;width:200px;margin:-100px -100px;top:50%;left:50%;position:fixed;font-size:20px;'>"
				+ "<div class='glyphicon glyphicon-off' style='text-align:center;width:50%;height:50%;font-size:66px;margin-top:10px;'></div><div style='position:absolute;top:100px;width:100%;text-align:center;'>"+value+"</div><div class='btn btn-primary' style='position:absolute;left:15px;bottom:15px;width:80px;' id='confirmYes'>确定</div><div class='btn btn-default' style='position:absolute;right:15px;bottom:15px;width:80px;' id='confirmNo'>取消</div></div>");
		$('#confirmYes').click(function(){
			$('#confirmDiv').remove();
			$('#confirm').remove();
			if(fn){
				fn();
			}
		});
		$('#confirmNo').click(function(){
			$('#confirmDiv').remove();
			$('#confirm').remove();
			
		});
	},
	/**
	 * 回到顶部按钮
	 */
	goBackTop : function() {
		$("body").append("<div id='goBackTop' style='display:none;color:#fff;background-color:black;text-align:center;border:20px solid blue;border-left-color:red;border-right-color:green;border-top-color:yellow;border-radius:50%;height:20px;width:20px;top:80%;left:88%;position:fixed;-moz-transition: -moz-transform 1s ease 0s;-webkit-transition: -webkit-transform 1s ease 0s;transition: transform 1s ease 0s;'></div>");
		$(window).on('scroll',function(){
		if(!myUtils.isScrollTop()){
			$("#goBackTop").css("display","block");
		}else{
			$("#goBackTop").css("display","none");
			$("#goBackTop").css({"-webkit-transform":"rotate(-1000deg)","-moz-transform":"rotate(-1000deg)","transform":"rotate(-1000deg)"});
		}
		});
		$("#goBackTop").on('click',function(){
			$("html,body").animate({scrollTop:0},1000);
			$("#goBackTop").css({"-webkit-transform":"rotate(1000deg)","-moz-transform":"rotate(1000deg)","transform":"rotate(1000deg)"});
			return false;
		});
	},
	/**
	 * 商品数量选定组件
	 */
	merchandiseNumber:function (mun,add,minus){
		
	//商品选购数量
		$(mun).on('change',function(){
			var munthis=$(this);
			if(myUtils.userVerification.catNum.test(munthis.val())&&(munthis.val()<=userData.merchandiseData[0].itemstock)){
				return;
			}else{
				munthis.val(1);
			}
		});
			//商品增加数量
		$(add).on('click',function(){
			var addthis=$(this);
			var numthis=addthis.prev();
			if(myUtils.userVerification.catNum.test(numthis.val())&&(numthis.val()<userData.merchandiseData[0].itemstock)){
				numthis.val(parseInt(numthis.val())+1);
				return;
			}else{
				numthis.val(1);
			}
		});
			//商品减少数量
		$(minus).on('click',function(){
			var minusthis=$(this);
			var numthis=minusthis.next();
			if(myUtils.userVerification.catNum.test(numthis.val())&&(numthis.val()<=userData.merchandiseData[0].itemstock)){
				if(numthis.val()==1){
					return;
				}
				numthis.val(parseInt(numthis.val())-1);
				return;
			}else{
				numthis.val(1);
			}
		});
	}

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
		userReceiptAddress : '添加收货地址'
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
		userReceiptAddress : '湖南长沙岳麓区晟通城'
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
				itemdiscount : 5.5,// 折扣
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
				itemdiscount : 5.6,// 折扣
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
				itemdiscount : 7.5,// 折扣
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
				itemdiscount : 3.5,// 折扣
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
