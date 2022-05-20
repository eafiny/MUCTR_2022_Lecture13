package ru.muctr.Exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Core {
    public static void main(String[] args) {
        List<String> buffer1 = new ArrayList<>();
        List<String> buffer2 = new ArrayList<>();

        Exchanger<List<String>> exchanger = new Exchanger<>();

        Producer producer = new Producer(buffer1,exchanger);
        Consumer consumer = new Consumer(buffer2, exchanger);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
