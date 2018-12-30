package com.bceden.httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/**
 * 通过httpclient 4.5.1 版本发送数据
 */
public class HttpClientUtilPerfect {

	private static final Logger logger = Logger.getLogger(HttpClientUtilPerfect.class);
	
	private static final String CHARSET = "GBK";
	private static final int TIMEOUT=5*1000*60;
	private static final int CONNECTION_TIMEOUT=5*1000*60;
	private static final int SO_TIMEOUT=5*1000*60;
	
	private HttpClientUtilPerfect(){}
	
	private static HttpClient httpClient ;
	
	private static synchronized HttpClient getHttpClient(){
		if(null == httpClient){
			SchemeRegistry schemeRegistry = new SchemeRegistry();  
			schemeRegistry.register(  
			         new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));  
			schemeRegistry.register(  
			         new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));  
			  
			ThreadSafeClientConnManager cm = new ThreadSafeClientConnManager(schemeRegistry);  
			// Increase max total connection to 200  
			cm.setDefaultMaxPerRoute(200);  
			// Increase default max connection per route to 20  
			cm.setDefaultMaxPerRoute(20);  
			// Increase max connections for localhost:80 to 50  
			HttpHost localhost = new HttpHost("locahost", 80);  
			cm.setMaxForRoute(new HttpRoute(localhost), 50);  
			   
			 httpClient = new DefaultHttpClient(cm); 		
		}
		return httpClient;
	}

	public static String sendHttpMessage(String url,Map<String, String> map) throws Exception{
		try {
			if(StringUtils.isEmpty(url) || null == map || map.isEmpty()){
				return null;
			}
			//创建POST请求
			HttpPost post = new HttpPost(url);
			post.setHeader("Content-type", (new StringBuilder()).append("application/x-www-form-urlencoded; charset=").append(CHARSET).toString());
	        post.setHeader("Accept",new StringBuffer("text/xml;charset=").append(CHARSET).toString());
	        post.setHeader("Cache-Control", "no-cache");
	        
	        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
	        //请求参数
			for(String key : map.keySet()){
				params.add(new BasicNameValuePair(key,map.get(key))); 
			}
	        post.setEntity(new UrlEncodedFormEntity(params, CHARSET));
	        
			//发送请求
			HttpClient client = getHttpClient();
			HttpResponse response = client.execute(post);
			if(response.getStatusLine().getStatusCode() != HttpStatus.SC_OK){
				throw new Exception("请求失败！");
			}
			
			HttpEntity resEntity = response.getEntity();
			return null == resEntity ? "" : EntityUtils.toString(resEntity,CHARSET);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			logger.error("HttpClientUtil error ...", e);
			throw new Exception(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			logger.error("HttpClientUtil error ...", e);
			throw new Exception(e.getMessage());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			logger.error("HttpClientUtil error ...", e);
			throw new Exception(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("HttpClientUtil error ...", e);
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("HttpClientUtil error ...", e);
			throw new Exception(e.getMessage());
		}
	}
	
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
	public static void post(){
		String url = "http://192.168.44.141/wlgateway/digest.html";
		 String response ="";
	        try{
	            //post请求参数
	        	StringBuffer buffer = new StringBuffer("{\"order\":{");
	    		buffer.append("\"orderCode\":").append("abc").append("abc").append("abc").append("abc");
	    		buffer.append("\"customerId\":").append("abc").append("abc").append("abc");
	    		buffer.append("}");
	    		buffer.append("}");
	           
	        	Map<String, String> param = new HashMap<String, String>();
	    		param.put("charset", CHARSET);
				param.put("dataType", "json");
				param.put("ordercode", "046447802");
				param.put("data", buffer.toString());
	            response = sendHttpMessage(url,param);
	            System.out.println("返回数据："+response);
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	}
}
