package com.rex.yangtzeu.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import com.rex.yangtzeu.Yangtzeu;

public class YuHttp {
	 public static String get(String url, String charset)throws Exception {  
		  
	        HttpClient client = Yangtzeu.getHttpClient();  
	        GetMethod method1 = new GetMethod(url);  
	  
	        if (null == url || !url.startsWith("http")) {
	            throw new Exception("请求地址格式不对");
	        }  
	  
	        // 设置请求的编码方式  
	        if (null != charset) {  
	            method1.addRequestHeader("Content-Type",  
	                    "application/x-www-form-urlencoded; charset=" + charset);  
	        } else {  
	            method1.addRequestHeader("Content-Type",  
	                    "application/x-www-form-urlencoded; charset=" + "utf-8");
	        }  
	        
	        // 保持cookies
	        method1.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
	        
	        int statusCode = client.executeMethod(method1);  
	  
	        if (statusCode != HttpStatus.SC_OK) {// 打印服务器返回的状态  
//	            System.out.println("Method failed: " + method1.getStatusLine());  
	        }  
	        // 返回响应消息  
	        byte[] responseBody = method1.getResponseBodyAsString().getBytes(method1.getResponseCharSet());  
	        // 在返回响应消息使用编码(utf-8或gb2312)
	        String response = new String(responseBody, charset);  
	        // 释放连接  
	        method1.releaseConnection();
	        return response;  
	    }
	 
	 /**  
     * <p>执行一个HTTP POST请求，返回请求响应的HTML</p>  
     *  
     * @param url       请求的URL地址  
     * @param params    请求的查询参数,可以为null  
     * @param charset   字符集  
     * @param pretty    是否美化  
     * @return          返回请求响应的HTML  
     */  
	 public static String post(String url, Map<String, String> params, String charset, boolean pretty) {  
	          
	        StringBuffer response = new StringBuffer();  
	          
	        HttpClient client = Yangtzeu.getHttpClient();
	        HttpMethod method = new PostMethod(url);
	        
	        // 保持cookies
	        method.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
	          
	        //设置Http Post数据   
	        if (params != null) {  
	        	NameValuePair[] p = new NameValuePair[params.size()];  
	        	int i = 0; 
	            for (Map.Entry<String, String> entry : params.entrySet()) {
	            	p[i++] = new NameValuePair(entry.getKey(), entry.getValue());
	            } 
	            ((PostMethod) method).setRequestBody(p);
	            method.setRequestHeader("Content-Type",
	                    "application/x-www-form-urlencoded;charset="+charset);
	        }  
	        try {  
	            client.executeMethod(method);  
	            if (method.getStatusCode() == HttpStatus.SC_OK) {  
	                //读取为 InputStream，在网页内容数据量大时候推荐使用  
	                BufferedReader reader = new BufferedReader(  
	                        new InputStreamReader(method.getResponseBodyAsStream(),  
	                                charset));  
	                String line;  
	                while ((line = reader.readLine()) != null) {  
	                    if (pretty)  
	                        response.append(line).append(System.getProperty("line.separator"));  
	                    else  
	                        response.append(line);  
	                }  
	                reader.close();  
	            }  
	        } catch (IOException e) {  
	            System.out.println("执行HTTP Post请求" + url + "时，发生异常！");  
	            e.printStackTrace();  
	        } finally {  
	            method.releaseConnection();  
	        }  
//	        System.out.println("--------------------"+response.toString());  
	        return response.toString();  
	    }   
}
