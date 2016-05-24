package com.yayao.messageinterface;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumQueryRequest;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumQueryResponse;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * 阿里短信测试
 * @author yy
 *
 */
public class SMSInterface {
	public static final String url = "http://gw.api.taobao.com/router/rest";
	//创建应用时，TOP颁发的唯一标识，TOP通过App Key来鉴别应用的身份。调用接口时必须传入的参数。  
    public static final String appkey = "23363627"; 
    /** 
     * SessionKey简单的说就是代表卖家的登录session 
     * SessionKey是用户身份的标识，应用获取到了SessionKey即意味着应用取得了用户的授权，可以替用户向TOP请求用户的 
     */  
    public static final String sessionKey = "*********";
    //App Secret是TOP给应用分配的密钥，开发者需要妥善保存这个密钥，这个密钥用来保证应用来源的可靠性，防止被伪造。  
    public static final String secret = "acbeda26389ee14c9f8072313245c92d"; 
	/**
	 *短信发送
	 */
    public static String SmsNumSend(String extend,String recNum,String templateCode){
    	TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend(extend);
		req.setSmsType("normal");
		req.setSmsFreeSignName("测试短信");
		req.setRecNum(recNum);
		req.setSmsParamString("{\"code\":\""+extend+"\",\"phoneName\":\""+recNum+"\"}");
		req.setSmsTemplateCode(templateCode);
		//req.setExtendCode("1234");
		//req.setExtendName("1234");
		AlibabaAliqinFcSmsNumSendResponse rsp = null;
		try {
			 rsp = client.execute(req);
			//System.out.println(rsp.getBody());
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rsp.getBody();
    }
    /**
     *短信发送记录查询
     */
    public static String SmsNumQuery(){
    	TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
    	AlibabaAliqinFcSmsNumQueryRequest req = new AlibabaAliqinFcSmsNumQueryRequest();
    	//req.setBizId("101688180762^1102237830646");
    	req.setRecNum("15111336587");
    	req.setQueryDate("20160524");
    	req.setCurrentPage(1L);
    	req.setPageSize(40L);
    	AlibabaAliqinFcSmsNumQueryResponse rsp = null;
		try {
			rsp = client.execute(req);
			//System.out.println(rsp.getBody());
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rsp.getBody();
    }
    /**
     * 综合测试
     * @param args
     * @throws ApiException
     */
    public static void SmsNumTotal(){
    	
    }
    public static void main(String[] args) throws ApiException {
    	//System.out.println(SmsNumSend("5484","15111336587","SMS_9140087"));
    	System.out.println(SmsNumQuery());
	}
}
