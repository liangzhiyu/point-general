package com.sortdemo.other;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class OtherTest {

	public static void main(String[] args) {
		BigDecimal a = new BigDecimal((String.valueOf(275.78)));
		BigDecimal b = new BigDecimal((Double.toString(0.152)));
		System.out.println(a.multiply(b).setScale(2,RoundingMode.HALF_UP).doubleValue());


//		BigDecimal a = new BigDecimal(275.78);//用户此次优惠金额
//		System.out.println((a.multiply(new BigDecimal(100)).setScale(2, RoundingMode.HALF_UP).intValue()));













	/*	Double userSaveMoneyInit =0.0;
		BigDecimal userSaveMoney = new BigDecimal(Double.toString( userSaveMoneyInit==null?0:userSaveMoneyInit));//用户总优惠金额
		BigDecimal entrySaveMoney = new BigDecimal(Double.toString(10.0));//用户此次优惠金额
		userSaveMoney.add(entrySaveMoney);
		System.out.println(userSaveMoney.add(entrySaveMoney));*/

		/*Random r = new Random(100);
		int i=0;
		while (i<=10){
			i++;
			System.out.println("random111111=="+r.nextInt(100));
		}

		int j=0;
		while (j<=10){
			j++;
			System.out.println("random222222=="+new Random().nextDouble()*10);
		}
*/
		/*String s=null;
		if (s != null || s.length() > 0) {
			System.out.println("111111");
		} else if(s!=null & s.length()>0) {
			System.out.println("22222");
		}*/
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
