
//固定存储点击事件存储sessionStorage
;(function($){
    		$.controlSessionStorage=function(orderList,customOrderList){
var sessionStorageOLC=window.sessionStorage;
if(sessionStorageOLC.getItem("controlSessionStorage")){
	var thisid=sessionStorageOLC.getItem("controlSessionStorage");
	//alert(thisid);
	if(thisid=="orderList"||thisid=="merchandiseList"){
		$("#"+orderList).css("display","none");
		$("#"+customOrderList).css("display","block");
	}else{
		$("#"+orderList).css("display","block");
		$("#"+customOrderList).css("display","none");
		
	}
}
    		}
})(jQuery);
//订单、商品类别、商品列表切换
;(function($){
    		$.fn.orderListControl=function(orderList,customOrderList){
    			$(this).on("click",function(){
    			var sessionStorageOLC=window.sessionStorage;
    			sessionStorageOLC.setItem("controlSessionStorage", orderList);
    			$("#"+orderList).css("display","none");
    			$("#"+customOrderList).css("display","block");
    		});
    	}
    	})(jQuery);
//订单、商品类别、商品控制列表切换
;(function($){
	$.fn.control=function (){
    	this.on("click",function(){
    		if($(this).next().attr("class")){	
    		$(this).next().removeClass();
    		$(this).next().next().removeClass();
    		if($(this).next().next().next().attr("class")=="hidden"){
    			$(this).next().next().next().removeClass();
    		}
    		}else{
    		$(this).next().addClass("hidden");
    		$(this).next().next().addClass("hidden");
    		if($(this).next().next().next()&&($(this).next().next().next().attr("class")!="active")){
    			$(this).next().next().next().addClass("hidden");
    		}
    			
    		}
    	});}
})(jQuery);
//登录退出
;(function($){
	$.fn.adminLogout=function (){
		 $(this).on("click",function(){
			 if(confirm("确定退出吗？"))
			 {
    		 $.ajax(
    				 {
    		  type:'POST',
    		  url:"adminLogout.dhtml",
			success:function()
			{
				location.href="Admin/ht_login.html";
			},
			error:function(){
				$.toast("操作失败");
			}
    	 });
			 }
			
    	 });
	}
})(jQuery);
//指定删除
;(function($){
	$.fn.delIndex=function (url,del,target){
		
		$(this).on("click",function(){
			var name=eval("("+del+")");
			if(confirm("确定删除吗？")){
    		$.post(url+".dhtml",
    				{
    				hln:name
    				},
    				function(data){
    					$.toast("删除成功");
    					var re=function(){
    						location.replace(target+".dhtml");
    					}
    					setTimeout(re, 1000);
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
    			return $.toast("请勾选指定删除对象");;
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
    				$.toast("删除成功");
    				var re=function(){
    					location.replace(target+".dhtml");
    				}
    				setTimeout(re, 1000);
    			},
    			error:function(){
    				$.toast("删除失败");
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
    			$.toast("没有更多了");
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
		var sc=null;
		$("#"+searchContent).on("change",function(){
			sc=$(this).val();
		});
this.on("click",function(){
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
				$.toast(data);
			}
			var re=function(){
				location.replace(target+".dhtml");
			}
			setTimeout(re, 1000);
		},
		error:function(){
			$.toast("查询失败");
		}
		});
	}else{
		$.toast("请输入查询信息");
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
			$.toast("操作成功");
			var re=function(){
				location.replace(target+".dhtml");
			}
			setTimeout(re, 1000);
		},
		error:function(){
			$.toast("查询失败");
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
//实现闪现闪退的的alert
;(function($){
	$.toast=function (value){
$("body").append("<div id='toast' style='display:none;width:150px;height:50px;position:fixed;background-color:black;color:white;left:50%;top:50%;text-align:center;line-height:50px;border:1px solid black;border-radius:5px;'>"+value+"</div>");
$("#toast").fadeIn();
var ddd=function(){
$("#toast").fadeOut("slow");
$("#toast").remove();
}
setTimeout(ddd,1000);
	}
})(jQuery);
//过滤图片型号和判断图片大小
;(function($){
	$.getPhotoSize=function (obj){
	//判断照片大小
    photoExt=obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();//获得文件后缀名
    if(photoExt!='.jpg'&&photoExt!='.png'){
       alert("请上传后缀名为jpg/png的照片!");
        return false;
    }
    var fileSize = 0;
    var isIE = /msie/i.test(navigator.userAgent) && !window.opera;            
    if (isIE && !obj.files) {          
         var filePath = obj.value;            
         var fileSystem = new ActiveXObject("Scripting.FileSystemObject");   
         var file = fileSystem.GetFile (filePath);               
         fileSize = file.Size;         
    }else {  
         fileSize = obj.files[0].size;     
    } 
    fileSize=Math.round(fileSize/1024*100/1024)/100; //单位为MB
    if(fileSize>=2){
        alert("图片大小为"+fileSize+"MB，超过最大尺寸为2MB，请重新上传!");
        return false;
    }
    return true;
	}
})(jQuery);