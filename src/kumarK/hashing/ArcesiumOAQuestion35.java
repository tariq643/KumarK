package kumarK.hashing;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class ArcesiumOAQuestion35 {

    public static boolean check(String x, String y) {
        int i = 0;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        HashMap<Character, Integer> map3 = new HashMap<>();
        HashMap<Character, Integer> map4 = new HashMap<>();

        while (i < x.length()) {
            char g = x.charAt(i);

            if (i % 2 == 0) {
                map1.put(g, map1.getOrDefault(g, 0) + 1);
            } else {
                map2.put(g, map2.getOrDefault(g, 0) + 1);
            }

            i++;
        }

        i = 0;

        while (i < y.length()) {
            char g = y.charAt(i);

            if (i % 2 == 0) {
                map3.put(g, map3.getOrDefault(g, 0) + 1);
            } else {
                map4.put(g, map4.getOrDefault(g, 0) + 1);
            }

            i++;
        }

        return map1.equals(map3) && map2.equals(map4);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Vector<String> s1 = new Vector<>();
        Vector<String> s5 = new Vector<>();

        for (int i = 1; i <= n; i++) {
            String a = scanner.next();
            s1.add(a);
        }

        n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            String b = scanner.next();
            s5.add(b);
        }

        for (int i = 0; i < n; i++) {
            if (check(s1.get(i), s5.get(i))) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

        scanner.close();
    }
}
