/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 上午11:38:40
 * Version: 1.0
 *
 */

package com.bceden.pattern.Builder.service;

import com.bceden.pattern.Builder.model.ChinaStyleHouse;
import com.bceden.pattern.Builder.model.House;

/**
 *
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-8-27 上午11:38:40   
 */

public class ChinaStyleHouseBuilderImpl implements IHouseBuilder {

    public House house = new ChinaStyleHouse();

    @Override
    public void buildDoor() {
        house.setDoor("中式风格房门");
    }

    @Override
    public void buildFloor() {
        house.setFloor("中式风格地板");
    }

    @Override
    public void buildWall() {
        house.setWall("中式风格墙壁");
    }

    @Override
    public void buildWindows() {
        house.setWindows("中式风格门窗");
    }

    @Override
    public House getHouse() {
        return house;
    }

}