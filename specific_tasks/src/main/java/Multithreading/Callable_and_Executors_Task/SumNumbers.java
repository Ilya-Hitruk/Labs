package Multithreading.Callable_and_Executors_Task;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumNumbers {

    private final static int COUNT_OF_THREADS = 10;
    private final static long RANGE = 1_000_000_000;
    private static long sum = 0;
    private final static List<Future<Long>> listOfLocalSums = new ArrayList<>();

    @SneakyThrows
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_OF_THREADS);

        long valueDividedBy_10 = RANGE / 10;
        for (int i = 0; i < COUNT_OF_THREADS; i++) {
            long from = valueDividedBy_10 * i + 1;
            long to = valueDividedBy_10 * (i + 1);

            PartialSum task = new PartialSum(from, to);
            Future<Long> futurePartialSum = executorService.submit(task);
            listOfLocalSums.add(futurePartialSum);
        }

        for (Future<Long> localSum: listOfLocalSums) {
            sum += localSum.get();
        }

        executorService.shutdown();
        System.out.println("Total sum = " + sum);

    }
}

class PartialSum implements Callable<Long> {

    private final long from;
    private final long to;
    private long localSum;

    public PartialSum(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call() {
        for (long i = from; i <= to; i++) {
            localSum += i;
        }
        System.out.println("Sum from " + from + " to " + to + " = " + localSum);
        return localSum;
    }
}
