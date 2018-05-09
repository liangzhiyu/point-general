package com.sortdemo.thread;

/**
 * Created by dell on 2018/4/21.
 */
public class RunMain implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"ffffffff");
    }

    public static void main(String[] args) {
        RunMain rm = new RunMain();
        Thread.currentThread().setName("second");
        rm.run();
    }
}
