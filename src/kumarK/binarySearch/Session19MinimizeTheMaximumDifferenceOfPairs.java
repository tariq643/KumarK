package kumarK.binarySearch;

import java.util.Arrays;

public class Session19MinimizeTheMaximumDifferenceOfPairs {


 /* You are given a 0-indexed integer array nums and an integer p.
    Find p pairs of indices of nums such that the maximum difference amongst
    all the pairs is minimized. Also, ensure no index appears more than once amongst the p pairs.

    Note that for a pair of elements at the index i and j, the difference of
    this pair is |nums[i] - nums[j]|, where |x| represents the absolute value of x.

    Return the minimum maximum difference among all p pairs. We define the
    maximum of an empty set to be zero. */

    public int minimizeMax(int[] nums, int p) {

        int length = nums.length;
        Arrays.sort(nums);
        int low = 0, high = nums[length - 1] - nums[0], result = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(nums, mid, p)) {
                result = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return result;
    }

    private boolean isValid(int[] nums, int mid, int p) {

        int i = 0, length = nums.length;
        int countPairs = 0;
        while (i < length - 1) {
            if (nums[i + 1] - nums[i] <= mid) {
                countPairs = countPairs + 1;
                i = i + 2;
            }
            else {
                i = i + 1;
            }
        }
        return countPairs >= p;
    }
}
