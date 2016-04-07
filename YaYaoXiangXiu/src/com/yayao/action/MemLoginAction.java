package com.yayao.action;

import java.io.IOException;
import java.util.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;















import com.yayao.bean.ExclusiveCustom;
import com.yayao.bean.Member;
import com.yayao.bean.Merchandise;
import com.yayao.service.CartService;
import com.yayao.service.CommentService;
import com.yayao.service.ConsigneeService;
import com.yayao.service.ExclusiveCustomService;
import com.yayao.service.MemService;
import com.yayao.service.MerService;
import com.yayao.service.OrderService;
import com.yayao.util.ActionContextUtil;
import com.yayao.util.BaseAction;
import com.yayao.util.SHAutil;
/**
 * 账户登录
 * @author yy
 *
 */
@Scope("prototype")
@Controller("memLogin")
public class MemLoginAction extends BaseAction {
	
	@Autowired
	@Qualifier("merService")
	private MerService merService;
	@Autowired
	@Qualifier("memService")
	private MemService memService;
	@Autowired
	@Qualifier("consigneeService")
	private ConsigneeService consigneeService;
	@Autowired
	@Qualifier("commentService")
	private CommentService commentService;
	@Autowired
	@Qualifier("exclusiveCustomService")
	private ExclusiveCustomService exclusiveCustomService;
	@Autowired
	@Qualifier("cartService")
	private CartService cartService;
	@Autowired
	@Qualifier("orderService")
	private OrderService orderService;
	private String loginName;//注册账号
	private String loginPwd;//注册密码
	private String validate;	//验证码
	
	

	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getValidate() {
		return validate;
	}
	public void setValidate(String validate) {
		this.validate = validate;
	}
	/**
	 * 用户登录
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		Map session = ActionContextUtil.getSession();
		
		String shalp = SHAutil.getSHA(loginPwd);
		boolean state= memService.chkLoginName(loginName);
		//Map application = ActionContextUtil.getApplication();
		//Member sm = (Member) session.get("Member");
		//List list = (ArrayList) application.get("appMember");
		//session.clear();
		if(state){
			// list.add(m);
			
			//application.put("appMember",list);
			
		//OnlineStatistics.getOnlineMemberList().contains(sm)防止重复登录
//		else if(OnlineStatistics.getOnlineMemberList().contains(m)){		
//					
//			return "index";
//		}
			Member m = memService.memLogin(loginName, shalp);
			if(m!=null){
				session.put("Member", m);
				
				//浏览初始化
				Member member = (Member)session.get("Member");
				consigneeService.browseConsignee(m);
				exclusiveCustomService.browseExclusiveCustom(member);
				//merService.browseCategory();
				cartService.browseCart(m);
				orderService.browseOrderMer(member);
			    commentService.browseMemCustomComment(member);
				commentService.browseMemMerComment(member);
				//commentService.browseComment(6,1);
				return "success";
			}
		
		
		 } 
		this.addFieldError("loginerror","※账户或密码错误！");
		return "input";
		
		}
	//验证是否登录
	@SkipValidation
     public String isLogin() throws Exception{
    	 Map session = ActionContextUtil.getSession();
    	 Member mem = (Member)session.get("Member");
    	 if(mem!=null&&!mem.equals("")){
    		//第一种方法 data
    		 //String name = member.getLoginName();
    		 //ActionContextUtil.getResponse().getWriter().write(name);
    		 
    		//第二种方法  页面获取 json类型 data.loginName
    		/* Map m=new HashMap();
    		 m.put("loginName",member.getLoginName());
    		 m.put("loginPwd",member.getLoginPwd());
    		 JSONArray mm = JSONArray.fromObject(m);
    		 */
    		 //第三种方法 页面获取text类型 JSON.parse(data)[0].loginName
    		 /*Member m=new Member();
    		 m.setLoginName(member.getLoginName());
    		 m.setLoginPwd(member.getLoginPwd());
    		 
    		 JSONObject mm = JSONObject.fromObject(m);
    		  JSONArray ma=JSONArray.fromObject(mm);*/
    		 //第四种方法
    		 Member m=new Member();
    		 m.setLoginName(mem.getLoginName());
    		 m.setLoginPwd(mem.getLoginPwd());
    		 
    		 JSONObject me = JSONObject.fromObject(m);
    		// JSONArray ma=JSONArray.fromObject(mm);
    		 ActionContextUtil.getResponse().setCharacterEncoding("UTF-8");
    		 ActionContextUtil.getResponse().getWriter().write(me.toString());
    	     return null;
    	 }else{
    		 //提供自动永久登录功能
    		 String ln=ActionContextUtil.getRequest().getParameter("ln");
    			String lp=ActionContextUtil.getRequest().getParameter("lp");
    			if(ln!=null&&!ln.equals("")&&lp!=null&&!lp.equals("")){
    				boolean s= memService.chkLoginName(ln);
    				if(s){
    					Member mm = memService.memLogin(ln, lp);
    					if(mm!=null){
    						session.put("Member", mm);
    						
    						//浏览初始化
    						Member m= (Member)session.get("Member");
    						consigneeService.browseConsignee(m);
    						exclusiveCustomService.browseExclusiveCustom(m);
    						//merService.browseCategory();
    						cartService.browseCart(m);
    						orderService.browseOrderMer(m);
    					    commentService.browseMemCustomComment(m);
    						commentService.browseMemMerComment(m);
    						//commentService.browseComment(6,1);
    						return "success";
    					}
    				}
    				
    			}
    		 return null;
    	 }
    	 
     }
	//验证码
	public void validate() {
		Map session = ActionContextUtil.getSession();
		if(!session.get("random").equals(validate)) {
			this.addFieldError("validate", "※验证码错误！");
		}
	}
}