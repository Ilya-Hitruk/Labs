package Callable_Future_ExecutorService;

import java.util.concurrent.*;

public class CallableExample {
    static final int TEST_NUMBER = 5;
    static int factorialResult;

    public static void main(String[] args) {
        Factorial factorial = new Factorial(TEST_NUMBER);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(factorial);

        try {
            factorialResult = future.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            e.getCause();
        }
        finally {
            executorService.shutdown();
        }

        System.out.println(factorialResult);
    }
}

class Factorial implements Callable<Integer> {
    private final int f;

    public Factorial(int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {
        if (f < 0) {
            throw new Exception("Invalid number");
        }

        int result = 1;
        for (int i = 1; i <= f; i++) {
            result *= i;
        }
        return result;
    }
}
