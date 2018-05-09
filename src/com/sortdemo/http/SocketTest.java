package com.sortdemo.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

public class SocketTest {
	
	
	//========================UDP协议通信==============================
	/**UDP协议通信（服务器端）*/
	public static void serverSocketByUDP() throws IOException{
		//服务器端，实现基于UDP的用户登录
		//1、创建服务器端DatagramSocket，指定端口
		DatagramSocket socket =new DatagramSocket(10010);
		//2、创建数据报，用于接受客户端发送的数据
		byte[] data =new byte[1024];//
		DatagramPacket packet =new DatagramPacket(data,data.length);
		System.out.println("即将阻塞。。。");
		//3、接受客户端发送的数据
		socket.receive(packet);//此方法在接受数据报之前会一致阻塞
		//4、读取数据
		String info =new String(data,0,data.length);
		System.out.println("我是服务器，客户端告诉我"+info);

		//------------------------------
		//向客户端响应数据
		//1、定义客户端的地址、端口号、数据
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "欢迎您！".getBytes();
		//2、创建数据报，包含响应的数据信息
		DatagramPacket packet2 = new DatagramPacket(data2,data2.length,address,port);
		//3、响应客户端
		socket.send(packet2);
		//4、关闭资源
		socket.close();
	}

	/**UDP协议通信（客户端）*/
	public static void clientSocketByUDP() throws IOException {
		// 客户端
		// 1、定义服务器的地址、端口号、数据
		InetAddress address = InetAddress.getByName("localhost");
		int port = 10010;
		byte[] data = "用户名：admin;密码：123".getBytes();
		// 2、创建数据报，包含发送的数据信息
		DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
		// 3、创建DatagramSocket对象
		DatagramSocket socket = new DatagramSocket();
		// 4、向服务器发送数据
		socket.send(packet);

		// 接受服务器端响应数据
		// ------------------------
		// 1、创建数据报，用于接受服务器端响应数据
		byte[] data2 = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
		// 2、接受服务器响应的数据
		socket.receive(packet2);
		String reply = new String(data2, 0, packet2.getLength());
		System.out.println("我是客户端，服务器说：" + reply);
		// 4、关闭资源
		socket.close();
	}
	
	
	
	//============================TCP协议通信==========================
	
	/** 基于TCP协议的Socket通信，实现用户登录，服务端*/
	public static void serverSocketByTCP() throws IOException {
		//1、创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
		ServerSocket serverSocket =new ServerSocket(10086);//1024-65535的某个端口
		//2、调用accept()方法开始监听，等待客户端的连接
		Socket socket = serverSocket.accept();
		//3、获取输入流，并读取客户端信息
		InputStream is = socket.getInputStream();
		InputStreamReader isr =new InputStreamReader(is);
		BufferedReader br =new BufferedReader(isr);
		String info =null;
		while((info=br.readLine())!=null){
		System.out.println("我是服务器，客户端说："+info);
		}
		socket.shutdownInput();//关闭输入流
		//4、获取输出流，响应客户端的请求
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		pw.write("欢迎您！");
		pw.flush();

		//5、关闭资源
		pw.close();
		os.close();
		br.close();
		isr.close();
		is.close();
		socket.close();
		serverSocket.close();
	}
	
	/** 基于TCP协议的Socket通信，实现用户登录，客户端*/
	public static void clientSocketByTCP() throws IOException {
		//1、创建客户端Socket，指定服务器地址和端口
		Socket socket =new Socket("localhost",10086);
		//2、获取输出流，向服务器端发送信息
		OutputStream os = socket.getOutputStream();//字节输出流
		PrintWriter pw =new PrintWriter(os);//将输出流包装成打印流
		pw.write("用户名：admin；密码：123");
		pw.flush();
		socket.shutdownOutput();
		//3、获取输入流，并读取服务器端的响应信息
		InputStream is = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String info = null;
		while((info=br.readLine())!=null){
		 System.out.println("我是客户端，服务器说："+info);
		}

		//4、关闭资源
		br.close();
		is.close();
		pw.close();
		os.close();
		socket.close();
	}
	//通过url获取网页信息
	public static void url(){
		try {
			URL url = new URL("http://www.baidu.com");
			URLConnection uo = url.openConnection();
//			byte[] b = new byte[(int) uo.getContentLengthLong()]; //获取连接返回内容的长度
			InputStreamReader isr = new InputStreamReader(uo.getInputStream(),"utf-8");
			BufferedReader br = new BufferedReader(isr);
			String text = null;
			while((text = br.readLine())!=null){
				System.out.println(text);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
