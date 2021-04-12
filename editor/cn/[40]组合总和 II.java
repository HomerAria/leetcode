//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 460 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> mCurrentList;
    List<List<Integer>> mResult;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        mCurrentList = new ArrayList<Integer>();
        mResult = new ArrayList<List<Integer>>();

        Arrays.sort(candidates);
        DFS(candidates, target, 0);
        return mResult;
    }

    /*
    The difference with No.39 is here candidates may contains repeated numbers,
    but each combination cannot contain each node more than once.
    This is a typical combination problem
    */
    void DFS(int[] candidates, int target, int startPosition){
         // GUI: hit the condition, and pop currentList into result
         if(target == 0){
            // Cannot add mCurrentList directly, which will be effect by other branch
            List<Integer> tempList = new ArrayList<Integer>(mCurrentList);
            mResult.add(tempList);
            return;
         }

         // DI: contribute the starting conditions and go forward into next depth
         int lastVal = -1;
         for(int i = startPosition; i < candidates.length; i++){
            // cut the wrong branch
            if(candidates[i] > target){
                break;
            }
            if(lastVal > 0 && lastVal == candidates[i]){
                continue;    // Prevent the same value at the same depth
            }

            lastVal = candidates[i];
            mCurrentList.add(candidates[i]);
            DFS(candidates, target - candidates[i], i + 1);
            mCurrentList.remove(mCurrentList.size() - 1);
         }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
