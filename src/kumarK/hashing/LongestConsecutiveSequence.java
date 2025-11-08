package kumarK.hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        // base case if the length of the array is 0
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxCount = Integer.MIN_VALUE;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int x = num;
                int cnt = 1;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt++;
                }
                maxCount = Math.max(cnt, maxCount);
            }
        }
        return maxCount;
    }
}
