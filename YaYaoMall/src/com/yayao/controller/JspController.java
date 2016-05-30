package com.yayao.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yayao.bean.MerCategory;
import com.yayao.service.MerCategoryService;
import com.yayao.util.FileUploadUtil;
/**
 * jsp控制类
 * 
 * @author yy
 * 
 */
@Scope("prototype")
@Controller("jspController")
public class JspController {
	@Resource(name = "merCategoryService")
	private MerCategoryService merCategoryService;
	/**
	 * jsp
	 * 
	 * 无.返回路径
	 * .json .xml返回路径
	 *
	 */
	@RequestMapping(value = "/{success}", method = {RequestMethod.GET,RequestMethod.POST})
	public  String s2(@PathVariable String success) {
		if(success.equals("a")){
			return "success";
		}
		if(success.equals("b")){
			return success;
		}
		return success;
	}
	/**
	 * jsp
	 * 
	 * 无.返回错误404
	 * .json .xml返回含有对象名的对象
	 *如：{merCategoryList:[...]} 
	 */
	@RequestMapping(value = "/a/{success}", method = {RequestMethod.GET,RequestMethod.POST})
	public List<MerCategory> a2(@PathVariable("success") String url) {
		List<MerCategory> list=null;
		if(url.equals("a")){
			 list = merCategoryService.browseMerCategory(8);
			return list;
		}
		if(url.equals("b")){
			return list;
		}
		return list;
	}
	/**
	 * 无.返回错误404
	 * .json .xml返回含有对象名的对象
	 *如：{merCategoryList:[...]} 
	 */
	@RequestMapping(value = "/a/d/{success}", method = {RequestMethod.GET,RequestMethod.POST})
	public @ModelAttribute List<MerCategory> asa2(@PathVariable("success") String url) {
		List<MerCategory> list=null;
		if(url.equals("a")){
			list = merCategoryService.browseMerCategory(8);
			return list;
		}
		if(url.equals("b")){
			return list;
		}
		return list;
	}
	/**
	 * jsp
	 * 
	 * 无.返回xml
	 * .json .xml返回不含对象名的数组对象
	 *如：[...] 
	 */
	@RequestMapping(value = "/a/d/d/{success}", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<MerCategory> asdsa2(@PathVariable("success") String url) {
		List<MerCategory> list=null;
		if(url.equals("a")){
			list = merCategoryService.browseMerCategory(8);
			return list;
		}
		if(url.equals("b")){
			return list;
		}
		return list;
	}
	/**
	 *test
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value = "/fileUploadTest", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String asdsa2(@RequestParam("fileTest") MultipartFile file,HttpSession session) throws IllegalStateException, IOException {
		String merImgUrl = FileUploadUtil.FormDataMerImgFileUpload(file, session,"/resources/sellerUpload","1");
		return merImgUrl;
	}
	
}