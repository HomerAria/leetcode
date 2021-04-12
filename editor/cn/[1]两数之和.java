//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9773 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

/**
        // solution 1: O(N2)
        for(int i = 0 ; i < nums.length ; i++){
            // No need to for-loop from the very beginning, which has been tested before.
            for(int j = i + 1 ; j < nums.length ; j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
**/

        // solution 2: O(N)
        Map<Integer, Integer> pool = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < nums.length ; i++) {

            int diff = target - nums[i];
            if(pool.containsKey(diff)) {
                result[0] = i;
                result[1] = pool.get(diff);
                return result;
            }
            // Key-Value should be put at the end, prevent from the condition: nums[i]*2 = target.
            pool.put(nums[i], i);
        }

        return result;

        // solution 3: O(nlogn), sort + two pointers
    }
}
//leetcode submit region end(Prohibit modification and deletion)
