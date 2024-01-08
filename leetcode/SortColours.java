package leetcode;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-07
 * Time:16:10
 */
public class SortColours {
    public void sortColors(int[] nums) {
        int l =0;
        int n = nums.length;
        int r = n-1;
        for(int i =0;i<n;i++) {
            if(nums[i]==0) swap(nums, l++, i);
        }

        for(int i =n-1; i>=0;i--) {
            if(nums[i]==2) swap(nums, r--, i);
        }
    }

    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j] = temp;
    }
}

