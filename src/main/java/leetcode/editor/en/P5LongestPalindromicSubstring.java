//Given a string s, find the longest palindromic substring in s. You may assume 
//that the maximum length of s is 1000. 
//
// Example 1: 
//
// 
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: "cbbd"
//Output: "bb"
// 
// Related Topics String Dynamic Programming

package leetcode.editor.en;

//Java：Longest Palindromic Substring

public class P5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            /**
             * 思路：中心扩展算法，回文中心的两侧互为镜像。因此可以每次循环选择一个中心，进行左右扩展，判断左右字符是否相等。
             * 一共有 2n−1 个这样的中心(n个数，n-1个间隔)
             */
            if (s == null || s.length() < 1) {
                return "";
            }
            int start = 0;// 记录最大回文子串的坐标
            int end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expandAroundCenter(s, i, i); // i为中心
                int len2 = expandAroundCenter(s, i, i + 1); // i,i+1的间隙为中心
                int len = Math.max(len1, len2); // 二者取最大，用来和之前的最大回文子串坐标比较
                if (len > end - start) {
                    // 向左和向右都移动n/2步，根据奇偶两种情况提出来如下的公式
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        private int expandAroundCenter(String s, int left, int right) {
            int l = left, r = right;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                // 向中心的两侧拓展
                l--;
                r++;
            }
            return r - l - 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}