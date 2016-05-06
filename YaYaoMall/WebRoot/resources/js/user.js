/**
 * user数据(涵商品)
 * 
 */
var userData = {
	//商户href
	refereerSeller:function(){
		   myUtils.sellerNotExistence();
		   $("#classificationhref").attr("href","/mall/mobile/classification?sellerid="+myUtils.GetQueryString("sellerid"));
		   $("#indexhref").attr("href","/mall/mobile/index?sellerid="+myUtils.GetQueryString("sellerid"));
		   $("#shoppingCirclehref").attr("href","/mall/mobile/shoppingCircle?sellerid="+myUtils.GetQueryString("sellerid"));
		   $("#cathref").attr("href","/mall/mobile/cat?sellerid="+myUtils.GetQueryString("sellerid"));
		   $("#personhref").attr("href","/mall/mobile/person?sellerid="+myUtils.GetQueryString("sellerid"));
		   //存储sellerid
		   if(myUtils.userVerification.catNum.test(myUtils.GetQueryString("sellerid"))){
			   sessionStorage.setItem("sellerid", myUtils.GetQueryString("sellerid"));
		   }
	},
	// 用户数据初始化
	userInit : {
		userid:null,
		userPassword : '123456',
		userIMG : '/resources/img/preLoding.jpg',
		userNiceName : '添加昵称',
		userSignature : '把你爱好留在这里！',
		userEmail : '邮箱认证后可以用它登陆',
		userPhone : '手机号认证后可以用它登陆',
		userIdentity : '点击认证',
		userReceiptAddress : '添加收货地址'
	},
	// 用户数据
	person : function(data){
		document.querySelector("#userHref").href='/mall/mobile/user_info';
		document.querySelector("#userNiceName").innerHTML=data.userNiceName||data.userEmail||data.userPhone||userData.userInit.userName;
		document.querySelector("#userIMG").src=data.userIMG||userData.userInit.userIMG;
		document.querySelector("#userAccess").innerHTML='';
		document.querySelector("#userSignature").innerHTML=data.userSignature||userData.userInit.userSignature;
	},
	user_info:function(data){
		document.querySelector("#userInfoIMG").src=data.userIMG||userData.userInit.userIMG;
		document.querySelector("#userNiceName").innerHTML=data.userNiceName||userData.userInit.userNiceName;
		document.querySelector("#userSignature").innerHTML=data.userSignature||userData.userInit.userSignature;
		document.querySelector("#userEmail").innerHTML=data.userEmail||userData.userInit.userEmail;
		document.querySelector("#userPhone").innerHTML=data.userPhone||userData.userInit.userPhone;
		document.querySelector("#userIdentity").innerHTML=data.userIdentity||userData.userInit.userIdentity;
		document.querySelector("#userReceiptAddress").innerHTML=data.userReceiptAddress||userData.userInit.userReceiptAddress;
	},
	// 商品数据
	merchandiseIndex:function(elementid,mers){
		for ( var merid in mers) {
			var mer=mers[merid];
			console.log(mer.merchandiseImg[0].imgaddress)
		   $(elementid).append(
		"<a class='list-card well' href='/mall/mobile/merchandise_details?sellerid="+myUtils.GetQueryString("sellerid")+"&merid="+mer.merchandiseid+"'>"+
		"<div class='itemimg'><img src='"+mer.merchandiseImg[0].imgaddress+"'>"+
		"<span class='goods-sold'>销量"+mer.merchandiseSold+"</span>"+
        "<span class='goods-discount'>"+parseFloat(mer.merDiscount).toFixed(1)+"折</span></div>"+
        "<div  class='iteminfo'>"+
        "<h3 class='goods-title'>"+mer.merchandiseName+"</h3>"+
        "<span class='goods-relprice'>¥"+parseFloat(mer.merchandisePrice).toFixed(2)+"</span>"+
        "<span class='goods-price'>¥"+parseFloat(mer.merchandiseOldPrice).toFixed(2)+"</span>"+
        "</div></a>");
		}
	},
	//商品数据初始化加载
	 initIndexMer:function(){
		 var merindexloadfinlish=0;//加载完成
		 
		   myUtils.myFootLoadingToast("55px",function(){
				var currentcount=1;
				if(localStorage.getItem("browseMerchandise")!=null){
					currentcount=JSON.parse(decode64(localStorage.getItem("browseMerchandise"))).length;
				}else {
					sessionStorage.setItem("merindexloadfinlish",0);//browseMerchandise==null,没完成
				}
				
				if(sessionStorage.getItem("merindexloadfinlish")==1){
					myUtils.myFootLoadingToast("55px",null,"remove");
					return;
				} 
				
	 $.ajax({  
			type : "get",  
			url : "/merchandise/browseMerchandise.json",  
			data : "currentCount=" + currentcount,  
			async : false,//取消异步 
			dataType:"json",
			success : function(data){  
			   if(data==''||data==null){
				   console.log("ds")
				myUtils.myFootLoadingToast("55px",null,"remove");
				myUtils.myLoadingToast("没有更多了");
				merindexloadfinlish=1;
				sessionStorage.setItem("merindexloadfinlish", merindexloadfinlish);
				return;
			}
			   var newData=data;//所有数据 
			   if(localStorage.getItem("browseMerchandise")!=null){
			  var olddata=JSON.parse(decode64(localStorage.getItem("browseMerchandise")));
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
	merchandise_details:function(mers){
		for ( var merid in mers) {
			var mer=mers[merid];
			console.log(mer.merchandiseImg[0].imgaddress)
			if(mer.merchandiseid==myUtils.GetQueryString("merid")){
			  $(".merchandise-img img").attr("src",encodeURIComponent(mer.merchandiseImg[0].imgaddress));
			  $(".merchandise-img .goods-sold").text("销量"+mer.merchandiseSold);
			  $(".merchandise-img .goods-stock").text("库存"+mer.merchandiseStock);
			  $(".merchandise-details .merchandise-title").text(mer.merchandiseName);
			  $(".merchandise-price .merchandise-relprice").text("¥"+parseFloat(mer.merchandisePrice).toFixed(2));
			  $(".merchandise-price .merchandise-price").text("¥"+parseFloat(mer.merchandiseOldPrice).toFixed(2));
			   //初始化购物数量
		  myUtils.merchandiseNumber(".merchandise-num",".merchandise-add",".merchandise-minus",mer.merchandiseStock);
			  	}
			}
		
	},
	//商品类别
	merCategory:function(data){
		//myUtils.slice(merchandises)
		for (var i = 0; i < data.length; i++) {
			console.log(data[0].merchandises[1].merchandiseImg[0].imgAddress);
			
      		$("#classification-left")
          	.append("<a class='btn' href='#'>"
                    +"<img src=''/>"
      	  			+"<div class='classification-left-title'>"+data[i].cateName+"</div>"
     			 	+"</a>");
          	
			}
	}
	//$().children("a:first-child").css("background-color","red");

};
