//给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是 2 。 
//
// 
//
// 示例： 
//
// 
//输入：[4, 6, 7, 7]
//输出：[[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]
//] 
//
// 
//
// 提示： 
//
// 
// 给定数组的长度不会超过15。 
// 数组中的整数范围是 [-100,100]。 
// 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。 
// 
// Related Topics 深度优先搜索 
// 👍 268 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> mResult;
    List<Integer> mList;

    public List<List<Integer>> findSubsequences(int[] nums) {
        mResult = new ArrayList<List<Integer>>();
        mList = new ArrayList<Integer>();

        DFS(nums, 0);
        return mResult;
    }

    void DFS(int[] nums, int start){
        // GUI
        if(mList.size() > 1){
            // non-leaf node should also be put into mResult
            mResult.add(new ArrayList<Integer>(mList));
            // no return, recursion will end by 'for' traversal
        }

        // DI
        Set<Integer> pool = new HashSet<Integer>();    // prevent from repeated number
        for(int i = start; i < nums.length; i++){
            if((mList.size() > 0 && nums[i] < mList.get(mList.size() - 1))
            || pool.contains(nums[i])) {
                // not valid
                continue;
            }else{
                // valid, go deeper
                pool.add(nums[i]);
                mList.add(nums[i]);
                DFS(nums, i + 1);
                // track back, and turn mStack back for next traversal
                mList.remove(mList.size() - 1);
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
