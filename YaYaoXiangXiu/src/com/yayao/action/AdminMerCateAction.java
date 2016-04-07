package com.yayao.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.yayao.bean.Admin;
import com.yayao.bean.Category;
import com.yayao.bean.Member;
import com.yayao.bean.Merchandise;
import com.yayao.service.AdminService;
import com.yayao.service.MerService;
import com.yayao.util.ActionContextUtil;
import com.yayao.util.BaseAction;
import com.yayao.util.SHAutil;


/**
 * 管理员对商品类型的增删改查
 * @author yy
 *
 */
@Scope("prototype")
@Controller("adminMerCate")
public class AdminMerCateAction extends BaseAction{
	@Autowired
	@Qualifier("merService")
	private MerService merService;
	
	private String ht_cateName;//商品类别名
	private String ht_cateDesc;//商品类别描述
	public String getHt_cateName() {
		return ht_cateName;
	}
	public void setHt_cateName(String ht_cateName) {
		this.ht_cateName = ht_cateName;
	}
	public String getHt_cateDesc() {
		return ht_cateDesc;
	}
	public void setHt_cateDesc(String ht_cateDesc) {
		this.ht_cateDesc = ht_cateDesc;
	}
	

	/**
	 * 增加商品类别
	 * @return
	 * @throws Exception
	 */
	public String ht_addMerCategory() throws Exception {
		Admin a = (Admin) ActionContextUtil.getSession().get("Admin");
		if(ht_cateName==null||ht_cateName.equals("")||ht_cateDesc==null||ht_cateDesc.equals("")){
			this.addFieldError("ht_addMerCategoryError", "※商品类别两个为必填项，请您重新添加！");
			return "input";
		}
		//检查添加的类别是否已经存在
		boolean status=merService.chkCategory(ht_cateName);
		if(!status&&a.getAdminType()==1){
		Category cate=new Category();
		cate.setCateName(ht_cateName);
		cate.setCateDesc(ht_cateDesc);;
		merService.addCategory(cate);
		merService.browseCategory();
		return "success";
		}else{
			this.addFieldError("ht_addMerCategoryError", "※商品类别存在，请您重新添加！");
			return "input";
		}	
	}
	/**
	 * 删除商品类别
	 * @return
	 * @throws Exception
	 */
	public String ht_delMerCategory() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		//获取索引
		String delCateIndex = ActionContextUtil.getRequest().getParameter("hln");
		Integer dci=new Integer(delCateIndex);
		if(a!=null&&a.getAdminType()==1){

		merService.delCategory(dci);
		}
		merService.browseCategory();
		merService.browseMer("from Merchandise as a order by a.id desc");
		return "success";
	}
	
	/**
	 * 批量删除商品类别
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	public String ht_delAllMerCategory() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		Integer mcdiid=null;
		//获取索引
		String merCategoryDelIndexs = ActionContextUtil.getRequest().getParameter("delIndexs");
		if(merCategoryDelIndexs!=null&&!merCategoryDelIndexs.equals("")){
		String[] mcdi=merCategoryDelIndexs.split(",");
		for (int i = 0; i < mcdi.length; i++) {
			mcdiid=new Integer(mcdi[i]);
		if(a!=null&&a.getAdminType().equals(1)){
					merService.delCategory(mcdiid);
				}
			}
		}
		merService.browseCategory();
		return null;
	}
	/**
	 * 更改商品类型
	 * @return
	 * @throws Exception
	 */
	public String ht_updateMerCategory() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		//获取索引
		String modifyCateIndex = ActionContextUtil.getRequest().getParameter("ht_cateID");
		Integer mci=new Integer(modifyCateIndex);
		if(a!=null&&a.getAdminType()==1){
		Category cate = merService.loadCategory(mci);
		boolean status=merService.chkCategory(ht_cateName);
		if(!status){
		cate.setCateName(ht_cateName);
		cate.setCateDesc(ht_cateDesc);
		merService.updateCategory(cate);
		merService.browseCategory();
		return "success";
		}else{
			this.addFieldError("ht_addMerCategoryError", "※商品类别存在，请您重新修改！");
			return "input";
		}}
		return "input";
	}
	/**
	 * 装载单个商品类型（浏览单个）
	 * @return
	 * @throws Exception
	 */
	public String ht_loadCate() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		//获取索引
		String loadCateIndex = ActionContextUtil.getRequest().getParameter("loadCateIndex");
		Integer lci=new Integer(loadCateIndex);
		if(a!=null&&a.getAdminType()==1){
			merService.loadCategory(lci);
			return "success";	
		}
		return "input";
	}
	/**
	 * 浏览所有商品类型（浏览所有）
	 * @return
	 * @throws Exception
	 */
	public String ht_showAllCategory() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		if(a!=null&&a.getAdminType()==1){
			merService.browseCategory();
			return "success";	
		}
		return "input";
	}
	
	
}