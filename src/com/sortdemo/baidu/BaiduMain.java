package com.sortdemo.baidu;

/**
 *  ������
 * @author Legend��
 *
 */
public class BaiduMain {
 
     
public static void main(String[] args) throws Exception {
         
    //��֤�˺Ų���ȡcookie
        String cookie  =  BaiduTieBaNDWS.testAccount("", "");
        //����
        String info = BaiduTieBaNDWS.reply("�������ţB������", "http://tieba.baidu.com/p/1193625840", cookie);
        //��ӡ��������
        System.out.println(info);
    }
}