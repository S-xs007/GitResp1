package com.dragon.力扣.数组和字符串;

public class C查找数组中重复位置 {

        private int extremeInsertionIndex(int[] nums, int target, boolean left) {
            int lo = 0;
            int hi = nums.length;

            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (nums[mid] > target || (left && target == nums[mid])) {
                    hi = mid;
                }
                else {
                    lo = mid+1;
                }
            }
            return lo;
        }

        public int[] searchRange(int[] nums, int target) {
            int[] targetRange = {-1, -1};

            int leftIdx = extremeInsertionIndex(nums, target, true);
            if (leftIdx == nums.length || nums[leftIdx] != target) {
                return targetRange;
            }

            targetRange[0] = leftIdx;
            targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

            return targetRange;
        }

    public static void main(String[] args) {

        /*while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target ) { //|| (left && target == nums[mid]
                hi = mid;   //大了就向左走
            }
            else {
                lo = mid+1; //小了就像右走    （得到的结果要-1，并且不一定能找的到 ，lo，hi只是个范围。lo-1）
            }
        }
        return lo;*/
    }
    }

