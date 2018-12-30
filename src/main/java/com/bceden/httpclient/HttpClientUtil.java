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
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/**
 * 通过httpclient 4.0.3 版本发送数据
 */
public class HttpClientUtil {

	private static final Logger logger = Logger.getLogger(HttpClientUtil.class);
	
	private static final String CHARSET = "GBK";
	private static final int TIMEOUT=5*1000*60;
	private static final int CONNECTION_TIMEOUT=5*1000*60;
	private static final int SO_TIMEOUT=5*1000*60;
	
	private HttpClientUtil(){}
	
	private static HttpClient httpClient ;
	
	private static synchronized HttpClient getHttpClient(){
		if(null == httpClient){
			HttpParams httpParams = new BasicHttpParams();
			httpParams.setParameter("http.method.retry-handler", new DefaultHttpRequestRetryHandler());
			httpParams.setBooleanParameter("http.connection.stalecheck", false);
			//参数设置
			HttpProtocolParams.setVersion(httpParams, HttpVersion.HTTP_1_1);
			HttpProtocolParams.setContentCharset(httpParams, CHARSET);
			HttpProtocolParams.setUseExpectContinue(httpParams, true);
			//超时设置
			ConnManagerParams.setTimeout(httpParams, TIMEOUT);
			//连接超时
			HttpConnectionParams.setConnectionTimeout(httpParams, CONNECTION_TIMEOUT);
			//请求超时
			HttpConnectionParams.setSoTimeout(httpParams, SO_TIMEOUT);
			
			//设置支持HTTP和HTTPS
			SchemeRegistry schemeReg = new SchemeRegistry();
			schemeReg.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
			schemeReg.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
			//使用线程安全的连接创建HttpClient
			ClientConnectionManager conManager = new ThreadSafeClientConnManager(httpParams, schemeReg);
			httpClient = new DefaultHttpClient(conManager,httpParams);
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
