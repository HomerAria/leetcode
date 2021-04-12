//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 870 👎 0


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

    public boolean isValidBST(TreeNode root) {
        // Solution 1: recursion
//         return DFS(root, Long.MIN_VALUE, Long.MAX_VALUE);

        // Solution 2: iteration with in-order
//         return iteration(root);

        // Solution 3: recursion with in-order
        // the current root goes from left to root to right. If tree is valid,
        // this root.val should always keep increasing.
        return DFSInOrder(root);
    }

    long currentMax = Long.MIN_VALUE;

    boolean DFSInOrder(TreeNode root){
        // GUI
        if(root == null){
            return true;
        }

        // DI, in-order
        boolean leftIsValid = DFSInOrder(root.left);
        if(!leftIsValid) return false;
        // whether the value of current node keeps increasing.
        if(root.val > currentMax){
            currentMax = root.val;
        }else{
            return false;
        }
        boolean rightIsValid = DFSInOrder(root.right);
        if(!rightIsValid) return false;

        return true;
    }

    private boolean iteration(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        long currentMax = Long.MIN_VALUE;

        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();

            if(current != null){
                // PART 1: go to the leftest node
                if(current.right != null) stack.push(current.right);    //right

                stack.push(current);     //middle
                stack.push(null);

                if(current.left != null) stack.push(current.left);  //left
            }else{
                // PART 2: leftest arrived, and run towards right
                // During the procedure toward right, currentTemp's value keep becoming bigger
                TreeNode currentTemp = stack.pop();
                if(currentTemp.val > currentMax){
                    currentMax = currentTemp.val;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    // Recursion
    private boolean DFS(TreeNode root, long lowerLimit, long upperLimit){
        // end condition
        if(root == null){
            return true;
        }

        if(root.val <= lowerLimit || root.val >= upperLimit){
            return false;
        }

        // go deeper
        boolean leftResult = DFS(root.left, lowerLimit, root.val);
        boolean rightResult = DFS(root.right, root.val, upperLimit);
        return leftResult && rightResult;
    }

    // Traversal in-order, a valid BST should always increase.
}
//leetcode submit region end(Prohibit modification and deletion)
