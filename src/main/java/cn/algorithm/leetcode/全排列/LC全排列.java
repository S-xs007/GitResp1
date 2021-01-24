package cn.algorithm.leetcode.全排列;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LC全排列 {
    List<List<Integer>> res = new LinkedList<>();
    Set<Integer> used = new HashSet<>();
    public List<List<Integer>> permute(int[] nums){
        if(nums.length == 0)return res;
        recur(nums,0,new LinkedList<>());
        return res;

    }

    private void recur(int[] nums,int cur,List<Integer> list) {
        if (cur == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(!used.contains(nums[i])){
                list.add(nums[i]);
                used.add(nums[i]);
                recur(nums,cur+1,list);
                used.remove(nums[i]);//回溯
                list.remove(list.size()-1);
            }
        }
    }
}
