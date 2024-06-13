package leetcode;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-02-27
 * Time:20:25
 */
public class FindPeek {
    public static int solve(int[] A) {
        int l = 0;
        int r = A.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid != 0 && mid != A.length - 1 && A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
                return A[mid];
            } else if (mid == 0 || mid == A.length - 1) return A[mid];
            else if (A[mid] < A[mid + 1]) l = mid + 1;
            else r = mid - 1;
        }
        return A[l];
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{2,3}));
    }
}
