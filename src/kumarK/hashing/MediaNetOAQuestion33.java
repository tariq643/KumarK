package kumarK.hashing;

public class MediaNetOAQuestion33 {

    private int mediaNetOAQuestion33 (int[] arr, int k) {
        
        int prefixSum = 0;
        for (int i = 0; i < k; i++) {
            prefixSum = prefixSum + arr[i];
        }
        int maxSum = prefixSum;
        int rightIndex = arr.length - 1;
        int suffixSum = 0;
        for (int i = k - 1; i >= 0; i--) {
            prefixSum = prefixSum - arr[i];
            suffixSum = suffixSum + arr[rightIndex--];
            maxSum = Math.max(maxSum, prefixSum + suffixSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MediaNetOAQuestion33 m = new MediaNetOAQuestion33();
        int[] arr = {5,-2,3,1,2};
        System.out.println(m.mediaNetOAQuestion33(arr, 3));
    }
}
