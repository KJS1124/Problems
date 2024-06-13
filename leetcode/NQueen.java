package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-03-13
 * Time:00:21
 */
public class NQueen {
    ArrayList<ArrayList<String>> result = new ArrayList<>();

    public ArrayList<ArrayList<String>> solveNQueens(int A) {
        boolean available[][] = new boolean[A][A];
        solve(A, available, new ArrayList<>());
        return result;
    }

    public void solve(int n, boolean available[][], List<Integer> choose) {
        if (n == 0) {
            ArrayList<String> strArr = new ArrayList<>();
            int i = 0;
            for (boolean arr[] : available) {
                String str = "";
                for (boolean x : arr)
                    str += ".";
                char arrs[] = str.toCharArray();
                arrs[choose.get(i++)] = 'Q';
                strArr.add(String.valueOf(arrs));
            }
            result.add(strArr);
            return;
        }

        for (int i = 0; i < available.length; i++) {
            if (!available[n - 1][i]) {
                boolean[][] newArr = cloneArray(available);
                mark(newArr, n - 1, i);
                choose.add(i);
                solve(n - 1, newArr, choose);
                choose.remove(choose.size() - 1);
            }
        }
    }

    public void mark(boolean available[][], int x, int y) {
        for (int i = x; i < available.length; i++) available[i][y] = true;
        for (int i = y; i < available[0].length; i++) available[x][i] = true;
        for (int i = x; i >= 0; i--) available[i][y] = true;
        for (int i = y; i >= 0; i--) available[x][i] = true;

        for (int i = x, j = y; i < available.length && j < available[0].length; i++, j++) available[i][j] = true;
        for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) available[i][j] = true;
        for (int i = x, j = y; i >= 0 && j < available[0].length; i--, j++) available[i][j] = true;
        for (int i = x, j = y; i < available.length && j >= 0; i++, j--) available[i][j] = true;
    }

    public boolean[][] cloneArray(boolean[][] src) {
        int length = src.length;
        boolean[][] target = new boolean[length][src[0].length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(src[i], 0, target[i], 0, src[i].length);
        }
        return target;
    }

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        nQueen.solveNQueens(1);
    }
}
