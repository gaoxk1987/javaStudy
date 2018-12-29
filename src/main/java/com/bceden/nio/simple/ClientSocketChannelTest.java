
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: ����3:08:29
 * Version: 1.0
 *
 */

package com.bceden.nio.simple;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-6-9 ����3:08:29   
 */

public class ClientSocketChannelTest {

	/**
	 * 
	 * @author Gao xingkun
	 * @version 1.0
	 * @date 2014-6-9 ����3:08:29
	 * @param args void
	 */

	public static void main(String[] args) throws IOException, InterruptedException{
		
	SocketChannel socketChannel = SocketChannel.open(); // ����SocketChannel
    InetSocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(), 10000);
    socketChannel.socket().connect(address);
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    ByteBuffer buffer = ByteBuffer.allocate(1024); // ����Buffer
    while (true) {
        try {
            buffer.clear();
            String time = sdf.format(new Date());
            buffer.put(time.getBytes());
            buffer.flip(); // ���óɶ�ȡ״̬
            socketChannel.write(buffer); // ��������
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Connection Close");
            break;
        }
    }
    }

}
