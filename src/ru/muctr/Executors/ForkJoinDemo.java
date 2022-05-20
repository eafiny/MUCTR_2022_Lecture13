package ru.muctr.Executors;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo {
    static long Iterations = 20_000_000_000L;
    static int numOfCores = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        System.out.println("Число логических процессоров = " + numOfCores);
        long time = System.currentTimeMillis();
        long j = 0;
        for (long i = 0; i < Iterations; i++){
            j += i;
        }
        System.out.println(j);

//        ForkJoinPool pool = new ForkJoinPool(numOfCores);
//        System.out.println(pool.invoke(new MyFork(0, Iterations)));
        System.out.println(System.currentTimeMillis() - time);
    }

    static class MyFork extends RecursiveTask<Long> {
        long from, to;

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if ((to - from) <= Iterations / numOfCores) {
                long j = 0;
                for (long i = from; i < to; i++) {
                    j += i;
                }
                return j;
            } else {
                long middle = (from + to) / 2;
                MyFork firstHalf = new MyFork(from, middle);
                MyFork secondHalf = new MyFork(middle + 1, to);
                MyFork.invokeAll(firstHalf,secondHalf);

                long res = 0;
                res += firstHalf.join();
                res += secondHalf.join();
                return res;
            }
        }
    }

}
