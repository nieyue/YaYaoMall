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
		<h1 style="margin:1px 20px;color:red;font-size:36px">“亲情中华·汉语桥”夏令营来长沙县参观学习湘绣</h1><br/><br/>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2015年07月16日在长沙县湘绣城内，第一次来长沙的澳大利亚籍华裔袁艾嘉对湘绣很是喜欢，尤其是熊猫的刺绣，
			她边参观边用手机拍下美丽的照片红网长沙县站7月17日讯（分站记者 林畅）近距离感受中华优秀文化，体验家乡的风情。昨日，
			“亲情中华·汉语桥”夏令营在长沙县侨联的组织下来到星沙，来自美国、老挝、泰国、澳大利亚、新西兰等国家和地区的近70名湘籍华侨子弟前往湘绣城参观、学习湘绣。</p>
  <p style="margin:10px 225px "><img  alt="游乐天堂" src="article/img/004_1.jpg"></p>
　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;湘绣城的展厅内，栩栩如生的湘绣作品琳琅满目。华侨子弟们一边参观展厅内的湘绣产品，一边听解说员讲解湘绣的历史文化，还不时拿出相机拍下美照。</p>

　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;刚初中毕业的胡泽鑫是中美混血儿，出生于美国，妈妈是长沙人。虽然是第三次来长沙，可是，这是他第一次见到湘绣。“看着这些作品，觉得很漂亮，以前从来没有见过。”</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;而在一旁的袁艾嘉则表示，自己以前从电视、网络上就了解过湘绣，但也是第一次近距离观察湘绣。袁艾嘉的爸爸是常德人，妈妈是广州人，目前居住在澳大利亚。</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;“我觉得她们很厉害，绣出来的作品也很新奇，我很喜欢这些用针线绣出的熊猫、老虎，我也想学一学。”袁艾嘉高兴地说，这是她第一次来长沙，通过几天的活动，她对中华民族优秀文化和湖湘文化有了更深入的了解。</p>

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当天，孩子们还观看了湘绣老师的现场刺绣，并亲自穿针引线体验了湘绣的制作过程。</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;湘绣城总经理曾应明表示，湘绣有两千多年的历史，有丰富的文化底蕴和艺术内涵，此次华裔青少年来湘绣城参观、学习可以很好地了解中华民族文化，希望通过他们也让更多的人了解湘绣。</p>

　　
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