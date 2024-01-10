package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-09
 * Time:15:58
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (l, r) -> Integer.compare(l[0], r[0]));
        List<int[]> resultList = new ArrayList<>();

        for (int pair[] : intervals) {
            if (resultList.size() == 0 || resultList.get(resultList.size() - 1)[1] < pair[0]) {
                resultList.add(pair);
            } else {
                resultList.get(resultList.size() - 1)[1] = Math.max(resultList.get(resultList.size() - 1)[1], pair[1]);
            }
        }
        int result[][] = new int[resultList.size()][2];
        int i = 0;
        for (int[] list : resultList) {
            result[i][0] = list[0];
            result[i++][1] = list[1];
        }
        return result;
    }
}
