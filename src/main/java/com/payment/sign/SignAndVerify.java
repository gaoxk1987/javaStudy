package com.payment.sign;

/**
 * 签名验证接口
 * @author hk 
 * @version 1.0
 */

public interface SignAndVerify {

	/**
	 * 签名字符串
	 * @param text 需要签名的字符串
	 * @param key 密钥
	 * @param input_charset 编码格式
	 * @return 签名结果
	 */

	public String sign(String text, String key, String input_charset);

	/**
	 * 签名字符串
	 * @param text 需要签名的字符串
	 * @param sign 签名结果
	 * @param key 密钥
	 * @param input_charset 编码格式
	 * @return 签名结果
	 */

	public boolean verify(String text, String sign, String key, String input_charset);
	
}