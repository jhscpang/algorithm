//Given preorder and inorder traversal of a tree, construct the binary tree. 
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics Array Tree Depth-first Search


package leetcode.editor.en;

//Java：Construct Binary Tree from Preorder and Inorder Traversal

public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        // 边界检查
        if (inStart > inEnd || preStart > preorder.length - 1) {
            return null;
        }
        // 先序遍历的第一个节点是根节点
        TreeNode root = new TreeNode(preorder[preStart]);
        // 在中序遍历里找到根节点，然后根节点左边就是左子树，右边就是右子树
        int inIndex = 0; // 记录中序遍历中root的位置
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }
        // 左右子树递归同样的操作，主要是确定左右子树的位置
        root.left = buildTree(preorder, inorder, preStart + 1, inStart, inIndex - 1);
        root.right = buildTree(preorder, inorder, preStart + (inIndex - inStart + 1), inIndex + 1, inEnd);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}