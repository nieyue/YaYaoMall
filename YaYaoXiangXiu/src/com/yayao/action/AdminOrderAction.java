package com.yayao.action;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.ServletActionRedirectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.yayao.bean.Admin;
import com.yayao.bean.Cartselectedmer;
import com.yayao.bean.Consignee;
import com.yayao.bean.ExclusiveCustom;
import com.yayao.bean.Orders;
import com.yayao.service.CartService;
import com.yayao.service.CommentService;
import com.yayao.service.ConsigneeService;
import com.yayao.service.MemService;
import com.yayao.service.OrderService;
import com.yayao.util.ActionContextUtil;
import com.yayao.util.BaseAction;


/**
 * 普通订单的增加、删除，查询
 * @author yy
 *
 */
@Scope("prototype")
@Controller("adminOrder")
public class AdminOrderAction extends BaseAction{
	@Autowired
	@Qualifier("memService")
	private MemService memService;
	@Autowired
	@Qualifier("commentService")
	private CommentService commentService;
	@Autowired
	@Qualifier("consigneeService")
	private ConsigneeService consigneeService;
	@Autowired
	@Qualifier("orderService")
	private OrderService orderService;
	@Autowired
	@Qualifier("cartService")
	private CartService cartService;

	
	/**
	 * 指定删除订单
	 * @return
	 * @throws Exception
	 */
	public String ht_delOrder() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		//获取索引
		String ht_orderID = ActionContextUtil.getRequest().getParameter("hln");
		Integer hod=new Integer(ht_orderID);
		if(a!=null&&a.getAdminType().equals(3)){
			List list=orderService.browseAllOrderMer();
			for (int i = 0; i < list.size(); i++) {
				Cartselectedmer cartselectedmer=(Cartselectedmer)list.get(i);
				if(cartselectedmer.getId().equals(hod)){
		    			cartService.delCart(hod);//删除点击的选购订单商品
		    			Orders oo = cartselectedmer.getOrder();
		    			List sels = orderService.browseOrderMer(oo);
		    			  if(sels.size()==0){
		    			   orderService.delOrder(oo.getId());
		    			   cartService.delCartSelf(cartselectedmer.getCart().getId());
		    			   Consignee con = oo.getConsignee();
		    			   if(con.getHasOrder().intValue()==2){
		    				   consigneeService.delConsignee(con.getId());
		    			   }
		
		    			  }
					}
				}
				}
		orderService.browseOrder();
		return null;
	}
	/**
	 * 订单批量删除
	 * @return
	 * @throws Exception
	 */
	public String ht_delAllOrder() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		Integer mdiid=null;
		//获取索引
		String orderDelIndexs = ActionContextUtil.getRequest().getParameter("delIndexs");
		if(orderDelIndexs!=null&&!orderDelIndexs.equals("")){
			
		String[] mdi=orderDelIndexs.split(",");
		for (int i = 0; i < mdi.length; i++) {
			mdiid=new Integer(mdi[i]);
		if(a!=null&&a.getAdminType().equals(3)){
				
			List list=orderService.browseAllOrderMer();
			for (int j = 0; j < list.size(); j++) {
				Cartselectedmer cartselectedmer=(Cartselectedmer)list.get(j);
				if(cartselectedmer.getId().equals(mdiid)){
			cartService.delCart(mdiid);//删除点击的选购订单商品
			Orders oo = cartselectedmer.getOrder();
			List sels = orderService.browseOrderMer(oo);
			  if(sels.size()==0){
			   orderService.delOrder(oo.getId());
			   cartService.delCartSelf(cartselectedmer.getCart().getId());
			   Consignee con = oo.getConsignee();
			    if(con.getHasOrder().intValue()==2){
				   consigneeService.delConsignee(con.getId());
			    }
			  }
				
				}
			}
		}
		}
		}
		orderService.browseAllOrderMer();
		
		return null;
	}
	
	/**
	 * 订单详细查询（浏览单个）
	 * @return
	 * @throws Exception
	 */
	public String ht_showOrder() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		//获取索引
		String orderID = ActionContextUtil.getRequest().getParameter("orderID");
		Integer oi=new Integer(orderID);
		if(a!=null&&a.getAdminType().equals(3)){
			Cartselectedmer sel = cartService.loadCartselectedmer(oi);
			session.put("ht_Cartselectedmer", sel);
			return "success";	
		}
		return "input";
	}
	
	/**
	 * 模糊查询定制订单（一个或多个）
	 * @return
	 * @throws Exception
	 */
	public String ht_searchOrder() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		//获取索引
		String sc = ActionContextUtil.getRequest().getParameter("sc");
		if(a!=null&&a.getAdminType().equals(3)){
			List list = cartService.searchOrder("select csm.id,csm.number,csm.price,csm.money,csm.cartID,csm.orderID,csm.merchandiseID,csm.orderStatus from Cartselectedmer_tb csm left join Orders_tb o "
					+ "on csm.orderID=o.id where csm.orderStatus>0 and o.orderNumber like '%"+sc+"%'");
			ActionContextUtil.getSession().remove("allOrderMerList");
			ActionContextUtil.getSession().put("allOrderMerList", list);
			if(list==null||list.equals("")||list.isEmpty()){
				
			ActionContextUtil.getResponse().setCharacterEncoding("UTF-8");
			ActionContextUtil.getResponse().getWriter().write("没有此类订单号！");;
			
			}
			
		}
		return null;	
		
	}
	/**
	 * 查询所有订单
	 * @return
	 * @throws Exception
	 */
	public String ht_searchAllOrder() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		if(a!=null&&a.getAdminType().equals(3)){
			orderService.browseAllOrderMer();
		}
		return null;	
	}
	/**
	 * 修改当前订单状态（1个订单）
	 * @return
	 * @throws Exception
	 */
	public String ht_updateOrderMer() throws Exception{
		Map session = ActionContextUtil.getSession();
		String ht_orderStatus = ServletActionContext.getRequest().getParameter("ht_orderStatus");
		Integer hos=new Integer(ht_orderStatus);
		String ht_orderStatusID = ServletActionContext.getRequest().getParameter("ht_orderStatusID");
		Integer hosi=new Integer(ht_orderStatusID);
		Admin a = (Admin) session.get("Admin");
		if(a!=null&&a.getAdminType().equals(3)){
			cartService.updateOrderStatus(hos,hosi);
			orderService.browseAllOrderMer();
		}
		return SUCCESS;	
	}
	
}