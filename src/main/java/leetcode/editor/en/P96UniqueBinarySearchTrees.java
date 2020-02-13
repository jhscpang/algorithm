//Given n, how many structurally unique BST's (binary search trees) that store v
//alues 1 ... n? 
//
// Example: 
//
// 
//Input: 3
//Output: 5
//Explanation:
//Given n = 3, there are a total of 5 unique BST's:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
// Related Topics Dynamic Programming Tree

package leetcode.editor.en;

//Java：Unique Binary Search Trees

public class P96UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new P96UniqueBinarySearchTrees().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            /**
             * 思路：动态规划题，最重点是推到公式，然后从下到上运算，最终得到结果
             */
            int[] G = new int[n + 1];
            G[0] = 1;
            G[1] = 1;

            for (int i = 2; i <= n; ++i) { // 外层控制从低到高依次求G(i)
                for (int j = 1; j <= i; ++j) { // 内层利用之前求好的G(i-1)，G(i-2)等做公式计算
                    G[i] += G[j - 1] * G[i - j];
                }
            }

            return G[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}