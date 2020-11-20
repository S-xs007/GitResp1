package com.dragon.力扣.数组和字符串;
/**
 * @Author: zxS
 * @Date: 12:53 2020/11/20
 * @Description：在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *                      请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *
 */
public class OFFER二位数组中的查找 {

    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int lie = matrix[0].length-1;
        int hang = 0;
            //从第0行最后一列开始找
        //目标值大，就往下走 行数++
        //目标值小，就向左走 列数--
        while(lie>=0&&hang<matrix.length){
            int tem = matrix[hang][lie];
            if(tem==target){
                return true;
            }else if(tem<target){
                hang++;
            }else{
                lie--;
            }
        }
        return false;
    }
}
