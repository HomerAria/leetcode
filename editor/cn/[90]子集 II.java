//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//] 
// Related Topics 数组 回溯算法 
// 👍 356 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> mCurrent;
    List<List<Integer>> mResult;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        mCurrent = new ArrayList<Integer>();
        mResult = new ArrayList<List<Integer>>();

        // nums array should be sort first
        Arrays.sort(nums);

        for(int depth = 0; depth <= nums.length; ++depth){
            // Solution 1: branch-cutting, use set to prevent from duplicated value
//             DFS(nums, depth, 0);

            // Solution 2: branch-cutting, store the value of last node at the same depth
            DFS2(nums, depth, 0);
        }
        return mResult;
    }

    public void DFS(int[] nums, int depth, int start){
        if(mCurrent.size() == depth){
            List<Integer> tempCurrent = new ArrayList<Integer>(mCurrent);
            mResult.add(tempCurrent);
            return;
        }

        Set<Integer> pool = new HashSet<Integer>();
        for(int i = start; i < nums.length; ++i){
            if(i == start || !pool.contains(nums[i])){
                // beginning of this depth
                // or a new non-duplicated value in this depth
                mCurrent.add(nums[i]);
                DFS(nums, depth, i + 1);
                mCurrent.remove(mCurrent.size() - 1);

                // add to pool
                pool.add(nums[i]);
            }
        }
    }

    // Use a different branch cut method from DFS
    void DFS2(int[] candidates, int depth, int startPosition){
        // GUI
        if(mCurrent.size() == depth){
            List<Integer> tempList = new ArrayList<Integer>(mCurrent);
            mResult.add(tempList);
        }

        // DI
        int lastVal = 0;
        for(int i = startPosition; i < candidates.length; i++){
            // cut the wrong branch
            // we should not go deeper when meets the same value at same depth
            if(i > startPosition && candidates[i] == lastVal){
                continue;
            }

            lastVal = candidates[i];
            mCurrent.add(candidates[i]);
            DFS2(candidates, depth, i + 1);
            mCurrent.remove(mCurrent.size() -1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
