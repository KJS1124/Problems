package leetcode;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-05
 * Time:16:37
 */
public class NextPermutation {

    public static void main(String args[]) {
        NextPermutation nextPermutation = new NextPermutation();
        int arr[] = {1,1,5};
        nextPermutation.nextPermutation(arr);
        for(int x : arr) System.out.println(x);
    }
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        if (pivot != -1) {
            for (int i = n - 1; i >= 0; i--) {
                if (nums[pivot] < nums[i]) {
                    int temp = nums[pivot];
                    nums[pivot] = nums[i];
                    nums[i] = temp;

                    int l = pivot+1;
                    int r = n-1;
                    while(l<r) {
                        int temp2 = nums[l];
                        nums[l] = nums[r];
                        nums[r] = temp2;
                        l++;
                        r--;
                    }
                    break;
                }
            }
        } else {
            int l = 0;
            int r = n-1;
            while(l<r) {
                int temp2 = nums[l];
                nums[l] = nums[r];
                nums[r] = temp2;
                l++;
                r--;
            }
        }
    }
}
