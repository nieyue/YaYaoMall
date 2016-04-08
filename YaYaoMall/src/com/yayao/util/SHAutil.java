package com.yayao.util;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;


/**
 * 
 SHA加密
 * @author yy
 *
 */
public class SHAutil {
	private static final String KEY_SHA = "SHA";
	/** 
     * SHA加密 
     *  
     * @param data 
     * @return 
     * @throws Exception 
     */  
    public static byte[] encryptSHA(byte[] data) throws Exception {  
  
        MessageDigest sha = MessageDigest.getInstance(KEY_SHA);  
        	sha.update(data);  
        	//sha.digest();
       // return sha.digest();  
        //增加自定义的Base64算法
        byte[] b=Base64.encodeBase64(data);
        return b;  
        
    }  
	
	/**
	 * 获取SHA
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static String getSHA(Object obj) throws Exception{
	 byte[] inputData = ((String) obj).getBytes();
	 
	 BigInteger sha = new BigInteger(encryptSHA(inputData));
	return sha.toString(32);
	}
	
	public static void main(String[] args) throws Exception {
		String s = SHAutil.getSHA("123456789");
		System.out.println(s);
		byte[] b="123456".getBytes();
		byte[] sb = SHAutil.encryptSHA(b);
		System.out.println(sb);
	}
}
