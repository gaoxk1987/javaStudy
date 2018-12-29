package com.bceden.dsa.constack;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class ConcurrentStack<E> {
	private AtomicReference<Node<E>> top = new AtomicReference<Node<E>>();
	private AtomicInteger size = new AtomicInteger(0);

	public void push(E e) {
		Node<E> newHead = new Node<E>(e);
		Node<E> oldHead;
		do {
			oldHead = top.get();
			newHead.next = oldHead;
		} while (!top.compareAndSet(oldHead, newHead));
		size.incrementAndGet();
	}

	public E pop() {
		Node<E> oldHead;
		Node<E> newHead;   //˴ŻNode<E> newHead,oldHead;
		do {
			oldHead = top.get();
			if (oldHead == null) {
				return null;
			}
			newHead = oldHead.next;
		} while (!top.compareAndSet(oldHead, newHead));
		size.decrementAndGet();
		return oldHead.e;
	}

	public int getSize() {
		return size.get();
	}

	public boolean isEmpty() {
		return size.get() == 0;
	}

	private static class Node<E> {
		public final E e;
		public Node<E> next;

		public Node(E e) {
			this.e = e;
		}
	}

}
