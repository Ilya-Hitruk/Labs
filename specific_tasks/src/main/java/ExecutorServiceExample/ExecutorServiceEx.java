package ExecutorServiceExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceEx {

    static final int COUNT_OF_THREADS = 5;
    public static void main(String[] args) {

        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(COUNT_OF_THREADS);


        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new RunnableImplementedClass());
        }

        threadPoolExecutor.shutdown();

        //threadPoolExecutor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Main method ends");
    }
}

class RunnableImplementedClass implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
