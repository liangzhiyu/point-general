package com.sortdemo.webservice;

import javax.xml.ws.Endpoint;

/**
 * Created by dell on 2018/1/19.
 */
public class RunWebService {
    public static void main(String[] args) {
        String address = "http://localhost:8989/SortDemo/Order";
        Endpoint.publish(address , new Order());

        System.out.println("发布webservice成功!");
    }
}
