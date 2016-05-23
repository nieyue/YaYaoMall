/**
 * *商家数据
 */
var sellerData={
		/**
		 * 点击商品类别展示浏览
		 */
		showMerCategoryHandler:function(){
			$(".right-bar").html("");
    		$(".right-bar").load('/seller/templates/mer_category.html');
    		myUtils.myPrevToast("加载中",function(){
    			$.get("/merCategory/browseMerCategory.json?sellerid="+myUtils.getCookie("sellerid"),function(data){
    				console.log(data);
    				console.log(data.merCategoryList)
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
		showMerchandiseHandler:function(merchandiseStatus){
			$(".right-bar").html("");
    		$(".right-bar").load('/seller/templates/merchandise.html');
    		myUtils.myPrevToast("加载中",function(){
    			$.post("/merchandise/browseMerBySeller.json?sellerid="+myUtils.getCookie("sellerid")+"&currentCount=1&pageSize=10&merchandiseStatus="+merchandiseStatus,function(data){
    				if(data==null||data==''||data==undefined){
    					$("#merchandiseList").after("<div id='merEmpty' class='text-center'>你还没有添加商品哦，赶紧添加吧</div>");
    					return;
    				}
    				//console.log(data)
    				for (var i = 0; i < data.length; i++) {
    				$("#merchandiseList tbody").append(
    					"<tr data-merid="+data[i].merchandiseid+"><td class='merdesctd'><input type='checkbox' class='merchandiseCheckbox' >"+
     					"<img   src='"+data[i].merchandiseImgs[0].imgAddress+"'>"+
     					"<div>"+data[i].merchandiseName+"</div></td>"+
     					"<td class='meroldpricetd'>"+data[i].merchandiseOldPrice+"</td>"+
     					"<td class='merdiscounttd'>"+data[i].merDiscount+"</td>"+
     					"<td class='merpricetd'>"+data[i].merchandisePrice+"</td>"+
     					"<td class='merpostagetd'>"+(data[i].merchandisePostage!=null?data[i].merchandisePostage:"包邮")+"</td>"+
     					"<td class='mersoldtd'>"+(data[i].merchandiseSold||0)+"</td>"+
     					"<td class='merstocktd'>"+data[i].merchandiseStock+"</td>"+
     					"<td class='mercatetd'>"+(data[i].merCategory!=null?data[i].merCategory.cateName:'')+"</td>"+
    				    "<td class='merdatetd'>"+myUtils.timeStampToSimpleDate(data[i].merchandiseUpdateTime||"")+"</td>"+
     					"<td class='meroperationtd'>"+
	 					"<a class='button button-3d button-primary button-tiny myblock updateSingleMer'>编辑</a>"+
	 					"<a class='button button-3d button-inverse button-tiny myblock singleBan'>下架</a>"+
	 					"<a class='button button-3d button-caution button-tiny myblock delSingleMer'>删除</a>"+
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
		addMerchandiseImgsHandler:function(reload){
			if(reload==true){
			$(".right-bar").html("");
    		$(".right-bar").load('/seller/templates/addmerchandise.html');
			}
    		$(document).on("change","#addMerDiscount",function(){
    			if(myUtils.userVerification.merPrice.test($("#addMerchandiseOldPrice").val())
    					&&myUtils.userVerification.merDiscount.test($("#addMerDiscount").val())){
    				var realPrice=parseFloat($("#addMerchandiseOldPrice").val().trim()*$("#addMerDiscount").val().trim()).toFixed(2);
    				$("#addMerchandisePrice").val(realPrice);
    				return;
    			}
    			$("#addMerchandiseOldPrice").val("");
    			$("#addMerDiscount").val("");
    			$("#addMerchandisePrice").val("");
    		});
    		
    		//上传图片
    		$(document).off("click",".dragMerFileBtn");
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
    	  		                myUtils.myPrevToast("上传成功",null,"remove");
    	  		            	//设定图片显示问题
            			    	filebtnthis.parent(".nodrag").after(filebtnthis.parent(".nodrag").clone());
            			    	filebtnthis.css("display","none");
    	  		              	dragMerImgWarp.children(".dragMerImg").prev().attr("value",merimg.merchandiseimgid);//提交表单用
    	  		              	dragMerImgWarp.children(".dragMerImg").attr("src",merimg.imgAddress);
    	  		              	filebtnthis.parent(".nodrag").removeClass("nodrag").addClass("myDrag");//删除nodrag，实现拖拽
            		      		dragMerImgWarp.css("display","inline-block");
    	  		  				}
    	  		  				},
    			    	dragFn:function(e){
    			    	//jquery ui图片排序
    			  /* $("#imgwarp ").sortable({
    			    	opacity: 0.6,
    			    	items:".dragMerWarp:not(.dragMerWarp:last-child)",
    			    	placeholder: "divback",
    			    	update:function(event, ui){       //更新排序之后
    			              console.log($(this).get(0));
    			          }
    			    });
           		 	$("#imgwarp .dragMerWarp").disableSelection();*/
    			    		//sortable 更强大
    			    		 Sortable.create(imgwarp, { 
    			    		      handle: ".myDrag", 
    			    		      animation: 150,
    			    		      draggable:".myDrag",
    			    		      filter: ".nodrag"
    			    		       });	
           		 	
    			    }});
    			    });
    			  });
		},
		/**
		 * 添加商品时的商品分类展示
		 */
		merCategoryShowInMerchandise:function(updatedata){
			//分类展示
    		myUtils.myPrevToast("加载中",function(){
    		$.get("/merCategory/browseMerCategory.json?sellerid="+myUtils.getCookie("sellerid"),function(data){
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
    			//修改商品时显示的分类
    			if(updatedata){
    			for (var int = 0; int < $("input[name='merCategoryid']").length; int++) {
					if($("input[name='merCategoryid']")[int].value==updatedata.merCategoryid){
						$("input[name='merCategoryid']")[int].click();
				}
				}
    			}
    		});
    		myUtils.myPrevToast("加载完成",null,"remove");
    		},"add");
		},
		/**
		 * 添加商品表单提交,增加或修改
		 */
		addMerchandiseHandler:function(obj){
			$("#mersellerid").val(myUtils.getCookie("sellerid"));//传sellerid
			$(".merchandiseImgsid").each(function(){
			$(this).attr("name","merchandiseImgsid");
			if($(".merchandiseImgsid").length>=2&&$(this).next("img").attr("src")=="/resources/img/preLoding.jpg"){
			$(this).removeAttr("name");//去掉最后一个空图片
    		}
			});
			//商品id,更新用
			if(obj.merchandiseid){
				$("#merchandiseid").attr("value",obj.merchandiseid);
			}
    		if(!$(".dragMerImg").prev().attr("value")){
				return myUtils.myLoadingToast("未添加图片", null);
			} 
			if($("#addMerchandiseName").val().trim().length<=2||$("#addMerchandiseName").val().trim().length>=300){
				return myUtils.myLoadingToast("商品描述2-300字数之间", null);
			}
			if(!myUtils.userVerification.merPrice.test($("#addMerchandiseOldPrice").val())){
				return myUtils.myLoadingToast("商品价格必须为合法数字(正数，最多两位小数)", null);
			}
			if(!myUtils.userVerification.merDiscount.test($("#addMerDiscount").val())){
				return myUtils.myLoadingToast("商品折扣范围0.01-1.00，选填，默认1.00", null);
			}
			if(!myUtils.userVerification.merPrice.test($("#addMerchandisePrice").val())){
				return myUtils.myLoadingToast("商品价格必须为合法数字(正数，最多两位小数)", null);
			}
			if(!myUtils.userVerification.catNum.test($("#addMerchandiseStock").val())){
				return myUtils.myLoadingToast("商品库存(大于0正整数)", null);
			}
			if($("#addMerchandisePostage").val()!=""&&(!myUtils.userVerification.catNum.test($("#addMerchandisePostage").val()))){
				return myUtils.myLoadingToast("邮费必须为合法数字(正数，最多两位小数)", null);
			}
			 myUtils.myPrevToast("加载中",function(){
        		$.ajax({
        		url:obj.ajaxFn,//not代表除去file
        		data:$("#addMerForm").serialize(),
        		success:function(data){
        		console.log(data)
        			if(data.merchandiseMsg=="200"){
        			myUtils.myPrevToast("添加成功",null,"remove");
        			}else{
        			myUtils.myPrevToast("添加失败",null,"remove");
        			myUtils.myLoadingToast("请重新添加", null);
        			}
        		if(obj.add){
        		//复原
        		sellerData.addMerchandiseImgsHandler(true);
                sellerData.merCategoryShowInMerchandise();
        		}else if(obj.update){
        			sellerData.updateMerchandiseSingleHandler(obj.update.$element);
        		}
        		}});
        		},"add");  
		},
		/**
		 * 商品单个删除
		 */
		delMerchandiseSingleHandler:function($obj){
			var thisDelMer=$obj;
			myUtils.myConfirm("确定删除吗？",function(){
				$.post("/merchandise/delMerchandise.json",{merchandiseid:thisDelMer.parent().parent("tr").attr("data-merid"),sellerid:myUtils.getCookie("sellerid")},
						function(data){
					if(data=="200"){
					myUtils.myLoadingToast("删除成功", function(){
					thisDelMer.parent().parent("tr").remove();
  					if($("#merchandiseList tbody").html().trim()==""){
  						$("#merchandiseList").after("<div id='merEmpty' class='text-center'>你还没有添加商品哦，赶紧添加吧</div>");
  					}
  						
					});
					}
				});
  			});
		},
		/**
		 * 商品单个上、下架
		 */
		singleMerchandiseStatusHandler:function($obj,merchandiseStatus){
			var thisbanMer=$obj;
			myUtils.myConfirm("确定"+merchandiseStatus+"吗？",function(){
				$.post("/merchandise/statusMerchandise.json",{merchandiseid:thisbanMer.parent().parent("tr").attr("data-merid"),sellerid:myUtils.getCookie("sellerid"),merchandiseStatus:merchandiseStatus},
						function(data){
					if(data=="200"){
					myUtils.myLoadingToast(merchandiseStatus+"成功", function(){
						thisbanMer.parent().parent("tr").remove();
  					if($("#merchandiseList tbody").html().trim()==""){
  						$("#merchandiseList").after("<div id='merEmpty' class='text-center'>你还没有添加商品哦，赶紧添加吧</div>");
  					}
  						
					});
					}
				});
  			});
		},
		/**
		 * 商品单个修改
		 */
		updateMerchandiseSingleHandler:function($obj){
			$(".right-bar").html("");
    		$(".right-bar").load('/seller/templates/addmerchandise.html');
			var thisupdateMer=$obj;
			//原数据加载
			myUtils.myPrevToast("加载中",function(){
			$.get("/merchandise/loadMerchandise.json",{merchandiseid:thisupdateMer.parent().parent("tr").attr("data-merid"),sellerid:myUtils.getCookie("sellerid")},
					function(data){
				if(data.merchandiseMsg=="200"){
					$("#addMerchandiseName").text(data.merchandiseName);
					$("#addMerchandiseOldPrice").val(data.merchandiseOldPrice);
					$("#addMerDiscount").val(data.merDiscount);
					$("#addMerchandisePrice").val(data.merchandisePrice);
					$("#addMerchandiseStock").val(data.merchandiseStock);
					$("#addMerchandiseCode").val(data.merchandiseCode);
					//商品分类
					sellerData.merCategoryShowInMerchandise(data);
					$("#addMerchandisePostage").val(data.merchandisePostage);
					//原图片数据加载
				$.get("/merchandiseImg/browseMerchandiseImg.json",{merchandiseid:data.merchandiseid},function(d){
					console.log(d.length)
				for (var i = 0; i < d.length; i++) {
						$(".dragMerWarp:first-child").after($(".dragMerWarp:first-child").clone());
					}
					for (var j = 0; j < $(".dragMerWarp").length-1; j++) {
						console.log($(".dragMerWarp").length)
						console.log($($(".dragMerWarp .dragMerImg")[j]).prev())
						$($(".dragMerWarp .dragMerFileBtn")[j]).css("display","none");
						$($(".dragMerWarp .dragMerImg")[j]).prev().attr("value",d[j].merchandiseimgid);//提交表单用
						$($(".dragMerWarp .dragMerImg")[j]).attr("src",d[j].imgAddress);
						$($(".dragMerWarp")[j]).removeClass("nodrag").addClass("myDrag");//删除nodrag，实现拖拽
						$($(".dragMerWarp .dragMerImgWarp")[j]).css("display","inline-block");
					}
					sellerData.addMerchandiseImgsHandler(false);
					//sortable 更强大
		    		 Sortable.create(imgwarp, { 
		    		      handle: ".myDrag", 
		    		      animation: 150,
		    		      draggable:".myDrag",
		    		      filter: ".nodrag"
		    		       });	
  		 	
				});
				
				$("#addMerchandiseSubmit").attr("id","updateMerchandiseSubmit");
				$(document).off("click","#updateMerchandiseSubmit").on('click','#updateMerchandiseSubmit',function(){
					sellerData.addMerchandiseHandler({ajaxFn:"/merchandise/updateMerchandise.json",update:{$element:$obj},merchandiseid:data.merchandiseid});
				});
				}
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