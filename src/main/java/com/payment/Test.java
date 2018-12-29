package com.payment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import com.pay.zfb.validator.inteface.ValidateSignData;
import com.pay.zfb.vo.DirectPayMentPV;
import com.payment.util.Md5Util;

public class Test {

	public static void main(String[] args) {
		
		DirectPayMentPV dmp = new DirectPayMentPV();
		
		dmp.setAmount("178.00");
		dmp.setCharset("utf-8");
		dmp.setNotifyURL("http://www.hcjdc.com/hc360pay");
		dmp.setOrderCode("2015121726935");
		dmp.setPartner("100021");
		dmp.setReceiverAddress("");
		dmp.setReceiverName("");
		dmp.setReturnURL("http://www.hcjdc.com/hc360pay");
		dmp.setSellerSSOID("hcjdcc");
		dmp.setService("create_direct_pay_by_user");
		dmp.setSignType("MD5");
		dmp.setSubject("");
		dmp.setTimestamp("2015-03-23 12:49:20");
		dmp.setVersion("V1.0");
		dmp.setSign("b451e2700689a3334a6948ba3830c92d");
		
		System.out.println(isValid(dmp,"abc"));
		
	}
	
	
	public static boolean isValid(ValidateSignData value,String salt) {
		if(value == null || StringUtils.isEmpty(value.getPartner()) || StringUtils.isEmpty(value.getSignType()) || StringUtils.isEmpty(value.getSign()) || StringUtils.isEmpty(value.getCharset())){
			return false;
		}
		try {
			Map<String, String> map = BeanUtils.describe(value);
			map.remove("class");
			String text = createSignString(paraFilterData(map));
			System.out.println("text =" + text);
			//校验是否正确
			String mysign =Md5Util.encodeByMD5(text, salt);
			if (mysign.equals(value.getSign())) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	  /** 
     * 除去数组中的空值和签名参数 无需签名加密的参数
     * @param sArray 签名参数组
     * @return 去掉空值与签名参数后的新签名参数组
     */
    public static Map<String, String> paraFilterData(Map<String, String> sArray) {

        Map<String, String> result = new HashMap<String, String>();

        if (sArray == null || sArray.size() <= 0) {
            return result;
        }

        for (String key : sArray.keySet()) {
            String value = sArray.get(key);
            if (value == null || value.equals("") || value.equals("null") || key.equalsIgnoreCase("sign")
                || key.equalsIgnoreCase("signType") || key.equalsIgnoreCase("charset")) {
                continue;
            }
            result.put(key, value);
        }

        return result;
    }
    
    
    /** 
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public static String createSignString(Map<String, String> params) {

        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        String prestr = "";

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);

            if (i == keys.size() - 1) {//拼接时，最后不包括一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }

        return prestr;
    }

}
