package com.yayao.util;

import java.io.File;
import java.math.BigDecimal;






import java.util.ArrayList;
import java.util.Collections;
import java.util.List;







import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONString;
import net.sf.json.util.JSONBuilder;
import net.sf.json.util.JSONStringer;

import org.apache.commons.collections.map.HashedMap;
import org.apache.struts2.ServletActionContext;

import com.yayao.bean.Admin;


public class test {
	
	
	public static void main(String[] args) {
		
//	int d = Integer.MAX_VALUE;
//	System.out.println(d);
//	long l = Long.MAX_VALUE;
//	System.out.println(l);
//	
//	 List list=new ArrayList();
//	 int a=26;
//	 if(a>3){
//		 list.add("变值了");
//	 }
//	 System.out.println(list);
//	int b=5;
//	System.out.println(a/b);
//	}
//	
//	boolean a=true;
//	boolean b=false;
//	Boolean z=true;
//	Boolean x=false;
//	System.out.println(a);
//	System.out.println(b);
//	System.out.println(z.toString());
//	System.out.println(x);
//	
//	String aa="0";
//	System.out.println(aa);
//	System.out.println(aa.getClass());
//	Integer zz=new Integer(aa);
//	System.out.println(zz);
//	System.out.println(zz.getClass());
	//第一种：
	java.text.DecimalFormat df=new java.text.DecimalFormat("#.##"); 
	double d=3.14159; 
	System.out.println(df.format(d));
	 
	//第二种：
	BigDecimal bd = new BigDecimal("3.14159265"); 
	bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
	 
	//第三种：
	long l = Math.round(3.14159*100); //四舍五入 
	double ret = l/100.0; //注意：使用 100.0 而不是 100 
	 
	//第四种：
	double bbd = 13.569344; 
	//double bbd = 13.9999999; 
 //double ddd = Math.round(Double.valueOf(bbd)*100)/100.0;
 double dddd = Math.round(bbd*100)/100.0;
 //double dddd = bbd*100/100.0;
	//d=((int)(bbd*100))/100;
	System.out.println(dddd);
	
	/**JSON的数据获取*/
	String jsonStr = "{'head':{'version':'1'},'dataList':{'resCode':'ss','list':[{'name':'file1','type':'0'},{'name':'file2','type':'1'}]}}";
	JSONObject  dataJson=JSONObject.fromObject(jsonStr);
	JSONObject  dataList=dataJson.getJSONObject("dataList");
	JSONArray list=dataList.getJSONArray("list");
	for (int i = 0; i < list.size(); i++) {
		JSONObject info=list.getJSONObject(i);
		String name=info.getString("name");
		String type=info.getString("type");
		System.out.println(name+type);
	}
	
	//String name = jsonObject.getString("name");
	System.out.println(dataJson);
	Admin a=new Admin();
	a.setLoginName("sdfsd3333f");
	a.setAdminType(2);
	System.out.println(JSONArray.fromObject(a));
	JSONObject jsona = JSONObject.fromObject(a);
	System.out.println(jsona.getString("adminType"));
	
	
	List ll=new ArrayList();
	ll.add("sfdsd");
	ll.add("23432");
	ll.add(234);
	ll.add("电费");
	System.out.println(ll);
  Collections.shuffle(ll);
  System.out.println(ll);
  System.out.println(ll.toString());
  JSONArray jsonarray=JSONArray.fromObject(ll);
  System.out.println(jsonarray.toString());
  //String st=null;
	//System.out.println(st);
  
  String aaaaa="abscsdfspajfsap[fasdsdajfo";
  System.out.println(aaaaa.indexOf("b"));
  Admin aa=new Admin();
  aa.setAdminName("没");
  aa.setAdminType(3);
  aa.setLoginName("dsfsdf");
  aa.setLoginPwd("sdf2323");
  JSONObject son=JSONObject.fromObject(aa);
  System.out.println(son.toString());
  JSONArray ssdd = JSONArray.fromObject(son);
  System.out.println(ssdd.toString());
  
  
  String path=new File("D:\\nieyue\\YaYaoXiangXiu\\customPicture").toString();
  System.out.println(path);
  
  
}
}