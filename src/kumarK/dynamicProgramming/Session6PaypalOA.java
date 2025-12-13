package kumarK.dynamicProgramming;

/*

Paypal OA :-> Find the largest valid substring -
Valid string is a string where adjacent pair of char have diff<=k

-> dp[i] = largest valid substring ending at index “i”

-> if(abs(s[i-1]-s[i])<=k){
    -> dp[i] = 1 + dp[i-1]
}else{
    -> dp[i] = 1
}

-> Max(dp[1],dp[2],dp[3],..................dp[n])
-> once you know the max value find the smallest index “i” such that
dp[i] = max; and from there print the string

C++ https://ideone.com/GjcWIu
Java. https://ideone.com/PhWlRX.
Py https://ideone.com/h2gnlv



 */

public class Session6PaypalOA {
}
