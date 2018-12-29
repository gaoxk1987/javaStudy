package com.bceden.httpclient.commons;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.Logger;

public class HttpUtils {

	private static final Logger logger = Logger.getLogger(HttpUtils.class);

	public static final String sendRequest(String url,NameValuePair[] paramsList, String encoding, int timeout)
			throws Exception {
		
		String result ="";
		HttpClient httpClient = null;
		if ((url == null) || ("".equals(url))) {
			throw new NullPointerException("url empty");
		}
		if (paramsList == null) {
			throw new NullPointerException("paramsList empty");
		}
		if ((encoding == null) || ("".equals(encoding))) {
			encoding = "UTF-8";
		}
		if (timeout <= 0) {
			timeout = 5000;
		}

		PostMethod postMethod = new PostMethod(url);
		postMethod.getParams().setContentCharset(encoding);
		postMethod.getParams().setHttpElementCharset(encoding);
		postMethod.setRequestHeader("Connection", "close");

		postMethod.setRequestBody(paramsList);

		httpClient = new HttpClient();
		httpClient.getHttpConnectionManager().getParams()
				.setConnectionTimeout(timeout);
		httpClient.getHttpConnectionManager().getParams().setSoTimeout(timeout);
		try {
			httpClient.executeMethod(postMethod);
			if (postMethod.getStatusCode() == 200) {
				result = postMethod.getResponseBodyAsString();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
			logger.error("HttpUtils error ...", e);
			throw e;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			logger.error("HttpUtils error ...", e);
			throw e;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			logger.error("HttpUtils error ...", e);
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("HttpUtils error ...", e);
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("HttpUtils error ...", e);
			throw e;
		} finally {
			postMethod.releaseConnection();
			httpClient.getHttpConnectionManager().closeIdleConnections(0);
		}
		return result;
	}
	
}