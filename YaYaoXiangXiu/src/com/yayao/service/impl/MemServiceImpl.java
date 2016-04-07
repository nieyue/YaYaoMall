package com.yayao.service.impl;

import java.util.*;

import org.apache.struts2.ServletActionContext;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yayao.bean.*;
import com.yayao.dao.ConsigneeDao;
import com.yayao.dao.MemDao;
import com.yayao.service.CommentService;
import com.yayao.service.ConsigneeService;
import com.yayao.service.MemService;
import com.yayao.util.*;
@Service("memService")
public class MemServiceImpl implements MemService {

	@Autowired
	@Qualifier("memDao")
	private MemDao memDao;
	
	/** 新增注册会员 */
	public void addMember(Member member){
		member.setLoginTimes(0);
		member.setRegDate(DateUtil.getCurrentTime());
		Memberlevel ml=memDao.loadMemberLevel(1);
		member.setMemberlevel(ml);
		member.setLastDate(DateUtil.getCurrentTime());
		member.setIsLogin(new Integer(0));
		memDao.addMember(member);
	}

	/** 检测登录帐号是否有效 */
	public boolean chkLoginName(String loginName)  {
		boolean status=memDao.chkLoginName(loginName);
		return status;
	}


	/** 会员登录 */
	public Member memLogin(String loginName, String loginPwd) {
	Member member=memDao.memLogin(loginName, loginPwd);
	if(member!=null){
	Integer i= member.getLoginTimes();
	i++;
	member.setLoginTimes(i);
	member.setLastDate(DateUtil.getCurrentTime());
	member.setIsLogin(1);
	//修改数据库
	memDao.updateMember(member);
	}
		return member;
	}

	/** 修改注册会员 */
	public void updateMember(Member member) {
		
	memDao.updateMember(member);
		
	}

	/** 浏览注册会员*/
	public List browseMember()  {
		
		//浏览所有会员
		List members=memDao.browseMember();
		if(members!=null){
		
		ActionContextUtil.getSession().remove("memList");
		//存储所有会员
		ActionContextUtil.getSession().put("memList", members);
		}
		return members;
	}
	/** 管理员浏览注册会员*/
	public List adminBrowseMember() {
		
		//浏览所有会员
		List members=memDao.browseMember();
		if(members!=null){
			
			ActionContextUtil.getSession().remove("aMemList");
			//存储所有会员
			ActionContextUtil.getSession().put("aMemList", members);
		}
		return members;
	}

	/** 删除注册会员 */
	public void delMember(Integer id) {
		memDao.delMember(id);
		
	}

	/**装载注册会员 */
	public Member loadMember(Integer id) {
		Member member=memDao.loadMember(id);
		return member;
	}

	/**浏览注册会员等级 */
	public List browseMemberLevel()  {
		List l = memDao.browseMemberLevel();
		return l;
	}

	/**装载注册会员 级别*/
	public Memberlevel loadMemberLevel(Integer id) {
		Memberlevel ml = memDao.loadMemberLevel(id);
		return ml;
	}

	/** 查询注册会员  */
	public List searchMem(String hql) {
		List list = memDao.searchMem(hql);
		return list;
	}

	/**
	 * 找回账户
	 */
	public Member RetrieveAccount(String loginName, String email)
			 {
		Member m = memDao.RetrieveAccount(loginName, email);
		return m;
	}

	
}
