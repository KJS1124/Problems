package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-02-28
 * Time:16:23
 */
public class PaintWall {
        public static int paint(int A, int B, List<Integer> C) {
            long l=0;
            long r = 100000;
            long ans =0;
            while(l<=r) {
                long mid = l + ((r-l)/2);
                if(isPosible(C,mid,A,(long)B)) {
                    ans = mid % 1000000007;
                    r = mid-1;
                }
                else {
                    l = mid +1;
                }
            }
            return (int)ans;
        }

        public static boolean isPosible(List<Integer> c, long mid, int A, long B) {
            long totalTime =0;
            int i =0;
            for(int x: c) {
                totalTime += B * x;
                if(B * x>mid) return false;
                if(totalTime > mid) {
                    i++;
                    totalTime =B * x;
                }
            }

            if(i>=A || totalTime > mid) return false;
            return true;
        }

    public static void main(String[] args) {
        System.out.println(paint(3,10, Arrays.asList(185,186,938,558,655,461,441,234,902,681)));
    }
}
