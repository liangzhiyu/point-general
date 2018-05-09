package com.sortdemo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculate {
	//用来存放词典
		public static final Map<Integer, String> map=new HashMap<Integer, String>();
		//用来存放18进制数据的每一位
		public static List<Integer> list=new ArrayList<Integer>();
		
	//自动加载词典
		static{
			map.put(10, "A");
			map.put(11, "B");
			map.put(12, "C");
			map.put(13, "D");
			map.put(14, "E");
			map.put(15, "F");
			map.put(16, "G");
			map.put(17, "H");
		}
		
		/**将十进制数字转十八进制数字。
		 */
		private static void get18(int num){
			int yu=num%18;
			int shang=num/18;
			//把余数存入list
			list.add(yu);
			
			//当商<18的时候 把商存入list
			if(shang<18){
				list.add(shang);
			}
			
			//否则 递归计算
			else {
				get18(shang);
			}
			
		}
		//生成18进制数字
		private static String to18(){
			StringBuffer sb=new StringBuffer("");
			for (int i = list.size()-1; i >=0; i--) {
				if(map.containsKey(list.get(i))){
					sb.append(map.get(list.get(i)));
				}
				else{
					sb.append(list.get(i));
				}
			}
			return sb.toString();
		}
		

		private static String getResult(int num){
			get18(num);
			String str= to18();
			return str;
		}
	//测试
		public static void main(String[] args) {
			
			System.out.println(getResult(5400));
		}

}
