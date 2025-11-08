package kumarK.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfPairsWithAbsoluteDifferenceK {

    public int countKDifference(int[] nums, int k) {

        int count = 0;
        Map<Integer, Integer> cardinalityMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (cardinalityMap.containsKey(nums[i] + k)) {
                count = count + cardinalityMap.get(nums[i] + k);
            }
            if (cardinalityMap.containsKey(nums[i] - k)) {
                count = count + cardinalityMap.get(nums[i] - k);;
            }
            cardinalityMap.put(nums[i], cardinalityMap.getOrDefault(nums[i],0) + 1);
        }
        return count;
    }
}
