//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯算法 
// 👍 275 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> mCurrentList;
    List<List<Integer>> mResult;

    public List<List<Integer>> combinationSum3(int k, int n) {
        mCurrentList = new ArrayList<Integer>();
        mResult = new ArrayList<List<Integer>>();

        // use i replace value, so we start from 1 to 9.
        DFS(k, 1, n);
        return mResult;
    }

    // This problem can be translate into a tree with given depth 'k', and combination
    // sum target is 'n', gives all the possible combination.
    void DFS(int depth, int startPosition, int target){
        // GUI
        if(mCurrentList.size() == depth){
            if(target == 0){
                // hit the condition
                List<Integer> tempList = new ArrayList<Integer>(mCurrentList);
                mResult.add(tempList);
            }
            return;
        }

        // DI
        for(int i = startPosition; i < 10; i++){
            // cut the wrong branch
            if(i > target){
                break;
            }

            mCurrentList.add(i);
            DFS(depth, i + 1, target - i);
            mCurrentList.remove(mCurrentList.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
