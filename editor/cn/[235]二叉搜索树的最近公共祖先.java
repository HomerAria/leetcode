//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
// Related Topics 树 
// 👍 507 👎 0


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
    TreeNode mTarget;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Solution 1:
//         if(p.val < q.val){
//             return DFS(root, p, q);
//         }else{
//             return DFS(root, q, p);
//         }

        // Solution 2: pre-order, like binary search to find the right node
        DFS2(root, Math.min(p.val, q.val), Math.max(p.val, q.val));
        return mTarget;
    }

    /*
    When smallNode and biggerNode exist in root's left branch and right branch,
    This root is the target. To push depth, we use pre-order.
    */
    void DFS2(TreeNode root, int lower, int upper){
        // GUI
        if(root == null){
            return;
        }

        // DI
        if(root.val >= lower && root.val <= upper){
            // This condition means current root is the target value.
            mTarget = root;
        }else if(root.val > upper){
            // target must exist in the left branch
            DFS2(root.left, lower, upper);
        }else{
            // target must exist in the right branch
            DFS2(root.right, lower, upper);
        }
    }


    private TreeNode DFS(TreeNode current, TreeNode smallNode, TreeNode bigNode){
        // end condition
        if(current != null && current.val >= smallNode.val && current.val <= bigNode.val){
            return current;
        }

        // go deeper
        if(current.val < smallNode.val && current.right != null){
            return DFS(current.right, smallNode, bigNode);
        }
        if(current.val > bigNode.val && current.left != null){
            return DFS(current.left, smallNode, bigNode);
        }

        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
