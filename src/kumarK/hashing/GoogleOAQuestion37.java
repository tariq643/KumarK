package kumarK.hashing;

import java.util.Scanner;

public class GoogleOAQuestion37 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] b = new int[n + 1];
        int[] pref = new int[n + 1];
        int[] suf = new int[n + 1];
        pref[1] = 0;

        for (int i = 1; i <= n; i++) {
            b[i] = scanner.nextInt();
        }

        int j = 2;
        while (j <= n) {
            int c = 0;
            int i = 1;
            while (i <= j - 1) {
                if (b[i] > b[j]) {
                    c++;
                }
                i++;
            }
            pref[j] = c;
            j++;
        }

        suf[n] = 0;

        j = n - 1;
        while (j >= 1) {
            int c = 0;
            int k = j + 1;
            while (k <= n) {
                if (b[j] < b[k]) {
                    c++;
                }
                k++;
            }
            suf[j] = c;
            j--;
        }

        int c = 0;
        j = 1;
        while (j <= n) {
            c = c + pref[j] * suf[j];
            j++;
        }

        System.out.println(c);
    }
}
