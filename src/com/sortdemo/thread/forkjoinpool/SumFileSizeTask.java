package com.sortdemo.thread.forkjoinpool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by dell on 2018/5/21.
 */
class SumFileSizeTask extends RecursiveTask<Long> {

    final File file;
    public SumFileSizeTask(File file){
        this.file = file;
    }


    @Override
        protected Long compute() {
        return computeSize();
    }

    protected Long computeSize() {

        Long size = 0l;
        if (file.isFile()){
            size+=file.length();
            System.out.println("file--"+file.getName()+"size= "+size);
        }else{
            System.out.println("directory--"+file.getName());
            File [] files = file.listFiles();
            if (files != null) {
                List<ForkJoinTask<Long>> tasks = new ArrayList<ForkJoinTask<Long>>();
                for (File f : files) {
                    if (f.isFile()) {
                        return size += f.length();
                    } else {
                        tasks.add(new SumFileSizeTask(f));
                    }
                }

                for (ForkJoinTask<Long> longForkJoinTask : invokeAll(tasks)) {
                    size += longForkJoinTask.join();
                }
            }
        }
        return size;
    }
}


class SumFileSizePool {
    public static void main(String[] args) {
        long start = System.nanoTime();
        File file = new File("e:/");

//        Long size = new SumFileSizeTask(file).computeSize();

        ForkJoinPool fjp = new ForkJoinPool();
        ForkJoinTask<Long> task = new SumFileSizeTask(file);
        Long size = fjp.invoke(task);
        long end = System.nanoTime();
        System.out.println("size:"+size+ "   total time : "+ (end-start)/1.0e9);
        System.out.println("RD"+new Random().nextInt(100000000));
    }
}