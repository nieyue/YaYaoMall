// JavaScript Document
$(document).ready(function(){
	
	
	$(".imgid").each(function(){
		$(this).css("text-align","center").css("font-size","18px").css("color","#801dae");  
	});
	//图片的阴影效果
	$("body").on({
	mouseover:function() {
	$(this).css("border","solid 0 #ccc");
	$(this).css("box-shadow","4px 2px 6px #CCC,-4px -2px 6px #CCC");
	},
	mouseout:function(){
		$(this).css("border","none");
		$(this).css("box-shadow","none");
		}
	},".imgid");
 //输入框的阴影效果

	$(".inputid").on("focus",function(){
	$(this).css("border","solid 1px #ccc");
	$(this).css("box-shadow","4px 2px 6px #CCC,-4px -2px 6px #CCC");
	});
	$(".inputid").on("blur",function(){
	$(this).css("border","solid 1px #999");
	$(this).css("box-shadow","none");
	});
});