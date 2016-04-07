package com.yayao.util;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;


/** 具有日志功能 */
public class BaseAction  extends ActionSupport{
	/** 取得日志记录器Logger */
	public static Logger logger = Logger.getLogger(BaseAction.class);
	@Override
	public void addActionMessage(String aMessage) {
		 //改从国际化里取值
	    if (aMessage.startsWith("the request was rejected because its size"))

	    {
	        super.addActionError("系统上传的文件最大为2M");
	    }

	   else

	   {
	        super.addActionError(aMessage);
	   }
	}
}