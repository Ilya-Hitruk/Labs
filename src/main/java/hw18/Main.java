package hw18;


import hw18.LinkedList.LinkedListExample;
import hw18.LinkedList.ListInterface;
import hw18.Logger.LoggerTest;
import hw18.Stack.StackExample;
import hw18.Stack.StackInterface;


public class Main {

    private static final Integer[] EXAMPLE = {4, 8, 15, 16, 23, 42};
    private static final LoggerTest loggerTest = new LoggerTest();
    private static final StackInterface<Integer> stackExample = new StackExample<>();

    private static final ListInterface<Integer> listExample = new LinkedListExample<>();
    public static void main(String[] args) {

        // Logger Test
        System.out.println(loggerTest.getFirst());
        loggerTest.add(1);
        loggerTest.add(5, 6);
        System.out.println();


        // Stack Test
        System.out.println(stackExample.push(1));
        System.out.println(stackExample.push(2));
        System.out.println(stackExample.push(3));
        System.out.println("Stack size = " + stackExample.size());

        System.out.println("\n" + stackExample + "\n");


        System.out.println(stackExample.peek());
        System.out.println(stackExample.peek());

        System.out.println("\n" + stackExample + "\n");

        System.out.println(stackExample.pop());
        System.out.println(stackExample.pop());

        System.out.println("\n" + stackExample + "\n");
        System.out.println(stackExample.isEmpty());

        // Sorted List
        listExample.addAll(EXAMPLE);
        listExample.sort(true);
        listExample.stream().forEach(System.out::println);
    }
}