package com.sortdemo.sms;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;

public class AliSMS {

	public static void main(String[] args) {
	    String host = "http://sms.market.alicloudapi.com";
	    String path = "/singleSendSms";
	    String method = "GET";
	    String appcode = "���Լ���AppCode";
	    Map<String, String> headers = new HashMap<String, String>();
	    //�����header�еĸ�ʽ(�м���Ӣ�Ŀո�)ΪAuthorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("ParamString", "%7B%22no%22%3A%22123456%22%7D");
	    querys.put("RecNum", "RecNum");
	    querys.put("SignName", "SignName");
	    querys.put("TemplateCode", "TemplateCode");


	    try {
	    	/**
	    	* ��Ҫ��ʾ����:
	    	* HttpUtils���
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
	    	* ����
	    	*
	    	* ��Ӧ�����������
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
	    	*/
	    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
	    	System.out.println(response.toString());
	    	//��ȡresponse��body
	    	//System.out.println(EntityUtils.toString(response.getEntity()));
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}

}
