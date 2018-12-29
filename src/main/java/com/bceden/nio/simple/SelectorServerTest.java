/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: ����3:07:18
 * Version: 1.0
 *
 */

package com.bceden.nio.simple;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-6-9 ����3:07:18
 */

public class SelectorServerTest {

	public static void main(String args[]) throws IOException,
			InterruptedException {
		Selector selector = Selector.open(); // ����Selector

		// ����һ�����ڽ������ӵ�ServerSocketChannel
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		InetSocketAddress address = new InetSocketAddress(
				InetAddress.getLocalHost(), 10000);
		serverSocketChannel.socket().bind(address);
		serverSocketChannel.configureBlocking(false);
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT); // ע��Accept�¼�

		while (true) {
			if (selector.select() > 0) { // ���ע����¼�����
				Set<SelectionKey> selectedKeys = selector.selectedKeys(); // ��ȡ�������¼�
				Iterator<SelectionKey> it = selectedKeys.iterator(); // ���ν��д���
				while (it.hasNext()) {
					SelectionKey selectionKey = it.next();
					if (selectionKey.isAcceptable()) { // �����Accept�¼�
						// ��ȡע���ServerSocketChannel
						serverSocketChannel = ((ServerSocketChannel) selectionKey.channel());
						SocketChannel socketChannel = serverSocketChannel.accept(); // ��������
						socketChannel.configureBlocking(false);
						socketChannel.register(selector, SelectionKey.OP_READ); // ע������ӵ�Read�¼�
						System.out.println("Connected: "
								+ socketChannel.socket()
										.getRemoteSocketAddress());
					} else if (selectionKey.isReadable()) { // �����Read�¼�
						// ��ȡע���SocketChannel
						SocketChannel socketChannel = (SocketChannel) selectionKey
								.channel();
						ByteBuffer buffer = ByteBuffer.allocate(1024);
						while (socketChannel.read(buffer) > 0) { // ��ȡ���յ�������
							buffer.flip();
							byte[] dst = new byte[buffer.limit()];
							buffer.get(dst);
							System.out.println(new String(dst));
						}
					}
					it.remove(); // ��Ҫ����������¼��Ƴ�
				}
			}
			Thread.sleep(100);
		}
	}
}
