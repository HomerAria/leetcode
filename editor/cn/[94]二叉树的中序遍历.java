//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 797 👎 0


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
    public List<Integer> inorderTraversal(TreeNode root) {
        /**
        // Solution 1: recursion
        List<Integer> result = new ArrayList<Integer>();
        inorder(result, root);
        return result;
        **/

        // Solution 2: iteration
        // In DFS, you need data structure: Stack(implement by LinkedList with interface Deque)
        return iteration(root);
    }

    public List<Integer> iteration(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        if(root == null){
            return result;
        }

        stack.push(root);
        while(!stack.isEmpty()){
            // get the reference pointer, which is the node at the top of stack
            TreeNode current = stack.pop();

            // Following two parts:
            // Part 1: construct the stack orderly
            // part 2: pop the right node and put node's value into list
            // The critical point of two part is to put a null-node into stack
            if(current != null){
                // part 1: this node might have sub-node
                // left-->current-->right
                if(current.right != null) stack.push(current.right);    // right

                stack.push(current);    // current
                stack.push(null);

                if(current.left != null) stack.push(current.left);     // left
            } else{
                // part2: this node won't have sub-node
                TreeNode trueCurrent = stack.pop();
                result.add(trueCurrent.val);
            }
        }
        return result;
    }

    public void inorder(List<Integer> list, TreeNode root){
        if(root == null){
            return;
        }
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
