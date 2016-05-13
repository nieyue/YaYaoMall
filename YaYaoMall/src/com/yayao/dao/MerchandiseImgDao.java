package com.yayao.dao;

import java.util.List;

import com.yayao.bean.Merchandise;
import com.yayao.bean.MerchandiseImg;

/**
 * 商品图片访问接口
 * @author yy
 *
 */
public interface MerchandiseImgDao {
	/** 新增商品图片 */	
	public void addMerchandiseImg(MerchandiseImg merchandiseImg) ;	
	/** 删除指定的商品 图片*/	
	public void delMerchandiseImg(Integer id) ;	
	/** 更新商品 图片*/	
	public void updateMerchandiseImg(MerchandiseImg merchandiseImg);
	/** 装载指定的商品图片 */	
	public MerchandiseImg loadMerchandiseImg(Integer id) ;	
	/** 图片地址查询商品图片 */	
	public MerchandiseImg imgAddressLoadMerchandiseImg(String imgAddress) ;	
	/** 浏览商品图片 */
	public List<MerchandiseImg> browseMerchandiseImg(Merchandise merchandise,String orderName,String orderWay) ;	
	
}

