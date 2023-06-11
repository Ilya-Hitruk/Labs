package Multithreading.Callable_Future_ExecutorService;

import java.util.concurrent.*;


// CALLABLE CAN BE USED ONLY WITH EXECUTOR SERVICES
public class CallableExample {
    static final int TEST_NUMBER = 5;
    static int factorialResult;

    public static void main(String[] args) {
        Factorial factorial = new Factorial(TEST_NUMBER);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(factorial);

        try {
            System.out.println(future.isDone());
            factorialResult = future.get(); // get method will block current thread till it gets result
            System.out.println(future.isDone());
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
            Thread.sleep(1000);
        }
        return result;
    }
}
