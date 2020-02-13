//Given a binary tree, flatten it to a linked list in-place. 
//
// For example, given the following tree: 
//
// 
//    1
//   / \
//  2   5
// / \   \
//3   4   6
// 
//
// The flattened tree should look like: 
//
// 
//1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6
// 
// Related Topics Tree Depth-first Search

package leetcode.editor.en;

//Java：Flatten Binary Tree to Linked List

public class P114FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new P114FlattenBinaryTreeToLinkedList().new Solution();
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
        public void flatten(TreeNode root) {
            /**
             * 思路：将右子树挂在左子树最右节点的右侧
             * 然后将左子树作为根的新右子树
             * 将新右子树的作为根，重复上面的过程，重复过程可以使用迭代，也可以使用递归
             */
            if (root == null) {
                return;
            }
            TreeNode cur = root;
            while (cur != null) {
                if (cur.left != null) {
                    TreeNode pre = cur.left;
                    while (pre.right != null) { // 找左子树的最右节点
                        pre = pre.right;
                    }
                    pre.right = cur.right; // 将右子树挂在左子树最右节点的右侧
                    cur.right = cur.left; // 将左子树作为根的新右子树
                    cur.left = null;
                }
                cur = cur.right; // 将新右子树的作为根，重复上面的过程
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}