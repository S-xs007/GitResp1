package cn.algorithm.leetcode.字符串;
/**
 * @Author: zxS
 * @Date: 12:59 2020/11/20
 * @Description：如果不用StringBuilder，先统计出改变之后的长度，创建一个数组，然后遍历就行了
 */
public class OFFER替换空格 {
    public String replaceSpace(String s) {
        char[] ss = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<ss.length;i++){
            if(ss[i]==' '){
                sb.append("%20");
            }else{
                sb.append(ss[i]);
            }
        }
        return sb.toString();
    }
}
