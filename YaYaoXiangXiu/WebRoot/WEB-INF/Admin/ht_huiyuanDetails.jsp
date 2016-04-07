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
    	 //收货信息
    	$("#consignee").consigneeExclusiveOrder("consigneeID", "exclusiveCustomID", "orderID");
    	 //定制订单评价
    	 $("#exclusiveCustom").consigneeExclusiveOrder("exclusiveCustomID", "consigneeID", "orderID");
    	//普通订单评价
    	$("#order").consigneeExclusiveOrder("orderID", "consigneeID", "exclusiveCustomID");
    	 //登录退出
    	 $("#adminLogout").adminLogout();
    	/**
    	*加载更多实现
    	*/
    	//收货地址加载更多
    	$("#loadMoreConsignee").loadMore("#consigneeTbody tr");
    	//定制订单加载更多
    	$("#loadMoreCustomComment").loadMore("#customCommentTbody tr");
    	//普通订单加载更多
    	$("#loadMoreMerComment").loadMore("#merCommentTbody tr");
    	
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
          <div class="text-right">会员管理员,<s:property value="#Admin.adminName"/>,欢迎您！<div id="adminLogout" class="btn btn-default">退出</div></div>
        </h3>
   </div>
    
   <div class="panel-body">
       <div class="col-md-12" style="text-align:center;">
        <h1>会员详细信息</h1>
        <small><a href="increaseMem.dhtml">返回会员列表</a></small>
       </div>
       <div style="box-shadow:0px 0px 10px #999;border:2px solid #ccc;" class="col-md-offset-3 col-md-6">
       <div style="overflow:auto;"  >
          <table class="table table-striped table-hover table-responsive text-center">
   <thead>
      <tr>
         <th class="text-center">会员类别</th>
         <th class="text-center">会员姓名</th>
         <th class="text-center">会员账号</th>
         <th class="text-center">性别</th>
         <th class="text-center">Email</th>
         
      </tr>
   </thead>
   <tbody id="mem1">
   
   
   <s:set value="#session.ht_Member" var="Member"></s:set>
      <tr>
     
         <td><s:property value="#Member.memberlevel.levelName"/></td>
         <td><s:property value="#Member.memberName"/></td>
         <td><s:property value="#Member.loginName"/></td>
         <td><s:property value="#Member.sex"/></td>
         <td><s:property value="#Member.email"/></td>
         
      </tr>
   
     
   </tbody>
   <thead>
      <tr>
         
         <th class="text-center">注册时间</th>
         <th class="text-center">最近登录时间</th>
         <th class="text-center">收货地址</th>
         <th class="text-center">定制订单评价</th>
         <th class="text-center">普通订单评价</th>
         
      </tr>
   </thead>
    <tbody id="mem2">
   
      <tr>
         <td><s:property value="#Member.regDate"/></td>
         <td><s:property value="#Member.lastDate"/></td>
         <td><a href="javascript:;" id="consignee">收货地址</a></td>
         <td><a href="javascript:;" id="exclusiveCustom">定制订单评价</a></td>
         <td><a href="javascript:;" id="order">普通订单评价</a></td> 
      </tr>
   
     
   </tbody>
</table>
           
   </div>
       </div>
   
</div>
   <div class="panel-footer">
   		<div id="consigneeID">
   <s:set value="#session.aConList"/>
   <s:if test="#session.aConList==null or #session.aConList=={}">
       <div style="text-align:center">
         该用户没有添加收货地址！
       </div>
   </s:if>
   <s:else>
   	<div class="panel-body" style="box-shadow:0px 0px 10px #999;border:2px solid #ccc;">
       <div class="col-md-12" style="text-align:center;">
        <h3>收货地址详细信息</h3>
       </div>
       <div style="overflow:auto;" class="col-md-offset-1 col-md-10">
          <table class="table table-striped table-hover table-responsive text-center">
   <thead>
      <tr>
         <th class="text-center">收货人姓名</th>
         <th class="text-center">电话</th>
         <th class="text-center">手机</th>
         <th class="text-center">邮编</th>
         <th class="text-center">地址</th>
         
      </tr>
   </thead>
   <tbody id="consigneeTbody">
   <s:iterator value="#session.aConList">
      <tr>
         <td><s:property value="receiptName"/></td>
         <td><s:property value="telePhone"/></td>
         <td><s:property value="cellPhone"/></td>
         <td><s:property value="address"/></td>
         <td><s:property value="zip"/></td>   
      </tr>
   </s:iterator>
     
   </tbody>
</table>
<div class="btn btn-default pull-right" id="loadMoreConsignee" style="margin-top: -15px;">点击加载更多</div>
   </div>
   
</div>
    </s:else>       
   		</div><!-- 收货地址 -->
   		<div id="exclusiveCustomID">
  <s:set value="#session.aMemCustomCommentList"/>
   <s:if test="#session.aMemCustomCommentList==null or #session.aMemCustomCommentList=={}">
      <div style="text-align:center;">该用户没有定制订单评价！</div>
   </s:if>
   <s:else>
   		    	<div class="panel-body" style="box-shadow:0px 0px 10px #999;border:2px solid #ccc;">
       <div class="col-md-12" style="text-align:center;">
        <h3>定制订单评价信息</h3>
       </div>
       <div style="overflow:auto;" class="col-md-offset-1 col-md-10">
          <table class="table table-striped table-hover table-responsive text-center">
   <thead>
      <tr>
         <th class="text-center">评价的定制订单</th>
         <th class="text-center">评价印象</th>
         <th class="text-center">评价内容</th>
         <th class="text-center">评价时间</th>
         
      </tr>
   </thead>
   <tbody id="customCommentTbody">
   <s:iterator value="#session.aMemCustomCommentList" var="mc">
      <tr>
         <td>
         	
         <s:iterator value="#session.aExclusiveList" var="el">
         <s:set value="<s:property value='#el.id'/>"></s:set>
         <s:if test="#el.id==#mc.exclusiveCustom.id">
         <s:property value="#el.customCategory"/><br/>
         <img style="width:62px;height:62px;" src="<s:property value="#el.customPicture"/>"><br/>
         订单编号：<s:property value="customOrderNumber"/>
         </s:if>
         </s:iterator>
         	
         </td>
         <td><s:property value="#mc.title"/></td>
         <td><s:property value="content"/></td>
         <td><s:property value="commentDate"/></td>
           
      </tr>
   </s:iterator>
     
   </tbody>
</table>
           <div class="btn btn-default pull-right" id="loadMoreCustomComment" style="margin-top: -15px;">点击加载更多</div>
   </div>
   
</div>
   </s:else>
   		</div><!-- 定制订单评价 -->
   		<div id="orderID">
   <s:set value="#session.aMemMerCommentList"/>
   <s:if test="#session.aMemMerCommentList==null or #session.aMemMerCommentList=={}">
      <div style="text-align:center;">该用户没有普通订单评价！</div>
   </s:if>
   <s:else>
   		  <div class="panel-body" style="box-shadow:0px 0px 10px #999;border:2px solid #ccc;">
       <div class="col-md-12" style="text-align:center;">
        <h3>普通订单评价信息</h3>
       </div>
       <div style="overflow:auto;" class="col-md-offset-1 col-md-10">
          <table class="table table-striped table-hover table-responsive text-center">
   <thead>
      <tr>
         <th class="text-center">评价的订单</th>
         <th class="text-center">评价印象</th>
         <th class="text-center">评价内容</th>
         <th class="text-center">评价时间</th>
         
      </tr>
   </thead>
   <tbody id="merCommentTbody">
   <s:iterator value="#session.aMemMerCommentList" var="mmc">
      <tr>
         <td>
         <s:property value="#mmc.merchandise.merName"/><br/>
         <img style="width:62px;height:62px;" src="<s:property value="#mmc.merchandise.picture"/>"><br/>
         类型：<s:property value="#mmc.merchandise.category.cateName"/><br/>
         尺寸：<s:property value="#mmc.merchandise.merModel"/>
         
         </td>
         <td><s:property value="#mmc.title"/></td>
         <td><s:property value="content"/></td>
         <td><s:property value="commentDate"/></td>
           
      </tr>
   </s:iterator>
     
   </tbody>
</table>
      <div class="btn btn-default pull-right" id="loadMoreMerComment" style="margin-top: -15px;">点击加载更多</div>
   </div>
   
</div>
   </s:else>
   		</div><!-- 普通订单评价 -->
   	
   
   </div>
</div>
   </body>
</html>