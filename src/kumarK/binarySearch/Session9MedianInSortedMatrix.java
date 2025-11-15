package kumarK.binarySearch;

public class Session9MedianInSortedMatrix {

  /*  Given a row-wise sorted matrix mat[][] of size n*m,
    where the number of rows and columns is always odd. Return the median of the matrix.
    Input: mat[][] = [[1, 3, 5],
                    [2, 6, 9],
                    [3, 6, 9]]
    Output: 5
    Explanation: Sorting matrix elements gives us [1, 2, 3, 3, 5, 6, 6, 9, 9]. Hence, 5 is median.

    */

    /*  Brute force approach is to copy all the elements in
    a single array and sort it to find the median

    */

    /*
    * to apply binary search
    * first we should check whether there is
    * some monotonic function or not
    * eg., 2 2 4 4 8 10 10 12 12 15 18 18 20 20 20
    * now let us calc the number of numbers <= x in the array
    * for x = 2 f(x) = 2
    * for x = 4 f(x) = 4
    *     x = 8 f(x) = 5
    *     x = 10 f(x) = 7
    *  this function is monotonic in nature so binary search can be applied
    *  if i pick 10 to check for median how many elements are less than or equal to 10
    *  f(10) = 7 but 7 !> 7 so the left part can be ignored
    * if i pick 18 to check for median how many elements are less than or equal to 18
     *  f(18) = 12 but 12 !< 7 so the right part can be ignored
    * */

    /*
     * eg., 2 2 4 4 8 10 10 12 12 15 18 18 20 20 20 in the original question the range can be from 1 to 1e9
     * for sake of simplicity here let us take l = 1 and r = 40 so mid = 20
     * so median = 20 now check the number of elements <= 20 in the array and that is 15
     * which is > middle index 7 so we can reduce the search space by ignoring the numbers
     * from 20 to 40
     * so now l = 1 , r = 19 mid = 10
     * median = 10 now check the number of elements <= 10 in the array and that is 7
     * so it cannot be the median so ignore the left part
     * l = 11 r = 19 and so on ...
     *
     *  taking another example arr = [2 10 12 12 20]
     *  upperbound(arr, 10) - arr(1st index)
     * search space if from l = 1 to r = 10e9
     *
     * */

    // Function to find the upper bound of an element in a sorted row
    private int upperBound(int[] arr, int x, int m) {
        int low = 0, high = m - 1;
        int ans = m;

        // Apply binary search
        while (low <= high) {
            int mid = (low + high) / 2;

            // If arr[mid] > x, it can be a possible upper bound
            if (arr[mid] > x) {
                ans = mid;
                // Look for a smaller upper bound on the left
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    // Function to count how many elements in the matrix are less than or equal to x
    private int countSmallEqual(int[][] matrix, int n, int m, int x) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += upperBound(matrix[i], x, m);
        }
        return cnt;
    }

    // Function to find the median element in the matrix
    public int findMedian(int[][] matrix) {
        int n = matrix.length; // Number of rows
        int m = matrix[0].length; // Number of columns

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        // Initialize low and high
        for (int i = 0; i < n; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][m - 1]);
        }

        int req = (n * m) / 2;

        // Perform binary search to find the median
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int smallEqual = countSmallEqual(matrix, n, m, mid);

            if (smallEqual <= req) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }
}
