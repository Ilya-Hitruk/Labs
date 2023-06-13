package Multithreading.SemaphoreExample;

import java.util.concurrent.Semaphore;

public class SemaphoreTask {
    private static final Semaphore callBox = new Semaphore(2);

    public static void main(String[] args) {
        new Person("Ilya", callBox);
        new Person("Leonid", callBox);
        new Person("Tatiana", callBox);
        new Person("Ekaterina", callBox);
        new Person("Vitaliy", callBox);
    }
}

class Person extends Thread {

    private final String name;

    private final Semaphore callBox;

    public Person(String name, Semaphore callBox) {
        this.name = name;
        this.callBox = callBox;
        this.start();
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is waiting...");
            callBox.acquire();
            System.out.println(name + " is using call box");
            Thread.sleep(2000);
            System.out.println(name + " finished his call");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            callBox.release();
        }
    }
}
