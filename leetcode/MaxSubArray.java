package leetcode;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-07
 * Time:15:59
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum=0;
        int maxSum = Integer.MIN_VALUE;
        for(int i =0;i<n;i++) {
            sum+= nums[i];
            maxSum = Math.max(maxSum, sum);
            if(sum<=0) {
                sum=0;
            }
        }
        return maxSum;
    }
}
