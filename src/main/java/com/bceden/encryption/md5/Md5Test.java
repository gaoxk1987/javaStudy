package com.bceden.encryption.md5;

import java.security.MessageDigest;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.codec.Hex;

import sun.misc.BASE64Encoder;

public class Md5Test {
	
	private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5','6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	
	public static void main(String[] args) {
		
		
		System.out.println(sourceTest("1q2w3e4r","hc360"));
		System.out.println(sourceTest("1q2w3e4r","{hc360}"));
		System.out.println(sourceTest("你好","{hc360}"));
		System.out.println(sourceTest("你好",""));
		System.out.println("--------------------------------");
		System.out.println(sourceTest2("1q2w3e4r","hc360"));
		System.out.println(sourceTest2("1q2w3e4r","{hc360}"));
		System.out.println(sourceTest2("你好","{hc360}"));
		System.out.println(sourceTest2("你好",""));
		
		System.out.println("--------------------------------");
//		sourceTest2("1q2w3e4r","hc360");
		
		System.out.println(springTest("1q2w3e4r","hc360",false));
		System.out.println(springTest("1q2w3e4r","hc360",true));
		
		System.out.println(springTest("1q2w3e4r","",false));
		System.out.println(springTest("1q2w3e4r","",true));
	}

	public static String sourceTest(String source,String salt){
		return Md5Util.encodeByMD5(source, salt);
	}
	
	
	public static String sourceTest2(String source,String salt){
		if (source == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(source.getBytes("GBK"));
//            messageDigest.update(source.getBytes()); 95890b8904a0772a0a07e8e7f67aedfa
//            return getFormattedText(messageDigest.digest(salt.getBytes()));
//            return getFormattedText(messageDigest.digest());d2f2dcb683c23ece8a1d08c5826d1ed3
            return new String(Hex.encode(messageDigest.digest(salt.getBytes("GBK"))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	public static void sourceTest3(String source,String salt){
		try {
			
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(source.getBytes("UTF-8"));
			BASE64Encoder base64 = new BASE64Encoder();
			byte[] digest =md5.digest() ;
			byte[] md5Digest = md5.digest(salt.getBytes("UTF-8")) ;
			
			System.out.println(new String(digest));
			System.out.println(new String(md5Digest));
			
			String noSaltString = base64.encode(digest);
			String saltString = base64.encode(md5Digest);			
			System.out.println(noSaltString);
			System.out.println(saltString);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String springTest(String source,String salt,boolean encodeHashAsBase64){
		Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		passwordEncoder.setEncodeHashAsBase64(encodeHashAsBase64);  //是否使用base64编码
		return passwordEncoder.encodePassword(source,salt);
	}
	
	 private static String getFormattedText(byte[] bytes) {
         int len = bytes.length;
         StringBuilder buf = new StringBuilder(len * 2);
         // 把密文转换成十六进制的字符串形式
         for (int j = 0; j < len; j++) {      
        	 buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
             buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
         }
         
         return buf.toString();
}
}
