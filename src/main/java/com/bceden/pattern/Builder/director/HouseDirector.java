
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 上午11:40:23
 * Version: 1.0
 *
 */

package com.bceden.pattern.Builder.director;

import com.bceden.pattern.Builder.model.House;
import com.bceden.pattern.Builder.service.IHouseBuilder;

/**
 * 
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-8-27 上午11:40:23   
 */

public class HouseDirector {
	public House buildHouse(IHouseBuilder builder){
        /**
         * 建造房门
         */
        builder.buildDoor();
        /**
         * 建造地板
         */
        builder.buildFloor();
        /**
         * 建造墙壁
         */
        builder.buildWall();
        /**
         * 建造窗户
         */
        builder.buildWindows();
        
        return builder.getHouse();
    }
}
