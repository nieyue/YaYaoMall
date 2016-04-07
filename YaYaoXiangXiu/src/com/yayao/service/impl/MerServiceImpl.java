package com.yayao.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yayao.bean.*;
import com.yayao.dao.MerDao;
import com.yayao.service.MerService;
import com.yayao.util.ActionContextUtil;

@Service("merService")
public class MerServiceImpl implements MerService {

	@Autowired
	@Qualifier("merDao")
	private MerDao merDao;

	@Override
	public void addCategory(Category cate)  {
		merDao.addCategory(cate);
	}

	@Override
	public void delCategory(Integer id) {
		 merDao.delCategory(id);
	}

	@Override
	public void updateCategory(Category cate) {
		merDao.updateCategory(cate);
	}

	@Override
	public Category loadCategory(Integer id){
			Category cate = merDao.loadCategory(id);
		return cate;
	}

	/**
	 * 浏览商品类型
	 */
	public List browseCategory(){
		List list=null;
		list= merDao.browseCategory();
		ActionContextUtil.getSession().remove("cateList");
		//存储当前收货人信息
		ActionContextUtil.getSession().put("cateList", list);
		return list;
	
	}

	@Override
	public void addMer(Merchandise mer){
		merDao.addMer(mer);
		browseMer("from Merchandise as a order by a.id desc");
		browseMer("from Merchandise as a where a.special=1 order by a.id");
	}

	@Override
	public void delMer(Integer id){
		merDao.delMer(id);
		browseMer("from Merchandise as a order by a.id desc");
		browseMer("from Merchandise as a where a.special=1 order by a.id");
	}

	@Override
	public void updateMer(Merchandise mer) {
		 merDao.updateMer(mer);
		browseMer("from Merchandise as a order by a.id desc");
		browseMer("from Merchandise as a where a.special=1 order by a.id");
	}

	@Override
	public Merchandise loadMer(Integer id) {
		Merchandise mer = merDao.loadMer(id);
		return mer;
	}

	/**
	 * 浏览所有的商品
	 */
	public List browseMer(String hql){
		 String hql1 ="from Merchandise as a order by a.id desc";
		 String hql2 ="from Merchandise as a where a.special=1 order by a.id";
		 //存储商品
		 List list=new ArrayList();
		//浏览所有包含特价的商品
		 if(hql==hql1){	
		//浏览所有的商品
		List l = merDao.browseMer(hql1);
		for (int j = 0; j < l.size(); j++) {
			Merchandise mer = (Merchandise) l.get(j);
				list.add(mer);
		}
		
		ActionContextUtil.getSession().remove("merList");
		//存储当前收货人信息
		ActionContextUtil.getSession().put("merList", list);
		return list;
		}
		//浏览所有特价商品
		 else if(hql==hql2){	
			 //浏览所有的商品
			 List l = merDao.browseMer(hql2);
			
			 for (int j = 0; j < l.size(); j++) {
				 Merchandise mer = (Merchandise) l.get(j);
					 list.add(mer);
				
			 }
			 
			 ActionContextUtil.getSession().remove("smerList");
			 //存储当前收货人信息
			 ActionContextUtil.getSession().put("smerList", list);
			return list;
		 }
		return list;
	}

	/**
	 * 分页浏览类型ID为1，2，3的所有商品
	 */
	public List browseMer(int pageSize, int pageNo,int cateId1,int cateId2,
			boolean isSpecial) {
		Map session = ActionContextUtil.getSession();
		session.remove("embroideryMerchandiseList");
		int merTotals = 0; //记录总数
		int merTotalPages = 0; //总页数
		List merchandises = merDao.browseMer(pageSize, pageNo, cateId1, cateId2, isSpecial);
		Collections.shuffle(merchandises);//顺序打乱
			if(merchandises!=null){	
				merTotals = merDao.countRecord("select count(ID) from Merchandise  where category.id between "+cateId1+" and "+cateId2);
			if (merchandises!=null&&merchandises.size()>0){
			session.put("embroideryMerchandiseList", merchandises);
			}
			//设置总记录数、总页数、当前页号
			merTotalPages = merTotals / pageSize;
			if ((merTotals % pageSize)>0){ 
				merTotalPages++; 
			}
			session.remove("merTotals");
			session.remove("merTotalPages");
			session.remove("merPageNo");
			session.put("merTotals", new Integer(merTotals));
			session.put("merTotalPages",new Integer(merTotalPages));
			session.put("merPageNo",new Integer(pageNo));
		return merchandises ;
		}
		
		return merchandises;
	}

	/**
	 * 检索商品，按两个价格来检索
	 */
	public List browseMer(int pageSize, int pageNo, String firstPrice, String lastPrice)
			{
		Map session = ActionContextUtil.getSession();
		session.remove("embroideryMerchandiseList");
		int merTotals = 0; //记录总数
		int merTotalPages = 0; //总页数
		Double fp=Double.valueOf(firstPrice);
		Double lp=Double.valueOf(lastPrice);
		List merchandises = merDao.browseMer(pageSize, pageNo, "from Merchandise where ( price >"+fp+" and price <"+lp+") or ( price <"+fp+" and price >"+lp+")");
		Collections.shuffle(merchandises);//顺序打乱
			if(merchandises!=null){	
				merTotals = merDao.countRecord("select count(ID) from Merchandise  where ( price >"+fp+" and price <"+lp+") or ( price <"+fp+" and price >"+lp+")");
			if (merchandises!=null&&merchandises.size()>0){
			session.put("embroideryMerchandiseList", merchandises);
			}
			//设置总记录数、总页数、当前页号
			merTotalPages = merTotals / pageSize;
			if ((merTotals % pageSize)>0){ 
				merTotalPages++; 
			}
			session.remove("merTotals");
			session.remove("merTotalPages");
			session.remove("merPageNo");
			session.put("merTotals", new Integer(merTotals));
			session.put("merTotalPages",new Integer(merTotalPages));
			session.put("merPageNo",new Integer(pageNo));
			return merchandises;
			}
		  return merchandises;
	}

	@Override
	public int countRecord(String hql){
		int n = merDao.countRecord(hql);
		return n;
	}

	@Override
	public boolean chkCategory(String cateName)  {
		boolean status=merDao.chkCategory(cateName);
		return status;
	}

	@Override
	public List searchMerchandise(String merName) {
		List list = merDao.searchMerchandise(merName);
		return list;
	}
	

}
