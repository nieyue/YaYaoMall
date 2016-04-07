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
		<title>所有陶瓷</title>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<meta name="Keywords" content="湘绣，收藏，艺术品，文化，陶瓷，刺绣"/>
	<link rel="stylesheet" href="css/base.css" type="text/css" />
	<link rel="stylesheet" href="css/taoci.css" type="text/css" />
    <script type="text/javascript" src="js/jquery.js" ></script>
    <script type="text/javascript" src="js/topNav_menu.js"></script>
</head>
<body>

	<!-- Header-->
	<div class="shop_hd">

		<div class="shop_hd_topNav">
			<div class="shop_hd_topNav_all">
				<div class="shop_hd_topNav_all_left"><a href="index.html"><img src="images/0.jpg" /></a></div>
				<div class="shop_hd_topNav_all_right">
					<ul class="topNav_quick_menu">
						<li><a href="cartShoppingList.html"><img src="images/1.jpg" /></a></li>
					</ul>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		
		<div class="clear"></div>
		
  <div class="shop_hd_menu">
            <!-- 普通导航菜单 -->
    <ul class="shop_hd_menu_nav">
    <li><img style="margin-top:-12px" src="images/Logo.png" border="0"></li>
				<li class="link"><a href="index.html"><img src="images/m1.jpg" border="0" /></a></li>
				<li class="link"><a href="embroideryCustom.html"><img src="images/m2.jpg" border="0" /></a></li>
				<li class="link"><a href="ceramicCustom.html"><img src="images/m3.jpg" border="0" /></a></li>
				<li class="link"><a href="embroideryBoutique.html"><img src="images/m4.jpg" border="0" /></a></li>
				<li class="link"><a href="ceramicBoutique.html"><img src="images/m5.jpg" border="0" /></a></li>
    </ul>
			<!-- 普通导航菜单 End -->
   </div>

	</div>
	<div class="clear"></div>
	<!-- Header End -->
	

<!--宽度全屏-->
    <div  class="long2"><a href="#"><img src="images/taoci1.png"  /></a></div>

<!--宽度全屏 END-->
	<div class="shop_hd_breadcrumb">
		<strong>当前位置：</strong>
		<span>
			<a href="index.html">首页</a>&nbsp;›&nbsp;
			<a href="ceramicBoutique.html">陶瓷精品</a>&nbsp;›&nbsp;
			<a href="ceramicDetails.html">所有陶瓷</a>
		</span>
	</div>
	<div class="clear"></div>
<!--陶瓷 List -->
<div  class="go1">
 <div  class="go2">
<!-- 显示菜单 -->
			<div class="sort-bar">
				<div class="bar-l"> 

		            <!-- 排序方式S -->
		            <ul class="array">
		              <li class="selected"><a title="默认排序" onclick="javascript:dropParam(['key','order'],'','array');" class="nobg" href="javascript:void(0)">默认</a></li>
		              <li><a title="点击按销量从高到低排序" onclick="javascript:replaceParam(['key','order'],['sales','desc'],'array');" href="javascript:void(0)">销量</a></li>
		              <li><a title="点击按人气从高到低排序" onclick="javascript:replaceParam(['key','order'],['click','desc'],'array');" href="javascript:void(0)">人气</a></li>
		              <li><a title="点击按信用从高到低排序" onclick="javascript:replaceParam(['key','order'],['credit','desc'],'array');" href="javascript:void(0)">信用</a></li>
		              <li><a title="点击按价格从高到低排序" onclick="javascript:replaceParam(['key','order'],['price','desc'],'array');" href="javascript:void(0)">价格</a></li>
		            </ul>
		            <!-- 排序方式E --> 
		            <!-- 价格段S -->
		            <div class="prices"> <em>¥</em>
		              <input type="text" value="" class="w30">
		              <em>-</em>
		              <input type="text" value="" class="w30">
		              <input type="submit" value="确认" id="search_by_price">
		            </div>
		            <!-- 价格段E --> 
		          </div>
			</div>
			<div class="clear"></div>
			<!-- 显示菜单 End -->
			<!-- 商品列表 -->
		
			<div class="shop_bd_list_content clearfix">
				<ul>
					<li>
						<dl>
							<dt><a href="goods.html"><img src="images/bei1.png" /></a></dt>
							<dd class="title"><a href="">湘绣卷轴软裱花开富贵牡丹办公室摆件</a></dd>
							<dd class="content"><span class="goods_jiage">RMB<em>999</em></span></dd>
							<dd class="buy"><span class="goods_chengjiao"><input type="image" src="images/gouw.gif" /></span></dd>
						</dl>
					</li>
					<li>
						<dl>
							<dt><a href="goods.html"><img src="images/bei1.png" /></a></dt>
							<dd class="title"><a href="">湘绣卷轴软裱花开富贵牡丹办公室摆件</a></dd>
							<dd class="content"><span class="goods_jiage">RMB<em>999</em></span></dd>
							<dd class="buy"><span class="goods_chengjiao"><input type="image" src="images/gouw.gif" /></span></dd>
						</dl>
					</li>
					<li>
						<dl>
							<dt><a href="goods.html"><img src="images/bei1.png" /></a></dt>
							<dd class="title"><a href="">湘绣卷轴软裱花开富贵牡丹办公室摆件</a></dd>
							<dd class="content"><span class="goods_jiage">RMB<em>999</em></span></dd>
							<dd class="buy"><span class="goods_chengjiao"><input type="image" src="images/gouw.gif" /></span></dd>
						</dl>
					</li>
					<li>
						<dl>
							<dt><a href="goods.html"><img src="images/bei1.png" /></a></dt>
							<dd class="title"><a href="">湘绣卷轴软裱花开富贵牡丹办公室摆件</a></dd>
							<dd class="content"><span class="goods_jiage">RMB<em>999</em></span></dd>
							<dd class="buy"><span class="goods_chengjiao"><input type="image" src="images/gouw.gif" /></span></dd>
						</dl>
					</li>
					<li>
						<dl>
							<dt><a href="goods.html"><img src="images/bei1.png" /></a></dt>
							<dd class="title"><a href="">湘绣卷轴软裱花开富贵牡丹办公室摆件</a></dd>
							<dd class="content"><span class="goods_jiage">RMB<em>999</em></span></dd>
							<dd class="buy"><span class="goods_chengjiao"><input type="image" src="images/gouw.gif" /></span></dd>
						</dl>
					</li>
					<li>
						<dl>
							<dt><a href="goods.html"><img src="images/bei1.png" /></a></dt>
							<dd class="title"><a href="">湘绣卷轴软裱花开富贵牡丹办公室摆件</a></dd>
							<dd class="content"><span class="goods_jiage">RMB<em>999</em></span></dd>
							<dd class="buy"><span class="goods_chengjiao"><input type="image" src="images/gouw.gif" /></span></dd>
						</dl>
					</li>
				</ul>
			</div>
			<div class="clear"></div>
			<div class="pagination"> 
				<ul><li><span>首页</span></li>
					<li><span>上一页</span></li>
					<li><span class="currentpage">1</span></li>
					<li><span>2</span></li>
					<li><span>3</span></li>
					<li><span>4</span></li>
					<li><span>5</span></li>
					<li><span>下一页</span></li>
					<li><span>末页</span></li>
				</ul> 
			</div>
			<!-- 商品列表 End -->
  </div>
</div>
<!--陶瓷 List Body End -->

<!-- Footer -->
<div class="clear"></div>
<div class="foot">
	<div class="faq">
               <dl>
                    <dt>帮助中心</dt>
                    <dd><a href="#"><span>积分兑换说明</span></a></dd>
                    <dd><a href="#"><span>积分明细</span></a></dd>
                    <dd><a href="#"><span>查看已购买商</span></a></dd>
                    <dd><a href="#"><span>我要买</span></a></dd>
                    <dd><a href="#"><span>忘记密码</span></a></dd>
                </dl>
                
                <dl>
                    <dt>店主之家</dt>
                    <dd><a href="#"><span>如何申请开店</span></a></dd>
                    <dd><a href="#"><span>商城商品推荐</span></a></dd>
                    <dd><a href="#"><span>如何发货</span></a></dd>
                    <dd><a href="#"><span>查看已售商品</span></a></dd>
                    <dd><a href="#"><span>如何管理店铺</span></a></dd>
                </dl>
                
                <dl>
                    <dt>支付方式</dt>
                    <dd><a href="#"><span>公司转账</span></a></dd>
                    <dd><a href="#"><span>邮局汇款</span></a></dd>
                    <dd><a href="#"><span>分期付款</span></a></dd>
                    <dd><a href="#"><span>在线支付</span></a></dd>
                    <dd><a href="#"><span>如何注册支付</span></a></dd>
                </dl>
                
                <dl>
                    <dt>售后服务</dt>
                    <dd><a href="#"><span>退款申请</span></a></dd>
                    <dd><a href="#"><span>返修/退换货</span></a></dd>
                    <dd><a href="#"><span>退换货流程</span></a></dd>
                    <dd><a href="#"><span>退换货政策</span></a></dd>
                    <dd><a href="#"><span>联系卖家</span></a></dd>
                </dl>
                
                <dl>
                    <dt>客服中心</dt>
                    <dd><a href="#"><span>修改收货地址</span></a></dd>
                    <dd><a href="#"><span>商品发布</span></a></dd>
                    <dd><a href="#"><span>会员修改个人</span></a></dd>
                    <dd><a href="#"><span>会员修改密码</span></a></dd>
                </dl>
                
                <dl>
                    <dt>关于我们</dt>
                    <dd><a href="#"><span>合作及洽谈</span></a></dd>
                    <dd><a href="#"><span>招聘英才</span></a></dd>
                    <dd><a href="#"><span>联系我们</span></a></dd>
                    <dd><a href="#"><span>关于Shop</span></a></dd>
                </dl>
                
                
      </div>
	  <div class="clear"></div>
       <div class="foot_link">
                <p>
                    <a href="index.html">首页</a>|
                    <a href="#">招聘英才</a>|
                    <a href="#">广告合作</a>|
                    <a href="#">关于我们</a>|
                    <a href="#">关于我们</a>
               </p>
        </div>
       <div class="foot_copy"><p>Copyright 2015 itcast Inc.,All rights reserved.</p><p style="margin:10px 0;"> <img src="images/shi.png"  /></p></div>
</div>
	<!-- Footer End -->
</body>
</html>