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
}
