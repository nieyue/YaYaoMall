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
		<title>湘绣精品</title>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<meta name="Keywords" content="湘绣，收藏，艺术品，文化，陶瓷，刺绣"/>
	<link rel="stylesheet" href="css/base.css" type="text/css" />
	<link rel="stylesheet" href="css/taoci.css" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/img_effects.js"></script>
	<script type="text/javascript" src="js/topNav_menu.js"></script>
	
	<script type="text/javascript">
	$(function(){
		 $.get("loadAllEBMerchandise.dhtml");//初始化商品
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
	

<!--宽度全屏-->
    <div  class="long2"><a href="embroideryDetails.html"><span><span><img class="EBMerchandise" src="merchandisePicture/embroideryBoutique_1/first.png"  /></span></span></a></div>
<!--宽度全屏 END-->
<div class="clear"></div>
<!--湘绣展示1-->
<div  class="xiangxiu">
 <div  class="xiangxiu1">
 <img src="images/xiang2.jpg"  />
  <div  class="xiangxiu2">
     <div class="xiangxiu5 imgid">
     <dl>
		<dt><a href="javascript:;"><img class="EBMerchandise" src="merchandisePicture/embroideryBoutique_1/1.jpg" /></a></dt>
		<dd class="title">大吉大利</dd>
		<dd class="content"><span class="goods_jiage">RMB<em>388.0</em></span></dd>
		<dd class="buy"><span class="goods_chengjiao"><input type="image" src="images/gouw.gif" /></span></dd>
	</dl>
     </div>
	 <div class="xiangxiu6 imgid">
	 	<dl>
			<dt><a href="javascript:;"><img class="EBMerchandise" src="merchandisePicture/embroideryBoutique_1/2.jpg" /></a></dt>
			<dd class="title">蜻蜓戏荷</dd>
			<dd class="content"><span class="goods_jiage">RMB<em>388.0</em></span></dd>
			<dd class="buy"><span class="goods_chengjiao"><input type="image" src="images/gouw.gif"/></span></dd>
		</dl>
	 </div>
  </div>
  <div  class="xiangxiu3">
     <div class="xiangxiu5 imgid">
     	<dl>
			<dt><a href="javascript:;"><img class="EBMerchandise" src="merchandisePicture/embroideryBoutique_1/3.jpg" /></a></dt>
			<dd class="title">鹤立峰岩</dd>
			<dd class="content"><span class="goods_jiage">RMB<em>388.0</em></span></dd>
			<dd class="buy"><span class="goods_chengjiao"><input type="image" src="images/gouw.gif" /></span></dd>
	    </dl>
	</div>
	 <div class="xiangxiu6 imgid">
	 	<dl>
			<dt><a href="javascript:;"><img class="EBMerchandise" src="merchandisePicture/embroideryBoutique_1/4.jpg" /></a></dt>
			<dd class="title">马到成功</dd>
			<dd class="content"><span class="goods_jiage">RMB<em>388.0</em></span></dd>
			<dd class="buy"><span class="goods_chengjiao"><input type="image" src="images/gouw.gif" /></span></dd>
		</dl>
	 </div>
  </div>
  <div  class="xiangxiu4 imgid">
  	<dl>
		<dt><a href="javascript:;"><img class="EBMerchandise" src="merchandisePicture/embroideryBoutique_1/5.jpg" /></a></dt>
		<dd class="title">国宝熊猫</dd>
		<dd class="content"><span class="goods_jiage">RMB<em>388.0</em></span></dd>
		<dd class="buy"><span class="goods_chengjiao"><input type="image" src="images/gouw.gif" /></span></dd>
	</dl>
  </div>
 </div>   
</div>
<!--宽度展示 END-->

<div class="clear"></div>
<!--宽度全屏1-->
<div  class="go1">
 <div  class="go2">
<a href="embroideryDetails.html"><img src="merchandisePicture/embroideryBoutique_2/two.png" border="0"  /></a> </div>
</div>
<!--宽度全屏 END-->

<!-- 湘绣List -->
<div  class="go1">
 <div  class="go2">
			<!-- 商品列表 -->
			<a href="embroideryDetails.html"><img src="images/xiang6.jpg" border="0"  /></a>
			<div class="shop_bd_list_content clearfix">
				<ul>
					<li class="imgid">
						<dl>
							<dt><a href="javascript:;" id="embroideryBoutique_a1"><img class="EBMerchandise" src="merchandisePicture/embroideryBoutique_2/1.jpg" /></a></dt>
							<dd class="title">报春图</dd>
							<dd class="content"><span class="goods_jiage">RMB<em>6800.0</em></span></dd>
							<dd class="buy"><span class="goods_chengjiao"><input type="image" src="images/gouw.gif" onclick="document.getElementById('embroideryBoutique_a1').click();"/></span></dd>
						</dl>
					</li>

					<li class="imgid">
						<dl>
							<dt><a href="javascript:;" id="embroideryBoutique_a2"><img class="EBMerchandise" src="merchandisePicture/embroideryBoutique_2/2.jpg" /></a></dt>
							<dd class="title">鹊华秋色</dd>
							<dd class="content"><span class="goods_jiage">RMB<em>6800.0</em></span></dd>
							<dd class="buy"><span class="goods_chengjiao"><input type="image" src="images/gouw.gif" onclick="document.getElementById('embroideryBoutique_a2').click();"/></span></dd>
						</dl>
					</li>
					<li class="imgid">
						<dl>
							<dt><a href="javascript:;" id="embroideryBoutique_a3"><img class="EBMerchandise" src="merchandisePicture/embroideryBoutique_2/3.jpg" /></a></dt>
							<dd class="title">满园春</dd>
							<dd class="content"><span class="goods_jiage">RMB<em>6800.0</em></span></dd>
							<dd class="buy"><span class="goods_chengjiao"><input type="image" src="images/gouw.gif" onclick="document.getElementById('embroideryBoutique_a3').click();"/></span></dd>
						</dl>
					</li>
					<li class="imgid">
						<dl>
							<dt><a href="javascript:;" id="embroideryBoutique_a4"><img  class="EBMerchandise" src="merchandisePicture/embroideryBoutique_2/4.jpg" /></a></dt>
							<dd class="title">清明河上图</dd>
							<dd class="content"><span class="goods_jiage">RMB<em>6800.0</em></span></dd>
							<dd class="buy"><span class="goods_chengjiao"><input type="image" src="images/gouw.gif" onclick="document.getElementById('embroideryBoutique_a4').click();"/></span></dd>
						</dl>
					</li>
				</ul>
			</div>
			<div class="clear"></div>
			<!-- 商品列表 End -->
  </div>
</div>
<!--湘绣 List Body End -->

<div class="clear"></div>
<!--宽度全屏1-->
<div  class="go1">
 <div  class="go2">
<a href="embroideryDetails.html"><img src="merchandisePicture/embroideryBoutique_3/three.png"  /></a>
 </div>
</div>
<!--宽度全屏 END-->


<!-- 湘绣List -->
<div  class="go1">
 <div  class="go2">
			<!-- 商品列表 -->
			<a href="embroideryDetails.html"><img src="images/shuangmian.jpg" border="0"  /></a>
			<div class="shop_bd_list_content clearfix">
				<ul>
					<li class="imgid">
						<dl>
							<dt><a href="javascript:;" id="embroideryBoutique_a7"><img class="EBMerchandise" src="merchandisePicture/embroideryBoutique_3/1.jpg" /></a></dt>
							<dd class="title">松鹤延年</dd>
							<dd class="content"><span class="goods_jiage">RMB<em>1288.0</em></span></dd>
							<dd class="buy"><span class="goods_chengjiao"><input type="image" src="images/gouw.gif" onclick="document.getElementById('embroideryBoutique_a7').click();"/></span></dd>
						</dl>
					</li>
					<li class="imgid">
						<dl>
							<dt><a href="javascript:;" id="embroideryBoutique_a8"><img class="EBMerchandise" src="merchandisePicture/embroideryBoutique_3/2.jpg" /></a></dt>
							<dd class="title">喜上树梢</dd>
							<dd class="content"><span class="goods_jiage">RMB<em>1288.0</em></span></dd>
							<dd class="buy"><span class="goods_chengjiao"><input type="image" src="images/gouw.gif" onclick="document.getElementById('embroideryBoutique_a8').click();"/></span></dd>
						</dl>
					</li>
					<li class="imgid">
						<dl>
							<dt><a href="javascript:;" id="embroideryBoutique_a9"><img class="EBMerchandise" src="merchandisePicture/embroideryBoutique_3/3.jpg" /></a></dt>
							<dd class="title">荣华富贵</dd>
							<dd class="content"><span class="goods_jiage">RMB<em>1288.0</em></span></dd>
							<dd class="buy"><span class="goods_chengjiao"><input type="image" src="images/gouw.gif" onclick="document.getElementById('embroideryBoutique_a9').click();"/></span></dd>
						</dl>
					</li>
					<li class="imgid">
						<dl>
							<dt><a href="javascript:;" id="embroideryBoutique_a10"><img class="EBMerchandise" src="merchandisePicture/embroideryBoutique_3/4.jpg" /></a></dt>
							<dd class="title">花开富贵</dd>
							<dd class="content"><span class="goods_jiage">RMB<em>1288.0</em></span></dd>
							<dd class="buy"><span class="goods_chengjiao"><input type="image" src="images/gouw.gif" onclick="document.getElementById('embroideryBoutique_a10').click();"/></span></dd>
						</dl>
					</li>
					<li class="imgid">
						<dl>
							<dt><a href="javascript:;" id="embroideryBoutique_a11"><img class="EBMerchandise" src="merchandisePicture/embroideryBoutique_3/5.jpg" /></a></dt>
							<dd class="title">爱晚亭</dd>
							<dd class="content"><span class="goods_jiage">RMB<em>1288.0</em></span></dd>
							<dd class="buy"><span class="goods_chengjiao"><input type="image" src="images/gouw.gif" onclick="document.getElementById('embroideryBoutique_a11').click();"/></span></dd>
						</dl>
					</li>
					<li class="imgid">
						<dl>
							<dt><a href="javascript:;" id="embroideryBoutique_a12"><img class="EBMerchandise" src="merchandisePicture/embroideryBoutique_3/6.jpg" /></a></dt>
							<dd class="title">虎</dd>
							<dd class="content"><span class="goods_jiage">RMB<em>1288.0</em></span></dd>
							<dd class="buy"><span class="goods_chengjiao"><input type="image" src="images/gouw.gif" onclick="document.getElementById('embroideryBoutique_a12').click();"/></span></dd>
						</dl>
					</li>
				</ul>
			</div>
			<div class="clear"></div>
			<!-- 商品列表 End -->
  </div>
</div>
<!-- 湘绣List Body End -->

<div class="clear"></div>
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