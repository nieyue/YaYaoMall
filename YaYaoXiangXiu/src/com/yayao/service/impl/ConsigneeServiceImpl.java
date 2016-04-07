package com.yayao.service.impl;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yayao.bean.Consignee;
import com.yayao.bean.Member;
import com.yayao.dao.ConsigneeDao;
import com.yayao.service.ConsigneeService;
import com.yayao.util.ActionContextUtil;
import com.yayao.util.BaseLog;
@Service("consigneeService")
public class ConsigneeServiceImpl extends BaseLog implements ConsigneeService {
	
	@Autowired
	@Qualifier("consigneeDao")
	private ConsigneeDao consigneeDao;
	/**
	 * 增加收货人
	 */
	@Override
	public void addConsignee(Consignee consignee){
		consigneeDao.addConsignee(consignee);
		
	}
	
	/**
	 * 修改收货人信息
	 */
	@Override
	public void updateConsignee(Consignee consignee) {
		consigneeDao.updateConsignee(consignee);
		
	}

	/**
	 * 浏览当前人的所有收货信息
	 */
	@Override
	public List browseConsignee(Member member) {
		
		//存储当前收货人信息
		List list=new ArrayList();
		//浏览所有人收货信息
		List newconsignees=consigneeDao.browseConsignee();
		if(newconsignees!=null){
		for (int j = 0; j < newconsignees.size(); j++) {
			Consignee con = (Consignee) newconsignees.get(j);
			if((con.getMember().getId()).equals(member.getId())){
				list.add(con);
			}
		}
		
		ActionContextUtil.getSession().remove("conList");
		//存储当前收货人信息
		ActionContextUtil.getSession().put("conList", list);
		}
		return list;
	}
	/**
	 * 管理员浏览当前人的所有收货信息
	 */
	@Override
	public List adminBrowseConsignee(Member member){
		
		//存储当前收货人信息
		List list=new ArrayList();
		//浏览所有人收货信息
		List newconsignees=consigneeDao.browseConsignee();
		if(newconsignees!=null){
			for (int j = 0; j < newconsignees.size(); j++) {
				Consignee con = (Consignee) newconsignees.get(j);
				if((con.getMember().getId()).equals(member.getId())){
					list.add(con);
				}
			}
			
			ActionContextUtil.getSession().remove("aConList");
			//存储当前收货人信息
			ActionContextUtil.getSession().put("aConList", list);
		}
		return list;
	}

	/**
	 * 删除收货人信息
	 */
	@Override
	public void delConsignee(Integer id) {
		consigneeDao.delConsignee(id);
			
	}
	
	/**
	 * 装载收货人信息
	 */
	@Override
	public Consignee loadConsignee(Integer id){
		Consignee consignee=consigneeDao.loadConsignee(id);
		return consignee;
	}

}
