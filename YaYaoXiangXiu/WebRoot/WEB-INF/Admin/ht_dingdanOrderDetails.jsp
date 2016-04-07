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
		<title>雅耀商城后台管理登陆</title>
	<meta content="width=device-width,initial-scale=1.0,maximum-scale=1,user-scalable=no" name="viewport" />	
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<meta name="Keywords" content="系统，管理，湘绣，陶瓷"/>
	
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/img_effects.js"></script>
    <script src="js/bootstrap3.2.0.js"></script>
    <script src="js/jquery.customextend.js" type="text/javascript"></script>
    <style type="text/css">
    .errorMessage{
       list-style:none;
    }
    </style>
    <script type="text/javascript">
     $(function(){  	
    	 //普通订单收货地址需求信息
    	$("#orderDetails").consigneeExclusiveOrder("orderConsigneeDetailsID", null, null);
    	 //登录退出
    	 $("#adminLogout").adminLogout();
     });
    </script>
</head>
   <body>
<div class="panel panel-primary" style="padding:0 0px 200px 0;margin:0px auto;border:0px;">
   <div class="panel-heading" style="box-shadow:0px 0px 10px #666;">
      <h3 class="panel-title">
          <div class="h1 text-center">雅耀商城后台管理系统<br/><small style="color:white;">Ya Yao Mall Management System</small></div>
          <span style="color:red;" class="text-center"><s:fielderror value="#session.ht_addMemError"></s:fielderror></span>
          <s:set value="#session.Admin" id="Admin"></s:set>
          <div class="text-right">订单管理员,<s:property value="#Admin.adminName"/>,欢迎您！<div id="adminLogout" class="btn btn-default">退出</div></div>
        </h3>
   </div>
   <div class="panel-body">
       <div class="col-md-12" style="text-align:center;">
        <h1>定制订单详细信息</h1>
        <small><a href="customOrder.dhtml">返回订单列表</a></small>
       </div>
       <div style="box-shadow:0px 0px 10px #999;" class="col-md-offset-3 col-md-6">
          <div style="overflow: auto;">
          <table class="table table-striped table-hover table-responsive text-center">
   <thead>
      <tr>
         <th class="text-center">普通订单号</th>
         <th class="text-center">订单商品名称</th>
         <th class="text-center">订单商品单价</th>
         <th class="text-center">订单商品数量</th>
         <th class="text-center">订单商品总价</th>
         
         
      </tr>
   </thead>
   <tbody id="ht_order1">
   
   
   <s:set value="#session.ht_Cartselectedmer" var="ht_Cartselectedmer"></s:set>
      <tr>
     
         <td><s:property value="#ht_Cartselectedmer.order.orderNumber"/></td>
         <td><s:property value="#ht_Cartselectedmer.merchandise.merName"/></td>
         <td><s:property value="#ht_Cartselectedmer.merchandise.price"/>元</td>
         <td><s:property value="#ht_Cartselectedmer.number"/>件</td>
         <td><s:property value="#ht_Cartselectedmer.money"/>元</td>
         
      </tr>
   
     
   </tbody>
   <thead>
      <tr>
         <th class="text-center">普通订单图片</th>
         <th class="text-center">普通订单状态</th>
         <th class="text-center">普通订单下单日期</th>
         <th class="text-center">收货信息</th>
         <th class="text-center">商城会员账号</th>
        
         
      </tr>
   </thead>
    <tbody id="ht_order2">
   
      <tr>
         <td><img src="<s:property value='#ht_Cartselectedmer.merchandise.picture'/>" style="width:62px;height:62px;"/></td>
         <td>
         <s:if test="#ht_Cartselectedmer.orderStatus==1">已经下单</s:if>
         <s:if test="#ht_Cartselectedmer.orderStatus==2">已经发货</s:if>
         <s:if test="#ht_Cartselectedmer.orderStatus==3">交易完成</s:if>
          </td>
         <td><s:property value="#ht_Cartselectedmer.order.orderDate"/></td>
         <td><a href="javascript:;" id="orderDetails">收货信息</a></td>
         <td><s:property value="#ht_Cartselectedmer.order.member.loginName"/></td>
      </tr>
   
     
   </tbody>
</table>
           
          </div>
   </div>
   
</div>
   <div class="panel-footer">
   		<div id="orderConsigneeDetailsID">
   
   <s:if test="#ht_Cartselectedmer.order.consignee==null or #ht_Cartselectedmer.order.consignee=={}">
       <div style="text-align:center">
         该用户没有填写定制需求！
       </div>
   </s:if>
   <s:else>
   	<div class="panel-body">
       <div class="col-md-12" style="text-align:center;">
        <h3>普通订单收货信息</h3>
       </div>
       <div style="box-shadow:0px 0px 10px #999; " class="col-md-offset-3 col-md-6">
     <div style="overflow: auto;">
         <table class="table table-border table-hover">
         	<thead>
         		<tr>
         			<th class="text-center">收货人姓名</th>
         			<th class="text-center">电话</th>
         			<th class="text-center">手机</th>
         			<th class="text-center">收货详细地址信息</th>
         			<th class="text-center">邮编</th>
         		</tr>
         	</thead>
         	<tbody>
         		<tr>
         			<td><s:property value="#ht_Cartselectedmer.order.consignee.receiptName" /></td>
         			<td><s:property value="#ht_Cartselectedmer.order.consignee.telePhone" /></td>
         			<td><s:property value="#ht_Cartselectedmer.order.consignee.cellPhone" /></td>
         			<td><s:property value="#ht_Cartselectedmer.order.consignee.address" /></td>
         			<td><s:property value="#ht_Cartselectedmer.order.consignee.zip" /></td>
         		</tr>
         	</tbody>
         </table>
   </div>
     </div>
   
</div>
    </s:else>       
   		</div><!-- 定制详情 -->
 
 
   </div>
</div>
   </body>
</html>