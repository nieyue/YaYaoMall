/*
 * 改程序封装了GlobalProvinces_extend.js、GlobalProvinces_main.js两个文件中的对象和数组
 * 
 * @作者：侯伟
 * @创建日期：2007-07-20
 * 
 * 
 */


function initLocation2(option)
{
	
	option = jQuery.extend({
		modifysheng:"modifysheng",		//省的网页ID
		modifyshi:"modifyshi",			//市的网页ID
		modifyxian:"modifyxian",		//县的网页ID
		modifyxiang:"modifyxiang",		//乡的网页ID
		modifysheng_val:"",		//默认省份
		modifyshi_val:"",			//默认地区
		modifyxian_val:"",		//默认县
		modifyxiang_val:""		//默认乡镇
	},option||{});
	
	
	if(option.modifysheng_val == ""){
		option.modifysheng_val == "-1";
	}
		
	var gpm = new GlobalProvincesModule;



	gpm.def_province = ["---", -1];

	gpm.initProvince(document.getElementById(option.modifysheng));
	
	gpm.initCity1(document.getElementById(option.modifyshi), option.modifysheng_val);

	gpm.initCity2(document.getElementById(option.modifyxian), option.modifysheng_val, option.modifyshi_val);

	gpm.initCity3(document.getElementById(option.modifyxiang), option.modifysheng_val, option.modifyshi_val, option.modifyxian_val);


	gpm.selectProvincesItem(document.getElementById(option.modifysheng), option.modifysheng_val);

	gpm.selectCity2Item(document.getElementById(option.modifyxian), option.modifyxian_val);

	gpm.selectCity1Item(document.getElementById(option.modifyshi), option.modifyshi_val);

	
	
	if(document.getElementById(option.modifyxiang).options.length > 1){
		gpm.selectCity2Item(document.getElementById(option.modifyxiang), option.modifyxiang_val);
		document.getElementById(option.modifyxiang).style.display ="inline";
		document.getElementById(option.modifyxiang).style.display = "inline";
	}

	



	var onchgProv = function()
	{	
		gpm.initCity1(document.getElementById(option.modifyshi), gpm.getSelValue(document.getElementById(option.modifysheng)));
		gpm.initCity2(document.getElementById(option.modifyxian), '', '');		/* clear city2 select options*/
		gpm.initCity3(document.getElementById(option.modifyxiang), '', '', '');
		$("#"+option.modifyxiang).hide();
		
	}
	var onchgCity1 = function()
	{
		gpm.initCity2(document.getElementById(option.modifyxian), gpm.getSelValue(document.getElementById(option.modifysheng)), gpm.getSelValue(document.getElementById(option.modifyshi)));
		gpm.initCity3(document.getElementById(option.modifyxiang), '', '', '');
		$("#"+option.modifyxiang).hide();
		
	}

	var onchgStreet1 = function(){
		
		gpm.initCity3(document.getElementById(option.modifyxiang), gpm.getSelValue(document.getElementById(option.modifysheng)), gpm.getSelValue(document.getElementById(option.modifyshi)), gpm.getSelValue(document.getElementById(option.modifyxian)));

		if($("#"+option.modifyxiang).children().length > 1) {
				$("#"+option.modifyxiang).show();
		} else {
				$("#"+option.modifyxiang).hide();
		}
	}


	if(option.modifyxiang_val == "") 
		$("#"+option.modifyxiang).hide();
	$("#"+option.modifysheng).change(onchgProv);
	$("#"+option.modifyshi).change(onchgCity1);
	$("#"+option.modifyxian).change(onchgStreet1);
	
	



}