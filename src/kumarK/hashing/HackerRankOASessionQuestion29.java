package kumarK.hashing;

import java.util.Scanner;

public class HackerRankOASessionQuestion29 {

    static int convert (String s) {

        int u1 = s.charAt(0);
        int u5 = s.charAt(1);

        int v = (u1 * 10 + u5) * 60;

        u1 = s.charAt(3);
        u5 = s.charAt(4);

        v = v + (u1 * 10 + u5) * 60;

        return v;
    }

    static void ck(int g) {
        int u = g / 60;
        int y = g % 60;

        if (u <= 9) {
            System.out.print("0");
            System.out.print(u);
        } else {
            System.out.print(u);
        }
        System.out.print(":");

        if (y <= 9) {
            System.out.print("0");
            System.out.print(y);
        } else {
            System.out.print(y);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] y = new int[1441];

        for (int i = 0; i < n; i++) {
            String a = scanner.next();
            String b = scanner.next();

            String v1 = scanner.next();
            String v5 = scanner.next();

            int t1 = convert(v1);
            int t5 = convert(v5);

            y[t1]++;
            y[t5 + 1]--;
        }

        int i = 1;
        while (i < 1441) {
            y[i] = y[i - 1] + y[i];
            i++;
        }
        int c = 0;
        int g = 0;

        for (int j = 0; j < 1440; j++) {
            if (y[j] == 0) {
                c++;

                if (c == k) {
                    ck(j - k + 1); // convert this to (hh:mm)
                    g = 1;
                    break;
                }
            } else {
                c = 0;
            }
        }

        if (g == 0) {
            System.out.println("-1");
        }
    }
}
