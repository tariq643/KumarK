package kumarK.binarySearch;

public class SessionSevenAmazonOA {

    /*
    You are given an array of size “N” ; you are given a capacity of “k” ;
    Each element can be reduced by at most k in 1 move. You are allowed to make maximum “d” moves.
    Find the minimum possible value of “k”

    example if arr = [5 8 3] and x = 2
    then 5 will be destroyed in 3 moves
    similarly 8 will be destroyed in 4 moves
    and 3 in 2 moves
    so total moves = 3 + 2 + 4 = 9

    for the array [5 8 3]
    for k = 1 minimum number of moves = 16
    for k = 2 minimum number of moves = 3 + 4 + 2 = 9
    for k = 3 minimum number of moves = 2 + 3 + 1 = 6

    now we will be given a number d .. suppose d = 8 so we should k = 3
    that is the maximum k that is <= d.

    question is same as koko eating bananas

    with increasing k the number of moves decrease

    d1 >= d2 >= d3 >= d4 ..... (always)

    */
    private int sessionSevenAmazonOA (int[] pages, int x) {

        int low = 0, high = Integer.MIN_VALUE;
        int result = -1;

        for (int page : pages) {
            if(page > high) {
                high = page;
            }
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (this.helper(pages, mid, x)) {
                result = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return result;
    }

    private boolean helper (int[] pages, int page ,int x) {

        int length = pages.length, totalPage = 0;
        for (int i = 0; i < length; i++) {
            totalPage = totalPage + pages[i] / page;
            if (pages[i] % page != 0) {
                totalPage = totalPage + 1;
            }
            if (totalPage > x) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SessionSevenAmazonOA obj = new SessionSevenAmazonOA();
        int[] pages = {5,3,4};
        System.out.println(obj.sessionSevenAmazonOA(pages,4));
    }
}
