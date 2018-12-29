
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: ����3:23:12
 * Version: 1.0
 *
 */

package com.bceden.json.fastjson;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-5-27 ����3:23:12   
 */

public class Test {

	/**
	 * 
	 * @author Gao xingkun
	 * @version 1.0
	 * @date 2014-5-27 ����3:23:12
	 * @param args void
	 */

	public static void main(String[] args) {
		Firend firstF = new Firend("С��","��");
		Firend secondF = new Firend("С��","Ů");
		User user = new User();
		user.setName("�Ϲ�");
		user.setSex("����");
		List<Firend> fList = new ArrayList<Firend>();
		fList.add(firstF);
		fList.add(secondF);
		user.setFirends(fList);
		
		String str =JSONObject.toJSONString(user);
		System.out.println(str);
		
		User user2 = JSONObject.parseObject(str, User.class);
		List<Firend> fList2 = user2.getFirends();
		for(Firend fir:fList2){
			System.out.println(fir.getName());
			System.out.println(fir.getSex());
			System.out.println("-----------------------------------------------------");
		}

	}

}
