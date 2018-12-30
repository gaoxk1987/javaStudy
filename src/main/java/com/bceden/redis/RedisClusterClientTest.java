package com.bceden.redis;

import java.util.HashSet;  
import java.util.Set;  

import org.junit.Before;
import org.junit.Test;  

import redis.clients.jedis.HostAndPort;  
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;  

public class RedisClusterClientTest {  

  private JedisCluster jedisCluster; 
  private String serverInfo = "192.168.34.86:6379,192.168.34.86:6380,192.168.34.192:6379,192.168.34.192:6380,192.168.34.3:6379,192.168.34.3:6380";  

  private Set<HostAndPort> getClusterInfo(String serverInfo) {  
      Set<HostAndPort> set = new HashSet<HostAndPort>();  
      if(serverInfo==null||"".equals(serverInfo.length())) {  
          throw new RuntimeException("The serverInfo can not be empty");  
      }  
      String ipPort[] = serverInfo.split(",");  
      int len = ipPort.length;  
      for(int i=0;i<len;i++) {  
          String server[] = ipPort[i].split(":");  
          set.add(new HostAndPort(server[0], Integer.parseInt(server[1])));  
      }  
      return set;  
  }  
    
  @Before
  public void setup() {

      Set<HostAndPort> jedisClusterNodes = getClusterInfo(serverInfo);  
      // Jedis Cluster will attempt to discover cluster nodes automatically  
      jedisCluster = new JedisCluster(jedisClusterNodes);  
  }
  
  @Test  
  public void test() {  
      //-----添加数据----------  
	  jedisCluster.set("name","xinxin");//向key-->name中放入了value-->xinxin  
      System.out.println(jedisCluster.get("name"));//执行结果：xinxin  
      
      jedisCluster.append("name", " is my lover"); //拼接
      System.out.println(jedisCluster.get("name")); 
      
      jedisCluster.del("name");  //删除某个键
      System.out.println(jedisCluster.get("name"));
      //设置多个键值对
//      jedis.mset("name","liuling","age","23","qq","476777389");
//      jedis.incr("age"); //进行加1操作
//      System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));
  }  
  
  

}  
