package ru.muctr.Exchanger;

import java.util.concurrent.Exchanger;

public class PresentExchange {

    public static void main(String[] args) {
         Exchanger<String> exchanger = new Exchanger<>();

        new Thread(()->{
            String present1 = "Book";
            System.out.println("Поток 1 собирается подарить " + present1);
            try {
                Thread.sleep(5000);
                present1 = exchanger.exchange(present1);
                System.out.println("Поток 1 получил в подарок " + present1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            String present2 = "Flowers";
            System.out.println("Поток 2 собирается подарить " + present2);
            try {
                present2 = exchanger.exchange(present2);
                System.out.println("Поток 2 получил в подарок " + present2);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();
    }
}
