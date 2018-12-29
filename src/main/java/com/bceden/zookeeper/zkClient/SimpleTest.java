package com.bceden.zookeeper.zkClient;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class SimpleTest {

	public static void main(String[] args) {
		InetSocketAddress address =new InetSocketAddress("www.baidu.com",80);
//		InetSocketAddress address =new InetSocketAddress("192.168.34.132",80);
		InetAddress address2 = address.getAddress();
		System.out.println(address2!=null);
		System.out.println(address2.getHostName());
		System.out.println(address2.getHostAddress());

	}

}
