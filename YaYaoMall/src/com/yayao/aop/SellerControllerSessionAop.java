package com.yayao.aop;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;

import com.yayao.bean.Seller;
import com.yayao.util.StatusCode;

//@Component
//@Aspect
public class SellerControllerSessionAop {
	//@Pointcut("execution(* com.yayao.controller..*.*(..))" )
	public void pointCut() {
	}
	//@Around("pointCut()")
	public Object sellerValid(ProceedingJoinPoint jp) throws Throwable{
		Object[] args=jp.getArgs();
		Integer sellerid=0;
		HttpSession session = null;
		for (int i = 0; i < args.length; i++) {
			if(args != null && args.length > 0 && args[i].getClass() == Integer.class){
				sellerid=(Integer) args[i];
			}
			if(args != null && args.length > 0 && args[i].getClass() == HttpSession.class){
				session=(HttpSession) args[i];
			}
		}
		if(session.getAttribute("seller")==null||!(((Seller)session.getAttribute("seller")).getSellerid().equals(sellerid))){
			return StatusCode.GetValueByKey(StatusCode.SESSION_EXPIRED);
		}
		return jp.proceed(args);
	}
}
