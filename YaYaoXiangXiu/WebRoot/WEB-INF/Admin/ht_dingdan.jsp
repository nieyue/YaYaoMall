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
    <script src="js/bootstrap3.2.0.js" type="text/javascript"></script> 
    <script src="js/jquery.customextend.js" type="text/javascript"></script> 
    <style type="text/css">
    .errorMessage{
       list-style:none;
    }
    </style>
    <script type="text/javascript">
     $(function(){
    	 //登录退出
    	 $("#adminLogout").adminLogout(); 
    	 //指定定制订单号删除
    	$(".delCustomOrderIndex").delIndex("delCustomOrder","$(this).parent().prev().prev().prev().prev().text().trim()","customOrder");
    	 //指定普通订单号删除
    	$(".delOrderIndex").delIndex("delOrder","$(this).parent().parent().children().eq(0).children().val().trim()","showAllOrder");
    	
    	 //指定普通订单订单状态修改
    	$(".updateOrderIndex").on("click",function(){
    		var ht_orderStatusID=$(this).attr("id");
    		$("#myModal form").attr("action","updateOrderMer.dhtml?ht_orderStatusID="+ht_orderStatusID);
    	   	
    	}); 
    		
    	/**
    	*加载更多实现
    	*/
    	$("#loadMoreCustomOrder").loadMore("#customOrderListID tr");
    	$("#loadMoreOrder").loadMore("#orderListID tr");
    	
    	//全选/全不选
    	$("#allCheckCustomOrder").allCheck(".customOrderDelIndex");
    	//全选/全不选
    	$("#allCheckOrder").allCheck(".orderDelIndex");
    	//定制订单批量删除
    	$("#allDelCustomOrder").allDelPerson(".customOrderDelIndex","delAllCustomOrder","customOrder");
    	//普通订单批量删除
    	$("#allDelOrder").allDelPerson(".orderDelIndex","delAllOrder","showAllOrder");
    	
    	//定制订单查询
    	$("#searchCustomOrderBtn").search("searchCustomOrder","searchCustomOrder","customOrder");
    	//普通订单查询
    	$("#searchOrderBtn").search("searchOrder","searchOrder","showAllOrder");
    	
    	//全部定制订单查询
    	$("#searchAllCustomOrderBtn").searchAll("realCustomOrder","customOrder");
    	//全部普通订单查询
    	$("#searchAllOrderBtn").searchAll("realOrder","showAllOrder");
    	//订单控制列表切换
    	$("#customOrderControl").control();
    	$("#orderControl").control();
    	//订单列表切换
    	$("#customOrderControl").orderListControl("orderList", "customOrderList");
    	$("#orderControl").orderListControl( "customOrderList","orderList");
    	$.controlSessionStorage("orderList","customOrderList");
     });
    </script>
</head>
   <body>
<div class="panel panel-primary"  style="padding:0 0px 200px 0;margin:0px auto;border:0px;">
   <div class="panel-heading" style="box-shadow:0px 0px 10px #666;">
      <h3 class="panel-title">
          <div class="h1 text-center">雅耀商城后台管理系统<br/><small style="color:white;">Ya Yao Mall Management System</small></div>
          <span style="color:red;" class="text-center"><s:fielderror value="#session.ht_addMemError"></s:fielderror></span>
          <s:set value="#session.Admin" id="Admin"></s:set>
          <div class="text-right">订单管理员,<s:property value="#Admin.adminName"/>,欢迎您！<div id="adminLogout" class="btn btn-default">退出</div></div>
        </h3>
   </div>
    
       <div class="col-md-1">
        <ul class="nav nav-pills nav-stacked" style="width:120px;border:1px solid #CCC; box-shadow:0px 0px 5px #999;border-radius:3px;">
             <li class="active" id="customOrderControl"><a  href="javascript:;" class="glyphicon glyphicon-user">定制订单</a></li>
            
             <li class="hidden"><a href="javascript:;" id="searchAllCustomOrderBtn" class="glyphicon glyphicon-refresh">全部订单</a></li>
             
             <li class="hidden"><a href="javascript:;" id="allDelCustomOrder" class="glyphicon glyphicon-remove">批量删除</a></li>
           
             <li class="active" id="orderControl"><a   href="javascript:;" class="glyphicon glyphicon-user">普通订单</a></li>
            
             <li class="hidden"><a href="javascript:;" id="searchAllOrderBtn" class="glyphicon glyphicon-refresh">全部订单</a></li>
             
             <li class="hidden"><a href="javascript:;" id="allDelOrder" class="glyphicon glyphicon-remove">批量删除</a></li>
        </ul>
           
       </div>
   <div class="panel-body " id="customOrderList" >
       
       <div class="col-md-offset-1 col-md-10" >
        <label class="control-label">定制订单查询：</label> 
        <input type="text" id="searchCustomOrder" style="border:1px solid #999;width:200px;height:34px;box-shadow:0px 0px 2px #999;border-radius:5px;" placeholder="请输入订单编号(支持模糊查询)"/>
         <div class="btn btn-default" id="searchCustomOrderBtn">查询</div> 
       </div>
       <div style="box-shadow:0px 0px 10px #999;" class="col-md-offset-1 col-md-10">
       <div style="overflow: auto;">
         <table class="table table-striped table-hover table-responsive text-center">
   <caption class="text-center">定制订单信息</caption>
   <thead>
      <tr>
         <th class="text-center">选择</th>
         <th class="text-center">订单号</th>
         <th class="text-center">订单类别</th>
         <th class="text-center">定制图片</th>
         <th class="text-center">详情</th>
         <th class="text-center">操作</th>
      </tr>
   </thead>
   <tbody id="customOrderListID">
   
   
   <s:iterator value="#session.exclusiveAllList">
      <tr>
         <td>
         <input type="checkbox"  name="customOrderDelIndex" class="customOrderDelIndex" value="<s:property value='id'/>"/>
         </td>
         <td><s:property value="customOrderNumber"/></td>
         <td><s:property value="customCategory"/></td>
         <td><img style="width:62px;height:62px;" src="<s:property value="customPicture"/>"></td>
         <td><a style="text-decoration: none;" href="showCustomOrder.dhtml?customOrderID=<s:property value='id'/>" class="glyphicon glyphicon-th-list">详情</a></td>
       
         <td>
         <div class="delCustomOrderIndex btn glyphicon glyphicon-remove">删除</div>
         </td>
      </tr>
   </s:iterator>
     
   </tbody>
</table>
       </div>
   <s:set value="#session.exclusiveAllList"></s:set>
    <s:if test="#session.exclusiveAllList==null or #session.exclusiveAllList=={}">
    <div style="text-align:center;color:red;">没有查询到记录！</div>
    </s:if>
    	
       <input id="allCheckCustomOrder" class="pull-left" type="checkbox" />全选/全不选
       <div class="btn btn-default pull-right" id="loadMoreCustomOrder" style="margin-top: -15px;">点击加载更多</div>
       </div>     
   </div>
 
<!-- 普通订单 -->
<div class="panel-body" id="orderList" style="display:none;">
       <div class="col-md-offset-1 col-md-10" >
        <label class="control-label">普通订单查询：</label> 
        <input type="text" id="searchOrder" style="border:1px solid #999;width:200px;height:34px;box-shadow:0px 0px 2px #999;border-radius:5px;" placeholder="请输入订单编号(支持模糊查询)"/>
         <div class="btn btn-default" id="searchOrderBtn">查询</div> 
       </div>
       <div style="box-shadow:0px 0px 10px #999;" class="col-md-offset-1 col-md-10">
       <div style="overflow: auto;">
         <table class="table table-striped table-hover table-responsive text-center">
   <caption class="text-center">普通订单信息</caption>
   <thead>
      <tr>
         <th class="text-center">选择</th>
        <th class="text-center">订单号</th>
         <th class="text-center">订单商品名称</th>
         <th class="text-center">订单商品数量</th>
         <th class="text-center">订单商品总价</th>
         <th class="text-center">详情</th>
         <th class="text-center">操作</th>
      </tr>
   </thead>
   <tbody id="orderListID">
   
   
   <s:iterator value="#session.allOrderMerList">
      <tr>
         <td>
         <input type="checkbox"  name="orderDelIndex" class="orderDelIndex" value="<s:property value='id'/>"/>
         </td>
         <td><s:property value="order.orderNumber"/></td>
         <td><s:property value="merchandise.merName"/></td>
         <td><s:property value="number"/>件</td>
         <td><s:property value="money"/>元</td>
         <td><a style="text-decoration: none;" href="showOrder.dhtml?orderID=<s:property value='id'/>" class="glyphicon glyphicon-th-list">详情</a></td>
       
         <td>
         
         <div style="color:red;">
         <s:if test="orderStatus==1">已经下单</s:if>
         <s:if test="orderStatus==2">已经发货</s:if>
         <s:if test="orderStatus==3">交易完成</s:if>
         </div>
         <div class="updateOrderIndex btn glyphicon glyphicon-pencil" id="<s:property value='id'/>" data-toggle="modal" data-target="#myModal">修改状态</div>
         <div class="delOrderIndex btn glyphicon glyphicon-remove">删除</div>
         </td>
      </tr>
   </s:iterator>
     
   </tbody>
</table>
       </div>
   <s:set value="#session.allOrderMerList"></s:set>
    <s:if test="#session.allOrderMerList==null or #session.allOrderMerList=={}">
    <div style="text-align:center;color:red;">没有查询到记录！</div>
    </s:if>
       <input id="allCheckOrder" class="pull-left" type="checkbox" />全选/全不选
       <div class="btn btn-default pull-right" id="loadMoreOrder" style="margin-top: -15px;">点击加载更多</div>
       </div>     
   </div>
   
   <!-- 模态框（删除Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
              修改订单状态
            </h4>
            
         </div>
         <div class="modal-body">
           <form action="updateOrderMer.dhtml" class="form-horizontal row" role="form" method="post">
            
              <div class="form-group">
              <div class="text-center" style="line-height:32.4px;">
                  
                  <input type="radio"  name="ht_orderStatus"  value="1" checked="checked">已经下单
                  
                   <input type="radio"  name="ht_orderStatus"  value="2">已经发货
                  
                   <input type="radio"  name="ht_orderStatus"  value="3" style="display: inline">交易完成
              
              </div> 
              </div>
          <div class="form-group text-center">
            <input type="button" class="btn btn-default" 
               data-dismiss="modal" value="关闭">
            
            <input type="submit" class=" btn btn-primary" value="确认"/>
                                   
          </div>
              </form>
         </div>
         
         
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>
   
   <div class="panel-footer"></div>
</div>
   </body>
</html>