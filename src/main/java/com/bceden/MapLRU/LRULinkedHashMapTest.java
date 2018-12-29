
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: ����3:16:11
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
 * @date 2014-4-23 ����3:16:11   
 */
//������  
public class LRULinkedHashMapTest{  
	public static void main(String[] args) throws Exception{  
	  
	    //ָ�������������Ϊ4  
	    Map<Integer,Integer> map=new LRULinkedHashMap<Integer,Integer>(4);  
	    map.put(9,3);  
	    map.put(7,4);  
	    map.put(5,9);  
	    map.put(3,4);  
	    
//	    map.get(9);   //ע���Ͳ�ע���ǲ�ͬ��
	    
	    map.put(6,6);  
	    //�ܹ�put��5��Ԫ�أ�������ָ���Ļ����������  
	    //�������  
	        for(Iterator<Map.Entry<Integer,Integer>> it=map.entrySet().iterator();it.hasNext();){  
	            System.out.println(it.next().getKey());  
	        }  
	    }  
}  


//��չһ��LinkedHashMap����࣬����ʵ��LRU�㷨  
class LRULinkedHashMap<K,V> extends LinkedHashMap<K,V>{  
   //���建�������  
   private int capacity;  
   private static final long serialVersionUID = 1L;  
   //�������Ĺ�����     
   LRULinkedHashMap(int capacity){  
       //����LinkedHashMap�Ĺ��������������²���  
       super(16,0.75f,true);  
       //����ָ���Ļ����������  
       this.capacity=capacity;  
   }  
   //ʵ��LRU�Ĺؼ����������map�����Ԫ�ظ��������˻��������������ɾ������Ķ���Ԫ��  
   @Override  
   public boolean removeEldestEntry(Map.Entry<K, V> eldest){   
       System.out.println(eldest.getKey() + "=" + eldest.getValue());    
       return size()>capacity;  
   }    
}  
