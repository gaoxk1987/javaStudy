package com.payment.sign;


import java.util.HashMap;
import java.util.Map;

/**
 * 密钥工厂
 * @version 1.0
 */

public class SignVerifyFactory {

	private static Map<SignType, SignAndVerify> map = new HashMap<SignType, SignAndVerify>();
	
	public static SignAndVerify createSignAndVerify(SignType signType){
		SignAndVerify signAndVerify = map.get(signType);
		if(signAndVerify == null){
			synchronized(SignVerifyFactory.class) {
				signAndVerify = map.get(signType);
				if(signAndVerify == null){
					if(SignType.MD5 == signType){
						signAndVerify = new MD5();
					} else {
						throw new RuntimeException(signType.name() + "签名方式不支持");
					}
					map.put(signType, signAndVerify);
				}
			}
		}
		return signAndVerify;
	}
	
}