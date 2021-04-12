//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1258 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> mResult = new ArrayList<List<Integer>>();
    List<Integer> mCurrentList = new ArrayList<Integer>();
    List<Boolean> mUsedList = new ArrayList<Boolean>();    // default value is false

    public List<List<Integer>> permute(int[] nums) {
        for(int val : nums){
            mUsedList.add(false);
        }

        DFS(nums);
        return mResult;
    }

    void DFS(int[] nums){
        // GUI
        if(mCurrentList.size() == nums.length){
            List<Integer> tempList = new ArrayList<Integer>(mCurrentList);
            mResult.add(tempList);
            return;
        }

        // DI
        for(int i = 0; i < nums.length; i++){
            if(mUsedList.get(i) == false){
                // prepare the start conditions for next level
                mCurrentList.add(nums[i]);
                mUsedList.set(i, true);
                DFS(nums);

                // trace back: turn condition back to original for this level
                mCurrentList.remove(mCurrentList.size() - 1);
                mUsedList.set(i, false);
            }else{
                continue;
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
