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
	<title>订单列表</title>
	<link rel="stylesheet" href="css/base.css" type="text/css" />
	<link rel="stylesheet" href="css/common.css" type="text/css" />
	<link rel="stylesheet" href="css/manager.css" type="text/css" />
	<link rel="stylesheet" href="css/zzsc.css" type="text/css" />
    <script type="text/javascript" src="js/jquery.js" ></script>
    <script type="text/javascript" src="js/topNav.js" ></script>
	<script type="text/javascript" src="js/topNav_menu.js"></script>
	<script language="javascript" type="text/javascript">
	
//评价定制订单
$(function(){
	$("#customOrderList_tbody tr .pingjia").each(function(){
		$(this).click(function(){
			$("#popDiv").show();
			$("#popIframe").show();
			$("#bg").show();
		var cci=$(this).parent().parent().parent().parent().parent().parent().attr("id");
		$("#customCommentForm").attr("action","addCustomComment.dhtml?customCommentIndex="+cci);
		//$(this).parent().html("已评价");
		//$(this).remove();
		});
	});
	
	//删除定制订单
	$("#customOrderList_tbody tr .shanchu").each(function(){
		$(this).click(function(){		
		if(confirm("确定删除吗？")){
			
			$.post(
				"delCustom.dhtml",
				{
		 delCustomIndex:$(this).parent().parent().parent().parent().parent().parent().attr("id"),
				},
				function(){
					location.href="exclusiveCustomCancelSuccess.html";
				});
		}else{
			return false;
		}
		});
	});
	//截取图片地址
	 $("#customOrderList_tbody>tr").each(function(){
		
	var cpi=$("#customPictureid"+$(this).attr("id")).attr("src");
	scpi=cpi.substring(14);
	$("#customPictureScriptid"+$(this).attr("id")).html(scpi);
	}); 
	//关闭
	$("#closeDiv").click(function(){
		$("#popDiv").hide();
		$("#bg").hide();
		$("#popIframe").hide();
	});
});
</script>
</head>
<body>
<form id="customCommentForm" action="addCustomComment.dhtml" method="post">
<div id="popDiv" class="mydiv" style="display:none;">

<table width="450" height="180" border="0" cellspacing="0">
  <tr bgcolor="#555" style="color:#FFFFFF;">
    <td width="60" height="30" style="font-size:13px;">评价</td>
    <td width="40">&nbsp;</td>
    <td width="200">&nbsp;</td>

    <td width="40" >&nbsp;</td>
    <td width="40" class="guan"><a href="javascript:;" id="closeDiv">关闭</a></td>
  </tr>
	<tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td align="left"><table width="200" border="0" cellspacing="0">
      <tr>
        <td width="20"><label>
          <input type="radio" name="radioComment" value="好评!">
        </label></td>
        <td width="50"><img src="images/p1.png" width="24" height="24"></td>
        <td width="20"><input type="radio" name="radioComment" value="中评!"></td>
        <td width="50"><img src="images/p2.png" width="24" height="23"></td>
        <td width="20"><input type="radio" name="radioComment" value="差评!"></td>
        <td><img src="images/p3.png" width="24" height="20"></td>
      </tr>
    </table></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>

  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td  align="left"><textarea cols="40" name="contentComment" rows="5" class="form-text"></textarea></td>

    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td  align="left"><input name="submit" type="submit" class="form-submit" value="保存修改" /></td>

    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  
  
</table>
				
</div><s:token></s:token>
</form>

<div id="bg" class="bg" style="display:none;"></div>
<iframe id='popIframe' class='popIframe' frameborder='0' ></iframe>
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
			<a href="customOrdersList.html">定制订单</a>
		</span>
	</div>
	<div class="clear"></div>
	<!-- 面包屑 End -->

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
						<th style="width:180px;"><span>商品信息</span></th>
						<th style="width:75px;"><span>单价</span></th>
						<th style="width:50px;"><span>数量</span></th>
						<th style="width:80px;"><span>订单总价</span></th>
						<th style="width:160px;"><span>状态与操作</span></th>
					  </tr>
 					</thead>
					<tbody id="customOrderList_tbody">
					<s:iterator value="#session.exclusiveList" >
						<tr id="<s:property value="id" />"><td colspan="5">
							<table class="good">
								<thead >
									<tr>
									  <th colspan="7">
										<span><strong>订单号码：</strong><s:property value="customOrderNumber" /></span>	</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td class="dingdan_pic"><img id="customPictureid<s:property value="id" />" src="<s:property value="customPicture" />" /></td>
										<td class="dingdan_title" style="text-align:center;"><span style="color:red"><s:property value="customCategory" /></span><br /><span id="customPictureScriptid<s:property value="id" />"></span></td>
										<td class="dingdan_danjia">￥<strong>待商定</strong></td>
										<td class="dingdan_shuliang">1</td>
										<td class="dingdan_zongjia">￥<strong>待商定</strong><br />(免运费)</td>

										<td class="digndan_caozuo"><a class="shanchu" href="javascript:;" style="color:red;text-decoration:none;">删除订单</a></td>
									    <td class="digndan_caozuo">
									    <a class="pingjia" href="javascript:;" style="text-decoration:none;">评价</a></td>
									</tr>
								</tbody>
							</table>
						</td></tr>
					</s:iterator>
					
					</tbody>
				</table>
						<s:set name="exclusiveList" value="#session.exclusiveList"></s:set>
	                    <s:if test="#exclusiveList==null or #exclusiveList.size==0">
						<span style="color:blue;font-size:12px;margin-left:300px;">
						还没有添加订单，赶紧去定制吧！
						</span>
						</s:if>
			</div>
		</div>
		<!-- 右边购物列表 End -->

	</div>
	<!-- 我的个人中心 End -->

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
