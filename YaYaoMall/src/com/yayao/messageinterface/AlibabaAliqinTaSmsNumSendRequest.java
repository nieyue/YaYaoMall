package com.yayao.messageinterface;

import java.io.Serializable;

public class AlibabaAliqinTaSmsNumSendRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 公共回传参数
	 */
	private String extend;
	/**
	 * 短信类型
	 */
	private String smsType;
	/**
	 * 短信签名
	 */
	private String smsFreeSignName;
	/**
	 * 短信模板变量
	 */
	private String smsParamString;
	/**
	 * 短信接收号码
	 */
	private String recNum;
	/**
	 * 短信模板ID
	 */
	private String smsTemplateCode;
	/**
	 *自定义扩展码
	 */
	private String extendCode;
	/**
	 * 商家自定义扩展名,例如店铺nick
	 */
	private String extendName;
	
	public AlibabaAliqinTaSmsNumSendRequest() {
		super();
	}

	public AlibabaAliqinTaSmsNumSendRequest(String extend, String smsType,
			String smsFreeSignName, String smsParamString, String recNum,
			String smsTemplateCode, String extendCode, String extendName) {
		super();
		this.extend = extend;
		this.smsType = smsType;
		this.smsFreeSignName = smsFreeSignName;
		this.smsParamString = smsParamString;
		this.recNum = recNum;
		this.smsTemplateCode = smsTemplateCode;
		this.extendCode = extendCode;
		this.extendName = extendName;
	}

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}

	public String getSmsType() {
		return smsType;
	}

	public void setSmsType(String smsType) {
		this.smsType = smsType;
	}

	public String getSmsFreeSignName() {
		return smsFreeSignName;
	}

	public void setSmsFreeSignName(String smsFreeSignName) {
		this.smsFreeSignName = smsFreeSignName;
	}

	public String getSmsParamString() {
		return smsParamString;
	}

	public void setSmsParamString(String smsParamString) {
		this.smsParamString = smsParamString;
	}

	public String getRecNum() {
		return recNum;
	}

	public void setRecNum(String recNum) {
		this.recNum = recNum;
	}

	public String getSmsTemplateCode() {
		return smsTemplateCode;
	}

	public void setSmsTemplateCode(String smsTemplateCode) {
		this.smsTemplateCode = smsTemplateCode;
	}

	public String getExtendCode() {
		return extendCode;
	}

	public void setExtendCode(String extendCode) {
		this.extendCode = extendCode;
	}

	public String getExtendName() {
		return extendName;
	}

	public void setExtendName(String extendName) {
		this.extendName = extendName;
	}
	
}
