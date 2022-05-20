package ru.muctr.SynchClasses;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(()->{
            String present1 = "Book";
            System.out.println("Поток 1 хочет подарить " + present1);
            try{
                Thread.sleep(2000);
                present1 = exchanger.exchange(present1);
                System.out.println("Поток 1 получил в подарок " + present1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            String present2 = "Flowers";
            System.out.println("Поток 2 хочет подарить " + present2);
            try{
                Thread.sleep(4000);
                present2 = exchanger.exchange(present2);
                System.out.println("Поток 2 получил в подарок " + present2);
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();
    }
}
