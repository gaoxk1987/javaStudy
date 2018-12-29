package com.selfActualization.concurrent.test;

import java.util.Random;

public class TestVo {
	
	private String key;
	private String value;
	
	
	public TestVo(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "TestVo [key=" + key + ", value=" + value + "]";
	}
	
	public static void main(String[] args) {
		while(true){
			Random random = new Random();
			int key = random.nextInt(4);
			System.out.println(key);
		}
	}
}
