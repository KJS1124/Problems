package leetcode;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-03-12
 * Time:22:08
 */
public class UniquePath {
    public int solve(int[][] A) {
        int x = 0, y = 0;
        int count = 0;
        boolean visited[][] = new boolean[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    x = i;
                    y = j;
                }
                if (A[i][j] == -1) {
                    count++;
                }
            }
        }
        return traverse(A, x, y, visited, count, 0);
    }

    public int traverse(int a[][], int x, int y, boolean visited[][], int count, int totalVisited) {
        if (a[x][y] == 2) {
            if( totalVisited + count + 1 == a.length * a[0].length) {
                return 1;
            } else return 0;
        }
        if(a[x][y]== -1)
            return 0;
        int xx[] = {-1, 1, 0, 0};
        int yy[] = {0, 0, -1, 1};
        visited[x][y] = true;
        int actualAns = 0;
        for (int i = 0; i < 4; i++) {
            if (isSafe(a, x + xx[i], y + yy[i]) && !visited[x + xx[i]][y + yy[i]]) {
                actualAns += traverse(a, x + xx[i], y + yy[i], visited, count, totalVisited +1);
            }
        }
        visited[x][y] = false;
        return actualAns;
    }

    public boolean isSafe(int a[][], int x, int y) {
        return x >= 0 && x < a.length && y >= 0 && y < a[0].length;
    }

    public static void main(String[] args) {
        UniquePath uniquePath = new UniquePath();
        System.out.println(uniquePath.solve(new int[][]{{1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}}));
    }
}
