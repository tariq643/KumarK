package kumarK.hashing;

public class FindCommonPrefixOfTwoArraysBrute {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int count = 0, n = A.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = 0; j <= i; j++) {
                for (int k = 0; k <= i; k++) {
                    if (A[j] == B[k]) {
                        count++;
                    }
                }
            }
            result[i] = count;
        }
        return result;
    }

    public static void main(String[] args) {
        FindCommonPrefixOfTwoArraysBrute findCommonPrefixOfTwoArrays = new FindCommonPrefixOfTwoArraysBrute();
//        int[] A = {1,3,2,4,5};
//        int[] B = {3,1,2,4,5};
        int[] A = {2,3,1};
        int[] B = {3,1,2};
        System.out.println(findCommonPrefixOfTwoArrays.findThePrefixCommonArray(A,B));
    }
}
