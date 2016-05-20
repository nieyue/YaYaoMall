package com.yayao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.yayao.bean.Seller;
import com.yayao.dao.SellerDao;
import com.yayao.service.SellerService;
/**
 * 商户业务实现类
 * @author yy
 *
 */
@Service("sellerService")
public class SellerServiceImpl implements SellerService {
	@Autowired
	@Qualifier("sellerDao")
	private SellerDao sellerDao;
	/** 商户登录 */
	@Cacheable(cacheNames="sellerCache")
	public Seller merSellerLogin(String sellerName, String sellerPassword) {
		Seller seller=sellerDao.merSellerLogin(sellerName, sellerPassword);
		sellerDao.updateSeller(seller);
		return seller;
	}
	/** 检测登录商户是否有效 */
	@Cacheable(cacheNames="sellerCache")
	public boolean chkLoginName(String sellerName) {
		boolean status=sellerDao.chkLoginName(sellerName);
		return status;
	}
	/**
	 * 找回商户
	 */
	public Seller RetrieveAccount(String sellerName) {
		Seller seller = sellerDao.RetrieveAccount(sellerName);
		return seller;
	}
	/** 新增注册商户 */
	public boolean addSeller(Seller seller) {
		seller.setRegisterDate(new Date());//记录注册日期
		seller.setSellerNumber(0);//收藏初始为0
		seller.setIsAuthentication(0);//未认证
		String sellername = null;
		if(seller.getSellerEmail()!=null&&!seller.getSellerEmail().isEmpty()){
			sellername=seller.getSellerEmail();
		}
		if(seller.getSellerPhone()!=null&&!seller.getSellerPhone().isEmpty()){
			sellername=seller.getSellerPhone();
		}
		boolean state = sellerDao.chkLoginName(sellername);
		if (!state) {
			sellerDao.addSeller(seller);
			return true;
		}
		return false;
	}
	/** 修改注册商户 */
	public void updateSeller(Seller seller) {
		sellerDao.updateSeller(seller);
	}
	/** 查询注册商户  */
	@Cacheable(cacheNames="sellerCache")
	public List<Seller> searchSeller(String hql) {
		List<Seller> list = sellerDao.searchSeller(hql);
		return list;
	}
	/** 浏览注册商户*/
	@Cacheable(cacheNames="sellerCache")
	public List<Seller> browseSeller() {
		//浏览所有会员
		List<Seller> list=sellerDao.browseSeller();
		return list;
	}
	
	/** 删除注册商户 */
	public void delSeller(Integer sellerid) {
		sellerDao.delSeller(sellerid);

	}
	/**装载注册商户 */
	@Cacheable(cacheNames="sellerCache")
	public Seller loadSeller(Integer sellerid) {
		Seller seller=sellerDao.loadSeller(sellerid);
		return seller;
	}

}
