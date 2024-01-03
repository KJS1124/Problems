package leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-03
 * Time:07:40
 */
public class PascalTriangle {
    class Solution {
         public List<List<Integer>> generate1(int numRows) {
             List<List<Integer>> result = new ArrayList<>();
             for(int i=0;i<numRows; i++) {
                 result.add(new ArrayList<>());
                 for(int j=0; j<=i;j++) {
                     if(j==0 || j==i) result.get(i).add(1);
                     else result.get(i).add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
                 }
             }
             return result;
         }

        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            for(int i=0;i<numRows; i++) {
                result.add(new ArrayList<>());
                for(int j=0; j<=i;j++) {
                    result.get(i).add(combination(i,j));
                }
            }
            return result;
        }

        public int combination(int n, int r) {
            return (fact(new BigInteger(String.valueOf(n))).divide((fact(new BigInteger(String.valueOf(r))).multiply(fact(new BigInteger(String.valueOf(n-r))))))).intValue();
        }

        public BigInteger fact(BigInteger x) {
            if(x.equals(BigInteger.ZERO)) return BigInteger.ONE;
            return x.multiply(fact(x.subtract(BigInteger.ONE)));
        }
    }
}
