/**
 * 自动a标签滑过透明
 */
for (var int = 0; int < document.getElementsByTagName('a').length; int++) {
	//var divthis=document.getElementsByTagName('div')[int];

	//console.log(divthis)
	(function(int){
	document.getElementsByTagName('a')[int].addEventListener('mouseover',function aaa(){
		this.style.opacity=0.5;
	});
	document.getElementsByTagName('a')[int].addEventListener('mouseout',function aaa(){
		this.style.opacity=1;
	});
	})(int);
	
}
/**
**设置全局变量事件
*/
var myTouchEvents={
		touchstart:"touchstart",
		touchmove:"touchmove",
		touchend:"touchend",
		/**
		 * 判断手机还是PC
		 */
		isPC:function(){
			    var userAgentInfo = navigator.userAgent;
			    var Agents = ["Android", "iPhone",
			                "SymbianOS", "Windows Phone",
			                "iPad", "iPod"];
			    var flag = true;
			    for (var v = 0; v < Agents.length; v++) {
			        if (userAgentInfo.indexOf(Agents[v]) > 0) {
			            flag = false;
			            break;
			        }
			    }
			    return flag;
		},
		/**
		 * 判断手机还是PC,更改touch为鼠标事件
		 */
		initTouchEvents:function(){
			if(this.isPC()){
				this.touchstart = "mousedown";
                this.touchmove = "mousemove";
                this.touchend = "mouseup";
			}
		}
		
};

/**
 * 模拟登录
 * 
 */
var userData={
		userInit:{
		userName:'nieyue',
		userPassword:hex_sha1('123456'),
		userIMG:'resources/img/preLoding.jpg',
		userNiceName:'添加昵称',
		userSignature:'把你爱好留在这里！',
		userEmail:'邮箱认证后可以用它登陆',
		userPhone:'手机号认证后可以用它登陆',
		userIdentity:'点击认证',
		userReceiptAddress:'添加收货地址',
		init:function(){
			localStorage.getItem("userName", userName);
		}
			
},
  userPerson:{
	  userName:'nieyue',
	  userNiceName:'聂跃',
		userPassword:hex_sha1('123456'),
		userIMG:'http://img.mukewang.com/user/54859e4f00019f2a01000100-40-40.jpg',
		userSignature:'我是一直笑笑笑!',
		userEmail:'278076545@qq.com',
		userPhone:'15488654845',
		userIdentity:'430504194705050468',
		userReceiptAddress:'湖南长沙岳麓区晟通城',
		init:function(){
			localStorage.getItem("userName", userName);
		}
}

};

/**
 * 初始化
 * 
 */

myTouchEvents.initTouchEvents();











