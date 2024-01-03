package leetcode;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-02
 * Time:22:53
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean isFirstRow=false, isFirstCol=false;
        for(int i =0 ; i< matrix.length; i++) {
            for(int j=0; j< matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i==0) isFirstRow = true;
                    if(j==0) isFirstCol = true;
                    matrix[i][0] =0;
                    matrix[0][j] =0;
                }
            }
        }

        for(int i =1 ; i<matrix.length;i++) {
            if(matrix[i][0] == 0) {
                for(int j =0;j<matrix[0].length;j++) {
                    matrix[i][j] = 0;
                }
            }
        }


        for(int i =1 ; i<matrix[0].length;i++) {
            if(matrix[0][i] == 0) {
                for(int j =0;j<matrix.length;j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        System.out.println(isFirstRow + " "+ isFirstCol);
        if(isFirstRow) for(int i =0 ; i<matrix[0].length;i++) matrix[0][i] = 0;

        if(isFirstCol) for(int i =0 ; i<matrix.length;i++) matrix[i][0] = 0;
    }
}
