package cn.algorithm.leetcode.图;

import java.util.Scanner;

public class LC单词搜索 {
        private boolean[][] marked;
        private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        // 盘面上有多少行
        private int m;
        // 盘面上有多少列
        private int n;
        private String word;
        private char[][] board;

        public boolean exist(char[][] board, String word) {
            m = board.length;
            if (m == 0) {
                return false;
            }
            n = board[0].length;
            marked = new boolean[m][n];
            this.word = word;
            this.board = board;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(board[i][j] == word.charAt(0))
                    if (dfs(i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(int i, int j, int start) {
            if (start == word.length() - 1) {           //数量够了就看最后一个字母
                return board[i][j] == word.charAt(start);
            }
            if (board[i][j] == word.charAt(start)) {
                marked[i][j] = true;
                for (int k = 0; k < 4; k++) {   // 0 1 2 3 四个方向
                    int newX = i + direction[k][0];
                    int newY = j + direction[k][1];
                    if (inArea(newX, newY) && !marked[newX][newY]) {
                        if (dfs(newX, newY, start + 1)) {
                            return true;
                        }
                    }
                }
                marked[i][j] = false;
            }
            return false;
        }

        private boolean inArea(int x, int y) {
            return x >= 0 && x < m && y >= 0 && y < n;
        }


    public static void main(String[] args) {

//        char[][] board =
//                {
//                        {'A', 'B', 'C', 'E'},
//                        {'S', 'F', 'C', 'S'},
//                        {'A', 'D', 'E', 'E'}
//                };
//
//        String word = "ABCCED";

        System.out.println("二维数组的列数：");
        Scanner scan=new Scanner(System.in);
        int r=scan.nextInt();
        int c=scan.nextInt();
        char[][] board=new char[r][c];
        scan.nextLine();//用来跳过行列后的回车符
        for(int i=0;i<r;i++) {
            String tem = scan.nextLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = tem.charAt(j);
                System.out.print(board[i][j] + ",");
            }
            System.out.println("");
        }
        LC单词搜索 lc单词搜索 = new LC单词搜索();
        boolean exist = lc单词搜索.exist(board, "ABCCED");
        System.out.println(exist);
    }

}
