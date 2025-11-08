package kumarK.hashing;

public class AmazonOAQuestion40 {

    private boolean increasingSubSequenceOfSizeThreeBruteForce (int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i]<arr[j] && arr[j]<arr[k]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean increasingSubSequenceOfSizeThreeOptimal (int[] arr) {
        int n = arr.length;
        int[] prefixMinimumSum = new int[n];
        int[] suffixMaximumSum = new int[n];
        prefixMinimumSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixMinimumSum[i] = Math.min(prefixMinimumSum[i-1], arr[i]);
        }
        suffixMaximumSum[n-1] = arr[n-1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMaximumSum[i] = Math.max(suffixMaximumSum[i + 1], arr[i]);
        }
        for (int i = 1; i < n; i++) {
            if (arr[i] > prefixMinimumSum[i] && arr[i] < suffixMaximumSum[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AmazonOAQuestion40 amazonOAQuestion40 = new AmazonOAQuestion40();
        int[] arr = {18,5,4,3,2,1,8,10};
        amazonOAQuestion40.increasingSubSequenceOfSizeThreeOptimal(arr);
    }
}
