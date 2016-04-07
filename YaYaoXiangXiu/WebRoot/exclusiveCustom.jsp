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
		<title>专属定制</title>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<meta name="Keywords" content="湘绣，收藏，艺术品，文化，陶瓷，刺绣"/>
	<link rel="stylesheet" href="css/base.css" type="text/css" />
	 <script type="text/javascript" src="js/jquery.js" ></script>
	 <script type="text/javascript" src="js/topNav_menu.js"></script>
	 <script type="text/javascript" src="js/jquery.customextend.js"></script>
	 
<script type="text/javascript">
function c(th){
    var inf = document.getElementById('s');
    var fN = '';
    //判断并获取文件名
    if(fN = th.value.match(/[^\\\/]+\.[a-zA-Z0-9]+$/)){
        //如果获取到文件名，则将文件名在后面的span标签中显示出来。
        //这里你可以自行修改要显示的样式等。
        inf.value = fN;
    }else{
        inf.value = "× 获取文件名失败！";
    }
}
$(function(){
	   //file文件改变
    $("#df").on("change",function(e){
    	//过滤图片型号和判断图片大小
    	if(!$.getPhotoSize(this)){
    		return;
    	};
    	$(this).parent().hide();
    	$("#changeIMG").parent().show();
    	//$(this).parent().parent().append("<div>"+context.Request.Files[0].FileName+"</div>");
    	 var file = e.target.files[0];
         var reader = new FileReader(); 
      	reader.onload = function(e){
       //displayImage($('bd'),e.target.result);
       //alert('load');
       //$("#imgPreview").attr({'src':e.target.result});
    	$("#df").parent().parent().next().prepend("<div id='showIMG'><img style='width:50px;height:50px;' src='"+e.target.result+"'/></div>");
      }
      reader.readAsDataURL(file);
    });
	//file更换图片
	$("#changeIMG").click(function(){
		$("#showIMG").remove();
		$("#df").parent().show();
		$(this).parent().hide();
		$("#df").trigger("click");
		
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
	
<div  class="long456">
  <div  class="longer4">	<img src="images/zhuanshu.png" class="tijiaoan" />
<form id="msform" action="addCustom.dhtml" enctype="multipart/form-data" method="post">
	<fieldset>
  <s:fielderror fieldName="fileError" cssStyle="color:red;font-size:12px;"/>
	<select name="customCategory">
	  <option >湘绣定制</option>
	  <option >陶瓷定制</option>
	</select>
		<input type="text" name="customName" placeholder="姓名" />
		<input type="text" name="customPhone" placeholder="电话" />
		
		
		<table width="100%" border="0" cellspacing="0">
  <tr>
    <td width="73%"><input type="text" id="s"  placeholder="上传图样" /></td>
    <td>
    <div class="fbtn">点击上传
    <!-- <input type="button" name="btn" class="next action-button" accept="image/*" value="点击上传"  onclick="document.getElementById('df').click();"/> -->
    <input type="file" name="customPicture" id="df" style="background:url()" accept="image/*" onChange="c(this)" value="点击上传" />
    </div>
    </td>
    <td>
    <div  style="display: none;"><a id='changeIMG'  style='cursor:pointer;color:red;'>更换图片</a></div>
    </td>
    </tr>
</table>

		<textarea cols="" rows="5" style="resize:none;" placeholder="要求简述" name="customDetails"></textarea>
		<input type="button" name="next" class="next action-button" value="提交订制" onclick="document.getElementById('ectj').click();"/>
		<input type="submit"  id="ectj" style="display:none" />
	</fieldset>
	<s:token></s:token>
</form>
  
  
  </div>

</div>	





<!-- Footer -->
<div class="clear"></div>
<div class="foot">
	<div class="faq" style="margin-top:0px;">
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