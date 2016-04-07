package com.yayao.dao.impl;

import java.util.*;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.yayao.bean.*;
import com.yayao.dao.CommentDao;
import com.yayao.util.*;
@Repository("commentDao")
public class CommentDaoImpl extends BaseLog implements CommentDao {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
		//return sessionFactory.openSession();
		
	}
	/** 新增留言 */
	public void addComment(Comment comment) {
			getSession().save(comment);
		
	}

	/**  分页浏览所有留言*/
	public List browseComment(int pageSize,int pageNo) {
		
		List list = null;
			Query query = getSession().createQuery("from Comment as c order by c.id desc");
			query.setMaxResults(pageSize);
			query.setFirstResult((pageNo-1)*pageSize);
			list = query.list();
		return list;
	}

	/**
	 * 分页浏览所有当前的商品的留言
	 */
	public List browseComment(int pageSize, int pageNo, Merchandise merchandise)
			{
		List list = null;
			Query query = getSession().createQuery("from Comment as c where merchandise=:merchandise order by c.id desc");
			query.setEntity("merchandise", merchandise);
			query.setMaxResults(pageSize);
			query.setFirstResult((pageNo-1)*pageSize);
			list = query.list();
		return list;
	}

	/** 
	 * 浏览所有留言
	 * 
	 */
	public List browseComment() {
		List list = null;
			Query query = getSession().createQuery("from Comment as c order by c.id desc");
			list = query.list();
		return list;
	}

	/** 统计留言条数 */
	public int countComment() {
		int count = 0;
			Query query = getSession().createQuery("select count(*) from Comment as c");
			query.setMaxResults(1);
			count = Integer.parseInt(query.uniqueResult().toString());
		return count;
	}

	/**
	 * 统计当前商品的留言条数
	 */
	public int countComment(Merchandise merchandise){
		int count = 0;
			Query query = getSession().createQuery("select count(*) from Comment as c where c.merchandise=:merchandise");
			query.setEntity("merchandise", merchandise);
			query.setMaxResults(1);
			count = Integer.parseInt(query.uniqueResult().toString());
		return count;
	}
	
	/** 装载留言 */	
	public Comment loadComment(Integer id) {
		
		Comment comment = null;
			comment = (Comment)getSession().get(Comment.class, id);
	return comment;
	}

	/** 删除留言 */	
	public void delComment(Integer id) {
			Query q=getSession().createQuery(" delete from Comment as c  where c.id=:id ");
			q.setInteger("id", id);
			q.executeUpdate();
	}

	/** 回复留言 */	
	public void updateComment(Comment comment) {
			getSession().update(comment);
		/*Query hql= getSession().createQuery("update Comment c"
					+ " set c.admin=?, "
					+ " c.member=?, "
					+ " c.merchandise=?, "
					+ " c.exclusiveCustom=?, "
					+ " c.title=?, "
					+ " c.content=?, "
					+ " c.commentDate=?, "
					+ " c.answerContent=?, "
					+ " c.answerDate=? "
					+ " where a.id=? ");
			hql.setEntity(0, comment.getAdmin());
			hql.setEntity(1, comment.getMember());
			hql.setEntity(2, comment.getMerchandise());
			hql.setEntity(3, comment.getExclusiveCustom());
			hql.setString(4, comment.getTitle());
			hql.setString(5, comment.getContent());
			hql.setString(6, comment.getCommentDate());
			hql.setString(7, comment.getAnswerContent());
			hql.setString(8, comment.getAnswerDate());
			hql.setInteger(9, comment.getId());
			hql.executeUpdate();*/
			
	}

}
