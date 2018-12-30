
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: ����2:39:53
 * Version: 1.0
 *
 */

package com.bceden.pattern.Observer;

/**
 * Subject�ӿ�
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-8-26 ����2:39:53   
 */

public interface Subject {
	public void registerObserver(Observer observer);
	public void removeObserver(Observer observer);
	public void notifyAllObservers();

}
