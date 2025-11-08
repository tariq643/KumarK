package kumarK.hashing;

import java.util.HashMap;
import java.util.Map;

public class CheckIfTwoNumbersExistDistanceLessThanK {

    private boolean checkIfTwoNumbersExistDistanceLessThanK (int[] arr, int k) {

        Map<Integer, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (positionMap.containsKey(arr[i]) && positionMap.get(arr[i]) - i <= k) {
                return true;
            }
            positionMap.put(arr[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        CheckIfTwoNumbersExistDistanceLessThanK checkIfTwoNumbersExistDistanceLessThanK = new CheckIfTwoNumbersExistDistanceLessThanK();
        int[] arr = {3,1,2,3,2};
        System.out.println(checkIfTwoNumbersExistDistanceLessThanK.checkIfTwoNumbersExistDistanceLessThanK(arr, 3));
    }
}
