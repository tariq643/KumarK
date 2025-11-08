package kumarK.hashing;

public class FindCommonPrefixOfTwoArraysOptimal {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int n = A.length;
        int freq[] = new int[n + 1];
        int result[] = new int[n], count = 0;

        for (int i = 0; i < n; i++) {
            freq[A[i]]++;
            if (freq[A[i]] == 2) {
                count++;
            }
            freq[B[i]]++;
            if (freq[B[i]] == 2) {
                count++;
            }
            result[i] = count;
        }
        return result;
    }
}
