//Given a binary search tree (BST), find the lowest common ancestor (LCA) of two
// given nodes in the BST. 
//
// According to the definition of LCA on Wikipedia: “The lowest common ancestor 
//is defined between two nodes p and q as the lowest node in T that has both p and
// q as descendants (where we allow a node to be a descendant of itself).” 
//
// Given binary search tree: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// Example 1: 
//
// 
//Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//Output: 6
//Explanation: The LCA of nodes 2 and 8 is 6.
// 
//
// Example 2: 
//
// 
//Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//Output: 2
//Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant o
//f itself according to the LCA definition.
// 
//
// 
//
// Note: 
//
// 
// All of the nodes' values will be unique. 
// p and q are different and both values will exist in the BST. 
// 
// Related Topics Tree

package leetcode.editor.en;

//Java：Lowest Common Ancestor of a Binary Search Tree

public class P235LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P235LowestCommonAncestorOfABinarySearchTree().new Solution();
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
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            /**
             * 思路：此题也可以像P236那样寻找，但是因为是二叉搜索树，就可以利用其特性
             * 二叉搜索树的左子树全小于根节点，右子树全大于根节点
             * 因此，递归时，
             * 如果p，q全在左子树、或者全在右子树上，那么在子树上重复1的操作
             * 如果不满足上面情况，那么该节点就是公共祖先
             */
            if (root == null) {
                return null;
            }
            if (root.val < p.val && root.val < q.val) { // 继续递归右子树
                return lowestCommonAncestor(root.right, p, q);
            } else if (root.val > p.val && root.val > q.val) { // 继续递归左子树
                return lowestCommonAncestor(root.left, p, q);
            } else {
                return root;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}