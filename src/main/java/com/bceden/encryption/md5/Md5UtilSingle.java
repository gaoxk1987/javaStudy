package com.bceden.encryption.md5;

import java.security.MessageDigest;

public class Md5UtilSingle {
	
	private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5','6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	
	public static String encodeByMD5(String source){
					if (source == null) {
			            return null;
			        }
			        try {
			            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			            messageDigest.update(source.getBytes());
			            return getFormattedText(messageDigest.digest());
			        } catch (Exception e) {
			            throw new RuntimeException(e);
			        }

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
	 
	public static void main(String[] args) {
		System.out.println(encodeByMD5("1q2w3e4r"));
	}
}
