package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class OddEvenPrintWithThreads {



    public static void main(String[] args) {
        List<Runnable> tasks = new ArrayList<>();
        AtomicInteger integer = new AtomicInteger();
        Runnable even = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    if (integer.get() % 2 == 0) {
                        System.out.println("Even =" + integer.getAndIncrement() +" thread is ="+ Thread.currentThread().getName());
                    }
                }
            }
        };
        Runnable odd = new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(integer.get()%2!=0){
                        System.out.println("Odd ="+ integer.getAndIncrement()+" thread is ="+ Thread.currentThread().getName());
                    }
                }
            }
        };
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(even);
        es.execute(odd);

    }
}
