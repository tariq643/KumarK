package kumarK.binarySearch;

import java.util.Arrays;

public class Session24DEShawOA {
    static int n, m;
    static int[] b;

    public static void main(String[] args) {
        // Input
        n = 4;
        int[] a = {4, 3, 2, 1};
        m = 33;
        b = Arrays.copyOfRange(a, 0, n);

        // Binary search
        int r = 0;
        int low = 1, high = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (!check(mid, b, m)) {
                high = mid - 1;
            } else {
                if (check(mid + 1, b, m)) {
                    low = mid + 1;
                } else {
                    r = mid;
                    break;
                }
            }
        }

        // Handle the case where k = 1 is also not working
        if (r == 0 && !check(1, b, m)) {
            r = 0;
        }

        // Output
        System.out.println(r);
    }

    static boolean check(int k, int[] b, int m) {
        int[] g = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int vl = i * k + b[i - 1];
            g[i] = vl;
        }
        Arrays.sort(g, 1, n + 1);

        int sum = 0;
        for (int i = 1; i <= k; i++) {
            sum += g[i];
        }

        return sum <= m;
    }
}
