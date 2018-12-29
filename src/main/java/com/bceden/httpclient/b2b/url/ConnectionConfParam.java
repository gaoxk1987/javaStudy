
package com.bceden.httpclient.b2b.url;

public class ConnectionConfParam {
	private String id;
	private String url;
	private boolean isread;
	private String type;
	private int connect_time_out = 5000;
	private int read_time_out = 5000;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isIsread() {
		return isread;
	}
	public void setIsread(boolean isread) {
		this.isread = isread;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getConnect_time_out() {
		return connect_time_out;
	}
	public void setConnect_time_out(int connect_time_out) {
		this.connect_time_out = connect_time_out;
	}
	public int getRead_time_out() {
		return read_time_out;
	}
	public void setRead_time_out(int read_time_out) {
		this.read_time_out = read_time_out;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
