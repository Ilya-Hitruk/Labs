package hw9;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Brackets {

        private static final Map<Character, Character> mapOfBrackets = new HashMap<>();
    private static final int FIRST = 0;

    static {
        mapOfBrackets.put('}', '{');
        mapOfBrackets.put(')', '(');
        mapOfBrackets.put(']', '[');
        mapOfBrackets.put('>', '<');
    }

    private static final Stack<Character> stack = new Stack<>();
    public static void main(String[] args) {
        String example = "()(){[]}";


        //  Iterative
        long time = System.nanoTime();
        System.out.println(iterativeIsValidBrackets(example));
        System.out.println(System.nanoTime() - time);

        //  Recursive with ENUM
        long recursiveTimeEnum = System.nanoTime();

        System.out.println(recursiveIsValidBracketsEnum(example, stack, FIRST));
        System.out.println(System.nanoTime() - recursiveTimeEnum);

//         Recursive with MAP
        long recursiveTimeMap = System.nanoTime();
        System.out.println(recursiveIsValidBracketsMap(example, stack, FIRST));
        System.out.println(System.nanoTime() - recursiveTimeMap);


    }
    private static boolean recursiveIsValidBracketsEnum(String bracketsString, Stack<Character> stack, int element) {
        if (element == bracketsString.length()) {
            return stack.isEmpty();
        }

        char currentChar = bracketsString.charAt(element);

        if (currentChar == KindsOfBrackets.OPEN_CURLY_BRACKET.getBracket()
                || currentChar == KindsOfBrackets.OPEN_ROUND_BRACKET.getBracket()
                || currentChar == KindsOfBrackets.OPEN_SQUARE_BRACKET.getBracket()) {
            stack.push(currentChar);
        }

        if (isValidBracket(currentChar) && (stack.isEmpty() || compareBrackets(currentChar))) {
            return false;
        }
        return recursiveIsValidBracketsEnum(bracketsString, stack, ++element);
    }

    private static boolean isValidBracket(char currentChar) {
        return currentChar == KindsOfBrackets.CLOSE_CURLY_BRACKET.getBracket()
                || currentChar == KindsOfBrackets.CLOSE_ROUND_BRACKET.getBracket()
                || currentChar == KindsOfBrackets.CLOSE_SQUARE_BRACKET.getBracket();
    }

    private static boolean compareBrackets(char currentChar) {
        return (currentChar == KindsOfBrackets.CLOSE_ROUND_BRACKET.getBracket()
                    && stack.pop() != KindsOfBrackets.OPEN_ROUND_BRACKET.getBracket())
                || (currentChar == KindsOfBrackets.CLOSE_SQUARE_BRACKET.getBracket()
                    && stack.pop() != KindsOfBrackets.OPEN_SQUARE_BRACKET.getBracket())
                || (currentChar == KindsOfBrackets.CLOSE_CURLY_BRACKET.getBracket()
                    && stack.pop() != KindsOfBrackets.OPEN_CURLY_BRACKET.getBracket());
    }


    // Recursive method with MAP

    private static boolean recursiveIsValidBracketsMap(String bracketsString, Stack<Character> stack, int element) {
        if (element == bracketsString.length()) {
            return stack.isEmpty();
        }

        char currentChar = bracketsString.charAt(element);

        if (mapOfBrackets.containsValue(currentChar)) {
            stack.push(currentChar);
        }

        if (mapOfBrackets.containsKey(currentChar)) {
            if (stack.isEmpty() || stack.pop() != mapOfBrackets.get(currentChar)) {
                return false;
            }
        }
        return recursiveIsValidBracketsMap(bracketsString, stack, ++element);
    }


    // Iterative method with MAP

    private static boolean iterativeIsValidBrackets(String brackets) {
        Stack<Character> stack = new Stack<>();

        for (char ch: brackets.toCharArray()) {
            if (mapOfBrackets.containsValue(ch)) {
                stack.push(ch);
            } else if (mapOfBrackets.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != mapOfBrackets.get(ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

    enum KindsOfBrackets {
        OPEN_CURLY_BRACKET('{'),
        CLOSE_CURLY_BRACKET('}'),
        OPEN_ROUND_BRACKET('('),
        CLOSE_ROUND_BRACKET(')'),
        OPEN_SQUARE_BRACKET('['),
        CLOSE_SQUARE_BRACKET(']');

        private final char bracket;

        KindsOfBrackets(char bracket) {
            this.bracket = bracket;
        }

        public char getBracket() {
            return bracket;
        }
    }
