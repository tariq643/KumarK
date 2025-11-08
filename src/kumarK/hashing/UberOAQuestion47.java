package kumarK.hashing;

import java.util.Scanner;

public class UberOAQuestion47 {

    // given an array of positive integers task
    // to calculate the sum of all pairs when they are concatenated
    // arr(i) + arr(j)
    private long bruteForce (long[] arr) {

        long sum = 0;
        String v1 , v2, ans;
        for (long value : arr) {
            for (long l : arr) {
                v1 = String.valueOf(value);
                v2 = String.valueOf(l);
                ans = v1 + v2;
                sum = sum + Long.parseLong(ans);
            }
        }
        return sum;
    }

    public static int no_of_digit(int num) {
        int count = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }
        return count;
    }

    // optimal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] b = new int[n + 1];
        int right = 0;

        for (int i = 1; i <= n; i++) {
            b[i] = scanner.nextInt();
            right += b[i];
        }

        int tot = 0;
        int[] digit = new int[10];

        for (int i = 1; i <= n; i++) {
            int u = no_of_digit(b[i]);
            digit[u] = digit[u] + 1;
        }

        int g = 0;
        for (int i = 1; i <= n; i++) {
            int l = 1, y = 0;
            while (l <= 6) {
                y += (int) (b[i] * Math.pow(10, l) * digit[l]);
                l++;
            }

            int lt = y;
            int v = lt + right;
            g = g + v;
        }

        System.out.println(g);
    }
}
