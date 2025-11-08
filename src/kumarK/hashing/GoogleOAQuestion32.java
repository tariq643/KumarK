package kumarK.hashing;

import java.util.HashMap;
import java.util.Map;

public class GoogleOAQuestion32 {

    private int googleOAQuestion32 (int[] arr) {

        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int rhs = arr[arr[arr[i]]];
            if (map.containsKey(rhs)) {
                result = result + map.get(rhs);
            }
            int lhs = arr[arr[arr[i]]];
            map.put(rhs, map.getOrDefault(rhs,0) +1);
        }
        return result;
    }
}
