/**
 * user数据(涵商品)
 * 
 */
var userData = {
	//商户href
	refereerSeller:function(){
		   myUtils.sellerNotExistence();
		   $("#classificationhref").attr("href","/mall/mobile/classification?user_id="+myUtils.GetQueryString("user_id"));
		   $("#indexhref").attr("href","/mall/mobile/index?user_id="+myUtils.GetQueryString("user_id"));
		   $("#shoppingCirclehref").attr("href","/mall/mobile/shoppingCircle?user_id="+myUtils.GetQueryString("user_id"));
		   $("#cathref").attr("href","/mall/mobile/cat?user_id="+myUtils.GetQueryString("user_id"));
		   $("#personhref").attr("href","/mall/mobile/person?user_id="+myUtils.GetQueryString("user_id"));
		   //存储sellerid
		   if(myUtils.userVerification.catNum.test(myUtils.GetQueryString("user_id"))){
			   sessionStorage.setItem("user_id", myUtils.GetQueryString("user_id"));
		   }
	},
	// 用户数据初始化
	userInit : {
		user_id:null,
		user_password : '123456',
		user_img : '/resources/img/preLoding.jpg',
		user_nice_name : '添加昵称',
		user_signature : '把你爱好留在这里！',
		user_email : '邮箱认证后可以用它登陆',
		user_phone : '手机号认证后可以用它登陆',
		user_identity : '点击认证',
		user_receipt_address : '添加收货地址'
	},
	// 用户数据
	person : function(data){
		document.querySelector("#userHref").href='/mall/mobile/user_info';
		document.querySelector("#userNiceName").innerHTML=data.user_nice_name||data.user_email||data.user_phone||userData.userInit.user_name;
		document.querySelector("#userIMG").src=data.user_img||userData.userInit.user_img;
		document.querySelector("#userAccess").innerHTML='';
		document.querySelector("#userSignature").innerHTML=data.user_signature||userData.userInit.user_signature;
	},
	userInfo:function(data){
		document.querySelector("#userInfoIMG").src=data.user_img||userData.userInit.user_img;
		document.querySelector("#userNiceName").innerHTML=data.user_nice_name||userData.userInit.user_nice_name;
		document.querySelector("#userSignature").innerHTML=data.user_signature||userData.userInit.user_signature;
		document.querySelector("#userEmail").innerHTML=data.user_email||userData.userInit.user_email;
		document.querySelector("#userPhone").innerHTML=data.user_phone||userData.userInit.user_phone;
		document.querySelector("#userIdentity").innerHTML=data.user_identity||userData.userInit.user_identity;
		document.querySelector("#userReceiptAddress").innerHTML=data.user_receipt_address||userData.userInit.user_receipt_address;
	},
	// 商品数据
	merchandiseIndex:function(elementid,mers){
		for ( var merid in mers) {
			var mer=mers[merid];
			console.log(mer.merchandise_img[0].merchandise_img_address)
		   $(elementid).append(
		"<a class='list-card well' href='/mall/mobile/merchandise_details?seller_id="+myUtils.GetQueryString("seller_id")+"&merchandise_id="+mer.merchandise_id+"'>"+
		"<div class='itemimg'><img src='"+mer.merchandise_img[0].merchandise_img_address+"'>"+
		"<span class='goods-sold'>销量"+mer.merchandise_sold+"</span>"+
        "<span class='goods-discount'>"+parseFloat(mer.merchandise_discount).toFixed(1)+"折</span></div>"+
        "<div  class='iteminfo'>"+
        "<h3 class='goods-title'>"+mer.merchandise_name+"</h3>"+
        "<span class='goods-relprice'>¥"+parseFloat(mer.merchandise_price).toFixed(2)+"</span>"+
        "<span class='goods-price'>¥"+parseFloat(mer.merchandise_old_price).toFixed(2)+"</span>"+
        "</div></a>");
		}
	},
	//商品数据初始化加载
	 initIndexMer:function(){
		 var mer_index_load_finlish=0;//加载完成
		 
		   myUtils.myFootLoadingToast("55px",function(){
				var currentcount=1;
				if(localStorage.getItem("browse_merchandise")!=null){
					currentcount=JSON.parse(decode64(localStorage.getItem("browse_merchandise"))).length;
				}else {
					sessionStorage.setItem("mer_index_load_finlish",0);//browseMerchandise==null,没完成
				}
				
				if(sessionStorage.getItem("mer_index_load_finlish")==1){
					myUtils.myFootLoadingToast("55px",null,"remove");
					return;
				} 
				
	 $.ajax({  
			type : "get",  
			url : "/merchandise/browseMerchandise",  
			data : {seller_id:myUtils.GetQueryString("seller_id"),current_count:currentcount,page_size:10,mer_category_name:"all"},  
			async : false,//取消异步 
			dataType:"json",
			success : function(data){  
			   if(data==''||data==null){
				   console.log("ds")
				myUtils.myFootLoadingToast("55px",null,"remove");
				myUtils.myLoadingToast("没有更多了");
				mer_index_load_finlish=1;
				sessionStorage.setItem("mer_index_load_finlish", mer_index_load_finlish);
				return;
			}
			   var newData=data;//所有数据 
			   if(localStorage.getItem("browse_merchandise")!=null){
			  var olddata=JSON.parse(decode64(localStorage.getItem("browse_merchandise")));
		 	   newData=olddata.concat(data);
			   }else{
				  document.querySelector("#remtjsp").innerHTML='';//第一次加载
			   }
			  localStorage.setItem("browseMerchandise",encode64(JSON.stringify(newData)));
				console.log(newData)
			   userData.merchandiseIndex("#remtjsp",data);//只加载最新
				myUtils.myFootLoadingToast("55px",null,"remove");
				    }
				    });
		   
		},"add");
		   
	   },
	//商品详情页
	merchandiseDetails:function(mers){
		for ( var merid in mers) {
			var mer=mers[merid];
			console.log(mer.merchandise_img[0].merchandise_img_address)
			if(mer.merchandise_id==myUtils.GetQueryString("merchandise_id")){
			  $(".merchandise-img img").attr("src",encodeURIComponent(mer.merchandise_img[0].merchandise_img_address));
			  $(".merchandise-img .goods-sold").text("销量"+mer.merchandise_sold);
			  $(".merchandise-img .goods-stock").text("库存"+mer.merchandise_stock);
			  $(".merchandise-details .merchandise-title").text(mer.merchandise_name);
			  $(".merchandise-price .merchandise-relprice").text("¥"+parseFloat(mer.merchandise_price).toFixed(2));
			  $(".merchandise-price .merchandise-price").text("¥"+parseFloat(mer.merchandise_old_price).toFixed(2));
			   //初始化购物数量
		  myUtils.merchandiseNumber(".merchandise-num",".merchandise-add",".merchandise-minus",mer.merchandise_stock);
			  	}
			}
		
	},
	//商品类别
	merCategory:function(data){
		//myUtils.slice(merchandises)
		for (var i = 0; i < data.length; i++) {
			console.log(data[0].merchandises[1].merchandise_img[0].merchandise_img_address);
			
      		$("#classification-left")
          	.append("<a class='btn' href='#'>"
                    +"<img src=''/>"
      	  			+"<div class='classification-left-title'>"+data[i].mer_category_name+"</div>"
     			 	+"</a>");
          	
			}
	}
	//$().children("a:first-child").css("background-color","red");

};
