package hw5;

import java.util.*;

public class OperationsWithArrays {

    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, Integer> wordsMap = new HashMap<>();
    static final int COORDINATE_SIZE = 2;


//    Function

    public static void main(String[] args) {

        System.out.println("Write your words divided by space");
        String[] inputStringArray = inputString().split(" ");
        System.out.println(Arrays.toString(inputStringArray));
        System.out.println("Write the letter");
        char ch = scanner.nextLine().charAt(0);
        System.out.println("Write the string");
        String letters = scanner.nextLine();

        for (String word: inputStringArray) {
            if (wordsMap.containsKey(word)) {
                wordsMap.put(word, wordsMap.get(word) + 1);
            } else {
                wordsMap.put(word, 1);
            }
        }

        outputResult(getSameWords(wordsMap),
                getFrequentWord(wordsMap),
                getFirstWord(inputStringArray),
                getLastWord(inputStringArray),
                getLettersCoordinate(inputStringArray, ch),
                getSameLetters(letters));


    }


    public static String inputString() {
        String input = scanner.nextLine().strip();
        if (input.isEmpty() || input.isBlank()) {
            System.out.println("Empty string! Please write your words divided by space");
            inputString();
        }
        return input;
    }


    public static int getSameWords(Map<String, Integer> hashMap) {
        int sameWords = 0;

        for (Map.Entry<String,Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > 1) {
                sameWords += entry.getValue();
            }
        }

        hashMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(word -> System.out.printf("(%s) - (%d)\n", word.getKey(), word.getValue()));

        return sameWords;
    }

    public static String getFrequentWord(Map<String, Integer> hashMap) {
        StringBuilder mostFrequentWord = new StringBuilder();
        int maxValue = 0;


        for (Map.Entry<String,Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                if (!mostFrequentWord.isEmpty()) {
                    mostFrequentWord.delete(0, mostFrequentWord.length());
                }
                mostFrequentWord.append(entry.getKey());
            } else if (entry.getValue() == maxValue) {
                mostFrequentWord.append(" | ").append(entry.getKey());
            }
        }
        return mostFrequentWord.toString();
    }

    public static int[] getLettersCoordinate(String[] words, char ch) {
        int[] coordinate = new int[COORDINATE_SIZE];
        boolean isFound = false;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (words[i].charAt(j) == ch) {
                    coordinate[0] = i;
                    coordinate[1] = j;
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                break;
            }
        }
        return coordinate;
    }

    public static int getSameLetters(String letters) {
        int counter = 1;
        char ch;
        for (int i = 0; i < letters.length(); i++) {
            ch = letters.charAt(i);
            for (int j = i + 1; j < letters.length(); j++) {
                if (ch == letters.charAt(j)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static String getFirstWord(String[] words) {
        return words[0];
    }

    public static String getLastWord(String[] words) {
        return words[words.length - 1];
    }

    public static void outputResult(int sameWords, String mostFrequentWord, String firstWord,
                                    String lastWord, int[] coordinates, int sameLetters) {
        System.out.printf("""
                
                Count of same words: %d
                Most frequent word(-s): %s
                First word is %s
                Last word is %s
                
                Coordinates of letter: [%d, %d]
                
                Same letters in string: %d
                """,sameWords, mostFrequentWord, firstWord, lastWord, coordinates[0], coordinates[1], sameLetters);
    }
}