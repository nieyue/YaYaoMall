package com.yayao.dao;

import java.util.List;

import com.yayao.bean.User;
import com.yayao.bean.UserLevel;

/**
 * 账户接口
 * @author yy
 *
 */
public interface UserDao {
	/** 账户登录 */
	public User userLogin(String userName,String userPassword);	
	/** 检测登录帐号是否有效 */	
	public boolean chkLoginName(String userName) ;	
	/** 找回账户 */	
	public User RetrieveAccount(String userName,String userEmail) ;	
	/** 新增注册账户 */	
	public void addUser(User user) ;
	/** 修改注册账户信息 */	
	public void updateUser(User user) ;
	/** 查询注册账户  */
	public List<User> searchUser(String hql) ;
	/** 浏览注册账户*/
	public List<User> browseUser() ;
	/** 删除注册账户 */	
	public void delUser(Integer id) ;
	/**装载注册账户 */	
	public User loadUser(Integer id);	
	/** 浏览账户级别 */
	public List<User> browseUserLevel() ;
	/** 装载账户级别 */
	public UserLevel loadUserLevel(Integer id);
	
}

