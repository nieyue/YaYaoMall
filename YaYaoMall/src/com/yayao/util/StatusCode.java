package com.yayao.util;
/**
 * 状态码常量类
 * @author yy
 *
 */
public class StatusCode {
	/**
	 * 成功
	 */
	public static String SUCESS="200";
	/**
	 * 失败
	 */
	public static String ERROR="null";
	/**
	 * 用户已经存在
	 */
	public static String USER_EXIST="用户已经存在";
	/**
	 * 用户不存在
	 */
	public static String USER_NOT_EXIST="用户不存在";
	/**
	 * 一分钟请求一次
	 */
	public static String ONE_ASK_ONE="一分钟请求一次";
	/**
	 * 验证码错误
	 */
	public static String VERIFICATION_CODE_ERROR="验证码错误";
	/**
	 * 验证码过期
	 */
	public static String VERIFICATION_CODE_EXPIRED="验证码过期";
	/**
	 * Session不存在或过期
	 */
	public static String SESSION_EXPIRED="会话过期";
	
}
