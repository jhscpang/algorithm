//Given two strings s and t, determine if they are isomorphic. 
//
// Two strings are isomorphic if the characters in s can be replaced to get t. 
//
// All occurrences of a character must be replaced with another character while 
//preserving the order of characters. No two characters may map to the same charac
//ter but a character may map to itself. 
//
// Example 1: 
//
// 
//Input: s = "egg", t = "add"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "foo", t = "bar"
//Output: false 
//
// Example 3: 
//
// 
//Input: s = "paper", t = "title"
//Output: true 
//
// Note: 
//You may assume both s and t have the same length. 
// Related Topics Hash Table

package leetcode.editor.en;

//Java：Isomorphic Strings

public class P205IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new P205IsomorphicStrings().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            /**
             * 思路：
             * 解法1:双hashMap，依次对比
             */
            // Map<Character, Integer> map1 = new HashMap<>();
            // Map<Character, Integer> map2 = new HashMap<>();
            // for (int i = 0; i < s.length(); i++) {
            //     char ch1 = s.charAt(i);
            //     char ch2 = t.charAt(i);
            //     if (!map1.getOrDefault(ch1, -1).equals(map2.getOrDefault(ch2, -1))) {
            //         return false;
            //     }
            //     map1.put(ch1, i);
            //     map2.put(ch2, i);
            // }
            // return true;

            // 解法2:一个非常巧妙的解法
            char[] ss = s.toCharArray();
            char[] tt = t.toCharArray();

            int length = ss.length;
            if (length != tt.length) {
                return false;
            }

            char[] sm = new char[256];
            char[] tm = new char[256];

            for (int i = 0; i < length; i++) {
                char sc = ss[i];
                char tc = tt[i];
                if (sm[sc] == 0 && tm[tc] == 0) {
                    sm[sc] = tc;
                    tm[tc] = sc;
                } else {
                    if (sm[sc] != tc || tm[tc] != sc) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}