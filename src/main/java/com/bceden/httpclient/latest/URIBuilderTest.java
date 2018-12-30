package com.bceden.httpclient.latest;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;

public class URIBuilderTest {

	public static void main(String[] args) {
		
		  URI uri;
		try {
			uri = new URIBuilder()
			    .setScheme("http")
			    .setHost("www.google.com")
			    .setPath("/search")
			    .setParameter("q", "httpclient")
			    .setParameter("btnG", "Google Search")
			    .setParameter("aq", "f")
			    .setParameter("oq", "")
			    .build();
			HttpGet httpget = new HttpGet(uri);
			System.out.println(httpget.getURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}

}
