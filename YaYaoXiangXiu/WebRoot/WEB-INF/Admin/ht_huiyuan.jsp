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
    	 $(".delMemIndex").delIndex("delMem","$(this).parent().prev().prev().text().trim()","browseMem");
    	 //指定修改
    	$(".updateMemIndex").on("click",function(){
    		
    		var ht_loginName=$(this).parent().prev().prev().text().trim();
    		$("#myModalLabel").text("修改会员");
    		$("[name='ht_memberName']").val($(this).parent().prev().prev().prev().text().trim());
    		$("[name='ht_loginName']").val(ht_loginName);
    		$("[name='ht_loginPwd']").val("");
    		$("[name='ht_email']").val($(this).parent().next().text().trim());
    		$("#myModal form").attr("action","modifyMem.dhtml?mmm="+ht_loginName);
    	   	
    	}); 
    		
    	/**
    	*加载更多实现
    	*/
    	$("#loadMore").loadMore("#memList tr");
    	//全选/全不选
    	$("#allCheckMem").allCheck(".memDelIndex");
    	//批量删除
    	$("#allDelMem").allDelPerson(".memDelIndex","delAllMem","browseMem");
    	//会员查询
    	$("#searchMemBtn").search("searchMem","searchMem","browseMem");
    	//全部会员查询
    	$("#searchAllMemBtn").searchAll("searchAllMem","browseMem");
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
    
   <div class="panel-body ">
       <div class="col-md-1">
        <ul class="nav nav-pills nav-stacked" style="width:120px;border:1px solid #CCC; box-shadow:0px 0px 5px #999;border-radius:3px;">
             <li class="active"><a href="javascript:;" class="glyphicon glyphicon-user">管理会员</a></li>
             <li><a href="javascript:;" id="searchAllMemBtn" class="glyphicon glyphicon-refresh">全部会员</a></li>
             <li><a href="javascript:;" class="glyphicon glyphicon-plus" data-toggle="modal" data-target="#myModal">增加会员</a>
             </li>
             <li><a href="javascript:;" id="allDelMem" class="glyphicon glyphicon-remove">批量删除</a></li>
        </ul>
       </div>
       
       <div class="col-md-offset-1 col-md-10" >
        <label class="control-label">会员查询：</label> 
        <input type="text" id="searchMem" style="border:1px solid #999;width:200px;height:34px;box-shadow:0px 0px 2px #999;border-radius:5px;" placeholder="请输入账号(支持模糊查询)"/>
         <div class="btn btn-default" id="searchMemBtn">查询</div> 
       </div>
       <div style="box-shadow:0px 0px 10px #999;" class="col-md-offset-1 col-md-10">
       <div style="overflow: auto;">
         <table class="table table-striped table-hover table-responsive text-center">
   <caption class="text-center">会员信息</caption>
   <thead>
      <tr>
         <th class="text-center">选择</th>
         <th class="text-center">会员类别</th>
         <th class="text-center">会员姓名</th>
         <th class="text-center">会员账号</th>
         <th class="text-center">详情</th>
         <th class="text-center">操作</th>
      </tr>
   </thead>
   <tbody id="memList">
   
   
   <s:iterator value="#session.aMemList">
      <tr>
         <td>
         <input type="checkbox"  name="memDelIndex" class="memDelIndex" value="<s:property value='id'/>"/>
         </td>
         <td><s:property value="memberlevel.levelName"/></td>
         <td><s:property value="memberName"/></td>
         <td><s:property value="loginName"/></td>
         <td><a style="text-decoration: none;" href="showMem.dhtml?memID=<s:property value='id'/>" class="glyphicon glyphicon-th-list">详情</a></td>
       
         <td>
         <div class="updateMemIndex btn glyphicon glyphicon-pencil" data-toggle="modal" data-target="#myModal">修改</div>
         <div class="delMemIndex btn glyphicon glyphicon-remove">删除</div>
         </td>
         <td hidden="hidden"><s:property value="email"/></td>
         <td hidden="hidden"><s:property value="sex"/></td>
      </tr>
   </s:iterator>
     
   </tbody>
</table>
       </div>
   <s:set value="#session.aMemList"></s:set>
    <s:if test="#session.aMemList==null or #session.aMemList=={}">
    <div style="text-align:center;color:red;">没有查询到记录！</div>
    </s:if>
       <input id="allCheckMem" class="pull-left" type="checkbox" />全选/全不选
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
               添加会员
            </h4>
            <div style="color:red;" class="pull-right">※号为必填项</div>
         </div>
         <div class="modal-body">
           <form action="increaseMem.dhtml" class="form-horizontal row" role="form" method="post">
              <div class="form-group">
                  <label for="ht_loginName" class="col-sm-2 control-label"><span style="color:red;">※</span>账号</label>
              <div class="col-sm-8">
                   <input type="text" class="form-control" name="ht_loginName"  placeholder="请输入会员账号">
              </div>
              </div>
              <div class="form-group">
                   <label for="ht_loginPwd" class="col-sm-2 control-label"><span style="color:red;">※</span>密码</label>
              <div class="col-sm-8">
                   <input type="password" class="form-control" name="ht_loginPwd" placeholder="请输人会员密码">
              </div> 
              </div>
               <div class="form-group">
                   <label for="ht_email" class="col-sm-2 control-label"><span style="color:red;">※</span>邮箱</label>
                   <div class="col-sm-8">
                   <input type="text" class="form-control" name="ht_email"  placeholder="请输入邮箱">
                   </div>
              </div>
               <div class="form-group">
                  <label for="ht_memberName" class="col-sm-2 control-label">姓名</label>
              <div class="col-sm-8">
                   <input type="text" class="form-control" name="ht_memberName"  placeholder="请输入会员名字">
              </div>
              </div>
              <div class="form-group">
                   <label for="ht_sex" class="col-sm-2 control-label">性别</label>
              <div class="col-sm-8" style="line-height:32.4px;">
                  
                  <input type="radio"  name="ht_sex"  value="男" checked="checked">男
                  
                   <input type="radio"  name="ht_sex"  value="女">女
                  
                   <input type="radio"  name="ht_sex"  value="其他" style="display: inline">其他
              
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