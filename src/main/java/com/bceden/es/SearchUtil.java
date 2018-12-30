package com.bceden.es;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;


public class SearchUtil {
	public static volatile Client client;
	//static Logger logger = Logger.getLogger(SearchUtil.class.toString());
	public static void init() {
		
		try {

				client = TransportClient.builder().build()
						.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.44.203"), 9300));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除文档
	 * @param type
	 * @param id
	 */
	public static void deleteDocument(String type, String id) {
		client.prepareDelete("sdjd", type, id).execute().actionGet();
	}
	
	



}