package kumarK.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountAllPairsBiMinusBjEqualsK {

    private int countAllPairsBiBjEqualsK (int[] arr, int target) {

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = arr[i] + target;
            if (map.containsKey(complement)) {
                count++;
            }
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
        }
        return count;
    }
}
