package kumarK.binarySearch;

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


    public static void main(String[] args) {

        Session14MiddleOccurenceOfNumberMultipleTimes obj = new Session14MiddleOccurenceOfNumberMultipleTimes();
        int[] arr = {1,1,1,2,2,2,3,4,4,4,4};
        System.out.println(obj.middleOccurenceOfNumberMultipleTimes(arr,1));
    }
}
