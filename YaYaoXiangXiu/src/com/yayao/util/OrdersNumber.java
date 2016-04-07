package com.yayao.util;
/**
 * 实现订单编号的自动增加
 * @author yy
 *
 */
public class OrdersNumber {
	/**
	 * 自动增加
	 * @param value是传入进来的产品数量
	 * @return
	 */
    public static String increase(String value){  
    int index=1;  
    if(value.length()>1){
    	
    int n=Integer.parseInt(value.substring(index))+1;  
    String newValue=String.valueOf(n);  
    int len=value.length()-newValue.length()-index;  
      
    for(int i=0;i<len;i++){  
    newValue="0"+newValue;  
    }  
    return value.substring(0,index)+newValue;  
    }   else if(value.length()==1){
    	int currentvalue = Integer.parseInt(value)+1;
    	return String.valueOf(currentvalue);
    }else{
    	return value;
    }
    }
    
    public static void main(String[] args) {
		String s = increase("0019");
		System.out.println(s);
	}
}
