/**
 * 修改原型
 */
	String.prototype.trim=function(){
		    return this.replace(/(^\s*)|(\s*$)/g,"");
		}
	
/**
 * *工具包
 */
var myUtils = {
	slice:function(obj){
		return Array.prototype.slice.call(obj);
	},
	/**
	 * 验证规则
	 */	
	userVerification:{
		catNum:/^\+?[1-9][0-9]*$/,// 非零正整数
		nicename: /^[^\s]{1,10}$/,// 1-10位,不包含空格。
		signature:/^[^\s]{1,15}$/,// 1-15位,不包含空格.
		email:/^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+(\.[a-zA-Z]{2,3})+$/, // 邮箱
		phone:/^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/, // 手机
		identity:/^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/, // 15位和18位身份证号码
		password:/^[0-9_a-zA-Z]{6,20}$/ // 数字、字母、下划线，6-20长度
	},
	/**
	 * 如果没选择店铺就404
	 * 
	 */
	sellerNotExistence:function(){
		if(myUtils.GetQueryString("sellerid")==null||myUtils.GetQueryString("sellerid")==''){
			if(location.href.indexOf("404")==-1){
				location.replace("/mall/mobile/404");
			}
		};
	},
	/**
	 * 时间戳转yyyy-MM-dd hh:mm:ss
	 * 
	 */
	timeStampToDate:function(timeStamp){
		var date = new Date(timeStamp);
		Y = date.getFullYear() + '-';
		M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
		D = date.getDate() + ' ';
		h = date.getHours() + ':';
		m = date.getMinutes() + ':';
		s = date.getSeconds(); 
	return Y+M+D+h+m+s; 
	},
	/**
	 * 时间戳转MM-dd
	 * 
	 */
	timeStampToSimpleDate:function(timeStamp){
		var date = new Date(timeStamp);
		M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
		D = date.getDate() + ' ';
	return M+D; 
	},
	/**
	 * 获取当前url的参数
	 * 
	 */
	GetQueryString: function (name)
	{
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  unescape(r[2]); return null;
	},
	/**
	 * cookie
	 * 
	 */
	// 写cookie
	setCookie:function (name,value,expires)
	{
	var exp = new Date();
	exp.setTime(exp.getTime() + expires*1000);
	document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
	},
	// 读取cookie
	getCookie:function (name)
	{
	var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
	if(arr=document.cookie.match(reg))
	return unescape(arr[2]);
	else
	return null;
	},
	// 删除cookie
	delCookie:function(name)
	{
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	var cval=myUtils.getCookie(name);
	if(cval!=null)
	document.cookie= name + "="+cval+";expires="+exp.toGMTString();
	},
	
	/**
	 * 表单验证
	 * 
	 */
	registerFormValid:function(userName,password,rePassword,validBtn,validCode){
		
		// 账号
		if(typeof userName=='object'&&userName!=null){
      	$(userName.userNameValue).on("change",function(){
      		var  userNameInfo=$(userName.userNameValue).val().trim();
			if(!userName.verification.test(userNameInfo)){
      			$(userName.userNameError).text(userName.userNameErrorValue);
      			return ;
      		}
      		$.get(userName.userNameURL,
      			{userName:userNameInfo},
      			function(data){
      				console.log(data)
      				if(data=="用户不存在"){
      					$(userName.userNameError).text("");
      				}else{
      			$(userName.userNameError).text(data);
      		}
      				
      	}
      			);
      	});
		}
      	// 密码
		if(typeof password=='object'&&password!=null){
      	$(password.userPasswordValue).on("change",function(){
      		var userPasswordInfo=$(password.userPasswordValue).val().trim();
      		if(!myUtils.userVerification.password.test(userPasswordInfo)){
      			$(password.userPasswordError).text(password.userPasswordErrorValue);
      		}else{
      			$(password.userPasswordError).text("");
      		}
      	});
		}
      	// 重复密码
		if(typeof rePassword=='object'&&rePassword!=null){
      	$(rePassword.userRePasswordValue).on("change",function(){
      		var reUserPasswordInfo=$(rePassword.userRePasswordValue).val().trim();
      		var userPasswordInfo=$(password.userPasswordValue).val().trim();
      		if(reUserPasswordInfo===userPasswordInfo){
      			$(rePassword.userRePasswordError).text("");
      		}else{
      			$(rePassword.userRePasswordError).text(rePassword.userRePasswordErrorValue);
      		}
      	});
		}
		// 请求服务器发送给邮箱验证码
      	$(validBtn).click(function(){
      		var  userNameInfo=$(userName.userNameValue).val().trim();
			if(!userName.verification.test(userNameInfo)){
      			$(validCode.userNameError).text(userName.userNameErrorValue);
      			return ;
      		}
      		$.get(validCode.userValidCodeSendURL,
      				{
      				userEmail:userNameInfo,
      				validCode:parseInt(Math.random()*9000+1000)
      				},
      				function(data){
      		if(data=="200"){
      		var timer=60;
      		var setinterval=setInterval(function(){
      		if(timer==0){
      			clearInterval(setinterval);
      			timer=60;
      			$(validBtn).text("获取验证码").removeAttr("disabled");
      		}else{
      			timer--;
      			$(validBtn).attr("disabled",true);	
      			$(validBtn).text(timer+"s重新发送")
      			
      		}
      		},1000);
      		}
      		});
      	});
		// 验证码
		if(typeof validCode=='object'&&validCode!=null){
      	$(validCode.userValidCodeValue).on("change",function(){
      		var  userNameInfo=$(userName.userNameValue).val().trim();
			if(!userName.verification.test(userNameInfo)){
      			$(validCode.userValidCodeError).text(userName.userNameErrorValue);
      			return ;
      		}
			if($(validCode.userValidCodeValue).val()==null||$(validCode.userValidCodeValue).val().trim()==""||$(validCode.userValidCodeValue).val()==undefined){
				return ;
			}
			$(validCode.userValidCodeError).text("");
      		$.get(validCode.userValidCodeCheckedURL,{
      			validCode:$(validCode.userValidCodeValue).val().trim()
      		},
      			function(data){
      				if(data=='200'){
      				$(validCode.userValidCodeError).text("");
      				}else{
      					$(validCode.userValidCodeError).text(data);
      		}
      				
      	});
      	});
		}
	},
	
	/**
	 * 修改一行的组件 clickDiv:点击的对象 modalTitle:模型的标题 userInfoOne:数据库实际的值
	 * userInfoOneModal:修改的值 errorMessage:错误信息
	 */
	updateOne:function(clickDiv,modalTitle,userInfoOne,userInfoOneModal,errorMessage){
		$(clickDiv).click(function(){
				// 判断是否能够点击
			if($(userInfoOne).text()!=userData.userInit[userInfoOne.slice(1)]){
				if(userInfoOne.indexOf("Email")>-1||userInfoOne.indexOf("Phone")>-1||userInfoOne.indexOf("Identity")>-1){
  		  		return;
  		  		}
			}
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
	  		$.post("/user/updateUserInfo",{
	  			userid:localStorage.getItem("userid"),
	  			userInfoOne:userInfoOne,
	  			changeValue:uiom
	  		},
	  		function(){
	  			$(userInfoOne).text(uiom);
	  			$('#closeModal').click();
	  			myUtils.myLoadingToast("修改成功");
	  		});	
	  		});
	  		});
	},
	/**
	 * 单文件上传组件
	 * options:输入项
	 * options.inputfile 文件元素
	 * options.ajaxObj 数组对象1，formData{key,value} 2,url 3,success 4,error
	 * options.dragFn 拖拽的对象
	 */
	fileUpload:function(options){
		if(!options&&typeof options!='object' ){
			myUtils.myLoadingToast("操作失败",null);
			return;
		}
		var file=options.inputfile.get(0);
		//console.log(file.files)
		  photoExt=file.value.substr(file.value.lastIndexOf(".")).toLowerCase();// 获得文件后缀名
		// 判断照片格式
		  if(photoExt!='.jpg'&&photoExt!='.png'){
			  myUtils.myLoadingToast("请上传后缀名为jpg/png的照片!");
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
		  fileSize=Math.round(fileSize/1024*100/1024)/100; // 单位为MB
		  if(fileSize>=20){
			  alert("图片大小为"+fileSize+"MB，超过最大尺寸为2MB，请重新上传!");
		      return false;
		  }		  
	    	if (file.files && file.files[0])  
	    	 {
	         var reader = new FileReader(); 
	      	reader.onload = function(e){
	      		if(typeof options.ajaxObj!='object'){
	      		myUtils.myLoadingToast("上传失败",null);
	      		return;
	      		}
	      		myUtils.myPrevToast("上传中",function(){
	      			var fd=new FormData();
	      			if(typeof options.ajaxObj.formData=='object'){
	      			for (var i = 0; i < options.ajaxObj.formData.length; i++) {
	      				fd.append(options.ajaxObj.formData[i].key,options.ajaxObj.formData[i].value);
					}
	      			}
			                $.ajax({
			                  url:options.ajaxObj.url,
			                  type:"POST",
			                  data:fd,
			                  enctype:'multipart/form-data',
			                  processData:false,// 告诉jQuery不要去处理发送的数据
			                  contentType:false, // 告诉jQuery不要去设置Content-Type请求头
			                  success:function(src){// 获取最新图片更新
			                	  if(typeof options.ajaxObj.success=='function'){
			                		  options.ajaxObj.success(src);
			      	      		}
			                  },
			                  error:function(){
			                	  if(typeof options.ajaxObj.error=='function'){
			                		  options.ajaxObj.error();
				      	      		}
			                    myUtils.myPrevToast("上传失败",null,"remove");
			                  }
			                });
			                },"add");
	      				
	      		if(typeof options.dragFn=='function'){
	      			options.dragFn(e);
	      		}
	    	}
	      	reader.readAsDataURL(file.files[0]);
	      }else{
	      	myUtils.myPrevToast("浏览器不支持",null,"add");
	      	setTimeout(function(){
	      	myUtils.myPrevToast("浏览器不支持",null,"remove");
	      	},1000);
	    	//$(imgelement).attr("src",file.value);
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
				// event.preventDefault();
				// console.log(event.originalEvent.touches[0].pageX);
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
					// console.log(myUtils.isScrollTop());
					$(attrValue).css("margin-top",(moveY-startY));
				}else {
					$(attrValue).unbind(myTouchEvents.touchmove);
				}
			}
			else if(moveY-startY<0&&moveY-startY>-100){
				// window.event.preventDefault();
				if(myUtils.isScrollBottom(attrValue)){
				$(attrValue).css("margin-top",(moveY-startY));
				}else{
					$(attrValue).unbind(myTouchEvents.touchmove);
				}
			}
		});
			}
		$(attrValue).on(myTouchEvents.touchend,function(event){
			// event.preventDefault();
			event.stopPropagation();
			$(attrValue).css("margin-top",0);
			// $(this).unbind(myTouchEvents.touchmove);
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
	      		// console.log((scrollTop + windowHeight ==
				// scrollHeight)||(elementHeight<=windowHeight))
	      	}
	      	return isscrollbottom;
},
	/**
	 * 实现慢事件执行的toast
	 */
	myPrevToast : function(value,fn,motion) {
		// 如果存在，remove
		if(document.querySelector("#prevToastWarp")){
			document.querySelector("#prevToastValue").innerText=value;
			if(motion=="add"){
				$("#prevToastWarp").fadeIn();
				$("#prevToastWarp").attr("display","block");
			}else if(motion=="remove"){
				setTimeout(function() {
					$("#prevToastWarp").fadeOut('slow');
					$("#prevToastWarp").attr("display","none");
					}, 1000);
			}
			if(typeof fn=='function'){
				fn();
			}
			return;
		}
		$("body")
				.append(
						"<div id='prevToastWarp' style='display:none;position:fixed;width:100%;height:100%;top:0;left:0;'><div id='prevToast' style='color:#fff;background-color:#000;text-align:center;line-height:30px;border:1px solid black;border-radius:5px;min-height:30px;width:100px;margin:-15px -50px;top:50%;left:50%;position:fixed;'><canvas id='prevloading'  height='30px' width='30px' style='display:inline-block;margin-bottom:-10px;' >您的浏览器不支持html5</canvas>"
						+"<span id='prevToastValue'>"+ value +"</span>&nbsp;&nbsp; </div></div>");
		if(typeof fn=='function'){
			fn();
		}
	},
	/**
	 * 事件快速完成的toast
	 */
	myLoadingToast : function(value, fn) {
		$("body")
				.append(
						"<div id='loadingToast' style='display:none;color:#fff;background-color:black;text-align:center;line-height:30px;border:1px solid black;border-radius:5px;min-height:30px;min-width:100px;margin:-15px -50px;top:50%;left:50%;position:fixed;'>"
						+ value + "</div>");
		$("#loadingToast").fadeIn();
		setTimeout(function() {
			$("#loadingToast").fadeOut('slow');
			$("#loadingToast").remove();
			if(typeof fn=='function'){
				fn();
			}
			}, 1000);
	},
	/**
	 * 底部加载toast
	 */
	myFootLoadingToast : function(bottom, fn,motion) {
		if(typeof bottom!='number'||isNaN(bottom)){
			bottom=0;
		}
		// 如果存在，remove
		if(document.querySelector("#footToast")){
			if(motion=="add"){
				$("#footToast").css("bottom",bottom);
				$("#footToast").fadeIn();
				$("#footToast").attr("display","block");
			}else if(motion=="remove"){
				setTimeout(function() {
					$("#footToast").fadeOut('slow');
					$("#footToast").attr("display","none");
					}, 1000);
			}
			if(typeof fn=='function'){
				fn();
			}
			return;
		}
		
		
		$("body")
				.append(
						"<div id='footToast' style='display:none;color:#fff;background-color:#ccc;text-align:center;line-height:30px;border:0px solid black;min-height:30px;width:100%;bottom:"+bottom+";left:0;position:fixed;'><canvas id='bottomloading'  height='30px' width='30px' style='display:inline-block;margin-bottom:-10px;' >您的浏览器不支持html5</canvas><span id='footToastValue'>正在努力加载中...</span></div>");
		
			if(typeof fn=='function'){
				fn();
			}
			
	},
	/**
	 * loading小图片
	 */
	loading:function (canvas,options){
	      this.canvas = canvas;
	      if(options){
	        this.loading.radius = options.radius||12;
	        this.loading.circleLineWidth = options.circleLineWidth||4;
	        this.loading.circleColor = options.circleColor||'#00db00';
	        this.loading.moveArcColor = options.moveArcColor||'#a6ffa6';
	        this.loading.__loading=options.__loading!=null?options.__loading!=true?false:true:true;
	      }else{     
	        this.loading.radius = 12;
	        this.loading.circelLineWidth = 4;
	        this.loading.circleColor = '#00db00';
	        this.loading.moveArcColor = '#a6ffa6';
	        this.loading.__loading=true;
	      }
	      
	       function show(myutil){
	        var canvas = myutil.canvas;
	        if(!canvas)return;
	        if(!canvas.getContext)return;
	        if(canvas.__loading)return;
	        canvas.__loading = myutil.loading;
	        var ctx = canvas.getContext('2d');
	        var radius = myutil.loading.radius;     
	        var me = myutil.loading;
	        var rotatorAngle = Math.PI*1.5;
	        var step = Math.PI/6;
	        canvas.loadingInterval = setInterval(function(){
	          ctx.clearRect(0,0,canvas.width,canvas.height);        
	          var lineWidth = me.circleLineWidth;
	          var center = {x:canvas.width/2 ,y:canvas.height/2};         
	          ctx.beginPath();
	          ctx.lineWidth = lineWidth;
	          ctx.strokeStyle = me.circleColor;
	          ctx.arc(center.x,center.y,radius,0,Math.PI*2);
	          ctx.closePath();
	          ctx.stroke();
	          // 在圆圈上面画小圆
	          ctx.beginPath();
	          ctx.strokeStyle = me.moveArcColor;
	          ctx.arc(center.x,center.y,radius,rotatorAngle,rotatorAngle+Math.PI*.45);
	          ctx.stroke();
	          rotatorAngle+=step;
	          
	        },66);
	      }
	    function hide(myutil){
	        var canvas=myutil.canvas;
	        canvas.__loading = false;
	        if(canvas.loadingInterval){
	          window.clearInterval(canvas.loadingInterval);
	        }
	        var ctx = canvas.getContext('2d');
	        if(ctx)ctx.clearRect(0,0,canvas.width,canvas.height);
	      }
	      if(this.loading.__loading){
	        show(this);
	      }else{
	      hide(this);
	    }
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
		if(typeof fn=='function'){
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
			if(typeof fn=='function'){
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
	merchandiseNumber:function (mun,add,minus,stock){
		
	// 商品选购数量
		$(mun).on('change',function(){
			var munthis=$(this);
			if(myUtils.userVerification.catNum.test(munthis.val())&&(munthis.val()<=stock)){
				return;
			}else{
				munthis.val(1);
			}
		});
			// 商品增加数量
		$(add).on('click',function(){
			var addthis=$(this);
			var numthis=addthis.prev();
			if(myUtils.userVerification.catNum.test(numthis.val())&&(numthis.val()<stock)){
				numthis.val(parseInt(numthis.val())+1);
				return;
			}else{
				numthis.val(1);
			}
		});
			// 商品减少数量
		$(minus).on('click',function(){
			var minusthis=$(this);
			var numthis=minusthis.next();
			if(myUtils.userVerification.catNum.test(numthis.val())&&(numthis.val()<=stock)){
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
	 * 过滤ie10以下版本
	 */
	isIE : function() {
		if (navigator.userAgent.indexOf("MSIE")>0){
			return true;
		}
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
	},
	/**
	 * 拖拽事件
	 * element 多个元素
	 */
	myDraggable:function(element,startFn,moveFn,endFn){
		myTouchEvents.initTouchEvents();
		 $(element).each(function(){
         var thiselement=this;
         var dragging = false;
         var iX, iY;
         var thiszindex= $(thiselement).css("z-index");
         $(thiselement).on(myTouchEvents.touchstart,function(e) {
        	 e.preventDefault();
             dragging = true;
             $(thiselement).css("z-index","999999999");
             e.clientX==undefined?e.clientX=e.originalEvent.targetTouches[0].pageX:e.clientX;
             e.clientY==undefined?e.clientY=e.originalEvent.targetTouches[0].pageY:e.clientY;
             iX = e.clientX - thiselement.offsetLeft;
             iY = e.clientY - thiselement.offsetTop;
             if(typeof startFn=='function'){
            	 startFn();
             }
             return false;
         });
         $(thiselement).on(myTouchEvents.touchmove,function(e) {
        	 e.preventDefault();
             if (dragging) {
             var e = e || window.event;
             e.clientX==undefined?e.clientX=e.originalEvent.targetTouches[0].pageX:e.clientX;
             e.clientY==undefined?e.clientY=e.originalEvent.targetTouches[0].pageY:e.clientY;
             var oX = e.clientX - iX;
             var oY = e.clientY - iY;
             $(thiselement).css({"left":oX + "px", "top":oY + "px"});
             if(typeof moveFn=='function'){
            	 moveFn();
             }
             return false;
             }
         });
         $(thiselement).on(myTouchEvents.touchend,function(e) {
        	 e.preventDefault();
             dragging = false;
             if(typeof endFn=='function'){
            	 endFn();
             }
             $(thiselement).css("z-index",thiszindex);
             //$(thiselement).css("position",thisposition);
         });

           });
	}

};


/**
 * 初始化
 * 
 */
// 触摸事件
myTouchEvents.initTouchEvents();
// 阻塞Loading
myUtils.myPrevToast("加载中");
// 阻塞loading圆圈
myUtils.loading(document.querySelector('#prevloading'),{radius:8,circleLineWidth:2});
// 底部加载loading
myUtils.myFootLoadingToast("55px");
// 底部加载圆圈
myUtils.loading(document.querySelector('#bottomloading'),{radius:8,circleLineWidth:2});

// 底部footer a设置sellerid
/*
 * $(".fixed-footer a").each(function(){
 * if(myUtils.GetQueryString("sellerid")!=null&&myUtils.GetQueryString("sellerid")!=''){
 * $(this).attr("href",$(this).attr("href")+"?sellerid="+myUtils.GetQueryString("sellerid")); }
 * });
 */