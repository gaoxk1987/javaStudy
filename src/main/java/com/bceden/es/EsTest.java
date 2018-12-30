package com.bceden.es;

import java.net.InetAddress;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class EsTest {

	public static void main(String[] args) {
		Client client;
		
		try {
			
			client = TransportClient.builder().build()
					.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.44.203"), 9300));
			
		 GetResponse response = client.prepareGet("secilog", "log", "1").get(); 
		 
		 System.out.println(response);
					 
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
