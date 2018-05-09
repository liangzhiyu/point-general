package com.sortdemo.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by dell on 2018/1/19.
 */
@WebService
public class Order {

    @WebMethod
    public void printOrderNumber(){
        System.out.println("订单号为：564655121");
    }

    @WebMethod
    public String getOrderNumber(){
        System.out.println("订单号为：564655121");
        return "dsjflewjewjf";
    }
}
