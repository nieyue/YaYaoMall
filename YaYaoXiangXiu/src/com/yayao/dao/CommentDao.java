package com.yayao.dao;

import com.yayao.bean.*;
import java.util.*;

public interface CommentDao {
	/** 新增留言 */	
	public void addComment(Comment comment) ;
	/** 分页浏览所有留言 */
	public List browseComment(int pageSize,int pageNo) ;
	/** 分页浏览当前商品的所有留言 */
	public List browseComment(int pageSize,int pageNo,Merchandise merchandise);
	/** 浏览所有留言 */
	public List browseComment();
	/** 统计留言条数 */
	public int countComment();	
	/** 统计当前商品的留言条数 */
	public int countComment(Merchandise merchandise) ;	
	/** 删除留言 */	
	public void delComment(Integer id) ;	
	/** 装载留言 */	
	public Comment loadComment(Integer id) ;
	/** 回复留言 */	
	public void updateComment(Comment comment) ;
}
