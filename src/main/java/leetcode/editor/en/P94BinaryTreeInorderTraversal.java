//Given a binary tree, return the inorder traversal of its nodes' values. 
//
// Example: 
//
// 
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,3,2] 
//
// Follow up: Recursive solution is trivial, could you do it iteratively? 
// Related Topics Hash Table Stack Tree

package leetcode.editor.en;

//Java：Binary Tree Inorder Traversal

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P94BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();
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
        List<Integer> res = new ArrayList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            /**
             * 思路：基于递归的很简单，基于循环的需要特别记一下
             */
            //            if (root != null) {
            //                inorderTraversal(root.left);
            //                res.add(root.val);
            //                inorderTraversal(root.right);
            //            }
            //            return res;
            /**
             * 非递归实现
             */
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            while (curr != null || !stack.isEmpty()) { // 条件是节点没走到底 或者 栈不为空
                while (curr != null) { // 满足节点没走到底时，一直往左走，把根存入栈
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop(); // 弹出
                res.add(curr.val); // 访问
                curr = curr.right; // 转向右侧
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}