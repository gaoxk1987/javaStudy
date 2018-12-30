package com.bceden.curator.zkbook;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

public class NodeSample {
	static String path="/projectx/modulex/1.0.0/property-group1";
	static CuratorFramework client = CuratorFrameworkFactory.builder()
			.connectString("121.42.43.122:2181")
			.sessionTimeoutMs(3000)
			.retryPolicy(new ExponentialBackoffRetry(1000,3))
			.build();
	 static NodeCache cache = null;
	 
	public static void main(String[] args) {
		init();
		
		try {
			//创建节点
			createNode();
			//增加节点监听
//			addNodeListener();
			//读取节点
			getData();
			//更新节点
//			setData();
			//读取节点
//			getData();
			//删除节点
//			delData();
			//读取节点
//			getData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void init (){
		client.start();
		cache= new NodeCache(client, path,false);
	}
	
	
	static void createNode() throws Exception{
		client.create()
		.creatingParentsIfNeeded()
//		.withMode(CreateMode.EPHEMERAL)
		.withMode(CreateMode.PERSISTENT)
//		.forPath(path,"/1.0.0/property-group1".getBytes());
		.forPath(path);
		System.out.println("创建节点成功！");
	}
	
	static void getData() throws Exception{
		Stat stat = new Stat();
		System.out.println("读取到数据："+new String(client.getData().storingStatIn(stat).forPath(path)));
		System.out.println("读到的版本号："+stat.getVersion()+","+stat.getCversion());
	}
		
	static void delData() throws Exception{
		Stat stat = new Stat();
		client.getData().storingStatIn(stat).forPath(path);
		client.delete().deletingChildrenIfNeeded().withVersion(stat.getVersion()).forPath(path);
	}	
	
	static void setData() throws Exception{
		Stat stat = new Stat();
		client.getData().storingStatIn(stat).forPath(path);
		System.out.println("");
		client.setData().withVersion(stat.getVersion()).forPath(path,"yes! very good!".getBytes());
	}

	static void addNodeListener() throws Exception{
		cache.start(true);
		cache.getListenable().addListener(new NodeListener());
	}
	
	static class NodeListener implements NodeCacheListener{

		@Override
		public void nodeChanged() throws Exception {
			System.out.println("Node data 更新啦！监听到了！");
			System.out.println("更新后内容为："+new String(cache.getCurrentData().getData()));
		}
		
	}
}