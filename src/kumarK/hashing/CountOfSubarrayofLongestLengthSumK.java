package kumarK.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountOfSubarrayofLongestLengthSumK {

    private int countOfSubarrayofShortestLengthSumK (int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, sum = 0, n = arr.length, maxLength = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
            if (sum == k) {
                maxLength = Math.max(maxLength, i + 1);
            }
            if (map.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        sum = 0;
        int i = 0, j = 0;
        while (j < n) {
            sum = sum + arr[j];
            if (j- i + 1 < maxLength) {
                j++;
            }
            else if (j- i + 1 == maxLength) {
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

        CountOfSubarrayofLongestLengthSumK c = new CountOfSubarrayofLongestLengthSumK();
        int arr[] = {10,5,5,2,7,1,8,7};
        System.out.println(c.countOfSubarrayofShortestLengthSumK(arr, 15));

    }
}
