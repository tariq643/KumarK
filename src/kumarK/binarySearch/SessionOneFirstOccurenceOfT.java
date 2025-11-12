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
                high = mid + 1;
            }
            else {
                low = mid + 1;
            }
        }
        return firstOccurence;
    }

    public static void main(String[] args) {

        SessionOneFirstOccurenceOfT obj = new SessionOneFirstOccurenceOfT();
        boolean[] arr = {false,false,false,false,false,false,true,true};
        System.out.println(obj.sessionOneFirstOccurenceOfT(arr));
    }
}
