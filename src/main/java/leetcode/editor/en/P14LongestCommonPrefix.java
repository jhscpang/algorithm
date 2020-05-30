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
             * 思路：此题有很多在解法，有水平对比，垂直对比，二分法等
             * 下面记录最好理解的垂直查找法
             */
            if (strs == null || strs.length == 0) {
                return "";
            }
            for (int i = 0; i < strs[0].length(); i++) {
                char c = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (i == strs[j].length() || strs[j].charAt(i) != c) {
                        return strs[0].substring(0, i);
                    }
                }
            }
            return strs[0];
        }
        //leetcode submit region end(Prohibit modification and deletion)

    }
}