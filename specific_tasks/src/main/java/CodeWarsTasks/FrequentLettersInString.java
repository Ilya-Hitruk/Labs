package CodeWarsTasks;

import java.util.HashMap;
import java.util.Map;

public class FrequentLettersInString {
    public static void main(String[] args) {
        System.out.println(duplicateCount("aA11"));
    }

    public static int duplicateCount(String text) {
        Map<Character, Integer> frequentChars = new HashMap<>();

        for (char ch : text.toLowerCase().toCharArray()) {
            if (frequentChars.containsKey(ch)) {
                frequentChars.put(ch, frequentChars.get(ch) + 1);
                continue;
            }
            frequentChars.put(ch, 0);
        }
        return (int) frequentChars.values().stream().filter(el -> el > 0).count();
    }
}

