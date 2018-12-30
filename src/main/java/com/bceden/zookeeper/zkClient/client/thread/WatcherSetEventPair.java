package com.bceden.zookeeper.zkClient.client.thread;

import java.util.Set;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

class WatcherSetEventPair {
    private final Set<Watcher> watchers;
    private final WatchedEvent event;

    public WatcherSetEventPair(Set<Watcher> watchers, WatchedEvent event) {
        this.watchers = watchers;
        this.event = event;
    }


}
