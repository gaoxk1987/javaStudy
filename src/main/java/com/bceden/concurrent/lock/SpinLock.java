package com.bceden.concurrent.lock;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {
	// use thread itself as  synchronization state  
    private AtomicReference<Thread> owner = new AtomicReference<Thread>();   
    private int count = 0; // reentrant count of a thread, no need to be volatile  
    public void lock() {  
        Thread t = Thread.currentThread();  
        if (t == owner.get()) { // if re-enter, increment the count.  
            ++count;  
            return;  
        }  
        while (owner.compareAndSet(null, t)) {} //spin  
    }  
    public void unlock() {  
        Thread t = Thread.currentThread();  
        if (t == owner.get()) { //only the owner could do unlock;  
            if (count > 0) --count; // reentrant count not zero, just decrease the counter.  
            else {  
                owner.set(null);// compareAndSet is not need here, already checked  
            }  
        }  
    }  
}
