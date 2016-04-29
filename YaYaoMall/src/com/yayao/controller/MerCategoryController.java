package com.yayao.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yayao.bean.MerCategory;
import com.yayao.bean.Merchandise;
import com.yayao.service.MerCategoryService;
import com.yayao.service.MerchandiseService;
import com.yayao.util.NumberUtil;
/**
 * 账户控制类
 * 
 * @author yy
 * 
 */
@Scope("prototype")
@Controller("merCategory")
@RequestMapping(value = "/merCategory")
public class MerCategoryController {
	@Resource(name = "merCategoryService")
	private MerCategoryService merCategoryService;
	@Resource(name = "merchandiseService")
	private MerchandiseService merchandiseService;
	/**
	 * 浏览 分类
	 * @return
	 */
	@RequestMapping(value = "/browseMerCategory/{cateName}", method = RequestMethod.GET)
	public @ResponseBody List<MerCategory> browseMerCategory(@PathVariable("cateName")String cateName)  {
		List<MerCategory> list = new ArrayList<MerCategory>();
		if(cateName.equals("all")){
			list=merCategoryService.browseMerCategory();
		}else{
			boolean status = merCategoryService.chkMerCategory(cateName);
			if(status){
				list.add(merCategoryService.loadMerCategory(cateName));
			}
		}
		return list;
	}
	/**
	 * 分页浏览 分类
	 * @return
	 */
	@RequestMapping(value = "/browseMerchandise", method = RequestMethod.GET)
	public @ResponseBody List<Merchandise> browseMerchandise(@RequestParam("currentCount")String currentCount,HttpSession session)  {
		int pageSize=10;
		int pageNo=1;
		MerCategory cate=null;
		int count=0;
		List<Merchandise> list = new ArrayList<Merchandise>() ;
		count=merchandiseService.countRecord(cate);
		if(currentCount!=null&&NumberUtil.isNumeric(currentCount)&&Integer.valueOf(currentCount)<=count){
			if(Integer.valueOf(currentCount)%pageSize!=0){//前台页面有问题，需重新获取
				//每次pageSize个
				list= merchandiseService.browseMer(pageSize, pageNo, cate, "merchandiseid", "asc");
				return list;
			}
			//
			pageNo=Integer.valueOf(currentCount)/pageSize+1;//6/2=3
			//没有更多
			if(count<pageSize*pageNo){
				return list;
			}
			list= merchandiseService.browseMer(pageSize, pageNo, cate, "merchandiseid", "asc");
			return list;
		}
		return null;
	}
	/**
	 * 商品增加
	 * @return
	 */
	@RequestMapping(value = "/addMerchandise", method = RequestMethod.POST)
	public @ResponseBody List<Merchandise> addMerchandise(@RequestParam("file") MultipartFile file,HttpServletRequest request,@RequestParam("userid")Integer id)  {
		List<Merchandise> list = new ArrayList<Merchandise>();
		
		return list;
	}
	
}