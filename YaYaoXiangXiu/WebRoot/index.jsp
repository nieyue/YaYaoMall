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
		<title>雅耀商城</title>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<meta name="Keywords" content="湘绣，收藏，艺术品，文化，陶瓷，刺绣"/>
	<link rel="stylesheet" href="css/base.css" type="text/css" />
    <script src="js/jquery.js" language="javascript" type="text/javascript"></script>
    <script language="javascript" type="text/javascript" src="js/public.js"></script>
    <script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
    <script type="text/javascript" src="js/img_effects.js"></script>
    <script type="text/javascript" src="js/topNav_menu.js"></script>
    <script type="text/javascript">
 function mobile_device_detect(url)
 {
        var thisOS=navigator.platform;

        var os=new Array("iPhone","iPod","iPad","android","Nokia","SymbianOS",
      "Symbian","Windows Phone","Phone","Linux armv71","MAUI","UNTRUSTED/1.0",
      "Windows CE","BlackBerry","IEMobile");
 for(var i=0;i<os.length;i++){
 if(thisOS.match(os[i])){   
	  window.location=url;
  }
 }

 //因为相当部分的手机系统不知道信息,这里是做临时性特殊辨认
 if(navigator.platform.indexOf('iPad') != -1)
        {
  window.location=url;
 }

 //做这一部分是因为Android手机的内核也是Linux

 //但是navigator.platform显示信息不尽相同情况繁多,因此从浏览器下手，即用navigator.appVersion信息做判断

  var check = navigator.appVersion;
  if( check.match(/linux/i) )
          {
   //X11是UC浏览器的平台 ，如果有其他特殊浏览器也可以附加上条件
   if(check.match(/mobile/i) || check.match(/X11/i))
                 {
   window.location=url;
   }  
 }

 //类in_array函数

 Array.prototype.in_array = function(e){
  for(i=0;i<this.length;i++)
  {
   if(this[i] == e)
   return true;
  }
  return false;
 }
 }
//mobile_device_detect("http://www.358go.com/mobile");
$(function(){
	$("#box_top_left a img,#box_top_right a img,#box_middle a img,#box_bottom_left a img,#box_bottom_right a img").mouseover(function(){
		$(this).css("zIndex",9999);	
	});
	$("#box_top_left a img,#box_top_right a img,#box_middle a img,#box_bottom_left a img,#box_bottom_right a img").mouseout(function(){
		$(this).css("zIndex",1);	
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

	
<!--自适应缩放-->
<div class="mBan2">
<div id="slideBox" class="slideBox">
    <div class="hd">
        <ul><li></li><li></li><li></li></ul>
    </div>
    <div class="bd">
        <ul>
            <li><a href="embroideryCustom.html" target="_blank"><img  src="images/01.jpg" /></a></li>
            <li><a href="embroideryCustom.html" target="_blank"><img  src="images/02.jpg" /></a></li>
            <li><a href="ceramicCustom.html" target="_blank"><img  src="images/03.jpg" /></a></li>
        </ul>
    </div>
</div>
</div>
<script language="javascript">
jQuery(".slideBox").slide({mainCell:".bd ul",effect:"fold",autoPlay:true,trigger:"click"});
</script>
<!--自适应缩放  END-->
	<div class="clear"></div>

<!-- 文章显示 -->
<div class="shop_bd_home_block clearfix" style="border :5px double red;border-radius:50px">
   <h2 style="margin:1px 400px;color:red;font-size:36px;text-shadow: 2px 2px 5px blue;">湘&nbsp;绣&nbsp;来&nbsp;袭</h2>
  <div id="list" style="margin:10px;" class="imgid LunBo">
        <a href="article/011.html" class="CurrentPic" style="width:480px;height:250px;dispaly:none;position:absolute;"><img class="imgid" style="width:480px;height:250px;" src="article/img/011_1.jpg" alt="1"/></a>
        <a href="article/004.html" style="width:480px;height:250px;dispaly:none;position:absolute;"><img class="imgid" style="width:480px;height:250px;" src="article/img/004_1.jpg" alt="2"/></a>
        <a href="article/006.html" style="width:480px;height:250px;dispaly:none;position:absolute;"><img class="imgid" style="width:480px;height:250px;" src="article/img/006_1.jpg" alt="3"/></a>
        <a href="article/007.html" style="width:480px;height:250px;dispaly:none;position:absolute;"><img class="imgid" style="width:480px;height:250px;" src="article/img/007_2.jpg" alt="4"/></a>
        <a href="article/008.html" style="width:480px;height:250px;dispaly:none;position:absolute;"><img class="imgid" style="width:480px;height:250px;" src="article/img/008_1.jpg" alt="5"/></a>
  <div class="LunBoNum" style="position:absolute;left:380px;top:280px;">
     <span class="CurrentNum" style="height: 20px;width: 20px;display: block;line-height: 20px;text-align: center;margin-top: 5px;margin-bottom: 5px;float: left;cursor: pointer;color:white;">1</span>
     <span style="height: 20px;width: 20px;display: block;line-height: 20px;text-align: center;margin-top: 5px;margin-bottom: 5px;float: left;cursor: pointer;color:white;">2</span>
     <span style="height: 20px;width: 20px;display: block;line-height: 20px;text-align: center;margin-top: 5px;margin-bottom: 5px;float: left;cursor: pointer;color:white;">3</span>
     <span style="height: 20px;width: 20px;display: block;line-height: 20px;text-align: center;margin-top: 5px;margin-bottom: 5px;float: left;cursor: pointer;color:white;">4</span> 
     <span style="height: 20px;width: 20px;display: block;line-height: 20px;text-align: center;margin-top: 5px;margin-bottom: 5px;float: left;cursor: pointer;color:white;">5</span>
  </div>
  </div>
  <div style="margin:-10px 490px 10px;width:490px;padding:10px 30px;display:inline-block;">
   <a href="article/001.html" style="margin:1px;display:block;">四大名绣-湘绣</a>
   <a href="article/011.html" style="margin:1px;display:block;">湘绣梦结合中国梦是我们的奋斗目标</a>

   <a href="article/002.html" style="margin:1px;display:block;">90后湘绣传承人 一针一线绣青春</a>
   <a href="article/003.html" style="margin:1px;display:block;">“无名”湘绣女 用丝线控诉日军侵湘造成夫妻别离</a>
   <a href="article/004.html" style="margin:1px;display:block;">“亲情中华·汉语桥”夏令营来长沙县参观学习湘绣</a>
   <a href="article/005.html" style="margin:1px;display:block;">湘绣的选配、悬挂及摆放知识</a>
   <a href="article/006.html" style="margin:1px;display:block;">湘绣夏布泥人，长沙非遗惊艳</a>
   <a href="article/007.html" style="margin:1px;display:block;">长卷湘绣《百骏图》封针 将亮相米兰世博会</a>
   <a href="article/008.html" style="margin:1px;display:block;">中国首条湘绣主题文化旅游街区开盘 沙坪绣坊街盛装亮相</a>
   <a href="article/009.html" style="margin:1px;display:block;">湘绣米兰归来带回500万订单</a>
   <a href="article/010.html" style="margin:1px;display:block;">72岁沙坪湘绣第一人捧回全国"典型人物奖"</a>
  </div> 
  <hr style="border:1px dashed red;"/>
  <h1 style="margin:20px 70px;color:red;font-size:36px">“俄罗斯援华抗战老战士中国行”湖南站启动</h1>
  <div  style="margin:-100px 490px 10px;width:490px;padding:10px 30px;display:inline-block;">
  <div id="box_top_left" style="width:200px;height:200px;border:1px solid #333;display:inline-block;margin:10px 0 410px -510px;">
   <a href="article/012.html">
   <img class="imgid" style="width:200px;height:200px;position:absolute;" onmouseover="this.style.cssText='width:400px;height:400px;position:absolute;margin:-100px -100px;'" onmouseout="this.style.cssText='width:200px;height:200px;position:absolute;'"  src="article/img/012_1.jpg" alt="2"/>
   </a>
  </div>
   
  <div id="box_top_right" style="width:200px;height:200px;border:1px solid #333;display:inline-block;margin:10px 0 410px 560px;">
  <a href="article/012.html">
   <img class="imgid" style="width:200px;height:200px;position:absolute;" onmouseover="this.style.cssText='width:400px;height:400px;margin:-100px -100px;position:absolute;'" onmouseout="this.style.cssText='width:200px;height:200px;position:absolute;'"  src="article/img/012_2.jpg" alt="2"/>
   </a>
  </div>
   
  <div id="box_middle" style="width:550px;height:600px;border:1px solid #333;display:inline-block;margin:100px -765px 10px -765px;">
   <a href="article/012.html">
   <img class="imgid" style="width:550px;height:600px;position:absolute;" onmouseover="this.style.cssText='width:1000px;height:800px;margin:-100px -225px;position:absolute;'" onmouseout="this.style.cssText='width:550px;height:600px;position:absolute;'"  src="article/img/012_0.jpg" alt="2"/>
   </a>
  </div>
  <div id="box_bottom_left" style="width:200px;height:200px;border:1px solid #333;display:inline-block;margin:10px 0 10px;">
  <a href="article/012.html">
   <img class="imgid" style="width:200px;height:200px;position:absolute;" onmouseover="this.style.cssText='width:400px;height:400px;margin:-100px -100px;position:absolute;'" onmouseout="this.style.cssText='width:200px;height:200px;position:absolute;'"  src="article/img/012_3.jpg" alt="2"/>
   </a>
   </div>
    
  <div id="box_bottom_right" style="width:200px;height:200px;border:1px solid #333;display:inline-block;margin:10px 0 10px 560px;">
  <a href="article/012.html">
   <img class="imgid" style="width:200px;height:200px;position:absolute;" onmouseover="this.style.cssText='width:400px;height:400px;margin:-100px -100px;position:absolute;'" onmouseout="this.style.cssText='width:200px;height:200px;position:absolute;'"  src="article/img/012_4.jpg" alt="2"/>
   </a>
   </div>
  </div> 
</div>

<!--宽度全屏-->
    <div class="long3">
	
	<a href="embroideryCustom.html"><img src="images/05.png" width="990" height="140" /></a>
	</div>
<!--宽度全屏 END-->
<!--主体 -->
<div class="shop_bd">

<!--首页产品-->
<div class="shop_bd_home_block clearfix">
                <!-- 左边 -->
                <div class="shop_bd_home_block_left">
                    <div class="shop_bd_home_block_left_1 imgid"><a href="embroideryBoutique.html"><img  src="merchandisePicture/index_1/1-1.png"/></a></div>
                    <div class="shop_hd_home_block_left_2 imgid"><a href="embroideryBoutique.html"><img  src="merchandisePicture/index_1/2-1.png"/></a></div>
                    <div class="shop_hd_home_block_left_3 imgid"><a href="embroideryBoutique.html"><img  src="merchandisePicture/index_1/3-1.png"/></a></div>
                </div>
                <!-- 左边 End -->
                
                <!-- 中间 -->
                <div class="shop_bd_home_block_center">
                    <div class="shop_bd_home_block_center_1 imgid"><a href="embroideryBoutique.html"><img src="merchandisePicture/index_1/center.png"/></a></div>
                    <div class="shop_hd_home_block_center_2 imgid"><a href="embroideryBoutique.html"><img src="merchandisePicture/index_1/3-2.png"/></a></div>
                    <div class="shop_hd_home_block_center_3 imgid"><a href="embroideryBoutique.html"><img src="merchandisePicture/index_1/3-3.png"/></a></div>
                </div>
                <!-- 中间 End -->
                
                <!-- 右边商品排行 -->
                <div class="shop_bd_home_block_right">
                    <div class="shop_bd_home_block_right_1 imgid"><a href="embroideryBoutique.html"><img src="merchandisePicture/index_1/1-4.png"/></a></div>
                    <div class="shop_hd_home_block_right_2 imgid"><a href="embroideryBoutique.html"><img src="merchandisePicture/index_1/2-4.png"/></a></div>
                    <div class="shop_hd_home_block_right_3 imgid"><a href="embroideryBoutique.html"><img src="merchandisePicture/index_1/3-4.png"/></a></div>
                </div>
                <!-- 右边商品排行 -->
 </div>
<!--首页产品 END-->
 
<div class="clear"></div>

<!--宽度全屏-->
<div class="long3">
<a href="embroideryCustom.html"><img src="images/06.png" width="990" height="153" /></a>
</div>
<!--宽度全屏 END-->

<!--首页产品-->
<div class="shop_bd_home_block clearfix">
                
                <!-- 左边 -->
                <div class="shop_bd_home_block_left">
                    <div class="shop_bd_home_block_left_4 imgid"><a href="embroideryBoutique.html"><img src="merchandisePicture/index_2/1-1.png"/></a></div>
                    <div class="shop_hd_home_block_left_5 imgid"><a href="embroideryBoutique.html"><img src="merchandisePicture/index_2/3-1.png"/></a></div>
                </div>
                <!-- 左边 End -->
                
                <!-- 中间 -->
                <div class="shop_bd_home_block_center">
                    <div class="shop_hd_home_block_center_4 imgid"><a href="embroideryBoutique.html"><img src="merchandisePicture/index_2/1-2.png"/></a></div>
                    <div class="shop_hd_home_block_center_4 imgid"><a href="embroideryBoutique.html"><img src="merchandisePicture/index_2/2-2.png"/></a></div>
                    <div class="shop_hd_home_block_center_4 imgid"><a href="embroideryBoutique.html"><img src="merchandisePicture/index_2/3-2.png"/></a></div>
                </div>
                <!-- 中间 End -->
                
                <!-- 右边商品排行 -->
                <div class="shop_bd_home_block_right">
                    <div class="shop_bd_home_block_right_4 imgid"><a href="embroideryBoutique.html"><img src="merchandisePicture/index_2/1-3.png"/></a></div>
                    <div class="shop_hd_home_block_right_5 imgid"><a href="embroideryBoutique.html"><img src="merchandisePicture/index_2/3-3.png"/></a></div>
                </div>
                <!-- 右边商品排行 -->
 </div>
<!--首页产品 END-->
 <div class="clear"></div>
<!--宽度全屏-->
<div  class="long3">
<a href="embroideryCustom.html"><img src="images/07.png" width="990" height="175" /></a>
</div>
<!--宽度全屏END-->


<!--首页产品-->
<div class="shop_bd_home_block clearfix">
                <!-- 中间 -->
                <div class="shop_bd_home_block_center2">
                    <div class="shop_bd_home_block_center_5 imgid"><a href="embroideryBoutique.html"><img src="merchandisePicture/index_3/1-1.png"/></a></div>
                    <div class="shop_hd_home_block_center_6 imgid"><a href="embroideryBoutique.html"><img src="merchandisePicture/index_3/2-1.png"/></a></div>
                    <div class="shop_hd_home_block_center_7 imgid"><a href="embroideryBoutique.html"><img src="merchandisePicture/index_3/2-2.png"/></a></div>
                </div>
                <!-- 中间 End -->
                
                <!-- 中间 -->
                <div class="shop_bd_home_block_center2">

                    <div class="shop_hd_home_block_center_6 imgid"><a href="embroideryBoutique.html"><img src="merchandisePicture/index_3/1-2.png"/></a></div>
                    <div class="shop_hd_home_block_center_7 imgid"><a href="embroideryBoutique.html"><img src="merchandisePicture/index_3/1-3.png"/></a></div>
					<div class="clear"></div>
                    <div class="shop_bd_home_block_center_9 imgid"><a href="embroideryBoutique.html"><img src="merchandisePicture/index_3/2-3.png"/></a></div>
                </div>
                <!-- 中间 End -->
 </div>
 <!--首页产品 END--> 
     
</div>
<!--主体 END -->

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
	<script type="text/javascript">
	var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");
	document.write(unescape("%3Cspan id='cnzz_stat_icon_1256370393'%3E%3C/span%3E%3Cscript src='" 
			+cnzz_protocol + "s95.cnzz.com/z_stat.php%3Fid%3D1256370393%26show%3Dpic' type='text/javascript'%3E%3C/script%3E"));
	</script>
        </div>
       <div class="foot_copy"><p>Copyright 2015 itcast Inc.,All rights reserved.</p><p> <img src="images/shi.png"  /></p></div>
</div>
	<!-- Footer End -->
	<script type="text/javascript">
		   /*文章图片轮播*/
		 var PicTotal = 5;
		 var CurrentIndex=0;
		 //var ToDisplayPicNumber = 0;
		 $("div.LunBo div.LunBoNum span").hover(DisplayPic);
		 function DisplayPic() {

		 // 测试是父亲的第几个儿子

		 CurrentIndex = $(this).index();

		 // 删除所有同级兄弟的类属性

		 $(this).parent().children().removeClass("CurrentNum");
		 $(this).parent().children().css("background","linear-gradient(white,blue)").css("border","solid 0px white").css("border-radius","10px");
          
		 // 为当前元素添加类

		 $(this).addClass("CurrentNum");
         $(this).css("background","red");
		 // 隐藏全部图片

		 var Pic = $(this).parent().parent();

		 $(Pic).children("a").hide();

		 // 显示指定图片

		 $(Pic).children("a").eq(CurrentIndex).show();
		 $(Pic).children("a").eq(CurrentIndex).css("display","block");

		 }

		 function PicNumClick() {
			 		 
		 $("div.LunBo div.LunBoNum span").eq(CurrentIndex).trigger("mouseenter");
			
		// $("div.LunBo div.LunBoNum span").css("background","linear-gradient(white,blue)");
		 //$("div.LunBo div.LunBoNum span").eq(CurrentIndex).css("background","red");
		 CurrentIndex = (CurrentIndex + 1) % PicTotal;
         
		 setTimeout("PicNumClick()",1000);
		 }

		 setTimeout("PicNumClick()",1000);
	</script>
</body>
</html>