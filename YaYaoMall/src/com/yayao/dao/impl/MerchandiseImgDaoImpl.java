package com.yayao.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.yayao.bean.Merchandise;
import com.yayao.bean.MerchandiseImg;
import com.yayao.dao.MerchandiseImgDao;


/**
 *商品图片数据访问实现类
 * @author yy
 *
 */
@Repository("merchandiseImgDao")
public class MerchandiseImgDaoImpl implements MerchandiseImgDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
		 //return sessionFactory.openSession();

	}

	/**
	 * 新增商品图片 
	 */
	public void addMerchandiseImg(MerchandiseImg merchandiseImg) {
		getSession().save(merchandiseImg);
	}

	/**
	 * 删除指定的商品图片 
	 */
	public void delMerchandiseImg(Integer id) {
		getSession().delete(loadMerchandiseImg(id));
	}

	/**
	 * 更新商品 图片
	 */
	public void updateMerchandiseImg(MerchandiseImg merchandiseImg) {
		getSession().merge(merchandiseImg);
	}

	/**
	 * 装载指定的商品图片
	 */
	public MerchandiseImg loadMerchandiseImg(Integer id) {
		MerchandiseImg merchandiseImg = null;
		merchandiseImg = (MerchandiseImg)getSession().get(MerchandiseImg.class, id);
		return merchandiseImg;
	}

	/**
	 * 浏览商品 图片
	 */
	@SuppressWarnings("unchecked")
	public List<MerchandiseImg> browseMerchandiseImg(Merchandise merchandise,String orderName,String orderWay) {
		Criteria c = getSession().createCriteria(MerchandiseImg.class);
		if(merchandise!=null){
			c.add(Restrictions.eq("merchandise", merchandise));
		}
		switch (orderWay) {
		case "asc":
			c.addOrder(Order.asc(orderName));
			break;
		case "desc":
			c.addOrder(Order.desc(orderName));
			break;
		}
		List<MerchandiseImg> list = c.list();
		return list;
	}


}