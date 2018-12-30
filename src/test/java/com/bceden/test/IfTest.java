package com.bceden.test;

import org.apache.commons.lang3.StringUtils;

public class IfTest {

	public static void main(String[] args) {
		if (StringUtils.isNotBlank("6666") //有运单号
				&& ("4".equals("6")||"6".equals("6")||"7".equals("6"))) {//运输中、已签收、签收异常
			System.out.println("啦啦啦啦啦all水电费");
		}

	}

}