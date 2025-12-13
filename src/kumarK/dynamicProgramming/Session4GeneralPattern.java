package kumarK.dynamicProgramming;

/*

    Given two arrays select subset from two arrays such that
    no two adjacent elements are selected

    either select from array a or array b

    example

    a -> [2 3 4 -8 2]
    b -> [-5 8 3 1 -4]

    1) only one element from either a or b
    2) no two elements should be consecutive

    eg 2 4 3 2
       8 7 6 5

       then 8+3 = 11 can be selected but not 7+3 = 10

       the sum should be maximized

       1) first calculate dp[0],dp[1],dp[2]
       2) create a general formual for dp[i]
       3) dp[n] is the final answer

       2 3 4 -8 2
       -5 8 3 1 -4

       dp[0] = Math.max(a[0], b[0])
       dp[1] = Math.max(dp[0], Math.max(a[1], b[1]))
       .....
       dp[i] = Math.max(dp[i-1], Math.max(a[i],b[i]))

 */

public class Session4GeneralPattern {

    public int nonAdjacentTwoArrays(int[] a,int[] b) {

        int length = a.length;
        int dp[] = new int[length];

        dp[0] = Math.max(a[0], b[0]);
        dp[1] = Math.max(dp[0], Math.max(a[1], b[1]));

        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(a[i], b[i]));
        }
        return dp[length - 1];
    }

    public static void main() {

        int a[] = {2,3,4,-8,2};
        int b[] = {-5,8,3,1,-4};
        Session4GeneralPattern obj = new Session4GeneralPattern();
        System.out.println(obj.nonAdjacentTwoArrays(a,b));
    }
}
