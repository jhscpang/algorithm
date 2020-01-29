//Given a string, you need to reverse the order of characters in each word withi
//n a sentence while still preserving whitespace and initial word order. 
//
// Example 1: 
// 
//Input: "Let's take LeetCode contest"
//Output: "s'teL ekat edoCteeL tsetnoc"
// 
// 
//
// Note:
//In the string, each word is separated by single space and there will not be an
//y extra space in the string.
// Related Topics String

package leetcode.editor.en;

//Java：Reverse Words in a String III

public class P557ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new P557ReverseWordsInAStringIii().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            /**
             * 思路：将字符串按空格分隔，对每个子字符串进行反转，然后再用空格拼回来
             */
            String words[] = s.split(" ");
            StringBuilder res = new StringBuilder();
            for (String word : words) {
                res.append(new StringBuffer(word).reverse().toString())
                        .append(" ");
            }
            return res.toString().trim();

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}