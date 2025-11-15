package kumarK.binarySearch;

public class Session10ArraningCoins {

    public int arrangeCoins(int n) {

        // base case
        if (n == 1) {
            return 1;
        }
        long low = 1, high = n, result = high;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid + mid <= 2L * n) {
                result = mid;
                low = mid + 1;

            }
            else {
                high = mid - 1;
            }
        }
        return (int) result;
    }

    // leetcode question
    public char nextGreatestLetter(char[] letters, char target) {

        int low = 0, high = letters.length - 1;
        char result = letters[low];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (letters[mid] > target) {
                result = letters[mid];
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Session10ArraningCoins obj = new Session10ArraningCoins();
        System.out.println(obj.arrangeCoins(7));
    }
}
