//Given a binary tree, find the lowest common ancestor (LCA) of two given nodes 
//in the tree. 
//
// According to the definition of LCA on Wikipedia: “The lowest common ancestor 
//is defined between two nodes p and q as the lowest node in T that has both p and
// q as descendants (where we allow a node to be a descendant of itself).” 
//
// Given the following binary tree: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// Example 1: 
//
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//Output: 3
//Explanation: The LCA of nodes 5 and 1 is 3.
// 
//
// Example 2: 
//
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//Output: 5
//Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant o
//f itself according to the LCA definition.
// 
//
// 
//
// Note: 
//
// 
// All of the nodes' values will be unique. 
// p and q are different and both values will exist in the binary tree. 
// 
// Related Topics Tree

package leetcode.editor.en;

//Java：Lowest Common Ancestor of a Binary Tree

public class P236LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new P236LowestCommonAncestorOfABinaryTree().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        private TreeNode target = null; // 记录结果

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            /**
             * 思路：分三种情况：
             * 1. 一个节点的左右子树都找到值，那么该节点就是公共祖先
             * 2. 左子树找到值，当前值等于另一个，那么当前值就是公共祖先
             * 3。右子树找到值，当前值等于另一个，那么当前值就是公共祖先
             * 定义三个变量分别代表左右子树和当前值的情况，与上面三种情况做对比
             */
            recurseTree(root, p, q);
            return target;
        }

        private boolean recurseTree(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return false;
            }
            int left = recurseTree(root.left, p, q) ? 1 : 0; // 递归左子树
            int right = recurseTree(root.right, p, q) ? 1 : 0; // 递归右子树
            int mid = (root.val == p.val || root.val == q.val) ? 1 : 0; // 当前值
            if (left + right + mid == 2) { // 找到目标结果的情况
                this.target = root;
            }
            // 范围本次递归结果
            return (left + right + mid) > 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}