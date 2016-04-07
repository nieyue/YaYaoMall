package com.yayao.service.impl;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yayao.bean.*;
import com.yayao.dao.CommentDao;
import com.yayao.dao.ConsigneeDao;
import com.yayao.service.CommentService;
import com.yayao.util.*;
@Service("commentService")
public class CommentServiceImpl extends BaseLog implements CommentService {

	@Autowired
	@Qualifier("commentDao")
	private CommentDao commentDao;
	/** 新增留言 */
	public void addComment(Comment comment) {
		 commentDao.addComment(comment);
		//browseComment(6,1);
	}

	/**  分页浏览所有留言*/
	public List browseComment(int pageSize,int pageNo){
		List list=new ArrayList();
		Map session=ActionContextUtil.getSession();
		HttpServletRequest request = ActionContextUtil.getRequest();
		Member m=(Member)session.get("Member");
		Merchandise EBMer = (Merchandise) session.get("EBMer");
		// pageNo = 1; //页号
		//pageSize = 10; //每页记录数
		int totals = 0; //记录总数
		int totalPages = 0; //总页数
			List comments =commentDao.browseComment(pageSize, pageNo);
			if(list!=null){
				for (int j = 0; j < comments.size(); j++) {
					Comment com = (Comment) comments.get(j);
					if(com.getMerchandise()!=null&&(!com.getMerchandise().equals(""))&&com.getMerchandise().getId().equals(EBMer.getId())){
					
							list.add(com);
					}
				}
		
			totals = list.size();
			if (list!=null&&list.size()>0){
			session.put("paginationCommentList", list);
			}
			//设置总记录数、总页数、当前页号
			totalPages = totals / pageSize;
			if ((totals % pageSize)>0){ 
			    totalPages++; 
			}
			session.remove("totals");
			session.remove("totalPages");
			session.remove("pageNo");
			session.put("totals", new Integer(totals));
			session.put("totalPages",new Integer(totalPages));
			session.put("pageNo",new Integer(pageNo));
		return list ;
		}
		return list;
	}

	/**
	 * 分页浏览当前商品的所有留言
	 */
	public List browseComment(int pageSize, int pageNo, Merchandise merchandise)
			 {
		List list=new ArrayList();
		Map session=ActionContextUtil.getSession();
		session.remove("paginationCommentList");
		 //pageNo = 1; //页号
		//pageSize = 10; //每页记录数
		int totals = 0; //记录总数
		int totalPages = 0; //总页数
			List comments =commentDao.browseComment(pageSize, pageNo,merchandise);
			if(comments!=null){
				for (int j = 0; j < comments.size(); j++) {
					Comment com = (Comment) comments.get(j);
					if(com.getMerchandise()!=null&&(!com.getMerchandise().equals(""))){
					
							list.add(com);
					}
				}
		
			totals = commentDao.countComment(merchandise);
			if (list!=null&&list.size()>0){
			session.put("paginationCommentList", list);
			}
			//设置总记录数、总页数、当前页号
			totalPages = totals / pageSize;
			if ((totals % pageSize)>0){ 
			    totalPages++; 
			}
			session.remove("totals");
			session.remove("totalPages");
			session.remove("pageNo");
			session.put("totals", new Integer(totals));
			session.put("totalPages",new Integer(totalPages));
			session.put("pageNo",new Integer(pageNo));
		return list ;
		}
		return list;
	}

	/** 
	 * 浏览当前人的所有定制订单留言
	 * 
	 */
	public List browseMemCustomComment(Member member)
			{
		//存储当前收货人信息
		List list=new ArrayList();
		//浏览所有人收货信息
		List newcomments=commentDao.browseComment();
		if(newcomments!=null){
		for (int j = 0; j < newcomments.size(); j++) {
			Comment com = (Comment) newcomments.get(j);
			if(com.getExclusiveCustom()!=null&&(!com.getExclusiveCustom().equals(""))){
			if(com.getMember().getId().equals(member.getId())){
				list.add(com);
				}
			}
		}
		}
		ActionContextUtil.getSession().remove("memCustomCommentList");
		//存储当前收货人信息
		ActionContextUtil.getSession().put("memCustomCommentList", list);
		return list;
	}
	/** 
	 * 管理员浏览当前人的所有定制订单留言
	 * 
	 */
	public List adminBrowseMemCustomComment(Member member)
			{
		//存储当前收货人信息
		List list=new ArrayList();
		//浏览所有人收货信息
		
		List newcomments=commentDao.browseComment();
		if(newcomments!=null){
			for (int j = 0; j < newcomments.size(); j++) {
				Comment com = (Comment) newcomments.get(j);
				if(com.getExclusiveCustom()!=null&&(!com.getExclusiveCustom().equals(""))){
					if(com.getMember().getId().equals(member.getId())){
						list.add(com);
					}
				}
			}
		}
		ActionContextUtil.getSession().remove("aMemCustomCommentList");
		//存储当前收货人信息
		ActionContextUtil.getSession().put("aMemCustomCommentList", list);
		return list;
	}
	
	/**浏览当前人的订单留言*/
	public List browseMemMerComment(Member member)
			 {
		//存储当前收货人信息
				List list=new ArrayList();
				//浏览所有人收货信息
				List newcomments=commentDao.browseComment();
				if(newcomments!=null){
				for (int j = 0; j < newcomments.size(); j++) {
					Comment com = (Comment) newcomments.get(j);
					if(com.getMerchandise()!=null&&(!com.getMerchandise().equals(""))){
					if(com.getMember().getId().equals(member.getId())){
						list.add(com);
						}
					}
				}
				}
				ActionContextUtil.getSession().remove("memMerCommentList");
				//存储当前收货人信息
				ActionContextUtil.getSession().put("memMerCommentList", list);
				return list;
	}
	
	/**管理员浏览当前人的订单留言*/
	public List adminBrowseMemMerComment(Member member)
			{
		//存储当前收货人信息
		List list=new ArrayList();
		//浏览所有人收货信息
		List newcomments=commentDao.browseComment();
		if(newcomments!=null){
			for (int j = 0; j < newcomments.size(); j++) {
				Comment com = (Comment) newcomments.get(j);
				if(com.getMerchandise()!=null&&(!com.getMerchandise().equals(""))){
					if(com.getMember().getId().equals(member.getId())){
						list.add(com);
					}
				}
			}
		}
		ActionContextUtil.getSession().remove("aMemMerCommentList");
		//存储当前收货人信息
		ActionContextUtil.getSession().put("aMemMerCommentList", list);
		return list;
	}
	
	/**浏览当前商品所有留言*/
	public List browseMerComment(Merchandise merchandise)
			 {
		//存储当前收货人信息
		List list=new ArrayList();
		//浏览所有人收货信息
		List newcomments=commentDao.browseComment();
		if(newcomments!=null){
			for (int j = 0; j < newcomments.size(); j++) {
				Comment com = (Comment) newcomments.get(j);
				if(com.getMerchandise()!=null&&(!com.getMerchandise().equals(""))&&com.getMerchandise().getId().equals(merchandise.getId())){
				
						list.add(com);
				}
			}
		}
		ActionContextUtil.getSession().remove("merCommentList");
		//存储当前收货人信息
		ActionContextUtil.getSession().put("merCommentList", list);
		return list;
	}

	/** 统计留言条数 */
	public int countComment() {
		int count = commentDao.countComment();
		return count;
	}

	/**统计当前商品的留言条数*/
	public int countComment(Merchandise merchandise) {
		int count = commentDao.countComment(merchandise);
		return count;
	}
	
	/** 装载留言 */	
	public Comment loadComment(Integer id) {
		Comment comment = commentDao.loadComment(id);
	return comment;
	}

	/** 删除留言 */	
	public void delComment(Integer id)  {
		 commentDao.delComment(id);
	//	browseComment(6,1);
			
	}

	/** 回复留言 */	
	public void updateComment(Comment comment) {
		 commentDao.updateComment(comment);
	//	browseComment(6,1);
		
	}




}
