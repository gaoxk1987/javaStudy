
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 下午2:43:58
 * Version: 1.0
 *
 */

package com.bceden.innerClass;

/**
 *
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-5-6 下午2:43:58
 */

public class Test {
    private String s;
    public static void main(String[] args) {
//		 	Son son = new Son();
        Son son = getSon();    //shift+alt+m 快捷键的应用(新建一个方法将给语句封装进去)
        System.out.println("Son 的Strong：" + son.getStrong());
        System.out.println("Son 的kind：" + son.getKind());
    }

    /**
     *
     * @author Gao xingkun
     * @version 1.0
     * @date 2014-5-6 下午3:20:06
     * @return Son
     */

    private static Son getSon() {
        Son son = new Son();
        return son;
    }
}
