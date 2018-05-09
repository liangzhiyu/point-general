package com.sortdemo.java8;

import org.apache.log4j.Logger;

import java.io.*;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by dell on 2017/11/22.
 */
public class Streams {
    private static Logger LOG = Logger.getLogger(Streams.class);
    public static void main(String[] args) throws IOException, ParseException {
//        Optional accResult = Stream.of(1, 2, 3, 4)
//                .reduce((acc, item) -> {
//                    System.out.println("acc : "  + acc);
//                    acc += item;
//                    System.out.println("item: " + item);
//                    System.out.println("acc+ : "  + acc);
//                    System.out.println("--------");
//                    return acc;
//                });
//        System.out.println("accResult: " + accResult.get());
//        System.out.println("--------");



//        java8();

    }

    public static void java8(){
        System.out.println("给定个初始值，求和");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, (sum, item) -> sum + item));
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, Integer::sum));

        System.out.println("给定个初始值，求min");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, (min, item) -> Math.min(min, item)));
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, Integer::min));

        System.out.println("给定个初始值，求max");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, (max, item) -> Math.max(max, item)));
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, Integer::max));

        //##############################################################################################################
        System.out.println("无初始值，求和");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(Integer::sum).orElse(0));

        System.out.println("无初始值，求max");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(Integer::max).orElse(0));

        System.out.println("无初始值，求min");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(Integer::min).orElse(0));


//        List<Integer> nList = new ArrayList<>();
//        System.out.println(nList.stream().findFirst().get());


        List<Integer>nums = Arrays.asList(1, 3, null, 8, 7, 8, 13, 10);
//        nums.stream().filter(num -> num != null).distinct().forEach(System.out::println);
        nums.stream().filter(num -> num != null).distinct().forEach(item -> {
            System.out.println(item);
        });

        Map<String, Integer> items = new LinkedHashMap<>();
        items.put("小白", 10);
        items.put("小文", 20);
        items.put("小君", 30);
        items.put("KD", 40);
        items.put("ws", 50);
        items.put("XJ", 60);

        items.forEach((k,v)->{
            System.out.println("key:"+k+" value:"+v);
        });

        List<String> list = Arrays.asList("a","B","C","d","e");
//        System.out.println(list.stream().filter(str -> str!=null).count());

        System.out.println(list.stream().findFirst().get());

        list.stream().map(item->item+"***").forEach(item->{
            System.out.println("8888"+item);
        });
        System.out.println(list.stream().anyMatch(item->item=="ae"));

        list.stream().map(String::toUpperCase).forEach(item->{
            System.out.println("0000000000:"+item);
        });
        List<String> cList = list.stream().skip(3).collect(Collectors.toList());
        cList.forEach(item -> {
            System.out.println("======="+item);
        });

//        list.stream().distinct().forEach(item ->{
//            System.out.println(item);
//        });
    }


}