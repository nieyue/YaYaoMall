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
	 * 浏览商家 分类 sellerid==0浏览所有
	 * sellerid=指定id 浏览指定id商家
	 * @return
	 */
	@RequestMapping(value = "/browseMerCategory", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<MerCategory> browseMerCategory(@RequestParam("sellerId") Integer sellerId)  {
		List<MerCategory> list = new ArrayList<MerCategory>();
		list=merCategoryService.browseMerCategory(sellerId);
		return list;
	}
	/**
	 * 删除单个商家分类
	 * @return
	 */
	@RequestMapping(value = "/delMerCategory", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String delMerCategory(@RequestParam("merCategoryId")Integer merCategoryId,HttpSession session)  {
			merCategoryService.delMerCategory(merCategoryId);
			return StatusCode.GetValueByKey(StatusCode.SUCCESS);
	}
	/**
	 * 商户商品分类增加
	 * @return
	 */
	@RequestMapping(value = "/addMerCategory", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody MerCategory addMerCategory(@RequestParam("merCategoryName") String merCategoryName,@RequestParam("sellerId") Integer sellerId,HttpSession session)  {
		MerCategory merCategory=new MerCategory();
		boolean status = merCategoryService.chkMerCategory(sellerId, merCategoryName);
		if(status){
			merCategory.setMerCategoryMsg(StatusCode.GetValueByKey(StatusCode.MERCATE_EXIST));
			return merCategory;
		}
		merCategory.setMerCategoryName(merCategoryName);
		merCategory.setSeller(sellerService.loadSeller(sellerId));
		merCategoryService.addMerCategory(merCategory);
		merCategory.setMerCategoryMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
		return merCategory;
	}
	/**
	 * 商户商品分类更新
	 * @return
	 */
	@RequestMapping(value = "/updateMerCategory", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody MerCategory updateMerCategory(@RequestParam("merCategoryId")Integer merCategoryId,@RequestParam("newCateName") String newCateName,@RequestParam("sellerId") Integer sellerId,HttpSession session)  {
		MerCategory oldMerCategory=merCategoryService.loadMerCategory(merCategoryId);
		boolean status = merCategoryService.chkMerCategory(sellerId, newCateName);
		if(status){
			oldMerCategory.setMerCategoryMsg(StatusCode.GetValueByKey(StatusCode.MERCATE_EXIST));
			return oldMerCategory;
		}
		oldMerCategory.setMerCategoryName(newCateName);
		oldMerCategory.setMerCategoryMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
		merCategoryService.updateMerCategory(oldMerCategory);
		return oldMerCategory;
	}
	
}