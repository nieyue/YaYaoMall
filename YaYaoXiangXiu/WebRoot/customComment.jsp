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
	<title>定制评价</title>
	<link rel="stylesheet" href="css/base.css" type="text/css" />
	<link rel="stylesheet" href="css/common.css" type="text/css" />
	<link rel="stylesheet" href="css/style.css" type="text/css" />
	<link rel="stylesheet" href="css/manager.css" type="text/css" />
	<link rel="stylesheet" href="css/list.css" type="text/css" />
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/alertCustom.js" ></script>
    <script type="text/javascript" src="js/topNav_menu.js"></script>

<script type="text/javascript">
$(function(){
	//删除评论
	$("#customComment_tbody a").each(function(){
		$(this).click(function(){
					//alert("删除评论成功！"); 
		if(confirm("确定删除吗？")){
			
			$.post("delCustomComment.dhtml",
				{
			delCustomCommentIndex:$(this).parent().parent().parent().parent().parent().parent().attr("id")
				},
				function(){
					///* setTimeout(function(){
					location.href="customComment.html";
					//},1000); */
			
				});
		}else{
			return false;
		}
		
		});
	});
	//获取图片地址
	$("#customComment_tbody>tr").each(function(){
		
		var cpi=$("#customPictureScriptid"+$(this).attr("id")).html();
		scpi=cpi.substring(14);
		$("#customPictureScriptid"+$(this).attr("id")).html(scpi);
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

	<div class="shop_hd_breadcrumb">
		<strong>当前位置：</strong>
		<span>
			<a href="index.html">首页</a>&nbsp;›&nbsp;
			<a href="memberInformation.html">用户中心</a>&nbsp;›&nbsp;
			<a href="customComment.html">定制评价</a>
		</span>
	</div>
	<div class="clear"></div>

	<!-- Header End -->	

	<!-- 我的个人中心 -->
	<div class="shop_member_bd clearfix">
		<!-- 左边导航 -->
		<div class="shop_member_bd_left clearfix">
			
			<div class="shop_member_bd_left_pic">
				<a href="javascript:void(0);"><img src="images/avatar.png" /></a>
			</div>
			<div class="clear"></div>

			<dl>
				<dt>我的交易</dt>
				<dd><span><a href="ordersList.html">普通订单</a></span></dd>
				<dd><span><a href="customOrdersList.html">定制订单</a></span></dd>
				<!--<dd><span><a href="merchandiseCollection.html">我的收藏</a></span></dd>-->
				<dd><span><a href="comment.html">普通评价</a></span></dd>
				<dd><span><a href="customComment.html">定制评价</a></span></dd>
			</dl>
			<dl>
				<dt>我的账户</dt>
				<dd><span><a href="memberInformation.html">个人资料</a></span></dd>
				<dd><span><a href="memberChangePassword.html">密码修改</a></span></dd>
				<dd><span><a href="manageConsigneeAddress.html">收货地址</a></span></dd>
			</dl>

		</div>
		<!-- 左边导航 End -->
		
		<!-- 右边购物列表 -->
		<div class="shop_member_bd_right clearfix">
			
			<div class="shop_meber_bd_good_lists clearfix">
				<div class="title"><h3>订单列表</h3></div>
				<table>
					<thead class="tab_title">
						<tr>
						<th style="width:80px;"><span>满意度</span></th>
						<th style="width:320px;"><span>评价内容</span></th>
						<th style="width:180px;"><span>评价人</span></th>
						<th style="width:100px;"><span>宝贝信息</span></th>
						<th style="width:115px;"><span>操作</span></th>
						</tr>
					</thead>
					<tbody id="customComment_tbody">
						<s:iterator value="#session.memCustomCommentList">
						<tr id="<s:property value="id" />"><td colspan="5">
							<table class="good" style="height:50px">
								<tbody>
									<tr>
										<td class="pingjia_pic">
										<s:if test="title=='好评!'">
										<img src="images/p1.png" width="24" height="24">
										</s:if>
										<s:if test="title=='中评!'">
										<img src="images/p2.png" width="24" height="24">
										</s:if>
										<s:if test="title=='差评!'">
										<img src="images/p3.png" width="24" height="24">
										</s:if>
										</td>
										<td class="pingjia_title"><span><s:property value="title"/>&nbsp;&nbsp;
										<s:property value="content" /> </span><br />
										[<s:property value="commentDate" />]</td>
										<td class="pingjia_danjia"><strong><s:property value="member.loginName" /> </strong><br/>
										 <strong><s:property value="member.memberlevel.levelName" /> </strong> 
										</td>
										<td class="pingjia_shuliang"><s:property value="exclusiveCustom.customCategory" /> <br />
										 <img  src="<s:property value='exclusiveCustom.customPicture'/>" style="width:62px;height:62px;"/> <br />
										<span id="customPictureScriptid<s:property value="id" />"><s:property value="exclusiveCustom.customPicture" /></span>
										</td>
										<td class="pingjia_caozuo"><a href="javascript:;">删除</a></td>
									</tr>
								</tbody>
							</table>
						</td></tr>
						</s:iterator>
					</tbody>
					
				</table>
						<s:set name="memCustomCommentList" value="#session.memCustomCommentList"></s:set>
	                    <s:if test="#memCustomCommentList==null or #memCustomCommentList.size==0">
						<span style="color:blue;font-size:12px;margin-left:300px;">
						还没有评论，赶紧去评论吧！
						</span>
						</s:if>
			</div>
		</div>
		<!-- 右边购物列表 -->

	</div>

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
