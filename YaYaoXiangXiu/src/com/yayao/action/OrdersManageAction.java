package com.yayao.action;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;











import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.yayao.bean.Cart;
import com.yayao.bean.Cartselectedmer;
import com.yayao.bean.Consignee;
import com.yayao.bean.Member;
import com.yayao.bean.Orders;
import com.yayao.dao.OrderDao;
import com.yayao.service.CartService;
import com.yayao.service.ConsigneeService;
import com.yayao.service.OrderService;
import com.yayao.util.ActionContextUtil;
import com.yayao.util.BaseAction;
import com.yayao.util.DateUtil;


/**
 * 普通订单管理
 * @author yy
 *
 */
@Scope("prototype")
@Controller("ordersManage")
public class OrdersManageAction extends BaseAction{
	
	@Autowired
	@Qualifier("cartService")
	private CartService cartService;
	@Autowired
	@Qualifier("orderService")
	private OrderService orderService;
	@Autowired
	@Qualifier("consigneeService")
	private ConsigneeService consigneeService;
	
	/**
	 * 提交按钮购物清单
	 * @return
	 * @throws Exception
	 */
	public String addOrders() throws Exception {
		String on="";//放订单时间
		Map session = ActionContextUtil.getSession();
		
		Member member=(Member)session.get("Member");
		
        //选定的收货地址
		String ischeck = ActionContextUtil.getRequest().getParameter("ischeck");
		Integer ic = new Integer(ischeck);
		if(member!=null){
			//订单生成
			Orders order=new Orders();
			order.setMember(member);
	        Consignee consignee = consigneeService.loadConsignee(ic);
	        consignee.setHasOrder(new Integer(1));//
	        consigneeService.updateConsignee(consignee);
			order.setConsignee(consignee);
			
			Cart cart = cartService.loadCart(member);
			cart.setCartStatus(new Integer(1));//改变购物车状态由0变成1，使用中变成已下单。
			order.setCart(cart);
			cartService.updateCart(cart);
			on = DateUtil.getOrdersTime();
			order.setOrderDate(DateUtil.getCurrentTime());
			order.setOrderNumber(on);
			orderService.addOrder(order);
			
	
			List lll=orderService.browseOrder(member);
			for (int i = 0; i < lll.size(); i++) {
				Orders ooo = (Orders)lll.get(i);
				if(ooo.getOrderNumber().equals(on)){
					
			//当前购物车选购商品的订单ID确定
			List cartSelectedMerList = (List) session.get("cartSelectedMerList");
			for (int j = 0; j < cartSelectedMerList.size(); j++) {
				Cartselectedmer cartSelectedMer= (Cartselectedmer) cartSelectedMerList.get(j);	
				
				cartSelectedMer.setOrderStatus(new Integer(1));//0:已取消订单，1:已经下单，2:已经发货，3:完成交易
				cartService.insertOrder(ooo,cartSelectedMer );
				
					}
				}
			}			
			session.remove("cartSelectedMerList");
			session.remove("totalMoney");
			orderService.browseOrderMer(member);
			
			return "success";
				
			}
			
		return "input";
		}
	/**
	 * 取消订单中的某选购订单 
	 * @return
	 * @throws Exception
	 */
	public  String cancelOrders() throws Exception {
		Map session = ActionContextUtil.getSession();
		Member member=(Member)session.get("Member");
		String rejectOrdersIndex = ActionContextUtil.getRequest().getParameter("rejectOrdersIndex");
	    Integer roi=new Integer(rejectOrdersIndex);
	    if(member!=null){
	    	List cartselectedmerlists= (List) session.get("orderMerList");
	    	for (int i = 0; i < cartselectedmerlists.size(); i++) {
	    		Cartselectedmer cartselectedmer = (Cartselectedmer)cartselectedmerlists.get(i);
	    		if(cartselectedmer.getId().equals(roi)){
	    			cartselectedmer.setOrderStatus(new Integer(0));
	    			cartService.insertOrder(cartselectedmer.getOrder(), cartselectedmer);
	    			orderService.browseOrderMer(member);
	    			return SUCCESS;
	    		}
			}
	    }
		return INPUT;
	}
	/**
	 * 恢复已经取消订单中的某选购订单 
	 * @return
	 * @throws Exception
	 */
	public  String regainOrders() throws Exception {
		Map session = ActionContextUtil.getSession();
		Member member=(Member)session.get("Member");
		String recoverOrdersIndex = ActionContextUtil.getRequest().getParameter("recoverOrdersIndex");
		Integer roi=new Integer(recoverOrdersIndex);
		if(member!=null){
			List cartselectedmerlists= (List) session.get("orderMerList");
			for (int i = 0; i < cartselectedmerlists.size(); i++) {
				Cartselectedmer cartselectedmer = (Cartselectedmer)cartselectedmerlists.get(i);
				if(cartselectedmer.getId().equals(roi)){
					cartselectedmer.setOrderStatus(new Integer(1));
					cartService.insertOrder(cartselectedmer.getOrder(), cartselectedmer);
					orderService.browseOrderMer(member);
					return SUCCESS;
				}
			}
		}
		return INPUT;
	}
	/**
	 * 删除一行订单商品
	 * 三级联动：1。如果订单中的选购商品多个，只执行删除一行订单商品。
	 * 2.如果订单商品全部删除完，则执行两个操作:
	 * a.对应订单收货人信息:如果收货信息状态为1，则不删除地址，如果为2，则删除地址。
	 * b.删除订单信息。
	 * c.删除购物车信息。
	 * @return
	 * @throws Exception
	 */
	public String delOrders() throws Exception {
		Map session = ActionContextUtil.getSession();
		Member member=(Member)session.get("Member");
		
		String delOrdersIndex = ActionContextUtil.getRequest().getParameter("delOrdersIndex");
		Integer doi = new Integer(delOrdersIndex);
		if(member!=null){
			List cartselectedmerlists= (List) session.get("orderMerList");
	    	for (int i = 0; i < cartselectedmerlists.size(); i++) {
	    		Cartselectedmer cartselectedmer = (Cartselectedmer)cartselectedmerlists.get(i);
	    		if(cartselectedmer.getId().equals(doi)){
	    			cartService.delCart(doi);//删除点击的选购订单商品
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
	    			orderService.browseOrderMer(member);
	    			return SUCCESS;
				}
			}
			
		}
		
		return "input";
	}

}
	
