
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: обнГ2:50:17
 * Version: 1.0
 *
 */

package com.bceden.pattern.Observer;

/**
 * 
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-8-26 обнГ2:50:17   
 */

public class JobSeeker implements Observer {

	private String name;

	public JobSeeker(String name){
		this.name = name;
	}

	@Override
	public void update(Subject subject) {
		System.out.println(this.name + " got notified!");
		System.out.println(subject);
	}

}
