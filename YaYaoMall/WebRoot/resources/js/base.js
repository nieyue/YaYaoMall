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
 * 初始化
 * 
 */

myTouchEvents.initTouchEvents();















