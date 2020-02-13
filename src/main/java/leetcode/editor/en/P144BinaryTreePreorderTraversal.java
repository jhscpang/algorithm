//Given a binary tree, return the preorder traversal of its nodes' values. 
//
// Example: 
//
// 
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,2,3]
// 
//
// Follow up: Recursive solution is trivial, could you do it iteratively? 
// Related Topics Stack Tree

package leetcode.editor.en;

//Java：Binary Tree Preorder Traversal

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P144BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P144BinaryTreePreorderTraversal().new Solution();
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

        public List<Integer> preorderTraversal(TreeNode root) {
            /**
             * 思路：递归版很简单，这里记录非递归版
             */
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            while (curr != null || !stack.isEmpty()) { // 条件是节点没走到底 或者 栈不为空
                while (curr != null) { // 满足节点没走到底时，一直往左走，把根存入栈
                    res.add(curr.val); // 入栈前访问
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop(); // 弹出
                curr = curr.right; // 转向右侧
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}