package kumarK.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestPalidromeByConcatenation {

    public int longestPalindrome(String[] words) {

        int count = 0;
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            String reversedWord = Character.toString(word.charAt(1)) + Character.toString(word.charAt(0));
            if (map.containsKey(reversedWord)) {
                count = count + 4;
                map.put(reversedWord, map.get(reversedWord) - 1);
                if (map.get(reversedWord) == 0) {
                    map.remove(reversedWord);
                }
            }
            else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String word = entry.getKey();
            Integer freq = entry.getValue();
            if (word.charAt(0) == word.charAt(1) && freq > 0) {
                count = count + 2;
                break;
            }
        }

        return count;
    }
}
