package com.yayao.dao;

import java.util.*;

import com.yayao.bean.*;

public interface MemDao {
	/** 会员登录 */
	public Member memLogin(String loginName,String loginPwd);	
	/** 检测登录帐号是否有效 */	
	public boolean chkLoginName(String loginName) ;	
	/** 找回账户 */	
	public Member RetrieveAccount(String loginName,String email) ;	
	/** 新增注册会员 */	
	public void addMember(Member member) ;
	/** 修改注册会员信息 */	
	public void updateMember(Member member) ;
	/** 查询注册会员  */
	public List searchMem(String hql) ;
	/** 浏览注册会员*/
	public List browseMember() ;
	/** 删除注册会员 */	
	public void delMember(Integer id) ;
	/**装载注册会员 */	
	public Member loadMember(Integer id);	
	/** 浏览会员级别 */
	public List browseMemberLevel() ;
	/** 装载会员级别 */
	public Memberlevel loadMemberLevel(Integer id);
	
}
