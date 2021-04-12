//给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下： 
//
// 
// 二叉树的根是数组 nums 中的最大元素。 
// 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。 
// 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。 
// 
//
// 返回有给定数组 nums 构建的 最大二叉树 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,1,6,0,5]
//输出：[6,3,5,null,2,0,null,null,1]
//解释：递归调用如下所示：
//- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
//    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
//        - 空数组，无子节点。
//        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
//            - 空数组，无子节点。
//            - 只有一个元素，所以子节点是一个值为 1 的节点。
//    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
//        - 只有一个元素，所以子节点是一个值为 0 的节点。
//        - 空数组，无子节点。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[3,null,2,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// nums 中的所有整数 互不相同 
// 
// Related Topics 树 
// 👍 261 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> mList;

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        mList = new ArrayList<Integer>();
        for(int i:nums){
            mList.add(i);
        }
        return doRecursion(0, mList.size() - 1);
    }

    // [start, end]
    TreeNode doRecursion(int start, int end){
        // GUI
        if(start > end){
            return null;
        }

        // DI
        // Find the Max value node, which is regarded as the root node at this level
        TreeNode root = new TreeNode();
        int maxPosition = getMaxPosition(start, end);
        root.val = mList.get(maxPosition);
        root.left = doRecursion(start, maxPosition - 1);
        root.right = doRecursion(maxPosition + 1, end);
        return root;
    }

    // [start, end]
    int getMaxPosition(int start, int end){
        int max = Integer.MIN_VALUE;
        int result = 0;
        for(int i = start; i <= end; i++){
            if(max < mList.get(i)){
                result = i;
                max = mList.get(i);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
