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
	/**
	 * 验证规则
	 */	
	userVerification:{
		catNum:/^\+?[1-9][0-9]*$/,//非零正整数
		nicename: /^[^\s]{1,10}$/,//1-10位,不包含空格。
		signature:/^[^\s]{1,15}$/,//1-15位,不包含空格.
		email:/^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+(\.[a-zA-Z]{2,3})+$/, //邮箱
		phone:/^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/, //手机
		identity:/^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/, //15位和18位身份证号码
		password:/^[0-9_a-zA-Z]{6,20}$/ //数字、字母、下划线，6-20长度
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
	//写cookie
	setCookie:function (name,value,expires)
	{
	var exp = new Date();
	exp.setTime(exp.getTime() + expires*1000);
	document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
	},
	//读取cookie
	getCookie:function (name)
	{
	var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
	if(arr=document.cookie.match(reg))
	return unescape(arr[2]);
	else
	return null;
	},
	//删除cookie
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
		
		//账号
		if(userName!=null){
      	$(userName.userNameValue).on("change",function(){
      		var  userNameInfo=$(userName.userNameValue).val().trim();
			if(!userName.verification.test(userNameInfo)){
      			$(userName.userNameError).text(userName.userNameErrorValue);
      			return ;
      		}
      		$.get("user/chkUserName",
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
      	//密码
		if(password!=null){
      	$(password.userNameValue).on("change",function(){
      		var userPasswordInfo=$(password.userNameValue).val().trim();
      		if(!myUtils.userVerification.password.test(userPasswordInfo)){
      			$(password.userNameError).text(password.userNameErrorValue);
      		}else{
      			$(password.userNameError).text("");
      		}
      	});
		}
      	//重复密码
		if(rePassword!=null){
      	$(rePassword.userNameValue).on("change",function(){
      		var reUserPasswordInfo=$(rePassword.userNameValue).val().trim();
      		var userPasswordInfo=$(password.userNameValue).val().trim();
      		if(reUserPasswordInfo===userPasswordInfo){
      			$(rePassword.userNameError).text("");
      		}else{
      			$(rePassword.userNameError).text(rePassword.userNameErrorValue);
      		}
      	});
		}
		//请求服务器发送给邮箱验证码
      	$(validBtn).click(function(){
      		var  userNameInfo=$(userName.userNameValue).val().trim();
			if(!userName.verification.test(userNameInfo)){
      			$(validCode.userNameError).text(userName.userNameErrorValue);
      			return ;
      		}
      		$.get("user/validCode",
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
		//验证码
		if(validCode!=null){
      	$(validCode.userNameValue).on("change",function(){
      		var  userNameInfo=$(userName.userNameValue).val().trim();
			if(!userName.verification.test(userNameInfo)){
      			$(validCode.userNameError).text(userName.userNameErrorValue);
      			return ;
      		}
			if($(validCode.userNameValue).val()==null||$(validCode.userNameValue).val().trim()==""||$(validCode.userNameValue).val()==undefined){
				return ;
			}
			$(validCode.userNameError).text("");
      		$.get("user/chkValidCode",{
      			validCode:$(validCode.userNameValue).val().trim()
      		},
      			function(data){
      				if(data=='200'){
      				$(validCode.userNameError).text("");
      				}else{
      					$(validCode.userNameError).text(data);
      		}
      				
      	});
      	});
		}
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
				//判断是否能够点击
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
	  		$.post("user/updateUserInfo",{
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
	 * 文件上传组件
	 */
	fileUpload:function(file,imgelement){
			var file=document.querySelector(file);
		  photoExt=file.value.substr(file.value.lastIndexOf(".")).toLowerCase();//获得文件后缀名
		//判断照片格式
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
		  fileSize=Math.round(fileSize/1024*100/1024)/100; //单位为MB
		  if(fileSize>=2){
			  alert("图片大小为"+fileSize+"MB，超过最大尺寸为2MB，请重新上传!");
		      return false;
		  }		  
	    	if (file.files && file.files[0])  
	    	 {
	         var reader = new FileReader(); 
	        var fd=new FormData();
	         fd.append("userid",myUtils.getCookie("userid"));
	         fd.append("file", file.files[0]);
	      	reader.onload = function(e){
	      		//console.log(e.target.result);
	      		myUtils.myPrevToast("上传中",function(){
	      		$.ajax({
	      			url:"user/userIMGUpload",
	      			type:"POST",
	      			data:fd,
	      			enctype:'multipart/form-data',
	      			processData:false,// 告诉jQuery不要去处理发送的数据
	      			contentType:false, // 告诉jQuery不要去设置Content-Type请求头
	      			success:function(){
	      				//console.log("sdf");
	      				myUtils.myPrevToast("上传成功",null,"remove");
	      			},
	      			error:function(){
	      				myUtils.myLoadingToast("上传失败");
	      			}
	      		});
	      		$(imgelement).attr("src",e.target.result);
	      		},"add");
	      		
	    	}
	      	reader.readAsDataURL(file.files[0]);
		  //console.log(file.files[0]);
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
	 * 实现慢事件执行的toast
	 */
	myPrevToast : function(value,fn,motion) {
		//如果存在，remove
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
			if(fn){
				fn();
			}
			return;
		}
		$("body")
				.append(
						"<div id='prevToastWarp' style='display:none;position:fixed;width:100%;height:100%;top:0;left:0;'><div id='prevToast' style='color:#fff;background-color:#000;text-align:center;line-height:30px;border:1px solid black;border-radius:5px;min-height:30px;width:100px;margin:-15px -50px;top:50%;left:50%;position:fixed;'><canvas id='prevloading'  height='30px' width='30px' style='display:inline-block;margin-bottom:-10px;' >您的浏览器不支持html5</canvas>"
						+"<span id='prevToastValue'>"+ value +"</span>&nbsp;&nbsp; </div></div>");
		if(fn){
			fn();
		}
	},
	/**
	 *事件快速完成的toast
	 */
	myLoadingToast : function(value, fn) {
		$("body")
				.append(
						"<div id='loadingToast' style='display:none;color:#fff;background-color:black;text-align:center;line-height:30px;border:1px solid black;border-radius:5px;min-height:30px;width:100px;margin:-15px -50px;top:50%;left:50%;position:fixed;'>"
						+ value + "</div>");
		$("#loadingToast").fadeIn();
		setTimeout(function() {
			$("#loadingToast").fadeOut('slow');
			$("#loadingToast").remove();
			if(fn){
				fn();
			}
			}, 1000);
	},
	/**
	 *底部加载toast
	 */
	myFootLoadingToast : function(bottom, fn,motion) {
		if(bottom==null||bottom==''||bottom==undefined){
			bottom=0;
		}
		//如果存在，remove
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
			if(fn){
				fn();
			}
			return;
		}
		
		
		$("body")
				.append(
						"<div id='footToast' style='display:none;color:#fff;background-color:#ccc;text-align:center;line-height:30px;border:0px solid black;min-height:30px;width:100%;bottom:"+bottom+";left:0;position:fixed;'><canvas id='bottomloading'  height='30px' width='30px' style='display:inline-block;margin-bottom:-10px;' >您的浏览器不支持html5</canvas><span id='footToastValue'>正在努力加载中...</span></div>");
		
			if(fn){
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
	          //在圆圈上面画小圆
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
	merchandiseNumber:function (mun,add,minus,stock){
		
	//商品选购数量
		$(mun).on('change',function(){
			var munthis=$(this);
			if(myUtils.userVerification.catNum.test(munthis.val())&&(munthis.val()<=stock)){
				return;
			}else{
				munthis.val(1);
			}
		});
			//商品增加数量
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
			//商品减少数量
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
		userid:null,
		userPassword : '123456',
		userIMG : 'resources/img/preLoding.jpg',
		userNiceName : '添加昵称',
		userSignature : '把你爱好留在这里！',
		userEmail : '邮箱认证后可以用它登陆',
		userPhone : '手机号认证后可以用它登陆',
		userIdentity : '点击认证',
		userReceiptAddress : '添加收货地址'
	},
	// 用户数据
	person : function(data){
		document.querySelector("#userHref").href='user_info';
		document.querySelector("#userNiceName").innerHTML=data.userNiceName||data.userEmail||data.userPhone||userData.userInit.userName;
		document.querySelector("#userIMG").src=data.userIMG||userData.userInit.userIMG;
		document.querySelector("#userAccess").innerHTML='';
		document.querySelector("#userSignature").innerHTML=data.userSignature||userData.userInit.userSignature;
	},
	user_info:function(data){
		document.querySelector("#userInfoIMG").src=data.userIMG||userData.userInit.userIMG;
		document.querySelector("#userNiceName").innerHTML=data.userNiceName||userData.userInit.userNiceName;
		document.querySelector("#userSignature").innerHTML=data.userSignature||userData.userInit.userSignature;
		document.querySelector("#userEmail").innerHTML=data.userEmail||userData.userInit.userEmail;
		document.querySelector("#userPhone").innerHTML=data.userPhone||userData.userInit.userPhone;
		document.querySelector("#userIdentity").innerHTML=data.userIdentity||userData.userInit.userIdentity;
		document.querySelector("#userReceiptAddress").innerHTML=data.userReceiptAddress||userData.userInit.userReceiptAddress;
	},
	// 商品数据
	merchandiseIndex:function(elementid,mers){
		for ( var merid in mers) {
			var mer=mers[merid];
		   $(elementid).append(
		"<a class='list-card well' href='merchandise_details?merid="+mer.merchandiseid+"'>"+
		"<div class='itemimg'><img src='"+mer.merchandiseIMGS+"'>"+
		"<span class='goods-sold'>销量"+mer.merchandiseSold+"</span>"+
        "<span class='goods-discount'>"+parseFloat(mer.merDiscount).toFixed(1)+"折</span></div>"+
        "<div  class='iteminfo'>"+
        "<h3 class='goods-title'>"+mer.merchandiseName+"</h3>"+
        "<span class='goods-relprice'>¥"+parseFloat(mer.merchandisePrice).toFixed(2)+"</span>"+
        "<span class='goods-price'>¥"+parseFloat(mer.merchandiseOldPrice).toFixed(2)+"</span>"+
        "</div></a>");
		}
	},
	//商品数据初始化加载
	 initIndexMer:function(){
		   myUtils.myFootLoadingToast("55px",function(){
				var currentcount=1;
				if(localStorage.getItem("browseMerchandise")!=null){
					currentcount=JSON.parse(decode64(localStorage.getItem("browseMerchandise"))).length;
				}
		   $.get("merchandise/browseMerchandise.json?currentCount="+currentcount,"json",function(data){
				console.log(data);
					   
			if(data==''||data==null){
				myUtils.myFootLoadingToast("55px",null,"remove");
				myUtils.myLoadingToast("没有更多了");
				return;
			}
			   var newData=data; 
			   if(localStorage.getItem("browseMerchandise")!=null){
			  var olddata=JSON.parse(decode64(localStorage.getItem("browseMerchandise")));
		 	   newData=olddata.concat(data);
			   }
			  localStorage.setItem("browseMerchandise",encode64(JSON.stringify(newData)));
				console.log(newData)
			   userData.merchandiseIndex("#remtjsp",data);//只加载最新
				myUtils.myFootLoadingToast("55px",null,"remove");
		   });
		   
		},"add");
	   },
	//商品详情页
	merchandise_details:function(mers){
		for ( var merid in mers) {
			var mer=mers[merid];
			if(mer.merchandiseid==myUtils.GetQueryString("merid")){
			  $(".merchandise-img img").attr("src",mer.merchandiseIMGS);
			  $(".merchandise-img .goods-sold").text("销量"+mer.merchandiseSold);
			  $(".merchandise-img .goods-stock").text("库存"+mer.merchandiseStock);
			  $(".merchandise-details .merchandise-title").text(mer.merchandiseName);
			  $(".merchandise-price .merchandise-relprice").text("¥"+parseFloat(mer.merchandisePrice).toFixed(2));
			  $(".merchandise-price .merchandise-price").text("¥"+parseFloat(mer.merchandiseOldPrice).toFixed(2));
			   //初始化购物数量
		  myUtils.merchandiseNumber(".merchandise-num",".merchandise-add",".merchandise-minus",mer.merchandiseStock);
			  	}
			}
		
	}

};

/**
 * 初始化
 * 
 */

myTouchEvents.initTouchEvents();
myUtils.myPrevToast("加载中");
//loading
myUtils.loading(document.querySelector('#prevloading'),{radius:8,circleLineWidth:2});
myUtils.myFootLoadingToast("55px");
myUtils.loading(document.querySelector('#bottomloading'),{radius:8,circleLineWidth:2});
