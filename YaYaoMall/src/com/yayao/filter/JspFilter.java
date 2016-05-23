package com.yayao.filter;

import java.io.File;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 过滤请求实现rest风格
 * @author yy
 *
 */
public class JspFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		 // 获得在下面代码中要用的request,response
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        //实现跨域
        servletResponse.setHeader("Access-Control-Allow-Origin", "*");
        servletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        servletResponse.setHeader("Access-Control-Max-Age", "3600");
        servletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        //chain.doFilter(request, response);
        // 获得用户请求的http://localhost:8080/YaYaoMall/mall/mobile/index
        // 获得用户请求的http://localhost:8080/mall/mobile/indexp
        String rpath = servletRequest.getRequestURI(); 						// /YaYaoMall/mall/mobile/index /mall/mobile/index 
        String path=servletRequest.getServletPath();						// /mall/mobile/index           /mall/mobile/index
        String cpath = servletRequest.getContextPath(); 					// /YaYaoMall  					空 
        String strBackUrl=servletRequest.getRealPath("/");					// D:\nieyue\tomcat\apache-tomcat-7.0.57-windows-x64\apache-tomcat-7.0.57\webapps\YaYaoMall\ 
        String strServletUrl=servletRequest.getServletContext().getRealPath("");// D:\nieyue\tomcat\apache-tomcat-7.0.57-windows-x64\apache-tomcat-7.0.57\webapps\YaYaoMall 
        String urlpath=servletRequest.getPathInfo();						// null    						null
        String urlpath1=servletRequest.getLocalAddr();						// 127.0.0.1					127.0.0.1
        String urlpath2=servletRequest.getPathTranslated();					//  null 						null
        String urlpath3=servletRequest.getRemoteAddr();						//  127.0.0.1   				127.0.0.1
        StringBuffer urlpath4=servletRequest.getRequestURL();				//http://localhost:8080/YaYaoMall/mall/mobile/index  http://localhost:8080/mall/mobile/index
        String urlpath5=servletRequest.getProtocol();						// HTTP/1.1 					HTTP/1.1
        String urlpath6=servletRequest.getQueryString();					//  null  						null
        ServletContext urlpath7=servletRequest.getServletContext();			//org.apache.catalina.core.ApplicationContextFacade@2d849d56  org.apache.catalina.core.ApplicationContextFacade@3ddd82fa
        String urlpath8=servletRequest.getServletContext().getContextPath();///YaYaoMall   					空
        /*if(path.indexOf("resources")>-1){
		if(!path.startsWith("/resources")){
			path=path.substring(path.indexOf("/resources"));
		}
		servletRequest.getRequestDispatcher(path).forward(request, response);
	}else if (path.indexOf("resources")==-1&&(path.indexOf(".")>-1)){
			if(path.indexOf(".ico")!=-1){
					chain.doFilter(request, response);
			}else if(path.indexOf(".txt")!=-1||path.indexOf(".json")!=-1||path.indexOf(".xml")!=-1||path.indexOf(".pdf")!=-1||path.indexOf(".xls")!=-1){
					servletRequest.getRequestDispatcher(path).forward(request, response);
		 
			}else{
				//对请求过滤
				servletRequest.getRequestDispatcher("/404.html").forward(request, response);
				//servletResponse.sendRedirect(servletRequest.getContextPath()+"/404.html");
			}DefaultServletHttpRequestHandler
	}else {	*/
        if(rpath.startsWith("/resources")&&new File(strServletUrl+rpath).exists()){
			servletRequest.getRequestDispatcher(rpath).forward(request, response);
		}else if(new File(strServletUrl+rpath+".html").exists()){
				servletRequest.getRequestDispatcher(rpath+".html").forward(request,response);
		}else if(path.equals("/")){//综合门户
				servletRequest.getRequestDispatcher(cpath+"/seller/index.html").forward(request, response);
				//servletRequest.getRequestDispatcher("/mall/mobile/index.html").forward(request, response);
			}else if(path.equals("/admin/")||path.equals("/admin")){
				servletRequest.getRequestDispatcher("/admin/index.html").forward(request, response);
			}else if(path.equals("/seller/")||path.equals("/seller")){
				servletRequest.getRequestDispatcher("/seller/index.html").forward(request, response);
			}else{
				chain.doFilter(request, response);
			}
	//}
		
}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	

}
