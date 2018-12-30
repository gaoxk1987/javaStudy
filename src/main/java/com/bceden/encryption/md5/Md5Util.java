package com.bceden.encryption.md5;

import java.security.MessageDigest;

import org.apache.log4j.Logger;

public class Md5Util {
	
	private static final Logger logger = Logger.getLogger(Md5Util.class);
	
	
	public static String encodeByMD5(String source,String salt){
		if (source == null) {
            return "";
        }
		if(salt==null){
			salt = "";
		}
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(source.getBytes("GBK"));
            return new String(Hex.encode(messageDigest.digest(salt.getBytes("GBK"))));
        } catch (Exception e) {
        	logger.error("生成md5报错",e);
        }
        return "";
	}	

}