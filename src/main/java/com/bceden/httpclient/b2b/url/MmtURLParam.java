
package com.bceden.httpclient.b2b.url;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.bceden.httpclient.b2b.B2BConstants;

public class MmtURLParam {
	/** 默认对输入流按ISO-8859-1编码处理 */
	private String charsetin =  B2BConstants.CHARTSET_ISO;
	/** 默认对输出流按GBK 编码处理 */
	private String charsetout =  B2BConstants.CHARTSET_GBK;
	/** 默认链接超时时间 5s */
    public int CONNECT_TIME_OUT=5000;
    /** 默认读取超时时间 5s */
    public int READ_TIME_OUT=5000;
    /** 节点IP */
    public String IP;

	
	/** 连接url */
	private String socektHost;
	/** 端口号 */
	private int post;
	
    /** 搜索条件 */
	private Map<String,String> param = new HashMap();
	
	/** 格式化接口 */
	private MmtParser parser ;
	
	public String getSocektHost() {
		return socektHost;
	}

	public void setSocektHost(String socektHost) {
		this.socektHost = socektHost;
	}

	public int getPost() {
		return post;
	}

	public void setPost(int post) {
		this.post = post;
	}

	public void add(String key,String value){
		param.put(key, value);
	}
	
	public void get(String key){
		param.get(key);
	}
	
	public Iterator getIterator(){
	
		return param.entrySet().iterator();
	}
	
//	public void getValues(){
//		Iterator it = getIterator();
//		while (it.hasNext()) {
//			    Map.Entry entry = (Map.Entry) it.next();
//			    Object key = entry.getKey();
//			    Object value = entry.getValue();
//			    System.out.println("key=" + key + " value=" + value);
//		}
//	}



	public String getCharsetin() {
		return charsetin;
	}

	public void setCharsetin(String charsetin) {
		this.charsetin = charsetin;
	}

	public String getCharsetout() {
		return charsetout;
	}

	public void setCharsetout(String charsetout) {
		this.charsetout = charsetout;
	}

	public int getCONNECT_TIME_OUT() {
		return CONNECT_TIME_OUT;
	}

	public void setCONNECT_TIME_OUT(int connect_time_out) {
		CONNECT_TIME_OUT = connect_time_out;
	}

	public int getREAD_TIME_OUT() {
		return READ_TIME_OUT;
	}

	public void setREAD_TIME_OUT(int read_time_out) {
		READ_TIME_OUT = read_time_out;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String ip) {
		IP = ip;
	}

	public Map<String, String> getParam() {
		return param;
	}

	public void setParam(Map<String, String> param) {
		this.param = param;
	}

	public MmtParser getParser() {
		return parser;
	}

	public void setParser(MmtParser parser) {
		this.parser = parser;
	}
	

}
