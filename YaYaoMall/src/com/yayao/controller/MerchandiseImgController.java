package com.yayao.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yayao.bean.MerchandiseImg;
import com.yayao.service.MerchandiseImgService;
import com.yayao.service.MerchandiseService;
import com.yayao.util.FileUploadUtil;
import com.yayao.util.StatusCode;
/**
 * 商品图片控制类
 * 
 * @author yy
 * 
 */
@Scope("prototype")
@Controller("merchandiseImgController")
@RequestMapping(value = "/merchandiseImg")
public class MerchandiseImgController {
	@Resource(name = "merchandiseImgService")
	private MerchandiseImgService merchandiseImgService;
	@Resource(name = "merchandiseService")
	private MerchandiseService merchandiseService;
	
	/**
	 * 浏览单个商品图片
	 * @return
	 */
	@RequestMapping(value = "/browseMerchandiseImg", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<MerchandiseImg> browseMerchandiseImg(@RequestParam("merchandiseId") Integer merchandiseId,HttpSession session)  {
			List<MerchandiseImg> list = merchandiseImgService.browseMerchandiseImg(merchandiseId, "merchandiseImgUpdateTime", "asc");
			return list;
	}
	/**
	 * 商品图片修改
	 * @return
	 */
	@RequestMapping(value = "/updateMerchandiseImg", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody MerchandiseImg updateMerchandiseImg(@RequestParam("merchandise_img_id")Integer merchandiseImgId,HttpSession session,@RequestParam("mer_file") MultipartFile file,@RequestParam("seller_id")Integer sellerId)  {
		MerchandiseImg merchandiseImg=merchandiseImgService.loadMerchandiseImg(merchandiseImgId);
		String imgdir=sellerId.toString();
		String merImgUrl = null;
		try{
			 merImgUrl = FileUploadUtil.updateFormDataMerImgFileUpload(file, session, "/resources/sellerUpload", imgdir, merchandiseImg.getMerchandiseImgAddress());
			 merchandiseImg.setMerchandiseImgAddress(merImgUrl);
		}catch (IOException e) {
			e.printStackTrace();
		}
		merchandiseImg.setMerchandiseImgMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
		merchandiseImgService.updateMerchandiseImg(merchandiseImg);
		return merchandiseImg;
	}
	/**
	 * 商品图片增加
	 * @return
	 */
	@RequestMapping(value = "/addMerchandiseImg", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody MerchandiseImg addMerchandiseImg(@RequestParam("mer_file") MultipartFile file,HttpSession session,@RequestParam("seller_id")Integer sellerId )  {
		MerchandiseImg merchandiseImg=new MerchandiseImg();
		String imgdir=sellerId.toString();
		String merImgUrl = null;
		try{
			 merImgUrl = FileUploadUtil.FormDataMerImgFileUpload(file, session,"/resources/sellerUpload",imgdir);
			merchandiseImg.setMerchandiseImgAddress(merImgUrl);
		}catch (IOException e) {
			e.printStackTrace();
		}
		merchandiseImg.setMerchandiseImgMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
		merchandiseImgService.addMerchandiseImg(merchandiseImg);
		merchandiseImg=merchandiseImgService.imgAddressLoadMerchandiseImg(merImgUrl);
		return merchandiseImg;
	}
	/**
	 * 商品图片删除
	 * @return
	 */
	@RequestMapping(value = "/delMerchandiseImg", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String delMerchandiseImg(@RequestParam("merchandiseImgId")Integer merchandiseImgId,HttpSession session)  {
		MerchandiseImg merimg = merchandiseImgService.loadMerchandiseImg(merchandiseImgId);
		boolean status = FileUploadUtil.delMerImgFile(session, merimg.getMerchandiseImgAddress());
		if(status){
			merchandiseImgService.delMerchandiseImg(merchandiseImgId);
			return StatusCode.GetValueByKey(StatusCode.SUCCESS);
		}
		return StatusCode.GetValueByKey(StatusCode.ERROR);
	}
	
}