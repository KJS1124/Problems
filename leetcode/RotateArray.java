package leetcode;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-08
 * Time:23:17
 */
public class RotateArray {
    public void rotate(int[][] matrix) {
        for(int i =0;i<matrix.length; i++) {
            for(int j =0 ; j<i;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i =0;i<matrix.length; i++) {
            int l =0;
            int r = matrix.length -1;
            while(l<=r) {
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++;
                r--;
            }
        }
    }
}
