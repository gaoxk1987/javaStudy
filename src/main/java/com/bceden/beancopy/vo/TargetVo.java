
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 11:20:51
 * Version: 1.0
 *
 */

package com.bceden.beancopy.vo;

import java.util.Date;
import java.util.List;

/**
 *
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-4-8 11:20:51
 */

public class TargetVo {
    private String name;
    private int num;
    private long min;
    private Date publish;
    private List friend;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public long getMin() {
        return min;
    }
    public void setMin(long min) {
        this.min = min;
    }
    public Date getPublish() {
        return publish;
    }
    public void setPublish(Date publish) {
        this.publish = publish;
    }
    public List getFriend() {
        return friend;
    }
    public void setFriend(List friend) {
        this.friend = friend;
    }

}