package cn.algorithm.leetcode.图;

import java.util.*;

public class LC朋友圈 {
    int count = 0;
    public int findCircleNum(int[][] M) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0;i<M.length;i++){
            for(int j = 0;j<M[0].length;j++){
                if(i == j)continue;
                if(M[i][j] == 1){
                    map.computeIfAbsent(i,k->new HashSet<>()).add(j);
                    map.computeIfAbsent(j,k->new HashSet<>()).add(i);
                }
            }
        }
        for(int i = 0;i<M.length;i++){
            set.add(i);
        }
        //2.
        bfs(map,set,M.length);
        return count;
    }

    private void bfs(Map<Integer, Set<Integer>> map, Set<Integer> set,int len) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<len;i++){
            if(!set.contains(i))continue;
            count++;
            queue.offer(i);
            set.remove(i);
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int j = 0;j<size;j++){
                    int node = queue.poll();
                    for(int tem:map.getOrDefault(node,new HashSet<>())){
                        if(set.contains(tem)){
                            set.remove(tem);
                            queue.offer(tem);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        LC朋友圈 lc朋友圈 = new LC朋友圈();
        lc朋友圈.findCircleNum(new int[][]{{1, 0, 0, 1},{0,1,1,0},{0,1,1,1},{1,0,1,1}});
    }
}
