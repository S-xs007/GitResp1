package cn.algorithm.leetcode.数组;

import javax.xml.bind.annotation.XmlID;

public class OFFER旋转数组的最小数字 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length-1;
        while(right>left){
            int mid = left+((right-left)>>1);
            if(numbers[right]>numbers[mid]){       //右边大找左边
                right = mid;
            }else if(numbers[mid]>numbers[right]){   //中间大找右边
                left = mid+1;
            }else {
                right--;
            }
        }
        return numbers[left];
    }
}
