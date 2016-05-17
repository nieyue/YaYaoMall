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
import com.yayao.bean.Seller;
import com.yayao.service.MerCategoryService;
import com.yayao.service.MerchandiseService;
import com.yayao.service.SellerService;
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
	@Resource(name = "sellerService")
	private SellerService sellerService;
	/**
	 * 浏览商家 分类（含单个查询（用cateName））
	 * @return
	 */
	@RequestMapping(value = "/browseMerCategory", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<MerCategory> browseMerCategory(@RequestParam("mercategoryid")Integer mercategoryid,@RequestParam("sellerid") Integer sellerid)  {
		List<MerCategory> list = new ArrayList<MerCategory>();
		if(mercategoryid.equals("0")){//全部查询
			list=merCategoryService.browseMerCategory(sellerid);
		}else{
				list.add(merCategoryService.loadMerCategory(sellerid,mercategoryid));
		}
		return list;
	}
	/**
	 * 删除单个商家分类
	 * @return
	 */
	@RequestMapping(value = "/delMerCategory", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String delMerCategory(@RequestParam("mercategoryid")Integer mercategoryid,@RequestParam("sellerid") Integer sellerid,HttpSession session)  {
		if(session.getAttribute("seller")==null||!(((Seller)session.getAttribute("seller")).getSellerid().equals(sellerid))){
				return StatusCode.GetValueByKey(StatusCode.SESSION_EXPIRED);
			}
			merCategoryService.delMerCategory(sellerid,mercategoryid);
			return StatusCode.GetValueByKey(StatusCode.SUCCESS);
	}
	/**
	 * 商户商品分类增加
	 * @return
	 */
	@RequestMapping(value = "/addMerCategory", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody MerCategory addMerCategory(@RequestParam("cateName") String cateName,@RequestParam("sellerid") Integer sellerid,HttpSession session)  {
		MerCategory merCategory=new MerCategory();
		if(session.getAttribute("merSeller")==null||!(((Seller)session.getAttribute("seller")).getSellerid().equals(sellerid))){
			merCategory.setCateMsg(StatusCode.GetValueByKey(StatusCode.SESSION_EXPIRED));
			return merCategory;
		}
		boolean status = merCategoryService.chkMerCategory(sellerid, cateName);
		if(status){
			merCategory.setCateMsg(StatusCode.GetValueByKey(StatusCode.MERCATE_EXIST));
			return merCategory;
		}
		merCategory.setCateName(cateName);
		merCategory.setSeller(sellerService.loadSeller(sellerid));
		merCategoryService.addMerCategory(merCategory);
		merCategory.setCateMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
		return merCategory;
	}
	/**
	 * 商户商品分类更新
	 * @return
	 */
	@RequestMapping(value = "/updateMerCategory", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody MerCategory updateMerCategory(@RequestParam("mercategoryid")Integer mercategoryid,@RequestParam("newCateName") String newCateName,@RequestParam("sellerid") Integer sellerid,HttpSession session)  {
		MerCategory oldMerCategory=merCategoryService.loadMerCategory(sellerid, mercategoryid);
		if(session.getAttribute("merSeller")==null||!(((Seller)session.getAttribute("seller")).getSellerid().equals(sellerid))){
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