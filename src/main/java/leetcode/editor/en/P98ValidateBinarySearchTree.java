//Given a binary tree, determine if it is a valid binary search tree (BST). 
//
// Assume a BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the node's
// key. 
// The right subtree of a node contains only nodes with keys greater than the no
//de's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
//
// Example 1: 
//
// 
//    2
//   / \
//  1   3
//
//Input: [2,1,3]
//Output: true
// 
//
// Example 2: 
//
// 
//    5
//   / \
//  1   4
//     / \
//    3   6
//
//Input: [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
// Related Topics Tree Depth-first Search

package leetcode.editor.en;

//Java：Validate Binary Search Tree

import java.util.Stack;

public class P98ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P98ValidateBinarySearchTree().new Solution();
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
        public boolean isValidBST(TreeNode root) {
            /**
             * 思路：先考虑二叉搜索树的特性，然后发现二叉搜索树使用左->根->右的中序遍历，应该是递增有序的
             * 因此可以通过中序遍历比较是否是递增的来进行判断。此外，使用一个变量记录上一个元素即可，不需要保存整个序列
             * 使用中序遍历的非递归形式
             */
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            long before = Long.MIN_VALUE;
            while (curr != null || !stack.isEmpty()) { // 条件是节点没走到底 或者 栈不为空
                while (curr != null) { // 满足节点没走到底时，一直往左走，把根存入栈
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop(); // 弹出
                if (curr.val <= before) { // 与前一个元素比较，如果不递增则说明不是二叉搜索树
                    return false;
                }
                before = curr.val;
                curr = curr.right; // 转向右侧
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}