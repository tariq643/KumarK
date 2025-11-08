package kumarK.hashing;

import java.util.HashMap;
import java.util.Map;

public class MaxDistanceBetweenConsecutiveElements {

    public int maxDistance(int[] nums) {

        Map<Integer, Integer> firstOccurence = new HashMap<>();
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            if (firstOccurence.containsKey(nums[i])) {
                maxDistance = Math.max(maxDistance, i - firstOccurence.get(nums[i]));
            }
            else {
                firstOccurence.put(nums[i], i);
            }
        }
        return maxDistance;
    }
}
