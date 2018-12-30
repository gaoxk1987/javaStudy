/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 下午3:16:11
 * Version: 1.0
 *
 */

package com.bceden.MapLRU;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-4-23 下午3:16:11   
 */
//测试类  
public class LRULinkedHashMapTest{
    public static void main(String[] args) throws Exception{

        //指定缓存最大容量为4
        Map<Integer,Integer> map=new LRULinkedHashMap<Integer,Integer>(4);
        map.put(9,3);
        map.put(7,4);
        map.put(5,9);
        map.put(3,4);

//	    map.get(9);   //注销和不注销是不同的

        map.put(6,6);
        //总共put了5个元素，超过了指定的缓存最大容量
        //遍历结果
        for(Iterator<Map.Entry<Integer,Integer>> it=map.entrySet().iterator();it.hasNext();){
            System.out.println(it.next().getKey());
        }
    }
}


//扩展一下LinkedHashMap这个类，让他实现LRU算法  
class LRULinkedHashMap<K,V> extends LinkedHashMap<K,V>{
    //定义缓存的容量
    private int capacity;
    private static final long serialVersionUID = 1L;
    //带参数的构造器
    LRULinkedHashMap(int capacity){
        //调用LinkedHashMap的构造器，传入以下参数
        super(16,0.75f,true);
        //传入指定的缓存最大容量
        this.capacity=capacity;
    }
    //实现LRU的关键方法，如果map里面的元素个数大于了缓存最大容量，则删除链表的顶端元素
    @Override
    public boolean removeEldestEntry(Map.Entry<K, V> eldest){
        System.out.println(eldest.getKey() + "=" + eldest.getValue());
        return size()>capacity;
    }
}  