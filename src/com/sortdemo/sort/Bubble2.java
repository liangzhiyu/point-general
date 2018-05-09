package com.sortdemo.sort;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class Bubble2 {

	public static void main(String[] args) {




	}

	public void calender(){
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, +1);
		date = calendar.getTime();
		System.out.println(date);
	}
	public static void bubble() {
		List<Integer> list = new ArrayList<Integer>();
		Random rd = new Random();
		int n;
		for (int i = 0; i < 10; i++) {
			n = rd.nextInt(10);
			if (!list.contains(n)) {
				list.add(n);
			}
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + ",");
		}

		Integer temple;
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i);
			Integer right = list.get(i + 1);
			Integer left = list.get(i);
			if (left > right) {
				temple = right;
				right = left;
				left = temple;
			}
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + ",");
		}
	}

	public static void flushPoker(){
		List<String> pokerList = new ArrayList<String>();
		for (int i = 1; i < 55; i++) {
			pokerList.add(String .valueOf(i));
		}
		pokerList.forEach(item ->{
			System.out.print(item+",");
		});

		int pokerSize = pokerList.size();
		Random r = new Random();
		for (int i = 0; i <pokerSize; i++) {
			int index = r.nextInt(pokerSize);
			String current = pokerList.get(i);
			String random = pokerList.get(index);
			pokerList.set(i,random);
			pokerList.set(index,current);
		}
		System.out.println();
		pokerList.forEach(item ->{
			System.out.print(item+",");
		});
	}
}
