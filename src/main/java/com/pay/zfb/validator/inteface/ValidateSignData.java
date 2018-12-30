package com.pay.zfb.validator.inteface;


/**
 * 验证签名数据接口
 * @version 1.0
 */

public interface ValidateSignData {

	public String getSign();
	
	public String getSignType();
	
	public String getPartner();
	
	public String getCharset();
	
}