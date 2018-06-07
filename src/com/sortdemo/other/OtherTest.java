package com.sortdemo.other;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class OtherTest {

	public static void main(String[] args) {


	}
	public static String generateRandom() {
		final UUID uuid = UUID.randomUUID();
		System.out.println(uuid);
		return uuid.toString().replaceAll("-", "");
	}

	public static Integer binarySearch(List<Integer> list,Integer key) {
		int low=0;
		int high=list.size();
		while(low<=high) {
			int middle = (low+high)/2;
			if(key>list.get(middle)) {
				low=middle+1;
			}else if(key<list.get(middle)) {
				high=middle-1;
			}else {
				return list.get(middle);
			}

		}
		return 0;

	}

	
	
	
	
	
	
}
