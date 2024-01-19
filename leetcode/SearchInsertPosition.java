package leetcode;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-18
 * Time:23:15
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        return r;
    }

    public int binarySearch(int l, int r, int nums[], int target) {
        if (l >= r) return l;
        int mid = l + r >> 1;
        if (nums[mid] == target) return mid;
        if (nums[mid] < target) return binarySearch(mid + 1, r, nums, target);
        return binarySearch(l, mid, nums, target);
    }
}
