package kumarK.hashing;

public class AmazonOAQuestion46 {

    // given an array of n integers find the sum of f(x,y) such that f(x,y) = x + y(concatenation)
    // brute force
    private long sumOfAllPairsBruteForce (long[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sum = sum + f(arr[i], arr[j]);
            }
        }
        return sum;
    }

    private long f(long x, long y) {
        String xs = String.valueOf(x);
        String ys = String.valueOf(y);
        return Long.parseLong(xs + ys);
    }

    // optimal
    private long sumOfAllPairsOptimal (long[] arr) {
        long sum = 0, num, sumOfArray = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            sumOfArray = sumOfArray + arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            num = arr[i];
            while (num > 0) {
                count++;
                num = num / 10;
            }
            sum = sum + arr[i] * (arr.length - 1)  + (long)Math.pow(10, count) * sumOfArray;
        }
        return sum;
    }

    public static void main(String[] args) {
        AmazonOAQuestion46 obj = new AmazonOAQuestion46();
        long[] arr= new long[]{3,14,25};
        System.out.println(obj.sumOfAllPairsOptimal(arr));
    }
}
