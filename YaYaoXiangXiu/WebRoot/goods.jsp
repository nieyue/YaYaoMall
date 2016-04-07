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
	<title>商品详细页面</title>
	<link rel="stylesheet" href="css/base.css" type="text/css" />
	<link rel="stylesheet" href="css/common.css" type="text/css" />
	<link rel="stylesheet" href="css/goodPic.css" type="text/css" />
     <link rel="stylesheet" href="css/style.css" type="text/css" />
	<link rel="stylesheet" href="css/manager.css" type="text/css" />
	<link rel="stylesheet" href="css/list.css" type="text/css" />
    <link rel="stylesheet" href="css/goods.css" type="text/css" />
    <script type="text/javascript" src="js/jquery.js" ></script>
    <script type="text/javascript" src="js/topNav.js" ></script>
    <script type="text/javascript" src="js/shop_goods.js" ></script>
	<script type="text/javascript" src="js/shop_goodPic_base.js"></script>
	<script type="text/javascript" src="js/lib.js"></script>
	<script type="text/javascript" src="js/163css.js"></script>
	 <script type="text/javascript" src="js/topNav_menu.js"></script>
	 <script type="text/javascript">
	 $(function(){
		//商品详情页面多图展示功能
		 var imgtu1=$("#imgtu1").attr("src");
		 var imgtu2=$("#imgtu2").attr("src");
		 var imgtu3=$("#imgtu3").attr("src");
		 
		 function insert_flg(str,flg,sn){
			 var newstr=str.split("").reverse().join("");
			 var result="";
			
		       var tmpq=newstr.substring(0,sn);
			   var tmph=newstr.substring(sn);
			   result+=tmpq+flg+tmph;
			   result=result.split("").reverse().join("");
		    return result;
		} 
		 imgtu1=insert_flg(imgtu1,"1-",4);
		 imgtu2=insert_flg(imgtu2,"2-",4);
		 imgtu3=insert_flg(imgtu3,"3-",4);
		 
		 $("#imgtu1").attr("src",imgtu1);
		 $("#imgtu2").attr("src",imgtu2);
		 $("#imgtu3").attr("src",imgtu3);
		 
		 //当前总条数
			var totals=$("#totals").text().trim().substring(0);
		 //当前总页数
			var totalPages=$("#totalPages").text().trim().substring(0);
		 //当前第几页
			var pageNo=$("#pageNo").text().trim().substring(0);
			if(totalPages==0){
				$(".pagination ul").html();
			}
			if(totalPages==1){
				$(".pagination ul").html(
				"<li><span>首页</span></li>"
				+"<li><span>上一页</span></li>"
				+"<li><span class='currentpage'>1</span></li>"
				+"<li><span>下一页</span></li>"
				+"<li><span>末页</span></li>"
						);
			}
			if(totalPages==2){
				$(".pagination ul").html(
				"<li><span>首页</span></li>"
				+"<li><span>上一页</span></li>"
				+"<li><span class='currentpage'>1</span></li>"
				+"<li><span>2</span></li>"
				+"<li><span>下一页</span></li>"
				+"<li><span>末页</span></li>"
						);
			}
			if(totalPages==3){
				$(".pagination ul").html(
				"<li><span>首页</span></li>"
				+"<li><span>上一页</span></li>"
				+"<li><span class='currentpage'>1</span></li>"
				+"<li><span>2</span></li>"
				+"<li><span>3</span></li>"
				+"<li><span>下一页</span></li>"
				+"<li><span>末页</span></li>"
						);
			}
			if(totalPages==4){
				$(".pagination ul").html(
				"<li><span>首页</span></li>"
				+"<li><span>上一页</span></li>"
				+"<li><span class='currentpage'>1</span></li>"
				+"<li><span>2</span></li>"
				+"<li><span>3</span></li>"
				+"<li><span>4</span></li>"
				+"<li><span>下一页</span></li>"
				+"<li><span>末页</span></li>"
						);
			}
			if(totalPages==5){
				$(".pagination ul").html(
				"<li><span>首页</span></li>"
				+"<li><span>上一页</span></li>"
				+"<li><span class='currentpage'>1</span></li>"
				+"<li><span>2</span></li>"
				+"<li><span>3</span></li>"
				+"<li><span>4</span></li>"
				+"<li><span>5</span></li>"
				+"<li><span>下一页</span></li>"
				+"<li><span>末页</span></li>"
						);
			} 
		 if(totalPages>5){
			   
			   $(".pagination ul").html("<li><span>首页</span></li>"
				+"<li><span>上一页</span></li>"
				+"<li><span class='currentpage'>1</span></li>"
				+"<li><span>2</span></li>"
				+"<li><span>3</span></li>"
				+"<li><span>4</span></li>"
				+"<li><span>5</span></li>"
				+"<li><span>...</span></li>"
				+"<li><span>"+totalPages+"</span></li>"
				+"<li><span>下一页</span></li>"
				+"<li><span>末页</span></li>"
				);
		   }
		   if(pageNo>=5&&pageNo<(parseInt(totalPages)-1)){
			   $(".pagination ul").html("<li><span>首页</span></li>"
						+"<li><span>上一页</span></li>"
						+"<li><span>1</span></li>"
						+"<li><span>...</span></li>"
						+"<li><span>"+(pageNo-1)+"</span></li>"
						+"<li><span class='currentpage'>"+pageNo+"</span></li>"
						+"<li><span>"+(parseInt(pageNo)+1)+"</span></li>"
						+"<li><span>...</span></li>"
						+"<li><span>"+totalPages+"</span></li>"
						+"<li><span>下一页</span></li>"
						+"<li><span>末页</span></li>"
						);
		   }
		   if(pageNo>5&&pageNo==(parseInt(totalPages)-1)){
			   $(".pagination ul").html("<li><span>首页</span></li>"
						+"<li><span>上一页</span></li>"
						+"<li><span>1</span></li>"
						+"<li><span>...</span></li>"
						+"<li><span>"+(pageNo-1)+"</span></li>"
						+"<li><span class='currentpage'>"+pageNo+"</span></li>"
						+"<li><span>"+(parseInt(pageNo)+1)+"</span></li>"
						+"<li><span>下一页</span></li>"
						+"<li><span>末页</span></li>"
						);
		   }
		   if(pageNo>5&&pageNo==parseInt(totalPages)){
			   $(".pagination ul").html("<li><span>首页</span></li>"
						+"<li><span>上一页</span></li>"
						+"<li><span>1</span></li>"
						+"<li><span>...</span></li>"
						+"<li><span>"+(pageNo-2)+"</span></li>"
						+"<li><span>"+(pageNo-1)+"</span></li>"
						+"<li><span class='currentpage'>"+pageNo+"</span></li>"
						+"<li><span>下一页</span></li>"
						+"<li><span>末页</span></li>"
						);
		   }
		 
		//分页评论
		 $(".pagination ul li").each(function(index){
			//当前页显示高亮
			 $(this).children().removeClass();
			 if($(this).children().text()==pageNo){
				 $(this).children().attr("class","currentpage");
			 }
		//分页评论的点击
			$(this).click(function(){
			 //分页首页失效
			if((($(this).children().text()=="首页")&&($(this).next().next().children().text()=="1")&&($(this).next().next().children().attr("class")=="currentpage"))
					||(($(this).children().text()=="上一页")&&($(this).next().children().text()=="1")&&($(this).next().children().attr("class")=="currentpage"))){
					alert("已经是第一页了！");
					return;
			}
			//分页末页失效	
			if((($(this).children().text()=="末页")&&($(this).prev().prev().children().text()==totalPages)&&($(this).prev().prev().children().attr("class")=="currentpage"))
					||(($(this).children().text()=="下一页")&&($(this).prev().children().text()==totalPages)&&($(this).prev().children().attr("class")=="currentpage"))){
					alert("已经是最后页了！");
					return;
				
			}
			if($(this).children().attr("class")=="currentpage"||$(this).children().text()=="..."){
				return;
			}else{
				var topaginationIndex=$(this).children().text();
				
					$.post("browseMerComment.dhtml",
							{
							tpn:topaginationIndex
							},
							function(data){
							
								location.href="goods.html";
							}
							);
				}
				
			});
		});
		
		//点击进入商品详情页面
			$(".clearfix").on("click",function(){
				
					$.post("loadEBMerchandise.dhtml",
							{
					loadEBMerchandiseImg:$(this).children().children().children("img").attr("src")
							},
					function(){
					location.href="goods.html";	
							});
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
	
	<!-- Goods Body -->
	<div class="shop_goods_bd clear">

		<!-- 商品展示 -->
		<div class="shop_goods_show">
			<div class="shop_goods_show_left">
				<!-- 商品展示 -->

				<div id="preview">
					<div class=jqzoom id="spec-n1" onClick="window.open('/')">
					<s:set name="EBMer" value="#session.EBMer"></s:set>
                    <s:if test="#EBMer==null or #EBMer==''">
                    <IMG height="350" src="images/xianqin1.jpg" jqimg="images/xianqin1.jpg" width="350">
                    </s:if>
                    <s:else>
					<IMG height="350" src="<s:property value='#session.EBMer.picture' />" jqimg="<s:property value='#session.EBMer.picture' />" width="350">
				     </s:else>
				  </div>
						<div id="spec-n5">
							<div class=control id="spec-left">
								<img src="images/left.gif" />
							</div>
							<div id="spec-list">
								<ul >
                                     <s:set name="EBMer" value="#session.EBMer"></s:set>
                                     <s:if test="#EBMer==null or #EBMer==''">
                                     <li><img src="images/xianqin1.jpg"></li>
                                     </s:if>
                                     <s:else>
									<li><img src="<s:property value='#session.EBMer.picture' />"> </li>
									<!-- <li><img src="images/xianqin1.jpg"> </li>
									<li><img src="images/xianqin2.jpg"> </li>
									<li><img src="images/xianqin3.jpg"> </li> -->
                                     </s:else>

								</ul>
							</div>
							<div class=control id="spec-right">
								<img src="images/right.gif" />
							</div>
							
					    </div>
			  </div>

					<SCRIPT type=text/javascript>
						$(function(){	
							
						   $(".jqzoom").jqueryzoom({
								xzoom:400,
								yzoom:400,
								offset:10,
								position:"right",
								preload:1,
								lens:1
							});
							$("#spec-list").jdMarquee({
								deriction:"left",
								width:350,
								height:56,
								step:2,
								speed:4,
								delay:10,
								control:true,
								_front:"#spec-right",
								_back:"#spec-left"
							});
							$("#spec-list img").bind("mouseover",function(){
								var src=$(this).attr("src");
								$("#spec-n1 img").eq(0).attr({
									src:src.replace("\/n5\/","\/n1\/"),
									jqimg:src.replace("\/n5\/","\/n0\/")
								});
								$(this).css({
									"border":"2px solid #ff6600",
									"padding":"1px"
								});
							}).bind("mouseout",function(){
								$(this).css({
									"border":"1px solid #ccc",
									"padding":"2px"
								});
							});				
						})
						</SCRIPT>
					<!-- 京东商品展示 End -->

			</div>
			<form action="addCartSelectMer.dhtml">
			<div class="shop_goods_show_right">
				<ul>
					<li>
						<strong style="font-size:16px; font-weight:bold;margin-left:100px;"><s:property value='#session.EBMer.merName' /></strong>					</li>
					<li>
						<label>【价 格】：</label>
						<span><strong><s:property value='#session.EBMer.price' /></strong>元</span>					</li>
					<li>
						<label>【尺 寸】：</label>
						<span><s:property value='#session.EBMer.merModel' /></span>					</li>
					<%-- <li>
						<label>【售 出】：</label>
						<span>99件</span>					</li> --%>
					<li>
						<label>【评 价】：</label>
						<span><s:property value="#session.totals"/>条评论</span>					</li>
					<li class="goods_num">
						<label>购买数量：</label>
					<span><a class="good_num_jian" id="good_num_jian" href="javascript:void(0);"></a><input type="text" name="goodsNumber" value="1" id="good_nums" class="good_nums" onkeyup="value=value.replace(/[^1234567890-]+/g,'')" /><a href="javascript:void(0);" id="good_num_jia" class="good_num_jia"></a></span></li>
					<li ><input type="image" src="images/gouw.gif"  class="tijiaoan"  onclick="document.getElementById('goodstijiao').onclick()"/>
						<input type="submit" id="goodstijiao" style="display: none"/>
						</li>
				</ul>
			</div>
			</form>
		</div>
		<!-- 商品展示 End -->

		<div class="clear mt15"></div>
		<!-- Goods Left -->
		<div class="shop_bd_list_left clearfix">


			<!-- 热卖推荐商品 -->
			<div class="shop_bd_list_bk clearfix">
				<div class="title">热卖推荐商品</div>
				<div class="contents clearfix">
					<ul class="clearfix">
						
						<li class="clearfix">
							<div class="goods_name">著绣工艺品 纯手工绣品</div>
							<div class="goods_pic"><span class="goods_price">¥ 388.0 </span><a href="javascript:;"><img src="merchandisePicture/embroideryBoutique_1/3.jpg" /></a></div>
							<div class="goods_xiaoliang">
								<span class="goods_xiaoliang_link"></span>
								<span class="goods_xiaoliang_nums">已销售<strong>28</strong>笔</span>
							</div>
						</li>

						<li class="clearfix">
							<div class="goods_name">著绣工艺品 纯手工绣品</div>
							<div class="goods_pic"><span class="goods_price">¥ 6800.0 </span><a href="javascript:;"><img src="merchandisePicture/embroideryBoutique_2/4.jpg" /></a></div>
							<div class="goods_xiaoliang">
								<span class="goods_xiaoliang_link"></span>
								<span class="goods_xiaoliang_nums">已销售<strong>98</strong>笔</span>
							</div>
						</li>

						<li class="clearfix">
							<div class="goods_name">著绣工艺品 纯手工绣品</div>
							<div class="goods_pic"><span class="goods_price">¥ 1288.0 </span><a href="javascript:;"><img src="merchandisePicture/embroideryBoutique_3/5.jpg" /></a></div>
							<div class="goods_xiaoliang">
								<span class="goods_xiaoliang_link"></span>
								<span class="goods_xiaoliang_nums">已销售<strong>67</strong>笔</span>
							</div>
						</li>

					</ul>
				</div>
			</div>
			<!-- 热卖推荐商品 -->
			<div class="clear"></div>

			<!-- 浏览过的商品 -->
			<div class="shop_bd_list_bk clearfix">
				<!-- <div class="title">浏览过的商品</div> -->
				<div class="contents clearfix">
					<ul class="clearfix">
						
						<li class="clearfix">
							<div class="goods_name">著绣工艺品 纯手工绣品</div>
							<div class="goods_pic"><span class="goods_price">¥ 388.0 </span><a href="javascript:;"><img src="merchandisePicture/embroideryDetails/13.jpg" /></a></div>
							<div class="goods_xiaoliang">
								<span class="goods_xiaoliang_link"></span>
								<span class="goods_xiaoliang_nums">已销售<strong>25</strong>笔</span>
							</div>
						</li>

						<li class="clearfix">
							<div class="goods_name">著绣工艺品 纯手工绣品</div>
							<div class="goods_pic"><span class="goods_price">¥ 6800.0 </span><a href="javascript:;"><img src="merchandisePicture/embroideryDetails/7.jpg" /></a></div>
							<div class="goods_xiaoliang">
								<span class="goods_xiaoliang_link"></span>
								<span class="goods_xiaoliang_nums">已销售<strong>21</strong>笔</span>
							</div>
						</li>


					</ul>
				</div>
			</div>
			<!-- 浏览过的商品 -->

		</div>
		<!-- Goods Left End -->

		<!-- 商品详情 -->
		<script type="text/javascript" src="js/shop_goods_tab.js"></script>
		<div class="shop_goods_bd_xiangqing clearfix">
			<div class="shop_goods_bd_xiangqing_tab">
				<ul>
					<li id="xiangqing_tab_1" onmouseover="shop_goods_easytabs('1', '1');" onfocus="shop_goods_easytabs('1', '1');" onclick="return false;"><a href="#"><span>商品详情</span></a></li>
					<li id="xiangqing_tab_2" onmouseover="shop_goods_easytabs('1', '2');" onfocus="shop_goods_easytabs('1', '2');" onclick="return false;"><a href="#"><span>商品评论</span></a></li>
					<li id="xiangqing_tab_3" onmouseover="shop_goods_easytabs('1', '3');" onfocus="shop_goods_easytabs('1', '3');" onclick="return false;"><a href="#"><span>商品咨询</span></a></li>
				</ul>
			</div>
			<div class="shop_goods_bd_xiangqing_content clearfix">
				<div id="xiangqing_content_1" class="xiangqing_contents clearfix">
					<p>
					<s:set name="EBMer" value="#session.EBMer"></s:set>
                     <s:if test="#EBMer==null or #EBMer==''">
                     </s:if>
                     <s:else>
                    
                     <h1 style="margin:1px 100px;color:red;font-size:36px;text-align:center;"><s:property value='#session.EBMer.merName' /></h1><br/>
                     <p style="color:red;text-indent:24px;Letter-spacing:5px;Line-height:30px;"><s:property value='#session.EBMer.merDesc' /></p><br/><br/>
                     
					<img id="imgtu1" width="700px" style="margin-top:20px;" src="<s:property value='#session.EBMer.picture' />"/>
					<img id="imgtu2" width="700px" style="margin-top:20px;" src="<s:property value='#session.EBMer.picture' />"/>
					<img id="imgtu3" width="700px" style="margin-top:20px;" src="<s:property value='#session.EBMer.picture' />"/>
					</s:else>
					</p>
				</div>
				<div id="xiangqing_content_2" class="xiangqing_contents clearfix">
				    <div style="width:690px;">
								<s:set name="paginationCommentList" value="#session.paginationCommentList"></s:set>
	                   			<s:if test="#paginationCommentList==null or #paginationCommentList.size==0">
								<div style="color:blue;font-size:12px;margin-left:300px;">
									暂时还没人评论，赶紧抢第一沙发！
								</div>
								</s:if>
				    		 	<s:else>
				    	 <div class="title" style="width:690px;margin-bottom:20px;font-size:24px;"><h3>评价列表</h3></div>
				      		 <table  style="width:705px;border-collapse:collapse;">
					     		 <thead class="tab_title" style="border:1px #999 solid;color:#666;background-color:#f0f0f4;">
					     			<tr>
						  				 <th style="width:80px;padding:10px;font-weight:700;text-align:center;"><span>满意度</span></th>
										 <th style="width:320px;padding:10px;font-weight:700;text-align:center;"><span>评价内容</span></th>
										 <th style="width:180px;padding:10px;font-weight:700;text-align:center;"><span>评价人</span></th>
										 <th style="width:100px;padding:10px;font-weight:700;text-align:center;"><span>宝贝信息</span></th>
										<%--  <th style="width:115px;"><span>操作</span></th> --%>
									</tr>
								</thead>
								<tbody id="comment_tbody" >
								<s:iterator value="#session.paginationCommentList">
									<tr id="<s:property value="id" />"><td colspan="4">
										<table class="good" style="height:50px;">
											<tbody>
												<tr style="border:1px #999 solid;">
													<td class="pingjia_pic" style="text-align:center;" >
														<s:if test="title=='好评!'">
														<img src="images/p1.png" width="24" height="24" style="margin:0 auto;">
														</s:if>
														<s:if test="title=='中评!'">
														<img src="images/p2.png" width="24" height="24" style="margin:0 auto;">
														</s:if>
														<s:if test="title=='差评!'">
														<img src="images/p3.png" width="24" height="24" style="margin:0 auto;">
														</s:if>
													</td>
													<td class="pingjia_title"><span><s:property value="title"/>&nbsp;&nbsp;
														<s:property value="content" /> </span><br />
													  <div style="color:#999;">
													  [<s:property value="commentDate" />]
													   <a>回复（0）</a>
													   <a>赞（0）</a>
													  </div>
													</td>
													<td class="pingjia_danjia" style="text-align:center;" ><strong><s:property value="member.loginName" /> </strong><br/>
														<strong><s:property value="member.memberlevel.levelName" /> </strong>
													</td>
													<td class="pingjia_shuliang" style="text-align:center;"><s:property value="merchandise.merName" /> <br />
														<img  src="<s:property value='merchandise.picture'/>" style="width:62px;height:62px;margin:0 auto;"/> <br />
													</td>
													<!-- <td class="pingjia_caozuo"><a href="javascript:;">删除</a></td> -->
													
												</tr>
											</tbody>
										</table>
									  </td>
									  </tr>
								</s:iterator>
					  			</tbody>
				    		 </table>
				    		 	<div class="pagination"> 
				    		 	 		<div style="display:none;">总共有<div id="totals" style="display:inline-block;"><s:property value="#session.totals"/></div>条评论</div>
				    		 	 		<div style="display:none;">总共有<div id="totalPages" style="display:inline-block;"><s:property value="#session.totalPages"/></div>页</div>
				    		 	 		<div style="display:none;">当前为第<div id="pageNo" style="display:inline-block;"><s:property value="#session.pageNo"/></div>页</div>
				 					<ul>
				    		 	 		<li><span>首页</span></li>
										<li><span>上一页</span></li>
										<%-- <s:set value="#session.totalPages" id="totalPages"></s:set>
						
										 <s:iterator value="#session.totalPages.size" status="st" begin="1" end="totalPages" >
										<li><span><s:property value="#st.index+1"/></span></li>
										</s:iterator> --%>
										<li><span class="currentpage">1</span></li>
										<li><span>2</span></li>
										<li><span>3</span></li>
										<li><span>4</span></li>
										<li><span>5</span></li> 
										
										<li><span>下一页</span></li>
										<li><span>末页</span></li>
									</ul> 
								</div>
				    		 	</s:else>
			        </div> 
					
				</div>

				<div id="xiangqing_content_3" class="xiangqing_contents clearfix">
					<p>QQ:278076304</p>
				</div>
			</div>
		</div>
		<!-- 商品详情 End -->

	</div>
	<!-- Goods Body End -->

<!-- Footer -->
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
</body>
</html>