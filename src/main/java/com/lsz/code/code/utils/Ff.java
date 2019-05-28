package com.lsz.code.code.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ff {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                        if (index == 2){
                            int i = 5/0;
                        }
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
