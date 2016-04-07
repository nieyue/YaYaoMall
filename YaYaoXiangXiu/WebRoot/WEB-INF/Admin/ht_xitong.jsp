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
    	 //登录退出
    	 $("#adminLogout").adminLogout();
    	 //指定删除
    	$(".delAdminIndex").delIndex("delAdmin","$(this).parent().prev().text().trim()","browseAdmin");
    	 //指定修改
    	$(".updateAdminIndex").on("click",function(){
    		
    		var ht_loginName=$(this).parent().prev().text().trim();
    		$("#myModalLabel").text("修改管理员");
    		$("[name='ht_adminName']").val($(this).parent().prev().prev().text().trim());
    		$("[name='ht_loginName']").val($(this).parent().prev().text().trim());
    		$("[name='ht_loginPwd']").val("");
    		$("[name='ht_adminType']").val($(this).parent().prev().prev().prev().text().trim());
    		$("#myModal form").attr("action","modifyAdmin.dhtml?aaa="+ht_loginName);
    	   	
    	}); 
    		
    	/**
    	*加载更多实现
    	*/
    	$("#loadMore").loadMore("#adminList tr");
    	
    	//全选/全不选
    	$("#allCheckAdmin").allCheck(".adminDelIndex");
    	//批量删除
    	$("#allDelAdmin").allDelPerson(".adminDelIndex","delAllAdmin","browseAdmin");
    	
     });
    </script>
</head>
   <body>
<div class="panel panel-primary" style="padding:0 0px 200px 0;margin:0px auto;border:0px;">
   <div class="panel-heading" style="box-shadow:0px 0px 10px #666;">
      <h3 class="panel-title">
          <div class="h1 text-center">雅耀商城后台管理系统<br/><small style="color:white;">Ya Yao Mall Management System</small></div>
          <span style="color:red;" class="text-center"><s:fielderror value="#session.ht_addAdminError"></s:fielderror></span>
          <s:set value="#session.Admin" id="Admin"></s:set>
          <div class="text-right">系统管理员,<s:property value="#Admin.adminName"/>,欢迎您！<div id="adminLogout" class="btn btn-default">退出</div></div>
        </h3>
   </div>
    
   <div class="panel-body">
       <div class="col-md-2">
        <ul class="nav nav-pills nav-stacked" style="width:120px;border:1px solid #CCC; box-shadow:0px 0px 5px #999;border-radius:3px;">
             <li class="active"><a href="javascript:;" class="glyphicon glyphicon-user">管理管理员</a></li>
             <li><a href="javascript:;" class="glyphicon glyphicon-plus" data-toggle="modal" data-target="#myModal">增加管理员</a>
             </li>
             <li><a href="javascript:;" id="allDelAdmin" class="glyphicon glyphicon-remove">批量删除</a></li>
        </ul>
       </div>
       <div style="box-shadow:0px 0px 10px #999;" class="col-md-offset-1 col-md-8">
       <div style="overflow: auto;">
          <table class="table table-striped table-hover table-responsive text-center">
   <caption class="text-center">管理员信息</caption>
   <thead>
      <tr>
         <th class="text-center">选择</th>
         <th class="text-center">管理员类别</th>
         <th class="text-center">管理员姓名</th>
         <th class="text-center">管理员账号</th>
         <th class="text-center">操作</th>
      </tr>
   </thead>
   <tbody id="adminList">
   
   
   <s:iterator value="#session.adminList">
      <tr>
         <td>
         <input type="checkbox"  name="adminDelIndex" class="adminDelIndex" value="<s:property value='id'/>"/>
         </td>
         <td>
         <s:if test="adminType==1">
                          商品管理员
         </s:if>
         <s:if test="adminType==2">
                          会员管理员
         </s:if>
         <s:if test="adminType==3">
                          订单管理员
         </s:if>
         <s:if test="adminType==4">
                          系统管理员
         </s:if>
         </td>
         <td><s:property value="adminName"/> </td>
         <td><s:property value="loginName"/> </td>
         <td>
         <div class="updateAdminIndex btn glyphicon glyphicon-pencil" data-toggle="modal" data-target="#myModal">修改</div>
         <div class="delAdminIndex btn glyphicon glyphicon-remove">删除</div>
         </td>
      </tr>
   </s:iterator>
  
     
   </tbody>
</table>
       </div>
       <input id="allCheckAdmin" class="pull-left" type="checkbox" />全选/全不选
       <div class="btn btn-default pull-right" id="loadMore" style="margin-top: -15px;">点击加载更多</div>
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
               添加管理员
            </h4>
            <div style="color:red;" class="pull-right">※号为必填项</div>
         </div>
         <div class="modal-body">
           <form action="increaseAdmin.dhtml" class="form-horizontal row" role="form" method="post">
              <div class="form-group">
                  <label for="ht_loginName" class="col-sm-2 control-label"><span style="color:red;">※</span>账号</label>
              <div class="col-sm-8">
                   <input type="text" class="form-control" name="ht_loginName"  placeholder="请输入管理员账号">
              </div>
              </div>
              <div class="form-group">
                   <label for="ht_loginPwd" class="col-sm-2 control-label"><span style="color:red;">※</span>密码</label>
              <div class="col-sm-8">
                   <input type="password" class="form-control" name="ht_loginPwd" placeholder="请输人管理员密码">
              </div> 
              </div>
               <div class="form-group">
                  <label for="ht_adminName" class="col-sm-2 control-label">姓名</label>
              <div class="col-sm-8">
                   <input type="text" class="form-control" name="ht_adminName"  placeholder="请输入管理员名字">
              </div>
              </div>
               <div class="form-group">
                   <label for="ht_adminType" class="col-sm-2 control-label">管理员类别</label>
                   <div class="col-sm-4">
                   <select class="form-control" name="ht_adminType">
                     <option>商品管理员</option>
                     <option>会员管理员</option>
                     <option>订单管理员</option>
                     <option>系统管理员</option>
                   </select>
                   </div>
              </div>
          <div class="form-group text-center">
            <input type="button" class="btn btn-default" 
               data-dismiss="modal" value="关闭">
            
            <input type="submit" class=" btn btn-primary" value="提交"/>
                                   
          </div>
          <s:token></s:token>
              </form>
         </div>
         
         
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>
   
   <div class="panel-footer"></div>
</div>
   </body>
</html>