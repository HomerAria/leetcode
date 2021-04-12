//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 456 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> mCurrent;
    List<List<Integer>> mResult;

    public List<List<Integer>> combine(int n, int k) {
        mCurrent = new ArrayList<Integer>();
        mResult = new ArrayList<List<Integer>>();     // we can also use linkedList as a Deque

        DFS(k, n, 0);
        return mResult;
    }

    private void DFS(int depth, int n, int start){
        if(mCurrent.size() == depth){
            // put copy of mCurrent into mResult
            List<Integer> tempCurrent = new ArrayList<Integer>(mCurrent);
            mResult.add(tempCurrent);
            return;
        }

        for(int i = start; i < n; ++i){
            mCurrent.add(i + 1);
            DFS(depth, n, i + 1);
            mCurrent.remove(mCurrent.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
