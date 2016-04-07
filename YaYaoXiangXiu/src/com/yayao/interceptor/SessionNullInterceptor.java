package com.yayao.interceptor;

import java.util.Map;












import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.yayao.action.AdminLoginAction;
import com.yayao.action.CommentAction;
import com.yayao.action.MemLoginAction;
import com.yayao.action.MemLogoutAction;
import com.yayao.action.MemRegAction;
import com.yayao.action.MerchandiseAction;
import com.yayao.action.RetrieveAccountLoginAction;
import com.yayao.bean.Admin;
import com.yayao.bean.Member;
import com.yayao.yanzhengma.ImageAction;
/**
 * 
 * 实现账户没登陆不能访问特定页面
 * @author yy
 *
 */
public class SessionNullInterceptor extends AbstractInterceptor {


	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Object action = invocation.getAction();
		ActionContext ac=invocation.getInvocationContext();
		Map session= ac.getSession();
		Member m=(Member) session.get("Member");
		Admin a=(Admin)session.get("Admin");
		//对登陆、退出、注册、商品购买展示、分页查询、账户找回不做拦截
		if((action instanceof MemLoginAction)||(action instanceof ImageAction)
				||(action instanceof AdminLoginAction)||(action instanceof MemRegAction)
				||(action instanceof MemLogoutAction)||(action instanceof MerchandiseAction)
				||(m!=null&&m.getLoginName()!=null)||(a!=null&&a.getLoginName()!=null)
				||(action instanceof CommentAction)||(action instanceof RetrieveAccountLoginAction)){
		
			return invocation.invoke();
		}
		else{
			ac.put("nologinerror", "对不起，您还没登陆！");
		    return "login";
		}
	}

}
