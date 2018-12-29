// File generated by hadoop record compiler. Do not edit.
/**
* Licensed to the Apache Software Foundation (ASF) under one
* or more contributor license agreements.  See the NOTICE file
* distributed with this work for additional information
* regarding copyright ownership.  The ASF licenses this file
* to you under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance
* with the License.  You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.bceden.zookeeper.zkClient.watcher;

import org.apache.jute.*;
public class WatcherEvent implements Record {
  private int type;
  private int state;
  private String path;
  public WatcherEvent() {
  }
  public WatcherEvent(
        int type,
        int state,
        String path) {
    this.type=type;
    this.state=state;
    this.path=path;
  }
  public int getType() {
    return type;
  }
  public void setType(int m_) {
    type=m_;
  }
  public int getState() {
    return state;
  }
  public void setState(int m_) {
    state=m_;
  }
  public String getPath() {
    return path;
  }
  public void setPath(String m_) {
    path=m_;
  }
  public void serialize(OutputArchive a_, String tag) throws java.io.IOException {
    a_.startRecord(this,tag);
    a_.writeInt(type,"type");
    a_.writeInt(state,"state");
    a_.writeString(path,"path");
    a_.endRecord(this,tag);
  }
  public void deserialize(InputArchive a_, String tag) throws java.io.IOException {
    a_.startRecord(tag);
    type=a_.readInt("type");
    state=a_.readInt("state");
    path=a_.readString("path");
    a_.endRecord(tag);
}
  public String toString() {
    try {
      java.io.ByteArrayOutputStream s =
        new java.io.ByteArrayOutputStream();
      CsvOutputArchive a_ = 
        new CsvOutputArchive(s);
      a_.startRecord(this,"");
    a_.writeInt(type,"type");
    a_.writeInt(state,"state");
    a_.writeString(path,"path");
      a_.endRecord(this,"");
      return new String(s.toByteArray(), "UTF-8");
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
    return "ERROR";
  }
  public void write(java.io.DataOutput out) throws java.io.IOException {
    BinaryOutputArchive archive = new BinaryOutputArchive(out);
    serialize(archive, "");
  }
  public void readFields(java.io.DataInput in) throws java.io.IOException {
    BinaryInputArchive archive = new BinaryInputArchive(in);
    deserialize(archive, "");
  }
  public int compareTo (Object peer_) throws ClassCastException {
    if (!(peer_ instanceof WatcherEvent)) {
      throw new ClassCastException("Comparing different types of records.");
    }
    WatcherEvent peer = (WatcherEvent) peer_;
    int ret = 0;
    ret = (type == peer.type)? 0 :((type<peer.type)?-1:1);
    if (ret != 0) return ret;
    ret = (state == peer.state)? 0 :((state<peer.state)?-1:1);
    if (ret != 0) return ret;
    ret = path.compareTo(peer.path);
    if (ret != 0) return ret;
     return ret;
  }
  public boolean equals(Object peer_) {
    if (!(peer_ instanceof WatcherEvent)) {
      return false;
    }
    if (peer_ == this) {
      return true;
    }
    WatcherEvent peer = (WatcherEvent) peer_;
    boolean ret = false;
    ret = (type==peer.type);
    if (!ret) return ret;
    ret = (state==peer.state);
    if (!ret) return ret;
    ret = path.equals(peer.path);
    if (!ret) return ret;
     return ret;
  }
  public int hashCode() {
    int result = 17;
    int ret;
    ret = (int)type;
    result = 37*result + ret;
    ret = (int)state;
    result = 37*result + ret;
    ret = path.hashCode();
    result = 37*result + ret;
    return result;
  }
  public static String signature() {
    return "LWatcherEvent(iis)";
  }
}