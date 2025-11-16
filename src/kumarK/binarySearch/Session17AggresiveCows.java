package kumarK.binarySearch;

import java.util.Arrays;

public class Session17AggresiveCows {


/*    Given an array nums of size n, which denotes the positions of stalls, and an integer k,
    which denotes the number of aggressive cows, assign stalls to k cows such
    that the minimum distance between any two cows is the maximum possible.
    Find the maximum possible minimum distance.


    Examples:
    Input: n = 6, k = 4, nums = [0, 3, 4, 7, 10, 9]

    Output: 3

    Explanation: The maximum possible minimum distance
    between any two cows will be 3 when 4 cows are placed
    at positions [0, 3, 7, 10]. Here the distances between cows are 3, 4, and 3 respectively.
    We cannot make the minimum distance greater than 3 in any ways. */

    public int aggressiveCows(int[] nums, int k) {

        Arrays.sort(nums);

        int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < minValue) {
                minValue = num;
            }
            if (num > maxValue) {
                maxValue = num;
            }
        }
        int low = 1, high = maxValue - minValue, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(nums, k, mid)) {
                ans = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] nums, int k, int minAllowedDistance) {

        int cows = 1, lastStallPos = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - lastStallPos >= minAllowedDistance) {
                cows = cows + 1;
                lastStallPos = nums[i];
            }
            if (cows == k) {
                return true;
            }
        }
        return false;
    }


  /*  Given an array arr[] of integers, where each element
        arr[i] represents the number of pages in the i-th book.
    You also have an integer k representing the number of students.
    The task is to allocate books to each student such that:

    Each student receives atleast one book.
    Each student is assigned a contiguous sequence of books.
    No book is assigned to more than one student.
    The objective is to minimize the maximum number of pages assigned to any student.
    In other words, out of all possible allocations, find the arrangement where the
    student who receives the most pages still has the smallest possible maximum.

            Note: If it is not possible to allocate books to all students, return -1.

    Examples:

    Input: arr[] = [12, 34, 67, 90], k = 2
    Output: 113
    Explanation: Allocation can be done in following ways:
            => [12] and [34, 67, 90] Maximum Pages = 191
            => [12, 34] and [67, 90] Maximum Pages = 157
            => [12, 34, 67] and [90] Maximum Pages = 113.
    The third combination has the minimum pages assigned to a student which is 113.

    */

    /*
    * for the array [4 3 2 5 7 2 8 6] and m = 3
    * we need to divide the subarray into three subarrays
    * such that the maximum sum of subarray is minimized ...
    * l = min(array) r = max(array) i.e., sum of the entire array
    * for example arr = [1 1 1] m = 3
    * then max(sum) of sub array = 1
    *
    * for the array = [4 3 2 5 7 2 8 6]
    * l = 2 r = sum(arr) = 37 mid = 19
    * if m = 1
    * then 4 < 19 (mid) it is valid
    * 4 + 3 = 7 < 19 it is valid
    * 7 + 2 = 9 < 19 valid
    * 9 + 5 = 14 < 19 valid
    * 14 + 7 = 21 < 19 invalid
    *
    *
    * */

    public int findPages(int[] arr, int k) {
        // code here
        int n = arr.length;
        if (k > n) {
            return -1;
        }
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int i = 0; i < n; i++) {
            low = Math.max(low, arr[i]);
            high = high + arr[i];
        }
        // apply binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int students = countStudents(arr, mid);
            if (students > k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }

    private int countStudents(int[] nums, int pages) {

        // Size of array
        int n = nums.length;

        int students = 1;
        int pagesStudent = 0;

        for (int i = 0; i < n; i++) {
            if (pagesStudent + nums[i] <= pages) {
                // Add pages to current student
                pagesStudent += nums[i];
            } else {
                // Add pages to next student
                students++;
                pagesStudent = nums[i];
            }
        }
        return students;
    }
}
