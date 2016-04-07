package com.yayao.dao.impl;

import java.util.*;

import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.yayao.bean.*;
import com.yayao.dao.MerDao;
import com.yayao.util.*;
@Repository("merDao")
public class MerDaoImpl extends BaseLog implements MerDao {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
		//return sessionFactory.openSession();
		
	}

	/**
	 * 新增商品分类 
	 */
	public void addCategory(Category cate){
			getSession().save(cate);
	}

	/**
	 * 删除指定的商品分类 
	 */
	public void delCategory(Integer id){
		
			//Query q=getSession().createSQLQuery(" delete from category_tb where id=:id ");
			Query hql=getSession().createQuery(" delete from Category where id=:id ");
			hql.setInteger("id", id);
			hql.executeUpdate();
	}

	/**
	 * 更新商品分类 
	 */
	public void updateCategory(Category cate) {
			/*Query q=getSession().createSQLQuery(
			" UPDATE category_tb "+ 
		            " SET cateName=?, "+
					" cateDesc=? "+
		            " WHERE ID=? "
					);*/
			/*Query hql=getSession().createQuery(
					" UPDATE Category "+ 
							" SET cateName=?, "+
							" cateDesc=? "+
							" WHERE id=? "
					);
			hql.setString(0, cate.getCateName());
			hql.setString(1, cate.getCateDesc());
			hql.setInteger(2, cate.getId());
			hql.executeUpdate();*/
		getSession().merge(cate);
	}

	/**
	 * 装载指定的商品分类 
	 */
	public Category loadCategory(Integer id) {
		Category cate = null;
			cate = (Category)getSession().get(Category.class, id);
		return cate;
	}

	/**
	 * 浏览商品分类 
	 */
	public List browseCategory() {
			Criteria c = getSession().createCriteria(Category.class);		
			c.addOrder(Order.asc("id"));
			List list=c.list();
		    return list;
	}

	/**
	 * 新增商品 
	 */
	public void addMer(Merchandise mer) {
			getSession().save(mer);
	}

	/**
	 * 删除指定的商品 
	 */
	public void delMer(Integer id){
			//Query q=getSession().createSQLQuery(" delete from merchandise_tb  where id=:id");
			Query hql=getSession().createQuery(" delete from Merchandise  where id=:id");
			hql.setInteger("id", id);
			hql.executeUpdate();
	}

	/**
	 * 更新商品 
	 */
	public void updateMer(Merchandise mer)  {
			getSession().merge(mer);
		/*Query q = getSession().createSQLQuery(
					" UPDATE merchandise_tb "+ 
                    " SET merName=?, "+
					" price=?, "+
					" sprice=?, "+
					" merModel=?, "+
					" picture=?, "+
					" merDesc=?, "+
					" manufacturer=?, "+
					" leaveFactoryDate=?, "+
					" special=? "+
                    " WHERE ID=? ");*/
			/*Query hql = getSession().createQuery(
					" UPDATE Merchandise "+ 
							" SET merName=?, "+
							" price=?, "+
							" sprice=?, "+
							" merModel=?, "+
							" picture=?, "+
							" merDesc=?, "+
							" manufacturer=?, "+
							" leaveFactoryDate=?, "+
							" special=?, "+
							" category=? "+
					" WHERE id=? ");
			hql.setString(0, mer.getMerName());
			hql.setDouble(1, mer.getPrice());
			hql.setDouble(2, mer.getSprice());
			hql.setString(3, mer.getMerModel());
			hql.setString(4, mer.getPicture());
			hql.setString(5, mer.getMerDesc());
			hql.setString(6, mer.getManufacturer());
			hql.setString(7, mer.getLeaveFactoryDate());
			hql.setInteger(8, mer.getSpecial());
			hql.setEntity(9, mer.getCategory());
			hql.setInteger(10, mer.getId());
			hql.executeUpdate();*/

	}

	/**
	 * 装载指定的商品
	 */
	public Merchandise loadMer(Integer id)  {
		Merchandise mer = null;
			mer = (Merchandise)getSession().get(Merchandise.class, id);
		return mer;
	}

	/**
	 * 浏览商品 
	 */
	public List browseMer(String hql){
		List list = null;
			Query query = getSession().createQuery(hql);
			list = query.list();
		return list;
	}

	/**
	 * 分页浏览商品 
	 */
	public List browseMer(int pageSize, int pageNo, int cateId1,int cateId2,
			boolean isSpecial)  {
		List list = null;
			String hql = "from Merchandise ";
			if (isSpecial){	//特价商品
				hql = hql + " where special=1";
			}else{ //普通商品
				hql = hql + " where special=0";				
			}
			if (cateId1!=0&&cateId2!=0){ //指定类别
				hql = hql + " and category.id between "+cateId1+" and "+cateId2;
			}
			hql = hql + " order by id desc";
			Query query = getSession().createQuery(hql);
			query.setMaxResults(pageSize);
			query.setFirstResult((pageNo-1)*pageSize);
			list = query.list();
		return list;
	}

	/**
	 * 检索商品
	 */
	public List browseMer(int pageSize, int pageNo, String hql)
		 {
		List list = null;
			Query query = getSession().createQuery(hql);
			query.setMaxResults(pageSize);
			query.setFirstResult((pageNo-1)*pageSize);
			list = query.list();
		return list;
	}

	/**
	 * 统计记录条数 
	 */
	public int countRecord(String hql)  {
		int count = 0;
			Query query = getSession().createQuery(hql);
			query.setMaxResults(1);
			count = Integer.parseInt(query.uniqueResult().toString());
		return count;
	}

	/**
	 * 检查商品分类存在否
	 */
	public boolean chkCategory(String cateName) {
		boolean status = true;//true代表数据库已经存在
		Category cate = null;
		Criteria c = getSession().createCriteria(Category.class);
		c.add(Restrictions.eq("cateName", cateName));
		 cate = (Category) c.uniqueResult();
		//mem.setLoginTimes(Integer.valueOf(mem.getLoginTimes().intValue()+1));
		//mem.setLastDate(new Date());
		if(cate==null){
			status=false;
			return status;
		}
		
		return status;
	}

	/** 后台检索商品（按商品模糊名称） */
	public List searchMerchandise(String merName) {
		List list=null;
		Criteria criteria = getSession().createCriteria(Merchandise.class);
		criteria.add(Restrictions.like("merName", "%"+merName+"%"));
		list=criteria.list();
		return list;
	}
	
}
