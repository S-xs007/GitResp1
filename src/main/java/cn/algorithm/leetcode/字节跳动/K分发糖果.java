package cn.algorithm.leetcode.字节跳动;

public class K分发糖果 {
    public static int candy(int[] ratings) {
        int[] result = new int[ratings.length];
        int res = 0;
        for(int i = 0;i<ratings.length;i++){
            if(i==0){
                result[i]++;
                continue;
            }
            if(ratings[i]>ratings[i-1]){
                result[i] = result[i-1]+1;
            }else if(ratings[i]==ratings[i-1]){
                result[i]++;
            }else{  //降序
                if(result[i-1]==1){
                    result[i]++;
                    int j = i;
                    while(j-1>=0 && ratings[j-1]>ratings[j] && result[j-1]<=result[j]){
                        result[j-1]++;
                        j--;
                    }
                }else{
                    result[i] = 1;
                }

            }
        }
        for(int i = 0;i<result.length;i++){
            res +=result[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] tem = new int[]{1,3,2,2,1};
        System.out.println(candy(tem));
    }
}
