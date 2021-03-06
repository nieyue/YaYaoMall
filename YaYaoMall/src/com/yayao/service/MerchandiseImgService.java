package com.yayao.service;

import java.util.List;

import com.yayao.bean.MerchandiseImg;
/**
 * 商品图片业务逻辑接口
 * @author yy
 *
 */
public interface MerchandiseImgService {
	/** 新增商品图片 */	
	public void addMerchandiseImg(MerchandiseImg merchandiseImg) ;	
	/** 删除指定的商品 图片*/	
	public void delMerchandiseImg(Integer merchandiseimgid) ;	
	/** 更新商品 图片*/	
	public void updateMerchandiseImg(MerchandiseImg merchandiseImg);
	/** 装载指定的商品图片 */	
	public MerchandiseImg loadMerchandiseImg(Integer merchandiseimgid) ;	
	/** 图片地址查询商品图片 */	
	public MerchandiseImg imgAddressLoadMerchandiseImg(String imgAddress);
	/** 浏览商品图片 */
	public List<MerchandiseImg> browseMerchandiseImg(Integer merchandiseid,String orderName,String orderWay) ;	
}
