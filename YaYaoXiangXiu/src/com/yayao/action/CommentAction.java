package com.yayao.action;

import java.io.PrintWriter;
import java.io.WriteAbortedException;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.metal.MetalBorders.Flush3DBorder;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;


import com.yayao.bean.Cartselectedmer;
import com.yayao.bean.Comment;
import com.yayao.bean.ExclusiveCustom;
import com.yayao.bean.Member;
import com.yayao.bean.Merchandise;
import com.yayao.service.CartService;
import com.yayao.service.CommentService;
import com.yayao.service.ConsigneeService;
import com.yayao.service.ExclusiveCustomService;
import com.yayao.service.MemService;
import com.yayao.service.MerService;
import com.yayao.util.ActionContextUtil;
import com.yayao.util.BaseAction;
import com.yayao.util.DateUtil;
import com.yayao.util.OnlineStatistics;
import com.yayao.util.SHAutil;
/**
 * 普通订单评价类
 * @author yy
 *
 */
@Scope("prototype")
@Controller("comment")
public class CommentAction extends BaseAction {

	@Autowired
	@Qualifier("commentService")
	private CommentService commentService;
	
	private String radioComment;//评价选项，红、黄、绿花
	private String contentComment;//评价内容
	
	
	public String getRadioComment() {
		return radioComment;
	}

	public void setRadioComment(String radioComment) {
		this.radioComment = radioComment;
	}

	public String getContentComment() {
		return contentComment;
	}

	public void setContentComment(String contentComment) {
		this.contentComment = contentComment;
	}

	/**
	 * 增加产品评价
	 * 概念：对订单评价，就是对订单中的每一行选购商品评价，当选购商品删除（订单完成删除、取消删除）
	 * 评价应该还存在，则应该让评价类直接与商品类绑定。
	 * @return
	 * @throws Exception
	 */
	public String addOrdersComment() throws Exception {
		
		Map session = ActionContextUtil.getSession();
		Member member = (Member)session.get("Member");
		
		//获取索引
		String commentIndex = ActionContextUtil.getRequest().getParameter("commentIndex");
		Integer ci = new Integer(commentIndex);
		if(member!=null){
			List cartselectedmerlists=(List) session.get("orderMerList");
			for (int i = 0; i < cartselectedmerlists.size(); i++) {
				Cartselectedmer cartselectedmer=(Cartselectedmer)cartselectedmerlists.get(i);
				if(cartselectedmer.getId().equals(ci)){
					Merchandise mer = cartselectedmer.getMerchandise();
					
					Comment comment=new Comment();
					comment.setCommentDate(DateUtil.getCurrentTime());
					comment.setContent(contentComment);
					comment.setMerchandise(mer);//把评价指定给当前商品，相当于当前订单评价
					comment.setMember(member);
					comment.setTitle(radioComment);
					commentService.addComment(comment);
					commentService.browseMemMerComment(member);
					return "success";
					}
				}
			}
		return "input";
		}
	/**
	 * 删除当前人的订单产品评价
	 * @return
	 * @throws Exception
	 */
	public String delOrdersComment() throws Exception {
		
		Map session = ActionContextUtil.getSession();
		Member member = (Member)session.get("Member");
		
		//获取索引
		String delCommentIndex = ActionContextUtil.getRequest().getParameter("delCommentIndex");
		Integer di = new Integer(delCommentIndex);
		if(member!=null){
			List list=commentService.browseMemMerComment(member);
			for (int i = 0; i < list.size(); i++) {
				Comment com=(Comment)list.get(i);
				if(com.getId().equals(di)){
					commentService.delComment(com.getId());
					commentService.browseMemMerComment(member);
					return "success";
				}
			}
		}
		return "input";
	}
	
	/**
	 * 当前商品的产品评价分页显示
	 * 1.点击“首页”
	 * 2.点击“上一页”
	 * 3.点击其他所有页面
	 * 4.点击“下一页”
	 * 5.点击“末页”
	 * @return
	 * @throws Exception
	 */
	public String browseClickComment() throws Exception {
		Map session = ActionContextUtil.getSession();
		Merchandise EBMer = (Merchandise) session.get("EBMer");
		int pageNo=(Integer) session.get("pageNo");
		int toPageNo=1;
		
		//获取索引
		String tpn = ActionContextUtil.getRequest().getParameter("tpn");
		//ActionContextUtil.getResponse().setCharacterEncoding("utf-8");
		//ActionContextUtil.getResponse().getWriter().write(tpn);
		//return null;
		if(tpn.equals("首页")){
			commentService.browseComment(10,toPageNo, EBMer);
			return null;
		}else if(tpn.equals("末页")){
			toPageNo = (Integer) session.get("totalPages");
			commentService.browseComment(10,toPageNo, EBMer);
			return null;
		}else if(tpn.equals("上一页")){
			toPageNo=pageNo-1;
			commentService.browseComment(10,toPageNo, EBMer);
			return null;
		}else if(tpn.equals("下一页")){
			toPageNo=pageNo+1;
			commentService.browseComment(10,toPageNo, EBMer);
			return null;
		}else{	
		 toPageNo = new Integer(tpn);
		 commentService.browseComment(10,toPageNo, EBMer);
		//ActionContextUtil.getResponse().setCharacterEncoding("utf-8");
		//ActionContextUtil.getResponse().getWriter().write(tpn);
		 return null;
		}
	}
	
	
} 
