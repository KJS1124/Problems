package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-03-12
 * Time:22:56
 */
public class Permutation {
    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Set<Integer> set = new HashSet<>();
        permutations(res, A, new ArrayList<>(), set);
        return res;
    }
    public static void permutations(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> actual, ArrayList<Integer> current, Set<Integer> set)
    {
        if(set.size() == actual.size()) {
            res.add(new ArrayList<>(current));
            return;
        }


        for(int i =0;i<actual.size();i++) {
            if(!set.contains(i)) {
                set.add(i);
                current.add(actual.get(i));
                permutations(res,actual,current,set);
                current.remove(current.size()-1);
                set.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Permutation.permute(new ArrayList<Integer>(Arrays.asList(1,1,2)));
        Permutation.permute(new int[]{1,3,2});
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); // to store returning the result
        List<Integer> permutation = new ArrayList<>(); // to store one of the permutation aftereach recursive call
        Set<Integer> visited = new HashSet<>(); // to track if the element is already added to the permutation list
        helper(nums, permutation, res, visited, 0); // permutate helper function
        return res;
    }

    public static void helper(int[] nums, List<Integer> permutation, List<List<Integer>> res, Set<Integer> visited, int currentIndex) {
        if (visited.size() == nums.length) {
            res.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = currentIndex; i < nums.length; i++) {
            if(!visited.contains(nums[i])) {
                permutation.add(nums[i]);
                visited.add(nums[i]);
                helper(nums, permutation, res, visited, currentIndex);
                permutation.remove(permutation.size() - 1);
                visited.remove(nums[i]);
            }
        }
    }
}
