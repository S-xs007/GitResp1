package cn.algorithm.leetcode.数组;

public class OFFER顺时针打印矩阵 {
        public int[] spiralOrder(int[][] matrix) {
            //判空
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return new int[0];
            }
            int rows = matrix.length, columns = matrix[0].length;
            boolean[][] visited = new boolean[rows][columns];   //二维数组访问过的标记
            int total = rows * columns;
            int[] order = new int[total];   //结果数组
            int row = 0, column = 0;
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};    //向右列+1  向下行+1  向左列-1  向上行-1
            int directionIndex = 0; //0，1，2，3
            for (int i = 0; i < total; i++) {   //遍历
                order[i] = matrix[row][column];
                visited[row][column] = true;        //先打印当前元素，然后在判断下一个方向
                int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
                if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {//越界或者访问过了
                    directionIndex = (directionIndex + 1) % 4;//切换方向
                }
                row += directions[directionIndex][0];   //
                column += directions[directionIndex][1];
            }
            return order;
        }
}
