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
		<h1 style="margin:1px 30px;color:red;font-size:36px">“无名”湘绣女 用丝线控诉日军侵湘造成夫妻别离</h1><br/><br/>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;“历史是会呼吸有体温的”。在抗战胜利70周年之际，一场名为“特别纪念——中国人民抗日战争暨世界反法西斯战争胜利70周年文物资料展”于昨天上午9时在长沙市博物馆开幕。
			如何纪念抗战胜利70周年？或许参观过这场展览的观众会得到一个答案，绝对不能淡忘这段历史，要与这段历史同呼吸共命运，在仍然具有体温、充满感情的历史中，我们应当铭记抗战中的英雄，尽管他们或许只是些“无名之辈”，历史其实正是由亿万“无名之辈”所创造，他们可歌可泣的抗争，值得我们感受他们的温度和冷暖，铭记他们作出的努力。</p>
  <p style="margin:10px 225px "><img  alt="游乐天堂" src="article/img/003_2.jpg"></p>
　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在第四展厅展出的一条白棉布绣花方巾特别引人注目。</p>

　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;　一位不知姓名的湖南绣女用红绿紫三色丝线，在一块长宽均约半米的白方巾上，绣出56句缠绵悱恻的七言诗，倾诉其对抗战的丈夫的深切思念，
控诉了日本侵湘造成普通人家如牛郎织女一般的别恨离愁：“ ……九月菊花遍地黄，前方炸弹响叮当，可恨日本心肠毒，飞机大炮打先锋……夏月牡丹配芙蓉，可怜我夫受风寒，心中送起前方去，路途遥远枉费心。
腊月梅花对雪开，夫君当兵一年来，得胜提起茶盘格，洗手焚香谢天台。奴守空房十二月，眼泪汪汪落纷纷，用手提起茶盘格，如真如见半夫人。”这条浸满泪水绣成于抗战年代，实录生活的方巾，为长沙市博物馆收藏，已定为国家一级文物。</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在这条白棉布绣诗方巾旁，另外陈列着一方极不打眼的黑陶罐，陶罐外壁镌刻有“小日本不讲理”六个大字，
它像在展示着一道难以愈合的历史伤疤。这个粗糙陶罐的制作者无法考证，但其指斥“小日本不讲理”的话语，穿越时空，至今仍觉掷地有声。</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;战火与硝烟似乎随70年时光已散尽，但在长沙抗战文物资料展上，那些清晰的抗战老兵环境照似乎仍让他们弥漫在过往的岁月中，历久弥新。</p>
  <p style="margin:10px 225px "><img  alt="游乐天堂" src="article/img/003_1.jpg"></p>
　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;几乎每个展厅墙上均悬挂有本次策展人马金辉为抗战老兵们拍摄的照片，照片中的老人们，或健在，或已故，照片旁的文字，极其简略地概括着老人在抗战中的经历。</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;现家住长沙市岳麓区金岭小区的抗战老兵刘津在志愿者的搀扶下，来到展厅中自己的相片下。刘老自称，这张他半躺在椅子上，手拿自己画像的相片，
让他“很满足，很满意，很喜欢，拍出了他随便时的状态”。拍摄者马金辉的理解是：这些展览上的相片，让所有老兵获得了一种“视觉上的待遇”，老兵们会觉得这些相片反映了他们真实的状态，令他们有面子，找到了历史的位置，他们并不仅仅只是一个“过去的存在”。</p>

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;马金辉回忆，当初为老兵刘津拍摄相片时，刚看完《欲望高速》的老人曾说：他“现在怕死，舍不得，不知足，生活上没有太多的要求，就是对知识，对人生路程的长度和宽度不满足”。</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;现在人们进来看这些相片，浏览抗战老兵们的经历，大家都会知道，都会铭记这些“无名之辈”，他们是士兵，是70年前的抵抗者，中国抗战，是由一个个具体的人来完成的，
他们是那段历史的亲历者，这些湖南老兵正以“无名之辈”的名义，以自己在抗战中的真实细节，重构着一段抗战史。本雅明说：“纪念无名之辈比纪念名人要艰难得多，但历史的建构就是要致力于对无名之辈的铭记。”马金辉认为，
“从个体生命的角度，铭记无名之辈，铭记他们在曾经的时代要求下所作出的简单的壮烈回应，这是我们对70年前那场全民抗战具微而真实的纪念”。</p>

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;来自长沙县路口镇的抗战老兵粟翼航曾在99军99师司职译电员，在汨罗，他曾被迫击炮击中头部，展览上，他在自己的相片下，揭下帽子将当年被弹片划破的头部伤痕展示出来。</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;满屋抗战老兵相片，一件件抗战历史文物，一下子就让首批前来参观展览的八旬娭毑彭越碍回到日寇入侵湘潭的历史现场。</p>
　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;她说，1944年，她刚满10岁，禾苗才长得齐她腰深的时节，日寇跑到她家乡湘潭县易俗河空灵乡赤广塘打掳，她抱着半岁大的侄女躲兵，
8岁的弟弟则牵着一头大水牛，手中提着一篓饭逃难。这些抗战中的细伢妹子，紧紧跟着家中患痢疾的大人，在混乱中往山里跑，往沟里躲。在那个日寇侵湘、兵荒马乱的年代，无论男女老幼都不得安生，他一个5岁的侄儿就在这次混乱中走丢了。</p>
　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;展览中的文物资料及老兵相片，让彭娭毑一下子就回到七十多年前。在省委党校退休的她，说了一句堪称经典的话：“无须常怀仇恨，但应牢记历史。”她说这是她作为一个抗战亲历者得来的教训，虽然她并非抗战老兵，但她也是见证这段历史的“无名之辈”。</p>
          
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