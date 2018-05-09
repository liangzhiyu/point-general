package com.sortdemo.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;

/**
 * Created by dell on 2018/4/24.
 */
public class FastJsonDemo {

    public static void main(String[] args) {
        transferToBean();
        testJSONStrToJavaBeanList();
    }
    public static void transferToBean(){
        Student student = new Student();
        student.setAge(18);
        student.setName("Bob");
        student.setSex("man");
        String json = JSON.toJSONString(student);
        System.out.println(json);
    }
    public static void transferToJson(){
        String str = "{\"name\":\"Bob\",\"age\":20,\"sex\":\"man\"}";
        Student student = JSON.parseObject(str, new TypeReference<Student>(){});
        System.out.println(student.getName()+"   "+student.getAge()+"  "+student.getSex());
    }

    /**
     * json字符串-数组类型与JavaBean_List之间的转换
     */
    public static void testJSONStrToJavaBeanList(){
        String str = "[{\"name\":\"Bob\",\"age\":20,\"sex\":\"man\"},{\"name\":\"Tom\",\"age\":18,\"sex\":\"man\"}]";
        ArrayList<Student> students = JSON.parseObject(str, new TypeReference<ArrayList<Student>>() {});

        for (Student student : students) {
            System.out.println(student.getName()+":"+student.getAge()+" "+student.getSex());
        }
    }

    public static void transferToArray(){

        System.out.println("==========");
        String jsonstring = "[{x:00,y:00},{x:10,y:10},{x:20,y:20},{x:30,y:30},{x:40,y:40},{x:50,y:50}]";
        JSONArray b = JSON.parseArray(jsonstring);
        for (Object object : b) {
            JSONObject jsonObject = (JSONObject)object;
            String x = jsonObject.getString("x");
            System.out.println(x);
        }
    }
}
