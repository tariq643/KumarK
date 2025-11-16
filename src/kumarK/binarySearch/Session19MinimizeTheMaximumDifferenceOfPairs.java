package kumarK.binarySearch;

public class Session19MinimizeTheMaximumDifferenceOfPairs {


 /* You are given a 0-indexed integer array nums and an integer p.
    Find p pairs of indices of nums such that the maximum difference amongst
    all the pairs is minimized. Also, ensure no index appears more than once amongst the p pairs.

    Note that for a pair of elements at the index i and j, the difference of
    this pair is |nums[i] - nums[j]|, where |x| represents the absolute value of x.

    Return the minimum maximum difference among all p pairs. We define the
    maximum of an empty set to be zero. */

    public int minimizeMax(int[] nums, int p) {

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < low) {
                low = num;
            }
            if (num > high) {
                high = num;
            }
        }
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(nums, mid, p)) {
                result = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return result;
    }

    private boolean isPossible(int[] nums, int mid, int p) {


    }
}
