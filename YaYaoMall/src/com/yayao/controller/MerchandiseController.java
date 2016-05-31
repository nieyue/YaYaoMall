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
import com.yayao.service.SellerService;
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
	@Resource(name = "sellerService")
	private SellerService sellerService;
	
	/**
	 * 浏览商家的获取所有商品
	 * @return
	 */
	@RequestMapping(value = "/browseMerBySeller", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<Merchandise> browseMerchandise(@RequestParam("sellerId") Integer sellerId,@RequestParam("currentCount")String currentCount,@RequestParam("pageSize") Integer pageSize,@RequestParam(value="merchandiseStatus",required=false) String merchandiseStatus,HttpSession session)  {
		int pageNo=1;//初始化
		int count=0;
		List<Merchandise> list = new ArrayList<Merchandise>();
		count=merchandiseService.countRecord(sellerId,merchandiseStatus, 0);//查询一个商户的所有商品，不分类别
		if(currentCount!=null&&NumberUtil.isNumeric(currentCount)&&Integer.valueOf(currentCount)<=count){
			if(Integer.valueOf(currentCount)%pageSize!=0){//前台页面有问题，需重新获取
				list= merchandiseService.browseMerBySeller(pageSize, pageNo, sellerId,merchandiseStatus, "merchandiseId", "asc");
				return list;
			}
			//
			pageNo=Integer.valueOf(currentCount)/pageSize+1;//6/2=3
			//没有更多
			if(count<pageSize*pageNo){
				return list;
			}
			list= merchandiseService.browseMerBySeller(pageSize, pageNo, sellerId,merchandiseStatus, "merchandiseId", "asc");
			return list;
		}
		return list;
	}
	/**
	 * 商品修改
	 * @return
	 */
	@RequestMapping(value = "/updateMerchandise", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Merchandise updateMerchandise(@ModelAttribute MerchandiseDTO merchandiseDTO,HttpSession session)  {
		Merchandise merchandise=merchandiseService.loadMer(merchandiseDTO.getMerchandiseId());
		BeanUtils.copyProperties(merchandiseDTO, merchandise);
		//查询绑定商品类别
		if(merchandiseDTO.getSellerId()!=0){
					Seller seller = sellerService.loadSeller(merchandiseDTO.getSellerId());
					merchandise.setSeller(seller);
					MerCategory merCate = merCategoryService.loadMerCategory(merchandiseDTO.getMerCategoryId());
					merchandise.setMerCategory(merCate);
					merchandiseService.addMer(merchandise);
					merchandise.setMerchandiseMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
		}
		for (int i = 0;i < merchandiseDTO.getMerchandiseImgIds().length; i++) {
					MerchandiseImg merImg = merchandiseImgService.loadMerchandiseImg(merchandiseDTO.getMerchandiseImgIds()[i]);
					merImg.setMerchandise(merchandise);
					merchandiseImgService.updateMerchandiseImg(merImg);
		}
				Merchandise mer = merchandiseService.loadMer(merchandise.getMerchandiseId());//最新数据
				return mer;
	}
	/**
	 * 商品增加
	 * @return
	 */
	@RequestMapping(value = "/addMerchandise", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Merchandise addMerchandise(@ModelAttribute MerchandiseDTO merchandiseDTO, HttpSession session)  {
		Merchandise merchandise=new Merchandise();
		BeanUtils.copyProperties(merchandiseDTO, merchandise);//dto复制到bean
		//查询绑定商品类别
		if(merchandiseDTO.getSellerId()!=0){
			Seller seller = sellerService.loadSeller(merchandiseDTO.getSellerId());
			merchandise.setSeller(seller);
			MerCategory merCate = merCategoryService.loadMerCategory(merchandiseDTO.getMerCategoryId());
			merchandise.setMerCategory(merCate);
			merchandiseService.addMer(merchandise);
			merchandise.setMerchandiseMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
		}
		for (int i = 0; i < merchandiseDTO.getMerchandiseImgIds().length; i++) {
			MerchandiseImg merImg = merchandiseImgService.loadMerchandiseImg(merchandiseDTO.getMerchandiseImgIds()[i]);
			merImg.setMerchandise(merchandise);
			merchandiseImgService.updateMerchandiseImg(merImg);
		}
		Merchandise mer = merchandiseService.loadMer(merchandise.getMerchandiseId());//最新数据
		return mer;
	}
	/**
	 * 商品删除
	 * @return
	 */
	@RequestMapping(value = "/delMerchandise", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String delMerchandise(@RequestParam("merchandiseId") Integer merchandiseId,HttpSession session)  {
		merchandiseService.delMer(merchandiseId);
		return StatusCode.GetValueByKey(StatusCode.SUCCESS);
	}
	/**
	 * 商品上、下架
	 * @return
	 */
	@RequestMapping(value = "/statusMerchandise", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String statusMerchandise(@RequestParam("merchandiseId") Integer merchandiseId,@RequestParam(value="merchandiseStatus",required=false) String merchandiseStatus,HttpSession session)  {
		Merchandise mer = merchandiseService.loadMer(merchandiseId);
		mer.setMerchandiseStatus(merchandiseStatus);
		merchandiseService.updateMer(mer);
		return StatusCode.GetValueByKey(StatusCode.SUCCESS);
	}
	/**
	 * 浏览商品数量
	 * @return
	 */
	@RequestMapping(value = "/browseMerCountBySeller", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody int browseMerCountBySeller(@RequestParam("sellerId") Integer sellerId,@RequestParam(value="merchandiseStatus",required=false) String merchandiseStatus,HttpSession session)  {
		int count = merchandiseService.countRecord(sellerId, merchandiseStatus, 0);
		return count;
	}
	/**
	 * 单个商品加载
	 * @return
	 */
	@RequestMapping(value = "/loadMerchandise", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody MerchandiseDTO loadMerchandise(@RequestParam("merchandiseId") Integer merchandiseId,HttpSession session)  {
		MerchandiseDTO merDTO=new MerchandiseDTO();
		Merchandise mer = merchandiseService.loadMer(merchandiseId);
		BeanUtils.copyProperties(mer, merDTO);
		merDTO.setMerCategoryId(mer.getMerCategory().getMerCategoryId());
		Integer[] merchandiseImgsid=new Integer[mer.getMerchandiseImgs().size()];
		for (int i = 0; i < merchandiseImgsid.length; i++) {
			merchandiseImgsid[i]=mer.getMerchandiseImgs().get(i).getMerchandiseImgId();
		}
		merDTO.setMerchandiseImgIds(merchandiseImgsid);
		merDTO.setMerchandiseMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
		return merDTO;
	}
	
	
}