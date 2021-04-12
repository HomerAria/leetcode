//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 912 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> current = new LinkedList<Integer>();

        for(int depth = 0; depth < nums.length + 1; ++depth){
            DFS(result, nums, 0, depth, current);
        }
        return result;
    }

    // DFS + recursion
    public void DFS(List<List<Integer>> result, int[] nums, int start, int size, List<Integer> current){
        // abort condition
        if(current.size() == size){
            // put the copy of current into result, or it will be clear later
            List<Integer> tempDone = new LinkedList<Integer>(current);
            result.add(tempDone);
            return;
        }

        // go deeper
        for(int i = start; i < nums.length; ++i){
            current.add(nums[i]);
            DFS(result, nums, i + 1, size, current);

            // DFS have returned, which means current list have be put into result
            // In this level, size(depth) will not be changed, so the element just be pushed int
            // should be pop out before entering next loop.
            current.remove(current.size() -1);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
