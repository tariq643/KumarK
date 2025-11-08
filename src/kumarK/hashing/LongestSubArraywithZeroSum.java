package kumarK.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraywithZeroSum {

    int maxLength(int nums[]) {

        Map<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0, len = 0, maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum == 0) {
                maxLen = i + 1;
            }
            if (sumMap.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - sumMap.get(sum));
            }
            else {
                sumMap.put(sum, i);
            }
        }
        return maxLen;
    }
}
