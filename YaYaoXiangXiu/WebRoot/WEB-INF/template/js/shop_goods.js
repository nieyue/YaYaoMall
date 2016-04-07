
 jQuery(function(){
	 
	 $("#good_nums").on("change",function(){
		 var num=$("#good_nums").val();
		 if(!num||isNaN(num)||num<=0){
			 num=1;
			 $("#good_nums").val(num);
		 }
		 
	 });
 	jQuery("#good_num_jian").click(function(){
 		var num = jQuery("#good_nums").val();
 		num = parseInt(num);
 		num = num-1;
 		if(num<=1||isNaN(num)){
 			num = 1;
 		}
 		jQuery("#good_nums").val(num);
 	});

 	jQuery("#good_num_jia").click(function(){
 		var num = jQuery("#good_nums").val();
 		num = parseInt(num);
 		if(isNaN(num)){
 			num=0;
 		}
 		num = num+1;
 		jQuery("#good_nums").val(num);
 	});
 });