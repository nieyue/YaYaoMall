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
	<meta name="Keywords" content="湘绣，收藏，艺术品，文化，陶瓷，刺绣"/>
	<title>收藏中心</title>
	<link rel="stylesheet" href="css/base.css" type="text/css" />
	<link rel="stylesheet" href="css/common.css" type="text/css" />
	<link rel="stylesheet" href="css/style.css" type="text/css" />
	<link rel="stylesheet" href="css/manager.css" type="text/css" />
	<link rel="stylesheet" href="css/list.css" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/img_effects.js"></script>
	 <script type="text/javascript" src="js/topNav_menu.js"></script>
	 
	<script type="text/javascript">
	$(function(){
		$(".imgid").each(function(){
			$(this).click(function(){
				$.post("loadEBMerchandise.dhtml",
						{
				loadEBMerchandiseImg:$(this).children().children().children().children(".EBMerchandise").attr("src")
						},
				function(){
				location.href="goods.html";	
						});
			});
		});
	});
	</script>

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

	<div class="shop_hd_breadcrumb">
		<strong>当前位置：</strong>
		<span>
			<a href="index.html">首页</a>&nbsp;›&nbsp;
			<a href="memberInformation.html">用户中心</a>&nbsp;›&nbsp;
			<a href="merchandiseCollection.html">收藏中心</a>
		</span>
	</div>
	<div class="clear"></div>

	<!-- Header End -->	

	<!-- 我的个人中心 -->
	<div class="shop_member_bd clearfix">
		<!-- 左边导航 -->
		<div class="shop_member_bd_left clearfix">
			
			<div class="shop_member_bd_left_pic">
				<a href="javascript:void(0);"><img src="images/avatar.png" /></a>
			</div>
			<div class="clear"></div>

			<dl>
				<dt>我的交易</dt>
				<dd><span><a href="ordersList.html">普通订单</a></span></dd>
				<dd><span><a href="customOrdersList.html">定制订单</a></span></dd>
				<dd><span><a href="merchandiseCollection.html">我的收藏</a></span></dd>
				<dd><span><a href="comment.html">普通评价</a></span></dd>
				<dd><span><a href="customComment.html">定制评价</a></span></dd>
			</dl>
			<dl>
				<dt>我的账户</dt>
				<dd><span><a href="memberInformation.html">个人资料</a></span></dd>
				<dd><span><a href="memberChangePassword.html">密码修改</a></span></dd>
				<dd><span><a href="manageConsigneeAddress.html">收货地址</a></span></dd>
			</dl>

		</div>
		<!-- 左边导航 End -->
		
		<!-- 右边购物列表 -->
		<div class="shop_member_bd_right clearfix">
			
			<div class="shop_meber_bd_good_lists clearfix">
				<div class="title"><h3>我的收藏</h3></div>
				
				<!-- 商品列表 -->
			<div class="shop_bd_list_content5 clearfix">
				<ul>
				  
					<li id="<s:property value="id" />" class="imgid">
						<dl>
							<dt><a href="goods.html"><img src="images/5.jpg" class="EBMerchandise"/></a></dt>
							<dd class="title"><a href="goods.html">湘绣订制</a></dd>
							<dd class="content">
								<span class="goods_jiage">￥<strong>999.00</strong></span>
								<span class="goods_chengjiao">最近成交5笔</span>
							</dd>
						</dl>
					</li>
				  
				</ul>
			</div>
			<div class="clear"></div>
			<div class="pagination"> 
				<ul><li><span>首页</span></li>
					<li><span>上一页</span></li>
					<li><span class="currentpage">1</span></li>
					<li><span>下一页</span></li>
					<li><span>末页</span></li>
				</ul> 
			</div>
			<!-- 商品列表 End -->

					<s:set name="conList" value="#session.conList"></s:set>
	                <s:if test="#conList==null or #conList.size==0">
						<span style="color:blue;font-size:12px;margin-left:300px;">
						还没有收藏宝贝，赶紧去寻找吧！
						</span>
			        </s:if>
			</div>
		</div>
		<!-- 右边购物列表 End -->

	</div>
	<!-- 我的个人中心 End -->

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