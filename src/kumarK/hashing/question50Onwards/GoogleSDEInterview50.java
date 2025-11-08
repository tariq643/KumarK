package kumarK.hashing.question50Onwards;

public class GoogleSDEInterview50 {

    // Count the number of mountain subarrays(length.>=3) in the array
    // 1<=N<=100000
    // 1<=A[i]<=100000000

    // first calculate the longest increasing subsequence in the array
    private int longestIncreasingSubarray (long[] arr) {

        int l = arr.length;
        int[] prefix = new int[l];
        prefix[0] = 1;
        for (int i = 1; i < l; i++) {
            if (arr[i] > arr[i - 1]) {
                prefix[i] = prefix[i - 1] + 1;
            }
            else {
                prefix[i] = 1;
            }
        }
        int answer = 0;
        for (int num : prefix) {
            answer = Math.max(num, answer);
        }
        return answer;
    }

    // now calculate the longest decreasing subsequence in the array
    private int longestDecreasingSubarray (long[] arr) {

        int l = arr.length;
        int[] prefix = new int[l];
        prefix[l - 1] = 1;
        for (int i = l - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                prefix[i] = prefix[i + 1] + 1;
            }
            else {
                prefix[i] = 1;
            }
        }
        int answer = 0;
        for (int num : prefix) {
            answer = Math.max(num, answer);
        }
        return answer;
    }

    // now find the largest mountain in the array
    // using prefix[i] + suffix[i] - 1
    private int largestMountain (long[] arr) {

        int l = arr.length;

        int[] prefix = new int[l];
        prefix[0] = 1;
        for (int i = 1; i < l; i++) {
            if (arr[i] > arr[i - 1]) {
                prefix[i] = prefix[i - 1] + 1;
            }
            else {
                prefix[i] = 1;
            }
        }

        int[] suffix = new int[l];
        suffix[l - 1] = 1;
        for (int i = l - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                suffix[i] = suffix[i + 1] + 1;
            }
            else {
                suffix[i] = 1;
            }
        }

        int answer = 0;
        for (int i = 0; i < l; i++) {
            answer = Math.max(answer, prefix[i] + suffix[i] - 1);
        }
        return answer;
    }

    // calculate the total number of mountains in the array
    private int totalMountain (long[] arr) {

        int total = 0;
        int l = arr.length;

        int[] prefix = new int[l];
        prefix[0] = 1;
        for (int i = 1; i < l; i++) {
            if (arr[i] > arr[i - 1]) {
                prefix[i] = prefix[i - 1] + 1;
            }
            else {
                prefix[i] = 1;
            }
        }

        int[] suffix = new int[l];
        suffix[l - 1] = 1;
        for (int i = l - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                suffix[i] = suffix[i + 1] + 1;
            }
            else {
                suffix[i] = 1;
            }
        }
        for (int i = 0; i < l; i++) {
                total = total + (prefix[i] - 1) * (suffix[i] - 1);
        }
        return total;
    }

    public static void main(String[] args) {

        GoogleSDEInterview50 obj = new GoogleSDEInterview50();
        long arr[] = {5,4,3};
        System.out.println(obj.totalMountain(arr));
    }
}
