package com.kanni.AsyncSpringDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class AsyncController {

    @Autowired
    AsyncServiceImpl asyncService;

    @GetMapping("/sync")
    public String testWithoutAsync() throws InterruptedException {
        long start=System.currentTimeMillis();
        Thread.currentThread().setName("sync_thread");
        System.out.println("Thread Name :  "+Thread.currentThread().getName());

        asyncService.holdThread();
        return "success for API done = "+(System.currentTimeMillis()-start) + " millisecond";

    }

    @GetMapping("/async")
    public String testWithAsync() throws InterruptedException {
        long start=System.currentTimeMillis();
        Thread.currentThread().setName("async_thread");
        System.out.println("Thread Name :  "+Thread.currentThread().getName());

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    asyncService.holdThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        return "success for API done = "+(System.currentTimeMillis()-start) + " millisecond";

    }


    @GetMapping("/Async")
    public String holdThreadAsync() throws InterruptedException {
        long start=System.currentTimeMillis();
        Thread.currentThread().setName("Async_thread_1");
        System.out.println("Thread Name :  "+Thread.currentThread().getName());


        asyncService.holdThreadAsync();

        return "success testAsync for API done = "+(System.currentTimeMillis()-start) + " millisecond";

    }

}
