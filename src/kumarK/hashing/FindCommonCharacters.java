package kumarK.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonCharacters {

    public List<String> commonChars(String[] words) {

        Map<Character, Integer> minimumMap = new HashMap<>();

        for (char ch = 'a' ; ch <= 'z'; ch ++) {
            minimumMap.put(ch, 1000);
        }

        for (String word : words) {

            Map<Character, Integer> map = new HashMap<>();
            for (Character ch : word.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            for (char ch = 'a' ; ch <= 'z'; ch++) {
                if (map.containsKey(ch)) {
                    minimumMap.put(ch, Math.min(map.get(ch), minimumMap.get(ch)));
                }
                else {
                    minimumMap.put(ch, 0);
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (char ch = 'a' ; ch <= 'z'; ch++) {
            int freq = minimumMap.get(ch);
            while (freq-- > 0) {
                result.add(Character.toString(ch));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindCommonCharacters findCommonCharacters = new FindCommonCharacters();
        String[] words = {"bella","label","roller"};
        findCommonCharacters.commonChars(words);
    }
}
