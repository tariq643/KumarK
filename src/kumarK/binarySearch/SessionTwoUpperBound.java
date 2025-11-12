package kumarK.binarySearch;

public class SessionTwoUpperBound {

    public int upperBound(int[] nums, int x) {

        int low = 0, high = nums.length - 1;
        int upperBound = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
           if (nums[mid] > x) {
                high = mid - 1;
                upperBound = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return upperBound;
    }

  /*  upper bound
    kumar k

    let say arr = [3 5 5 8 8 10 12]
    */

/*
    so upperBound(6) = 8 so return 3 -> index of 8
    so array A = [1 1 3 3 5 500]
    upperBound(6) = 500 so return 5 - > index of 500

    in C++ there is a in-build function to do the same
    but in Java there is no such function

    so if arr[] = {100 200 500 550 600 800 1000 1500 1800] target = 1200
    so we need to find a number just greater than 1200
    low = 0 high = 8 mid = 4 arr[mid] = 600 but 600 ! > 1200 so all the numbers
    to the left of 600 are of no good so ignore -> low = mid + 1
    so array now becomes [800 1000 1500 1800] target = 1200 mid = 1000
    so we again iterate
*/



}
