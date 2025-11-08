package kumarK.hashing;

import java.util.HashMap;
import java.util.Scanner;

public class MicrosoftOAQuestion44 {

    // find the number of unordered quadruplets (i,j,k,l) such that b(i) + b(j) + b(k) + b(l) == 0
    private int findNumberOfQuadrupletsBruteForce (int[] arr) {

        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        if (arr[i]+arr[j]+arr[k]+arr[l] == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    // optimal appraoch
    private long findNumberOfQuadrupletsOptimal (int[] arr) {

        // use a hashmap
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            b[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> y = new HashMap<>();

        // First loop to count sums of pairs (k, l)
        for (int k = 3; k <= n; k++) {
            for (int l = k + 1; l <= n; l++) {
                int sum = b[k] + b[l];
                y.put(sum, y.getOrDefault(sum, 0) + 1);
            }
        }

        long r = 0;

        // Second loop to count results
        for (int j = 2; j <= n - 2; j++) {
            for (int i = 1; i < j; i++) {
                int d = b[i] + b[j];
                int u = -(b[i] + b[j]);
                r += y.getOrDefault(u, 0);  // count of (k, l) whose sum = u
            }

            for (int j1 = j + 2; j1 <= n; j1++) {
                int sum = b[j + 1] + b[j1];
                y.put(sum, y.get(sum) - 1);
            }
        }

        return r;
    }
}
