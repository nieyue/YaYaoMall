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
	<title>哎呀…您访问的页面不存在</title>
<link rel="stylesheet" href="css/base.css" type="text/css" />

<style>
*{margin:0;padding:0}
body{font-family:"微软雅黑";background:#DAD9D7}
</style>

</head>
<body>
<div class="">
	<div class="cont">
		<div class="c1"><img src="images/01.png" class="img1" /></div>
		<h2>哎呀…您访问的页面不存在</h2>
		<h2><a href="index.html" class="home">网站首页</a></h2>
	</div>
</div>
</body>
</html>