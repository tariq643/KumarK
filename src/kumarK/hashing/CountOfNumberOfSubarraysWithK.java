package kumarK.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountOfNumberOfSubarraysWithK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);
        int count = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sumMap.containsKey(sum - k)) {
                count = count + sumMap.get(sum - k);
            }
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
