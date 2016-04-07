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
	<style type="text/css">
	
	.errorMessage{
       list-style:none;
    }
	</style>
	
</head>
<body style="  background:url(images/ht_bg.jpg) repeat center center;background-size:cover;">
<div ><!-- 整体 -->
	<!-- Header-->
  	 <div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<h3 class="text-center">
					<strong><span class="marker"><strong style="color:green;font-size:36px;">雅耀商城后台管理系统<br/><small style="color:white;">Ya Yao Mall Management System</small></strong></span></strong>
				</h3>
			</div>
		</div>
	</div>
	<div class="row imgid" id="ht_login"  style="width:350px;height:35%;padding:10px;margin:100px auto 200px;border-radius:10px;background-color:green;">
	<form class="form-horizontal" role="form" method="post" action="adminLogin.dhtml">
	<div class="form-group">
    <label for="inputTitle" class="col-sm-7 control-label">用户登陆</label>
  </div>
  
  <div class="form-group">
    <span style="background-color:#801dae;padding:9px;border:1px solid #801dae;margin-right:-5px;border-radius:5px 0 0 5px;color:white;"><span class="glyphicon glyphicon-user"></span></span>
    <input type="text" style="padding:7px;border:1px solid #801dae;margin-right:-5px;border-radius:0 5px 5px 0;" onfocus="this.style='padding:7px;border:1px solid blue;margin-right:-5px;border-radius:0 5px 5px 0;'" onblur="this.style='padding:7px;border:1px solid #801dae;margin-right:-5px;border-radius:0 5px 5px 0;'"  name="ht_loginName" placeholder="账户名">
  </div>
  <div class="form-group">
    <span style="background-color:#801dae;padding:9px;border:1px solid #801dae;margin-right:-5px;border-radius:5px 0 0 5px;color:white;"><span class="glyphicon glyphicon-lock"></span></span>
    <input type="password" style="padding:7px;border:1px solid #801dae;margin-right:-5px;border-radius:0 5px 5px 0;"  onfocus="this.style='padding:7px;border:1px solid blue;margin-right:-5px;border-radius:0 5px 5px 0;'" onblur="this.style='padding:7px;border:1px solid #801dae;margin-right:-5px;border-radius:0 5px 5px 0;'" name="ht_loginPwd" placeholder="账户密码">
    
  </div>
 <div class="form-group">
		<input type="text" name="ht_validate" class="text" size="10" style="border:1px solid #801dae;border-radius:5px;width:53px;"  onfocus="this.style='border:1px solid blue;border-radius:5px;width:53px;'" onblur="this.style='border:1px solid #801dae;border-radius:5px;width:53px;'"> 
		<img src="imageAction" id="yanzhengma" align="absmiddle" style="position:relative;top:-2px;"/> 
			<a onclick="document.getElementById('yanzhengma').src='imageAction.dhtml?'+ Math.random()" style="color:#999;cursor: pointer;text-decoration: none; font-size:16px;">看不清，换一张</a>
 </div>
  <div class="form-group" style="width:240px;text-center;margin:0 auto;">
  		
  		
		 <s:fielderror fieldName="ht_validate" cssStyle="border:1px white solid;color:red;font-size:12px;background-color:#ccc;"/>
  		 <s:fielderror fieldName="adminloginerror" cssStyle="border:1px white solid;color:red;font-size:12px;background-color:#ccc;"/>
   
  </div>
  <div class="form-group">
    <div class=" col-sm-10">
      <input type="submit" style="padding:8px;color:#801dae;font-size:16px;" class="btn btn-default" value="登&nbsp;&nbsp;&nbsp;&nbsp;录"></input>
    </div>
  </div>
</form>
	
	</div>

</div>
</body>
</html>