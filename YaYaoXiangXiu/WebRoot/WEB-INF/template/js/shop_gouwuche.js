
/*jQuery(function(){
	 购物车商品加减 
	jQuery(".this_good_nums").goodnums({zid:'good_zongjia',xclass:'good_xiaojis',max:5,min:1,typ:'+'});
	 删除购物车商品 
	jQuery(".shop_good_delete").goodDelete({zid:'good_zongjia',xclass:'good_xiaojis'});
});*/
$(function(){
	$(".cart_shopping_jian").each(function(){
		
 	$(this).click(function(){
 		var num = $(this).next().val();
 		num = parseInt(num);
 		num = num-1;
 		if(num<=1||isNaN(num)){
 			num = 1;
 		}
 		$(this).next().val(num);
 	});
	});
	$(".cart_shopping_jia").each(function(){
 	$(this).click(function(){
 		var num = $(this).prev().val();
 		num = parseInt(num);
 		if(isNaN(num)){
 			num=0;
 		}
 		num = num+1;
 		$(this).prev().val(num);
 	});
	});
	
 });