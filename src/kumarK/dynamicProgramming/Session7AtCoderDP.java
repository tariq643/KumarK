package kumarK.dynamicProgramming;
/*

There are
N stones, numbered
1,2,…,N. For each
i (
1≤i≤N), the height of Stone
i is
h
i
​
 .

There is a frog who is initially on Stone
1. He will repeat the following action some number of times to reach Stone
N:

If the frog is currently on Stone
i, jump to Stone
i+1 or Stone
i+2. Here, a cost of
∣h
i
​
 −h
j
​
 ∣ is incurred, where
j is the stone to land on.
Find the minimum possible total cost incurred before the frog reaches Stone
N.

Constraints
All values in input are integers.
2≤N≤10
5

1≤h
i
​
 ≤10
4



 */

/*

example for the array [10 100 20]

from index i either to i + 1 or i + 2

Link to the P1 https://atcoder.jp/contests/dp/tasks/dp_a

Understanding :-> You are standing at index 1 of the array. You have to reach the last index N of the array in minimum cost ; you can only make 1 step or 2 step jumps. If you are jumping from index i to index j cost will be-> abs(b[i] - b[j])

General Way :->
->First we declare empty dp[N]

-> We assume dp[i] is the best answer to the question if size of the array is “i”

-> Always try to calculate the dp[1] ; dp[2] ; dp[3] ; dp[4]  by yourself ; this will make you realise the pattern and you will be able to make the formula yourself

-> Then we try to create the formula.

-> We put the formula in the for loop and calculate dp[1] , dp[2] , dp[3] , dp[4] ….. dp[n]

-> Generally dp[n] will be the final answer
[10 500 20 80]
Dp[1] = minimum cost to reach the index1. = 0
Dp[2] = minimum cost to reach the index2. = 490
Dp[3] = best cost to reach index3 from index 1. = 10
Dp[4] = abs(b[3]-b[4]) + dp[3] )    o1 (3→4) -> direct jump
= abs(b[2]-b[4]) + dp[2] o2(2—>4) -> direct jump
Answer will be the minimum of these two.

Dp[4] = min(abs(b[3]-b[4]) + dp[3] , abs(b[2]-b[4]) + dp[2])

General formula->

Dp[i] = min(abs(b[i-1]-b[i]) + dp[i-1] , abs(b[i-2]-b[i]) + dp[i-2])

Using this formula calculate dp[1]...dp[2]....dp[3].....dp[n]

-> dp[n] = final answer to reach the index n in minimum cost


Pseudo Code : - https://ideone.com/mNiVpL
TC :- O(N)
SC :- O(N) (dp[n])

C++ -> https://atcoder.jp/contests/dp/submissions/42276696
Java -> https://atcoder.jp/contests/dp/submissions/42290564
Python-> https://atcoder.jp/contests/dp/submissions/42290680


P2 :->
C++ -> https://atcoder.jp/contests/dp/submissions/42277272
Jv-> https://atcoder.jp/contests/dp/submissions/42294397
Py->
 -> https://atcoder.jp/contests/dp/tasks/dp_b



Understanding of Q2 :-> Same as above ; but you can make a jump of maximum “K” size.

Dp[i] = (i-1—->i)
OR
(i-2—->i)
OR
(i-3—->i)
OR
(i-4—->i)
OR
.
.
.
(i-k—-->i)



Pseudo Code-> https://ideone.com/XGv9SK
TC : - O(N*K)
SC:- O(N) (DP[])



 */

import java.util.Arrays;

// frog jump
public class Session7AtCoderDP {

    public int frogJump(int[] heights) {
        int length = heights.length;
        if (length == 0 || length == 1) {
            return 0;
        }
        if (length == 2) {
            return Math.abs(heights[1] - heights[0]);
        }
        int dp[] = new int[length];
        dp[0] = 0;
        dp[1] = Math.abs(heights[1] - heights[0]);
        dp[2] = Math.min(dp[1], Math.abs(heights[2] - heights[0]));
        for (int i = 2; i < length; i++) {
            int jumpOne = Math.abs(heights[i] - heights[i - 1]) + dp[i - 1];
            int jumpTwo = Math.abs(heights[i] - heights[i - 2]) + dp[i - 2];
            dp[i] = Math.min(jumpOne, jumpTwo);
        }
        return dp[length - 1];
    }

    /*

        A frog wants to climb a staircase with n steps. Given an integer array heights, where heights[i] contains the height of the ith step, and an integer k.



To jump from the ith step to the jth step, the frog requires abs(heights[i] - heights[j]) energy, where abs() denotes the absolute difference. The frog can jump from the ith step to any step in the range [i + 1, i + k], provided it exists.



Return the minimum amount of energy required by the frog to go from the 0th step to the (n-1)th step.


Example 1

Input: heights = [10, 5, 20, 0, 15], k = 2

Output: 15

Explanation:

0th step -> 2nd step, cost = abs(10 - 20) = 10

2nd step -> 4th step, cost = abs(20 - 15) = 5

Total cost = 10 + 5 = 15.

     */

    public int frogJump(int[] heights, int k) {

        int length = heights.length;
        int[] dp = new int[length + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < length; i++) {
            int mmSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    mmSteps = Math.min(mmSteps, jump);
                }
            }
            dp[i] = mmSteps;
        }
        return dp[length - 1];
    }

    static void main() {
        Session7AtCoderDP obj = new Session7AtCoderDP();
        int[] heights = {2, 1, 3, 5, 4};
        obj.frogJump(heights);
    }
}
