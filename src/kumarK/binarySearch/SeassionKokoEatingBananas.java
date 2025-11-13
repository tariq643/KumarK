package kumarK.binarySearch;

public class SeassionKokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1, high = Integer.MIN_VALUE;
        int result = -1;

        for (int pile : piles) {
            if (pile > high) {
                high = pile;
            }
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (this.helper(piles, mid, h)) {
                result = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return result;
    }

    private boolean helper (int[] piles, int eatingSpeed, int hours) {

        int length = piles.length, totalTime = 0;
        for (int i = 0; i < length; i++) {
            totalTime = totalTime + piles[i] / eatingSpeed;
            if (piles[i] % eatingSpeed != 0) {
                totalTime = totalTime + 1;
            }
            if (totalTime > hours) {
                return false;
            }
        }
        return true;
    }
}
