package com.company;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

    public static AtomicReference<Date> ref = new AtomicReference<>();

    public static void main(String[] args) {
        System.out.println("before: " + ref.get());
        ref.compareAndSet(ref.get(), new Date());
        System.out.println("after: " + ref.get());
    }
}
