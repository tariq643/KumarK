package kumarK.binarySearch;

public class Session6FindfirstOccuernceof1in0s {

    private int findfirstOccuernceof1in0s (int[] nums) {

        int low = 0, high = nums.length - 1;
        int firstOccurence = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == 0) {
                low = mid + 1;
            }
            else {
                firstOccurence = mid;
                high = mid - 1;
            }
        }
        return firstOccurence;
    }

    public static void main(String[] args) {
        Session6FindfirstOccuernceof1in0s obj = new Session6FindfirstOccuernceof1in0s();
        int[] nums = {1,1,1,1,1};
        System.out.println(obj.findfirstOccuernceof1in0s(nums));
    }
}
