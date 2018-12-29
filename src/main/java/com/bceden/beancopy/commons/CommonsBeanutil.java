package com.bceden.beancopy.commons;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import com.bceden.beancopy.vo.SourceVo;
import com.bceden.beancopy.vo.TargetVo;


public class CommonsBeanutil {
	
	public static void main(String[] args) {
		long totalArray =0;
		
		//先预热100000次
		for(int i=0;i<100000;i++){
			CommonsBeanutilTest();
		}
		//统计时间
		for(int i=0;i<1000000;i++){
			totalArray+=CommonsBeanutilTest();
//			System.out.println("当前实测次数："+i);
		}
		
		System.out.println("100万次BeanUtils.copyProperties总耗时："+totalArray+"秒");
		System.out.println("100万次BeanUtils.copyProperties平均耗时："+totalArray/1000000+"秒");
		/*******************************BeanUtils结束******************************************/
		
		/*******************************PropertyUtils开始******************************************/
		totalArray =0;
		//先预热100000次
		for(int i=0;i<100000;i++){
			PropertyUtilsTest();
//			System.out.println("当前预热次数："+i);
		}
		//统计时间
		for(int i=0;i<1000000;i++){
			totalArray+=PropertyUtilsTest();
//			System.out.println("当前实测次数："+i);
		}
		
		System.out.println("100万次PropertyUtils.copyProperties总耗时："+totalArray+"秒");
		System.out.println("100万次PropertyUtils.copyProperties平均耗时："+totalArray/1000000+"秒");
		/*******************************PropertyUtils结束******************************************/
	}
	
	public static long CommonsBeanutilTest(){
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
		try {
			Long startTime = System.currentTimeMillis();
			BeanUtils.copyProperties(tVo, sVo);
			Long endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return totalTime;
	}
	public static long PropertyUtilsTest(){
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
		try {
			Long startTime = System.currentTimeMillis();
			PropertyUtils.copyProperties(tVo, sVo);
			Long endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return totalTime;
	}
}
