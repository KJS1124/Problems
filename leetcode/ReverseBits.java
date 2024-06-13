package leetcode;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-02-26
 * Time:16:06
 */
public class ReverseBits {
    public static long reverse(long A) {
        long ans =0;
        for(int i =0;i<32;i++) {
            long bit = (A & (1<<i));
            ans = ((ans<<1) | (bit != 0 ? 1 : 0));
            // A = A >>1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(reverse(3));
    }

}
