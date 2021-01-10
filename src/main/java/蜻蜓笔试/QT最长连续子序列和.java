package 蜻蜓笔试;

public class QT最长连续子序列和 {
    //时间复杂度O(n)  空间复杂度O(1)
    public static int maxSum(int[] nums){
        if(nums==null || nums.length==0)return -1;
        int pre = 0;
        int max = 0;
        for(int i = 0;i<nums.length;i++){
            pre = Math.max(nums[i],pre+nums[i]);
            max = Math.max(max,pre);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSum(nums));
    }
}
