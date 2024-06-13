package leetcode;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-02-26
 * Time:16:14
 */
public class HummingDistance {
    public static int hammingDistance(final int[] A) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int x : A) {
                boolean temp = (x & (1 << i)) > 0;
                if (temp) {
                    count++;
                }
            }
            ans = (ans + (count * (A.length - count))) % 1000000007;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(new int[]{2,4,6}));
    }
}
