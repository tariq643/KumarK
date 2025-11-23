package kumarK.binarySearch;

import java.util.Scanner;

public class Session20DEShawOA {

   /* We are given “n” type of items ; array b is given which tells us ->
    b[i] = frequency of item “i” ;

    Our task is to make a group of k distinct items;

    And finally output how many maximum such types of groups can be formed.

    [3 3 3] ; K = 2
    Output :- 4

    Observation : if you want to make y groups of size 'k': then sum of the array >= y*k

    Question is to find the maximum 'y'

    Brute force :

    first try for y = 1
    if it is possible for y = 1
    then try for y = 2;
    if yest try for y = 3 and so on .....

    */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long sum = 0;
        int i = 1;
        long ans = 0;
        long[] arr = new long[n + 1];
        long low = 0, high = (long) Math.pow(10, 18), y = 0;
        while (i <= n) {
            arr[i] = scanner.nextLong();
            sum = sum + arr[i];
            i = i + 1;
        }
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if(check(mid,k,n,arr)==true && check(mid+1,k,n,arr)==false){
                ans = mid ;
                y = 1 ;
            }
            else if(check(mid,k,n,arr)==true){
                low = mid ; //right....................
            } else {

                high = mid - 1 ; //left......
            }
        }
        System.out.println(ans);
    }

    static boolean check(long g, long k, long n, long[] b){

        //sz =====> k
        //=====> g
        long t = g*k ;

        int i = 1 ;
        while(i<=n){

            if(b[i]>g){
                t = t - g ;
            } else {
                t = t - b[i] ;
            }

            i++;
        }

        if(t<=0) {
            return true;
        }

        return false ;

    }

}

