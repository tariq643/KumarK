package kumarK.binarySearch;
/*

Constraints:-
        1<=N<=100000
        1<=b[i]<=10000000000

Understanding :-> You are given an array you can perform this operation any number of times:-

        -> Pick any index “i” ; remove some quantity from it and put inside index i - 1

        -> After doing these operations let's say g is your maximum value in the array

        -> Find minimum possible g

Analysis:- By doing these operations we can reduce the maximum of array

-> How to find the minimum possible maximum value after doing all the operations optimally

Observation1 -> 1st number can never be decreased. The final answer will always be >=1st number

Observation2 -> sum of the array remains the same after all operations!

Given an array can you make the maximum of your array <=5
        —-----------------------------------------------------------------

Only if all the array elements are <=5

Experiment -> Given an array make the maximum <=5 -> I will try to make all the elements <=5

        -> whatever is the extra quantity is gradually shifting to the left of the array

-> the last number can only be reduced-> so why not reduce ut first safely

→ now we have the algorithm to make all the elements<=g in O(N).
Solution :->

        —> Can you make all the elements <=1 -> O(N) -> Let's say not possible.

        —> Can you make all the elements <=2 -> O(N) -> Let's say not possible.

        —> Can you make all the elements <=3 -> O(N) -> Let's say not possible.

        —> Can you make all the elements <=4 -> O(N) -> Let's say not possible.

        -> Can you make all the elements <=5 -> O(N) -> Let's say possible.
It means your maximum is 5 and answer is 5

        -> Can you make all the elements <=6 -> Yes of course; no need to check.
        .
        .
        .
        .
        .
        .
        .
        .
Can you make all the elements <=infinity -> Yes of course; no need to check.

FF F F T T T T TTTTTTTTTTTTTTTTTTT
1 2 3 4 5 6 7 8 …………………………………………………d

Linear Search :- O(d*N) —> d = Max element of the array
Binary Search :- O(logd*N)






C++ https://ideone.com/DwwYLP
Java. https://ideone.com/cLuk6w
Py https://ideone.com/cJuqtp
*/


import java.util.Scanner;
import java.util.Vector;

public class Session25ZScalarOA {

    static Vector<Long> b = new Vector<>();
    static long n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        b.clear();
        n = scanner.nextLong();
        for (int i = 0; i <= n + 5; i++) {
            b.add(0L); // Initialize each element individually
        }
        for (int i = 1; i <= n; i++) {
            b.set(i, scanner.nextLong());
        }

        long low = 0;
        long k = 1;
        long high = getMaxValue(b);
        long rr = (long) 1e18;

        while (low <= high && k == 1) {
            long md = (low + high) / 2;

            if (check(md) && !check(md - 1)) {
                rr = md;
                k = 0;
            } else if (check(md)) {
                high = md;
            } else {
                low = md + 1;
            }
        }

        System.out.println(rr);
    }

    static boolean check(long vl) {
        Vector<Long> gg = new Vector<>(b);
        long i = n;

        while (i >= 2) {
            if (b.get((int) i) >= vl) {
                long diff = Math.abs(b.get((int) i) - vl);
                b.set((int) (i - 1), b.get((int) (i - 1)) + diff);
            }
            i--;
        }

        if (b.get(1) <= vl) {
            b = gg;
            return true;
        }

        b = gg;
        return false;
    }

    static long getMaxValue(Vector<Long> vector) {
        long max = Long.MIN_VALUE;
        for (long value : vector) {
            max = Math.max(max, value);
        }
        return max;
    }
}
