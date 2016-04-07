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
	<title>管理收货地址</title>
	<link rel="stylesheet" href="css/base.css" type="text/css" />
	<link rel="stylesheet" href="css/common.css" type="text/css" />

	<link rel="stylesheet" href="css/manager.css" type="text/css" />
	<link rel="stylesheet" href="css/dz.css" type="text/css" />
    <script type="text/javascript" src="js/jquery.js" ></script>
    <script type="text/javascript" src="js/topNav.js" ></script>
    <script type="text/javascript" src="js/GlobalProvinces_extend.js" ></script>
    <script type="text/javascript" src="js/GlobalProvinces_main.js" ></script>
    <script type="text/javascript" src="js/initLocation.js" ></script>
    <script type="text/javascript" src="js/alertCustom.js" ></script>
    <script type="text/javascript" src="js/initLocation2.js" ></script>
	<script type="text/javascript" src="js/topNav_menu.js"></script>
	<script type="text/javascript" src="js/img_effects.js"></script>
	<script language="javascript" type="text/javascript">
	
	$(function(){
		$("#manageAddress_ul li a:last-child").each(function(){
			$(this).click(function(){
				if(confirm("确定删除吗？")){
					
				//alert("删除收货地址成功！");
				$.post("delManageConsigneeAddress.dhtml",
						{
					delConsigneeIndex:$(this).parent().parent().attr("id")
						},
						function(){
							
							location.href="manageConsigneeAddress.html";
							
						});
				
				}else{
					return false;
				}
			});
		});
		
		$("#manageAddress_ul li a:first-child").each(function(){
			$(this).click(function(){
				$("#popDiv").show();
				$("#popIframe").show();
				$("#bg").show();
			var mci=$(this).parent().parent().attr("id");
			$("#modifyForm").attr("action","modifyManageConsigneeAddress.dhtml?modifyConsigneeIndex="+mci);
			
			});
		});
			
		$("#closeDiv").click(function(){
			$("#popDiv").hide();
			$("#bg").hide();
			$("#popIframe").hide();
		});
	});
</script>
</head>
<body>
<form id="modifyForm" action="modifyManageConsigneeAddress.dhtml" method="post">
<div id="popDiv" class="mydiv" style="display:none;">

<table width="450" height="180" border="0" cellspacing="0">
  <tr bgcolor="#555" style="color:#FFFFFF;">
    <td width="100" height="30" style="font-size:13px;">编辑地址</td>
    <td width="40">&nbsp;</td>
    <td width="200">&nbsp;</td>

    <td width="40" >&nbsp;</td>
    <td width="40" class="guan"><a href="javascript:;" id="closeDiv">关闭</a></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>姓名</td>
    <td align="left"><input type="text" class="form-text inputid" name="modifyReceiptName"/></td>

    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>

  <tr>
    <td>&nbsp;</td>
    <td>电话</td>
     <td  align="left"><input type="text" class="form-text inputid" name="modifyTelePhone"/></td>

    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>地址</td>
    <td  align="left"> 	<select id="modifysheng" name="modifyProvince" >
											<!-- <option value="">广东</option> -->
									</select>
									<select id="modifyshi" name="modifyCity">
										<!-- <option value="">广州</option> -->
									</select>
									<select id="modifyxian" name="modifyCountry">
										<!-- <option value="">天河</option> -->
									</select>
									<select id="modifyxiang" name="modifyStreet" >
									 <!-- <option value="">--</option> -->
									</select>
									</td>

    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td  align="left"><input type="text" class="form-text inputid"  name="modifyAddress"/></td>

    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td  align="left">
    <input type="button" id="hid" style="display: none"/>
    <input id="isubmit" type="submit" class="form-submit" value="保存修改"/>
    <!-- <a id="asubmit" href="javascript:;" class="form-submit">保存修改</a> --></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
				
</div>
<s:token></s:token>
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
			<a href="manageConsigneeAddress.html">收货地址</a>
		</span>
	</div>
	<div class="clear"></div>


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
				<div class="title"><h3>管理收货地址<a style="float:right;" href="javascript:;" id="new_add_shdz_btn">新增收货地址</a></h3></div>
				<div class="clear"></div>
			<!-- 收货人地址 Title End -->
			<div class="shop_bd_shdz clearfix">
				<div class="shop_bd_shdz_lists clearfix">
					<ul id="manageAddress_ul">
					<%-- 	<li><label><span><input type="radio" name="radiobutton" value="radiobutton"></span></label><em>广东</em><em>广州市</em><em>天河区</em><em>东圃大街</em><em>雅耀(收)</em><em>1336699232</em><span class="admin_shdz_btn"><a href="javascript:showDiv()">编辑</a><a href="">删除</a></span></li>

						<li><label><span><input type="radio" name="radiobutton" value="radiobutton"></span></label><em>广东</em><em>广州市</em><em>天河区</em><em>东圃大街</em><em>雅耀(收)</em><em>1336699232</em><span class="admin_shdz_btn"><a href="javascript:showDiv()">编辑</a><a href="">删除</a></span></li>

						<li><label><span><input type="radio" name="radiobutton" value="radiobutton"></span></label><em>广东</em><em>广州市</em><em>天河区</em><em>东圃大街</em><em>雅耀(收)</em><em>1336699232</em><span class="admin_shdz_btn"><a href="javascript:showDiv()">编辑</a><a href="">删除</a></span></li> --%>
		<s:set name="conList" value="#session.conList"></s:set>
	    <s:if test="#conList==null or #conList.size==0">
	        <span style="color:blue;font-size:12px;margin-left:300px;">
	                         还没有添加收货地址，赶紧添加吧！
			</span>   
	    </s:if>
		<s:iterator value="#session.conList">
		    <s:if test="hasOrder==0 or hasOrder==1">
			<li id="<s:property value="id" />"> <label><span><input type="radio" name="radiobutton" value="radiobutton"></span></label>
			<em><s:property value="address" /></em>
			<em>电话:<s:property value="telePhone" /></em>
			<em>手机:<s:property value="cellPhone" /></em>
			<span class="admin_shdz_btn">
			<a href="javascript:;">编辑</a>
			<a href="javascript:;">删除</a></span></li>
		    </s:if>
			
		</s:iterator>
						
					</ul>
				</div>
				<!-- 新增收货地址 -->
				<div id="new_add_shdz_contents" style="display:none;" class="shop_bd_shdz_new clearfix">
					<div class="title">新增收货地址</div>
					<div class="shdz_new_form">
						<form action="manageConsigneeAddress.dhtml" method="post">
							<ul>
								<li><label for=""><span>*</span>收货人姓名：</label>
								<input type="text" class="name inputid" name="receiptName" /></li>
								<li><label for=""><span>*</span>所在地址：</label>
									<select id="sheng" name="province">
										<!-- <option value="">广东</option> -->
									</select>省
									<select id="shi" name="city">
										<!-- <option value="">广州</option> -->
									</select>市
									<select id="xian" name="country">
										<!-- <option value="">天河</option> -->
									</select>县
									<select id="xiang" name="street" >
									<%-- 
									 <option value="">--</option>
									 --%>
									</select>镇或街道 
								</li>
								<li><label for=""><span>*</span>详细地址：</label>
								<input type="text" class="xiangxi inputid" name="address"/></li>
								<li><label for=""><span></span>邮政编码：</label>
								<input type="text" class="youbian inputid" name="zip"/></li>
								<li><label for=""><span></span>电话：</label>
								<input type="text" class="dianhua inputid" name="telePhone"/></li>
								<li><label for=""><span></span>手机号：</label>
								<input type="text" class="shouji inputid" name="cellPhone"/></li>
								<li><label for="">&nbsp;</label><input type="submit" value="增加收货地址" /></li>
							</ul>
							<s:token></s:token>
						</form>
					</div>
				</div>
				<!-- 新增收货地址 End -->
			</div>
			<div class="clear"></div>
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
	<script type="text/javascript">
	$(function(){
		$("#new_add_shdz_btn").click(function(){
			if($("#new_add_shdz_contents").is(":visible")){
			$("#new_add_shdz_contents").hide(500);}
			else{
			$("#new_add_shdz_contents").show(500);
			}
		});
	});
	
	$(function(){
		initLocation(
			{sheng_val:"湖南",shi_val:"长沙",
			xian_val:"长沙市"});
		initLocation2(
			{modifysheng_val:"湖南",modifyshi_val:"长沙",
				modifyxian_val:"长沙市"});
		});
	</script>
</body>
</html>