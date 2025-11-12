package kumarK.binarySearch;

public class SessionTwoUpperBound {

    public int upperBound(int[] nums, int x) {

        int low = 0, high = nums.length - 1;
        int upperBound = -1;
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

*/



}
