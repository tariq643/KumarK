package kumarK.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountSubArraysWithGivenXOR {

    public long subarrayXor(int nums[], int k) {

        int prefixXor = 0, count = 0;
        Map<Integer, Integer> xorMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            prefixXor = prefixXor ^ nums[i];
            if (prefixXor == k) {
                count++;
            }
            if (xorMap.containsKey(prefixXor^k)) {
                count = count + xorMap.get(prefixXor^k);
            }
            xorMap.put(prefixXor, xorMap.getOrDefault(prefixXor,0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        CountSubArraysWithGivenXOR countSubArraysWithGivenXOR = new CountSubArraysWithGivenXOR();
        int arr[] = {3,8,3};
        System.out.println(countSubArraysWithGivenXOR.subarrayXor(arr,8));
    }
}
