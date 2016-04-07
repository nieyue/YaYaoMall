//订单列表切换
;(function($){
    		$.fn.orderListControl=function(orderList,customOrderList){
    		this.on("click",function(){
    			$("#"+orderList).css("display","none");
    			$("#"+customOrderList).css("display","block");
    		});
    	}
    	})(jQuery);
//订单控制列表切换
;(function($){
	$.fn.control=function (){
    	this.on("click",function(){
    		if($(this).next().attr("class")){	
    		$(this).next().removeClass();
    		$(this).next().next().removeClass();
    		}else{
    		$(this).next().addClass("hidden");
    		$(this).next().next().addClass("hidden");
    			
    		}
    	});}
})(jQuery);
//登录退出
;(function($){
	$.fn.adminLogout=function (){
		 $(this).on("click",function(){
    		 $.ajax({
    		  type:'POST',
    		  url:"adminLogout.dhtml",
			success:function()
			{
				if(confirm("确定退出吗？")){
				location.href="Admin/ht_login.html";
				}
			},
			error:function(){
				alert("操作失败！");
			}
    		 }
    		 );
    	 });
	}
})(jQuery);
//指定删除
;(function($){
	$.fn.delIndex=function (url,del,target){
		$(this).on("click",function(){
			var ht_loginName=eval("("+del+")");
			if(confirm("确定删除吗？")){
    		$.post(url+".dhtml",
    				{
    				hln:ht_loginName
    				},
    				function(data){
    					
    					location.replace(target+".dhtml");
    				});
			}
    	}); 
	}
})(jQuery);
//批量删除
;(function($){
	$.fn.allDelPerson=function (each,url,target){
		
		$(this).on("click",function(){
    		var adi="";
    		$(each).each(function(){
    			if($(this).is(":checked")){
    				adi+=$(this).attr("value")+",";
    				
    			}
    		});
    		adi=adi.substring(0,adi.length-1);
    		if(adi==null||adi.length<=0){
    			return alert("请勾选指定删除对象！");
    		}
    		$.ajax({
    			url:url+".dhtml",
    			type:"POST",
    			data:{
    			   delIndexs:adi
    			},
    			beforeSend:function(){
    				//alert("删除中...");
    			},
    			complete:function(){
    				//alert("删除完成！");
    			},
    			success:function(){
    				alert("删除成功！");
    				location.replace(target+".dhtml");
    			},
    			error:function(){
    				alert("删除失败！");
    			}
    		
    		});
    	});
	}
})(jQuery);
//全选/全不选
;(function($){
	$.fn.allCheck=function (each){
		$(this).on("click",function(){
    		if($(this).is(":checked")){
    			$(this).prop("checked",true);
    			$(each).each(function(){
    			$(this).prop("checked",true);
    			});
    		}else{
    			$("#allCheckAdmin").prop("checked",false);
    			$(each).each(function(){
    			$(this).prop("checked",false);
   	
    			});
    		}
    	});
	}
})(jQuery);

/**
*加载更多实现
*只有两个是tr作用域的this，其他的为点击按钮this
*/
;(function($){
	$.fn.loadMore=function (tr){
		var list=5;
    	if($(tr).size()<=list){
    		$(this).remove();
    	}
    	$(tr).hide();
    	$(this).on("click",function(){
    		list+=20;
    		if(list>=$(tr).size()){
    			alert("没有更多了！");
    		  $(this).remove();
    		}
    		$(tr).each(function(index){
    		if(index<(5+list)){
    				$(this).show();//这是tr的this		
    		}
        		});
    	});	
    	//初始化显示
    	$(tr).each(function(index){
    		if(index<list){
    			$(this).show();//这是tr的this
    		}});
	}
})(jQuery);
//查询
;(function($){
	$.fn.search=function (searchContent,url,target){
this.on("click",function(){
	var sc=eval("("+searchContent+")");
	if(sc!=null&&sc!=""){
		$.ajax({
			url:url+".dhtml",
			type:"POST",
			dataType:"text",
			data:{
				sc:sc
			},
			//async:false,
		success:function(data){
			if(data){
				
			alert(data);
			}
			location.replace(target+".dhtml");
		},
		error:function(){
			alert("查询失败！");
		}
		});
	}else{
		alert("请输入查询信息！");
	}
	
});
	}
})(jQuery);
//全部查询
;(function($){
	$.fn.searchAll=function (url,target){
this.on("click",function(){
		$.ajax({
			url:url+".dhtml",
			type:"POST",
		success:function(data){
		
			location.replace(target+".dhtml");
		},
		error:function(){
			alert("查询失败！");
		}
		});
	
});
	}
})(jQuery);
//封装收货信息、定制订单评价、普通订单评价的函数
;(function($){
	$.fn.consigneeExclusiveOrder=function (consigneeID,exclusiveCustomID,orderID){
    		 $("#"+consigneeID).hide();
    	    	$(this).click(function(){
    	    		$("#"+exclusiveCustomID).hide();
    	    		$("#"+orderID).hide();
    	    		if($("#"+consigneeID).is(":visible")){
    	    			 $("#"+consigneeID).hide();	
    	    	
    	    		}else{
    	    			$("#"+consigneeID).show();
    	    			
    	    		}
    	    	}
    	    	);
	}
})(jQuery);