
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 2:43:00
 * Version: 1.0
 *
 */

package com.bceden.innerClass;

/**
 *
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-5-6 2:43:00
 */

public class Son {

    /**
     * father
     *
     */
    class Father_1 extends Father{
        public int strong(){
            return super.strong() + 1;
        }
    }

    class Mother_1 extends  Mother{
        public int kind(){
            return super.kind() - 2;
        }
    }

    public int getStrong(){
        return new Father_1().strong();
    }

    public int getKind(){
        return new Mother_1().kind();
    }
}
