package kumarK.binarySearch;

public class SessionThreeSearchInRotatedSortedArray {

    // search in rotated sorted array
    public int search(int[] nums, int target) {

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // base case element found
            if (nums[mid] == target) {
                return mid;
            }
            // left array is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            // right array is sorted
            else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    // search element in sorted array
    private int singleNonDuplicate (int[] nums) {

        int length = nums.length;
        int low = 0, high = length - 1;
        if (length == 1) {
            return nums[0];
        }
        // edge case remove the first and last element if they are non duplicate
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[length - 1] != nums[length - 2]) {
            return nums[length - 1];
        }
        while (low <= high) {
            int mid = low + (high -  low) / 2; // to prevent overflow
            // to check if mid is not equal to its neighbouring elements
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /*
        find the nth root of a number m using binary search
        create a function to calc pow(x, n)
        from takeUForward
    */

    public int nthRoot(int n, int m) {

        int low = 1, high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int result = powFunc(mid, n);
            if (result == m) {
                return mid;
            }
            else if (result < m) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // func(x,n)
    private int powFunc (int a, int n) {
        if (n < 0) {
            n = -1 * n;
            a = 1 / a;
        }
        int ans = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                ans = ans * a;
            }
            a = a * a;
            n = n / 2;
        }
        return ans;
    }

}
