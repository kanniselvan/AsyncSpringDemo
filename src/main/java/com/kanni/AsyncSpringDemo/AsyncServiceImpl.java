package com.kanni.AsyncSpringDemo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class AsyncServiceImpl {


    public void holdThread() throws InterruptedException {

        long start=System.currentTimeMillis();
        System.out.println("SUB Thread Name :  "+Thread.currentThread().getName());
      // TimeUnit.MINUTES.sleep(1);

       TimeUnit.SECONDS.sleep(1);

        System.out.println("Thread wakeup to sleep now................"+(System.currentTimeMillis()-start) );
    }

    @Async
    public void holdThreadAsync() throws InterruptedException {
        long start=System.currentTimeMillis();
        System.out.println("SUB Thread Name :  "+Thread.currentThread().getName());

        // TimeUnit.MINUTES.sleep(1);

        TimeUnit.MINUTES.sleep(5);

        System.out.println("Thread wakeup to sleep now................"+(System.currentTimeMillis()-start) );
    }
}
