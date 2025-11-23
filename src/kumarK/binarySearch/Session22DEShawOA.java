package kumarK.binarySearch;

/*
-> Question is saying to us :- We are given an array and integer k ;
we have to make maximum k moves on the array such that all elements of array
        become <=0 ; also -> in each move you can :->

Decrease any number of the array by x .

K = 15

Task is to find the minimum possible value of x.

Example :-

Observation : - When the value of x is small ; total operations are more ;
and when value of x is large ; total operations are less.

        [5 8 8 5 5] is our array and max moved allowed are k = 15 ;

So if you select x = 0 ; —-> you cannot achieve the task.

If you select x = 1 ; —--> It will take you 31 steps which is > k ->
cannot achieve task

If you select x = 2 ; —--> will take you 17 steps which is > k ->
cannot achieve the task

If you select x = 3 ; —--> will take you 12 steps which is <= k —>
successfully achieve the task

If you select x = 4 ; —---> will take you 10 steps which is <=k —>
successful

If you select x = 5 ; —---> successful

If you select x = 6 ; —--> same success.
        .
        .
        .
        .
        .
        .
        .
        .
        .
If you select x = infinity —> still successful


Observation : -> Once you become successful for some x ;
you will stay successful for all values >=x ; let's call it the starting point of success.

So —-> [5 8 8 5 5] ; k = 15 ; answer → 3
Once ; you become successful for some x = y ;
Then all x>=y will always be successful ;

Hence y is the minimum possible answer :)

Brute Force Solution :-> Iterate from all values 1 till
you reach y and become successful and y will be your answer.

-> How to check if x = i is successful or not ?

        -> Answer if you travel the full array and calculate the cost.


        C++ :- https://ideone.com/pfmtt9
Java :- https://ideone.com/v0xAes
Python :- https://ideone.com/nGAaDm

TC : O(N*max element of array) = O(100000*1000000000) = very big not efficient jii

Efficient Solution :- You can find the y using binary search as
it a monotonic function ; suppose you have a function f(i) ;

f(i) = true —> it means for x = i ; we can be successful

Hence f array will always look like this :-


F F F F F F F F F F F T T T T T T T T T T T T T T T T T T T T

Hence there will be some F in the starting and at some particular
point T will start coming and that point will be your minimum answer
when you become successful.
*/


import java.util.Scanner;

public class Session22DEShawOA {

    public static boolean f(long x, long k, long[] b, long n) {
        long i = 1;
        long g = 0;

        while (i <= n) {
            if (b[(int)i] % x == 0) {
                g = g + (b[(int)i] / x);
            } else {
                g = g + (b[(int)i] / x) + 1;
            }
            i++;
        }

        return g <= k;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long[] b = new long[(int)n + 1];

        long i = 1;
        long sum = 0;
        while (i <= n) {
            b[(int)i] = scanner.nextLong();
            sum = Math.max(sum, b[(int)i]);
            i++;
        }

        long k = scanner.nextLong();
        long answer = -1;
        long low = 1;
        long high = sum;
        long kk = 0; // binary search will keep running till kk == 0

        while (low <= high && kk == 0) {
            long mid = (low + high) / 2;

            if (f(mid, k, b, n)) {
                if (mid == 1) {
                    answer = 1;
                    kk = 1;
                } else if (!f(mid - 1, k, b, n)) {
                    answer = mid;
                    kk = 1;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
