<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,com.yayao.action.*"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%    
String path = request.getContextPath();    
// 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是 http://localhost:8080/MyApp/）:    
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";    
%> 
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>错误提示页面</title>
	<link rel="stylesheet" href="css/base.css" type="text/css" />
	<link rel="stylesheet" href="css/common.css" type="text/css" />
	<link rel="stylesheet" href="css/style.css" type="text/css" />
	<link rel="stylesheet" href="css/list.css" type="text/css" />
   
    <script type="text/javascript" src="js/jquery.js" ></script>
    <script type="text/javascript" src="js/topNav.js" ></script>
     <style type="text/css">
     ul.errorMessage {list-style-type: none;text-align:center;}
    
    </style>
<SCRIPT type="text/javascript">
	var secs = 5;//倒计时的秒数
	var URL;
	function Load(url) {
		URL = url;
		for(var i = secs; i >= 0; i--) {
			window.setTimeout('doUpdate(' +i+ ')',(secs - i)*1000);
		}
	}
	function doUpdate(num) {
		document.getElementById('ShowDiv').innerHTML = '您的账户已经在其他地方登陆成功，账户将在' + num +'秒后自动跳转到登录页面！';
		if(num == 0) {
			window.location = URL;
		}
	}
</SCRIPT>
</head ><body>
	<!-- Header-->
	<div class="shop_hd">

		<div class="shop_hd_topNav">
			<div class="shop_hd_topNav_all">

				<div class="shop_hd_topNav_all_left">
					[<a href="login.html">登录</a>][<a href="reg.html">注册</a>]</p>
				</div>
		


				<div class="shop_hd_topNav_all_right">
					<ul class="topNav_quick_menu">

						<li>
							<div class="topNav_menu">
								<a href="user.html" class="topNavHover">个人中心<i></i></a>
								<div class="topNav_menu_bd" style="display:none;" >
						            <ul>
						              <li><a title="已买到的商品" target="_top" href="order.html">已买到的商品</a></li>

						            </ul>
						        </div>
							</div>
						</li>

						<li>
							<div class="topNav_menu">
								<a href="gouwu2.html" class="topNav_menu">购物车<b>3</b>种商品<i></i></a>
							
							</div>
						</li>

						<li>
							<div class="topNav_menu">
								<a href="shoucang.html" >我的收藏<i></i></a>							</div>
						</li>

			
					</ul>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>


		<div class="shop_hd_header">
			<div class="shop_hd_header_logo"><h1 class="logo"><a href="/"><img src="images/logo.png" alt="ShopCZ" /></a><span>ShopCZ</span></h1></div>
			<div class="shop_hd_header_search">
                           <a href="/"><img src="images/ban.jpg" alt="ShopCZ" width="600" height="80" /></a>
			    
                            <div class="clear"></div>
	      </div>
		</div>
		<div class="clear"></div>

		<div class="shop_hd_menu">

            <!-- 普通导航菜单 -->
<ul class="shop_hd_menu_nav">
				<li class="link"><a href="index.html"><span>首页</span></a></li>
				<li class="link"><a href="list1.html"><span>湘绣定制</span></a></li>
				<li class="link"><a href="list2.html"><span>陶瓷定制</span></a></li>
				<li class="link"><a href="list3.html"><span>湘绣精品</span></a></li>
				<li class="link"><a href=""><span>陶瓷精品</span></a></li>
				<li class="link"><a href=""><span>相关资讯</span></a></li>
		  </ul>
			<!-- 普通导航菜单 End -->
	  </div>




	</div>
	<div class="clear"></div>
	<!-- Header End -->

	<div id="ShowDiv">
			<script type="text/javascript">
				Load("http://www.358go.com/login.html");
			</script>
		</div>
	
	<!-- Footer -->
	<div class="clear"></div>
<div style="background:#e1e1e1">
	<div class="shop_footer">
            <div class="shop_footer_link">
			                <p style="margin:10px 0;"> <img src="images/er.jpg" alt="ShopCZ" /></p>
                <p>
                    <a href="">首页</a>|
                    <a href="">招聘英才</a>|
                    <a href="">广告合作</a>|
                    <a href="">关于我们</a>|
                    <a href="">关于我们</a>
                </p>
            </div>
            <div class="shop_footer_copy">
                <p>Copyright 2015 itcast Inc.,All rights reserved.</p>
				  <p style="margin:10px 0;"> <img src="images/shi.png" alt="ShopCZ" /></p>
            </div>
      </div>
</div>

</body>
</html>