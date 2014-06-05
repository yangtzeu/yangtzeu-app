package com.rex.yangtzeu.http;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;

public class JwcHttp {
	public static boolean jwc_login() {
		HttpClient client = new HttpClient();
		NameValuePair[] nameValuePairs = {
                new NameValuePair("username", "aaa"),
                new NameValuePair("passwd", "123456")
        };
		
		return true;
	}
}
