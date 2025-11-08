package kumarK.hashing.question50Onwards;

import java.util.Arrays;

public class GoogleOAQuestion52 {

    // basic pre-requisite
    // given an array of size 'N' for each index 'i' output the subarray sum which is the largest and ends at index 'i'
    private void subArrayAtIndexIWithLargestSum (long[] arr) {

        int l = arr.length;
        long[] largestSumAtEachIndex = new long[l];
        long sum = arr[0], maxSum = Integer.MIN_VALUE;
        largestSumAtEachIndex[0] = arr[0];
        for (int i = 1; i < l; i++) {
            sum = sum + arr[i];
            maxSum = Math.max(sum, maxSum);
            largestSumAtEachIndex[i] = maxSum;
            sum = sum > 0 ? sum : 0L;
        }
        Arrays.stream(largestSumAtEachIndex).forEach(System.out::println);
    }

    // given an array of size 'N' for each index 'i' output the subarray sum which is the largest and ends at index 'i'
    private void subArrayAtIndexIWithLargestSumKumarK (long[] arr) {

        int l = arr.length;
        long[] largestSumAtEachIndex = new long[l];
        largestSumAtEachIndex[0] = arr[0];
        for (int i = 1; i < l; i++) {
            largestSumAtEachIndex[i] = Math.max(arr[i], arr[i] + largestSumAtEachIndex[i - 1]);
        }
        Arrays.stream(largestSumAtEachIndex).forEach(System.out::println);

        // we can further optimize using only one variable
        long largestSumVar = arr[0];
        for (int i = 1; i < l; i++) {
            largestSumVar = Math.max(largestSumVar + arr[i], largestSumVar);
            System.out.println(largestSumVar);
        }
    }

    // asked in google ->
    // find the maximum sum of two overlapping subarrays
    // test case 8 -800 5 3 2 100
    // output should be 8 + (100+5+3+2) = 118
    // create two subarray sum -> prefix and suffix array
    private void findMaximumSumOfTwoOverlappingSubArray (long[] arr) {

        int l = arr.length;

        long[] prefixSum = new long[l]; // takes the maximum sum from 0 to n - 1
        prefixSum[0] = arr[0];
        for (int i = 1; i < l; i++) {
            prefixSum[i] = Math.max(prefixSum[i - 1] + arr[i], arr[i]);
        }

        long[] suffixSum = new long[l]; // takes the maximum sum from n - 1 to 0
        suffixSum[l - 1] = arr[l - 1];
        for (int i = l - 2; i >= 0; i--) {
            suffixSum[i] = Math.max(suffixSum[i + 1] + arr[i], suffixSum[i + 1]);
        }

        // take the sum of these two and find the maximum of the two
        long maximumSumOfNonOverlappingSubArray = Integer.MIN_VALUE;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                long tempSum = prefixSum[i] + suffixSum[i];
                maximumSumOfNonOverlappingSubArray = Math.max(tempSum, maximumSumOfNonOverlappingSubArray);
            }
        }

    }

    // asked in google ->
    // find the maximum sum of two overlapping subarrays
    // test case 8 -800 5 3 2 100
    // output should be 8 + (100+5+3+2) = 118
    // create two subarray sum -> prefix and suffix array
    private void findMaximumSumOfTwoOverlappingSubArrayOptimal (long[] arr) {

        int l = arr.length;

        long[] prefixSum = new long[l]; // takes the maximum sum from 0 to n - 1
        prefixSum[0] = arr[0];
        for (int i = 1; i < l; i++) {
            prefixSum[i] = Math.max(prefixSum[i - 1] + arr[i], arr[i]);
        }

        long[] suffixSum = new long[l]; // takes the maximum sum from n - 1 to 0
        suffixSum[l - 1] = arr[l - 1];
        for (int i = l - 2; i >= 0; i--) {
            suffixSum[i] = Math.max(suffixSum[i + 1] + arr[i], suffixSum[i + 1]);
        }

//         take the sum of these two and find the maximum of the two
//        long maximumSumOfNonOverlappingSubArray = Integer.MIN_VALUE;
//        for (int i = 0; i < l; i++) {
//            for (int j = i + 1; j < l; j++) {
//                long tempSum = prefixSum[i] + suffixSum[i];
//                maximumSumOfNonOverlappingSubArray = Math.max(tempSum, maximumSumOfNonOverlappingSubArray);
//            }
//        }

        // instead of iterating over the two arrays create a suffix array with
        // pre computed max sum
        long[] maxSuffixSum = new long[l];
        maxSuffixSum[l - 1] = suffixSum[l - 1];
        for (int i = l - 2; i >= 0; i--) {
            maxSuffixSum[i] = Math.max(maxSuffixSum[i + 1], suffixSum[i]);
        }

    }


    public static void main(String[] args) {
        GoogleOAQuestion52 obj = new GoogleOAQuestion52();
        long[] arr= {5,-8,1,1,3};
        obj.subArrayAtIndexIWithLargestSumKumarK(arr);
    }
}
