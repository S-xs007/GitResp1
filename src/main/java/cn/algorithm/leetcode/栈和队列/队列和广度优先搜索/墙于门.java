package cn.algorithm.leetcode.栈和队列.队列和广度优先搜索;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * -1表示墙或是障碍物
 * 0表示一扇门
 * INF无限表示一个空的房间。然后，我们用231 - 1 = 2147483647代表INF。你可以认为通往门的距离总是小于2147483647的。
 *
 */
public class 墙于门 {
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[]{1, 0},
            new int[]{-1, 0},
            new int[]{0, 1},
            new int[]{0, -1}
    );

    public void wallsAndGates(int[][] rooms) {
        //1.先把所有门放在一个队列中
        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == GATE) {
                    q.add(new int[]{row, col});
                }
            }
        }
        while (!q.isEmpty()) {
            //得到门的坐标
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            //四个方向走
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];
                //判断边界，以及是否走过
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                q.add(new int[]{r, c});
            }
        }
    }
}
