package com.sortdemo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculate {
	//������Ŵʵ�
		public static final Map<Integer, String> map=new HashMap<Integer, String>();
		//�������18�������ݵ�ÿһλ
		public static List<Integer> list=new ArrayList<Integer>();
		
	//�Զ����شʵ�
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
		
		/**��ʮ��������תʮ�˽������֡�
		 */
		private static void get18(int num){
			int yu=num%18;
			int shang=num/18;
			//����������list
			list.add(yu);
			
			//����<18��ʱ�� ���̴���list
			if(shang<18){
				list.add(shang);
			}
			
			//���� �ݹ����
			else {
				get18(shang);
			}
			
		}
		//����18��������
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
	//����
		public static void main(String[] args) {
			
			System.out.println(getResult(5400));
		}

}
