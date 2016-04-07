package com.yayao.action;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.yayao.bean.Admin;
import com.yayao.bean.Consignee;
import com.yayao.bean.Member;
import com.yayao.service.AdminService;
import com.yayao.service.ConsigneeService;
import com.yayao.util.ActionContextUtil;
import com.yayao.util.BaseAction;
import com.yayao.util.SHAutil;


/**
 * 管理收货地址修改地址
 * @author yy
 *
 */
@Scope("prototype")
@Controller("modifyManageConsigneeAddress")
public class ModifyManageConsigneeAddressAction extends BaseAction{
	@Autowired
	@Qualifier("consigneeService")
	private ConsigneeService consigneeService;
	
	private String modifyReceiptName;//收货人名称
	private String modifyProvince;//省
	private String modifyCity;//市
	private String modifyCountry;//县
	private String modifyStreet;//街道或镇
	private String modifyAddress;//详细地址
	private String modifyTelePhone;//电话

	public String getModifyReceiptName() {
		return modifyReceiptName;
	}


	public void setModifyReceiptName(String modifyReceiptName) {
		this.modifyReceiptName = modifyReceiptName;
	}


	public String getModifyProvince() {
		return modifyProvince;
	}

	public void setModifyProvince(String modifyProvince) {
		this.modifyProvince = modifyProvince;
	}

	public String getModifyCity() {
		return modifyCity;
	}

	public void setModifyCity(String modifyCity) {
		this.modifyCity = modifyCity;
	}


	public String getModifyCountry() {
		return modifyCountry;
	}


	public void setModifyCountry(String modifyCountry) {
		this.modifyCountry = modifyCountry;
	}


	public String getModifyStreet() {
		return modifyStreet;
	}

	public void setModifyStreet(String modifyStreet) {
		this.modifyStreet = modifyStreet;
	}

	public String getModifyAddress() {
		return modifyAddress;
	}


	public void setModifyAddress(String modifyAddress) {
		this.modifyAddress = modifyAddress;
	}


	public String getModifyTelePhone() {
		return modifyTelePhone;
	}

	public void setModifyTelePhone(String modifyTelePhone) {
		this.modifyTelePhone = modifyTelePhone;
	}

	//修改收货地址
	public String modifyConsigneeAddress() throws Exception {
		Map session = ActionContextUtil.getSession();
		Member member = (Member) session.get("Member");
		//获取索引
		String modifyConsigneeIndex = ActionContextUtil.getRequest().getParameter("modifyConsigneeIndex");
		Integer mci = new Integer(modifyConsigneeIndex);
		if(member!=null&&modifyReceiptName!=null){
			//获取当前人的所有地址列表
			List list= consigneeService.browseConsignee(member);
			for (int i = 0; i < list.size(); i++) {
				Consignee con = (Consignee) list.get(i);
				if(con.getId().equals(mci)){
					Consignee consignee=consigneeService.loadConsignee(con.getId());
					consignee.setReceiptName(modifyReceiptName);
					consignee.setTelePhone(modifyTelePhone);
					String totalAddress=modifyProvince+" "+modifyCity+" "+modifyCountry+" "+modifyStreet+" "+modifyAddress;
					consignee.setAddress(totalAddress);
					consigneeService.updateConsignee(consignee);
					consigneeService.browseConsignee(member);
					return "success";
				}
				
			}
			
		}
		return "input";

}

	
	}
	
