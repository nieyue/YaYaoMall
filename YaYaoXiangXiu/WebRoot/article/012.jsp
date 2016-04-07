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
	<title>湘绣文渊</title>
	<link rel="stylesheet" href="css/base.css" type="text/css" />
	<link rel="stylesheet" href="css/common.css" type="text/css" />
	<link rel="stylesheet" href="css/gouwuche.css" type="text/css" />
    <script type="text/javascript" src="js/jquery.js" ></script>
    <script type="text/javascript" src="js/jquery.cookie.js" ></script>
    <script type="text/javascript" src="js/topNav_menu.js"></script>
   
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
	
	<div class="clear"></div>

	
	<!-- 购物车 Body -->
	<div class="shop_gwc_bd clearfix">
	
		
		<!-- 购物车有商品 -->
		<div class="shop_gwc_bd_contents clearfix">
		<div style="padding:50px">
		<h1 style="margin:1px 10px;color:red;font-size:36px;text-align:center;">“俄罗斯援华抗战老战士中国行”湖南站启动</h1><br/><br/>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;俄罗斯援华抗战老战士们继出席9月3日纪念抗日战争暨世界反法西斯战争胜利70周年活动天安门广场大阅兵后，俄中友协副主席叶甫盖尼·康斯坦丁诺维奇·奥巴索夫、全俄老战士委员会副主席瓦西里·伊凡诺夫·格涅兹季洛夫中将、俄罗斯国际技术科学院副院长尼古拉·弗拉基米洛维奇·崔可夫院士一行受邀从北京出发，赴前苏联空军志愿队以及前苏联红军曾经战斗过的张家口、贵阳、长沙等地参观访问。</p>
    <p style="margin:10px 50px "><img style="width:800px;height:600px;" alt="游乐天堂" src="article/img/012_3.jpg"></p>
    
　　<p style="color:red;margin-left:300px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;活动承办单位雅耀（湖南）科技董事长现场致辞</p>
　　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;9月10日下午，“俄罗斯援华抗战老战士中国行”一行由贵阳乘坐高铁前往本次活动最后一站——湖南长沙。</p>

　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;11日下午，俄罗斯援华抗战老战士一行来到橘子洲头，近距离感受长沙山水洲城美貌。</p> 
　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;次日上午，代表团一行在五强集团参加俄罗斯援华抗战老战士中国行活动走进湖南欢迎活动。</p> 
　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;为表达湖南人民友情，中国民协湘绣文化传承与发展产业中心主任，著名画家，湘绣工艺大师王铭杰将历时6个月时间完成的老兵肖像——湖南特有的湘绣画绣作为特殊礼品赠予俄罗斯援华抗战老战士。</p> 
　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;长沙市的活动中，三位老兵向前来合影留念的长沙市民佩戴俄罗斯抗战胜利70周年庆典活动纪念勋章。表达他们的情谊。期间翻译不断传达老兵们对市民的问候，市民纷纷用俄语向老兵问好，欢声笑语不断从人群里传来。</p> 
　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;俄罗斯援华抗战老战士中国行活动走进湖南活动的承办单位，雅耀（湖南）科技有限公司董事长常胜说，我能为俄罗斯援华抗战老战士做点事我深感荣幸，我们今天的生活来之不易，离不开前辈们的牺牲和奉献精神，我们要继续努力，更多的开展有益于社会的文化活动，为实现我们心中的梦想不断创新前进，并希望老战士们回到俄罗斯传达中国人民的友情，共同助力于发展两国间的经贸合作，让更多的普通民众受益。</p> 
　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;“二战期间，俄中两国并肩作战结下了血浓于水的友谊，9月3日的北京天安门阅兵观礼，让他深刻感受到了中国的巨变。这次来到长沙，深深的感受到中国人民的友情，感受到湖南人民的热情招待。”83岁高龄的叶甫盖尼·康斯坦丁诺维奇·奥巴索夫竖起大拇指为长沙喝彩。</p> 
　<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;奥巴索夫副主席告诉记者，他的父亲1937年以空军志愿者身份参加援华战争，1938年参加长沙会战空战期间，飞机坠毁，年仅25岁的父亲英勇牺牲。他表示，生命和鲜血换回来的和平来之不易，希望中俄人民珍惜和平，将友谊一代一代传承与发扬。</p> 

		</div>
	</div>
	</div>
<!-- Footer -->
<div class="clear" style="margin-top:130px"></div>
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