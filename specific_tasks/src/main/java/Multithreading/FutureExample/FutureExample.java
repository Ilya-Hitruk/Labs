package Multithreading.FutureExample;

import java.util.concurrent.*;

public class FutureExample {
    static final int TEST_NUMBER = 5;
    static int factorialResult;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Factorial factorial = new Factorial(TEST_NUMBER);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> future = executorService.submit(factorial);

        System.out.println(future.get()); // get method using submit with runnable implemented class returns null
        System.out.println(future.isDone());

        executorService.shutdown();

        System.out.println(factorialResult);
    }
}

class Factorial implements Runnable {
    private final int f;

    public Factorial(int f) {
        this.f = f;
    }

    @Override
    public void run() {
        if (f < 0) {
            System.out.println("Invalid number");
        }

        int result = 1;
        for (int i = 1; i <= f; i++) {
            result *= i;
        }
        FutureExample.factorialResult = result;
    }
}

