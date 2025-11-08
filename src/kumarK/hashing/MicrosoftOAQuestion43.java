package kumarK.hashing;

public class MicrosoftOAQuestion43 {

    // find the minimum sum of x elements at exactly y distance
    // optimal approach
    private int microsoftOAQuestion43 (int[] arr, int x, int y) {

        int n = arr.length;
        int prefixSum[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i - y >= 1) {
                prefixSum[i] = prefixSum[i - y] + arr[i];
            }
            else {
                prefixSum[i] = arr[i];
            }
        }

        int minSum = Integer.MAX_VALUE, currSum = 0;
        for (int i = 0; i < n; i++) {
            if (i - y >= 1) {
                currSum = prefixSum[i] - prefixSum[i - x * y];
            }
            minSum = Math.min(minSum, currSum);
        }
        return minSum;
    }
}
