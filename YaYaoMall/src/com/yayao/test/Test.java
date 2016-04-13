package com.yayao.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mysql.jdbc.Util;

public class Test {
	int validCode=(int) (Math.random()*9000+1000);
	public static void main(String[] args) throws ParseException {
		new Thread(new Runnable() {
			public void run() {
				System.out.println("123");
			}
		}).start();
		//System.out.println(new Integer(-0));
		//System.out.println(new Test().validCode);
		
		String a=null;
		String b="";
		String c=" ";
		Integer aa=null;
		Integer bb=0;
		Integer cc;
			System.out.println(bb);
			SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String str="2011-5-31 14:40:50";
			String str2="2011-5-31 14:40:40";
			Date d=sim.parse(str);
			Date d2=sim.parse(str2);
			System.out.println(d);
			System.out.println(!(d2.after(d)));
		String bvb="sdf";
		System.out.println(Integer.valueOf(str).intValue());
			
	}
}
