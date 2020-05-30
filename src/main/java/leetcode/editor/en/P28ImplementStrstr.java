//Implement strStr(). 
//
// Return the index of the first occurrence of needle in haystack, or -1 if need
//le is not part of haystack. 
//
// Example 1: 
//
// 
//Input: haystack = "hello", needle = "ll"
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: haystack = "aaaaa", needle = "bba"
//Output: -1
// 
//
// Clarification: 
//
// What should we return when needle is an empty string? This is a great questio
//n to ask during an interview. 
//
// For the purpose of this problem, we will return 0 when needle is an empty str
//ing. This is consistent to C's strstr() and Java's indexOf(). 
// Related Topics Two Pointers String

package leetcode.editor.en;

//Java：Implement strStr()
public class P28ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new P28ImplementStrstr().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            /**
             * 思路：使用双指针，当找到第一个相同字符时，同步向后走，
             * 如果完全匹配，则结束，否则，回退到第一个相同字符的下一个位置
             * 然后重复上面过程
             */
            int needelLen = needle.length();
            int haystackLen = haystack.length();
            if (needelLen == 0) {
                return 0;
            }

            int pn = 0;
            while (pn < haystackLen - needelLen + 1) {
                // 找第一个相同的字符位置
                while (pn < haystackLen - needelLen + 1 && haystack.charAt(pn) != needle.charAt(0)) {
                    pn++;
                }

                // 双指针同步往后走
                int currLen = 0, pL = 0;
                while (pL < needelLen && pn < haystackLen && haystack.charAt(pn) == needle.charAt(pL)) {
                    pn++;
                    pL++;
                    currLen++;
                }

                // 如果完全匹配，返回初始位置
                if (currLen == needelLen) {
                    return pn - needelLen;
                } else { // 否则，回退到第一个相同字符的下一个位置
                    pn = pn - currLen + 1;
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
