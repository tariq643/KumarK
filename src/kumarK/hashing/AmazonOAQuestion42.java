package kumarK.hashing;

import java.util.HashMap;
import java.util.Map;

public class AmazonOAQuestion42 {

    private int shortestlengthSubArrayWithSumKBruteForce(int[] arr, int k) {

        int n = arr.length;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == k) {
                    minLength = Math.min(minLength, j-i+1);
                }
            }
        }
        return minLength;
    }

    private int shortestlengthSubArrayWithSumKOptimal(int[] arr, int k) {

        int n = arr.length;
        int minLength = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int complmeent = k - arr[i];
            if (map.containsKey(complmeent)) {
                int j = map.get(complmeent);
                minLength = Math.min(minLength, i-j+1);
            }
            map.put(arr[i], i);
        }
        return minLength;
    }

    public static void main(String[] args) {
        AmazonOAQuestion42 obj = new AmazonOAQuestion42();
        int arr[] = {5,6,7,8,10,4,3,2,1};
        System.out.println(obj.shortestlengthSubArrayWithSumKOptimal(arr,8));
    }
}
