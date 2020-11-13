package com.dragon.力扣.动态规划;

import java.util.HashSet;
import java.util.Set;

public class N皇后__ {

        public int totalNQueens(int n) {
            Set<Integer> columns = new HashSet<Integer>();      //记录不能放的列
            Set<Integer> diagonals1 = new HashSet<Integer>();   //记录不能放的斜线1
            Set<Integer> diagonals2 = new HashSet<Integer>();   //记录不能放的斜线2
            return backtrack(n, 0, columns, diagonals1, diagonals2);
        }

        public int backtrack(int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
            if (row == n) {
                return 1;
            } else {
                int count = 0;
                //判断这一行的每一个位置
                for (int i = 0; i < n; i++) {
                    if (columns.contains(i)) {
                        continue;
                    }
                    int diagonal1 = row - i;        //行-列
                    if (diagonals1.contains(diagonal1)) {
                        continue;
                    }
                    int diagonal2 = row + i;        //行+列
                    if (diagonals2.contains(diagonal2)) {
                        continue;
                    }
                    columns.add(i);
                    diagonals1.add(diagonal1);
                    diagonals2.add(diagonal2);      //更新不能存放的位置
                    count += backtrack(n, row + 1, columns, diagonals1, diagonals2);    //遍历下一行
                    columns.remove(i);              //清楚位置
                    diagonals1.remove(diagonal1);
                    diagonals2.remove(diagonal2);
                }



                return count;
            }
        }



//位运算
    public int totalNQueens1(int n) {
        return solve(n, 0, 0, 0, 0);
    }

    public int solve(int n, int row, int columns, int diagonals1, int diagonals2) {
        if (row == n) {
            return 1;
        } else {
            int count = 0;
            int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
            while (availablePositions != 0) {//所有位置不全是0，表示又可以放的位置
                int position = availablePositions & (-availablePositions);//可以获得 x 的二进制表示中的最低位的 1 的位置；
                availablePositions = availablePositions & (availablePositions - 1);//可以将 xx 的二进制表示中的最低位的 11 置成 00
                count += solve(n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
            }
            return count;
        }
    }

    }
