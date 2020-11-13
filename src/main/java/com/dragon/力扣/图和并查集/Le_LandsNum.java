package com.dragon.力扣.图和并查集;

import java.util.LinkedList;
import java.util.Queue;

public class Le_LandsNum {
   /* 输入：grid = [
            ["1","1","1","1","0"],
            ["1","1","0","1","0"],
            ["1","1","0","0","0"],
            ["0","0","0","0","0"]
            ]
    输出：1*/
       //广度优先
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int nr = grid.length;   //行
            int nc = grid[0].length;//列
            int num_islands = 0;

            for (int r = 0; r < nr; ++r) {
                for (int c = 0; c < nc; ++c) {
                    if (grid[r][c] == '1') {
                        ++num_islands;
                        grid[r][c] = '0';
                        Queue<Integer> neighbors = new LinkedList<>();
                        neighbors.add(r * nc + c);
                        while (!neighbors.isEmpty()) {
                            int id = neighbors.remove();
                            int row = id / nc;
                            int col = id % nc;
                            if (row - 1 >= 0 && grid[row-1][col] == '1') {
                                neighbors.add((row-1) * nc + col);
                                grid[row-1][col] = '0';
                            }
                            if (row + 1 < nr && grid[row+1][col] == '1') {
                                neighbors.add((row+1) * nc + col);
                                grid[row+1][col] = '0';
                            }
                            if (col - 1 >= 0 && grid[row][col-1] == '1') {
                                neighbors.add(row * nc + col-1);
                                grid[row][col-1] = '0';
                            }
                            if (col + 1 < nc && grid[row][col+1] == '1') {
                                neighbors.add(row * nc + col+1);
                                grid[row][col+1] = '0';
                            }
                        }
                    }
                }
            }

            return num_islands;
        }
    //广度优先
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
            int row = grid.length;
            int cow = grid[0].length;
            int landNums = 0;
            for(int r = 0;r<row;++r){
                for(int c = 0;c<cow;++c){
                    if(grid[r][c]=='1'){
                        landNums++;
                        Queue<Integer> queue = new LinkedList<>();
                        queue.offer(r*cow+c);
                        while(!queue.isEmpty()){
                            int id = queue.poll();
                            int row1 = id/cow;
                            int cow1 = id%cow;
                            if(row1-1>=0 && grid[row1-1][cow1]=='1'){
                                queue.offer((row1-1)*cow+cow1);
                                grid[row1-1][cow1]='0';
                            }
                            if(row1+1<row && grid[row1+1][cow1]=='1'){
                                queue.offer((row1+1)*cow+cow1);
                                grid[row1+1][cow1]='0';
                            }
                            if(cow1-1>=0 && grid[row1][cow1-1]=='1'){
                                queue.offer(row1*cow+cow1-1);
                                grid[row1][cow1-1]='0';
                            }
                            if(cow1+1<cow && grid[row1][cow1+1]=='1'){
                                queue.offer(row1*cow+cow1+1);
                                grid[row1][cow1+1]='0';
                            }
                        }
                    }
                }
            }
            return landNums;
    }

    }

