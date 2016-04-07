package com.yayao.service.impl;

import java.util.ArrayList;
import java.util.List;








import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yayao.bean.Consignee;
import com.yayao.bean.ExclusiveCustom;
import com.yayao.bean.Member;
import com.yayao.dao.ConsigneeDao;
import com.yayao.dao.ExclusiveCustomDao;
import com.yayao.service.ConsigneeService;
import com.yayao.service.ExclusiveCustomService;
import com.yayao.util.ActionContextUtil;
import com.yayao.util.BaseLog;
@Service("exclusiveCustomService")
public class ExclusiveCustomServiceImpl extends BaseLog implements ExclusiveCustomService {
	
	@Autowired
	@Qualifier("exclusiveCustomDao")
	private ExclusiveCustomDao exclusiveCustomDao;
	/**
	 * 增加定制
	 */
	@Override
	public void addExclusiveCustom(ExclusiveCustom exclusiveCustom) {
		exclusiveCustomDao.addExclusiveCustom(exclusiveCustom);
	
	}
	
	/**
	 * 修改定制信息
	 */
	@Override
	public void updateExclusiveCustom(ExclusiveCustom exclusiveCustom) {
		exclusiveCustomDao.updateExclusiveCustom(exclusiveCustom);
		
	}

	/**
	 * 浏览当前会员定制信息
	 */
	@Override
	public List browseExclusiveCustom(Member member) {
		//存储当前收货人信息
		List list=new ArrayList();
		//浏览所有人收货信息
		List newexclusiveCustoms=exclusiveCustomDao.browseExclusiveCustom();
		if(newexclusiveCustoms!=null){
		for (int j = 0; j < newexclusiveCustoms.size(); j++) {
			ExclusiveCustom exclusiveCustom = (ExclusiveCustom) newexclusiveCustoms.get(j);
			if((exclusiveCustom.getMember().getId()).equals(member.getId())){
				list.add(exclusiveCustom);
			}
		}
		
		ActionContextUtil.getSession().remove("exclusiveList");
		//存储当前收货人信息
		ActionContextUtil.getSession().put("exclusiveList", list);
		}
	return list;
	}
	/**
	 * 管理员浏览当前会员定制信息
	 */
	@Override
	public List adminBrowseExclusiveCustom(Member member)  {
		//存储当前收货人信息
		List list=new ArrayList();
		//浏览所有人收货信息
		List newexclusiveCustoms=exclusiveCustomDao.browseExclusiveCustom();
		if(newexclusiveCustoms!=null){
			for (int j = 0; j < newexclusiveCustoms.size(); j++) {
				ExclusiveCustom exclusiveCustom = (ExclusiveCustom) newexclusiveCustoms.get(j);
				if((exclusiveCustom.getMember().getId()).equals(member.getId())){
					list.add(exclusiveCustom);
				}
			}
			
			ActionContextUtil.getSession().remove("aExclusiveList");
			//存储当前收货人信息
			ActionContextUtil.getSession().put("aExclusiveList", list);
		}
		return list;
	}
	/**
	 * 删除定制信息
	 */
	@Override
	public void delExclusiveCustom(Integer id){
		exclusiveCustomDao.delExclusiveCustom(id);
	
	}
	
	/**
	 * 装载定制
	 */
	@Override
	public ExclusiveCustom loadExclusiveCustom(Integer id){
		ExclusiveCustom exclusiveCustom=exclusiveCustomDao.loadExclusiveCustom(id);
		return exclusiveCustom;
	}

	/**
	 * 浏览所有定制信息
	 */
	public List browseAllExclusiveCustom(){
				//浏览所有人收货信息
				List newexclusiveCustoms=exclusiveCustomDao.browseExclusiveCustom();
				if(newexclusiveCustoms!=null){
				
				ActionContextUtil.getSession().remove("exclusiveAllList");
				//存储当前收货人信息
				ActionContextUtil.getSession().put("exclusiveAllList", newexclusiveCustoms);
				}
			return newexclusiveCustoms;
	}

	/**
	 * 查询定制订单
	 */
	public List searchExclusiveCustom(String hql){
		List list = exclusiveCustomDao.searchExclusiveCustom(hql);
		return list;
	}

}
