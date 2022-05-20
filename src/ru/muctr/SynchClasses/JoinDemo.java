package ru.muctr.SynchClasses;

/**
 * @author Evgenia Skichko
 */
public class JoinDemo {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println("Working...");
        });
        t.start();
        Thread t2 = new Thread(()->{
            System.out.println("Working...");
        });
        t.start();
        Thread t3 = new Thread(()->{
            System.out.println("Working...");
        });
        t.start();


        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread working");
    }
}
