package com.yayao.dao;

import java.util.List;

import com.yayao.bean.UserLevel;

/**
 * 账户等级数据访问接口
 * @author yy
 *
 */
public interface UserLevelDao {
	/** 新增账户等级 */	
	public void addUserLevel(UserLevel userLevel) ;
	/** 修改账户等级 */	
	public void updateUserLevel(UserLevel userLevel) ;
	/** 删除账户等级 */	
	public void delUserLevel(Integer id) ;	
	/** 浏览账户级别 */
	public List<UserLevel> browseUserLevel() ;
	/** 装载账户级别 */
	public UserLevel loadUserLevel(Integer id);
	
}

