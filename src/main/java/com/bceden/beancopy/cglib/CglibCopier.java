package com.bceden.beancopy.cglib;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.cglib.beans.BeanCopier;

import com.bceden.beancopy.vo.SourceVo;
import com.bceden.beancopy.vo.TargetVo;


public class CglibCopier {
	
	public static void main(String[] args) {
			long totalArray =0;
			
			//先预热100000次
			for(int i=0;i<100000;i++){
				cglibCopyTest();
//				System.out.println("当前预热次数："+i);
			}
			
			for(int i=0;i<1000000;i++){
				totalArray+=cglibCopyTest();
			}
//			System.out.println("当前实测次数："+i);
		System.out.println("100万次beanCopier.copy总耗时："+totalArray+"秒");
		System.out.println("100万次beanCopier.copy平均耗时："+totalArray/1000000+"秒");
	}
	
	public static long cglibCopyTest(){
		SourceVo sVo = new SourceVo();
//		sVo.setName("张三");
		sVo.setMin(1);
		sVo.setNum(2);
		sVo.setPublish(new Date());
		List<String> fdList = new ArrayList<String>();
		fdList.add("李四");
		fdList.add("韩梅梅");
		sVo.setFriend(fdList);
		
		TargetVo tVo = new TargetVo();
		tVo.setName("1231");
		System.out.println(tVo.getName());
		Long startTime = System.currentTimeMillis();
		BeanCopier beanCopier = BeanCopier.create(SourceVo.class,TargetVo.class, false); 
		beanCopier.copy(sVo, tVo, null); 
		System.out.println(tVo.getName());
//		handle(sVo, tVo);
		Long endTime = System.currentTimeMillis();
		
		return (endTime - startTime);
	}
}
