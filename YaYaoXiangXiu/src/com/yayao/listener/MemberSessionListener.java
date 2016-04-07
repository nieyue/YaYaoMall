package com.yayao.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.yayao.bean.Member;
import com.yayao.util.OnlineStatistics;

/**
 * 实现在线账户监听
 * @author yy
 *
 */
public class MemberSessionListener implements HttpSessionAttributeListener,HttpSessionListener {

    /** 
     * 创建session 
     */  
    public void sessionCreated(HttpSessionEvent se) {  
        OnlineStatistics.increase(); 
        
    }  
  
    /** 
     * 服务器销毁session对象 
     */  
    public void sessionDestroyed(HttpSessionEvent se) {  
        OnlineStatistics.decrease();  
    }  
  
    /** 
     * 用户登录时 
     */  
    public void attributeAdded(HttpSessionBindingEvent se) {  
        if ("Member".equals(se.getName())) {  
            Member member= (Member) se.getValue();  
            OnlineStatistics.addAttr(member);  
          //  se.getSession().setMaxInactiveInterval(60 * 20);// 失效时间SEC * MINS  
        }  
    }  
  
    /** 
     * 用户退出登录(销毁session属性时) 
     */  
    public void attributeRemoved(HttpSessionBindingEvent se) {  
        if ("Member".equals(se.getName())) {  
            Member member = (Member) se.getValue();  
            OnlineStatistics.removeAttr(member);  
            member = null;  
        }  
    }  
  
    /** 
     * session属性被重新设置时
     */  
    public void attributeReplaced(HttpSessionBindingEvent se) {  
//    	if ("Member".equals(se.getName())) {  
//           Member = (Member) se.getSession().getAttribute("Member");  
//            OnlineStatistics.addAttr(member);  
            
//    }  

    }
}
