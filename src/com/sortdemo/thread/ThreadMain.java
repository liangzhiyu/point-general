package com.sortdemo.thread;

public class ThreadMain extends Thread {

    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("name:"+getName()+"    i:"+i);
            Thread.yield();
        }
    }
    public static void main(String[] args) {
//       Thread thread = new ThreadMain();
//       thread.setName("first");
//       thread.start();
//
//       ThreadMain tm = new ThreadMain();
//       tm.setName("second");
//       tm.start();
        newThread(1);
    }

    public static ThreadMain newThread(int i){
        Thread thread = new ThreadMain();
        thread.setName("threadName"+i);
        i++;
        return i>10?null:newThread(i);
    }
}
