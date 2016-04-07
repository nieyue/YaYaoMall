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
		<h1 style="margin:1px 180px;color:red;font-size:36px">90后湘绣传承人 一针一线绣青春</h1><br/><br/>
		
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;湖南省湘绣研究所里，有75位90后湘绣传承人。他们毕业于湖南省工艺美术职业学院，是湖南首批专业院校培养的湘绣人才。</p>

　　<p>故事：</p>

　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;6月，7.2米湘绣《百骏图》亮相米兰世博会。对此，王参文抑制不住内心的激动：“虽然我们没有直接参与制作，但作为湘绣人，深感荣耀。十几年来，湘绣很少以这种巨幅佳作走向国际。作为年轻一代，很受鼓舞。”</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;王参文是湖南省湘绣研究所的一名绣工。1990年出生的她，在一针一线的世界里摸索了8年。一盒针、一团线、一个绣花架，是王参文工作的“老三样”。入行时只为毕业后有一份稳定的工作。上班后才发现，每天一坐就是六七个小时
。出一幅作品，要折腾很多天。颜色、构图、粗细线条……无时无刻不在纠缠着她。性格活泼的她，一度按捺不住内心的焦躁。</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;去年，一位客户订制了一件湖南湘绣博物馆馆藏的《雄狮》复制品，雄狮茂盛的毛发让她不知如何下手，她盯着作品发呆。无奈之下，她找来了纸笔，一遍遍地勾勒毛发走势。她还跑到动物园，盯着狮子左看右看，琢磨神态，观察毛发纹路。只要老师有空，就追着老师问。纠结两天后，她鼓起勇气落了第一针。
在老师的悉心指导下，终于如期交出了让客户满意的作品。如今，她已经能绣出神态各异的老虎、狮子、熊猫、鹿、狗等动物。</p>

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;越往深处学习，越感觉知识不够用。今年，王参文作为国家艺术基金创新人才外出学习，7天内走了10个博物馆。
回来后，她花了1000多元，买了大堆书，埋头学习;还坚持每天绘画，练书法。“绘画是湘绣的基本功，画笔的走势就是线条的方向。我现在的目标是做一个懂绘画、精刺绣的匠工，希望以后能成为一个艺术家。”王参文说。</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;跟王参文一同成长起来的有70多位同伴，都是80后、90后。这里有唯一的男生徐振华，有擅长绣油画的李琼，有擅长绣花卉的田蓉，还有将人物绣得出神入化的韩超等。一针一线，绣出了多彩青春。
经过几年的学习，已有56人成为助理工艺美术师，共生产出2500余件作品，有的陈列于重要场所，有的被国内外人士收藏。</p>

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1991年出生的田蓉喜欢谈谈湘绣文化。入行时，她发现，老一辈刺绣大师“要她绣可以，但要讲出内涵，就不行了”。
后来，她成了湖南湘绣博物馆的一名讲解员。一边练习刺绣，一边积累湘绣知识。</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 田蓉对现状有种紧迫感。在车间楼上，最年轻的刺绣老师也42岁了。“顶多5年，我们就要接班了。我们已经做好了准备。”</p>

　　
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