angular.module('starter.controllers', [])

.controller('shoppingCtrl', function($scope,$interval) {
    $scope.myActiveSlide = 0;
    $scope.downRefresh=false;
  $scope.list=[{id:100,age:30,name:"张三"},{},{}];
	  $scope.downRefresh=true;
	  var setInter=$interval(function(){
		  if($scope.list.length<8){  
	          var obj=[{id:101,age:30,name:"李四"},{},{},{}];
	          console.log(obj);
	        $scope.list.push(obj);
		  }else{
	        	$scope.downRefresh=false;
	        	console.log("没有更多了");
	        	//clearInterval(setInter);
	        	$interval.cancel(setInter);
	        }
	         //$scope.downRefresh=false;
	  },2000);
	
})

.controller('classificationCtrl', function($scope,$ionicModal) {
	//模型
	function showModal(urli){
		$ionicModal.fromTemplateUrl(urli, {
		    scope: $scope,
		    animation: 'silde-in-up'
		  }).then(function(modal) {
		    $scope.modal = modal;
		    $scope.modal.show();
	});
	}
	  //选择商品
	  $scope.showBlackTea = function() {
		  if($scope.modal!=null||$scope.modal!=undefined){
			  console.log($scope.modal);
			  $scope.modal.remove();
			  
		  }
		  showModal("tab-classification-right.html");
	   };
})

.controller('ChatDetailCtrl', function($scope, $stateParams, Chats) {
  $scope.chat = Chats.get($stateParams.chatId);
})

.controller('shoppingCircleCtrl', function($scope) {
  $scope.settings = {
    enableFriends: true
  };
})
.controller('CatCtrl', function($scope) {
 
	$scope.aaa="sdaf";

})
.controller('PersonCtrl', function($scope,$ionicModal,$timeout,mycheckTextService) {
	//初始化
	$scope.haveImg=false;
	$scope.user={};
	 $scope.user.userimg='http://www.runoob.com/try/demo_source/venkman.jpg';
	 $scope.user.username='278076304@qq.com';
	 $scope.user.usersignature='快乐知足常乐！';
	 $scope.user.usernicename='聂跃';
	 $scope.user.setusernicename=$scope.user.usernicename;
	 $scope.user.setusersignature=$scope.user.usersignature;
	 
	 
	console.log($scope.user.userimg);
	//模型
	function showModal(urli){
		$ionicModal.fromTemplateUrl(urli, {
		    scope: $scope,
		    animation: 'silde-in-up'
		  }).then(function(modal) {
		    $scope.modal = modal;
		    $scope.modal.show();
	});
	}
	//登录转注册
 $scope.LoginToRegister = function() {
	  console.log("tab-register.html"); 
	  $scope.modal.remove();
	  showModal("tab-register.html");
  };
  //登录
  $scope.openLogin = function() {
	  if($scope.modal!=null||$scope.modal!=undefined){
		  console.log($scope.modal);
		  $scope.modal.remove();
		  
	  }
	  showModal("tab-login.html");
   };
   //打开用户信息
   $scope.openUserInfo=function() {
	   if($scope.modal!=null||$scope.modal!=undefined){
			  console.log($scope.modal);
			  $scope.modal.remove();
			  
		  }
	   showModal("tab-userinfo.html");
   };
   //设置昵称页面
   $scope.UserInfoToUserNiceName=function() {
	   $scope.modal.remove();
	   showModal("tab-usernicename.html");
   };
   //设置个性签名页面
   $scope.UserInfoToUserSignature=function() {
			  $scope.modal.remove();
	   showModal("tab-usersignature.html");
   };
   //设置收货地址管理
   $scope.UserInfoToShippingAddress=function() {
	   $scope.modal.remove();
	   showModal("tab-shippingaddress.html");
   };
  $scope.closeModal = function() {
     $scope.modal.hide();
   };

   //当我们用完模型时，清除它！
   $scope.$on('$destroy', function() {
     $scope.modal.remove();
   });
   // 当隐藏模型时执行动作
   $scope.$on('modal.hide', function() {
     // 执行动作
     //$scope.openModal();
     alert('dsf')
   });
   // 当移动模型时执行动作
   $scope.$on('modal.removed', function() {
     // 执行动作
     //alert('removed')
   });
   
   $scope.doRefresh = function() {  
	   $scope.items = ['Item 1', 'Item 2', 'Item 3']; 
	    console.log('Refreshing!');  
	    $timeout( function() {  
	      //simulate async response  
	      $scope.items.push('New Item ' + Math.floor(Math.random() * 1000) + 4);  
	      console.log($scope.items);
	      //Stop the ion-refresher from spinning  
	      $scope.$broadcast('scroll.refreshComplete');  
	      
	    }, 1000);  
	        
	  }; 
	  //控制字符数
	  $scope.usernicenamecheck=function(num){
		  $scope.usernicenameerror=mycheckTextService($scope.user.setusernicename,num);
	  } 
	  $scope.usersignaturecheck=function(num){
		  $scope.usersignatureerror=mycheckTextService($scope.user.setusersignature,num);
	  } 
	 //设置昵称更新同步base
	  /*function myuserUpdateInfo(num,name,setname,usererror){
		  if (setname.length<=num) {
			  name=setname;
			  $scope.openUserInfo();
		  }else{
			  setname=name;
			usererror='';
		  }
	  };*/
	  /* $scope.saveusernicename=function(num){
	    	myuserUpdateInfo(num,$scope.user.usernicename,$scope.user.setusernicename,$scope.usernicenameerror);
	    };*/
	  
   $scope.saveusernicename=function(num){
	  if ($scope.user.setusernicename.length<=num) {
	 $scope.user.usernicename=$scope.user.setusernicename;
	 $scope.openUserInfo();
	  }else{
		  $scope.user.setusernicename=$scope.user.usernicename;
		  $scope.usernicenameerror='';
	  }
	    };
	    $scope.saveusersignature=function(num){
	    	if ($scope.user.setusersignature.length<=num) {
	    		$scope.user.usersignature=$scope.user.setusersignature;
	    		$scope.openUserInfo();
	    	}else{
	    		$scope.user.setusersignature=$scope.user.usersignature;
	    		$scope.usersignatureerror='';
	    	}
	    };
	
	    
	    
	    
	    //头像图片上传
	  userimgupload=function(file){
		  photoExt=file.value.substr(file.value.lastIndexOf(".")).toLowerCase();//获得文件后缀名
		//判断照片格式
		  if(photoExt!='.jpg'&&photoExt!='.png'){
		     alert("请上传后缀名为jpg/png的照片!");
		      return false;
		  }
		  var fileSize = 0;
		  var isIE = /msie/i.test(navigator.userAgent) && !window.opera;            
		  if (isIE && !file.files) {          
		       var filePath = file.value;            
		       var fileSystem = new ActiveXObject("Scripting.FileSystemObject");   
		       var file = fileSystem.GetFile (filePath);               
		       fileSize = file.Size;         
		  }else {  
		       fileSize = file.files[0].size;     
		  } 
		  fileSize=Math.round(fileSize/1024*100/1024)/100; //单位为MB
		  if(fileSize>=2){
		      alert("图片大小为"+fileSize+"MB，超过最大尺寸为2MB，请重新上传!");
		      return false;
		  }		  
		  //console.log(file);
	    	if (file.files && file.files[0])  
	    	 {
	         var reader = new FileReader(); 
	      	reader.onload = function(e){
	      		console.log(e.target.result);
	      		$scope.user.userimg=e.target.result;
	      		$scope.$apply();
	    	}
	      	reader.readAsDataURL(file.files[0]);
	      	$scope.haveImg=true;
	      }else{
	    	  $scope.user.userimg=file.value;
	      		$scope.$apply();
	    	  //console.log(file.value);
	    	  //prevDiv.innerHTML = '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>'; 
	      }
	    };
});