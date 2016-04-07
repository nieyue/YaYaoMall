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
		<h1 style="margin:1px 10px;color:red;font-size:36px">雅耀公司常胜：湘绣梦结合中国梦是我们的奋斗目标</h1><br/><br/>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;12月16日上午，“寻找最美湘绣绣女”大型公益评选活动在长沙市湘绣文化广场隆重启动。本次活动由长沙市委宣传部指导，开福区委宣传部、光明日报湖南记者站和光明网联合主办，长沙市湘绣协会、开福区沙坪街道办和雅耀公司共同承办。</p>
    <p style="margin:10px 100px "><img  alt="游乐天堂" src="article/img/011_1.jpg"></p>
　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;雅耀（湖南）科技有限公司总经理常胜在发言时介绍，湘绣距今已有2100多年的悠久历史，具有独具魅力的艺术风格，湘绣以中国画基础，运用近二百种颜色的绣线和上等的丝绸等，巧妙运用一百多种针法进行制作，成为独一无二的中国刺绣流派。据考证，我国汉代出土的丝绸很丰富，但其中首推长沙马王堆出土的丝绸之物最具代表性，标示着当时的最高水平。灿烂而厚重的湘绣文化造就了其成为湖南乃至国家级的艺术名片。湘绣是湖南的骄傲，也是中国的骄傲。</p>

　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;常胜谈到，党中央和习近平总书记高度重视文化强国，高度重视文化产业化发展，提出了新丝绸之路的重大战略构想，在这个大背景下，如何进一步发掘湘绣的文化内涵和产业价值，如何将湘绣的发展融入国家战略，并搭上新丝绸之路的快车，将灿烂辉煌的湘绣梦与实现中华民族伟大复兴的中国梦相结合，是摆在面前的重要课题，也是奋斗目标。</p> 
　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;据了解，在湘绣产业蓬勃发展的背后，其实还面临产业转型升级的难题。湘绣产业规模目前还偏小，但是难题往往蕴藏着机遇，这其中规模从小到大的转变就有很大的发展空间。只要抓住机遇，湘绣产业就能做大做强。常胜希望通过此次活动让湘绣能更好造福于人民，让湘绣产业能成为重要的支柱产业。</p> 
　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;近年来，长沙湘绣产业不断推陈出新，发展势头喜人，进一步推动湘绣的产业发展，需要政府的大力支持和政策引导，也需要社会各界的支持和帮助。常胜表示，雅耀公司作为这次活动的承办方，愿意为湘绣这颗璀璨的非物质文化遗产之花开的更加灿烂作出自己的贡献。</p> 

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