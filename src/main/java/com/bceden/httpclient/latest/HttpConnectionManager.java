package com.bceden.httpclient.latest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.bceden.httpclient.HttpClientUtil;

public class HttpConnectionManager {
	
private static final Logger logger = Logger.getLogger(HttpClientUtil.class);
	
	private static final String CHARSET = "GBK";
	private static final int TIMEOUT=5*1000*60;
	private static final int CONNECTION_TIMEOUT=5*1000*60;
	private static final int SO_TIMEOUT=5*1000*60;
	
	private HttpConnectionManager(){}
	
	private static HttpClient httpClient ;
	
	private static synchronized HttpClient getHttpClient() throws Exception{
		if(null == httpClient){
			   PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
			    // 将最大连接数增加到200
			    cm.setMaxTotal(200);
			    // 将每个路由基础的连接增加到20
			    cm.setDefaultMaxPerRoute(20);
			    //将目标主机的最大连接数增加到50
//			    HttpHost localhost = new HttpHost("www.yeetrack.com", 80);
			    HttpHost localhost = new HttpHost("192.168.44.141", 80);
			    cm.setMaxPerRoute(new HttpRoute(localhost), 50);
			    
//			    ConnectionConfig defaultConnectionConfig = n
//			    cm.setDefaultConnectionConfig(defaultConnectionConfig);
			    
//			    CloseableHttpClient   httpClient = HttpClients.custom()
//			            .setConnectionManager(cm)
//			            .build();  
			    httpClient = HttpClients.custom()
			            .setConnectionManager(cm)
			            .build();
			    
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
	        
	        //超时等设置
		    RequestConfig requestConfig = RequestConfig.custom()
		    		.setConnectionRequestTimeout(TIMEOUT)//使用连接管理器的获取连接的超时设置
		    		.setConnectTimeout(CONNECTION_TIMEOUT)//连接超时
		            .setSocketTimeout(SO_TIMEOUT)//超时等待数据,或者换句话说,两个连续的数据包之间的最长时间不活动
		            .build();
		    post.setConfig(requestConfig);
	        
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
	
	
	
	
	
	
	public static void getConnectionManager() {
		HttpClientContext context = HttpClientContext.create();
	    HttpClientConnectionManager connMrg = new BasicHttpClientConnectionManager();
	    HttpRoute route = new HttpRoute(new HttpHost("www.yeetrack.com", 80));
	    // 获取新的连接. 这里可能耗费很多时间
	    ConnectionRequest connRequest = connMrg.requestConnection(route, null);
	    HttpClientConnection conn = null;
	    try {
	    	// 10秒超时
	    	conn = connRequest.get(10, TimeUnit.SECONDS);
	        // 如果创建连接失败
	        if (!conn.isOpen()) {
	            // establish connection based on its route info
	            connMrg.connect(conn, route, 1000, context);
	            Thread.currentThread().sleep(10000);
	            // and mark it as route complete
	            connMrg.routeComplete(conn, route, context);
	        }
	        // 进行自己的操作.
	    }catch(Exception e){
	    	e.printStackTrace();
	    }finally {
	        connMrg.releaseConnection(conn, null, 1, TimeUnit.MINUTES);
	    }
	}
	
	public static void poolTest(){
		   PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		    // 将最大连接数增加到200
		    cm.setMaxTotal(200);
		    // 将每个路由基础的连接增加到20
		    cm.setDefaultMaxPerRoute(20);
		    //将目标主机的最大连接数增加到50
		    HttpHost localhost = new HttpHost("www.yeetrack.com", 80);
		    cm.setMaxPerRoute(new HttpRoute(localhost), 50);
	
		    CloseableHttpClient httpClient = HttpClients.custom()
		            .setConnectionManager(cm)
		            .build();  
		    
		    //关闭连接器
		    try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}