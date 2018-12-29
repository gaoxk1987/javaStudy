package com.bceden.zookeeper.zkClient;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZkClientTest {
	
	 static ZooKeeper zk = null;
	 static{
			// 创建一个与服务器的连接 需要(服务端的 ip+端口号)(session过期时间)(Watcher监听注册) 
//			 zk = new ZooKeeper("121.42.43.122:2181,www.baidu.com:2181", 
		 try {
//			zk = new ZooKeeper("121.42.43.122:2181",
		zk = new ZooKeeper("127.0.0.1:2181",
				        3000, new Watcher() { 
				            // 监控所有被触发的事件
							public void process(WatchedEvent event) {
								// TODO Auto-generated method stub
								System.out.println("已经触发了" + event.getType() + "事件！"); 
							} 
				  });
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
			 
	

	public static void main(String[] args)  {
	
		try {
			Stat stat = new Stat();
			  List<String> children = zk.getChildren("/zookeeper/quota",true);
			  zk.setData("/zookeeper/quota", "aaa".getBytes(), -1);
			  byte[] data = zk.getData("/zookeeper/quota",true,stat);
			  System.out.println(new String(data));
			
			  System.out.println(stat.getCversion());
			  System.out.println(stat.getNumChildren());
			  System.out.println(stat.getVersion());
			System.out.println(children);
//			zk.delete("/zookeeper", -1);
			zk.delete("/zookeeper/quota", -1);
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		zookeeper, disconf, zk-book, uncode
//		deleteAll("/");
		
		
		
		
		
		
		
		
		
		
//			try {
//						 
//				//创建之前先删除节点子节点 负责会报不能删除
//				List<String> children = zk.getChildren("/testRootPath",true);
////				List<String> children = zk.getChildren("/",true);
//				System.out.println("-----------------------------------");
//				System.out.println("-----------------------------------");
//				if(children!=null){
//					for (Iterator iterator = children.iterator(); iterator
//							.hasNext();) {
//						String string = (String) iterator.next();
//						System.out.println(string);
//						if(children==null){
//							 zk.delete("/"+string, -1);	 
//						}					
//					}
//				}
////				Thread.currentThread().sleep(5000);
//				 zk.delete("/testRootPath", -1);	 
//				 // 创建一个目录节点
//				 /**
//				  * CreateMode:
//				  * 	PERSISTENT (持续的，相对于EPHEMERAL，不会随着client的断开而消失)
//				  *		PERSISTENT_SEQUENTIAL（持久的且带顺序的）
//				  *		EPHEMERAL (短暂的，生命周期依赖于client session)
//				  *		EPHEMERAL_SEQUENTIAL  (短暂的，带顺序的)
//				  */
//				 zk.create("/testRootPath", "testRootData".getBytes(), Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT); 
//				 
//				 // 创建一个子目录节点
//				 zk.create("/testRootPath/testChildPathOne", "testChildDataOne".getBytes(),Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT); 
//				 System.out.println(new String(zk.getData("/testRootPath",false,null))); 
//				 
//				 // 取出子目录节点列表
//				 System.out.println(zk.getChildren("/testRootPath",true)); 	
//				 
//				 // 创建另外一个子目录节点
//				 zk.create("/testRootPath/testChildPathTwo", "testChildDataTwo".getBytes(), Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT); 		 
//				 System.out.println(zk.getChildren("/testRootPath",true)); 	
//				 
//				// 修改子目录节点数据
//				 zk.setData("/testRootPath/testChildPathOne","hahahahaha".getBytes(),-1); 	 		 
//				 byte[] datas = zk.getData("/testRootPath/testChildPathOne", true, null);
//				 String str = new String(datas,"utf-8");
//				 System.out.println(str); 	
//				 
//				 //删除整个子目录   -1代表version版本号，-1是删除所有版本
//				 zk.delete("/testRootPath/testChildPathOne", -1);	 
//				 System.out.println(zk.getChildren("/testRootPath",true)); 
//				 System.out.println(str);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
	}
	
	public  static boolean deleteAll(String path){
		if(path==null || "".equals(path)){
			path = "/";
		}
		try {
			List<String> children = zk.getChildren(path,true);
			System.out.println("-----------------------------------"+children);
			if(children!=null){
				for (Iterator iterator = children.iterator(); iterator
						.hasNext();) {
					String childrenPath = (String) iterator.next();
					if(!path.endsWith("/")){
						path =path +"/";
					}
					System.out.println("当前节点："+path+childrenPath);
					List<String> children2 = zk.getChildren(path+childrenPath,true);
					if(children2!=null && children2.size()>0){
						System.out.println("查找其子节点"+path+childrenPath);
						deleteAll(path+childrenPath);
					}
					System.out.println("删除节点"+path+childrenPath);
					zk.delete(path+childrenPath, -1);
				}
			}
		} catch (KeeperException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	
		return false;
	}
}
