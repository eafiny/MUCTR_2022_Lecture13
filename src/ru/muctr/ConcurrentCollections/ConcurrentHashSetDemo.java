package ru.muctr.ConcurrentCollections;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ConcurrentHashSetDemo {
    public static void main(String[] args) {
        Set<Integer> hashset = new CopyOnWriteArraySet<>();
        for (int i = 0; i <10; i++){
            hashset.add(i);
        }
        Iterator<Integer> itr =  hashset.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
            hashset.add(1000);
            hashset.remove(itr.next());
        }

        System.out.println();
        for (Integer i : hashset){
            System.out.println(i);
        }

    }
}
