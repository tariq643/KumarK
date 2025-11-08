package kumarK.hashing;

import java.util.HashMap;
import java.util.Map;

public class LeetCodeQuestion48 {

    // max number of k-sum pairs
    // You are given an integer array nums and an integer k.
    //
    //In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
    //
    //Return the maximum number of operations you can perform on the array.
    public int maxOperations(int[] nums, int k) {

        Map<Integer, Integer> cardinalityMap = new HashMap<>();
        Map<Integer, Integer> cardinalityMapForCheck = new HashMap<>();

        // populate cardinalityMap
        for (int num : nums) {
            cardinalityMap.put(num, cardinalityMap.getOrDefault(num,0) + 1);
        }
        int count = 0;
        for (int number : nums) {
            int complement = k - number;
            if (!cardinalityMapForCheck.containsKey(number) &&
                    !cardinalityMapForCheck.containsKey(complement)) {
                if (number == complement) {
                    count = count + cardinalityMap.get(number) / 2;
                } else {
                    if (cardinalityMap.containsKey(complement)) {
                        count = count + Math.min(cardinalityMap.get(number), cardinalityMap.get(complement));
                    }
                }
                cardinalityMapForCheck.put(number, 1);
                cardinalityMapForCheck.put(complement, 1);
            }
        }
        return count;
    }
}
