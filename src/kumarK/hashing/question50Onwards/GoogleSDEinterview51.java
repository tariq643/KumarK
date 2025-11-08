package kumarK.hashing.question50Onwards;

public class GoogleSDEinterview51 {

    // Given an array of N positive integers; find the number of valleys ; of size >=3 .
    //
    // B = [5 3 4 8]
    //
    // Number of V-shapes :- 2 (5,3,4) and (5,3,4,8)

    private int findNumberOfValleysBruteForce (long[] arr) {

        int l = arr.length;
        int count = 0;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (Math.abs(i - j) >= 2 && check(i, j, arr)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean check (int i, int j, long[] arr) {

        // check for the smallest number in the range i...j and all the numbers
        // left to smallest number index should be greater than the smallest number
        // and numbers to the right of the smallest index should also greater than the number
        long smallest = arr[i];
        int smallestIndex = i, length = arr.length;
        for (int l = 0; l < length; l++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
                smallestIndex = i;
            }
        }
        int left = smallestIndex;
        while (left >= i + 1) {
            if (!(arr[left] < arr[left - 1])) {
                return false;
            }
            left = left - 1;
        }
        int right =  smallestIndex;
        while (right < j) {
            if (arr[right] < arr[right + 1]) {

            }
            else {
                return false;
            }
            right = right + 1;
        }
        return true;
    }


    // starting the optimal approach from here
    // try to solve a new question -> for each index 'i' find the number of strictly increasing arrays on the left hand side
    // test case 5 4 3 2 1 8 10 8 at each index the number of strictly increasing arrays
    //           1 2 3 4 5 1  1 2
    private int countNumberOfStrictlySubArraysLeftHandSide (long[] arr) {

        // follows 0-based indexing
        int length = arr.length;
        int[] left = new int[length];
        left[0] = 1;
        for (int i = 1; i < length; i++) {
            if (arr[i - 1] < arr[i]) {
                left[i] = left[i - 1] + 1;
            }
            else {
                left[i] = 1;
            }
        }
        int countNumberOfStrictlySubArraysLeftSide = 0;
        for (int i = 0; i < left.length; i++) {
            countNumberOfStrictlySubArraysLeftSide = countNumberOfStrictlySubArraysLeftSide + left[i];
        }
        return countNumberOfStrictlySubArraysLeftSide;
    }

    // try to solve a new question -> for each index 'i' find the number of strictly increasing arrays on the right hand side
    private int countNumberOfStrictlySubArraysRightHandSide (long[] arr) {
        // follows 0-based indexing
        int length = arr.length;
        int[] right = new int[length];
        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {

            if (arr[i + 1] > arr[i]) {
                right[i] = right[i + 1] + 1;
            }
            else {
                right[i] = 1;
            }
        }
        int countNumberOfStrictlySubArraysRightSide = 0;
        for (int i = 0; i < right.length; i++) {
            countNumberOfStrictlySubArraysRightSide = countNumberOfStrictlySubArraysRightSide + right[i];
        }
        return countNumberOfStrictlySubArraysRightSide;
    }

    // now for each index 'i' find the number of valleys which can be created by keeping 'i' at the bottom
    // formula for that = left[i-1]*right[i-1]
    private int numberOfValleys (long[] arr) {

        int length = arr.length;
        int[] left = new int[length];
        left[0] = 1;
        for (int i = 1; i < length; i++) {
            if (arr[i - 1] < arr[i]) {
                left[i] = left[i - 1] + 1;
            }
            else {
                left[i] = 1;
            }
        }
        int[] right = new int[length];
        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {

            if (arr[i + 1] > arr[i]) {
                right[i] = right[i + 1] + 1;
            }
            else {
                right[i] = 1;
            }
        }
        int numberOfValleys = 0;
        for (int i = 0; i < length; i++) {
            numberOfValleys = numberOfValleys + (left[i] - 1) * (right[i] - 1);
        }
        return numberOfValleys;
    }

    // time complexity : o(3*n)
}
