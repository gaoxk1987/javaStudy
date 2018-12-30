/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 上午11:37:49
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
 * @date 2014-8-27 上午11:37:49   
 */

public interface IHouseBuilder {
    /**
     * 建造墙壁
     */
    public void buildWall();

    /**
     * 建造房门
     */
    public void buildDoor();

    /**
     * 建造地板
     */
    public void buildFloor();

    /**
     * 建造窗户
     * @return
     */
    public void buildWindows();

    /**
     * 返回创造完成的对象
     * @return
     */
    public House getHouse();
}