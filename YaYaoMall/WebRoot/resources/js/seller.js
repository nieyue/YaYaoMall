/**
 * *商家数据
 */
var sellerData={
		/**
		 * 点击商品展示浏览
		 */
		showMerCategoryHandler:function(){
			$(".right-bar").html("");
    		$(".right-bar").load('/seller/templates/mer_category.html');
    		myUtils.myPrevToast("加载中",function(){
    			$.get("/merCategory/browseMerCategory.json?sellerid="+myUtils.GetQueryString("sellerid")+"&cateName=all",function(data){
    				if(data==null||data==''||data==undefined){
    					$("#merCategoryList").after("<div id='merCategoryEmpty' class='text-center'>你还没有添加分类哦，赶紧添加吧</div>");
    					return;
    				}
    				for (var i = 0; i < data.length; i++) {
    				$("#merCategoryList tbody").append("<tr data-merCateName='"+data[i].cateName+"'><td>"+data[i].cateName+"</td><td>"+myUtils.timeStampToDate(data[i].cateDate)+"</td><td><a class='button button-3d button-action button-tiny updateCategoryBtn'>修改</a></td><td><a class='button button-3d button-caution button-tiny delCategoryBtn'>删除</a></td></tr>");
					}
    			
    			});
    			myUtils.myPrevToast("加载完成",null,"remove");
    		},"add");
		},
		/**
		 * 点击增加商品分类
		 */
		addMerCategoryHandler:function(){
			$("#mySellerModalLabel").text("添加商品类别");
    		$("#mySellerModalBody").html("<input type='text'class='form-control' placeholder='类别' id='merCategoryValue' />");
    		$("#errorSellerInfo").text("");
    		$("#mySellerModal").click();
    		$("#sellerSubmit").unbind("click");
    		$("#sellerSubmit").on("click",function(){
    			var mcv=$("#merCategoryValue").val().trim();
    			if(!myUtils.userVerification.nicename.test(mcv)){
    				$("#errorSellerInfo").text("1-10位，不能有空格");
    				return;
    			}
    			$.get("/merCategory/addMerCategory.json?sellerid="+myUtils.GetQueryString("sellerid")+"&cateName="+mcv,function(data){
    				if(data.cateMsg=="200"){
    					$("#closeModal").click();
    					console.log(data)
    					myUtils.myLoadingToast("添加成功", null);
    					
    					if($("#merCategoryEmpty")!=null){//删除商品类别为空信息
    					$("#merCategoryEmpty").remove();
    					}
    					$("#merCategoryList tbody").append("<tr data-merCateName='"+data.cateName+"'><td>"+data.cateName+"</td><td>"+myUtils.timeStampToDate(data.cateDate)+"</td><td><a class='button button-3d button-action button-tiny updateCategoryBtn'>修改</a></td><td><a class='button button-3d button-caution button-tiny delCategoryBtn'>删除</a></td></tr>");
    				}else if(data.cateMsg=="商品分类已经存在"){
    					$("#closeModal").click();
    					myUtils.myLoadingToast(data.cateMsg, null);
    				}
    			});
    		});
		},
		/**
		 * 删除商品分类
		 */
		delMerCategoryHandler:function(){
			var thisDelCate=$(this);
			//console.log(thisDelCate.parent().parent("tr").attr("data-merCateName"));
			myUtils.myConfirm("确定删除吗？",function(){
				$.post("/merCategory/delMerCategory.json",{cateName:thisDelCate.parent().parent("tr").attr("data-merCateName"),sellerid:myUtils.getCookie("sellerid")},
						function(data){
					if(data=="200"){
					myUtils.myLoadingToast("删除成功", function(){
  					thisDelCate.parent().parent("tr").remove();
  					if($("#merCategoryList tbody").html().trim()==""){
  						$("#merCategoryList").after("<div id='merCategoryEmpty' class='text-center'>你还没有添加分类哦，赶紧添加吧</div>");
  					}
  						
					});
					}
				});
  			});
		},
		/**
		 * 修改指定分类
		 */
		updateMerCategoryHandler:function(){
			var thisDelCate=$(this);
			$("#mySellerModalLabel").text("更改商品类别");
    		$("#mySellerModalBody").html("<input type='text'class='form-control' placeholder='类别' id='merCategoryValue' />");
    		$("#errorSellerInfo").text("");
    		$("#mySellerModal").click();
    		$("#sellerSubmit").unbind("click");
    		$("#sellerSubmit").on("click",function(){
    			var mcv=$("#merCategoryValue").val().trim();
    			if(!myUtils.userVerification.nicename.test(mcv)){
    				$("#errorSellerInfo").text("1-10位，不能有空格");
    				return;
    			}
				$.post("/merCategory/updateMerCategory.json?sellerid="+myUtils.getCookie("sellerid")+"&oldCateName="+thisDelCate.parent().parent("tr").attr("data-merCateName")+"&newCateName="+mcv,
					function(data){
					console.log(data);
					if(data.cateMsg=="200"){
						$("#closeModal").click();
    					myUtils.myLoadingToast("修改成功", null);
    					thisDelCate.parent().parent("tr").attr("data-merCateName",mcv);
    					thisDelCate.parent().parent("tr").html("<td>"+data.cateName+"</td><td>"+myUtils.timeStampToDate(data.cateDate)+"</td><td><a class='button button-3d button-action button-tiny updateCategoryBtn'>修改</a></td><td><a class='button button-3d button-caution button-tiny delCategoryBtn'>删除</a></td>")
  					}else if(data.cateMsg=="商品分类已经存在"){
    					$("#closeModal").click();
    					myUtils.myLoadingToast(data.cateMsg, null);
    				}
					});
					});
		},
		/**
		 * *登录退出
		 */
		sellerLoginOut:function(btn){
			$(btn).click(function(){
	    		 myUtils.myLoginOut("确定退出吗？",function(){
	       			$.get("/seller/sellerLoginOut",function(){
	       			myUtils.myLoadingToast("退出成功",function(){
	       			myUtils.delCookie("sellerloginstate");
	       			myUtils.delCookie("sellerid");
	       			myUtils.delCookie("sellerToken");
	       			location.replace("/seller/index");
	       			});
	       			});
	    	 });
	    	 });
		},
		/**
		* *自动登录
		*/
		sellerAutoLoginSession:function(obj){
			//sellerloginstate==1自动登录，==0，登录,不自动
			if(myUtils.userVerification.catNum.test(myUtils.getCookie("sellerid"))&&myUtils.getCookie("sellerloginstate")!=null&&myUtils.getCookie("sellerToken")!=null){
			$.get("/seller/sellerAutoLogin.json",
			{sellerid:myUtils.getCookie("sellerid"),sellerloginstate:myUtils.getCookie("sellerloginstate"),sellerToken:myUtils.getCookie("sellerToken")}
			,function(data){
				if(data.sellerMsg=="200"){
				sessionStorage.setItem("seller",encode64(JSON.stringify(data)));
				if(typeof obj.login=='function'){
					obj.login();//登录成功
				}
				}else {
					if(typeof obj.loginout=='function'){
						obj.loginout();//登录错误
					}
				}
			});
			}
		}
};