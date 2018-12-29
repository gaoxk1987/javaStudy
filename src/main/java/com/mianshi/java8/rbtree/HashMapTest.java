package com.mianshi.java8.rbtree;

import java.util.HashMap;

/**
 * http://www.jianshu.com/p/814432ed04e8
 * @author HK
 *
 */
public class HashMapTest {
	
	public static void main(String[] args) throws Exception {
        //map内的数组容量大于等于64 且 链表数量大于8才会进行红黑树转换
//		HashMap map = new HashMap(64);
//		for (int i = 0; i <= 8; i++) {
//			map.put(new HashCodeOneObj(i), i);
//		}
        HashMap map = new HashMap(16);
        for (int i = 1; i <= 10; i++) {
        	if(i==8){
        		System.out.println("该扩容了！");
        	}
            map.put(new HashCodeOneObj(i), i);
        }
        System.out.println(map);
    }

    private static class HashCodeOneObj implements Comparable<HashCodeOneObj> {
        private int val;

        public HashCodeOneObj(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        @Override
        public int hashCode() {
            return 1; //让所有数据都存入一个桶
        }

        @Override
        public int compareTo(HashCodeOneObj o) {
            if (null == o) {
                return -1;
            }
            return Integer.compare(this.getVal(), o.getVal());
        }
    }


}
