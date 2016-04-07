package com.yayao.action;

import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
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
import com.yayao.bean.Member;
import com.yayao.bean.Merchandise;
import com.yayao.service.CommentService;
import com.yayao.service.MemService;
import com.yayao.service.MerService;
import com.yayao.util.ActionContextUtil;
import com.yayao.util.BaseAction;
import com.yayao.util.DateUtil;
import com.yayao.util.OnlineStatistics;
import com.yayao.util.SHAutil;
/**
 * 会员账户评论
 * @author yy
 *
 */
@Scope("prototype")
@Controller("memComment")
public class MemCommentAction extends BaseAction {
	
	@Autowired
	@Qualifier("commentService")
	private CommentService commentService;
	@Autowired
	@Qualifier("merService")
	private MerService merService;
	private String title;//评论主题
	private String content;//评论内容
	
	
	/**
	 * 增加评论
	 * @return
	 * @throws Exception
	 */
	public String addComment() throws Exception{
		List list=new ArrayList();
		Map session=ActionContextUtil.getSession();
		HttpServletRequest request = ActionContextUtil.getRequest();
		
		int pageNo=1;//页号
		int pageSize=6;//每页记录数
		int taotals=0;//记录总数
		int tatalPages=0;//总页数
		
		if(request.getParameter("pageNo")!=null){
			pageNo=Integer.parseInt(request.getParameter("pageNo"));
			//判断会员是否已成功登录
			Member mem=(Member)session.get("Member");
			if(mem!=null){
				boolean status=false;
				Comment comment=new Comment();
				comment.setMember(mem);
				comment.setTitle(title);
				comment.setContent(content);
				comment.setCommentDate(DateUtil.getCurrentTime());
				 String merid = request.getParameter("merid");
				 Integer mid=new Integer(merid);
				Merchandise merchandise = merService.loadMer(mid);
				comment.setMerchandise(merchandise);
				commentService.addComment(comment);
				return "success";
			}
		}
			
		return "input";
	}
	
	
}