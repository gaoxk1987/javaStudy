package com.bceden.zookeeper.zkClient.watcher;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * Register a watcher for a particular path.
 */
public abstract class WatchRegistration {
    private Watcher watcher;
    private String clientPath;
    public WatchRegistration(Watcher watcher, String clientPath)
    {
        this.watcher = watcher;
        this.clientPath = clientPath;
    }

    abstract protected Map<String, Set<Watcher>> getWatches(int rc);

    /**
     * Register the watcher with the set of watches on path.
     * @param rc the result code of the operation that attempted to
     * add the watch on the path.
     */
    public void register(int rc) {
        if (shouldAddWatch(rc)) {
            Map<String, Set<Watcher>> watches = getWatches(rc);
            synchronized(watches) {
                Set<Watcher> watchers = watches.get(clientPath);
                if (watchers == null) {
                    watchers = new HashSet<Watcher>();
                    watches.put(clientPath, watchers);
                }
                watchers.add(watcher);
            }
        }
    }
    /**
     * Determine whether the watch should be added based on return code.
     * @param rc the result code of the operation that attempted to add the
     * watch on the node
     * @return true if the watch should be added, otw false
     */
    protected boolean shouldAddWatch(int rc) {
        return rc == 0;
    }
}
