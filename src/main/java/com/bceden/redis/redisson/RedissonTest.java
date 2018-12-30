package com.bceden.redis.redisson;



import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.client.RedisClient;
import org.redisson.client.RedisConnection;
import org.redisson.client.codec.StringCodec;
import org.redisson.client.protocol.RedisCommands;
import org.redisson.core.RBucket;
import org.redisson.core.RMap;
import org.redisson.core.RSet;
import org.redisson.core.RSortedSet;

public class RedissonTest {
	
	private Redisson redisson;
	
	@Before
	public void setBefore(){
		// connects to single Redis server via Config
    	Config config = new Config();
    	config.useSingleServer().setAddress("121.42.43.122:6379").setPassword("521125");

    	//or with database select num = 1
//    	config.useSingleServer().setAddress("121.42.43.122:6379");

    	redisson = Redisson.create(config);
    	System.out.println("-----开启redisson-----");
	}
	
    @Test
    public void LowlevelRedisTest () {
    	RedisClient client = new RedisClient("121.42.43.122", 6379);
    	RedisConnection conn = client.connect();
    	//or 
    	Future<RedisConnection> connFuture = client.connectAsync();

    	conn.sync(StringCodec.INSTANCE, RedisCommands.SET, "test", 123456);
    	io.netty.util.concurrent.Future<Object> async = conn.async(StringCodec.INSTANCE, RedisCommands.GET, "test");
    	
    	try {
			System.out.println(async.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

    	conn.sync(RedisCommands.PING);

//    	conn.close();
    	// or
    	conn.closeAsync();

//    	client.shutdown();
    	// or
    	client.shutdownAsync();
    }
    
    
    @Test
    public void SingleserverTest(){
    	
    	RBucket<String> bucket = redisson.getBucket("anyObject");
//    	bucket.set(new String("abc"));
    	io.netty.util.concurrent.Future<Void> setAsync = bucket.setAsync(new String("efg"));
    	
    	try {
			System.out.println(setAsync.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
    	
    	String obj = bucket.get();
    	
    	System.out.println(obj);
    	
    }
    
    @Test
    public void mapTest(){
    	
    	RMap<String, String> map = redisson.getMap("anyMap");
    	
    	String prevObject = map.put("123", new String("abc"));
    	String currentObject = map.putIfAbsent("323", new String("efg"));
    	String obj = map.remove("123");

    	map.fastPut("321", new String("efg"));
    	map.fastRemove("321");

//    	Future<String> putAsyncFuture = map.putAsync("321");
//    	Future<Void> fastPutAsyncFuture = map.fastPutAsync("321");

    	map.fastPutAsync("321", new String("fff"));
    	map.fastRemoveAsync("321");

    	System.out.println(map.get("321"));
    	
    }
    
    @Test
    public void setTest(){
    	
    	RSet<Integer> set = redisson.getSet("setTest");
    	set.add(2);
//    	set.remove(3);

    	set.addAsync(4);
    	
      	Iterator<Integer> iterator = set.iterator();
    	while(iterator.hasNext()){
    		System.out.println(iterator.next());
    	}
    }
    
    @Test
    public void sortSetTest(){
    	
    	RSortedSet<Integer> set = redisson.getSortedSet("sortSet");
    	set.add(3);
    	set.add(1);
    	set.add(2);

    	set.addAsync(5);
    	
    	System.out.println(set.contains(2));
    	System.out.println(set.contains(4));
    	
    	Iterator<Integer> iterator = set.iterator();
    	while(iterator.hasNext()){
    		System.out.println(iterator.next());
    	}
    }
    
    @After
    public void setEnd(){
    	System.out.println("-----关闭redisson-----");
    	redisson.shutdown();
    }

}
