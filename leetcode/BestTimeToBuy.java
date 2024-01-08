package leetcode;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-07
 * Time:17:43
 */
public class BestTimeToBuy {
    // public int maxProfit(int[] prices) {
    //     int profit =0;
    //     int n =prices.length;
    //     int arr[] = new int[n];
    //     arr[n-1] = prices[n-1];
    //     for(int i = n -2; i>=0;i--) {
    //         arr[i] = Math.max(arr[i+1], prices[i]);
    //     }

    //     for(int i=0;i<n;i++) {
    //         profit = Math.max(arr[i] - prices[i], profit);
    //     }

    //     return profit;
    // }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for(int x : prices) {
            min = Math.min(min, x);
            profit = Math.max(x - min, profit);
        }
        return profit;
    }
}
