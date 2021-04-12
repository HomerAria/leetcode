//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1267 👎 0


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
    public boolean isSymmetric(TreeNode root) {
        return DFSIsSymmetric(root.left, root.right);
    }

    boolean DFSIsSymmetric(TreeNode leftRoot, TreeNode rightRoot){
        // GUI: return conditions
        if(leftRoot == null && rightRoot == null){
            return true;
        }else if(leftRoot == null || rightRoot == null){
            return false;
        }else if(leftRoot.val != rightRoot.val){
            return false;
        }

        // DI: set the beginning conditions and pass it to next level
        boolean sideOutIsSame = DFSIsSymmetric(leftRoot.left, rightRoot.right);
        boolean sideInIsSame = DFSIsSymmetric(leftRoot.right, rightRoot.left);
        return sideInIsSame && sideOutIsSame;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
