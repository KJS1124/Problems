package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-03-13
 * Time:01:12
 */
public class PallindromPartition {
    Map<Integer, ArrayList<String>> result = new HashMap<>();

    public ArrayList<ArrayList<String>> partition(String a) {
        solve(a, 0, "", true);
        ArrayList<ArrayList<String>> actualResult = new ArrayList<>();
        for (int i = 1; i <= a.length(); i++) {
            ArrayList<String> temp = result.get(i);
            if(temp == null) continue;
            actualResult.add(temp);
        }
        return actualResult;
    }

    public void solve(String a, int current, String temp, boolean previousIncluded) {
        if (current > a.length()) return;
        if (temp.length() > 0 && isPallindrom(temp)) {
            if (result.containsKey(temp.length())) {
                result.get(temp.length()).add(temp);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(temp);
                result.put(temp.length(), list);
            }
        }
        for (int i = current; i < a.length(); i++) {
            if (previousIncluded && i == current) {
                temp += a.charAt(i);
                solve(a, i + 1, temp, true);
                temp = temp.substring(0, temp.length() - 1);
            } else {
                temp = a.charAt(i) + "";
                solve(a, i + 1, temp, true);
                temp = temp.substring(0, temp.length() - 1);
            }
        }

    }


    public boolean isPallindrom(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PallindromPartition pallindromPartition = new PallindromPartition();
        pallindromPartition.partition("efe");
    }

}
