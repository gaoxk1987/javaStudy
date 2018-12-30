package com.bceden.utils;

import java.math.BigDecimal;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class NumberUtil {
	
	private static final Logger logger = Logger.getLogger(NumberUtil.class);
	private static String numberReg = "^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$";
	
	
	/**
	 * 
	 * 将数字后0去掉
	 * @version 1.0
	 * @date 2015年7月27日 下午12:54:59
	 * @param number
	 * @return String
	 */
	public static String numberFormat(String number){
		String result ="0";
		try {
			//判断不为空，并且为数字
			if(number==null||"".equals(number.trim())||!Pattern.matches(numberReg, number)){
				return "0";
			}
			result = BigDecimal.valueOf(Double.parseDouble(number))  
            .stripTrailingZeros().toPlainString(); 
			if("0.0".equals(result)){
				result = "0";
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("格式化数字"+number+"错误：", e);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(numberFormat("2.00"));
		System.out.println(numberFormat("1.30"));
		System.out.println(numberFormat("1.32"));
		System.out.println(numberFormat("10.00"));
		System.out.println(numberFormat("10001.00"));
		System.out.println(numberFormat(""));
		System.out.println(numberFormat("abc"));
		System.out.println(numberFormat("null"));
		System.out.println(numberFormat(null));
		System.out.println(numberFormat("5000.01"));
		System.out.println(numberFormat("98765432100.01"));
		System.out.println(numberFormat("198765432100.01"));
		System.out.println(numberFormat("0198765432100.01"));
		System.out.println(numberFormat("-0198765432100.01"));
		System.out.println(numberFormat("0.01"));
		System.out.println(numberFormat("0.84"));
		System.out.println(numberFormat("0.940"));
		System.out.println(numberFormat("0.00"));
		System.out.println(numberFormat("0.0"));
		System.out.println(numberFormat("0.000"));
		System.out.println(numberFormat("6600.01"));
		System.out.println(numberFormat("660.0a"));
		System.out.println(numberFormat("6.0.0a"));
		System.out.println(numberFormat("6a0.0"));
		
		
//		Long lineId =0l;
		Long lineId =null;
		if(lineId==null||lineId==0){
			System.out.println("啦啦啦！");
		}
		String s =null;
		if(s==null){
			System.out.println(234);
		}
		
	}
	
}
