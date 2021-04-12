//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 374 👎 0


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
    public List<Integer> rightSideView(TreeNode root) {
        /**
        // Solution 1: DFS + recursion
        List<Integer> result = new ArrayList<Integer>();
        DFS(result, root, 0);
        return result;
        **/

        // Solution2: BFS + iteration
        // sort node by level, so keep the last node in each level
        return BFS(root);
    }

    public List<Integer> BFS(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }

        queue.offer(root);
        while(!queue.isEmpty()){
            // peek the rightest node of this level
            TreeNode rightestNode = queue.getLast();
            result.add(rightestNode.val);

            // generate the next level queue
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++){
                TreeNode current = queue.poll();
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }
        }
        return result;
    }

    /*
     Here I use pre-order to go through tree, which looks like: root --> leftChild --> rightChild.
     If I change order into: root --> rightChild --> leftChild, then List.set() can be ignored. Because
     the rightest node in every level comes first but not last. list can be add like this:
     if(depth == list.size()){
        list.add(current.val);
     }
    */
    public void DFS(List<Integer> list, TreeNode current, int depth){
        if(current == null){
            return;
        }
        // like pre-order, because list's elements order by depth
        list.set(depth, current.val);    // override in the same depth from left to right

        DFS(list, current.left, depth + 1);
        DFS(list, current.right, depth + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
