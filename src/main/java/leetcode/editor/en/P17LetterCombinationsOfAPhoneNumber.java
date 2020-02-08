//Given a string containing digits from 2-9 inclusive, return all possible lette
//r combinations that the number could represent. 
//
// A mapping of digit to letters (just like on the telephone buttons) is given b
//elow. Note that 1 does not map to any letters. 
//
// 
//
// Example: 
//
// 
//Input: "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// Note: 
//
// Although the above answer is in lexicographical order, your answer could be i
//n any order you want. 
// Related Topics String Backtracking

package leetcode.editor.en;

//Java：Letter Combinations of a Phone Number

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Character, String> phone = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        List<String> result = new ArrayList<String>();

        public List<String> letterCombinations(String digits) {
            /**
             * 思路：排列组合题，因此利用回溯法
             */
            if (digits == null || digits.length() == 0) {
                return result;
            }
            backtrace(0, digits, new StringBuilder());
            return result;
        }

        private void backtrace(int index, String digits, StringBuilder sb) {
            // 递归结束条件
            if (sb.length() == digits.length()) {
                result.add(sb.toString());
                sb = new StringBuilder();
                return;
            }

            char digit = digits.charAt(index);   // 获取第index位数字
            String letters = phone.get(digit);  // 获取第index位数字对应的各个字母
            for (int i = 0; i < letters.length(); i++) {
                sb.append(letters.charAt(i));  // 选择第i个字母
                backtrace(index + 1, digits, sb);
                sb.deleteCharAt(sb.length() - 1);// 撤销第i个字母
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}