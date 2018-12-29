
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: ����11:40:50
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
 * @date 2014-8-27 ����11:40:50   
 */

public class TestMain {

	 public static void main(String [] args){
	        IHouseBuilder cbuilder = new ChinaStyleHouseBuilderImpl();
	        House chouse = new HouseDirector().buildHouse(cbuilder);
	        System.out.println("------------------------------");
	        System.out.println("�������ԣ�" + chouse.getDoor());
	        System.out.println("ǽ�����ԣ�" + chouse.getWall());
	        System.out.println("�컨�����ԣ�" + chouse.getFloor());
	        System.out.println("�������ԣ�" + chouse.getWindows());
	        System.out.println("------------------------------");
	        IHouseBuilder ebuilder = new BritishStyleHouseBuilderImpl();
	        House ehouse = new HouseDirector().buildHouse(ebuilder);
	        System.out.println("�������ԣ�" + ehouse.getDoor());
	        System.out.println("ǽ�����ԣ�" + ehouse.getWall());
	        System.out.println("�컨�����ԣ�" + ehouse.getFloor());
	        System.out.println("�������ԣ�" + ehouse.getWindows());
	        System.out.println("------------------------------");
	    }

}
