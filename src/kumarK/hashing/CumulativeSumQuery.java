package kumarK.hashing;

import java.util.Scanner;

public class CumulativeSumQuery {

    private void cumulativeSumQuery () {

        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] prefixSum = new int[len + 1];
        prefixSum[0] = 0;
        for (int i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i-1];
        }
        int t = scanner.nextInt();
        while (t-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(prefixSum[r+1] - prefixSum[l]);
        }
    }

    public static void main(String[] args) {
        CumulativeSumQuery cumulativeSumQuery = new CumulativeSumQuery();
        cumulativeSumQuery.cumulativeSumQuery();
    }
}
