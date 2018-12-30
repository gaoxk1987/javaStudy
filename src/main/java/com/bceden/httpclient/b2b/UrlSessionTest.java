package com.bceden.httpclient.b2b;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class UrlSessionTest {

	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		 for(int i=0;i<5000;i++){
			 System.out.println("开始执行："+i);
			 post();
		 }
		 System.out.println("耗时："+(System.currentTimeMillis()-startTime));
		 try {
				Thread.currentThread().sleep(1000*60*5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	
	public static void post() {
		
		String url = "http://192.168.44.141/wlgateway/digest.html";
	            //post请求参数
	        	StringBuffer buffer = new StringBuffer("{\"order\":{");
	    		buffer.append("\"orderCode\":").append("abc").append("abc").append("abc").append("abc");
	    		buffer.append("\"customerId\":").append("abc").append("abc").append("abc");
	    		buffer.append("}");
	    		buffer.append("}");
//	           
//	        	Map<String, String> param = new HashMap<String, String>();
//	    		param.put("charset", CHARSET);
//				param.put("dataType", "json");
//				param.put("ordercode", "046447802");
//				param.put("data", buffer.toString());
//	            response = sendHttpMessage(url,param);
//	            System.out.println("返回数据："+response);
		
		
		String p =  buffer.toString();
//		p = URLEncoder.encode(p, "UTF-8");
		String response="";
		try {
			response = UrlSession.postUrl(url,p,"UTF-8","application/json");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(response);
	}

}
