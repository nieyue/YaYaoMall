package com.yayao.action;

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


import com.yayao.bean.Comment;
import com.yayao.bean.ExclusiveCustom;
import com.yayao.bean.Member;
import com.yayao.service.CommentService;
import com.yayao.service.ConsigneeService;
import com.yayao.service.ExclusiveCustomService;
import com.yayao.service.MemService;
import com.yayao.util.ActionContextUtil;
import com.yayao.util.BaseAction;
import com.yayao.util.DateUtil;
import com.yayao.util.OnlineStatistics;
import com.yayao.util.SHAutil;
/**
 * 定制评价类
 * @author yy
 *
 */
@Scope("prototype")
@Controller("customComment")
public class CustomCommentAction extends BaseAction {

	@Autowired
	@Qualifier("commentService")
	private CommentService commentService;
	@Autowired
	@Qualifier("exclusiveCustomService")
	private ExclusiveCustomService exclusiveCustomService;
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
	 * 增加定制产品评价
	 * @return
	 * @throws Exception
	 */
	public String addExclusiveCustomComment() throws Exception {
		
		Map session = ActionContextUtil.getSession();
		Member member = (Member)session.get("Member");
		
		//获取索引
		String customCommentIndex = ActionContextUtil.getRequest().getParameter("customCommentIndex");
		Integer cci = new Integer(customCommentIndex);
		if(member!=null&&customCommentIndex!=null){
			List list=exclusiveCustomService.browseExclusiveCustom(member);
			for (int i = 0; i < list.size(); i++) {
				ExclusiveCustom e=(ExclusiveCustom)list.get(i);
				if(e.getId().equals(cci)){
					Comment comment=new Comment();
					comment.setCommentDate(DateUtil.getCurrentTime());
					comment.setContent(contentComment);
					comment.setExclusiveCustom(e);
					comment.setMember(member);
					comment.setTitle(radioComment);
					commentService.addComment(comment);
					commentService.browseMemCustomComment(member);
					return "success";
					}
				}
			}
		return "input";
		}
	/**
	 * 删除定制产品评价
	 * @return
	 * @throws Exception
	 */
	public String delExclusiveCustomComment() throws Exception {
		
		Map session = ActionContextUtil.getSession();
		Member member = (Member)session.get("Member");
		
		//获取索引
		String delCustomCommentIndex = ActionContextUtil.getRequest().getParameter("delCustomCommentIndex");
		Integer dci = new Integer(delCustomCommentIndex);
		if(member!=null&&delCustomCommentIndex!=null){
			List list=commentService.browseMemCustomComment(member);
			for (int i = 0; i < list.size(); i++) {
				Comment com=(Comment)list.get(i);
				if(com.getId().equals(dci)){
					commentService.delComment(com.getId());
					commentService.browseMemCustomComment(member);
					return "success";
				}
			}
		}
		return "input";
	}
	} 
