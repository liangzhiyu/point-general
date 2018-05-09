package com.sortdemo.http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StreamTest {

	private static Logger log = LoggerFactory.getLogger(StreamTest.class);
	
	public static void main(String args[]) throws ParseException, IOException{
//		handleOutputStream();
//		handleInputStream();
//		handleInputStreamReader();
//		handleOutputStreamReader();
//		handleDataOutputStream();
//		handleDataInputStream();
//		handleRandomAccessFile;
//		handleRandomAccessFile();
//		url();
//		socket();
//		readTxtFile();
//		copyFile();
	}
	
	//�����ֽ������
	public static void handleOutputStream(){
		File file = new File("d:\\stream.txt");
		try {
			String text = "hello world!!";
			OutputStream os = new FileOutputStream(file,true);
//			os.write(text.getBytes());
			
			byte[] b = text.getBytes();
			for (int i = 0; i < b.length; i++) {
				os.write(b[i]);
			}
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//�����ֽ�������
	public static void handleInputStream(){
		try {
			File file = new File("d:\\stream.txt");
			byte[] b = new byte[(int) file.length()];
			InputStream is = new FileInputStream(file);
			if(is.available()>0){
				is.read(b);
			}
			is.close();
			System.out.println(new String(b));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//�����ַ�������
	public static void handleInputStreamReader(){
		try {
			File file = new File("d:\\stream.txt");
			InputStreamReader is = new InputStreamReader(new FileInputStream(file));
			BufferedReader br = new BufferedReader(is);
			String lineText = null;
			while((lineText=br.readLine())!=null){
				System.out.println(lineText);
			}
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//�����ַ������
	public static void handleOutputStreamReader(){
		try {
			File file = new File("d:\\stream.txt");
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file));
			BufferedWriter br = new BufferedWriter(osw);
			br.write("���⣺");
			br.write("\r\n");
			br.write("����");
			br.close();
			osw.close();
			/*��ͬϵͳ�Ļ���
			windows:\r\n
			Linux:\r
			mac:\n
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void handleDataInputStream(){
		try {
			DataInputStream is = new DataInputStream(new FileInputStream("d:\\stream.txt"));
			int i = is.readInt();
			double d = is.readDouble();
			is.close();
			System.out.println(i+""+d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void handleDataOutputStream(){
		try {
			DataOutputStream is = new DataOutputStream(new FileOutputStream("d:\\stream.txt"));
			is.write(999);
			is.writeDouble(888.235);
			is.writeFloat(777.25f);
			is.writeLong(666l);
			is.writeChar('C');
			is.writeBoolean(true);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void	handleRandomAccessFile(){
		try {
			File file = new File("d:\\stream.txt");
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			System.out.println(raf.getFilePointer());
			raf.seek(raf.length());
			byte[] b = new byte[1024];
			raf.write("׷��".getBytes());
			raf.read(b);
			raf.close();
			System.out.println(new String(b));
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	public static void te(){
		java.util.Date dates = new java.util.Date();  
		//��ʱ���ʽת���ɷ���TimestampҪ��ĸ�ʽ  
		String nowTime = new SimpleDateFormat("HH:mm:ss").format(dates);  
		java.sql.Time ts_date = java.sql.Time.valueOf(nowTime) ;
		System.out.println(ts_date);
		System.out.println("���������֣�");
		Scanner sc =new Scanner(System.in);
		String a = sc.next();
		System.out.println("aaaaaaaaa"+a);
		 String filePath = "C:\\Users\\liangzy\\Desktop\\΢�ŷ�����.txt";
	        readTxtFile(filePath);
	        log.warn("this is  error,check please!"+ts_date);
	}

	public static void readTxtFile(String filePath) {
		try {
			String encoding = "GBK";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // �ж��ļ��Ƿ����
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// ���ǵ������ʽ
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					System.out.println(lineTxt);
				}
				read.close();
			} else {
				System.out.println("�Ҳ���ָ�����ļ�");
			}
		} catch (Exception e) {
			System.out.println("��ȡ�ļ����ݳ���");
			e.printStackTrace();
		}
	}
	 public static void readTxtFile(){
		 try {
			String path = "d:\\aa.txt";
			File file = new File(path);
			if (file.exists()) {
				InputStream is = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader bf = new BufferedReader(isr);
				String str;
				while ((str = bf.readLine())!=null) {
					System.out.println(str);
				}
			}else{
				System.out.println("�ļ�������");
				file.createNewFile();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	 public static void copyFile(){
		 try {
			InputStream is = new FileInputStream("d:\\a.txt");
			OutputStream os =  new FileOutputStream("d:\\aa.txt");
			byte []b = new byte[1024];
			int len = is.read(b);
			while (len!=-1) {
				os.write(b, 0, len);
				len=is.read(b);  
			}
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
}