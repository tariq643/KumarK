package kumarK.binarySearch;
/*

Understanding -> We are giving you an array and a number “k”

We have to add this number “k” to some of the elements of our array

Do it in such a way such that the maximum number of our array is minimized.

        -> [2 3 1 2] K = 5

O/P -> 3 [3 3 3 3]


        -> [5 6] K = 1

OP - 6.

Observation :- Distribute the “k” optimally

How to distribute?

        -> If K = 0 ; max of array is the answer

Hence for K>=1 -> lowest limit of answer will always be “max element of array”


        [1 5 4 3 4] K = 0 answer is 5

How will you make the answer = 6?

        By making any one element equal to 6.

        -> by sorting the array and making largest element equal to 6 and
        if still left over k is there to give to other elements and hope that
        k becomes 0 after some time.


Given an array and k value we can instantly know if the answer can be g or not -> O(N.)

G = lowest limit = max of array

G = highest limit = max + k


Answer will be always in the range [lowest……….highest]

        [1 3 4 4 5] , k = 14.

Lowest = 5 highest = 19

f(5) = fails.
f(6) = fails.
f(7) = pass.
f(8) = pass.
.
        .
        .
        .
        .
        .
        .
f(19) = pass.

        Algorithm :- Will be uploaded soon.

TC - O((low-high)*N) ; lets say t = low-high = 10^15

Optimization -> O(log[t]*N).

C++ - https://ide.geeksforgeeks.org/online-cpp14-compiler/fe54e9af-5217-475a-abbd-c2e729c7fcad

Java - https://ide.geeksforgeeks.org/online-java-compiler/9f64f876-0454-49d0-9ee0-48f6ba09a2c9

Py - https://ide.geeksforgeeks.org/online-python3-compiler/7b5e3568-5139-4ed8-8149-e3eb128527bb
*/

/*

 linear time code optimize using binary search

->input(n)
->input(k)
->input(b[]) // array input

// lowest limit of g = max element in the ARRAY
// highest limit of g = lowest + g

lowest = max(b[])
highest = lowest + k

        answer = -1


for (g=lowest;g<=highest;g++) {

        if (!check(g,b)) {

answer = g;
    break;
            }
            }

print(answer)


// check function
// time complexity o((high - low) * n)
bool check(t, b[]) {

    u = 0;
    for (int i = 0; i < n; i++) {

        u = u + Math.abs(t - b[i])
    }
    return u < t;
}*/


public class Session26AmazonOA {
}
