//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 651 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> mResult = new ArrayList<List<Integer>>();
    List<Integer> mCurrentList = new ArrayList<Integer>();
    List<Boolean> mUsedList = new ArrayList<Boolean>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        for(int val : nums){
            mUsedList.add(false);
        }

        DFS(nums);
        return mResult;
    }

    /*
    Compared with 46, containing duplicated value here,
    so we should cut the wrong branch: meet the same value at the same level
    */
    void DFS(int[] nums){
        // GUI
        if(mCurrentList.size() == nums.length){
            List<Integer> tempList = new ArrayList<Integer>(mCurrentList);
            mResult.add(tempList);
        }

        // DI
        Set<Integer> pool = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(mUsedList.get(i) == false){
                // cut the wrong branch--> for the same level, cannot use duplicated value
                if(pool.contains(nums[i])){
                    continue;
                }
                pool.add(nums[i]);

                // prepare the next level condition and then trace back
                mCurrentList.add(nums[i]);
                mUsedList.set(i, true);
                DFS(nums);
                mCurrentList.remove(mCurrentList.size() - 1);
                mUsedList.set(i, false);
            }else{
                continue;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
