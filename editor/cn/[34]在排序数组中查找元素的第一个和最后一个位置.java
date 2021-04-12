//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 880 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int mLowerB;
    int mUpperB;

    public int[] searchRange(int[] nums, int target) {
        mLowerB = 0;
        mUpperB = nums.length -1;
        if(nums.length == 0){
            return new int[]{-1, -1};
        }

        BSLowerBound(mLowerB, mUpperB, target, nums);
        BSUpperBound(mLowerB, mUpperB, target, nums);

        if(nums[mLowerB] != target){
            // target not exist in nums
            return new int[]{-1, -1};
        }else if(nums[mUpperB] == target){
            // cannot find a bigger number, which means target is the biggest number.
            return new int[]{mLowerB, mUpperB};
        }else{
            return new int[]{mLowerB, mUpperB -1};
        }
    }

    /*
    Binary Search the lower boundary, which is the first number not bigger than target
    */
    void BSLowerBound(int lower, int upper, int target, int[] nums){
        // GUI
        if(lower == upper){
            mLowerB = lower;
            return;
        }

        // DI
        int middle = lower + (upper - lower) / 2;
        if(nums[middle] >= target){
            BSLowerBound(lower, middle, target, nums);
        }else{
            BSLowerBound(middle + 1, upper, target, nums);
        }
    }

    /*
    Binary Search the upper boundary, which is the first number bigger than target
    */
    void BSUpperBound(int lower, int upper, int target, int[] nums){
        // GUI
        if(lower == upper){
            mUpperB = lower;
            return;
        }

        // DI
        int middle = lower + (upper - lower) / 2;
        if(nums[middle] > target){
            BSUpperBound(lower, middle, target, nums);
        }else{
            BSUpperBound(middle + 1, upper, target, nums);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
