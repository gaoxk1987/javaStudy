package com.bceden.beancopy.spring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.bceden.beancopy.vo.SourceVo;
import com.bceden.beancopy.vo.TargetVo;


public class SpringBeanutil {
	
	public static void main(String[] args) {
		long totalArray =0;
		
		//先预热100000次
		for(int i=0;i<100000;i++){
			SpringBeanutilTest();
//			System.out.println("当前预热次数："+i);
		}
		
		//实测时间
		for(int i=0;i<1000000;i++){
			totalArray+=SpringBeanutilTest();
		}
//		System.out.println("当前实测次数："+i);
		System.out.println("100万次SpringBeanUtils.copyProperties总耗时："+totalArray+"秒");

		System.out.println("100万次SpringBeanUtils.copyProperties平均耗时："+totalArray/1000000+"秒");
	}
	
	public static long SpringBeanutilTest(){
		SourceVo sVo = new SourceVo();
		sVo.setName("张三");
		sVo.setMin(1);
		sVo.setNum(2);
		sVo.setPublish(new Date());
		List<String> fdList = new ArrayList<String>();
		fdList.add("李四");
		fdList.add("韩梅梅");
		sVo.setFriend(fdList);
		
		TargetVo tVo = new TargetVo();
		long totalTime =0;
		Long startTime = System.currentTimeMillis();
		BeanUtils.copyProperties(tVo, sVo);
		Long endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		return totalTime;
	}
}
