package cn.algorithm.leetcode.图;

import java.util.*;


public class LC课程安排 {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] tem:prerequisites){
            map.computeIfAbsent(tem[0],k->new HashSet<>()).add(tem[1]);
        }
        List<Boolean> list = new LinkedList<>();
        for(int[] edeg:queries){
            list.add(dfs(map,edeg[0],edeg[1]));
        }
        return list;
    }

    private Boolean dfs(Map<Integer, Set<Integer>> map, int from, int to) {
        Set<Integer> used = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(from);
        used.add(from);
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(!map.containsKey(node))return false;
            Set<Integer> set = map.get(node);
            if (set == null) continue;
                for(int value:set){
                    if(value == to)return true;
                    if(used.contains(value))continue;
                    queue.offer(value);
            }

        }
        return false;
    }
}
