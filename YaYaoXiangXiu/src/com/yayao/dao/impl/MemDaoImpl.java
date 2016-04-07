package com.yayao.dao.impl;

import java.util.*;

import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;






import org.springframework.transaction.annotation.Transactional;

import com.yayao.bean.*;
import com.yayao.dao.MemDao;
import com.yayao.util.*;
@Repository("memDao")
public class MemDaoImpl extends BaseLog implements MemDao {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
		//return sessionFactory.openSession();
		
	}
	/** 新增注册会员 */
	public void addMember(Member member) {
		
			getSession().save(member);
	
	}

	/** 检测登录帐号是否有效 */
	public boolean chkLoginName(String loginName) {
		boolean status = true;//true代表数据库已经存在
		Member mem = null;
		Criteria c = getSession().createCriteria(Member.class);
		c.add(Restrictions.eq("loginName", loginName));
		 mem = (Member) c.uniqueResult();
		//mem.setLoginTimes(Integer.valueOf(mem.getLoginTimes().intValue()+1));
		//mem.setLastDate(new Date());
		if(mem==null){
			status=false;
			return status;
		}	
		return status;
	}


	/** 会员登录 */
	public Member memLogin(String loginName, String loginPwd) {
		Member mem = null;
		
		Criteria c = getSession().createCriteria(Member.class);
		c.add(Restrictions.eq("loginName", loginName));
		c.add(Restrictions.eq("loginPwd",loginPwd));
		 mem = (Member) c.uniqueResult();
//		mem.setLoginTimes(Integer.valueOf(mem.getLoginTimes().intValue()+1));
//		mem.setLastDate(new Date());
		 if(mem==null){
			 return null;
		 }
		return mem;
	}

	/** 修改注册会员信息 */
	public void updateMember(Member member)  {
		
		
			//getSession().update(admin);
			/*Query q = getSession().createSQLQuery(
					" UPDATE member_tb "+ 
                    " SET LoginName=?, "+
					" LoginPwd=?, "+
					" MemberName=?, "+
					" Sex=?, "+
					" RegDate=?, "+
					" LastDate=?, "+
					" LoginTimes=?, "+
					" Email=? "+
                    " WHERE ID=? ");*/
			/*Query hql = getSession().createQuery(
					" UPDATE Member "+ 
                    " SET loginName=?, "+
					" loginPwd=?, "+
					" memberName=?, "+
					" sex=?, "+
					" regDate=?, "+
					" lastDate=?, "+
					" loginTimes=?, "+
					" memberlevel=?, "+
					" email=?, "+
					" isLogin=? "+
                    " WHERE id=? ");
			//根据登录账户修改
			hql.setString(0, member.getLoginName());
			hql.setString(1, member.getLoginPwd());
			hql.setString(2, member.getMemberName());
			hql.setString(3, member.getSex());
			hql.setString(4, member.getRegDate());
			hql.setString(5, member.getLastDate());
			hql.setInteger(6, member.getLoginTimes());
			hql.setEntity(7, member.getMemberlevel());
			hql.setString(8, member.getEmail());
			hql.setInteger(9, member.getIsLogin());
			hql.setInteger(10, member.getId());
			hql.executeUpdate();*/
		getSession().merge(member);
	}

	
	/** 浏览注册会员*/
	public List browseMember() {
		Criteria c = getSession().createCriteria(Member.class);	
		
		c.addOrder(Order.asc("id"));
		List list=c.list();
		//Query hql = getSession().createQuery("from Member m order by asc m.id");
		//List list = hql.list();
		//logger.info("在执行AdminServiceImpl类中的browseAdmin方法时出错：\n");
		return list;
	}
	
	/** 删除注册会员 */
	public void delMember(Integer id)  {
	
			//Query q = getSession().createSQLQuery(" delete from member_tb  where id=:id ");
			/*Query hql = getSession().createQuery(" delete from Member m  where m.id=:id ");
			hql.setInteger("id", id);
			hql.executeUpdate();*/
		Member member = (Member) getSession().get(Member.class, id);
		getSession().delete(member);
	}

	/**装载注册会员 */
	public Member loadMember(Integer id) {
		Member member = (Member)getSession().get(Member.class, id);
		System.out.println(member);
		return member;
	}
	/**
	 * 浏览会员级别
	 */
	public List browseMemberLevel() {
		List list = null;
			Query query = getSession().createQuery("from Memberlevel as a order by a.id");
			list = query.list();
		return list;
	}
	/**
	 * 装载会员级别
	 */
	public Memberlevel loadMemberLevel(Integer id) {
		Memberlevel level = null;
			level = (Memberlevel)getSession().get(Memberlevel.class, id);
		return level;
	}
	/**
	 * 查询注册会员
	 */
	public List searchMem(String hql)  {
		List list = null;
			Query query = getSession().createQuery(hql);
			list = query.list();
		return list;
	}
	/**
	 * 找回账户
	 */
	public Member RetrieveAccount(String loginName, String email)
			{
		Member mem = null;
		Criteria c = getSession().createCriteria(Member.class);
		c.add(Restrictions.eq("loginName", loginName));
		c.add(Restrictions.eq("email",email));
		 mem = (Member) c.uniqueResult();
		 if(mem==null){
			 return null;
		 }
		return mem;
	}

}
