//给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。 
//
// 例如， 
//
// 
//给定二叉搜索树:
//
//        4
//       / \
//      2   7
//     / \
//    1   3
//
//和值: 2
// 
//
// 你应该返回如下子树: 
//
// 
//      2     
//     / \   
//    1   3
// 
//
// 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。 
// Related Topics 树 
// 👍 114 👎 0


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
    TreeNode mTargetRoot;

    public TreeNode searchBST(TreeNode root, int val) {
        mTargetRoot = null;
        DFS(root, val);
        return mTargetRoot;
    }

    // use pre-order
    void DFS(TreeNode root, int val){
        // GUI
        if(root == null){
            return;
        }

        // DI: as a BST, we can cut the wrong branch if targetRoot must not in range
        if(root.val == val){
            mTargetRoot = root;
        }else if(root.val > val){
            // targetRoot will not exist in the right branch
            DFS(root.left, val);
        }else{
            DFS(root.right, val);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
