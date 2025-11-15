package kumarK.binarySearch;

public class Session11SearchInsertPosition {

    // leet code to find the upper bound of the question
    public int searchInsert(int[] nums, int target) {

        int low = 0 , high = nums.length - 1, result = high + 1;
        // find the upper bound of the target
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                result = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return result;
    }

    // search in a 2 d matrix
    public boolean searchMatrix(int[][] mat, int target) {

        int m = mat.length, n = mat[0].length;
        int low = 0, high = m - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target >= mat[mid][0] && target <= mat[mid][n - 1]) {
                return searchInRow(mat[mid], target);
            }
            else if (target >= mat[mid][n - 1]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return false;
    }

    private boolean searchInRow(int[] row, int target) {

        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == row[mid]) {
                return true;
            }
            else if (target > row[mid]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return false;
    }
}
