/**
 * 头部登录注册显示或者登录名显示
 */
document.getElementsByTagName("html")[0].style.display="none";
$(function(){
	$("body").append('<div id="loadingIMG" style="color:#ccc;margin:10% 35%;"><img style="width:70%;height:50%;;"src="images/load.gif"/></div>');
	//$("body").css("display","none");
	$(window).load(function(){
			$("#loadingIMG").remove();
			$("html").css("display","block");
	});

      /* 滚动显示
		$("body div.foot").hide();
        var htmlHeight= $(document).height();
        var clientHeight=$(window).height();
       var nu= parseInt(htmlHeight/clientHeight);
       $(document).on("scroll",function(){
    	   var  scrollTop=$(document).scrollTop();
    	 for (var int = 1; int < nu+1; int++) {
        if(scrollTop>=(clientHeight*(int+0.2))){  
        	//alert($(document.body).height()+"....."+$(window).height()+"....."+aaa+"..."+document.body.scrollTop)
        		$("body div.foot").show();
        }  
      }
	});*/
     
		
	
	
	$("ul.topNav_quick_menu").append("<li><a href='login.html'><img src='images/2.jpg' border='0' /></a></li>"
			+"<li><a href='reg.html'><img src='images/3.jpg' border='0' /></a></li>");
	$.get(
		    "ifLogin.dhtml",
		    function(data){
		    if(data){
		    	var da= JSON.parse(data);
		    	
		    	//alert(da.loginName);
		    $("ul.topNav_quick_menu li:eq(1),ul.topNav_quick_menu li:eq(2)").remove();
		    $("ul.topNav_quick_menu").append("<li><a href='memberInformation.html'><img src='images/user.jpg' /></a></li><span style='color:red;line-height:28px'>欢迎您，"+
		    		da.loginName+"</span><a id='memLogout' href='memLogout.dhtml' style='color:#fff;cursor: pointer;text-decoration: none;margin:0 4px;line-height: 28px;' >退出账户</a>");
		    //把session中新的用户名和密码存储在localstorage
		    if(window.localStorage){
		    	
		    var loginName=da.loginName;
		    var loginPwd=da.loginPwd;
		    var storage=window.localStorage;
		    storage.setItem("loginName",loginName);
		    storage.setItem("loginPwd",loginPwd);
		    }
		    }else{
		    //从localstorage中获取登录账号密码再登录
		    	if(window.localStorage){
		    var storage=window.localStorage;
		    var loginName=storage.getItem("loginName");
		    var loginPwd=storage.getItem("loginPwd");
		    	}
		    
		    if(loginName!=null&&loginName!=""){
		    	//alert(loginPwd);
		    	
		    $.post(
		    		"ifLogin.dhtml",
		    		{
		    			ln:loginName,
		    			lp:loginPwd
		    		},function(){
		    			window.location.href=location.href;
		    		}
		    );
		    }
		    }
		  
		    },"text");
	//删除localstorage中的登录账号密码
	$("ul.topNav_quick_menu").on("click","#memLogout",function(){
		//alert("ddd");
		if(window.localStorage){
			
		 var storage=window.localStorage;
		 storage.removeItem("loginName");
		 storage.removeItem("loginPwd");
		}
		
	});
		    
});
