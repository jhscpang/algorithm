//Given an integer n, generate all structurally unique BST's (binary search tree
//s) that store values 1 ... n. 
//
// Example: 
//
// 
//Input: 3
//Output:
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//Explanation:
//The above output corresponds to the 5 unique BST's shown below:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
// Related Topics Dynamic Programming Tree

package leetcode.editor.en;

//Java：Unique Binary Search Trees II

import java.util.LinkedList;
import java.util.List;

public class P95UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        Solution solution = new P95UniqueBinarySearchTreesIi().new Solution();
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
        public List<TreeNode> generateTrees(int n) {
            /**
             * 思路：基于P96题的推导公式，这里不再是计数，而是构建具体的树，建树需要递归，然后将左右节点和根节点挂接上
             *该题与P96的区别是，P96是自底向上的计算，而本题是自上而下的的递归运算
             */
            if (n == 0) {
                return new LinkedList<TreeNode>();
            }
            return generateTrees(1, n);
        }

        public LinkedList<TreeNode> generateTrees(int start, int end) {
            LinkedList<TreeNode> allTrees = new LinkedList<TreeNode>();
            // 递归结束条件
            if (start > end) {
                allTrees.add(null);
                return allTrees;
            }

            // 按个被选做根节点
            for (int i = start; i <= end; i++) {
                // 构建所有可能的左子树
                LinkedList<TreeNode> leftTrees = generateTrees(start, i - 1);
                // 构建所有可能的右子树
                LinkedList<TreeNode> rightTrees = generateTrees(i + 1, end);
                // 将左子树和右子树做笛卡尔积得到的左右子树对，挂接到根节点上
                for (TreeNode l : leftTrees) {
                    for (TreeNode r : rightTrees) {
                        TreeNode currentTree = new TreeNode(i);
                        currentTree.left = l;
                        currentTree.right = r;
                        allTrees.add(currentTree);
                    }
                }
            }
            return allTrees;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}