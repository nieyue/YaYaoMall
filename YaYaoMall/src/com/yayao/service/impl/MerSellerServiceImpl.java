package com.yayao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yayao.bean.MerSeller;
import com.yayao.dao.MerSellerDao;
import com.yayao.service.MerSellerService;
/**
 * 商户业务实现类
 * @author yy
 *
 */
@Service("merSellerService")
public class MerSellerServiceImpl implements MerSellerService {
	@Autowired
	@Qualifier("merSellerDao")
	private MerSellerDao merSellerDao;
	/** 商户登录 */
	@Override
	public MerSeller merSellerLogin(String sellerName, String sellerPassword) {
		MerSeller merSeller=merSellerDao.merSellerLogin(sellerName, sellerPassword);
		merSellerDao.updateMerSeller(merSeller);
		return merSeller;
	}
	/** 检测登录商户是否有效 */
	@Override
	public boolean chkLoginName(String sellerName) {
		boolean status=merSellerDao.chkLoginName(sellerName);
		return status;
	}
	/**
	 * 找回商户
	 */
	@Override
	public MerSeller RetrieveAccount(String sellerName) {
		MerSeller merSeller = merSellerDao.RetrieveAccount(sellerName);
		return merSeller;
	}
	/** 新增注册商户 */
	@Override
	public boolean addMerSeller(MerSeller merSeller) {
		merSeller.setRegisterDate(new Date());//记录注册日期
		merSeller.setSellerNumber(0);//收藏初始为0
		merSeller.setIsAuthentication(0);//未认证
		String sellername = null;
		if(merSeller.getSellerEmail()!=null&&!merSeller.getSellerEmail().isEmpty()){
			sellername=merSeller.getSellerEmail();
		}
		if(merSeller.getSellerPhone()!=null&&!merSeller.getSellerPhone().isEmpty()){
			sellername=merSeller.getSellerPhone();
		}
		boolean state = merSellerDao.chkLoginName(sellername);
		if (!state) {
			merSellerDao.addMerSeller(merSeller);
			return true;
		}
		return false;
	}
	/** 修改注册商户 */
	@Override
	public void updateMerSeller(MerSeller merSeller) {
		merSellerDao.updateMerSeller(merSeller);
	}
	/** 查询注册商户  */
	@Override
	public List<MerSeller> searchMerSeller(String hql) {
		List<MerSeller> list = merSellerDao.searchMerSeller(hql);
		return list;
	}
	/** 浏览注册商户*/
	@Override
	//@Cacheable(cacheNames="userCache")
	public List<MerSeller> browseMerSeller() {
		//浏览所有会员
		List<MerSeller> list=merSellerDao.browseMerSeller();
		return list;
	}
	
	/** 删除注册商户 */
	@Override
	public void delMerSeller(Integer id) {
		merSellerDao.delMerSeller(id);

	}
	/**装载注册商户 */
	public MerSeller loadMerSeller(Integer id) {
		MerSeller merSeller=merSellerDao.loadMerSeller(id);
		return merSeller;
	}

}
