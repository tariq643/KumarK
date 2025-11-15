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

        int low = 0, high = arr.length - 1, result = high;
        int firstOccurence = this.firstOccurence(arr, x);
        int lastOccurence = this.lastOccurence(arr, x);
        return result;
    }

    private int firstOccurence(int[] arr, int x) {

        int low = 0, high = arr.length - 1, firstOccurence = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > x) {
                firstOccurence = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return firstOccurence;
    }

    private int lastOccurence(int[] arr, int x) {

        int low = 0, high = arr.length - 1, lastOccurence = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                lastOccurence = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return lastOccurence;
    }


    public static void main(String[] args) {

        Session14MiddleOccurenceOfNumberMultipleTimes obj = new Session14MiddleOccurenceOfNumberMultipleTimes();
        int[] arr = {1,1,1,2,2,3,4,4,4,4};
        System.out.println(obj.firstOccurence(arr,1));
        System.out.println(obj.lastOccurence(arr,1));
    }
}
