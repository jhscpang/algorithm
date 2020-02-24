//Given a binary tree, find its minimum depth. 
//
// The minimum depth is the number of nodes along the shortest path from the roo
//t node down to the nearest leaf node. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// Given binary tree [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// return its minimum depth = 2. 
// Related Topics Tree Depth-first Search Breadth-first Search

package leetcode.editor.en;

//Java：Minimum Depth of Binary Tree

public class P111MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P111MinimumDepthOfBinaryTree().new Solution();
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
        public int minDepth(TreeNode root) {
            /**
             * 思路：使用递归，分别统计左右子树的高度，取小的
             */
            if (root == null) {
                return 0;
            }
            return countHeight(root, 1);

        }

        private int countHeight(TreeNode root, int height) {
            if (root == null) {
                return height;
            }
            if (root.left == null && root.right != null) {
                return countHeight(root.right, height + 1);
            } else if (root.left != null && root.right == null) {
                return countHeight(root.left, height + 1);
            } else if (root.left == null && root.right == null) {
                return height;
            }
            int leftHeight = countHeight(root.left, height + 1);
            int rightHeight = countHeight(root.right, height + 1);
            return leftHeight < rightHeight ? leftHeight : rightHeight;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}