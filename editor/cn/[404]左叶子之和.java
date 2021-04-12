//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 
// 👍 298 👎 0


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
    int leftSum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        DFS(root, false);
        return leftSum;
    }

    void DFS(TreeNode root, boolean leftNode){
        // GUI
        if(root == null){
            return;
        }

        // DI: pre-order
        // whether root's parent is a left leaf?
        if(leftNode && root.left == null && root.right == null){
            leftSum += root.val;
        }
        DFS(root.left, true);
        DFS(root.right, false);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
