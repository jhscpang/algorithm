//Invert a binary tree. 
//
// Example: 
//
// Input: 
//
// 
//     4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// Output: 
//
// 
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// Trivia: 
//This problem was inspired by this original tweet by Max Howell: 
//
// Google: 90% of our engineers use the software you wrote (Homebrew), but you c
//an’t invert a binary tree on a whiteboard so f*** off. 
// Related Topics Tree

package leetcode.editor.en;

//Java：Invert Binary Tree

import java.util.LinkedList;
import java.util.Queue;

public class P226InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P226InvertBinaryTree().new Solution();
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
        public TreeNode invertTree(TreeNode root) {
            //递归解法
            // if(root != null) {
            //     TreeNode temp = root.left;
            //     root.left = root.right;
            //     root.right = temp;
            //     invertTree(root.left);
            //     invertTree(root.right);
            // }
            // return root;

            //迭代解法
            if (root == null) {
                return null;
            }
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode current = queue.poll();
                TreeNode temp = current.left;
                current.left = current.right;
                current.right = temp;
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}