package Streams;

import java.util.Arrays;
public class StreamExampleWithArray {
    public static void main(String[] args) {
        int[] array = {4, 8, 15, 16, 23, 42};
        int[] newArr = Arrays.stream(array).map(operand -> {if (operand / 2 == 0) {
        operand = operand / 2;
            }
        return operand;
        }).toArray();

        System.out.println(Arrays.toString(newArr));
    }
}
