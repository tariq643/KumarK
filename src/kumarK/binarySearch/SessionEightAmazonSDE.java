package kumarK.binarySearch;

import java.util.HashMap;
import java.util.Map;

public class SessionEightAmazonSDE {

    /*
    You are given a sorted array -> each element in the array occurs for exactly “K” times ;
    except 1 element -> that 1 element occurs for < K times;
    please find that element
    */

    // brute force using a hashmap
    private int sessionEightAmazonSDE (int[] nums, int k) {

        Map<Integer, Integer> cardinalityMap = new HashMap<>();
        for (int num : nums) {
            cardinalityMap.put(num, cardinalityMap.getOrDefault(num, 0 ) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : cardinalityMap.entrySet()) {
            if (entry.getValue() != k) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /*
    * better approach is to consider the numbers in the array as islands
    * 2 2 2 3 3 4 4 4
    * 2 2 2 increase the count till the condition is satisfied nums[i] == nums[i + 1]
    * then reset the counter to 0
    * */

    private int sessionEightAmazonSDEBruteSinglePass (int[] nums, int k) {

        int count = 1, length = nums.length;

        for (int i = 1; i < length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            }
            else {
                if (count < k) {
                    return nums[i];
                }
                count = 1;
            }
        }
        return -1;
    }

    /*
     * binary search is the best way to solve this problem
     * in CP+OA question 1-based indexing is used
     * example if we take the array
     * 2 2 2 4 4 4 6 6 6 7 7 8 8 8
     * low = 0 high = 13 so mid = 13 / 2 = 6
     * create a function that calculates the first and last occurence of the number nums[mid]
     * if the number is absent then last occurence of nums[mid] % k == 0 should be the observation
     * */

    private int sessionEightAmazonSDEOptimalBinarySearch (int[] nums, int k) {

        int length = nums.length, low = 0, high = length - 1;
        while (low <= high) {

            int mid = low + (high - low) / 2;
            int l1 = this.firstOccurence(nums, nums[mid]);
            int h1 = this.lastOccurence(nums, nums[mid]);
            if (Math.abs(h1 - l1) + 1 < k) {
                return nums[mid];
            }
            else {

            }
        }
    }

    public static void main(String[] args) {
        SessionEightAmazonSDE obj = new SessionEightAmazonSDE();
//        int[] nums = {1,1,1,2,2,2,3,3};
        int[] nums = {1,2,2};
        System.out.println(obj.sessionEightAmazonSDEBruteSinglePass(nums,2));
    }
}
