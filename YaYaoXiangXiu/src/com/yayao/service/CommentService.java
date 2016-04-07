package com.yayao.service;

import com.yayao.bean.*;

import java.util.*;

public interface CommentService {
	/** 新增留言 */	
	public void addComment(Comment comment);
	/** 分页浏览所有留言 */
	public List browseComment(int pageSize,int pageNo) ;
	/** 分页浏览当前商品的所有留言 */
	public List browseComment(int pageSize,int pageNo,Merchandise merchandise) ;
	/** 浏览当前人的定制订单留言 */
	public List browseMemCustomComment(Member member) ;
	/** 管理员浏览当前人的定制订单留言 */
	public List adminBrowseMemCustomComment(Member member) ;
	/** 浏览当前人的订单留言 */
	public List browseMemMerComment(Member member);
	/** 管理员浏览当前人的订单留言 */
	public List adminBrowseMemMerComment(Member member) ;
	/** 浏览每个商品所有留言 */
	public List browseMerComment(Merchandise merchandise);
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
