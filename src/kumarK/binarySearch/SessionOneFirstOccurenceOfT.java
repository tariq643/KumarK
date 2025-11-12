package kumarK.binarySearch;

public class SessionOneFirstOccurenceOfT {

    private int sessionOneFirstOccurenceOfT (boolean[] arr) {

        int low = 0;
        int high = arr.length - 1;
        int firstOccurence = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid]) {
                firstOccurence = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return firstOccurence;
    }

    // search the element in sorted arrays
    private int searchInRotatedSortedArray (int[] nums, int k) {

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == k) {
                return mid;
            }
            else if (nums[mid] < k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1; // element not found in the array
    }

    // Find First and Last Position of Element in Sorted Array
    public int[] searchRange(int[] nums, int target) {

        int low = 0, high = nums.length - 1;
        int firstOccurence = -1, lastOccurence = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                firstOccurence = mid;
                high = mid - 1;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                lastOccurence = mid;
                low = mid + 1;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return new int[]{firstOccurence, lastOccurence};
    }

    public static void main(String[] args) {

        SessionOneFirstOccurenceOfT obj = new SessionOneFirstOccurenceOfT();
        boolean[] arr = {false,false,false,false,false,false,true,true};
//        System.out.println(obj.sessionOneFirstOccurenceOfT(arr));

        int[] nums = {2,4,6,8,10,11,14};
        System.out.println(obj.searchInRotatedSortedArray(nums, 2));
    }
}
