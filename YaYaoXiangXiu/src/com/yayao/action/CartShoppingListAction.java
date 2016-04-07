package com.yayao.action;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.yayao.bean.Admin;
import com.yayao.bean.Cartselectedmer;
import com.yayao.bean.Consignee;
import com.yayao.bean.Member;
import com.yayao.bean.Merchandise;
import com.yayao.service.AdminService;
import com.yayao.service.CartService;
import com.yayao.service.ConsigneeService;
import com.yayao.service.MerService;
import com.yayao.util.ActionContextUtil;
import com.yayao.util.BaseAction;
import com.yayao.util.SHAutil;


/**
 * 购物车
 * @author yy
 *
 */
@Scope("prototype")
@Controller("cartShoppingList")
public class CartShoppingListAction extends BaseAction{
	@Autowired
	@Qualifier("merService")
	private MerService merService;
	@Autowired
	@Qualifier("cartService")
	private CartService cartService;
	
	private Integer goodsNumber;//选购商品的数量
	
	public Integer getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(Integer goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	/**
	 * 确定购物清单
	 * @return
	 * @throws Exception
	 */
	public String addCart() throws Exception {
		Map session = ActionContextUtil.getSession();
		Merchandise mer = (Merchandise) session.get("EBMer");
		Member member=(Member)session.get("Member");
		
		if(member!=null&&mer!=null){
			cartService.addCart(member, mer, goodsNumber);
			cartService.browseCart(member);
			return "success";
				
			}
			
		return "input";
		}
	/**
	 * 更新购物车
	 * @return
	 * @throws Exception
	 */
	public  String changeCart() throws Exception {
		Map session = ActionContextUtil.getSession();
		Member member=(Member)session.get("Member");
		
		JSONObject saveCartJSON=JSONObject.fromObject(ActionContextUtil.getRequest().getParameter("data"));
		//System.out.println(saveCartJSON);
		JSONArray jl = saveCartJSON.getJSONArray("jl");
		List list = cartService.browseCart(member);
		 for (int i = 0; i < jl.size(); i++) {
		JSONObject info = jl.getJSONObject(i);
			String sid = info.getString("id");
			Integer id=new Integer(sid);
			String snumber = info.getString("number");
			Integer number=new Integer(snumber);
			
			if(member!=null){
				for (int j = 0; j < list.size(); j++) {
					Cartselectedmer csm=(Cartselectedmer) list.get(j);
					if(csm.getId().equals(id)){
						cartService.modiCart(id, number);
					}
				}
			}
				
		}
		 cartService.browseCart(member);
		 return "success";
		
	}
	/**
	 * 删除一行商品
	 * @return
	 * @throws Exception
	 */
	public String delCart() throws Exception {
		Map session = ActionContextUtil.getSession();
		Member member=(Member)session.get("Member");
		List list = cartService.browseCart(member);
		
		String cartselectmerindex = ActionContextUtil.getRequest().getParameter("cartselectmerindex");
		Integer csmi = new Integer(cartselectmerindex);
		if(member!=null&&list!=null){
			for (int i = 0; i < list.size(); i++) {
				Cartselectedmer csm=(Cartselectedmer) list.get(i);
				if(csm.getId().equals(csmi)){
					cartService.delCart(csmi);
					cartService.browseCart(member);
					return "success";
				}
			}
			
		}
		
		return "input";
	}

}
	
