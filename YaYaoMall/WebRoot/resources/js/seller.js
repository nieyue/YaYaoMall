/**
 * *商家数据
 */
var sellerData={
		/**
		 * *登录退出
		 */
		sellerLoginOut:function(btn){
			$(btn).click(function(){
	    		 myUtils.myLoginOut("确定退出吗？",function(){
	       			$.get("/seller/sellerLoginOut",function(){
	       			myUtils.myLoadingToast("退出成功",function(){
	       			myUtils.delCookie("sellerloginstate");
	       			myUtils.delCookie("sellerid");
	       			myUtils.delCookie("sellerToken");
	       			location.replace("/seller/index");
	       			});
	       			});
	    	 });
	    	 });
		},
		/**
		* *自动登录
		*/
		sellerAutoLoginSession:function(obj){
			//sellerloginstate==1自动登录，==0，登录,不自动
			if(myUtils.userVerification.catNum.test(myUtils.getCookie("sellerid"))&&myUtils.getCookie("sellerloginstate")!=null&&myUtils.getCookie("sellerToken")!=null){
			$.get("/seller/sellerAutoLogin.json",
			{sellerid:myUtils.getCookie("sellerid"),sellerloginstate:myUtils.getCookie("sellerloginstate"),sellerToken:myUtils.getCookie("sellerToken")}
			,function(data){
				if(data.sellerMsg=="200"){
				sessionStorage.setItem("seller",encode64(JSON.stringify(data)));
				if(typeof obj.login=='function'){
					obj.login();//登录成功
				}
				}else {
					if(typeof obj.loginout=='function'){
						obj.loginout();//登录错误
					}
				}
			});
			}
		}
};