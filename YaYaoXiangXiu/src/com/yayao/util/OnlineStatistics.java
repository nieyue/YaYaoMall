package com.yayao.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 * 用户统计类
 */
import com.yayao.bean.Member;

/**
 * 在线用户实现类
 * @author yy
 *
 */
	public class OnlineStatistics {  
	    private static int count = 0;  
	    private static Set onlineMemberList = new HashSet();  
	  
	    /** 
	     * 统计在线总数(递增) 
	     */  
	    public static void increase() {  
	        count++;  
	    }  
	  
	    /** 
	     * 统计在线人数(递减) 
	     */  
	    public static void decrease() {  
	        count--;  
	    }  
	  
	    /** 
	     * 统计在线会员(添加) 
	     *  
	     * @param memberInfo 
	     */  
	    public static void addAttr(Member member) {  
	        // 如果在线会员列表不为空,则迭代该列表,检查当前登录的会员id与列表中的记录id是否一致.  
	        Iterator itr = onlineMemberList.iterator();  
	        while (itr.hasNext()) {  
	            // 先判断该会员是否已有session信息保存在统计对象中.若有,把旧的挤掉,再放入新的.  
	            Member temp = (Member) itr.next();  
	            String memberName = temp.getLoginName();// 保存在统计类中的用户名  
	            if (member.getLoginName().equals(memberName)) {  
	                itr.remove();  
	            }  
	        }  
	        onlineMemberList.add(member);  
	    }  
	  
	    /** 
	     * 统计在线会员(清除) 
	     *  
	     * @param memberInfo 
	     */  
	    public static void removeAttr(Member member) {  
	        onlineMemberList.remove(member);  
	    }  
	  
	    /** 
	     * 获取在线访客的数量 
	     *  
	     * @return the count 
	     */  
	    public static int getOnlineVisitors() {  
	        return count - 1;// 除去管理员本身  
	    }  
	  
	    /** 
	     * 获取在线会员的列表 
	     *  
	     * @return the onlineMemberList 
	     */  
	    public static Set getOnlineMemberList() {  
	        return onlineMemberList;  
	    }  
	  
	    /** 
	     * 根据登录次数判断登录次序的先后 
	     *  
	     * @param memberInfo 
	     * @return 
	     */  
	    public static boolean isOld(Member member) {  
	        Iterator itr = onlineMemberList.iterator();  
	        while (itr.hasNext()) {  
	            Member temp = (Member) itr.next();  
	            String memberName = temp.getLoginName();// 保存在统计类中的用户名  
	            Integer loginTimes = temp.getLoginTimes();// 保存在统计类中的用户登录次数  
	            if (member.getLoginName().equals(memberName) && (member.getLoginTimes().intValue()-loginTimes.intValue())<0) {  
	                // 如果当前用户的登录次数比统计对象里保存的同名用户的登录次数要少,则返回true  
	                return true;  
	            }  
	        }  
	        return false;  
	    }  
	  
}
