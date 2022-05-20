package ru.muctr.Executors;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ServiceDemo {
    public static void main(String[] args) {
//        Thread t = new Thread(()->{
//           while (!Thread.currentThread().isInterrupted()){
//               System.out.println(Thread.currentThread().getName());
//           }
//        });
//        t.start();
//        t.interrupt();

//        ExecutorService service = Executors.newSingleThreadExecutor();
//        service.execute(()->{
//            System.out.println("Java");
//        });
//        service.shutdown();
//
//       ExecutorService service1 = Executors.newFixedThreadPool(3);
//        for (int i = 0; i <10; i++){
//            final int j = i;
//            service1.execute( ()-> {
//                try {
//                    System.out.println(j + "Start");
//                    Thread.sleep(2000);
//                    System.out.println(j + "End");
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//            });
//        }
//        service1.shutdown();

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(()->{
            System.out.println("Java");
        }, 2, 1, TimeUnit.SECONDS);
//        service.scheduleWithFixedDelay(()->{
//            System.out.println("Java");
//        }, 2, 3, TimeUnit.SECONDS);
//        service.schedule(()->{
//            System.out.println("Java");
//        }, 3, TimeUnit.SECONDS);

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();

    }
}
