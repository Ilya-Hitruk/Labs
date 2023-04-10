package hw6;

import java.util.ArrayList;
import java.util.List;

public class ArraysMethods {

    public static void main(String[] args) {

        List<Integer> generalList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        System.out.println("List elements " + generalList + "\n");
        System.out.println("Multiple " + divisor(generalList, 2));
        System.out.println("Sum of odds " + sumOfOdd(generalList));
        System.out.println("Indexes " + getIndexes(generalList, 5, 7, 9, 33));
        System.out.println("Sorted growth " + sortArray(generalList, "growth"));
        System.out.println("Sorted decrease " + sortArray(generalList, "decrease"));
        System.out.println("Count of evens " + evens(generalList));
        System.out.println("Count of odds " + odds(generalList));
        System.out.println("Sum of seconds " + sumOfSeconds(generalList));

    }

    public static ArrayList<Integer> divisor(List<Integer> generalList, int divisor) {
        ArrayList<Integer> temporaryList = new ArrayList<>();
        generalList.forEach(x -> {if(x % divisor == 0) temporaryList.add(x);});
        return temporaryList;
    }

    public static int sumOfOdd(List<Integer> generalList) {
        int result = 0;
        for(Integer num: generalList) {
            if (num % 2 != 0) {
                result += num;
            }
        }
        return result;
    }

    public static ArrayList<Integer> getIndexes(List<Integer> generalList, int... numbers) {
        ArrayList<Integer> temporaryList = new ArrayList<>();
        for (int number : numbers) {
            if (!generalList.contains(number)) {
                continue;
            }
            temporaryList.add(generalList.indexOf(number));
        }
        return temporaryList;
    }


    public static ArrayList<Integer> sortArray(List<Integer> generalList, String kindOfSort) {

        if (kindOfSort.equalsIgnoreCase("growth")) {
            for (int i = 0; i < generalList.size() - 1; i++) {
                for (int j = 0; j < generalList.size() - i - 1 ; j++) {
                    if (generalList.get(j) > generalList.get(j + 1)) {
                        int temp = generalList.get(j);
                        generalList.set(j, generalList.get(j + 1));
                        generalList.set(j + 1, temp);
                    }
                }
            }

        } else if (kindOfSort.equalsIgnoreCase("decrease")) {
            for (int i = 0; i < generalList.size() - 1; i++) {
                for (int j = 0; j < generalList.size() - i - 1 ; j++) {
                    if (generalList.get(j) < generalList.get(j + 1)) {
                        int temp = generalList.get(j);
                        generalList.set(j, generalList.get(j + 1));
                        generalList.set(j + 1, temp);
                    }
                }
            }
        }
        return (ArrayList<Integer>) generalList;
    }

    public static int evens(List<Integer> generalList) {
        int count = 0;
        for (Integer num: generalList) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int odds(List<Integer> generalList) {
        int count = 0;
        for (Integer num: generalList) {
            if (num % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    public static int sumOfSeconds(List<Integer> generalList) {
        int result = 0;
        for (Integer num: generalList) {
            if (generalList.indexOf(num) % 2 != 0) {
                result += num;
            }
        }
        return result;
    }
}