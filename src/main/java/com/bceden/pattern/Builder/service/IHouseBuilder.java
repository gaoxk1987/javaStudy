
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: ����11:37:49
 * Version: 1.0
 *
 */

package com.bceden.pattern.Builder.service;

import com.bceden.pattern.Builder.model.House;

/**
 * 
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-8-27 ����11:37:49   
 */

public interface IHouseBuilder {
	/**
     * ����ǽ��
     */
    public void buildWall();
    
    /**
     * ���췿��
     */
    public void buildDoor();
    
    /**
     * ����ذ�
     */
    public void buildFloor();
    
    /**
     * ���촰��
     * @return
     */
    public void buildWindows();
    
    /**
     * ���ش�����ɵĶ���
     * @return
     */
    public House getHouse();
}
