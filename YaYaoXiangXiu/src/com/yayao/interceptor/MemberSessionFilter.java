package com.yayao.interceptor;

import java.util.Map;

import org.aopalliance.intercept.Invocation;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.yayao.action.MemLoginAction;
import com.yayao.bean.Member;
import com.yayao.service.MemService;
import com.yayao.util.OnlineStatistics;
/**
 * 
 *实现账户重复登陆退出
 * @author yy
 *
 */
public class MemberSessionFilter extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ac=invocation.getInvocationContext();
		Map session= ac.getSession();
		Member m=(Member) session.get("Member");
		if(m!=null&&m.getLoginName()!=null&&m.getLoginPwd()!=null&&OnlineStatistics.isOld(m)){
				session.remove("Member");//清除session
				String faragoMessage="对不起，您的帐号[" + m.getLoginName() 
				+ "]已在别的地方登录，您已被迫退出。若有疑问请联系管理员，谢谢！";
				ac.put("faragoMessage", faragoMessage);
				
				return "index";
			}
		return invocation.invoke();
		
	}


}
