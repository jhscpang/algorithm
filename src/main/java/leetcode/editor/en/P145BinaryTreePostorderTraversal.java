//Given a binary tree, return the postorder traversal of its nodes' values. 
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
//Output: [3,2,1]
// 
//
// Follow up: Recursive solution is trivial, could you do it iteratively? 
// Related Topics Stack Tree

package leetcode.editor.en;

//Java：Binary Tree Postorder Traversal

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P145BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P145BinaryTreePostorderTraversal().new Solution();
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

        public List<Integer> postorderTraversal(TreeNode root) {
            /**
             * 思路：递归版很简单，但非递归版有些难度，需要记录是否从右节点返回。
             * 1. 利用一个窍门，后序遍历是仿照层次遍历的倒序,https://leetcode-cn
             * .com/problems/binary-tree-postorder-traversal/solution/er-cha-shu-de-hou-xu-bian-li-by-leetcode/
             *
             */
            //            LinkedList<TreeNode> stack = new LinkedList<>();
            //            LinkedList<Integer> output = new LinkedList<>();
            //            if (root == null) {
            //                return output;
            //            }
            //            stack.add(root); // 跟节点先入栈
            //            while (!stack.isEmpty()) {
            //                TreeNode node = stack.pollLast(); // 弹出
            //                output.addFirst(node.val); // 注意这里，是加在链表的前面
            //                if (node.left != null) {
            //                    stack.add(node.left);
            //                }
            //                if (node.right != null) {
            //                    stack.add(node.right);
            //                }
            //            }
            //            return output;
            /**
             * 2. 下面再介绍一种比较常规的思路，记录最后访问的节点是不是右子树
             */
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            TreeNode last = null; // 记录最后访问节点
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) { // 满足节点没走到底时，一直往左走，把根存入栈
                    stack.push(cur);
                    cur = cur.left;
                }
                TreeNode temp = stack.peek();
                // 判断是否变到右子树
                if (temp.right != null && temp.right != last) { // 右子树不为空并且没有访问过时，转向右子树
                    cur = temp.right;
                } else {
                    list.add(temp.val); // 访问
                    last = temp; // 记录最后访问的节点
                    stack.pop(); // 实际弹出
                }
            }
            return list;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}