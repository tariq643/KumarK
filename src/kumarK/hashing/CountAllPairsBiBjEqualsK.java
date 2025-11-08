package kumarK.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountAllPairsBiBjEqualsK {

    private int countAllPairsBiBjEqualsK (int[] arr, int k) {

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = k - arr[i];
            if (map.containsKey(complement)) {
                count = count + map.get(complement);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0 ) + 1);
        }
        return count;
    }
}
