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
....

 */

public class Session5AmazonOA {
}
