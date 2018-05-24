package com.sortdemo.thread.forkjoinpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by dell on 2018/5/21.
 */
public class SumNumberTask extends RecursiveTask<Integer>{

    private Integer [] arr ;
    private Integer start;
    private Integer end;
    private Integer THRESHOLD = 1000;

    public SumNumberTask(Integer start,Integer end,Integer [] arr){
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start < THRESHOLD) {
            Integer sum = 0;
            for (int i = start; i < arr.length; i++) {
                sum += arr[i];
            }

            return sum;
        }

        Integer middle = (start + end)/2;
        ForkJoinTask<Integer> leftTask = new SumNumberTask(start,middle,arr);
        ForkJoinTask<Integer>  rightTask = new SumNumberTask(middle,arr.length,arr);
        invokeAll(leftTask,rightTask);

        Integer result1 = leftTask.join();
        Integer result2 = rightTask.join();
        return result1+result2;
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();
        Integer [] arr = new Integer[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i;
        }
        ForkJoinPool fjp = new ForkJoinPool();

        Integer result = fjp.invoke(new SumNumberTask(1,arr.length,arr));
        long end = System.nanoTime();
        System.out.println("result:"+result+"  total time:"+(end-start)/1.0e9);

    }
}

