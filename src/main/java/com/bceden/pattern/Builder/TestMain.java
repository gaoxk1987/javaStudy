/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 上午11:40:50
 * Version: 1.0
 *
 */

package com.bceden.pattern.Builder;

import com.bceden.pattern.Builder.director.HouseDirector;
import com.bceden.pattern.Builder.model.House;
import com.bceden.pattern.Builder.service.BritishStyleHouseBuilderImpl;
import com.bceden.pattern.Builder.service.ChinaStyleHouseBuilderImpl;
import com.bceden.pattern.Builder.service.IHouseBuilder;

/**
 *
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-8-27 上午11:40:50   
 */

public class TestMain {

	public static void main(String [] args){
		IHouseBuilder cbuilder = new ChinaStyleHouseBuilderImpl();
		House chouse = new HouseDirector().buildHouse(cbuilder);
		System.out.println("------------------------------");
		System.out.println("房门属性：" + chouse.getDoor());
		System.out.println("墙壁属性：" + chouse.getWall());
		System.out.println("天花板属性：" + chouse.getFloor());
		System.out.println("窗户属性：" + chouse.getWindows());
		System.out.println("------------------------------");
		IHouseBuilder ebuilder = new BritishStyleHouseBuilderImpl();
		House ehouse = new HouseDirector().buildHouse(ebuilder);
		System.out.println("房门属性：" + ehouse.getDoor());
		System.out.println("墙壁属性：" + ehouse.getWall());
		System.out.println("天花板属性：" + ehouse.getFloor());
		System.out.println("窗户属性：" + ehouse.getWindows());
		System.out.println("------------------------------");
	}

}