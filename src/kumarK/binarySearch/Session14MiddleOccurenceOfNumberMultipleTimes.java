package kumarK.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class Session14MiddleOccurenceOfNumberMultipleTimes {

//    Q1. Find the middle occurrence of X in the given array
//    A = [1,2,2,2,2,3,4,5,6,7] , X= 2
//    Output : 2

    /*
    * find the first occurence and last occurence of the number
    * and search within that space
    * */

    /*
    * use upper and lower bound to find the first occurence and last occurence
    * */
    public int middleOccurenceOfNumberMultipleTimes (int[] arr, int x) {

        int firstOccurence = this.firstOccurence(arr, x);
        int lastOccurence = this.lastOccurence(arr, x);
        int low = firstOccurence, high = lastOccurence, result = firstOccurence;
        // find the element x in the range first occuerence and last occuerence
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                result = mid;
                low = mid + 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return result;
    }

    private int firstOccurence(int[] arr, int target) {

        int low = 0, high = arr.length - 1, firstOccurence = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                firstOccurence = mid;
                high = mid - 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return firstOccurence;
    }

    private int lastOccurence(int[] arr, int target) {

        int low = 0, high = arr.length - 1, lastOccurence = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                lastOccurence = mid;
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lastOccurence;
    }


    /*
    * You are given two unsorted arrays a[] and b[]. Both arrays may contain duplicate elements.
    * For each element in a[], your task is to count how many elements in b[] are less than or equal to that element.
    * use binary search concept of lower/upper bound to calculate this
    *
    * Examples:

        Input: a[] = [4, 8, 7, 5, 1], b[] = [4, 48, 3, 0, 1, 1, 5]
        Output: [5, 6, 6, 6, 3]
        Explanation:
        For a[0] = 4, there are 5 elements in b (4, 3, 0, 1, 1) that are ≤ 4.
        For a[1] = 8 and a[2] = 7, there are 6 elements in b that are ≤ 8 and ≤ 7.
        For a[3] = 5, there are 6 elements in b that are ≤ 5.
        For a[4] = 1, there are 3 elements in b (0, 1, 1) that are ≤ 1.
        Input: a[] = [10, 20], b[] = [30, 40, 50]
        Output: [0, 0]
        Explanation:
        For a[0] = 10 and a[1] = 20, there are no elements in b that are less than or equal to 10 or 20. Hence, the output is [0, 0].
        *
    * */

    /*
    * upper bound concept -> if x is present then it will point to a value > x
    *
    * */

    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.sort(b);
        for (int ele : a) {
            result.add(countLessEqHelper (ele, b));
        }
        return result;
    }

    private static int countLessEqHelper(int ele, int[] b) {

        int low = 0, high = b.length - 1, result = high + 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (b[mid] > ele) {
                result = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return result;
    }


    public static void main(String[] args) {

        Session14MiddleOccurenceOfNumberMultipleTimes obj = new Session14MiddleOccurenceOfNumberMultipleTimes();
        int[] arr = {1,1,1,2,2,2,3,4,4,4,4};
        System.out.println(obj.middleOccurenceOfNumberMultipleTimes(arr,4));
        int a[] = {1,2,3,4,7,9};
        int b[] = {0,1,2,1,1,4};
        countLessEq(a, b);
    }
}
