package com.test;

import com.util.SnowflakeIdWorker;

public class SWtest {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(1, 1);
        long startTime = System.nanoTime();
        for (int i = 0; i < 50000; i++) {
            long id = idWorker.nextId();
            System.out.println(id);
        }
        System.out.println((System.nanoTime()-startTime)/1000000+"ms");
    }
}
