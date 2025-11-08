package kumarK.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSumarrayWitkSumK {

    public int longestSubarray(int[] arr, int k) {

        int maxlength = 0, length = 0, sum = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum == k) {
                maxlength = i + 1;
            }
            if (sumMap.containsKey(sum - k)) {
                maxlength = Math.max(maxlength, i - sumMap.get(sum - k));
            }
            if (!sumMap.containsKey(sum)) {
                sumMap.put(sum, i);
            }
        }
        return maxlength;
    }
}
