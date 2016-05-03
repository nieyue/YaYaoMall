package com.yayao.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yayao.service.MerCategoryService;
import com.yayao.service.MerchandiseService;
/**
 * 账户控制类
 * 
 * @author yy
 * 
 */
@Scope("prototype")
@Controller("seller")
@RequestMapping(value = "/seller")
public class SellerController {
	@Resource(name = "merCategoryService")
	private MerCategoryService merCategoryService;
	@Resource(name = "merchandiseService")
	private MerchandiseService merchandiseService;
	
	
	
	
}