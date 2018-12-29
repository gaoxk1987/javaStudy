/*
 * $Id: UrlSession.java,v 1.21 2015/07/09 09:28:02 wangzl Exp $
 * Copyright(c) 2000-2007 HC360.COM, All Rights Reserved.
 */
package com.bceden.httpclient.b2b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

import com.bceden.httpclient.b2b.url.ConnectionConfParam;
import com.bceden.httpclient.b2b.url.MmtURLParam;

/**
 * class description:这是一个根据传入URL得到网页原码信息的类
 * 
 * @author:
 * 
 * @modifyauthor:zengjuemin
 * 
 * @version:v1.0 Date:2007-3-16
 * 
 */
public class UrlSession {

	private static final Logger logger = Logger.getLogger(UrlSession.class);

	// 链接超时时间 5s
	public static int CONNECT_TIME_OUT = 5000;

	// 读取超时时间 5s
	public static int READ_TIME_OUT = 5000;

	/**
	 * 
	 * Methods Descrip:获得页面源码(对输入流按ISO-8859-1编码处理）
	 * 
	 * @param urlString
	 *            : String——页面地址
	 * @return String——页面源码
	 */
	public static String getHtmlCode(String htmlurl)
			throws MalformedURLException, IOException {
		return getHtmlCode(htmlurl, new MmtURLParam());
	}

	/**
	 * 
	 * Methods Descrip:获得页面源码(对输入流按ISO-8859-1编码处理）
	 * 
	 * @param urlString
	 *            : String——页面地址
	 * @return String——页面源码
	 */
	public static String getHtmlCode(String htmlurl, MmtURLParam param)
			throws MalformedURLException, IOException {
		return getHtmlCode(htmlurl, param, new ConnectionConfParam());
	}
	
    /**
     * 保留原接口逻辑
     */
    public static String getHtmlCode(String htmlurl, MmtURLParam param, ConnectionConfParam conf) throws MalformedURLException, IOException {
        return getHtmlCode(htmlurl, param, conf, false);
    }

	/**
	 * 
	 * Methods Descrip:获得页面源码(对输入流按ISO-8859-1编码处理）
	 * 
	 * @param urlString
	 *            : String——页面地址
	 * @return String——页面源码
	 */
	public static String getHtmlCode(String htmlurl, MmtURLParam param,
			ConnectionConfParam conf, boolean cUpTimeoutable) throws MalformedURLException, IOException {
		long beginTime = System.currentTimeMillis();
		StringBuffer result = new StringBuffer();
		BufferedReader in = null;
		try {
			URL url = new URL(htmlurl);
			
            long starttime = System.currentTimeMillis();
			URLConnection con = url.openConnection();
			con.setRequestProperty("Content-type", "application/json");
            if(System.currentTimeMillis() - starttime > 1000){
            	logger.error(htmlurl + " openConnection cost: " + (System.currentTimeMillis() - starttime) + "milisecond.");
            }
            
			starttime = System.currentTimeMillis();
			in = new BufferedReader(new InputStreamReader(con.getInputStream(),
					param.getCharsetin()));
            if(System.currentTimeMillis() - starttime > 1000){
            	logger.error(htmlurl + " from inputstream read data cost: " + (System.currentTimeMillis() - starttime) + "milisecond.");
        	}
            
			String line = null;

			while ((line = in.readLine()) != null) {
				result.append(line + "\r\n");
			}
			in.close();
		} catch (MalformedURLException e) {
			logger.error("UrlSession.getHtmlCode("+htmlurl+") throw MalformedURLException.",e);
		} catch (SocketTimeoutException e) {
			// shiwenfeng 二期修改(添加计数统计功能)
			logger.error("UrlSession.getHtmlCode("+htmlurl+") throw SocketTimeoutException.",e);
		} catch (IOException e) {
			logger.error("IOException when connecting to URL: " + htmlurl, e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception ex) {
					logger.error("UrlSession.getHtmlCode("+htmlurl+") release io throw exception.",ex);
				}
			}
		}
		
		return result.toString();
	}

	/**
	 * 
	 * Methods Descrip:获得页面源码(对输入流进行字符编码处理）
	 * 
	 * @param urlString
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static String getHtmlCodeUnCharset(String urlString, String chartSet)
			throws MalformedURLException, IOException {
		long beginTime = System.currentTimeMillis();
		if (chartSet == null || "".equals(chartSet)) {
			chartSet = B2BConstants.CHARTSET_ISO;
		}

		StringBuffer result = new StringBuffer();
		BufferedReader in = null;

		try {
			URL url = new URL(urlString);
			URLConnection con = url.openConnection();

			in = new BufferedReader(new InputStreamReader(con.getInputStream(),
					B2BConstants.CHARTSET_UTF8));
			String line = null;
			while ((line = in.readLine()) != null) {
				result.append(line + "\r\n");
			}
			in.close();
		} catch (MalformedURLException e) {
			logger.error("Unable to connect to URL: " + urlString, e);
		} catch (SocketTimeoutException e) {
			logger.error("Timeout Exception when connecting to URL: "
					+ urlString, e);
		} catch (IOException e) {
			logger.error("IOException when connecting to URL: " + urlString, e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception ex) {
					logger.error(
							"Exception throws at finally close reader when connecting to URL: "
									+ urlString, ex);
				}
			}
		}
		
		return result.toString();
	}

	/**
	 * 
	 * Methods Descrip:获得页面源码(不对输入流进行字符编码处理）
	 * 
	 * @param urlString
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static String getHtmlCodeUnCharset(String urlString)
			throws MalformedURLException, IOException {
		long beginTime = System.currentTimeMillis();
		StringBuffer result = new StringBuffer();
		BufferedReader in = null;

		try {
			URL url = new URL((urlString));
			URLConnection con = url.openConnection();

			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;
			while ((line = in.readLine()) != null) {
				result.append(line + "\r\n");
			}
			in.close();
		} catch (MalformedURLException e) {
			logger.error("Unable to connect to URL: " + urlString, e);
		} catch (SocketTimeoutException e) {
			logger.error("Timeout Exception when connecting to URL: "
					+ urlString, e);
		} catch (IOException e) {
			logger.error("IOException when connecting to URL: " + urlString, e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception ex) {
					logger.error(
							"Exception throws at finally close reader when connecting to URL: "
									+ urlString, ex);
				}
			}
		}
		return result.toString();
	}

	/**
	 * 通过post方式获取页面源码
	 * 
	 * @param urlString
	 *            url地址
	 * @param paramContent
	 *            需要post的参数
	 * @param chartSet
	 *            字符编码（默认为ISO-8859-1）
	 * @return
	 * @throws IOException
	 */
	public static String postUrl(String urlString, String paramContent,
			String chartSet) throws MalformedURLException, IOException{
				return postUrl(urlString, paramContent,chartSet,null);
		
	}
	/**
	 * 通过post方式获取页面源码
	 * 
	 * @param urlString
	 *            url地址
	 * @param paramContent
	 *            需要post的参数
	 * @param chartSet
	 *            字符编码（默认为ISO-8859-1）
	 * @return
	 * @throws IOException
	 */
	public static String postUrl(String urlString, String paramContent,
			String chartSet,String contentType) throws MalformedURLException, IOException {
		long beginTime = System.currentTimeMillis();
		if (chartSet == null || "".equals(chartSet)) {
			chartSet = B2BConstants.CHARTSET_ISO;
		}
		
		StringBuffer result = new StringBuffer();
		BufferedReader in = null;

		try {
			URL url = new URL((urlString));
			URLConnection con = url.openConnection();

			// 设置参数
			con.setDoOutput(true);
			if(contentType != null && !"".equals(contentType)){
				con.setRequestProperty("Content-type", contentType);
			}
			
			OutputStreamWriter writer = new OutputStreamWriter(
					con.getOutputStream(), chartSet);
			writer.write(paramContent);
			writer.flush();
			writer.close();
			in = new BufferedReader(new InputStreamReader(con.getInputStream(),
					chartSet));
			String line = null;
			while ((line = in.readLine()) != null) {
				result.append(line + "\r\n");
			}
			in.close();
		} catch (MalformedURLException e) {
			logger.error("Unable to connect to URL: " + urlString, e);
		} catch (SocketTimeoutException e) {
			logger.error("Timeout Exception when connecting to URL: "
					+ urlString, e);
		} catch (IOException e) {
			logger.error("IOException when connecting to URL: " + urlString, e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception ex) {
					logger.error(
							"Exception throws at finally close reader when connecting to URL: "
									+ urlString, ex);
				}
			}
		}
	
		return result.toString();
	}

	/**
	 * UrlConnectionUtil抽出
	 * 
	 * @param url
	 * @param chartSet
	 * @return
	 * @throws MmtException
	 */
	public static int getConnection(String url, String chartSet)
			throws MalformedURLException, IOException {
		long beginTime = System.currentTimeMillis();
		int i = 0;
		if (chartSet == null || "".equals(chartSet))
			chartSet = B2BConstants.CHARTSET_ISO;
		BufferedReader bw = null;

		try {
			URLConnection con = (URLConnection) new URL(url).openConnection();

			bw = new BufferedReader(new InputStreamReader(con.getInputStream(),
					chartSet));
			i = 1;
		} catch (Exception e) {
			logger.error("Unable to connect to URL: " + url, e);
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				logger.error(
						"Exception throws at finally close reader when connecting to URL: "
								+ url, e);
			}
		}
		return i;
	}

	/**
	 * 
	 * Methods Descrip:获得页面源码(不对输入流进行字符编码处理）
	 * 
	 * @param urlString
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static String getHtmlCodeUnCharset(String urlString,
			int connectTimeOut, int readTimeOut) throws MalformedURLException,
			IOException {
		long beginTime = System.currentTimeMillis();
		StringBuffer result = new StringBuffer();
		BufferedReader in = null;


		try {
			URL url = new URL(urlString);

			URLConnection con = url.openConnection();
			// 设置链接超时
			con.setConnectTimeout(connectTimeOut);
			// 设置读取超时
			con.setReadTimeout(readTimeOut);
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;
			while ((line = in.readLine()) != null) {
				result.append(line + "\r\n");
			}
			in.close();
		} catch (MalformedURLException e) {
			logger.error("Unable to connect to URL: " + urlString, e);
		} catch (SocketTimeoutException e) {
			logger.error("Timeout Exception when connecting to URL: "
					+ urlString, e);
		} catch (IOException e) {
			logger.error("IOException when connecting to URL: " + urlString, e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception ex) {
					logger.error(
							"Exception throws at finally close reader when connecting to URL: "
									+ urlString, ex);
				}
			}
		}
		return result.toString();
	}
	
	

	
	public static void main(String[] args) throws MalformedURLException, IOException {
		String p = "{'user_name':'haomeng500','client_enterprise_name':'haomeng500','client_access_token':'955472f9-873c-42e3-9f47-a84c7bb95188','legal_person_mobile':'13112345678','user_address':'中国','user_mobile':'13112345678','legal_person_name':'测试','client_uid':'31043347','client_enterprise_account':'haomeng500'}";
//		p = URLEncoder.encode(p, "UTF-8");
		System.out.println(p);
		String a = UrlSession.postUrl("http://open.fsfte.com/api/bind/enterprise_entry",p,"UTF-8","application/json");
		
		System.out.println(a);
	}
}
