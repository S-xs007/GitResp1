package com.dragon.力扣.图和并查集;

import java.util.LinkedList;
import java.util.Queue;

public class F腐烂的橘子 {
    //思路：先把
    public int orangesRotting(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        Queue<Node1> queue = new LinkedList<>();
        for(int i =0;i<R;i++){
            for(int j = 0;i<C;j++){
                if(grid[i][j]==2){
                    queue.offer(new Node1(i,j));
                }
            }
        }
        int time = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                Node1 node1 = queue.poll();
                int i = node1.x;
                int j = node1.y;

                //腐烂
                if(check(grid,R,C,i-1,j)){
                    grid[i-1][j] = 2;
                    queue.offer(new Node1(i-1,j));
                }
                if(check(grid,R,C,i+1,j)){
                    grid[i+1][j] = 2;
                    queue.offer(new Node1(i+1,j));
                }
                if(check(grid,R,C,i,j-1)){
                    grid[i][j-1] = 2;
                    queue.offer(new Node1(i,j-1));
                }
                if(check(grid,R,C,i,j+1)){
                    grid[i][j+1] = 2;
                    queue.offer(new Node1(i,j+1));
                }
            }
            time++;
        }
        boolean flag = true;
        for(int i =0;i<R;i++) {
            for (int j = 0; i < C; j++) {
                if(grid[i][j]==1) {
                    flag = false;
                }
            }
        }
        if(flag){
            return time;
        }
        return -1;
    }
    public boolean check(int[][] g,int c,int k,int i,int j){
        if(i<0||j<0||i>=c||j>=k||g[i][j]!=1){
            return false;
        }
        return true;
    }
    static class Node1 {
        int x;
        int y;
        public Node1(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
