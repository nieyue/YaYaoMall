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
		<h1 style="margin:1px 200px;color:red;font-size:36px">湘绣夏布泥人，长沙非遗惊艳</h1><br/><br/>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;全国第十个“文化遗产日”，由湖南省文化厅主办的“多彩潇湘”—2015年“文化遗产日”湖南非物质文化遗产展演活动在韶山拉开帷幕,
 同时中国（韶山）非物质文化遗产博览园开园，展示湖南近3000件艺术品及多个优秀非物质文化遗产，博览园里长沙馆多姿多彩的非遗项目更是让人们驻足流连。省委常委、宣传部长许又声，副省长李友志等出席开幕式。</p>

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;非遗展演市民看“稀罕”。</p>

　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;开幕式中，湖南省19个获第四批国家级非物质文化遗产代表性项目的代表接受授牌。接下来的民俗文化巡游将展演活动推向高潮：一路上，龙狮队、高跷队、扎故事队、民俗表演队组成巡游队伍，唢呐声热闹非凡，吸引了大批游客驻足观看。</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作为中国第十个“文化遗产日”湖南省主会场—中国（韶山）非物质文化遗产博览园开园昨日开园，目前正式开园的一期项目主要展示湖南各市州113项非遗项目。
“湘绣”、“菊花石雕”、“醴陵釉下五彩瓷”、“蓝印花布”、“苗族银饰锻造技艺”、“黑茶制作技艺”、“铜官窑陶瓷技艺”、“韶山毛氏菜系”……来自全省14个市州的各民族、地域的近3000件（项）非遗艺术品、项目在这里展出。
博览园通过现场与互联网同步展示非遗项目、出售非遗产品，观众可以线上线下同步感受非遗文化遗产的魅力。醴陵瓷器展、湖南民间文学音乐艺术馆、湖南手工技艺馆、湖南民俗民风馆、中华国药馆、中华非遗美食馆及省外精品非遗项目将在待完工的二、三期项目中可看到。</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;长沙非遗馆人气最旺。</p>

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;湘绣、烟花、菊花石雕、长沙铜官窑陶瓷、玉和醋、长沙绿茶、浏阳夏布……长沙市最有名的非遗产品、非遗项目亮相中国（韶山）非物质文化遗产博览园，长沙非遗馆也成为博览园里人气最旺的地方。</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;湘绣是长沙馆的主打产品，在馆中央位置展示，其中最引人注目的是长沙市开福湘绣研究所参加2015年意大利米兰世博会的长卷湘绣《百骏图》。该幅湘绣以清代郎世宁的《百骏图》为蓝本，
高90厘米、宽720厘米，由中国工艺美术大师江再红领衔20多位绣师，历时95天，运用各种针法和各色丝线精心绣制而成。绣卷上人物、山水、树木、土坡层次分明，颇富立体感。放牧游憩于草场的百匹骏马更是形象逼真，它们或卧或立、或翻滚嬉戏、或交斗觅食，
姿态各异，聚散不一，透露出自由、闲适的意境。另外，青竹湖湘绣展示的红色主题作品也令人赞叹不已。</p>
   <p style="margin:10px 225px "><img  alt="游乐天堂" src="article/img/006_1.jpg"></p>
　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;浏阳夏布此次高调亮相。织机摆在现场，一些人忍不住试织几下。夏布做的手包庄重、典雅，成为抢手货。“很久以前用过这种布，没想到在这里看到了，真有遇故人的感觉。”一位女士600元买了一个包，非常高兴。</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;陶制小火炉烧着木炭火，上面煮着水，木桌前一位清秀的姑娘在表演茶艺，一杯杯清茶送到观众手上，也把长沙金井绿茶的优雅和意韵送到了观众的心里。</p>

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;令人流连忘返的还有“泥人刘”制作的趣味横生的泥人；陈继武精雕的菊花石；玉和醋摆在现场，任观众品尝……“有些非遗项目我还是第一次知道，长知识了！”一位观众笑着说。</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;金球湘绣的创新作品蝉翼绣首次采用新材料作为底料，虚实相接，立体通透，薄如蝉翼。</p>
　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作为湘绣代表，金球湘绣的《暗香》等四幅作品赶赴昆明市，出席今日在云南开展的第五届全国非遗联展。
与以往不同的是，本次非遗联展参展，金球湘绣首创出的《暗香》等蝉翼绣作为湘绣极品，首次代表湘绣正式亮相。</p>
　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;传统湘绣多以绸、缎为绣布，随着湘绣的不断创新，如今这一“传统”在金球湘绣打破。记者在开福区沙坪湘绣文化广场的金球湘绣展厅看到，首创出的蝉翼绣给人第一印象就是现代、时尚，木质立式简约的装裱，一改以往的框边；而薄如蝉翼的双面绣，具有一定的通透性，
整幅作品雅致新颖，富有时代气息，让人耳目一新。目前，蝉翼绣已申报国家专利，其中装裱创新已获实用新型专利。</p>
          
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