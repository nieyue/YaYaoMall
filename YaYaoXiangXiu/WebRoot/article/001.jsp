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
		<h1 style="margin:1px 300px;color:red;font-size:36px">四大名绣-湘绣</h1><br/><br/>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;湘绣是以湖南长沙为中心的带有鲜明湘楚文化特色的湖南刺绣产品的总称，
			是勤劳智慧的湖南人民在漫长的人类文明历史的发展过程中，精心创造的一种具有湘楚文化特色的民间工艺。
			其历史源远流长，可追溯到2000多年前的春秋战国时期。从长沙战国楚墓和马王堆西汉古墓出土的大量绣品中，
			可以窥见当时湖南地方刺绣技艺已经达到令人惊讶的高度。据记载，1958年在长沙楚墓中发现的龙凤图案绣品图案之精美，
			绣工针法之细腻，早为世人叹而观止。1972年又在长沙马王堆西汉古墓中出土了四十来件刺绣衣物，说明远在二千一百多年前的西汉代，
			湖南地方刺绣即湘绣已发展到了较高的水平。</p>
    <p style="margin:10px 225px ">
    <img  alt="游乐天堂" src="article/img/001_1.jpg">
    </p>
 
　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;辉煌灿烂的楚绣与马王堆汉绣，不但是中国刺绣史上足资骄傲与自豪的一章，也是湘绣顺理成章的最初发展之源。”
在工艺文化的历史长河中，从刺绣工艺的文化深层内涵剖析，上述论点是很正确的。它对探讨湘绣这一特定历史条件下形成并广有影响的绣种的承前启后，
无疑是有积极意义的。另外，湘绣在湖南民间刺绣的基础上，还吸取了苏绣、粤绣、京绣等绣系的优点，发展成为清代刺绣艺苑的后起之秀。</p>

　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;湘绣的日用品主要有官服、镜袋、扇套、手帕、荷包、椅披、桌围、被面、枕套、帐帘、神袍、戏装、袈裟、绣衣、绣鞋等。欣赏品有中堂、条屏、屏风等。</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;湘绣既吸收了传统绘画的优点，又充分发挥刺绣工艺的特长，逐渐形成了形象写实，设色鲜明，风格质朴的地方风格。在构图上，主题突出，虚实结合，
大胆利用绣料上的大片空白，既省工，又美观。在造型手法上，则在线描的基础上,适当地有些明暗对比变化,以加强物象的质感和主体感。
湘绣的针法除了常用的掺针（又称搀针）外，还有游针、毛针、鬅毛针、齐针、平针、网针、打子针、交叉针（又称乱针）等几十种。</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;狮、虎是湘绣的传统题材，特别以虎更为著名。为了表现猛虎皮毛的质感，湖南刺绣艺人在毛针的基础上创制了鬅毛针。
后来，又由著名匠师余冬姑、余振辉姐妹俩加以不断完善。鬅毛针的绣法是，丝线排列成聚散状撑开，一端粗疏、松散，一端细密，
使之如同真毛一样，一端入肉，一端鬅起。经过艺人层层加绣后，所绣制的虎毛，刚劲竖立，力贯毫端，毛色斑斓，生动逼真。</p>

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;湘绣是在湖南民间刺绣的基础上发展而来的。湖南民间很早就能够刺绣。清代嘉庆年间，长沙县就有很多妇女从事刺绣。
光绪二十四年（1898），优秀绣工胡莲仙的儿子吴汉臣，在长沙开设第一家自绣自销的“吴彩霞绣坊”，作品精良，流传各地，湘绣从而闻名全国。
清光绪年间，宁乡画家杨世焯倡导湖南民间刺绣，长期深入绣坊，绘制绣稿，还创造了多种针法，提高了湘绣艺术水平。光绪末年，
湖南的民间刺绣发展成为一种独特的刺绣工艺系统，成为一种具有独立风格和浓厚地方色彩的手工艺商品走进市场。
这时，“湘绣”这样一个专门称谓才应运而生。此后，湘绣在技艺上不断提高，并成为蜚声中外的刺绣名品。</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;进入十九世纪以后，随着湘绣商品经济的发展，通过众多刺绣艺人不断深索和一大批出色的中国国画家潜心投入，
湘绣吸收了我国古老文化中绘画、刺绣、诗词、书法、金石等诸种艺术精华，从而形成了以中国画为基础、以数十种针法和多种色阶的绣线，
在各类底料上充分发挥针法的表现力，精细入微地刻画出物象外形内质的自行特色。二十世纪初湘绣以其独特风格，
在国内外获得多项殊荣，成为饮誉世界的中国四大名绣之一。</p>

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;自20世纪初以来，湘绣屡次获奖，声誉日增。1909年，在南京举行的南洋劝业会上，湘绣被赞誉为“迹灭针线”。
1911年，湘绣在意大利都朗博览会上获最优奖。1915年，在美国旧金山举行的巴拿马博览会上又获 4块金牌。
20年代，湘绣艺术家李凯云设计了孙中山先生的湘绣棺罩。30年代，湘绣艺术家杨佩珍绣制的“罗斯福肖像”，现仍珍藏于美国佐治亚州亚特兰大市小白宫博物馆。</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;20世纪30年代，湘绣的产值最高达80万银元，产品1/3出口。1935年《西湖博览会总报告书》“绣品”一节中，湘绣就占了一半的篇幅。
解放后的数十年间，湘绣取得了长足发展，以独特风格和高超绣艺傲立于“四大名绣”之列，成为湖南乃至国家的“艺术名片”，湘绣每年出口最高达500万美元。</p>

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;20世纪50年代以来,湘绣有了迅速的发展,成立了湖南省湘绣研究所，作品的艺术水平也日益提高。70年代末，湖南省湘绣研究所在传统双面绣的基础上创制了双面异物绣，
即正、反两面轮廓相同而形象不同的双面绣。1979年又创制了双面全异绣，即正、反两面形象、色彩、针法等完全不同的两种画面。代表作品有“狮、虎”绣屏和“望月”绣屏。
“狮、虎”绣屏的正面是仰天长啸的上山猛虎，反面却是低头夜行的下山雄狮。“望月”绣屏的正面为透过轻帘，只见丽人侧影，仰望明月；另一面是闺阁仕女云髻堆翠，
在颦笑之余又流露出哀怨之情。双面全异绣要求设计者构思巧妙，绣制者在运针时具有藏针、隐线的高超技艺，而且丝毫不露针迹。</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;湘绣先后参加过日本、巴拿马、美国等地举办的国际博览会，多次获得优胜奖，在国际市场上享有盛誉。近年来，湘绣在继承传统的刺绣技艺基础上又有的突破，
相继绣出了一批双面全异刺绣作品。尤其是《养在深闺人未识》的双面全异绣人物题材作品，经专家们鉴定，是一幅“超级绣品”。
中国科技协会将这幅绣品选为“中国古代传统技术展览会”的展品。正是湘绣界人士的不断努力，使湘绣从生活实用艺术走向了精品化的装饰和收藏艺术，
成为代表一方工艺及文化的礼仪佳品。贺香港回归的大型双面绣座屏《百鸟朝凤·洞庭春色》在香港回归和特区政府成立的典礼上得到了中外来宾的赞赏和好评。</p>
          
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