//Write a function to find the longest common prefix string amongst an array of 
//strings. 
//
// If there is no common prefix, return an empty string "". 
//
// Example 1: 
//
// 
//Input: ["flower","flow","flight"]
//Output: "fl"
// 
//
// Example 2: 
//
// 
//Input: ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
// 
//
// Note: 
//
// All given inputs are in lowercase letters a-z. 
// Related Topics String

package leetcode.editor.en;

//Java：Longest Common Prefix

public class P14LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            /**
             * 思路：此题有很多在解法，有水平对比，垂直对比等
             * 但是我觉得这个二分法用的比较好，下面记录这个机遇二分法的解法
             */
            if (strs == null || strs.length == 0) {
                return "";
            }

            int minLen = Integer.MAX_VALUE;
            // 所有字符串中取最短的长度，在这个最短的长度中用二分法
            for (String str : strs) {
                minLen = Math.min(minLen, str.length());
            }
            int low = 1; // substring是左闭右开，因此这里从1而不是0开始
            int high = minLen;
            //
            while (low <= high) {
                int middle = (low + (high - low) / 2);
                if (isCommonPrefix(strs, middle)) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            }
            return strs[0].substring(0, (high + low) / 2);
        }

        private boolean isCommonPrefix(String[] strs, int len) {
            String str1 = strs[0].substring(0, len);
            for (int i = 1; i < strs.length; i++) {
                if (!strs[i].startsWith(str1)) {
                    return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}