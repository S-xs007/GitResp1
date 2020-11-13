package com.dragon.力扣.每日一题;

import java.util.*;

public class L困难10_31 {
}
class RandomizedCollection {
    Map<Integer, Set<Integer>> idx; //key=插入的值 set存储插入的每个位置（允许重复可能有多个位置）
    List<Integer> nums; //正常存放元素的地方

    public RandomizedCollection() {
        idx = new HashMap<Integer, Set<Integer>>();
        nums = new ArrayList<Integer>();
    }

    public boolean insert(int val) {
        nums.add(val);          //添加到元素几个
        Set<Integer> set = idx.getOrDefault(val, new HashSet<Integer>());       //从map中查找元素的位置
        set.add(nums.size() - 1);   //添加新的位置
        idx.put(val, set);          //放回去
        return set.size() == 1;
    }

    public boolean remove(int val) {
        if (!idx.containsKey(val)) {
            return false;
        }
        Iterator<Integer> it = idx.get(val).iterator(); //得到这个值的每个位置 并迭代
        int i = it.next();
        int lastNum = nums.get(nums.size() - 1);        //得到list集合最后一个元素
        nums.set(i, lastNum);                           //让最后一个元素覆盖我们要删除的元素
        idx.get(val).remove(i);                         //从map中移除对应的下标信息（不是删除全部下表）
        idx.get(lastNum).remove(nums.size() - 1);
        if (i < nums.size() - 1) {
            idx.get(lastNum).add(i);
        }
        if (idx.get(val).size() == 0) { //如果就只有一个下表，那就删除所有
            idx.remove(val);
        }
        nums.remove(nums.size() - 1);
        return true;
    }

    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }
}


