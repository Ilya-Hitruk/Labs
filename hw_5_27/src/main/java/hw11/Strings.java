package hw11;

public class Strings {
    public static void main(String[] args) {
        String example = "Python Exercise";
        String check = "Pyt";
        System.out.println(isEndsStringMethod(example, check));
        System.out.println(isEndsLoop(example, check));
        System.out.println(isContainsStringMethod(example, check));
        System.out.println(isContainsLoop(example, check));
        System.out.println(isEqualsStringMethod(example, check));
        System.out.println(isEqualsLoop(example, check));
        System.out.println(isStartsStringMethod(example, check));
        System.out.println(isStartsLoop(example, check));


    }

    /////////////////////////////////// EndsWith
    private static boolean isEndsStringMethod(String example, String ends) {
        return example.endsWith(ends);
    }

    private static boolean isEndsLoop(String example, String check) {
        int exampleLastIndex = example.length() - 1;

        for (int i = check.length() - 1; i >= 0; i--) {
            if (check.charAt(i) != example.charAt(exampleLastIndex)) {
                return false;
            }
            exampleLastIndex--;
        }
        return true;
    }

    /////////////////////////////////// Contains
    private static boolean isContainsStringMethod(String example, String check) {
        return example.contains(check);
    }

    private static boolean isContainsLoop(String example, String content) {
        int sameLetters = 0;
        int contentIndex = 0;
        for (int i = 0; i < example.length(); i++) {

            if (example.charAt(i) == content.charAt(contentIndex)) {
                sameLetters++;
                contentIndex++;
            } else {
                sameLetters = 0;
                contentIndex = 0;
            }

            if (sameLetters == content.length()) {
                return true;
            }
        }
        return false;
    }

    //////////////////////////////////// Comparing ignore case
    private static boolean isEqualsStringMethod(String example, String check) {
        return example.equalsIgnoreCase(check);
    }

    private static boolean isEqualsLoop(String example, String check) {
        String lowerExample = example.toLowerCase();
        String lowerCheck = check.toLowerCase();
        for (int i = 0; i < example.length(); i++) {
            if (lowerExample.charAt(i) != lowerCheck.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    //////////////////////////////////// Starts with another string
    private static boolean isStartsStringMethod(String example, String check) {
        return example.startsWith(check);
    }

    private static boolean isStartsLoop(String example, String check) {
        for (int i = 0; i < check.length(); i++) {
            if (example.charAt(i) != check.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
