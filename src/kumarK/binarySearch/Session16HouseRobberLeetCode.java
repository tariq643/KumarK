package kumarK.binarySearch;

/*
    There are several consecutive houses along a street, each of which has some money inside. There is also a robber, who wants to steal money from the homes, but he refuses to steal from adjacent homes.

    The capability of the robber is the maximum amount of money he steals from one house of
    all the houses he robbed.

    You are given an integer array nums representing how much money is stashed in each house.
    More formally, the ith house from the left has nums[i] dollars.

    You are also given an integer k, representing the minimum number of houses the robber will steal from.
    It is always possible to steal at least k houses.

    Return the minimum capability of the robber out of all the possible ways to steal at least k houses.



            Example 1:

    Input: nums = [2,3,5,9], k = 2
    Output: 5
    Explanation:
    There are three ways to rob at least 2 houses:
            - Rob the houses at indices 0 and 2. Capability is max(nums[0], nums[2]) = 5.
            - Rob the houses at indices 0 and 3. Capability is max(nums[0], nums[3]) = 9.
            - Rob the houses at indices 1 and 3. Capability is max(nums[1], nums[3]) = 9.
    Therefore, we return min(5, 9, 9) = 5.
    Example 2:

    Input: nums = [2,7,9,3,1], k = 2
    Output: 2
    Explanation: There are 7 ways to rob the houses. The way which leads to minimum capability is to rob
    the house at index 0 and 4. Return max(nums[0], nums[4]) = 2.
*/

/*
* for the example [2,3,5,9] can we rob k = 2 houses in such a way that the capability would be 9 ??
* approach is pretty simple
* first we use linear search brute force
* */

/*
* for test case 2 7 9 3 1 for k = 2
* the low capability = 1 and high capability = 9
* so is it possible
* */

import java.util.Arrays;

public class Session16HouseRobberLeetCode {

    // brute force using recursion
    public int minCapability(int[] nums, int k) {

        int n = nums.length;
        int[][] dp = new int[n+1][k+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return this.solvemeMemoizated(nums, 0 ,k, dp);
    }

    // recursion helper function without memoization
    private int solve (int[] nums, int i, int k) {
        // base case
        if (k == 0) {
            return 0; // no more houses to be covered
        }
        // invalid path
        if (i >= nums.length) {
            return Integer.MAX_VALUE;
        }
        int pick = Math.max(this.solvemeMemoizated(nums, i+2, k-1), nums[i]);
        int nonPick = this.solve(nums, i+1, k);
        return Math.min(pick, nonPick);
    }

    // recursion helper function with memoization (dynamic programming)
    private int solvemeMemoizated (int[] nums, int i, int k, int[][] dp) {
        // base case
        if (k == 0) {
            return 0; // no more houses to be covered
        }
        // invalid path
        if (i >= nums.length) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][k] != -1) {
            return dp[i][k];
        }

        int pick = Math.max(this.solvemeMemoizated(nums, i+2, k-1, dp), nums[i]);
        int nonPick = this.solvemeMemoizated(nums, i+1, k, dp);
        return dp[i][k] = Math.min(pick, nonPick);
    }

    /*
    * observation if in any question we need to maximize the
    * */
}
