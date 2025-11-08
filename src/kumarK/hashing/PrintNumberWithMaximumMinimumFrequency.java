package kumarK.hashing;

import java.util.HashMap;
import java.util.Map;

public class PrintNumberWithMaximumMinimumFrequency {

    private void printNumberWithMaximumMinimumFrequency (int[] arr) {

        Map<Integer, Integer> cardinalityMap = new HashMap<>();
        for (int ele : arr) {
            cardinalityMap.put(ele, cardinalityMap.getOrDefault(ele,0) + 1);
        }
        int maxFrequency = Integer.MIN_VALUE, minFrequency = Integer.MAX_VALUE, eleMaxFrequency = arr[0], eleMinFrequency = arr[0];
        for (Map.Entry<Integer,Integer> entry : cardinalityMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                eleMaxFrequency = entry.getKey();
            }
            if (entry.getValue() < minFrequency) {
                minFrequency = entry.getValue();
                eleMinFrequency = entry.getKey();
            }
        }
        System.out.println(eleMaxFrequency + " " + eleMinFrequency);
    }

    public static void main(String[] args) {
        PrintNumberWithMaximumMinimumFrequency printNumberWithMaximumMinimumFrequency = new PrintNumberWithMaximumMinimumFrequency();
        int arr[] = {3,2,3,2,4,3};
        printNumberWithMaximumMinimumFrequency.printNumberWithMaximumMinimumFrequency(arr);
    }
}
