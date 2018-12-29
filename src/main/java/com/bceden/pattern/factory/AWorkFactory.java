
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: обнГ3:03:27
 * Version: 1.0
 *
 */

package com.bceden.pattern.factory;

/**
 * 
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-9-5 обнГ3:03:27   
 */

public class AWorkFactory implements IWorkFactory {

	@Override
	public IWork creatWork() {
		return new AWork();
	}

}
