package com.yayao.filter;

import java.io.File;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
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
        // 获得用户请求的http://localhost:8080/YaYaoMall/main/list.jsp
        //String rpath = servletRequest.getRequestURI(); // /YaYaoMall/main/list.jsp 
        String path=servletRequest.getServletPath();// /main/list.jsp 
        //String cpath = servletRequest.getContextPath();// /YaYaoMall 
        String strBackUrl=servletRequest.getRealPath("/");// F:\Tomcat 6.0\webapps\YaYaoMall\test 
	if (path.indexOf("resources")==-1&&(path.indexOf(".")>-1||path.indexOf("\\")>-1)){
	if(path.indexOf(".ico")!=-1){
		chain.doFilter(request, response);
	}else if(path.indexOf(".txt")!=-1||path.indexOf(".json")!=-1){
		 servletRequest.getRequestDispatcher(path).forward(request, response);
		 
	}else{
		//对请求过滤
	 servletRequest.getRequestDispatcher("/404.html").forward(request, response);
	  //servletResponse.sendRedirect(servletRequest.getContextPath()+"/404.html");
	}
	}else {
	if(new File(strBackUrl+path+".html").exists()){
		servletRequest.getRequestDispatcher(path+".html").forward(request, response);
	}else if(path.equals("/")){
		servletRequest.getRequestDispatcher("/index.html").forward(request, response);
	}else if(path.equals("/Admin/")||path.equals("/Admin")){
    	servletRequest.getRequestDispatcher("/Admin/index.html").forward(request, response);
	}else{
		chain.doFilter(request, response);
	}
}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	

}
