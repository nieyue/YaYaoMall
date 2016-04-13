package com.yayao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yayao.bean.User;
import com.yayao.bean.UserLevel;
import com.yayao.dao.UserDao;
import com.yayao.dao.UserLevelDao;
import com.yayao.service.UserService;
import com.yayao.util.DateUtil;
/**
 * 账户业务实现类
 * @author yy
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	@Autowired
	@Qualifier("userLevelDao")
	private UserLevelDao userLevelDao;
	/** 账户登录 */
	@Override
	public User userLogin(String userName, String userPassword) {
		User user=userDao.userLogin(userName, userPassword);
		if(user!=null){
		user.setLastLoginTime(DateUtil.getFormatCurrentTime());
		user.setIsLogin(1);
		//修改数据库
		userDao.updateUser(user);
		}
			return user;
	}
	/** 检测登录帐号是否有效 */
	@Override
	public boolean chkLoginName(String userName) {
		boolean status=userDao.chkLoginName(userName);
		return status;
	}
	/**
	 * 找回账户
	 */
	@Override
	public User RetrieveAccount(String userName) {
		User u = userDao.RetrieveAccount(userName);
		return u;
	}
	/** 新增注册账户 */
	@Override
	public boolean addUser(User user) {
		user.setRegDate(new Date());
		UserLevel ul=userLevelDao.loadUserLevel(1);
		if(ul!=null){
		user.setUserLevel(ul);
		user.setIntegral(new Integer(0));
		user.setLastLoginTime(new Date());
		user.setIsLogin(new Integer(1));
		String username = null;
		if(user.getUserEmail()!=null&&!user.getUserEmail().isEmpty()){
			username=user.getUserEmail();
		}
		if(user.getUserPhone()!=null&&!user.getUserPhone().isEmpty()){
			username=user.getUserPhone();
		}
		boolean state = userDao.chkLoginName(username);
		if (!state) {
			userDao.addUser(user);
			return true;
		}
		
		}
		return false;
	}
	/** 修改注册账户 */
	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
	/** 查询注册会员  */
	@Override
	public List<User> searchUser(String hql) {
		List<User> list = userDao.searchUser(hql);
		return list;
	}
	/** 浏览注册账户*/
	@Override
	public List<User> browseUser() {
		//浏览所有会员
		List<User> users=userDao.browseUser();
		//if(users!=null){
		//存储所有会员
		//session.setAttribute("userList", users);
		//}
		return users;
	}
	/** 管理员浏览注册账户*/
	@Override
	public List<User> adminBrowseUser() {
		//浏览所有会员
		List<User> users=userDao.browseUser();
		/*if(users!=null){
		ActionContextUtil.getSession().remove("aMemList");
		//存储所有会员
		ActionContextUtil.getSession().put("aMemList", members);
		}*/
		return users;
	}
	/** 删除注册账户 */
	@Override
	public void delUser(Integer id) {
		userDao.delUser(id);

	}
	/**装载注册账户 */
	@Override
	public User loadUser(Integer id) {
		User user=userDao.loadUser(id);
		return user;
	}

}
