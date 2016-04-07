<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,com.yayao.action.*"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%    
String path = request.getContextPath();    
// 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是 http://localhost:8080/MyApp/）:    
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";    
%> 
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<meta name="Keywords" content="湘绣，收藏，艺术品，文化，陶瓷，刺绣"/>
	<title>购物车页面</title>
	<link rel="stylesheet" href="css/base.css" type="text/css" />
	<link rel="stylesheet" href="css/common.css" type="text/css" />

	<link rel="stylesheet" href="css/gouwuche.css" type="text/css" />
    <script type="text/javascript" src="js/jquery.js" ></script>
    <script type="text/javascript" src="js/GlobalProvinces_extend.js" ></script>
    <script type="text/javascript" src="js/GlobalProvinces_main.js" ></script>
    <script type="text/javascript" src="js/initLocation.js" ></script>
    <script type="text/javascript" src="js/initLocation2.js" ></script>
    <script type="text/javascript" src="js/topNav_menu.js"></script>
    
    <style type="text/css">
    .shop_bd_shdz_title{width:1000px; margin-top: 10px; height:50px; line-height: 50px; overflow: hidden; background-color:#F8F8F8;}
    .shop_bd_shdz_title h3{width:120px; text-align: center; height:40px; line-height: 40px; font-size: 14px; font-weight: bold;  background:#FFF; border:1px solid #E8E8E8; border-radius:4px 4px 0 0; float: left;  position: relative; top:10px; left:10px; border-bottom: none;}
    .shop_bd_shdz_title p{float: right;}
    .shop_bd_shdz_title p a{margin:0 8px; color:#555555;}

	.shop_bd_shdz_lists{width:1000px;}
	.shop_bd_shdz_lists ul{width:1000px;}
	.shop_bd_shdz_lists ul li{width:980px; border-radius: 3px; margin:5px 0; padding-left:18px; line-height: 40px; height:40px; border:1px solid #FFE580; background-color:#FFF5CC;}
	.shop_bd_shdz_lists ul li label{color:#626A73; font-weight: bold;}
	.shop_bd_shdz_lists ul li label span{padding:10px;}
	.shop_bd_shdz_lists ul li em{margin:0 4px; color:#626A73;}

	.shop_bd_shdz{width:1000px; margin:10px auto 0;}
	.shop_bd_shdz_new{border:1px solid #ccc; width:998px;}
	.shop_bd_shdz_new div.title{width:990px; padding-left:8px; line-height:35px; height:35px; border-bottom:1px solid #ccc; background-color:#F2F2F2; font-color:#656565; font-weight: bold; font-size:14px;}
	.shdz_new_form{width:980px; padding:9px;}
	.shdz_new_form ul{width:100%;}
	.shdz_new_form ul li{clear:both; width:100%; padding:5px 0; height:25px; line-height: 25px;}
	.shdz_new_form ul li label{float:left;width:100px; text-align: right; padding-right: 10px;}
	.shdz_new_form ul li label span{color:#f00; font-weight: bold; font-size:14px; position: relative; left:-3px; top:2px;}
    </style>

	<script type="text/javascript">
	$(function(){
		 
		$("#new_add_shdz_btn").click(function(){
			if($("#new_add_shdz_contents").is(":visible")){
			$("#new_add_shdz_contents").hide(500);
			
			}
			else{
			$("#new_add_shdz_contents").show(500);
				}
		}); 
		
		
		//防止数量错误
		$(".good_nums").on("change",function(){
			 var num=$(this).val();
			 if(!num||isNaN(num)||num<=0){
				 num=1;
				 $(this).val(num);
			 }
			 
		 });
		//减少购物商品数量
		$(".good_num_jian").each(function(){
			$(this).click(function(){
	 		var num = $(this).next().val();
	 		num = parseInt(num);
	 		num = num-1;
	 		if(num<=1||isNaN(num)){
	 			num = 1;
	 			
	 		}
			
	 		$(this).next().val(num);
			
			var danjia=$(this).parent().parent().prev().children().children().html();
			$(this).parent().parent().next().children().children().html(parseFloat(danjia*num).toFixed(1));
			
			var zongjia=0;
			$("#goodTbody .xiaoji").each(function(){
				zongjia+=parseFloat($(this).html());
			});
			$("#good_zongjia").html(parseFloat(zongjia).toFixed(1));
	 	});
		});
		//增加购物商品数量
		$(".good_num_jia").each(function(){
			
	 	$(this).click(function(){
	 		var num = $(this).prev().val();
	 		num = parseInt(num);
	 		if(isNaN(num)){
	 			num=0;
	 		}
	 		num = num+1;
	 		$(this).prev().val(num);
	 		var danjia=$(this).parent().parent().prev().children().children().html();
			$(this).parent().parent().next().children().children().html(parseFloat(danjia*num).toFixed(1));
			var zongjia=0;
			$("#goodTbody .xiaoji").each(function(){
				zongjia+=parseFloat($(this).html());
			});
			$("#good_zongjia").html(parseFloat(zongjia).toFixed(1));
			
	 	});
		});
		//获取json
		function getJson(){
			var saveCartJSON="";
			saveCartJSON+="{'jl':[{";
			$("#goodTbody tr").each(function(index){
				var id=$(this).attr("id");
				var number=$(this).children().children().children(".good_nums").val();
				saveCartJSON+="'id':'"+id+"','number':'"+number+"'";
					if(index>($("#goodTbody tr").length-2)){
						saveCartJSON+="}";
					  }else{
						  saveCartJSON+="},{";
					  }
					});
					saveCartJSON+="]}";
					return saveCartJSON;
		}
		//删除购物
		$(".shop_good_delete").each(function(){
			$(this).click(function(){
				
				
							/* $.ajax({
							type:"POST",
							url: "changeCartSelectMer.dhtml",
							contentType:"application/x-www-form-urlencoded",
			 				data:saveCartJSON,//对象转json字符串参数
			 				dataType:"json",
			 				success:function(){
			 					
			 					//alert(saveCartJSON);
			 				}
				       }); */
				       var jsondata=getJson();
				       var cartselectmerindex =$(this).parent().parent().attr("id");
				if(confirm("确定删除吗？")){
				       $.post(
				    		   "changeCartSelectMer.dhtml",
				    		   {
				    			  data: jsondata
				    		   },
				    		   function(){
			$.post(
	 				"delCartSelectMer.dhtml",
	 				{
	 					cartselectmerindex:cartselectmerindex
	 				},
	 				function(){
	 					location.href="cartAddressList.html";
	 				});
				    		   });
				}else{
					return false;
				}			  
			});
		});
		
		//提交购物
		 $("#cartToAddress").click(function(){
			 var jsondata=getJson();
			 var ischeck=$("input:radio:checked").val();
			 
			 if(ischeck!=null||ischeck!=undefined){
				 $.post(
				     "changeCartSelectMer.dhtml",
				     {
				       data:jsondata
				     },
				     function(){
				    	 //alert(ischeck);
				      $.post(
				    		"submitOrders.dhtml",
				    		{
				    			ischeck:ischeck
				    		},function(){
				    			//alert(ischeck);
			 			location.href="cartSuccess.html";	
				    		}); 
				    			   });
				}else{
				 alert("对不起，您还没有选择收货地址！");
				    		   }				
				});
   
	});
	</script>
</head>
<body>
	<!-- Header-->
	<div class="shop_hd">

		<div class="shop_hd_topNav">
			<div class="shop_hd_topNav_all">
				<div class="shop_hd_topNav_all_left"><a href="index.html"><img src="images/0.jpg" /></a></div>
				<div class="shop_hd_topNav_all_right">
					<ul class="topNav_quick_menu">
						<li><a href="cartShoppingList.html"><img src="images/1.jpg" /></a></li>
					</ul>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		
		<div class="clear"></div>
		
  <div class="shop_hd_menu">
            <!-- 普通导航菜单 -->
    <ul class="shop_hd_menu_nav">
     <li><img style="margin-top:-12px" src="images/Logo.png" border="0"></li>
				<li class="link"><a href="index.html"><img src="images/m1.jpg" border="0" /></a></li>
				<li class="link"><a href="embroideryCustom.html"><img src="images/m2.jpg" border="0" /></a></li>
				<li class="link"><a href="ceramicCustom.html"><img src="images/m3.jpg" border="0" /></a></li>
				<li class="link"><a href="embroideryBoutique.html"><img src="images/m4.jpg" border="0" /></a></li>
				<li class="link"><a href="ceramicBoutique.html"><img src="images/m5.jpg" border="0" /></a></li>
    </ul>
			<!-- 普通导航菜单 End -->
   </div>

	</div>
	<div class="clear"></div>
	<!-- Header End -->
	<div class="shop_hd_breadcrumb">
		<strong>当前位置：</strong>
		<span>
			<a href="index.html">首页</a>&nbsp;›&nbsp;
			<a href="cartShoppingList.html">我的购物车</a>
		</span>
	</div>
	<div class="clear"></div>



	
	<!-- 购物车 Body -->
	<div class="shop_gwc_bd clearfix">
		<div class="shop_gwc_bd_contents clearfix">

			<!-- 购物流程导航 -->
			<div class="shop_gwc_bd_contents_lc clearfix">
				<ul>
					<li class="step_a">确认购物清单</li>
					<li class="step_b hover_b">确认收货人资料及送货方式</li>
					<li class="step_c">购买完成</li>
				</ul>
			</div>
			<!-- 购物流程导航 End -->
			<div class="clear"></div>
			<!-- 收货地址 title -->
			<div class="shop_bd_shdz_title">
				<h3>收货人地址</h3>
				<p><a href="javascript:;" id="new_add_shdz_btn">新增收货地址</a><a href="manageConsigneeAddress.html">管理收货地址</a></p>
			</div>
			<div class="clear"></div>
			<!-- 收货人地址 Title End -->
			<div class="shop_bd_shdz clearfix">
				<div class="shop_bd_shdz_lists clearfix">
					<ul id="manageAddress_ul">
					<%-- <li><label>寄送至：<span><input type="radio" name="radiobutton" value="radiobutton"></span></label><em>广东</em><em>广州市</em><em>天河区</em><em>东圃大街</em><em>雅耀(收)</em><em>1336699232</em></li>

					<li><label>寄送至：<span><input type="radio" name="radiobutton" value="radiobutton"></span></label><em>广东</em><em>广州市</em><em>天河区</em><em>东圃大街</em><em>雅耀(收)</em><em>1336699232</em></li>
					
					<li><label>寄送至：<span><input type="radio" name="radiobutton" value="radiobutton"></span></label><em>广东</em><em>广州市</em><em>天河区</em><em>东圃大街</em><em>雅耀(收)</em><em>1336699232</em></li> --%>
                  <s:set name="conList" value="#session.conList"></s:set>
					<s:if test="#conList==null or #conList.size==0">
	                  <span style="color:blue;font-size:12px;margin-left:300px;">
	                                               还没有添加收货地址，赶紧添加吧！
			           </span>   
	                </s:if>
	        <s:iterator value="#session.conList">
			<s:if test="hasOrder==0 or hasOrder==1">
			<li id="<s:property value="id" />"> <label>
			<span>
			  <input type="radio" name="radiobutton" value="<s:property value='id' />"></span></label>
			  <em><s:property value="address" /></em>
			  <em>电话:<s:property value="telePhone" /></em>
			  <em>手机:<s:property value="cellPhone" /></em>
			  <span class="admin_shdz_btn">

			</span>
			</li>
			</s:if>
			
		    </s:iterator>	
					</ul>
				</div>
				<!-- 新增收货地址 -->
				<div id="new_add_shdz_contents" style="display:none;" class="shop_bd_shdz_new clearfix">
					<div class="title">新增收货地址</div>
					<div class="shdz_new_form">
						<form action="cartManageConsigneeAddress.dhtml" method="post">
							<ul>
								<li><label for=""><span>*</span>收货人姓名：</label>
								<input type="text" class="name inputid" name="receiptName" /></li>
								<li><label for=""><span>*</span>所在地址：</label>
									<select id="sheng" name="province">
										<!-- <option value="">广东</option> -->
									</select>省
									<select id="shi" name="city">
										<!-- <option value="">广州</option> -->
									</select>市
									<select id="xian" name="country">
										<!-- <option value="">天河</option> -->
									</select>县
									<select id="xiang" name="street" >
									<%-- 
									 <option value="">--</option>
									 --%>
									</select>镇或街道 
								</li>
								<li><label for=""><span>*</span>详细地址：</label>
								<input type="text" class="xiangxi inputid" name="address"/></li>
								<li><label for=""><span></span>邮政编码：</label>
								<input type="text" class="youbian inputid" name="zip"/></li>
								<li><label for=""><span></span>电话：</label>
								<input type="text" class="dianhua inputid" name="telePhone"/></li>
								<li><label for=""><span></span>手机号：</label>
								<input type="text" class="shouji inputid" name="cellPhone"/></li>
								<li><label for="">&nbsp;</label><input type="submit" value="增加收货地址" /></li>
							</ul>
							<s:token></s:token>
						</form>
					</div>
				</div>
				<!-- 新增收货地址 End -->
			</div>
			<div class="clear"></div>
			<!-- 购物车列表 -->
			<div class="shop_bd_shdz_title">
				<h3>确认购物清单</h3>
			</div>
			<div class="clear"></div>
			<s:set value="#session.totalMoney" name="totalMoney">
				</s:set>
				<s:if test="#totalMoney==null or #totalMoney==''"><div class="shop_gwc_bd clearfix" style="width:980px;">
	
			<div class="empty_cart mb10" style="width:980px;">
				<div class="message">
			
           <p>购物车内暂时没有商品，您可以去<a href="index.html">首页</a>挑选喜欢的商品</p>
		</div>
		</div>
		</div>
    	<br/>
    	<br/>
   		 <br/>
    	<br/>
    	<br/>
    	<br/>
    	<br/>
   		
				</s:if>
				<s:else>
			<table>
				<thead>
					<tr>
						<th colspan="2"><span>商品</span></th>
						<th><span>单价(元)</span></th>
						<th><span>数量</span></th>
						<th><span>小计</span></th>
						<th><span>操作</span></th>
					</tr>
				</thead>
				<tbody id="goodTbody">
                  <s:iterator value="#session.cartSelectedMerList" >
					<tr id="<s:property value="id" />">
						<td class="gwc_list_pic"><img src="<s:property value="merchandise.picture" />" /></td>
						<td class="gwc_list_title"><s:property value="merchandise.merName" /></td>
						<td class="gwc_list_danjia"><span>￥<strong><s:property value="merchandise.price" /></strong></span></td>
						<td class="gwc_list_shuliang"><span><a class="good_num_jian" href="javascript:;">-</a>
					  <input type="text" value="<s:property value='number' />" class="good_nums" />
					  <a href="javascript:;" class="good_num_jia">+</a></span></td>
						<td class="gwc_list_xiaoji"><span>￥<strong  class="good_xiaojis xiaoji"><s:property value="money" /></strong></span></td>
						<td class="gwc_list_caozuo"><!-- <a href="merchandiseCollection.html">收藏</a> --><a href="javascript:;" class="shop_good_delete">删除</a></td>
					</tr>
                   </s:iterator>

				</tbody>
				<tfoot>
					<tr>
						<td colspan="6">
							<div class="gwc_foot_zongjia">商品总价(不含运费)<span>￥<strong id="good_zongjia"><s:property value="#totalMoney" /></strong></span></div>
							<div class="clear"></div>
							<div class="gwc_foot_links">
								<a href="cartShoppingList.html" class="go">返回上一步</a>
								<a id="cartToAddress" href="javascript:;" class="op">确认收货地址</a>
							</div>
						</td>
					</tr>
				</tfoot>
			</table>
			   </s:else>
			<!-- 购物车列表 End -->

		</div>
	</div>
	<!-- 购物车 Body End -->
	<div class="clear"></div>
<div class="foot">
	<div class="faq">
                <dl>
                    <dt>帮助中心</dt>
                    <dd><a href="#"><span>积分兑换说明</span></a></dd>
                    <dd><a href="#"><span>积分明细</span></a></dd>
                    <dd><a href="#"><span>查看已购买商</span></a></dd>
                    <dd><a href="#"><span>我要买</span></a></dd>
                    <dd><a href="#"><span>忘记密码</span></a></dd>
                </dl>
                
                <dl>
                    <dt>店主之家</dt>
                    <dd><a href="#"><span>如何申请开店</span></a></dd>
                    <dd><a href="#"><span>商城商品推荐</span></a></dd>
                    <dd><a href="#"><span>如何发货</span></a></dd>
                    <dd><a href="#"><span>查看已售商品</span></a></dd>
                    <dd><a href="#"><span>如何管理店铺</span></a></dd>
                </dl>
                
                <dl>
                    <dt>支付方式</dt>
                    <dd><a href="#"><span>公司转账</span></a></dd>
                    <dd><a href="#"><span>邮局汇款</span></a></dd>
                    <dd><a href="#"><span>分期付款</span></a></dd>
                    <dd><a href="#"><span>在线支付</span></a></dd>
                    <dd><a href="#"><span>如何注册支付</span></a></dd>
                </dl>
                
                <dl>
                    <dt>售后服务</dt>
                    <dd><a href="#"><span>退款申请</span></a></dd>
                    <dd><a href="#"><span>返修/退换货</span></a></dd>
                    <dd><a href="#"><span>退换货流程</span></a></dd>
                    <dd><a href="#"><span>退换货政策</span></a></dd>
                    <dd><a href="#"><span>联系卖家</span></a></dd>
                </dl>
                
                <dl>
                    <dt>客服中心</dt>
                    <dd><a href="#"><span>修改收货地址</span></a></dd>
                    <dd><a href="#"><span>商品发布</span></a></dd>
                    <dd><a href="#"><span>会员修改个人</span></a></dd>
                    <dd><a href="#"><span>会员修改密码</span></a></dd>
                </dl>
                
                <dl>
                    <dt>关于我们</dt>
                    <dd><a href="#"><span>合作及洽谈</span></a></dd>
                    <dd><a href="#"><span>招聘英才</span></a></dd>
                    <dd><a href="#"><span>联系我们</span></a></dd>
                    <dd><a href="#"><span>关于Shop</span></a></dd>
                </dl>
                
                
      </div>
	  <div class="clear"></div>
       <div class="foot_link">
                <p>
                    <a href="index.html">首页</a>|
                    <a href="#">招聘英才</a>|
                    <a href="#">广告合作</a>|
                    <a href="#">关于我们</a>|
                    <a href="#">关于我们</a>
               </p>
        </div>
       <div class="foot_copy"><p>Copyright 2015 itcast Inc.,All rights reserved.</p><p style="margin:10px 0;"> <img src="images/shi.png"  /></p></div>
</div>
	<!-- Footer End -->
	<script type="text/javascript">

	$(function(){
		initLocation(
			{sheng_val:"湖南",shi_val:"长沙",
			xian_val:"长沙市"});
		initLocation2(
			{modifysheng_val:"湖南",modifyshi_val:"长沙",
				modifyxian_val:"长沙市"});
		});
	</script>
</body>
</html>