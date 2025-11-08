package kumarK.hashing;

import java.util.HashMap;
import java.util.Map;

public class NutanixOAQuestion38 {

    public static void main(String[] args) {
        int n = 2; // Assuming n is 2 as per provided arrays
        int[] a = {2, 5};
        int[] b = {3, 8};
        int[] c = {-5, 8};
        int[] d = {5, 10};
        int[] e = {-10, 100};

        Map<Integer, Integer> hashmap = new HashMap<>();

        for (int l = 0; l < n; l++) {
            for (int m = 0; m < n; m++) {
                int sum = d[l] + e[m];
                if (hashmap.containsKey(sum)) {
                    hashmap.put(sum, hashmap.get(sum) + 1);
                } else {
                    hashmap.put(sum, 1);
                }
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int required_sum = -(a[i] + b[j] + c[k]);
                    if (hashmap.containsKey(required_sum)) {
                        count += hashmap.get(required_sum);
                    }
                }
            }
        }

        System.out.println(count);
    }
}
