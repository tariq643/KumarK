package kumarK.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MicrosoftOADigitsEqualSum {

    public static long sol(long v) {
        long sum = 0;
        while (v != 0) {
            sum = sum + v % 10;
            v = v / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long[] b = new long[n + 1];

        int i = 1;
        while (i <= n) {
            b[i] = scanner.nextLong();
            i++;
        }

        Map<Long, Long> kk = new HashMap<>();
        i = 1;
        long answer = -1;

        while (i <= n) {
            long digitSum = sol(b[i]);
            if (kk.containsKey(digitSum)) {
                long pp = b[i] + kk.get(digitSum);
                answer = Math.max(answer, pp);
                kk.put(digitSum, Math.max(kk.get(digitSum), b[i]));
            } else {
                kk.put(sol(b[i]), b[i]);
            }
            i++;
        }

        System.out.println(answer);
    }
}
