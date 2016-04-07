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
	<title>湘绣文渊</title>
	<link rel="stylesheet" href="css/base.css" type="text/css" />
	<link rel="stylesheet" href="css/common.css" type="text/css" />
	<link rel="stylesheet" href="css/gouwuche.css" type="text/css" />
    <script type="text/javascript" src="js/jquery.js" ></script>
    <script type="text/javascript" src="js/jquery.cookie.js" ></script>
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
	
	<div class="clear"></div>

	
	<!-- 购物车 Body -->
	<div class="shop_gwc_bd clearfix">
	
		
		<!-- 购物车有商品 -->
		<div class="shop_gwc_bd_contents clearfix">
		<div style="padding:50px">
		<h1 style="margin:1px 100px;color:red;font-size:36px">长卷湘绣《百骏图》封针 将亮相米兰世博会</h1><br/><br/>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;九名绣女一字儿排开，在一幅巨幅长卷湘绣前飞针走线，最后，在一匹用独创“立体针”绣制的白马马背上，
			中国工艺美术大师江再红用细细的桑蚕丝线添上最后一针。，长卷湘绣《百骏图》在长沙市开福湘绣研究所正式封针，并即将启程送往2015意大利米兰世博会湖南活动周展出。</p>
 <p style="margin:10px 225px "><img  alt="游乐天堂" src="article/img/007_1.jpg"></p>
　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;湘绣《百骏图》，长7.2米，宽0.9米，以意大利籍清代宫廷画师郎世宁的画作《百骏图》为蓝本，由江再红率20余名绣女历时95天操针绣制而成。在林中草地，
百匹骏马或卧或立、或嬉戏觅食，自由闲适。江再红团队使用了几百个色阶的顶级桑蚕丝线，运用平针、交叉针、游针等多种针法，并独创“立体针”新针法，来绣制姿态各异的骏马，使得整个绣品生动逼真，极富立体感。</p>
 <p style="margin:10px 225px "><img  alt="游乐天堂" src="article/img/007_2.jpg"></p>
　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 911年，湘绣曾在意大利都灵世博会上展出，并获世界进步“卓绝奖”，此次展出，可谓再续百年世博缘。随同《百骏图》一同赴展的，还有巨幅长卷湘绣《一带一路》。
记者看到，陆上丝绸之路以绣制的桑叶作底、海上丝绸之路以绣制的蓝色船帆作底，再用红色的丝带把古老的城市串起来，绣片右下角，绣制着一个商人领着一队骆驼在行进，寓意意大利商人马可·波罗把中国传统文化通过丝绸之路带到了欧洲。</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;长沙市开福湘绣研究所还提供了28件精品卷轴湘绣，作为本次湖南省代表团对外赠送的礼品，其中有一幅异面绣《国花盛开》，一面绣有中国国花牡丹，一面绣有意大利国花雏菊，将礼赠米兰世博会意大利国家馆。</p> 

　　
		</div>
	</div>
	</div>
<!-- Footer -->
<div class="clear" style="margin-top:130px"></div>
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