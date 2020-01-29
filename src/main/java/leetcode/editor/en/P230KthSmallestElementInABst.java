//Given a binary search tree, write a function kthSmallest to find the kth small
//est element in it. 
//
// Note: 
//You may assume k is always valid, 1 ≤ k ≤ BST's total elements. 
//
// Example 1: 
//
// 
//Input: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//Output: 1 
//
// Example 2: 
//
// 
//Input: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//Output: 3
// 
//
// Follow up: 
//What if the BST is modified (insert/delete operations) often and you need to f
//ind the kth smallest frequently? How would you optimize the kthSmallest routine?
// 
// Related Topics Binary Search Tree

package leetcode.editor.en;

//Java：Kth Smallest Element in a BST

import java.util.ArrayList;
import java.util.List;

public class P230KthSmallestElementInABst {
    public static void main(String[] args) {
        Solution solution = new P230KthSmallestElementInABst().new Solution();
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
        public int kthSmallest(TreeNode root, int k) {
            /**
             * 思路：利用二叉搜索树的特性，二叉搜索树的中序遍历就是从小到大的
             * 因此利用中序遍历构建链表，然后取第k个元素
             */
            List<Integer> list = new ArrayList<>();
            inOrder(root, list);
            return list.get(k - 1); // 链表脚本从0开始
        }

        private void inOrder(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}