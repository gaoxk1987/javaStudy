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
package com.bceden.zookeeper.zkClient.client.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is the main class for catching all the uncaught exceptions thrown by the
 * threads.
 */
public class ZooKeeperThread extends Thread {

    private static final Logger LOG = LoggerFactory
            .getLogger(ZooKeeperThread.class);

    private UncaughtExceptionHandler uncaughtExceptionalHandler = new UncaughtExceptionHandler() {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            handleException(t.getName(), e);
        }
    };

    public ZooKeeperThread(Runnable thread, String threadName) {
        super(thread, threadName);
        setUncaughtExceptionHandler(uncaughtExceptionalHandler);
    }

    public ZooKeeperThread(String threadName) {
        super(threadName);
        setUncaughtExceptionHandler(uncaughtExceptionalHandler);
    }

    /**
     * This will be used by the uncaught exception handler and just log a
     * warning message and return.
     * 
     * @param thName
     *            - thread name
     * @param e
     *            - exception object
     */
    protected void handleException(String thName, Throwable e) {
        LOG.warn("Exception occured from thread {}", thName, e);
    }
}