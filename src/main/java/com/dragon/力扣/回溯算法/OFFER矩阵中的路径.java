package com.dragon.力扣.回溯算法;

import java.util.TreeMap;

public class OFFER矩阵中的路径 {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int cow = board[0].length;
        char[] words = word.toCharArray();
        for(int i = 0;i<row;i++ ){
            for(int j = 0;j<cow;j++){
                    if(db(board,i,j,words,0)){
                        return true;
                }
            }
        }
        return false;
    }

    private boolean db(char[][] board, int i, int j, char[] words, int wordIndex) {
        //判断边界
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != words[wordIndex]) return false;
        if(wordIndex==words.length-1){
            return true;
        }
        board[i][j] = '\0';
        boolean res =  db(board,i+1,j,words,wordIndex+1)||      //这里不能用++
            db(board,i-1,j,words,wordIndex+1)||
            db(board,i,j+1,words,wordIndex+1)||
            db(board,i,j-1,words,wordIndex+1);
        board[i][j] = words[wordIndex]; //还原现场
        return res;
    }

}
