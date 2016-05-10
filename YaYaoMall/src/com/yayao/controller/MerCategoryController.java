package com.yayao.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yayao.bean.MerCategory;
import com.yayao.service.MerCategoryService;
import com.yayao.service.MerSellerService;
import com.yayao.service.MerchandiseService;
import com.yayao.util.StatusCode;
/**
 * 商品类别控制类
 * 
 * @author yy
 * 
 */
@Scope("prototype")
@Controller("merCategoryController")
@RequestMapping(value = "/merCategory")
public class MerCategoryController {
	@Resource(name = "merCategoryService")
	private MerCategoryService merCategoryService;
	@Resource(name = "merchandiseService")
	private MerchandiseService merchandiseService;
	@Resource(name = "merSellerService")
	private MerSellerService merSellerService;
	/**
	 * 浏览商家 分类（含单个查询（用cateName））
	 * @return
	 */
	@RequestMapping(value = "/browseMerCategory", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<MerCategory> browseMerCategory(@RequestParam("cateName")String cateName,@RequestParam("sellerid") Integer sellerid)  {
		List<MerCategory> list = new ArrayList<MerCategory>();
		if(cateName.equals("all")){
			list=merCategoryService.browseMerCategory(sellerid);
		}else{
			boolean status = merCategoryService.chkMerCategory(sellerid,cateName);
			if(status){
				list.add(merCategoryService.loadMerCategory(sellerid,cateName));
			}
		}
		return list;
	}
	/**
	 * 删除单个商家分类
	 * @return
	 */
	@RequestMapping(value = "/delMerCategory", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String delMerCategory(@RequestParam("cateName")String cateName,@RequestParam("sellerid") Integer sellerid,HttpSession session)  {
			if(session.getAttribute("merSeller")==null){
				return StatusCode.GetValueByKey(StatusCode.SESSION_EXPIRED);
			}
			MerCategory merCate = merCategoryService.loadMerCategory(sellerid, cateName);
			merCategoryService.delMerCategory(merCate.getMercategoryid());
			return StatusCode.GetValueByKey(StatusCode.SUCCESS);
	}
	/**
	 * 商户商品分类增加
	 * @return
	 */
	@RequestMapping(value = "/addMerCategory", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody MerCategory addMerCategory(@RequestParam("cateName") String cateName,@RequestParam("sellerid") Integer sellerid,HttpSession session)  {
		MerCategory merCategory=new MerCategory();
		if(session.getAttribute("merSeller")==null){
			merCategory.setCateMsg(StatusCode.GetValueByKey(StatusCode.SESSION_EXPIRED));
			return merCategory;
		}
		boolean status = merCategoryService.chkMerCategory(sellerid, cateName);
		if(status){
			merCategory.setCateMsg(StatusCode.GetValueByKey(StatusCode.MERCATE_EXIST));
			return merCategory;
		}
		merCategory.setCateName(cateName);
		merCategory.setMerSeller(merSellerService.loadMerSeller(sellerid));
		merCategoryService.addMerCategory(merCategory);
		merCategory.setCateMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
		return merCategory;
	}
	/**
	 * 商户商品分类更新
	 * @return
	 */
	@RequestMapping(value = "/updateMerCategory", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody MerCategory updateMerCategory(@RequestParam("oldCateName") String oldCateName,@RequestParam("newCateName") String newCateName,@RequestParam("sellerid") Integer sellerid,HttpSession session)  {
		MerCategory oldMerCategory=merCategoryService.loadMerCategory(sellerid, oldCateName);
		if(session.getAttribute("merSeller")==null){
			oldMerCategory.setCateMsg(StatusCode.GetValueByKey(StatusCode.SESSION_EXPIRED));
			return oldMerCategory;
		}
		boolean status = merCategoryService.chkMerCategory(sellerid, newCateName);
		if(status){
			oldMerCategory.setCateMsg(StatusCode.GetValueByKey(StatusCode.MERCATE_EXIST));
			return oldMerCategory;
		}
		oldMerCategory.setCateName(newCateName);
		oldMerCategory.setCateMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
		merCategoryService.updateMerCategory(oldMerCategory);
		return oldMerCategory;
	}
	
}