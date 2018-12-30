package com.bceden.httpclient.latest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSONReader;

public class HttpClientTest {

	@Test
	public void httpClientExecute() throws Exception{
		  CloseableHttpClient httpclient = HttpClients.createDefault();
		    HttpGet httpget = new HttpGet("http://www.yeetrack.com/");
		    CloseableHttpResponse response = httpclient.execute(httpget);
		    try {
		    	Locale locale = response.getLocale();
		    	System.out.println(locale.getLanguage());
		    } finally {
		        try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
	}
	
	@Test
    public void httpResponseTest(){
        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");

        System.out.println(response.getProtocolVersion());
        System.out.println(response.getStatusLine().getStatusCode());
        System.out.println(response.getStatusLine().getReasonPhrase());
        System.out.println(response.getStatusLine().toString());
    }
	
	@Test
	public void headerTest(){
		   HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
		    response.addHeader("Set-Cookie", "c1=a; path=/; domain=yeetrack.com");
		    response.addHeader("Set-Cookie", "c2=b; path=\"/\", c3=c; domain=\"yeetrack.com\"");
		    Header h1 = response.getFirstHeader("Set-Cookie");
		    System.out.println(h1);
		    Header h2 = response.getLastHeader("Set-Cookie");
		    System.out.println(h2);
		    Header[] hs = response.getHeaders("Set-Cookie");
		    System.out.println(hs.length);
		    
		    HeaderIterator it = response.headerIterator("Set-Cookie");
		    while (it.hasNext()) {
		    	System.out.println(it.next()); 
		    } 
		    
		    HeaderElementIterator its = new BasicHeaderElementIterator(response.headerIterator("Set-Cookie"));
		    while (its.hasNext()) {
		        HeaderElement elem = its.nextElement(); 
		        System.out.println(elem.getName() + " = " + elem.getValue());
		        NameValuePair[] params = elem.getParameters();
		        for (int i = 0; i < params.length; i++) {
		            System.out.println(" " + params[i]);
		        }
		    }
	}
	
	@Test
	public void httpEntity() throws ParseException, IOException{
		  StringEntity myEntity = new StringEntity("important message", ContentType.create("text/plain", "UTF-8"));
		    System.out.println(myEntity.getContentType());
		    System.out.println(myEntity.getContentLength());
		    System.out.println(EntityUtils.toString(myEntity));
		    System.out.println(EntityUtils.toByteArray(myEntity).length);
		    
	}
	
	@Test
	public void resoureClose() throws Exception{
		
		CloseableHttpClient httpclient =  HttpClients.createDefault();
	    HttpGet httpget = new HttpGet("http://www.yeetrack.com/");
	    CloseableHttpResponse response = httpclient.execute(httpget);
	    try {
	        HttpEntity entity = response.getEntity();
	        if (entity != null) {
	            InputStream instream = entity.getContent();
	            try {
	            	
	            	Thread.currentThread().sleep(10000);
	            	
	            } finally {
	                try {
						instream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
	            }
	        }
	    } finally {
	        try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	}
	
	@Test
	public void fileTransformTest(){
	    File file = new File("somefile.txt");
	    FileEntity entity = new FileEntity(file, ContentType.create("text/plain", "UTF-8"));

	    HttpPost httppost = new HttpPost("http://www.yeetrack.com/action.do");
	    httppost.setEntity(entity);
	}
	
	@Test
	public void formSumbit(){
		 	List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		    formparams.add(new BasicNameValuePair("param1", "value1"));
		    formparams.add(new BasicNameValuePair("param2", "value2"));
		    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		    HttpPost httppost = new HttpPost("http://www.yeetrack.com/handler.do");
		    httppost.setEntity(entity);
		    
		    
		    CloseableHttpClient httpclient =  HttpClients.createDefault();
		    try {
				CloseableHttpResponse response = httpclient.execute(httppost);
				System.out.println(response.getStatusLine());
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	@Test
	public void responseHandlerTest() throws ClientProtocolException, IOException{
		 CloseableHttpClient httpclient = HttpClients.createDefault();
		    HttpGet httpget = new HttpGet("http://www.yeetrack.com/json");

		    ResponseHandler<MyJson> rh = new ResponseHandler<MyJson>() {

		        @Override
		        public MyJson handleResponse(
		            final HttpResponse response) throws IOException {
		            StatusLine statusLine = response.getStatusLine();
		            HttpEntity entity = response.getEntity();
		            if (statusLine.getStatusCode() >= 300) {
		                throw new HttpResponseException(
		                        statusLine.getStatusCode(),
		                        statusLine.getReasonPhrase());
		            }
		            if (entity == null) {
		                throw new ClientProtocolException("Response contains no content");
		            }
		            ContentType contentType = ContentType.getOrDefault(entity);
		            Charset charset = contentType.getCharset();
		            Reader reader = new InputStreamReader(entity.getContent(), charset);
		            JSONReader jsonReader = new JSONReader(reader);
		            return jsonReader.readObject(MyJson.class);
		        }
		    };
		    //设置responseHandler，当执行http方法时，就会返回MyJsonObject对象。
		    MyJson myjson = httpclient.execute(httpget, rh);
	}
	
	@Test
	public void closeableHttpClient(){
		  CloseableHttpClient httpclient = HttpClients.createDefault();
		    try {
		       //
		    } finally {
		        //关闭连接
		        try {
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
	} 
}
