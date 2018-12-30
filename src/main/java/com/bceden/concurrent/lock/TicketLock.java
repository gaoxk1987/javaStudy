package com.bceden.concurrent.lock;

import java.util.concurrent.atomic.AtomicInteger;

public class TicketLock {
	 private AtomicInteger serviceNum = new AtomicInteger(0);  
	    private AtomicInteger ticketNum = new AtomicInteger(0);  
	    private static final ThreadLocal<Integer> myNum = new ThreadLocal<Integer>();  
	    public void lock () {  
	        myNum.set(ticketNum.getAndIncrement());  
	        while (serviceNum.get() != myNum.get()) {};  
	    }  
	    public void unlock() {  
	        serviceNum.compareAndSet(myNum.get(), myNum.get() + 1);  
	    }  
}
