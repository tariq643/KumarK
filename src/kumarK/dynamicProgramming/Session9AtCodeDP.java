package kumarK.dynamicProgramming;

/*

Taro's summer vacation starts tomorrow, and he has decided to make plans for it now.

The vacation consists of
N days. For each
i (
1≤i≤N), Taro will choose one of the following activities and do it on the
i-th day:

A: Swim in the sea. Gain
a
i
​
  points of happiness.
B: Catch bugs in the mountains. Gain
b
i
​
  points of happiness.
C: Do homework at home. Gain
c
i
​
  points of happiness.
As Taro gets bored easily, he cannot do the same activities for two or more consecutive days.

Find the maximum possible total points of happiness that Taro gains.
 */


/*

    Greedy vs Dynamic Programming
    two pointer is greedy algorithm

    if a problem can be solved by greedy approach
    it means that it is guaranteed that at each step
    you make a choice and that choice is best
    for now as well as the future ...
    then the problem can be solved using greedy method

    if there are multiple choice at each steps and it is not
    clear which choice will give better result long term
    then use dynamic programming

    Easier version : you are given 3 arrays a,b and c
    at each index you either select a(i),b(i) or c(i)
    once you are done selecting n elements
    the sum of all elements to be maximum ...

    max(a(i) + b(i) + c(i))

    select the maximum in each row

    pseudo code :-

    ->n
    ->a(n+1)
    ->b(n+1)
    ->c(n+1)
    sum = 0



 */


/*

    Link  https://atcoder.jp/contests/dp/tasks/dp_c

Greedy vs DP :->

-> If a problem can be solved by the Greedy approach ; it means it is guaranteed ;
that at each step ; you make a choice and that choice is the best possible for now as well as the future.
Then you can solve this problem using the Greedy Method.

-> If there are multiple choices at each step and it is not clear which choice can given you the better
answer long term -> use DP

Easier version of the Question :-> You are given three arrays a ; b ; c -> at each index you either
select a[i] or b[i] or c[i] ; once you are done selecting n elements we want the sum of all elements to be maximum.
Link https://ideone.com/kPNLiz
This is a greedy solution-> Why? -> Self explanatory


Hard Version.-> https://atcoder.jp/contests/dp/tasks/dp_c

-> You cannot select a number from a particular array for more than 1 time consecutively ->
You have to find the maximum sum of all the numbers -> can only be solved by DP-> because
there are multiple choice and any choice you has not guarantee if the future will be great or final answer will be maximum.

-> 3 arrays a b c hence we create 3 dp arrays dpa[] dpb[] dpc[]


dpa[i] = best answer to the question if size of the array was ‘i’ and you selected a[i] at the ith index.

dpb[i] = best answer to the question if size of array is i and selected b[i] at index i

dpc[i] = best answer to the question if size of array is i and selected c[i] at index i

-> dpa[3] = a[3] + max(dpb[2],dpc[2])
Generalize ; substitute.-> i

dpa[i] = a[i] + max(dpb[i-1],dpc[i-1])
dpb[i] = b[i] + max(dpc[i-1],dpa[i-1])



dpc[i] = c[i] + max(dpb[i-1],dpa[i-1]) ;

Put these in a for loop and your job is done.

TC :- O(N)..
SC:- O(N)......


C++  https://atcoder.jp/contests/dp/submissions/42299240

Java https://atcoder.jp/contests/dp/submissions/42308712
Py https://atcoder.jp/contests/dp/submissions/42308782

New Question.-> Same as above ; but you are allowed to take a
maximum of only 2 consecutive numbers ; not more than that->(3 numbers should not be consecutive.)

-> 2 consecutive are allowed;
-> 3 consecutive are not allowed;

-> dpa[1] = a[1] dpb[1] = b[1] dpc[1] = c[1]

-> dpa[2] = a[2] + max(a[1],b[1],c[1])
-> dpb[2] = b[2] + max(a[1],b[1],c[1])
-> dpc[2] = c[2] + max(a[1],b[1],c[1])

-> dpa[3] = a[3] + max(dpb[2],dpc[2]) -> first
               = OR a[3] + a[2] + max(dpb[1],dpc[1])



-> dpb[i] = max(b[i] + max(dpa[i-1],dpc[i-1]) , b[i] + b[i-1] +max(dpa[i-2],dpc[i-2]))

C++ https://ideone.com/PKYS2S.
Java. https://ideone.com/OaMxSE.
Py https://ideone.com/4wC2i7.


—-----------------------------------------------------------------

Hardest Version. -> https://www.youtube.com/watch?v=oAhlTS7U8GM&t=2s&ab_channel=KumarK%5BAmazon%5D .



 */

public class Session9AtCodeDP {

    // this is a greedy solution
    // because at each step the step is best for the future also
    private int session9AtCodeGreedy (int n, int a[], int b[],int c[]) {

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + Math.max(a[i], Math.max(b[i], c[i]));
        }
        return sum;
    }

    // hard version : DP
    // you cannot select a number from a particular array for more than one
    // time consecutively
    /*

        you have to find the maximum sum of all the numbers -> can only be solved by DP
        -> because there are multiple choices and any choice you have does not guarantee if the
        future will be great of final answer will be maximum

     */
    /*
        3 arrays a b and c hence we create 3 arrays

        dpa[i] = best answer to the question if the size of the
        array was 'i' and you selected a[i] at the 'i' th index

        dpb[i] =  best answer to the question if the size of the
        array was 'i' and you selected b[i] at the 'i' th index

        dpc[i] =  best answer to the question if the size of the
        array was 'i' and you selected c[i] at the 'i' th index


        a1 b1 c1
        a2 b2 c2
        . . . .
        ......



        ......

        dpa[1] = a1
        dpb[1] = b1
        dpc[1] = c1

        now dpa[2] = a2 + either the element b1 or c1
        so  dpa[2] = a2 + max(b1, c1)

        similarly dpb[2] = b2 + either the element a1 or c1
        so  dpb[2] = b2 + max(a1, c1)

        similarly dpc[2] = c2 + either the element b1 or c1
        so  dpc[2] = c2 + max(a1, b1)

        so in general ....
        dpa[i] = a[i] + max(dpb[i-1],dbc[i-1]);
        dpb[i] = b[i] + max(dpa[i-1],dbb[i-1]);
     */

    private long session9AtCodeDynamicProgramming (int n, long a[], long b[],long c[]) {

        long[] dpa = new long[n];
        long[] dpb = new long[n];
        long[] dpc = new long[n];

        dpa[0] = a[0];
        dpb[0] = b[0];
        dpc[0] = c[0];

        if (n > 1) {
            dpa[1] = a[1] + Math.max(dpb[0], dpc[0]);
            dpb[1] = a[1] + Math.max(dpa[0], dpc[0]);
            dpc[1] = a[1] + Math.max(dpa[0], dpb[0]);
        }

        for (int i = 2; i < n; i++) {
            dpa[i] = a[i] + Math.max(dpb[i - 1], dpc[i - 1]);
            dpb[i] = b[i] + Math.max(dpa[i - 1], dpc[i - 1]);
            dpc[i] = c[i] + Math.max(dpa[i - 1], dpb[i - 1]);
        }
        long result = Math.max(dpa[n - 1], Math.max(dpb[n - 1], dpc[n - 1]));
        return result;
    }

    static void main() {
        Session9AtCodeDP obj = new Session9AtCodeDP();
        long a[] = {10, 20 ,30};
        long b[] = {40, 50 ,60};
        long c[] = {70, 80 ,90};
        /*long a[] = {10 ,40, 70};
        long b[] = {20 ,50 ,80};
        long c[] = {30 ,60 ,90};*/
        System.out.println(obj.session9AtCodeDynamicProgramming(3,a,b,c));
    }
}
