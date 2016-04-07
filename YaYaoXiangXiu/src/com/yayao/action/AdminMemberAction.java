package com.yayao.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;






import com.yayao.bean.Admin;
import com.yayao.bean.Comment;
import com.yayao.bean.Member;
import com.yayao.service.CommentService;
import com.yayao.service.ConsigneeService;
import com.yayao.service.ExclusiveCustomService;
import com.yayao.service.MemService;
import com.yayao.service.OrderService;
import com.yayao.util.ActionContextUtil;
import com.yayao.util.BaseAction;
import com.yayao.util.DateUtil;
import com.yayao.util.SHAutil;

import freemarker.core.ArithmeticEngine.ConservativeEngine;


/**
 * 会员的增加、删除，查询以及会员评论的查询回复
 * @author yy
 *
 */
@Scope("prototype")
@Controller("adminMember")
public class AdminMemberAction extends BaseAction{
	@Autowired
	@Qualifier("memService")
	private MemService memService;
	@Autowired
	@Qualifier("commentService")
	private CommentService commentService;
	@Autowired
	@Qualifier("consigneeService")
	private ConsigneeService consigneeService;
	@Autowired
	@Qualifier("orderService")
	private OrderService orderService;
	@Autowired
	@Qualifier("exclusiveCustomService")
	private ExclusiveCustomService exclusiveCustomService;
	
	
	
	private String ht_memberName;//会员名字
	private String ht_loginName;//会员账户
	private String ht_loginPwd;//会员密码
	private String ht_email;//会员电子邮件
	private String ht_sex;
	//private String answerContent;//管理员评论会员留言
	
	
	public String getHt_memberName() {
		return ht_memberName;
	}
	
	public String getHt_sex() {
		return ht_sex;
	}

	public void setHt_sex(String ht_sex) {
		this.ht_sex = ht_sex;
	}

	public String getHt_loginName() {
		return ht_loginName;
	}
	public void setHt_loginName(String ht_loginName) {
		this.ht_loginName = ht_loginName;
	}
	public String getHt_loginPwd() {
		return ht_loginPwd;
	}
	public void setHt_loginPwd(String ht_loginPwd) {
		this.ht_loginPwd = ht_loginPwd;
	}
	public void setHt_memberName(String ht_memberName) {
		this.ht_memberName = ht_memberName;
	}
	public String getHt_email() {
		return ht_email;
	}
	public void setHt_email(String ht_email) {
		this.ht_email = ht_email;
	}
	/*public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}*/
	
	
	/**
	 * 管理员添加会员
	 * @return
	 * @throws Exception
	 */
	public String ht_addMem() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		if(ht_loginPwd==null||ht_loginPwd.equals("")||ht_loginName==null||ht_loginName.equals("")
				||ht_email==null||ht_email.equals("")){
			this.addFieldError("ht_addMemError", "※添加失败，请检查输入是否有误！");
			return "input";
		}
		boolean status=memService.chkLoginName(ht_loginName);
		if(!status&&a.getAdminType().equals(2)){
		String ht_lp = SHAutil.getSHA(ht_loginPwd);
		Member mem=new Member();
		mem.setLoginName(ht_loginName);
		mem.setMemberName(ht_memberName);;
		mem.setLoginPwd(ht_lp);
		mem.setEmail(ht_email);
		mem.setSex(ht_sex);
			
		memService.addMember(mem);
		memService.adminBrowseMember();
		return "success";
		}else{
			this.addFieldError("ht_addMemError", "※用户已经存在，请您重新添加！");
			return "input";
		}
	}
	/**
	 * 指定删除会员
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	public String ht_delMem() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		//获取索引
		String hln = ActionContextUtil.getRequest().getParameter("hln");
		
		if(a!=null&&a.getAdminType()==2){
			List list=memService.adminBrowseMember();
			for (int i = 0; i < list.size(); i++) {
				Member member=(Member)list.get(i);
				if(member.getLoginName().equals(hln)){
					memService.delMember(member.getId());
					memService.adminBrowseMember();
					return "success";
				}
			}
		}
		return "input";
	}
	/**
	 * 批量删除会员
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	public String ht_delAllMem() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		Integer mdiid=null;
		//获取索引
		String memDelIndexs = ActionContextUtil.getRequest().getParameter("delIndexs");
		if(memDelIndexs!=null&&!memDelIndexs.equals("")){
			
		String[] mdi=memDelIndexs.split(",");
		for (int i = 0; i < mdi.length; i++) {
			mdiid=new Integer(mdi[i]);
		if(a!=null&&a.getAdminType().equals(2)){
		
					memService.delMember(mdiid);
				}
			}
		}
		memService.adminBrowseMember();
		
		return null;
	}
	
	/**
	 * 会员详细查询（浏览单个）
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	public String ht_showMem() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		//获取索引
		String memID = ActionContextUtil.getRequest().getParameter("memID");
		Integer mi=new Integer(memID);
		if(a!=null&&a.getAdminType().equals(2)){
			Member m = memService.loadMember(mi);
			session.put("ht_Member", m);
			//浏览收货地址
			consigneeService.adminBrowseConsignee(m);
			//浏览订单的选购商品
			orderService.adminBrowseOrderMer(m);
			//浏览定制订单
			exclusiveCustomService.adminBrowseExclusiveCustom(m);
			//定制订单评价浏览
			commentService.adminBrowseMemCustomComment(m);
			//普通订单评价
			commentService.adminBrowseMemMerComment(m);
			return "success";	
		}
		return "input";
	}
	
	/**
	 * 模糊查询会员（一个或多个）
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	public String ht_searchMem() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		//获取索引
		String sc = ActionContextUtil.getRequest().getParameter("sc");
		if(a!=null&&a.getAdminType().equals(2)){
			List list =  memService.searchMem("from Member where loginName like '%"+sc+"%'");
			ActionContextUtil.getSession().remove("aMemList");
			ActionContextUtil.getSession().put("aMemList", list);
			if(list==null||list.equals("")||list.isEmpty()){
				
			ActionContextUtil.getResponse().setCharacterEncoding("UTF-8");
			ActionContextUtil.getResponse().getWriter().write("没有该类账户！");;
			}
			
		}
		return null;	
		
	}
	/**
	 * 查询所有会员
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	public String ht_searchAllMem() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		if(a!=null&&a.getAdminType().equals(2)){
			List list =  memService.adminBrowseMember();
		}
		return null;	
		
	}
	
	/**
	 * 更改会员
	 * @return
	 * @throws Exception
	 */
	public String ht_modifyMem() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		//获取索引
		String mmm = ActionContextUtil.getRequest().getParameter("mmm");
		if(ht_loginPwd==null||ht_loginPwd.equals("")||ht_loginName==null||ht_loginName.equals("")){
			this.addFieldError("ht_addMemError", "※添加失败，请检查输入是否有误！");
			return "input";
		}
		if(a!=null&&a.getAdminType().equals(2)){
			List list=memService.adminBrowseMember();
			for (int i = 0; i < list.size(); i++) {
				Member mem=(Member)list.get(i);
				if(mem.getLoginName().trim().equals(mmm.trim())){
				
					mem.setMemberName(ht_memberName);
				
					mem.setLoginName(ht_loginName);
					String ht_lp = SHAutil.getSHA(ht_loginPwd);
					mem.setLoginPwd(ht_lp);
					mem.setEmail(ht_email);
				
					mem.setSex(ht_sex.trim());
					memService.updateMember(mem);
					memService.adminBrowseMember();
					return "success";
				}
			}
		}
		return "input";
	}
	
	/**
	 * 装载会员留言（浏览单个）
	 * @return
	 * @throws Exception
	 */
	public String ht_loadComment() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		//获取索引
		String loadCommentIndex = ActionContextUtil.getRequest().getParameter("loadCommentIndex");
		Integer lci=new Integer(loadCommentIndex);
		if(a!=null&&a.getAdminType()==2){
			commentService.loadComment(lci);
			return "success";	
		}
		return "input";
	}
	/**
	 * 删除会员留言
	 * @return
	 * @throws Exception
	 */
	public String ht_delComment() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		//获取索引
		String delCommentIndex = ActionContextUtil.getRequest().getParameter("delCommentIndex");
		Integer dci=new Integer(delCommentIndex);
		if(a!=null&&a.getAdminType()==2){
			commentService.delComment(dci);
			return "success";	
		}
		return "input";
	}
	/**
	 * 回复会员留言（回复单个）
	 * @return
	 * @throws Exception
	 */
	public String ht_answerComment() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		//获取索引
		String answerCommentIndex = ActionContextUtil.getRequest().getParameter("answerCommentIndex");
		Integer aci=new Integer(answerCommentIndex);
		if(a!=null&&a.getAdminType()==2){
			Comment comment=commentService.loadComment(aci);
			comment.setAdmin(a);
			//comment.setAnswerContent(comment.getAnswerContent()+" "+ answerContent);
			comment.setAnswerDate(DateUtil.getCurrentTime());
			commentService.updateComment(comment);
			return "success";	
		}
		return "input";
	}
	
}