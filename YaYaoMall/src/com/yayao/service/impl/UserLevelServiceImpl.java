package com.yayao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.yayao.bean.UserLevel;
import com.yayao.dao.UserLevelDao;
import com.yayao.service.UserLevelService;
/**
 * 账户服务接口实现类
 * @author yy
 *
 */
@Service("userLevelService")
public class UserLevelServiceImpl implements UserLevelService {
	@Autowired
	@Qualifier("userLevelDao")
	private UserLevelDao userLevelDao;
	
	
	/** 新增账户等级 */
	public void addUserLevel(UserLevel userLevel) {
		userLevelDao.addUserLevel(userLevel);
	}
	/** 修改账户等级 */
	public void updateUserLevel(UserLevel userLevel) {
		userLevelDao.updateUserLevel(userLevel);
	}
	
	/** 删除账户等级 */
	public void delUserLevel(Integer id) {
		userLevelDao.delUserLevel(id);

	}
	/**浏览账户等级 */
	@Cacheable(cacheNames="userLevelCache")
	public List<UserLevel> browseUserLevel() {
		List<UserLevel> l = userLevelDao.browseUserLevel();
		return l;
	}
	/**装载账户等级*/
	@Cacheable(cacheNames="userLevelCache")
	public UserLevel loadUserLevel(Integer id) {
		UserLevel ml = userLevelDao.loadUserLevel(id);
		return ml;
	}

}
