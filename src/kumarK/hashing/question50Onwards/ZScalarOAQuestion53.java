package kumarK.hashing.question50Onwards;

import java.util.HashMap;
import java.util.Map;

public class ZScalarOAQuestion53 {

    // we are given an array of size 'N'. Find the number of subarrays which are have the same element at
    // start as well as the end and the sum of the elements inside the subarray should be equal.
    // that is sum of internal numbers = first number = last number

    // brute force check all the subarrays
    // run two nested for loops
    private int stableSubArray (long[] arr) {

        int length = arr.length;
        long sum, focusSum;
        int count = 0;
        for (int i = 0; i < length; i++) {
            sum = 0L;
            for (int j = i; j < length; j++) {
                sum = sum + arr[j];
                focusSum = sum - (arr[i] + arr[j]);
                if (arr[i] == arr[j] && focusSum == arr[i]) {
                    count++;
                }
            }
        }
        return count;
    }

    // optimal
    // example
    // 8 4 [5 1 2 2 5] -> stable subarray
    // analyze any subarray problem using i ... j and form an equation and
    // use a hashmap and solve it
    // p[j] = sum of numbers from index 0 to j
    // p[i - 1] = sum of numbers from index to i - 1
    // so p[j] - p[i - 1] => sum[i...j]
    // let g = p[j] - p[i - 1] - c[j] this is formula
    // c[j] to get the sum of sum[i..j]

    // optimized
    private long stableSubArrayOptimal (long[] arr) {

        Map<Pair<Long, Long>, Long> map = new HashMap<>();
        long length = arr.length, countStableArray = 0;
        long sum = 0L;
        for (int i = 0; i < length; i++) {
            sum = sum + arr[i];
            long focusedSum = sum - 2 * arr[i];
            countStableArray = countStableArray + map.getOrDefault(new Pair<>(arr[i],focusedSum),0L);
            map.put(new Pair<>(arr[i], sum), map.getOrDefault(new Pair<>(arr[i], sum),0L)+1L);
        }
        return countStableArray;
    }

}

class Pair<K, V> {
    private final K first;
    private final V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (!first.equals(pair.first)) return false;
        return second.equals(pair.second);
    }

    @Override
    public int hashCode() {
        int result = first.hashCode();
        result = 31 * result + second.hashCode();
        return result;
    }
}
