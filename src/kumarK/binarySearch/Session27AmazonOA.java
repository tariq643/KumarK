package kumarK.binarySearch;


/*

    You are given an array and a integer k. You must find the length
    of longest contiguous sub array  where all integers are equal
    after removing at most k elements from the array

    example [1 -2 1 1 3 2 1 -2] k = 3

 */
/*

(N,M,K)

Q :-> Construct an array of size ‘N’ such that the largest possible
number is at the kth index. Also each element should have an absolute
difference of 0 or 1 with their adjacent elements.

Total sum of these elements should be ‘m’

Try to maximize the element of index ‘k’
Each array element >=1

Eg :-
N = 5
M = 11
K = 3

        ->[    2 2 3 2 2   ] -> valid -> difference of any two adjacent elements = 1 or 0

        -> sum of all elements = M = 11
-> b[k] -> b[3] = (3)

N = 5
M = 18
K = 2
Answer = [4 5 4 3 2] = a[k] = 5



Brute - Force :->

Lets try for each value at b[k] = 1 or 2 or ………… m

Observation :-

Once b[k] is decided ; how do you know if it will satisfy all the conditions?


Min possible case :-> b[k] = y ; (k+1…..n) :->(y-1…y-2……….)

*/


public class Session27AmazonOA {
}
