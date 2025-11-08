package kumarK.hashing;

public class LeetQuestion49 {

    // You are given a 0-indexed integer array nums.
    //
    //Return the maximum value over all triplets of indices (i, j, k) such that i < j < k. If all such triplets have a negative value, return 0.
    //
    //The value of a triplet of indices (i, j, k) is equal to (nums[i] - nums[j]) * nums[k].
    //
    //Note: Please do not copy the description during the contest to maintain the integrity of your submissions.

    public long maximumTripletValueBruteForce(int[] nums) {

        long maximum = 0;
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                for (int k = j + 1; k < l; k++) {
                    maximum = Math.max(maximum, (long) (nums[i] - nums[j]) * nums[k]);
                }
            }
        }
        return maximum;
    }

    public static void main(String[] args) {
        LeetQuestion49 obj = new LeetQuestion49();
        int nums[] = {12,6,1,2,7};
        System.out.println(obj.maximumTripletValueBruteForce(nums));
    }
}
