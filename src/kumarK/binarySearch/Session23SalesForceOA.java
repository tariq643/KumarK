package kumarK.binarySearch;

/*
Understanding :-> We are giving you an array of size “M” ;
divide the array into at most “N” parts; lets say sum of
each part is s1,s2,s3,s4,s5,.......sn

max(s1,s2,s3,s4…….sn)---> minimum as possible.


        Observation:-> What can be the smallest possible capacity of a bucket

According to Sheenam’s Law:-> Minimum capacity of the.
Bucket is the maximum element of array

According to Karandeep’s Law :-> max capacity of a bucket
is sum of array elements


Final answer will always be in the range [minimum_capacity(N=M)
    ,maximum_capacity(N=1)]

I = minimum_capacity
-> check(minimum_capacity = i)-> is it possible to divide the array into N parts
such that capacity of each bucket is utmost = minimum_capacity
        -> it comes as false;

        ->try for check(i+1)-> false;

        -> try for check(i+2)->false;
        .
        .
        .
        .
        .
        .
        .
        .
        .
        ->try for check(i+g)==> true this your answer

Low = min;
High = max;
3 5 8 2 4 3 8
n=3.
F F F    F   F  F   F  T T T T T T T T T T T T T T T T T T T
8 9 10  11  12 13 14
C++ https://ideone.com/zid1tm
Java. https://ideone.com/4viVHp
Py https://ideone.com/3QWgPF


TC : O(M*sum)


-> FFFFFFFFFFFFFFFFFTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT

-> Standard Binary Search Problem.

low->5
high->500
k=0
        while(low<=high && k==0){
Mid = (low + high)/2.
        if(check(mid)==true && check(mid-1)==true){
High = mid - 1
        }
Else if(check(mid)==false and check(mid+1)==false){
Low = mid + 1
        }
Else if(check(mid)==true and check(mid-1)==false){
Answer = mid k = 1
    }
            }

TC : O(M*log(Sum))



C++ https://ideone.com/m6vjWu
Java. https://ideone.com/PzOSFj
Py https://ideone.com/pGDlrM
*/

import java.util.Scanner;

public class Session23SalesForceOA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long n = scanner.nextLong();
            long m = scanner.nextLong();
            long[] b = new long[100005];
            long sum = 0;
            long mx = Long.MIN_VALUE;

            for (int i = 1; i <= m; i++) {
                b[i] = scanner.nextLong();
                mx = Math.max(mx, b[i]);
                sum += b[i];
            }

            long low = mx;
            long high = sum;
            long k = 0;
            long v = -1;

            while (low <= high && k == 0) {
                long mid = (low + high) / 2;
                if (mid == mx && check(b, n, m, mx + 1) && check(b, n, m, mx)) {
                    v = mid;
                    k = 15;
                } else if (!check(b, n, m, mid) && !check(b, n, m, mid + 1)) {
                    low = mid + 1;
                } else if (check(b, n, m, mid) && !check(b, n, m, mid - 1)) {
                    v = mid;
                    k = 15;
                } else if (!check(b, n, m, mid) && check(b, n, m, mid + 1)) {
                    v = mid + 1;
                    k = 15;
                } else if (check(b, n, m, mid) && check(b, n, m, mid - 1)) {
                    high = mid - 1;
                }
            }

            System.out.println(v);
        }
    }

    public static boolean check(long[] b, long n, long m, long vl) {
        int i = 1;
        long c = 0;
        long sum = 0;
        while (i <= m) {
            sum += b[i];
            if (sum <= vl) {
                i++;
            } else {
                c++;
                sum = 0;
            }
        }
        if (c + 1 <= n) {
            return true;
        }
        return false;
    }
}
