package kumarK.hashing;

import java.util.HashMap;
import java.util.Map;

public class FindTheFrequency {

    int findFrequency(int arr[], int x) {
        // code here

        Map<Integer, Integer> map = new HashMap<>();
        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        if (map.containsKey(x)) {
            return map.get(x);
        }
        return 0;
    }
}
