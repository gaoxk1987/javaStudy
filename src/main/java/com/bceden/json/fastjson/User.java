package com.bceden.json.fastjson;

import java.util.List;

public class User {
	private String name;
	private String sex;
	private List<Firend> firends;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public List getFirends() {
		return firends;
	}
	public void setFirends(List firends) {
		this.firends = firends;
	}
}