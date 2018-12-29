package com.selfActualization.concurrent.test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Configure {
	
	private static Map<String,String> recharge2amountMap  = new  ConcurrentHashMap<String,String>();
	
	/**
	 * 
	 * 1个线程并发写 3个线程并发读  会报java.util.ConcurrentModificationException异常
	 */
//	private static List<TestVo> rechargeVoList = new ArrayList<TestVo>();
	private static List<TestVo> rechargeVoList = new CopyOnWriteArrayList<TestVo>();
	
	
	static {
		//系统启动时初始化监听配置文件
		init();
	}
	
	public static void init(){
		//注册通知事件处理器
		
		String[] array = {"1:1","2:2","3:3","4:4","5:5","6:6","7:7","8:8"};
		//下载配置文件 
		initRechargeConf(array);		
	}
	
	/**
	 * 
	 * @author hk
	 * @version 1.0.0
	 * @date 2017-4-24 下午12:20:30
	 * 
	* P4P充值金额和赠送金额列表初始化
	* #充值列表=待充值金额1:赠送虚拟金额1:充值类型;待充值金额2:赠送虚拟金额2:充值类型;.....
	 * recharge_list=1000:0:1;2000:0:2;4000:400:3;5000:600:4;8000:1000:5;10000:1200:6
	 * 
	 */
	public static void initRechargeConf(String[] array){
	try{
			
			if(array !=null){
					//清除历史数据
					if(array.length>0){
						recharge2amountMap.clear();
						rechargeVoList.clear();
					}
					for (int i = 0; i < array.length; i++) {
						String[] chargeArray = array[i].split(":");
						if(chargeArray!= null && chargeArray.length>1){
							TestVo testVo = new TestVo(chargeArray[0], chargeArray[1]);
							recharge2amountMap.put(chargeArray[0], chargeArray[1]);
							rechargeVoList.add(testVo);
						}
					}
			}else{
				recharge2amountMap.clear();
				rechargeVoList.clear();
			}
		
	}catch(Exception e){
		System.out.println("从配置管理中心读取champion_recharge.properties异常.");
	}
 }

	public static Map<String, String> getRecharge2amountMap() {
		return recharge2amountMap;
	}

	public static List<TestVo> getRechargeVoList() {
		return rechargeVoList;
	}
	
}
