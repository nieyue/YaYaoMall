package com.yayao.action;
import java.util.ArrayList;
import java.util.Collections;
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
 * 管理收货地址增加和删除
 * @author yy
 *
 */
@Scope("prototype")
@Controller("manageConsigneeAddress")
public class ManageConsigneeAddressAction extends BaseAction{
	private static final String Integer = null;

	@Autowired
	@Qualifier("consigneeService")
	private ConsigneeService consigneeService;
	
	private String receiptName;//收货人名称
	private String province;//省
	private String city;//市
	private String country;//县
	private String street;//街道或镇
	private String address;//详细地址
	private	String zip;//邮编
	private String telePhone;//电话
	private String cellPhone;//手机号
	//private Integer consigneeIndex=0;//收货地址索引
	
	
	public String getReceiptName() {
		return receiptName;
	}
	public void setReceiptName(String receiptName) {
		this.receiptName = receiptName;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getTelePhone() {
		return telePhone;
	}
	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	/*public Integer getConsigneeIndex() {
		return consigneeIndex;
	}
	public void setConsigneeIndex(Integer consigneeIndex) {
		this.consigneeIndex = consigneeIndex;
	}*/
	
	/**
	 * 增加收货人地址
	 * @return
	 * @throws Exception
	 */
	public String addConsigneeAddress() throws Exception {
		Map session = ActionContextUtil.getSession();
		Member member = (Member) session.get("Member");
		//List list1=new ArrayList();
	
		//查询consigneeIndex
		/*List newconsignees=consigneeService.browseConsignee();
		for (int i = 0; i < newconsignees.size(); i++) {
			Consignee con = (Consignee) newconsignees.get(i);
			if((con.getMember().getId()).equals(member.getId())){
				list1.add(con.getConsigneeIndex());
			}
		}
		//排序从少到多
		Collections.sort(list1);
		for (int i = 0; i < list1.size(); i++) {
			if(list1.size()==1){
				consigneeIndex=(Integer)list1.get(0);
			}else{
				consigneeIndex=(Integer)list1.get(list1.size()-1);
				
			}
		}*/
		
		if(member!=null){
		Consignee consignee=new Consignee();
		//consigneeIndex++;
		//consignee.setConsigneeIndex(consigneeIndex);
		consignee.setMember(member);
		consignee.setReceiptName(receiptName);
		String totalAddress = province+" "+city+" "+country+" "+street+" "+address;//totaladdress为存储在数据库的address
		consignee.setAddress(totalAddress);
		consignee.setZip(zip);
		consignee.setTelePhone(telePhone);
		consignee.setCellPhone(cellPhone);
		/*List consignees = member.getConsignees();
		
		consignees.add(consignee);*/
		consignee.setHasOrder(new Integer(0));
		consigneeService.addConsignee(consignee);
		consigneeService.browseConsignee(member);
//		String mca="<li><label><span><input type='radio' name='radiobutton' value='radiobutton'></span></label>"
//				+ "<em>"+totalAddress+"</em><em>电话:"+telePhone+"</em><em>手机:"+cellPhone+"</em>"
//				+ "<span class='admin_shdz_btn'><a onClick='javascript:showDiv()' href='modifyManageConsigneeAddress.action'>编辑</a><a href='delManageConsigneeAddress.action'>删除</a></span></li>"; 
//		session.put("Consignee", mca);
		return "success";
		}
		return "input";
	}
		/**
		 * 删除收货人地址
		 * @return
		 * @throws Exception
		 */
		public String delConsigneeAddress() throws Exception{
			Map session = ActionContextUtil.getSession();
			Member member = (Member) session.get("Member");
			
			//获取索引
			String delConsigneeIndex = ActionContextUtil.getRequest().getParameter("delConsigneeIndex");
			Integer dci = new Integer(delConsigneeIndex);
			if(member!=null){
				List list= consigneeService.browseConsignee(member);
				for (int i = 0; i < list.size(); i++) {
					Consignee con = (Consignee) list.get(i);
					if(con.getId().equals(dci)){
						Consignee consignee = consigneeService.loadConsignee(con.getId());
						if(consignee.getHasOrder().equals(new Integer(0))){//0代表没有订单	
						consigneeService.delConsignee(con.getId());
						consigneeService.browseConsignee(member);
						return "success";
						}else if(consignee.getHasOrder().equals(new Integer(1))){//1代表有订单显示订货地址
                          	consignee.setHasOrder(new Integer(2));//2代表有订单，删除了的订货地址，隐藏
                          	consigneeService.updateConsignee(consignee);
                          	consigneeService.browseConsignee(member);
                          
							return "success";
						}
					}
					
				}
				
			}
			return "input";
	
	}
		

	
}