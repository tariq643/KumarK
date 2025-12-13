package kumarK.binarySearch;

import java.util.Arrays;
/*

Understanding :- Find the length of longest subset such that
if the size of that subset is K then :-

i1*k + a[i1] + …………………………………….. ik*k + a[ik] <= m .

        Organic - Think what will happen if you select only element from the array

Let’s try to keep K = 1

Then a Kumar K student can clearly select :-  1 + a[1] or 2 + a[2] or ……………….N + a[N].

Which one will you select among all these options?
I will pick the minimum of all the options as it will have
the highest probability to be <=M.

You have found the valid subset of length 1

Good!!!!!!!

Try for K = 2.

For each index we will calculate :- i*2 + a[i]

We will pick the 2 smallest values out of the N values and
sum of those two smallest values if it is <=M; then K = 2.

Let's say you are able to find two smallest values whose sum<=M;

Try for K = 3. Good. Done!

Try for K = 4. Not possible.

Hence K = 3 is the answer


As K increases; Sum also increases; Hence if K = 4 fails
for any random array you should not try for K = 5 because it will definitely fail

->n,m
->b[n+1]


r = 0


bool check(int k,b [],int m){

    ->g[n+1]
    for(i=1;i<=n;i++){
        vl = i*k + b[i]
        g[i] = vl
    }
    sort(g)


    i=1;sum=0


    while(i<=k){
        sum = sum + g[i]
    }

    if(sum<=m){return true;
    }


    return false;
}

for(k=1;k<=n;k++){

        if(check(k,b,m)==true){
r = k
    }
            else {
            break;
            }


            }


print(r)



C++ - https://ideone.com/c5GeKl
Java - https://ideone.com/tefv0e
Py - https://ideone.com/nQHgMH


TC - O(N*(N+K+ ….. NlogN)) = O(N*NlogN)

Optimize it using binary search!



        ->n,m
->b[n+1]


r = 0


bool check(int k,b [],int m){

    ->g[n+1]
    for(i=1;i<=n;i++){
        vl = i*k + b[i]
        g[i] = vl
    }
    sort(g)


    i=1;sum=0


    while(i<=k){
        sum = sum + g[i]
    }

    if(sum<=m){return true;
    }


    return false;
}
R = 0
Low = 1
High = N.

while(low<=high){
Mid = (low+high)/2

        if(check(mid,b,m)==false){
High = mid-1
        }
Else{
    //mid=====T
    if(check(mid+1,b,m)==true){
        Low = mid + 1
    }
    Else{
        //mid+1==False.
        R = mid.
                Break
    }
}

}
//Handle the case where K = 1 is also not working in that case 0 is the answer

print(r)



C++ - https://ideone.com/7BshHp
Java - https://ideone.com/iNAqeR
Py - https://ideone.com/VpSutO


TC - O(LOGN*N*LOGN) = (N*(LOGN)*(LOGN)) = [6*10^7] < 10^8
*/




public class Session24DEShawOA {
    static int n, m;
    static int[] b;

    public static void main(String[] args) {
        // Input
        n = 4;
        int[] a = {4, 3, 2, 1};
        m = 33;
        b = Arrays.copyOfRange(a, 0, n);

        // Binary search
        int r = 0;
        int low = 1, high = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (!check(mid, b, m)) {
                high = mid - 1;
            } else {
                if (check(mid + 1, b, m)) {
                    low = mid + 1;
                } else {
                    r = mid;
                    break;
                }
            }
        }

        // Handle the case where k = 1 is also not working
        if (r == 0 && !check(1, b, m)) {
            r = 0;
        }

        // Output
        System.out.println(r);
    }

    static boolean check(int k, int[] b, int m) {
        int[] g = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int vl = i * k + b[i - 1];
            g[i] = vl;
        }
        Arrays.sort(g, 1, n + 1);

        int sum = 0;
        for (int i = 1; i <= k; i++) {
            sum += g[i];
        }

        return sum <= m;
    }
}
