package com.yayao.filter.params;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 修改接收map
 * @author yy
 *
 */
public class ParameterUpdateUtil {
	/**
	 * map修改后再封装
	 * @param map
	 * @return
	 */
	public static Map<String,String[]> UpdateParameterNames(Map<String, String[]> map){
	     Map<String, String[]> newMap = new HashMap<String, String[]>();
	     for(Iterator<?> iter = map.entrySet().iterator();iter.hasNext();){  
	    	 @SuppressWarnings("rawtypes")
			Map.Entry element = (Map.Entry)iter.next();  
	    	 String strKey = (String) element.getKey();  
	    	 String[] value=(String[])element.getValue();  
	    	 strKey=MyNamingStrategy.underlineToCamel(strKey);
	    	 
	    	 List<String> listvalue = new ArrayList<String>();  
	    	 for(int i=0;i <value.length;i++){  
	    	 listvalue.add(value[i]);
	    	 }  
	    	 String[] valueStr= listvalue.toArray(new String[listvalue.size()]);
	    	 newMap.put(strKey,valueStr);
	    	 }
		
		return newMap;
	}
}
