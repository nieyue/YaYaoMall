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
    	 //定制订单详细需求信息
    	$("#customDetails").consigneeExclusiveOrder("customDetailsID", null, null);
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
         <th class="text-center">定制订单号</th>
         <th class="text-center">定制订单类别</th>
         <th class="text-center">定制人姓名</th>
         <th class="text-center">定制人电话</th>
         
         
      </tr>
   </thead>
   <tbody id="ht_ExclusiveCustom1">
   
   
   <s:set value="#session.ht_ExclusiveCustom" var="ht_ExclusiveCustom"></s:set>
      <tr>
     
         <td><s:property value="#ht_ExclusiveCustom.customOrderNumber"/></td>
         <td><s:property value="#ht_ExclusiveCustom.customCategory"/></td>
         <td><s:property value="#ht_ExclusiveCustom.customName"/></td>
         <td><s:property value="#ht_ExclusiveCustom.customPhone"/></td>
         
      </tr>
   
     
   </tbody>
   <thead>
      <tr>
         <th class="text-center">定制图片</th>
         <th class="text-center">定制日期</th>
         <th class="text-center">定制需求</th>
         <th class="text-center">定制人的商城账号</th>
        
         
      </tr>
   </thead>
    <tbody id="ht_ExclusiveCustom2">
   
      <tr>
         <td><img src="<s:property value='#ht_ExclusiveCustom.customPicture'/>" style="width:62px;height:62px;"/></td>
         <td><s:property value="#ht_ExclusiveCustom.customDate"/></td>
         <td><a href="javascript:;" id="customDetails">定制需求</a></td>
         <td><s:property value="#ht_ExclusiveCustom.member.loginName"/></td>
      </tr>
   
     
   </tbody>
</table>
           
       </div>
   </div>
   
</div>
   <div class="panel-footer">
   		<div id="customDetailsID">
   
   <s:if test="#ht_ExclusiveCustom.customDetails==null or #ht_ExclusiveCustom.customDetails=={}">
       <div style="text-align:center">
         该用户没有填写定制需求！
       </div>
   </s:if>
   <s:else>
   	<div class="panel-body row">
       <div class="col-md-12" style="text-align:center;">
        <h3>定制需求详细信息</h3>
       </div>
       <div style="box-shadow:0px 0px 10px #999; padding:30px 100px;" class="col-md-offset-3 col-md-6">
       <div style="overflow: auto;">
         <s:property value="#ht_ExclusiveCustom.customDetails"/>
       </div>
   </div>
   
</div>
    </s:else>       
   		</div><!-- 定制详情 -->
 
 
   </div>
</div>
   </body>
</html>