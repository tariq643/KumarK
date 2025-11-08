package kumarK.hashing;

public class AmazonOASumofTwoNonIntersectingArrays {

    private int amazonOASumofTwoNonIntersectingArrays (int[] arr) {

        int n = arr.length;
        if (n == 0) {
            return 0;
        }

        int[] prefixSum = calculatePrefixSumKadane(arr);
        int[] suffixSum = calculateSuffixSumKadane(arr);

        int[] maxPrefixSum = new int[n + 1];
        maxPrefixSum[0] = prefixSum[0];
        for (int i = 1; i < n; i++) {
            maxPrefixSum[i] = Math.max(maxPrefixSum[i-1], prefixSum[i]);
        }

        int[] maxSuffixSum = new int[n + 1];
        maxSuffixSum[n - 1] = suffixSum[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxSuffixSum[i] = Math.max(maxSuffixSum[i-1], suffixSum[i]);
        }

        int maxSum = 0;
        for (int i = 0; i < n - 1; i++) {
            maxSum = Math.max(maxSum, maxPrefixSum[i] + maxSuffixSum[i + 1]);
        }
        return maxSum;
    }

    private int[] calculatePrefixSumKadane (int[] arr) {

        int n = arr.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        int currentMax = arr[0];
        for (int i = 1; i < n; i++) {
            currentMax = Math.max(0, Math.max(currentMax + arr[i], arr[i]));
            prefixSum[i] = currentMax;
        }
        return prefixSum;
    }

    private int[] calculateSuffixSumKadane (int[] arr) {

        int n = arr.length;
        int[] suffixSum = new int[n];
        suffixSum[0] = arr[n - 1];
        int currentMax = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            currentMax = Math.max(0, Math.max(currentMax + arr[i], arr[i]));
            suffixSum[i] = currentMax;
        }
        return suffixSum;
    }

    public static void main(String[] args) {

    }
}
