package kumarK.binarySearch;

/*
Understanding :-> You are given the requirement array +
current stock array + cost array

-> Tell the maximum number of units you can create in given budget

-> required -> [1,2]
        -> stock -> [0,1]
        -> cost -> [1,1]
        -> budget == 3;

        -> need :-> [1,1]
To create 1 unit :-> 1 x 1 + 1 x 1 = 2;

        -> 2<=3 hence you can create 1 unit in the given budget

-> Try for 2 units;

-> required -> [2,4]
        -> need -> [2,3]
        -> 2*1 + 3*1 ⇒ 5

Brute force solution :-> Try for 1 unit if you pass try for
two units if you pass try for 3 units if you pass try 4 units ->
then try 5 units until you hit a failing point

-> https://www.jdoodle.com/ia/1Iwp

TC :- O(large_value*N);

Optimization :-> Binary search over the monotonic function;

-> Plot a graph of no of units(x-axis) vs cost(y-axis) -> It is increasing function;

-> TTTTTFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF

-> Find last occurrence of “T” using linear search;

-> https://www.jdoodle.com/ia/1Iwt

TC -> O(N*log(large_value))

        -> Takes O(1) sz space;

*/


public class Session21MicrosoftOA {

    // linear search
    private long session21MicrosoftOABruteForce (long[] req, long[] stock, long[] cost
            , long budget) {

        long i = 1, answer = -1;
        boolean v1 = false;
        long sum;
        while (!v1) {
            sum = 0;
            for (int j = 0; j < req.length; j++) {
                long p = req[j] * i;
                long d = p - stock[j];
                if (d < 0) {
                    d = 0;
                }
                sum = sum + d * cost[j];
            }
            if (sum <= budget) {
                answer = i;
            }
            else {
                break;
            }
        }
        return answer;
    }

    // binary search
    private long session21MicrosoftOABinarySearch (long[] req, long[] stock, long[] cost
            , long budget) {

        long low = 1,high = (long) Math.pow(10,18), answer = -1;
        boolean v1 = false;
        long sum;
        while (!v1) {
            sum = 0;
            long mid = (low) + (high - low) / 2;
            for (int j = 0; j < req.length; j++) {
                long p = req[j] * mid;
                long d = p - stock[j];
                if (d < 0) {
                    d = 0;
                }
                sum = sum + d * cost[j];
            }
            if (sum <= budget) {
                answer = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return answer;
    }
}
