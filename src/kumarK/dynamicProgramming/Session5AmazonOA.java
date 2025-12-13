package kumarK.dynamicProgramming;

/*

Link-> https://www.desiqna.in/15983/amazon-summer-school-sep-2023-minimum-cost-reach-destination (Watch the video for the question pic) -> https://drive.google.com/file/d/1R8LNThwqvOZRUK47E1V0s6U1zaDVwwUM/view?usp=sharing



PseudoCode.-> https://ideone.com/cCStp1


C++ https://ideone.com/eoCHX7
Java. https://ideone.com/Szh6bR
Py https://ideone.com/xkhWiS.


 */

/*

    from one city to other
    the cost is associated
    cost = abs(a(i) - a(i+3))
    cost = abs(a(i) - a(i+1))


    create dp(0), dp(1) and ... dp(i)
    then return dp(n)


example for the array 4 12 13 18 10 12

dp(0) = 0
but dp(1) = 12 - 4 = 8
and dp(2) = dp(1) + arr(2) - arr(1) = 8 + 13 - 12 = 9
.... dp(3) = min(dp(2), dp(0) + arr(3) - arr(0)) = min(9, 18 -4) = 9

calculate dp(n) finally

 */

public class Session5AmazonOA {

    private int session5AmazonOA (int[] cost) {

        int length = cost.length;
        if (length == 1) {
            return cost[0];
        }
        int dp[] = new int[length];
        dp[0] = 0;
        dp[1] = Math.abs(cost[1] - cost[0]) + dp[0];
        dp[2] = Math.abs(cost[2] - cost[1]) + dp[1];
        for (int i = 3; i < length; i++) {
            dp[i] = Math.min(Math.abs(cost[i] - cost[i - 1]) + dp[i - 1],
                    Math.abs(cost[i] - cost[i - 3]) + dp[i - 3]);
        }
        return dp[length - 1];
    }

    public static void main(String[] args) {
        Session5AmazonOA session5AmazonOA = new Session5AmazonOA();

    }
}
