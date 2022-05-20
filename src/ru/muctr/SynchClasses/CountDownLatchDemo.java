package ru.muctr.SynchClasses;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++){
            final  int j = i;
            new Thread(()->{
                System.out.println(j+ "start");
                try{
                    Thread.sleep(3000);
                    latch.countDown();
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(j + "end");

            }).start();
        }

        //основной поток
        try {
            latch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("END");
    }
}
