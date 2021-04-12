//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1095 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> mCurrent;
    List<List<Integer>> mResult;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        mCurrent = new ArrayList<Integer>();
        mResult = new ArrayList<List<Integer>>();

        // sort is necessary, or a big number will cut the whole path
        Arrays.sort(candidates);

        DFS(candidates, 0, target);
        return mResult;
    }

    private void DFS(int[] nums, int start, int target){
        // end the depth search
        if(target == 0){
            List<Integer> tempCurrent = new ArrayList<Integer>(mCurrent);
            mResult.add(tempCurrent);
            return;
        }else if(target < 0){
            // cut down the wrong path
            return;
        }

        // keep depth search, enter a deeper level
        for(int i = start; i < nums.length; ++i){
            // cut down this path
            if(nums[i] > target) break;

            mCurrent.add(nums[i]);
            DFS(nums, i, target - nums[i]);

            // traceback
            mCurrent.remove(mCurrent.size() -1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
