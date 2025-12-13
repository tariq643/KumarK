package kumarK.binarySearch;


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

For each value from 1 to M ; for b[k] = i ; you can know the lowest and maximum sum possible.

If b[k] = i ; how will you know if this is a valid array ?
Max_Sum and Min_sum ;
Min_sum<=M<=Max_sum → array b is valid.

-> If you know the max sum of array and min sum of array ; then it means -> if m is lying b/w [min sum , max sum] -> valid hence i is valid answer .

Brute Force : - O(N*M)

Code:- https://ideone.com/4VGu9j (replace true by 1)
Java->  https://ideone.com/f1b9na
Py:-> https://ideone.com/IpyiMw

Efficient :- Efficient Solution :- Let's say y is the largest number possible at index ‘k’ .  You can find the y using binary search as it a monotonic function ; suppose you have a function f(i) ;

G(i) = true —> it means for x = i ; we can be successful

Hence f array will always look like this :-


FFFFFFFFFFFFFFFFFT T T T T T T T T T T T T T T T T T T T F F F F F F F F F F F

Hence there will be some F in the starting and at some particular point T will start coming and it will keep coming then F will keep coming forever


Say you are doing a binary search :-
1                                                                            M
[F F F F F F F F T T F F F F F F F F F F F F F F F F]

Low = 1
High = N
Mid = (low+mid)/2 ;
G[mid] = false ;
B[K] = mid
But the question is how do you identify if this the
last part of array or first part of the array

For B[k] = mid ; you can calculate the max sum and min sum ;
If M>max sum ; then first part
If M<min_sum ; then last part

Code :- https://ideone.com/ffltqm
Java :-> https://ideone.com/DFhfuc
Python :-> https://ideone.com/9CkxSE

-> Bonus you can solve this problem in O(LogN)



*/

public class Session28PaypalOA {
}
