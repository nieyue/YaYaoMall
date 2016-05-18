package com.yayao.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yayao.bean.MerCategory;
import com.yayao.bean.Merchandise;
import com.yayao.bean.MerchandiseImg;
import com.yayao.bean.Seller;
import com.yayao.dto.MerchandiseDTO;
import com.yayao.service.MerCategoryService;
import com.yayao.service.MerchandiseImgService;
import com.yayao.service.MerchandiseService;
import com.yayao.util.NumberUtil;
import com.yayao.util.StatusCode;
/**
 * 商品控制类
 * 
 * @author yy
 * 
 */
@Scope("prototype")
@Controller("merchandiseController")
@RequestMapping(value = "/merchandise")
public class MerchandiseController {
	@Resource(name = "merCategoryService")
	private MerCategoryService merCategoryService;
	@Resource(name = "merchandiseService")
	private MerchandiseService merchandiseService;
	@Resource(name = "merchandiseImgService")
	private MerchandiseImgService merchandiseImgService;
	
	/**
	 * 分段获取所有商品
	 * @return
	 */
	@RequestMapping(value = "/browseMerchandise", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<Merchandise> browseMerchandise(@RequestParam("sellerid") Integer sellerid,@RequestParam("currentCount")String currentCount,@RequestParam("pageSize") Integer pageSize,@RequestParam("merchandiseid")Integer merchandiseid,HttpSession session)  {
		int pageNo=1;//初始化
		MerCategory cate=null;
		int count=0;
		List<Merchandise> list = new ArrayList<Merchandise>();
		if(merchandiseid.equals(0)){
			cate=null;
		}else{
			cate = merCategoryService.loadMerCategory(sellerid,merchandiseid );
		}
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
	 * 商品修改
	 * @return
	 */
	@RequestMapping(value = "/updateMerchandise", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Merchandise updateMerchandise(@ModelAttribute MerchandiseDTO merchandiseDTO,HttpSession session)  {
		Merchandise merchandise=new Merchandise();
		if(session.getAttribute("seller")==null||!(((Seller)session.getAttribute("seller")).getSellerid().equals(merchandiseDTO.getSellerid()))){
			merchandise.setMerchandiseMsg(StatusCode.GetValueByKey(StatusCode.SESSION_EXPIRED));
			return merchandise;
		}
		BeanUtils.copyProperties(merchandiseDTO, merchandise);
		//merchandise.setMerchandiseMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
		//merchandiseService.updateMer(merchandise);
		return merchandise;
	}
	/**
	 * 商品增加
	 * @return
	 */
	@RequestMapping(value = "/addMerchandise", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Merchandise addMerchandise(@ModelAttribute MerchandiseDTO merchandiseDTO, HttpSession session)  {
		Merchandise merchandise=new Merchandise();
		if(session.getAttribute("seller")==null||!(((Seller)session.getAttribute("seller")).getSellerid().equals(merchandiseDTO.getSellerid()))){
			merchandise.setMerchandiseMsg(StatusCode.GetValueByKey(StatusCode.SESSION_EXPIRED));
			return merchandise;
		}
		BeanUtils.copyProperties(merchandiseDTO, merchandise);//dto复制到bean
		//查询绑定商品类别
		if(merchandiseDTO.getSellerid()!=null&&merchandiseDTO.getMerCategoryid()!=null){
			MerCategory merCate = merCategoryService.loadMerCategory(merchandiseDTO.getSellerid(), merchandiseDTO.getMerCategoryid());
			merchandise.setMerCategory(merCate);
			merchandiseService.addMer(merchandise);
			merchandise.setMerchandiseMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
		}
		for (int i = 0; i < merchandiseDTO.getMerchandiseImgsid().length; i++) {
			MerchandiseImg merImg = merchandiseImgService.loadMerchandiseImg(merchandiseDTO.getMerchandiseImgsid()[i]);
			merImg.setMerchandise(merchandise);
			merchandiseImgService.updateMerchandiseImg(merImg);
		}
		Merchandise mer = merchandiseService.loadMer(merchandise.getMerchandiseid());//最新数据
		return mer;
	}
	/**
	 * 商品删除
	 * @return
	 */
	@RequestMapping(value = "/delMerchandise", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String delMerchandise(@ModelAttribute MerchandiseDTO merchandiseDTO,HttpSession session)  {
		if(session.getAttribute("seller")==null||!(((Seller)session.getAttribute("seller")).getSellerid().equals(merchandiseDTO.getSellerid()))){
			return StatusCode.GetValueByKey(StatusCode.SESSION_EXPIRED);
		}
		//merchandiseService.delMer(merchandise.getMerchandiseid());;
		return StatusCode.GetValueByKey(StatusCode.SUCCESS);
	}
	
	
}