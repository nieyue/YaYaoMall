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
    .fbtn{
      width:30%;
      height:30%;
      left:35%;
      display:inline-block;
      border:1px solid #ccc;
      border-radius:25px;
      background:blueviolet;
      color:white;
      text-align:center;
      overflow:hidden;
      position:relative;
      cursor: pointer;
    }
   .fbtn:hover{
   border:1px solid white;
   width:30%;
   height:30%;
   background-color:green;
   left:35%;
   } 
  input[type=file]{
  	  font-size: 118px;
      width:100%;
      height:100%;
      cursor: pointer;
      position: absolute;
      right: 0;top: 0;
      opacity: 0;
      filter:alpha(opacity=0);
  }
    </style>
    <script type="text/javascript">
     $(function(){
    	 //登录退出
    	 $("#adminLogout").adminLogout(); 
    	 //指定商品类别删除
    	$(".delMerCategoryIndex").delIndex("delMerCategory","$(this).parent().prev().prev().prev().children().val().trim()","showAllCategory");
    	 //指定商品删除
    	$(".delMerchandiseIndex").delIndex("delMerchandise","$(this).prev().prev().attr('id').trim()","showAllMerchandise");
    	 //指定商品类型修改
    	$(".updateMerCategoryIndex").on("click",function(){
    		var ht_cateID=$(this).parent().prev().prev().prev().children().val().trim();
    		$("#myModalLabel").html("修改商品类别");
    		$("#myMerCategoryModal form").attr("action","updateMerCategory.dhtml?ht_cateID="+ht_cateID);
    	   	
    	}); 
    	 //指定商品修改
    	$(".updateMerchandiseIndex").on("click",function(){
    		var ht_merID=$(this).prev().attr("id");
    		$("#myMerModalLabel").html("修改商品");
    		$("#myMerModal form").attr("action","updateMerchandise.dhtml?ht_merID="+ht_merID);
    	}); 
    		
    	/**
    	*加载更多实现
    	*/
    	$("#loadMoreMerCategory").loadMore("#merCategoryListID tr");
    	$("#loadMoreMerchandise").loadMore("#merchandiseListID tr");
    	
    	//全选/全不选
    	$("#allCheckMerCategory").allCheck(".merCategoryDelIndex");
    	//全选/全不选
    	$("#allCheckMerchandise").allCheck(".merchandiseDelIndex");
    	//商品类型批量删除
    	$("#allDelMerCategory").allDelPerson(".merCategoryDelIndex","delAllMerCategory","showAllCategory");
    	//商品批量删除
    	$("#allDelMerchandise").allDelPerson(".merchandiseDelIndex","delAllMerchandise","showAllMerchandise");
    	//商品查询
    	$("#searchMerchandiseBtn").search("searchMerchandise","searchMerchandise","showAllMerchandise");
    	
    	//商品类型查询
    	$("#searchAllMerCategoryBtn").searchAll("realAllCategory","showAllCategory");
    	//商品查询
    	$("#searchAllMerchandiseBtn").searchAll("realAllMerchandise","showAllMerchandise");
    	//商品类别、商品控制列表切换
    	$("#merCategoryControl").control();
    	$("#merchandiseControl").control();
    	//商品类别、商品列表切换
    	$("#merCategoryControl").orderListControl("merchandiseList", "merCategoryList");
    	$("#merchandiseControl").orderListControl( "merCategoryList","merchandiseList");
    	$.controlSessionStorage("merchandiseList","merCategoryList");
    	//商品类别详细描述
    	$(".merCategoryDesc").hover(function(){
    		var cdt="012345678901234567890123456789";
    		var newCateDescText="";
    		var cateDescText=$(this).text();
    		for (var i = 0; i < cateDescText.length; i++) {
    			for (var j = 0; j < cdt.length; j++) {
    			if(newCateDescText.length==20*cdt[j]){
    			newCateDescText+="<br/>";
    				}
				}
    			newCateDescText+=cateDescText[i];
			}
    		$(this).html(newCateDescText);
    		$(this).parent().next().children().hide();
    		$(this).css({"overflow":"visible","display":"inline-block","margin-top":"-25px"});
    	},function(){
    		$(this).parent().next().children().show();
    		$(this).text($(this).text());
    		$(this).css({"display":"inline-block","white-space":"nowrap","width":"10em","overflow":"hidden","text-overflow":"ellipsis","margin-top":"0px"});
    		
    	});
    	//商品描述
    	$(".merchandiseDescID").on("click",function(){
    		//ajax方法获取，损耗服务器
    		/* 
    		var merchandiseID=$(this).parent().attr("id");
    		$.get("showMerchandiseDesc.dhtml",{merID:merchandiseID},function(data){
    			$("#myMerchandiseModalLabel").text(data[0].merName+"的商品描述");
    			$("#myMerchandiseModal .modal-body").html("<div style='text-indent:2em;'>"+data[0].merDesc+"</div>");
    		},"json"); */
    		//session中获取
    			var $this=$(this);
    			$("#myMerchandiseModalLabel").text($this.parent().parent().prev().prev().prev().prev().text()+"的商品描述");
    			$("#myMerchandiseModal .modal-body").html("<div style='text-indent:2em;'>"+$this.next().text()+"</div>");
    	});
    	//商品特价使input失效
    	/* $("input[name='ht_special']").on("click",function(){
    		if($(this).val()==2){
    	$("input[name='ht_sPrice']").attr("disabled",false);
    	}else if($(this).val()==1){
    	$("input[name='ht_sPrice']").attr("disabled",true);
    		
    	}
    		}); */
    //file文件改变
    $("#df").on("change",function(e){
    	//过滤图片型号和判断图片大小
    	if(!$.getPhotoSize(this)){
    		return;
    	};
    	$(this).parent().hide();
    	$("#changeIMG").parent().show();
    	//$(this).parent().parent().append("<div>"+context.Request.Files[0].FileName+"</div>");
    	 var file = e.target.files[0];
         var reader = new FileReader(); 
      	reader.onload = function(e){
       //displayImage($('bd'),e.target.result);
       //alert('load');
       //$("#imgPreview").attr({'src':e.target.result});
    	$("#df").parent().parent().prepend("<div id='showIMG'><img class='form-control'style='height:150px;' src='"+e.target.result+"'/></div>");
      
      	}
      reader.readAsDataURL(file);
    });
	//file更换图片
	$("#changeIMG").click(function(){
		$("#showIMG").remove();
		$("#df").parent().show();
		$(this).parent().hide();
		$("#df").trigger("click");
		
	});
     });
    </script>
</head>
   <body>
<div class="panel panel-primary" style="padding:0 0px 200px 0;margin:0px auto;border:0px;">
   <div class="panel-heading" style="box-shadow:0px 0px 10px #666;">
      <h3 class="panel-title">
          <div class="h1 text-center">雅耀商城后台管理系统<br/><small style="color:white;">Ya Yao Mall Management System</small></div>
          <span style="color:red;" class="text-center">
          <s:fielderror value="#session.ht_addMerCategoryError"></s:fielderror>
          </span>
          <s:set value="#session.Admin" id="Admin"></s:set>
          <div class="text-right">商品管理员,<s:property value="#Admin.adminName"/>,欢迎您！<div id="adminLogout" class="btn btn-default">退出</div></div>
        </h3>
   </div>
    
       <div class="col-md-1">
        <ul class="nav nav-pills nav-stacked" style="width:120px;border:1px solid #CCC; box-shadow:0px 0px 5px #999;border-radius:3px;">
             <li class="active" id="merCategoryControl"><a  href="javascript:;" class="glyphicon glyphicon-user">商品类别</a></li>
            
             <li class="hidden"><a href="javascript:;" id="searchAllMerCategoryBtn" class="glyphicon glyphicon-refresh">全部类别</a></li>
             <li class="hidden"><a href="javascript:;" id="addMerCategoryBtn" class="glyphicon glyphicon-plus" data-toggle="modal" data-target="#myMerCategoryModal" >增加类别</a></li>
             
             <li class="hidden"><a href="javascript:;" id="allDelMerCategory" class="glyphicon glyphicon-remove">批量删除</a></li>
           
             <li class="active" id="merchandiseControl"><a   href="javascript:;" class="glyphicon glyphicon-user">商品管理</a></li>
            
             <li class="hidden"><a href="javascript:;" id="searchAllMerchandiseBtn" class="glyphicon glyphicon-refresh">全部商品</a></li>
             <li class="hidden"><a href="javascript:;" id="addMerchandiseBtn" class="glyphicon glyphicon-plus" data-toggle="modal" data-target="#myMerModal" >增加商品</a></li>
             
             <li class="hidden"><a href="javascript:;" id="allDelMerchandise" class="glyphicon glyphicon-remove">批量删除</a></li>
        </ul>
           
       </div>
   <div class="panel-body " id="merCategoryList" >
       
       <div style="box-shadow:0px 0px 10px #999;" class="col-md-offset-1 col-md-10">
       <div style="overflow:auto;">
         <table class="table table-striped table-hover table-responsive text-center">
   <caption class="text-center">商品类型信息</caption>
   <thead>
      <tr>
         <th class="text-center">选择</th>
         <th class="text-center">商品类型</th>
         <th class="text-center">商品类型描述</th>
         <th class="text-center">操作</th>
  
      </tr>
   </thead>
   <tbody id="merCategoryListID">
   
   
   <s:iterator value="#session.cateList">
      <tr>
         <td>
         <input type="checkbox"  name="merCategoryDelIndex" class="merCategoryDelIndex" value="<s:property value='id'/>"/>
         </td>
         <td><s:property value="cateName"/></td>
         <td><div style="display:inline-block; white-space:nowrap;width:10em;overflow: hidden;text-overflow:ellipsis;" class="merCategoryDesc"><s:property value="cateDesc"/></div></td>
         <td>
         <div class="updateMerCategoryIndex btn glyphicon glyphicon-pencil" data-toggle="modal" data-target="#myMerCategoryModal">修改</div>
         <div class="delMerCategoryIndex btn glyphicon glyphicon-remove">删除</div>
         </td>
      </tr>
   </s:iterator> 
     
   </tbody>
</table>
       </div>
    <s:set value="#session.cateList"></s:set>
    <s:if test="#session.cateList==null or #session.cateList=={}">
    <div style="text-align:center;color:red;">没有查询到记录！</div>
    </s:if> 
       <input id="allCheckMerCategory" class="pull-left" type="checkbox" />全选/全不选
       <div class="btn btn-default pull-right" id="loadMoreMerCategory" style="margin-top: -15px;">点击加载更多</div>
       </div>     
   </div>
 
<!-- 商品 -->
<div class="panel-body " id="merchandiseList" style="display:none;">
       <div class="col-md-offset-1 col-md-10" >
        <label class="control-label">商品查询：</label> 
        <input type="text" id="searchMerchandise" style="border:1px solid #999;width:200px;height:34px;box-shadow:0px 0px 2px #999;border-radius:5px;" placeholder="请输入商品名称(支持模糊查询)"/>
         <div class="btn btn-default" id="searchMerchandiseBtn">查询</div> 
       </div>
       <div style="box-shadow:0px 0px 10px #999;" class="col-md-offset-1 col-md-10">
       <div style="overflow:auto;">
         <table class="table table-striped table-hover table-responsive text-center">
   <caption class="text-center">商品信息</caption>
   <thead>
      <tr>
         <th class="text-center">选择</th>
         <th class="text-center">商品类型</th>
        <th class="text-center">商品名称</th>
         <th class="text-center">商品单价</th>
         <th class="text-center">商品型号</th>
         <th class="text-center">商品图片</th>
         <th class="text-center">操作</th>
      </tr>
   </thead>
   <tbody id="merchandiseListID">
 <s:iterator value="#session.merList">
      <tr>
         <td>
         <input type="checkbox"  name="merchandiseDelIndex" class="merchandiseDelIndex" value="<s:property value='id'/>"/>
         </td>
         <td><s:property value="category.cateName"/></td>
         <td><s:property value="merName"/></td>
         <td><s:property value="price"/>元</td>
         <td><s:property value="merModel"/></td>
         <td><img width="62px" height="62px" class="uploadIMG" src="<s:property value='picture'/>" /></td>
       
         <td>
         <div id="<s:property value='id'/>">
         <a class="glyphicon glyphicon-list merchandiseDescID" data-toggle="modal" data-target="#myMerchandiseModal" style="cursor:pointer" >商品描述</a>
         <div class="hidden"><s:property value="merDesc"/></div>
         </div>
         <div class="updateMerchandiseIndex btn glyphicon glyphicon-pencil" data-toggle="modal" data-target="#myMerModal">修改</div>
         <div class="glyphicon glyphicon-remove delMerchandiseIndex btn">删除</div>
         </td> 
      </tr>
   </s:iterator>
     
   
   </tbody>
</table>
       </div>
  <s:set value="#session.merList"></s:set>
    <s:if test="#session.merList==null or #session.merList=={}">
    <div style="text-align:center;color:red;">没有查询到记录！</div>
    </s:if> 
       <input id="allCheckMerchandise" class="pull-left" type="checkbox" />全选/全不选
       <div class="btn btn-default pull-right" id="loadMoreMerchandise" style="margin-top: -15px;">点击加载更多</div>
       </div>     
   </div>
   
   <!-- 商品类别模态框（删除Modal） -->
<div class="modal fade" id="myMerCategoryModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
              增加商品类别
            </h4>
            
         </div>
         <div class="modal-body">
           <form action="addMerCategory.dhtml" class="form-horizontal row" role="form" method="post">
            
              <div class="form-group"> 
              <label class="control-label col-sm-3">商品类别名：</label>
              <div class="col-sm-8" style="line-height:32.4px;">
                  <input type="text" class="form-control" name="ht_cateName"/>
              </div> 
              </div>
              <div class="form-group">
              <label class="control-label col-sm-3">商品类别描述：</label>
              <div class="col-sm-8" style="line-height:32.4px;">
                  <textarea class="form-control" name="ht_cateDesc" rows="" cols="" style="resize:vertical;"></textarea>
              </div> 
              </div>
          <div class="form-group text-center">
            <input type="button" class="btn btn-default" 
               data-dismiss="modal" value="关闭">
            
            <input type="submit" class=" btn btn-primary" value="确认"/>
                                   
          </div>
          <s:token></s:token>
              </form>
         </div>
         
         
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>
   <!-- 商品模态框（删除Modal） -->
<div class="modal fade" id="myMerModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myMerModalLabel">
              增加商品
            </h4>
            
         </div>
         <div class="modal-body">
           <form action="addMerchandise.dhtml" class="form-horizontal row" role="form" method="post" enctype="multipart/form-data">
              <div class="form-group"> 
              <label class="control-label col-sm-3">商品类型：</label>
              <div class="col-sm-8" style="line-height:32.4px;">
                 <s:select name="ht_category" cssClass="form-control" list="#session.cateList" listKey="id" listValue="cateName" headerKey="0" headerValue="请选择商品类型" ></s:select>
              </div> 
              </div>
              <div class="form-group"> 
              <label class="control-label col-sm-3">商品名称：</label>
              <div class="col-sm-8" style="line-height:32.4px;">
                  <input type="text" class="form-control" name="ht_merName"/>
              </div> 
              </div>
              <div class="form-group"> 
              <label class="control-label col-sm-3">商品型号：</label>
              <div class="col-sm-8" style="line-height:32.4px;">
                  <input type="text" class="form-control" name="ht_merModel"/>
              </div> 
              </div>
              <div class="form-group"> 
              <label class="control-label col-sm-3">上传图片：</label>
              <div class="col-sm-8" style="line-height:32.4px;">
              	<div class="fbtn"> 
              	点击上传              		
                  <input type="file" name="ht_picture" id="df" style="background:url()" accept="image/*"  value="点击上传" />
              	</div>
               <div class='text-center' style="display: none"><a id='changeIMG'  style='cursor:pointer;color:red;'>更换图片</a></div>
              </div>
              </div>
              
             <!--  <div class="form-group">
              <label class="control-label col-sm-3">是否特价：</label>
              <div style="line-height:32.4px;text-indent:2em;">
                  <input type="radio"  name="ht_special"  value="1" checked="checked">正常价格
                   <input type="radio"  name="ht_special"  value="2">特价
              </div> 
              </div> -->
              <div class="form-group"> 
              <label class="control-label col-sm-3">商品单价：</label>
              <div class="col-sm-8" style="line-height:32.4px;">
                  <input type="number" class="form-control" name="ht_price"/>
              </div> 
              </div>
              <!-- <div class="form-group"> 
              <label class="control-label col-sm-3">商品特价：</label>
              <div class="col-sm-8 " style="line-height:32.4px;">
                  <input type="text" class="form-control" name="ht_sPrice" disabled="disabled"/>
              </div> 
              </div> -->
              <div class="form-group"> 
              <label class="control-label col-sm-3">商品描述：</label>
              <div class="col-sm-8" style="line-height:32.4px;">
                 <textarea class="form-control" name="ht_merDesc" rows="" cols="" style="resize:vertical;"></textarea>
             </div> 
              </div>
          <div class="form-group text-center">
            <input type="button" class="btn btn-default" 
               data-dismiss="modal" value="关闭">
            
            <input type="submit" class=" btn btn-primary" value="确认"/>
                                   
          </div>
          <s:token></s:token>
              </form>
         </div>
         
         
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>
   <!-- 商品详情展示模态框（删除Modal） -->
<div class="modal fade" id="myMerchandiseModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myMerchandiseModalLabel">
             
            </h4>
            
         </div>
         <div class="modal-body">
           
         </div>
         
         
      </div><!-- /.modal-content -->
</div><!-- /.modal -->

</div>
   
   <div class="panel-footer">
   </div>
</div>
   </body>
</html>