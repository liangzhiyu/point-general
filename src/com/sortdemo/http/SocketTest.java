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
	
	
	//========================UDPЭ��ͨ��==============================
	/**UDPЭ��ͨ�ţ��������ˣ�*/
	public static void serverSocketByUDP() throws IOException{
		//�������ˣ�ʵ�ֻ���UDP���û���¼
		//1��������������DatagramSocket��ָ���˿�
		DatagramSocket socket =new DatagramSocket(10010);
		//2���������ݱ������ڽ��ܿͻ��˷��͵�����
		byte[] data =new byte[1024];//
		DatagramPacket packet =new DatagramPacket(data,data.length);
		System.out.println("��������������");
		//3�����ܿͻ��˷��͵�����
		socket.receive(packet);//�˷����ڽ������ݱ�֮ǰ��һ������
		//4����ȡ����
		String info =new String(data,0,data.length);
		System.out.println("���Ƿ��������ͻ��˸�����"+info);

		//------------------------------
		//��ͻ�����Ӧ����
		//1������ͻ��˵ĵ�ַ���˿ںš�����
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "��ӭ����".getBytes();
		//2���������ݱ���������Ӧ��������Ϣ
		DatagramPacket packet2 = new DatagramPacket(data2,data2.length,address,port);
		//3����Ӧ�ͻ���
		socket.send(packet2);
		//4���ر���Դ
		socket.close();
	}

	/**UDPЭ��ͨ�ţ��ͻ��ˣ�*/
	public static void clientSocketByUDP() throws IOException {
		// �ͻ���
		// 1������������ĵ�ַ���˿ںš�����
		InetAddress address = InetAddress.getByName("localhost");
		int port = 10010;
		byte[] data = "�û�����admin;���룺123".getBytes();
		// 2���������ݱ����������͵�������Ϣ
		DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
		// 3������DatagramSocket����
		DatagramSocket socket = new DatagramSocket();
		// 4�����������������
		socket.send(packet);

		// ���ܷ���������Ӧ����
		// ------------------------
		// 1���������ݱ������ڽ��ܷ���������Ӧ����
		byte[] data2 = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
		// 2�����ܷ�������Ӧ������
		socket.receive(packet2);
		String reply = new String(data2, 0, packet2.getLength());
		System.out.println("���ǿͻ��ˣ�������˵��" + reply);
		// 4���ر���Դ
		socket.close();
	}
	
	
	
	//============================TCPЭ��ͨ��==========================
	
	/** ����TCPЭ���Socketͨ�ţ�ʵ���û���¼�������*/
	public static void serverSocketByTCP() throws IOException {
		//1������һ����������Socket����ServerSocket��ָ���󶨵Ķ˿ڣ��������˶˿�
		ServerSocket serverSocket =new ServerSocket(10086);//1024-65535��ĳ���˿�
		//2������accept()������ʼ�������ȴ��ͻ��˵�����
		Socket socket = serverSocket.accept();
		//3����ȡ������������ȡ�ͻ�����Ϣ
		InputStream is = socket.getInputStream();
		InputStreamReader isr =new InputStreamReader(is);
		BufferedReader br =new BufferedReader(isr);
		String info =null;
		while((info=br.readLine())!=null){
		System.out.println("���Ƿ��������ͻ���˵��"+info);
		}
		socket.shutdownInput();//�ر�������
		//4����ȡ���������Ӧ�ͻ��˵�����
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		pw.write("��ӭ����");
		pw.flush();

		//5���ر���Դ
		pw.close();
		os.close();
		br.close();
		isr.close();
		is.close();
		socket.close();
		serverSocket.close();
	}
	
	/** ����TCPЭ���Socketͨ�ţ�ʵ���û���¼���ͻ���*/
	public static void clientSocketByTCP() throws IOException {
		//1�������ͻ���Socket��ָ����������ַ�Ͷ˿�
		Socket socket =new Socket("localhost",10086);
		//2����ȡ���������������˷�����Ϣ
		OutputStream os = socket.getOutputStream();//�ֽ������
		PrintWriter pw =new PrintWriter(os);//���������װ�ɴ�ӡ��
		pw.write("�û�����admin�����룺123");
		pw.flush();
		socket.shutdownOutput();
		//3����ȡ������������ȡ�������˵���Ӧ��Ϣ
		InputStream is = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String info = null;
		while((info=br.readLine())!=null){
		 System.out.println("���ǿͻ��ˣ�������˵��"+info);
		}

		//4���ر���Դ
		br.close();
		is.close();
		pw.close();
		os.close();
		socket.close();
	}
	//ͨ��url��ȡ��ҳ��Ϣ
	public static void url(){
		try {
			URL url = new URL("http://www.baidu.com");
			URLConnection uo = url.openConnection();
//			byte[] b = new byte[(int) uo.getContentLengthLong()]; //��ȡ���ӷ������ݵĳ���
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
