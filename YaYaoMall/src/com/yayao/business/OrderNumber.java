package com.yayao.business;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.yayao.util.DateUtil;
import com.yayao.util.NumberUtil;
/**
 * 订单编号生成
 * @author yy
 *
 */
public class OrderNumber {
	private static AtomicInteger ai = new AtomicInteger(0);

	// 使用CAS实现线程安全的计数器
	public static void safeCount() {
		// 用一个for循环,如果没有计数成功的话,会一直执行这段代码，知道计数成功break为止
		for (;;) {
			if(ai.get()>=9999999){
				ai.set(0);
			}
			int i = ai.get(); // 读取value值,赋给i,i在线程的工作内存中
			// 将主内存中的值(current)与工作内存中的值i相比较,如果相等的话，说明工作内存中的i值仍然是value的最新值
			// 计数运算对当前i操作没有问题,将value值设为i+1,因为value是violent的，所以写的时候也就写到了主内存
			boolean suc = ai.compareAndSet(i, i + 1);
			if (suc) {
				
				break;
			}
			//return i;
		}
	}
	/**
	 * 0000001-1000000之间的订单尾号
	 * @param rearNum
	 * @return
	 */
	public static String rearNumber(){
		safeCount();
		int rearNum = ai.get();
		String sa = String.valueOf(rearNum);
		if(!NumberUtil.isNumeric(sa)){
			return "1";
		}else if(rearNum>9999999||rearNum<=0){
			return "1";
		}
	       int index = sa.length();
	       int first=0;
	       first=7-index;
	     for (int i = 0; i < first; i++) {
	    	   sa="0"+sa;
		}
		return sa;
	}
	public static void main(String[] args) throws InterruptedException {
		String ts=DateUtil.timeStamp();
			
		Thread ss=new Thread(new Runnable() {
			public void run() {
				System.out.println(rearNumber());
				System.out.println(rearNumber());
			}
		});
		ss.start();
		//ss.join();//优点安全，缺点阻塞
	}
		
}
