package kumarK.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountOfSubarrayofShortestLengthSumK {

    private int countOfSubarrayofShortestLengthSumK (int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, sum = 0, n = arr.length, minLength = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
            if (sum == k) {
                minLength = Math.min(minLength, i + 1);
            }
            if (map.containsKey(sum - k)) {
                minLength = Math.min(minLength, i - map.get(sum - k));
            }
            map.put(sum, i);
        }

        sum = 0;
        int i = 0, j = 0;
        while (j < n) {
            sum = sum + arr[j];
            if (j- i + 1 < minLength) {
                j++;
            }
            else if (j- i + 1 == minLength) {
                if (sum == k) {
                    count++;
                }
                sum = sum - arr[i];
                i++;
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        CountOfSubarrayofShortestLengthSumK c = new CountOfSubarrayofShortestLengthSumK();
        int arr[] = {48,99,37,4,-31};
        System.out.println(c.countOfSubarrayofShortestLengthSumK(arr, 140));

    }
}
