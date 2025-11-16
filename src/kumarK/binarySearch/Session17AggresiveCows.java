package kumarK.binarySearch;

import java.util.Arrays;

public class Session17AggresiveCows {


/*    Given an array nums of size n, which denotes the positions of stalls, and an integer k,
    which denotes the number of aggressive cows, assign stalls to k cows such
    that the minimum distance between any two cows is the maximum possible.
    Find the maximum possible minimum distance.


    Examples:
    Input: n = 6, k = 4, nums = [0, 3, 4, 7, 10, 9]

    Output: 3

    Explanation: The maximum possible minimum distance
    between any two cows will be 3 when 4 cows are placed
    at positions [0, 3, 7, 10]. Here the distances between cows are 3, 4, and 3 respectively.
    We cannot make the minimum distance greater than 3 in any ways. */

    public int aggressiveCows(int[] nums, int k) {

        Arrays.sort(nums);

        int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < minValue) {
                minValue = num;
            }
            if (num > maxValue) {
                maxValue = num;
            }
        }
        int low = 1, high = maxValue - minValue, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(nums, k, mid)) {
                ans = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] nums, int k, int minAllowedDistance) {

        int cows = 1, lastStallPos = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - lastStallPos >= minAllowedDistance) {
                cows = cows + 1;
                lastStallPos = nums[i];
            }
            if (cows == k) {
                return true;
            }
        }
        return false;
    }
}
