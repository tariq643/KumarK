package kumarK.hashing;

import java.util.ArrayList;
import java.util.List;

public class UberOAQuestion39 {

    public List<Integer> matchingCnt(int n, List<String> X) {
        int[][] g = new int[200005][28];
        List<Integer> p = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            p.add(0);
        }

        for (int i = n - 1; i >= 0; i--) {
            String u = X.get(i);
            int c = 0;
            int d = u.length();
            for (int j = 0; j < d; j++) { // j --> column number
                int y = u.charAt(j) - 'a';
                c = c + g[j][y]; // g[j][y] --> tells you the frequency of y in col "j"
                g[j][y] = g[j][y] + 1;
            }
            p.set(i, c);
        }

        return p;
    }
}
