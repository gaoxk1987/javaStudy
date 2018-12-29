package com.payment.util;

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
	public static void main(String[] args) {
		String timestamp = "2015-12-28 22:00:00";
		String accesstoken = "3974f3df0a8ca8b76ab924864939aebb";
//		String source = "{\"client_id\":\"ceshi\",\"client_secret\":\"haomeng\",\"access_token\":"+accesstoken+",\"time_stamp\":"+timestamp+",\"params\":{\"userName\":\"lzl\",\"phone\":\"18612450040\",\"source\":\"1\"}}";
		String source = "{\"client_id\":\"1\",\"client_secret\":\"haomeng\",\"access_token\":\""+accesstoken+"\",\"time_stamp\":\""+timestamp+"\",\"params\":{\"hfbType\":\"0\",\"hfbName\":\"刘尊礼\",\"cardNo\":\"1\",\"legalperson\":\"刘尊礼法人\",\"legalpersonCard\":\"法人11\",\"bankCardNo\":\"10000\",\"bankUserName\":\"刘尊礼\",\"openBankName\":\"中信银行\",\"openBankJigomc\":\"中信银行股份有限公司西安融鑫路支行\",\"sourceType\":\"1\"}}";
		System.out.println(source);
		System.out.println(new Md5Util().encodeByMD5(source, "666"));
	}

}