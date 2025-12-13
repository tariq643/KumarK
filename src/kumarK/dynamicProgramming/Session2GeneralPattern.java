package kumarK.dynamicProgramming;

/*

    1) dp[] -> N

    2) find dp[1], dp[2] and dp[3] by basic observation

    3) create a general formual for dp[i]

    4) dp[n] will be the final answer

 */


/*
    find the maximum sum subset such that no two elements in the array are adjacent

    dp[1] -> best answer to the problem when the size of array was 1
    dp[2] -> best answer to the problem when the size of array was 2
    dp[3] -> best answer to the problem when the size of array was 3

    ... example if the array is [2,-3,5,-8,7]

    so dp[1] = 2
    dp[2] = 2
    dp[3] = 7

    dp[i] = Math.max(dp[i-1] , arr[i] + dp[i-2])

 */

public class Session2GeneralPattern {

    public int nonAdjacent(int[] nums) {

        int length = nums.length;
        if (length == 1) {
            return nums[length - 1];
        }

        int dp[] = new int[length + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[length - 1];
    }

    public static void main(String[] args) {

        Session2GeneralPattern obj = new Session2GeneralPattern();
        int nums[] = {1, 7, 16, 8};
        System.out.println(obj.nonAdjacent(nums));

    }
}
