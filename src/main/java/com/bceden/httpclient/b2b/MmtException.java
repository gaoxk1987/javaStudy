/*
 * $Id: MmtException.java,v 1.5 2013/12/03 02:26:20 zhaolei Exp $
 * Copyright(c) 2000-2007 HC360.COM, All Rights Reserved.
 */
package com.bceden.httpclient.b2b;

import java.util.Map;

/**
 * 应用级别的异常
 * @author sunbaoming@hc360.com
 *
 */
public class MmtException extends Exception {
	private static final long serialVersionUID = 1L;

	/**MMT的错误编码*/
	private String errorcode;
		
	/**错误出现时的上下文*/
	private Map context;
	
	/**是否被记录的标志0表示未被标记*/
	private int flag=0;
	
	/**
	 * 构造函数
	 * @param errorMsg 错误编码
	 * @author Zhaosy 手工抛出异常重载构造
	 */
	public MmtException(String errorMsg) {
		super(errorMsg);
		this.errorcode = errorMsg;
	}
	
	/**
	 * 
	 * @param errorMsg
	 * @param ex
	 */
	public MmtException(String errorMsg, Throwable ex){
		super(errorMsg,ex);	
		this.errorcode = errorMsg;		
	}
	
	/**
	 * 
	 * @param errorMsg
	 * @param context
	 * @param ex
	 */
	public MmtException(String errorMsg, Map context,Throwable ex){
		super(errorMsg,ex);
		this.errorcode = errorMsg;
		this.context = context;
	}
	
	/**
	 * @return Returns the context.
	 */
	public Map getContext() {
		return context;
	}

	/**
	 * @param context The context to set.
	 */
	public void setContext(Map context) {
		this.context = context;
	}

	/**
	 * @return Returns the errorcode.
	 */
	public String getErrorcode() {
		return errorcode;
	}

	/**
	 * @return Returns the flag.
	 */
	public int getFlag() {
		return flag;
	}

	/**
	 * @param flag The flag to set.
	 */
	public void setFlag(int flag) {
		this.flag = flag;
	}
}