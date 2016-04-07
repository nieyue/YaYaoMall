package com.yayao.action;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.yayao.bean.Admin;
import com.yayao.bean.Consignee;
import com.yayao.bean.Member;
import com.yayao.bean.Merchandise;
import com.yayao.service.AdminService;
import com.yayao.service.CommentService;
import com.yayao.service.ConsigneeService;
import com.yayao.service.MerService;
import com.yayao.util.ActionContextUtil;
import com.yayao.util.BaseAction;
import com.yayao.util.SHAutil;


/**
 * 选购商品
 * @author yy
 *
 */
@Scope("prototype")
@Controller("merchandise")
public class MerchandiseAction extends BaseAction{
	@Autowired
	@Qualifier("merService")
	private MerService merService;
	@Autowired
	@Qualifier("commentService")
	private CommentService commentService;

	/**
	 * 点击商品图片进入商品购物页面
	 * @return
	 * @throws Exception
	 */
	public String showEBMerchandise() throws Exception {
		Map session = ActionContextUtil.getSession();
		//获取图片
		String loadEBMerchandiseImg = ActionContextUtil.getRequest().getParameter("loadEBMerchandiseImg");
		if(loadEBMerchandiseImg!=null){
			//获取当前人的所有图片
			List list= merService.browseMer("from Merchandise as a order by a.id desc");
			for (int i = 0; i < list.size(); i++) {
				Merchandise mer = (Merchandise) list.get(i);
				if(mer.getPicture().equals(loadEBMerchandiseImg)){
					//Merchandise merchandise=merService.loadMer(mer.getId());
					session.remove("EBMer");
					session.put("EBMer", mer);
					//Merchandise EBMer=(Merchandise) session.get("EBMer");
					commentService.browseComment(10, 1,mer);//添加浏览商品评论
					
				}
				
			}
			
		}
		return null;

}
	/**
	 * 商品详细页面的展示
	 * @return
	 * @throws Exception
	 */
	public String showAllEBMerchandise() throws Exception {
		Map session = ActionContextUtil.getSession();
		
			List list = merService.browseMer(6, 1, 1,3, false);//初始化
			
		JSONArray jsonarray=JSONArray.fromObject(list);
		HttpServletResponse response = ActionContextUtil.getResponse();
		response.setCharacterEncoding("utf-8");
		//response.setContentType("application/json");
		response.getWriter().write(jsonarray.toString());
		
		return null;		
}
	/**
	 * 商品点击实现分页功能
	 * @return
	 * @throws Exception
	 */
	public String showClickEBMerchandise() throws Exception {
		String mtpn = ActionContextUtil.getRequest().getParameter("mtpn");//被点击页，要去的页，
		List list=new ArrayList();
		
		Map session = ActionContextUtil.getSession();
		int merPageNo=(Integer) session.get("merPageNo");//当前页
		int merToPageNo=1;
		if(mtpn.equals("首页")){
			list = merService.browseMer(6, merToPageNo, 1,3, false);
		}else if(mtpn.equals("末页")){
			merToPageNo = (Integer) session.get("merTotalPages");
			list = merService.browseMer(6, merToPageNo, 1,3, false);
		}else if(mtpn.equals("上一页")){
			merToPageNo=merPageNo-1;
			list = merService.browseMer(6, merToPageNo, 1,3, false);
		}else if(mtpn.equals("下一页")){
			merToPageNo=merPageNo+1;
			list = merService.browseMer(6, merToPageNo, 1,3, false);
		}else if(mtpn!=null&&!mtpn.equals("")&&mtpn!="0"){
			
			merToPageNo = new Integer(mtpn);
			list = merService.browseMer(6, merToPageNo, 1,3, false);
		}
//		JSONArray jsonarray=JSONArray.fromObject(list);
//		HttpServletResponse response = ActionContextUtil.getResponse();
//		response.setCharacterEncoding("utf-8");
//		//response.setContentType("application/json");
//		response.getWriter().write(jsonarray.toString());
		return null;
		
		
	}
	/**
	 * 商品查询
	 * @throws Exception 
	 * 
	 */
	public String searchDoublePrice() throws Exception{
		String firstPrice = ActionContextUtil.getRequest().getParameter("firstPrice");//首价位
		String lastPrice = ActionContextUtil.getRequest().getParameter("lastPrice");//首价位
		List list = merService.browseMer(6, 1, firstPrice, lastPrice);
		
		return null;
		
	}
	}
	
