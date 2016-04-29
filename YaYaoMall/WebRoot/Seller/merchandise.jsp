<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%    
String path = request.getContextPath();    
// 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是 http://localhost:8080/MyApp/）:    
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";    
%> 
<!DOCTYPE html>
<html>
<head>
		<base href="<%=basePath%>">
		<title>商品管理</title>
	<meta content="width=device-width,initial-scale=1.0,maximum-scale=1,user-scalable=no" name="viewport" />	
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<meta name="Keywords" content="系统，管理"/>
	 <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
     <link href="/resources/css/seller.css" rel="stylesheet">
	
    
</head>
   <body>
	
	
       <script src="/resources/js/jquery2.1.js"></script>  
       <script src="/resources/js/bootstrap3.2.0.js"></script>
       <script src="/resources/js/base.js"></script>
   </body>
</html>