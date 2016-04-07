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
		<h1 style="margin:1px 200px;color:red;font-size:36px">湘绣的选配、悬挂及摆放知识</h1><br/><br/>
			<p style="font-size:25px">选配、摆置湘绣时应注意以下要点：</p>

　　<p>1.作品本身的风格、色调、题材、寓意适宜；<br/>
2.摆置后人、房、作品的协调一致；<br/>
3.作品悬挂数量及尺寸适宜；<br/>
4.作品悬挂位置高低；环境适宜（场所的光线、空气湿度适宜，忌置于风吹、易碰倒之处）。</p>
 <p style="margin:10px 225px "><img  alt="游乐天堂" src="article/img/005_1.jpg"></p>

　<p style="font-size:25px">详   解：</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1.湘绣画风格、色调不一样，有色彩艳丽的，有色彩淡雅的，有气势宏伟的，有手法娓婉的有喜气洋洋的，有儒雅翩翩的。顾客可根据自己的爱好和室内环境选定合适的湘绣，让室内气氛和谐。</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.挂湘绣画的色彩选择一定要考虑和家具的颜色相配，这样才能给人以协调的感觉，否则将会适得其反、画蛇添足。</p>

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.一般来说，所挂湘绣画的风格应和所处环境、场合相对应。例如办公楼大厅适宜挂摆意境大气一点的作品；大餐厅在餐桌周围的墙壁上，挂一幅与桌面大小相等的作品；或在客厅内挂一幅与沙发宽度相似的大幅作品，总之适宜的协调感更能体现挂湘绣的艺术效果。</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4.若室内空间不大，可选择尺寸小的画，若房间宽敞则可选择大幅或成套的湘绣悬挂。</p>

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5.充分发挥湘绣组合套画的魅力，在沙发上缘的墙壁，如将一套意境相同的作品集中吊挂，能使室内有清新爽美之感；画与画间的距离，须视室内空间大小，作适当的调配，否则会失去平衡。</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;6.室内所挂湘绣作品题材、寓意也应该和主人身份相匹配，观其作品如能达到可判断其主人身份是为官、为贾、为师、为艺者，乃是配饰的绝佳效果。</p>

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.悬挂湘绣画以能自然姿势欣赏的高度（立于画前、画底沿略高于双眼）为佳，这种高度，是视觉自然高度，可使室内有效宽阔的错觉感。如挂得过高将使欣赏者产生高不可攀、不稳重的感觉。</p> 

　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;8.双面绣摆放也参照以上方法来考虑。</p>
　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;9.悬挂、摆放湘绣画还要考虑到室内光线照射情况。通常为了突出画面主体；尽量让窗户的自然光源与画面上的人工光源相呼应。为突出视觉冲击，一般在背光的墙壁上挂色彩较淡的湘绣或对比反差强烈的湘绣作品；在光线充足的墙面上宜挂颜色较深的作品。</p>
　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;10.无论是摆置什么类型的湘绣作品，要注意避免强光的直射和反射，因湘绣的真丝缎面经强光久射后会褪色，因此湘绣宜摆在强光直射不到的地方。</p>
　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;11.配饰古典湘绣作品时，如能加以配饰文化味浓一点的博古架，将给场所平添许多高雅韵味。</p>
          
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