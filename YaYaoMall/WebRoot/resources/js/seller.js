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
    			$.get("/merCategory/browseMerCategory.json?sellerid="+myUtils.getCookie("sellerid")+"&mercategoryid=0",function(data){
    				if(data==null||data==''||data==undefined){
    					$("#merCategoryList").after("<div id='merCategoryEmpty' class='text-center'>你还没有添加分类哦，赶紧添加吧</div>");
    					return;
    				}
    				for (var i = 0; i < data.length; i++) {
    				$("#merCategoryList tbody").append("<tr data-mercategoryid='"+data[i].mercategoryid+"'><td>"+data[i].cateName+"</td><td>"+myUtils.timeStampToDate(data[i].cateDate)+"</td><td><a class='button button-3d button-action button-tiny updateCategoryBtn'>修改</a></td><td><a class='button button-3d button-caution button-tiny delCategoryBtn'>删除</a></td></tr>");
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
    			$.get("/merCategory/addMerCategory.json?sellerid="+myUtils.getCookie("sellerid")+"&cateName="+mcv,function(data){
    				if(data.cateMsg=="200"){
    					$("#closeModal").click();
    					console.log(data)
    					myUtils.myLoadingToast("添加成功", null);
    					
    					if($("#merCategoryEmpty")!=null){//删除商品类别为空信息
    					$("#merCategoryEmpty").remove();
    					}
    					$("#merCategoryList tbody").append("<tr data-mercategoryid='"+data.mercategoryid+"'><td>"+data.cateName+"</td><td>"+myUtils.timeStampToDate(data.cateDate)+"</td><td><a class='button button-3d button-action button-tiny updateCategoryBtn'>修改</a></td><td><a class='button button-3d button-caution button-tiny delCategoryBtn'>删除</a></td></tr>");
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
		delMerCategoryHandler:function($obj){
			var thisDelCate=$obj;
			//console.log(thisDelCate.parent().parent("tr").attr("data-merCateName"));
			myUtils.myConfirm("确定删除吗？",function(){
				$.post("/merCategory/delMerCategory.json",{mercategoryid:thisDelCate.parent().parent("tr").attr("data-mercategoryid"),sellerid:myUtils.getCookie("sellerid")},
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
		updateMerCategoryHandler:function($obj){
			var thisDelCate=$obj;
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
				$.post("/merCategory/updateMerCategory.json?sellerid="+myUtils.getCookie("sellerid")+"&mercategoryid="+thisDelCate.parent().parent("tr").attr("data-mercategoryid")+"&newCateName="+mcv,
					function(data){
					if(data.cateMsg=="200"){
						$("#closeModal").click();
    					myUtils.myLoadingToast("修改成功", null);
    					thisDelCate.parent().parent("tr").attr("data-mercategoryid",mcv);
    					thisDelCate.parent().parent("tr").html("<td>"+data.cateName+"</td><td>"+myUtils.timeStampToDate(data.cateDate)+"</td><td><a class='button button-3d button-action button-tiny updateCategoryBtn'>修改</a></td><td><a class='button button-3d button-caution button-tiny delCategoryBtn'>删除</a></td>")
  					}else if(data.cateMsg=="商品分类已经存在"){
    					$("#closeModal").click();
    					myUtils.myLoadingToast(data.cateMsg, null);
    				}
					});
					});
		},
		/**
		 * 点击商品管理展示
		 */
		showMerchandiseHandler:function(){
			$(".right-bar").html("");
    		$(".right-bar").load('/seller/templates/merchandise.html');
    		myUtils.myPrevToast("加载中",function(){
    			$.post("/merchandise/browseMerchandise.json?sellerid="+myUtils.getCookie("sellerid")+"&currentCount=1&pageSize=10&merchandiseid=0",function(data){
    				if(data==null||data==''||data==undefined){
    					$("#merchandiseList").after("<div class='text-center'>你还没有添加商品哦，赶紧添加吧</div>");
    					return;
    				}
    				for (var i = 0; i < data.length; i++) {
    					//data[i].merchandiseImgs[0].imgAddress
    				$("#merchandiseList tbody").append(
    					"<tr data-merid="+data[i].merchandiseid+"><td class='merdesctd'><input type='checkbox' class='merchandiseCheckbox' >"+
     					"<img   src='"+data[i].merchandiseImgs[0].imgAddress+"'>"+
     					"<div>"+data[i].merchandiseName+"</div></td>"+
     					"<td class='merpricetd'>"+data[i].merchandisePrice+"</td>"+
     					"<td class='mersoldtd'>"+data[i].merchandiseSold+"</td>"+
     					"<td class='merstocktd'>"+data[i].merchandiseStock+"</td>"+
     					"<td class='mercatetd'>"+data[i].merCategory.cateName+"</td>"+
    				    "<td class='merdatetd'>"+myUtils.timeStampToSimpleDate(data[i].merchandiseUpdateTime)+"</td>"+
     					"<td class='meroperationtd'>"+
	 					"<a class='button button-3d button-primary button-tiny myblock'>编辑</a>"+
	 					"<a class='button button-3d button-inverse button-tiny myblock'>下架</a>"+
	 					"<a class='button button-3d button-caution button-tiny myblock'>删除</a>"+
	 					"</td>"+
  						"</tr>");
					}
    				
    			});
    		myUtils.myPrevToast("加载完成",null,"remove");
    		//全选/全不选
			myUtils.changeAllChecked("#merchandiseCheckboxBoss", ".merchandiseCheckbox");
		},"add");
		},
		/**
		 * 添加商品图片
		 */
		addMerchandiseImgsHandler:function(){
			$(".right-bar").html("");
    		$(".right-bar").load('/seller/templates/addmerchandise.html');
    		//上传图片
    		 $(document).on("click",".dragMerFileBtn",function(event){
    			 	var filebtnthis=$(this);
					var dragMerImgWarp=filebtnthis.prev(".dragMerImgWarp");
					filebtnthis.next(".dragMerFile").click();
					filebtnthis.next(".dragMerFile").change(function(){
    			    myUtils.fileUpload({
    			    	inputfile:filebtnthis.next(".dragMerFile"),
    			    	ajaxObj:
    			    		{
    	  		  				formData:[{key:"merFile",value:filebtnthis.next(".dragMerFile").get(0).files[0]},{key:"sellerid",value:myUtils.getCookie("sellerid")}],
    	  		  				url:"/merchandiseImg/addMerchandiseImg.json",
    	  		  				success:function(merimg){
    	  		  				console.log(merimg)
    	  		                myUtils.myPrevToast("上传成功",null,"remove");
    	  		            	//设定图片显示问题
            			    	filebtnthis.parent(".dragMerWarp").after(filebtnthis.parent(".dragMerWarp").clone());
            			    	filebtnthis.css("display","none");
    	  		              	dragMerImgWarp.children(".dragMerImg").prev().attr("value",merimg.merchandiseimgid);//提交表单用
    	  		              	dragMerImgWarp.children(".dragMerImg").attr("src",merimg.imgAddress);
            		      		dragMerImgWarp.css("display","inline-block");
    	  		  				}
    	  		  				},
    			    	dragFn:function(e){
    			    	//图片排序
    			   $("#imgwarp ").sortable({
    			    	opacity: 0.6,
    			    	items:".dragMerWarp:not(.dragMerWarp:last-child)",
    			    	placeholder: "divback",
    			    	update : function(event, ui){       //更新排序之后
    			              console.log($(this).get(0));
    			          }
    			    });
           		 	$("#imgwarp .dragMerWarp").disableSelection();
           		 	
    			    }});
    			    });
    			  });
		},
		/**
		 * 添加商品中分类展示
		 */
		merCategoryShowInMerchandise:function(){
			//分类展示
    		myUtils.myPrevToast("加载中",function(){
    		$.get("/merCategory/browseMerCategory.json?sellerid="+myUtils.getCookie("sellerid")+"&mercategoryid=0",function(data){
    			$("#addMerCategoryList").append("<a class='button button-small  button-raised  button-primary' id='merAddCate'>添加分类</a>");
        		$(document).on('click',"#merAddCate",function(){
        			sellerData.addMerCategoryHandler();
        		});
    			if(data==null||data==''||data==undefined){
    				return;
    			}
    			for (var i = 0; i<data.length; i++) {
				$("#addMerCategoryList").prepend("<label class='radio-inline'><input type='radio' name='merCategoryid' value='"+data[i].mercategoryid+"'>  "+data[i].cateName+"</label>");
    			}
    			$("#addMerCategoryList").append("<a class='button button-small button-raised button-caution hide' id='merCancelCate'>取消分类</a>");
    			$(document).on('click',"input[name='merCategoryid']",function(){
    				$("#merCancelCate").removeClass("hide");
    			$(document).on('click',"#merCancelCate",function(){
    				$("input[name='merCategoryid']").attr("checked",false); 
    			});
    			});
    		});
    		myUtils.myPrevToast("加载完成",null,"remove");
    		},"add");
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