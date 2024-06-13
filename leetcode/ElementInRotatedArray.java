package leetcode;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-02-27
 * Time:20:44
 */
public class ElementInRotatedArray {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int search(final int[] A, int target) {
        int l = 0;
        int r = A.length - 1;
        int pivot = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (mid !=0 && mid != A.length -1 && A[mid - 1] > A[mid]) {
                pivot = mid;
                break;
            }
            if (A[mid] < A[A.length - 1]) {
                r = mid - 1;
            } else l = mid + 1;
        }

        if (target < A[A.length - 1]) {
            l = pivot;
            r = A.length -1;
        } else {
            l=0;
            r = pivot-1;
        }

        while (l <= r) {
            int mid = (l + r) >> 1;
            if (target == A[mid]) {
                return mid;
            }
            if (target < A[mid]) {
                r = mid - 1;
            } else l = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int []{192, 194, 197, 198, 199, 200, 201, 203, 204, 2, 3, 4, 7, 9, 10, 11, 14, 15, 16, 17, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 33, 34, 35, 36, 39, 40, 42, 43, 46, 47, 50, 51, 52, 53, 55, 57, 59, 60, 64, 66, 68, 70, 71, 72, 75, 76, 78, 85, 86, 87, 91, 92, 94, 95, 96, 99, 102, 105, 106, 107, 109, 111, 113, 114, 115, 119, 120, 121, 123, 125, 129, 130, 131, 133, 134, 137, 138, 139, 140, 141, 142, 143, 145, 146, 149, 151, 152, 156, 160, 161, 165, 167, 168, 170, 171, 176, 177, 178, 179, 180, 181, 182, 185, 186, 190}, 70));
    }

}
