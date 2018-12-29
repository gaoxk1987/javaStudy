
package com.bceden.httpclient.b2b.url;

public abstract class MmtURLResult {
	/** 公用的返回值*/
	private String result;

	/** 格式解析类  */
	private Object analyze;
	
	
	public Object getAnalyze() {
		return analyze;
	}

	public void setAnalyze(Object analyze) {
		this.analyze = analyze;
	}

	protected String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	/** 返回文本 */
	public abstract String getText();
	/** 返回XML */
	public abstract Object getXML();
	/** 返回JSON */
	public abstract Object getJSon();
	/** 返回boolean */
	public abstract Boolean getBoolean();
	
}
