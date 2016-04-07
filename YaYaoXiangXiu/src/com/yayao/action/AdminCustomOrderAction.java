package com.yayao.action;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.yayao.bean.Admin;
import com.yayao.bean.ExclusiveCustom;
import com.yayao.service.CommentService;
import com.yayao.service.ConsigneeService;
import com.yayao.service.ExclusiveCustomService;
import com.yayao.service.MemService;
import com.yayao.util.ActionContextUtil;
import com.yayao.util.BaseAction;


/**
 * 定制订单的增加、删除，查询
 * @author yy
 *
 */
@Scope("prototype")
@Controller("adminCustomOrder")
public class AdminCustomOrderAction extends BaseAction{
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
	@Qualifier("exclusiveCustomService")
	private ExclusiveCustomService exclusiveCustomService;

	
	/**
	 * 指定删除定制订单
	 * @return
	 * @throws Exception
	 */
	public String ht_delCustomOrder() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		
		//获取索引
		String ht_customOrderNumber = ActionContextUtil.getRequest().getParameter("hln");
		
		if(a!=null&&a.getAdminType().equals(3)){
			List list=exclusiveCustomService.browseAllExclusiveCustom();
			for (int i = 0; i < list.size(); i++) {
				ExclusiveCustom ec=(ExclusiveCustom)list.get(i);
				if(ec.getCustomOrderNumber().equals(ht_customOrderNumber)){
					exclusiveCustomService.delExclusiveCustom(ec.getId());
					
					exclusiveCustomService.browseAllExclusiveCustom();
					return null;
				}
			}
		}
		return null;
	}
	/**
	 * 定制订单批量删除
	 * @return
	 * @throws Exception
	 */
	public String ht_delAllCustomOrder() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		Integer mdiid=null;
		//获取索引
		String memDelIndexs = ActionContextUtil.getRequest().getParameter("delIndexs");
		if(memDelIndexs!=null&&!memDelIndexs.equals("")){
			
		String[] mdi=memDelIndexs.split(",");
		for (int i = 0; i < mdi.length; i++) {
			mdiid=new Integer(mdi[i]);
		if(a!=null&&a.getAdminType().equals(3)){
				exclusiveCustomService.delExclusiveCustom(mdiid);
				}
			}
		}
		exclusiveCustomService.browseAllExclusiveCustom();
		
		return null;
	}
	
	/**
	 * 定制订单详细查询（浏览单个）
	 * @return
	 * @throws Exception
	 */
	public String ht_showCustomOrder() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		//获取索引
		String customOrderID = ActionContextUtil.getRequest().getParameter("customOrderID");
		Integer coi=new Integer(customOrderID);
		if(a!=null&&a.getAdminType().equals(3)){
			ExclusiveCustom exclusiveCustom=exclusiveCustomService.loadExclusiveCustom(coi);
			session.put("ht_ExclusiveCustom", exclusiveCustom);
			return "success";	
		}
		return "input";
	}
	
	/**
	 * 模糊查询定制订单（一个或多个）
	 * @return
	 * @throws Exception
	 */
	public String ht_searchCustomOrder() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		//获取索引
		String sc = ActionContextUtil.getRequest().getParameter("sc");
		if(a!=null&&a.getAdminType().equals(3)){
			List list = exclusiveCustomService.searchExclusiveCustom("from ExclusiveCustom where customOrderNumber like '%"+sc+"%'");
			ActionContextUtil.getSession().remove("exclusiveAllList");
			ActionContextUtil.getSession().put("exclusiveAllList", list);
			if(list==null||list.equals("")||list.isEmpty()){
				
			ActionContextUtil.getResponse().setCharacterEncoding("UTF-8");
			ActionContextUtil.getResponse().getWriter().write("没有此类订单号！");;
			return null;
			}
			
		}
		return null;	
		
	}
	/**
	 * 查询所有定制订单
	 * @return
	 * @throws Exception
	 */
	public String ht_searchAllCustomOrder() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		if(a!=null&&a.getAdminType().equals(3)){
			List list = exclusiveCustomService.browseAllExclusiveCustom();
		}
		return null;	
		
	}
	
}