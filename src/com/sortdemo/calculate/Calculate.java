package com.sortdemo.calculate;

import java.math.BigDecimal;
import java.math.RoundingMode;

/*** Kingworld Omni Commerce Platform
 *
 * Copyright (c) 2017-2018 Kingworld Group
 * All rights reserved.
 ** This software is the confidential and proprietary information of Kingworld
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Kingworld.
 ** Created by liangzy on 2018/6/7.
 *
 */
public class Calculate {
    public static void main(String[] args) {
        System.out.println("1111111111111111111111");
        ssf();
        System.out.println("22222222222222222222222222");
    }
public static void ssf(){
    System.out.println("aaaaaaaaaaa");
        return;
}


    public void cal(){
        BigDecimal a = new BigDecimal((String.valueOf(275.78)));
        BigDecimal b = new BigDecimal((Double.toString(0.152)));
        System.out.println(a.multiply(b).setScale(2, RoundingMode.HALF_UP).doubleValue());


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
}
