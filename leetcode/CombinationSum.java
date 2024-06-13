package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-02-23
 * Time:17:18
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        RESULT = new ArrayList<>();
        List<Integer> can = new ArrayList<>();
        for(int x : candidates) can.add(x);
        findList(can, target, new ArrayList<>(),0);
        return RESULT;
    }
    static List<List<Integer>> RESULT = new ArrayList<>();
    public static void findList(List<Integer> candidates, int target, List<Integer> selected, int currentElement) {
        if(target==0) {
            //O(n2)
//            Collections.sort(selected);
            if(!doesContains(selected))  {
                RESULT.add(selected);
            }
            return;
        }
        if(target <0) return;
        // O(CANDidates)
        for(int i = currentElement; i<candidates.size();i++) {
            // 2
            if(target - candidates.get(i) >=0) {
                List<Integer> currentSelection = new ArrayList<>(selected);
                currentSelection.add(candidates.get(i));
                // target 5 list 2 // index 0
                // target 3 list 2 2 index
                // target 0 list 2 2 3 index 3
                // (O target - 1)
                findList(candidates, target-candidates.get(i), currentSelection, i);
                // (O target)
                findList(candidates, target, new ArrayList<>(selected), i+1);
            } else {
                return;
            }
        }
    }


    public static boolean doesContains(List<Integer> list) {
        for(List<Integer> testList: RESULT) {
            if(list.size() != testList.size()) continue;
            boolean isAllMatch = true;
            for(int i =0;i<list.size();i++) {
                if(list.get(i) != testList.get(i)) {
                    isAllMatch = false;
                    break;
                }

            }
            if(isAllMatch) return true;;
        }
        return false;
    }
    public static void main(String[] args) {
        int size =4;
        List<Integer> arr = new ArrayList<>();
        int target = 11;
        arr.add(2);
        arr.add(3);
        arr.add(6);
         arr.add(7);


        Collections.sort(arr); // nlogn
        // 2 3 6 7
        findList(arr, target, new ArrayList<>(), 0);
        for(List<Integer> list : RESULT) {
            for(int x : list) {
                System.out.print(x +", ");
            }
            System.out.println();
        }
    }
}