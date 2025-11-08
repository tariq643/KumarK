package kumarK.hashing;

import java.util.HashMap;
import java.util.Map;

public class AmazonOAHasingDeliveryQuestion25 {

    public static void main(String[] args) {

        int result = 0;
        int[] arr = {1,8,5,8,5,1,1};
        Map<Integer, Integer> cardinalityMap = new HashMap<>();
        for (int ele : arr) {
            cardinalityMap.put(ele, cardinalityMap.getOrDefault(ele, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : cardinalityMap.entrySet()) {
            int temp = entry.getValue();
            if (temp == -1) {
                result = -1;
                break;
            }
            if (temp % 3 == 0) {
                result = result + temp / 3;
            }
            else {
                result = result + temp / 3 + 1;
            }
        }
        System.out.println(result);
    }
}
