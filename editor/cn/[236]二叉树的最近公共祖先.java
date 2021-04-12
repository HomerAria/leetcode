//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
// Related Topics 树 
// 👍 878 👎 0


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
    TreeNode mResult;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        DFS(root, p.val ,q.val);
        return mResult;
    }

    /*
    Here has the same hit condition with No.235. We cannot tell p/q on the left or right branch
    by their val. So we use post-order from bottom to up.
    In a post-order template, root.left ==> root.right ==> root. When left branch find q and
    right branch find q, root is the target.
    */
    private boolean DFS(TreeNode root, int p, int q){
        // GUI
        if(root == null){
            return false;
        }

        // DI
        boolean isFoundInLeft = DFS(root.left, p, q);
        boolean isFoundInRight = DFS(root.right, p, q);
        // 1. root is q or q, and root's branch also find q or p ==> root is target
        if((root.val == p || root.val == q) && (isFoundInLeft || isFoundInRight)){
            mResult = root;
            return true;
        }
        // 2. q and p exists in left and right branch
        if(isFoundInRight && isFoundInLeft){
            mResult = root;
            return true;
        }
        // 3. miss the target, return the current branch condition
        return isFoundInLeft || isFoundInRight || (root.val == p || root.val == q);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
