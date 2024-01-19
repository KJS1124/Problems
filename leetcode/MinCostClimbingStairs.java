package leetcode;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-19
 * Time:01:12
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int min[] = new int[cost.length+1];
        min[0]=cost[0];
        min[1]=cost[1];
        for(int i =2;i<=cost.length;i++) {
            min[i] = Math.min(min[i-1], min[i-2]);
            if(i<cost.length) {
                min[i] += cost[i];
            }
        }
        return min[cost.length];
    }
}
