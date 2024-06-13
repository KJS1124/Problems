package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-06-11
 * Time:22:13
 */
public class OpenLocks {
    public static void main(String[] args) {
        OpenLocks openLocks = new OpenLocks();
        long currentTime = System.currentTimeMillis();
        System.out.println(openLocks.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
        System.out.println(System.currentTimeMillis() - currentTime);
    }
    public int openLock(String[] deadends, String target) {
        System.out.println("temp");
        Set<String> dead = new HashSet<>();
        for(String d: deadends) {
            dead.add(d);
        }
        Set<String> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node("0000", 0));
        visited.add("0000");
        System.out.println("temp");
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println(current.comb);
            if(current.comb.equals(target)) return current.ways;
            if(dead.contains(current.comb)) continue;
            for(int i =0;i<4;i++) {
                char arr[] = current.comb.toCharArray();
                int k = arr[i];
                int temp = arr[i];

                k = ((((k - '0') + 1) + 10) % 10) + '0';
                arr[i] = (char) k;
                String s = String.valueOf(arr);
                if(!visited.contains(s)) {
                    queue.add(new Node(String.valueOf(arr), current.ways + 1));
                    visited.add(s);
                }

                k = temp;
                k = ((((k - '0') - 1) + 10) % 10) + '0';
                arr[i] = (char) k;
                s = String.valueOf(arr);
                if(!visited.contains(s)) {
                    queue.add(new Node(String.valueOf(arr), current.ways + 1));
                    visited.add(s);
                }
            }
        }
        return -1;
    }
    static class Node {
        String comb;
        int ways;

        public Node(String str, int ways) {
            this.comb = str;
            this.ways = ways;
        }
    }
}
