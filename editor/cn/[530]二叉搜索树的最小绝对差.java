//给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。 
//
// 
//
// 示例： 
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
// 
//
// 
//
// 提示： 
//
// 
// 树中至少有 2 个节点。 
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 
//相同 
// 
// Related Topics 树 
// 👍 235 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    long mMinInterval;
    Integer mLastVal;

    public int getMinimumDifference(TreeNode root) {
        mMinInterval = Long.MAX_VALUE;
        mLastVal = null;

        DFS(root);
        return (int)mMinInterval;
    }

    /*
    traversal in-order
    */
    void DFS(TreeNode root){
        // GUI
        if(root == null){
            return;
        }

        // DI
        DFS(root.left);
        if(mLastVal == null){
            // First time come here, which mean this root is the leftest node(minimum val)
            mLastVal = root.val;
        }else{
            // root.val will always increase.
            mMinInterval = Math.min(root.val - mLastVal, mMinInterval);
            mLastVal = root.val;
        }
        DFS(root.right);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
