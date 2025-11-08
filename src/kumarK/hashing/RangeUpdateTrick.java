package kumarK.hashing;

import java.util.Arrays;
import java.util.Scanner;

public class RangeUpdateTrick {

    public static void main(String[] args) {

        int n = 8;
        int[] arr = new int[n + 1];
        Arrays.fill(arr, 0);
        int q = 2;
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        while (index < q) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            arr[l - 1] = arr[l - 1] + 1;
            arr[r] = arr[r] - 1;
            index++;
        }
        // calculate prefix sum
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }

        Arrays.stream(arr).forEach(System.out::print);
    }
}
