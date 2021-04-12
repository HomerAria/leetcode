//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 
// 👍 803 👎 0


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
    public TreeNode invertTree(TreeNode root) {
        // Solution 1: DFS
        // both pre-order and post-order work fine, but in-order is useless
        DFS(root);
        return root;

        // Solution 2: BFS
    }

    // here, pre-order is used
    void DFS(TreeNode root){
        // GUI
        if(root == null){
            return;
        }

        // DI: swap left and right children, then go to next level
        TreeNode leftChild = root.left;
        TreeNode rightChild = root.right;
        root.left = rightChild;
        root.right = leftChild;

        DFS(root.left);
        DFS(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
