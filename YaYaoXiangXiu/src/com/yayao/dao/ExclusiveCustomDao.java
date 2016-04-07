package com.yayao.dao;

import java.util.*;
import com.yayao.bean.*;

public interface ExclusiveCustomDao {
	
	/** 新增定制 */	
	public void addExclusiveCustom(ExclusiveCustom exclusiveCustom);
	/** 修改定制 */	
	public void updateExclusiveCustom(ExclusiveCustom exclusiveCustom);
	
	/** 浏览所有定制*/
	public List browseExclusiveCustom() ;
	/** 删除定制*/	
	public void delExclusiveCustom(Integer id) ;
	/**装载单个定制 */	
	public ExclusiveCustom loadExclusiveCustom(Integer id) ;	
	/**查询定制订单 */	
	public List searchExclusiveCustom(String hql);	
	
}
