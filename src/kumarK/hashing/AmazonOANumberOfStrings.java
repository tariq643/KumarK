package kumarK.hashing;

import java.util.HashMap;
import java.util.Map;

public class AmazonOANumberOfStrings {

    public static void main(String[] args) {

        Map<Character, Integer> mp1 = new HashMap<>();
        Map<Character, Integer> mp2 = new HashMap<>();

        String s1 = "monnom" , s2 = "ab";

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            mp1.put(ch, mp1.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            mp2.put(ch, mp2.getOrDefault(ch, 0) + 1);
        }
        int count = 0, val = Integer.MAX_VALUE;
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (!mp1.containsKey(ch)) {
                val = 0;
                break;
            }
            count = mp1.get(ch) / mp2.get(ch);
            val = Math.min(count, val);
        }
        System.out.println(val);
    }
}
