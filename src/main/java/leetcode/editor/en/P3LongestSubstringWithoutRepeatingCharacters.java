//Given a string, find the length of the longest substring without repeating cha
//racters. 
//
// 
// Example 1: 
//
// 
//Input: "abcabcbb"
//Output: 3 
//Explanation: The answer is "abc", with the length of 3. 
// 
//
// 
// Example 2: 
//
// 
//Input: "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// 
// Example 3: 
//
// 
//Input: "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3. 
//             Note that the answer must be a substring, "pwke" is a subsequence
// and not a substring.
// 
// 
// 
// 
// Related Topics Hash Table Two Pointers String Sliding Window

package leetcode.editor.en;

//Java：Longest Substring Without Repeating Characters

import java.util.HashMap;
import java.util.Map;

public class P3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            /**
             * 思路：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong
             * -fu-zi-fu-de-zui-chang-zi-chuan-by-leetcod/
             * 方法1：使用滑动窗口，当不存在重复元素时，窗口右侧不断尝试扩大，当存在重复元素时，窗口左侧不断缩小，知道窗口内不再有重复元素
             */
            //            int n = s.length();
            //            Set<Character> set = new HashSet<>();
            //            int ans = 0, i = 0, j = 0;
            //            while (i < n && j < n) {
            //                // try to extend the range [i, j]
            //                if (!set.contains(s.charAt(j))) {
            //                    set.add(s.charAt(j++));
            //                    ans = Math.max(ans, j - i);
            //                } else {
            //                    set.remove(s.charAt(i++));
            //                }
            //            }
            //            return ans;
            /**
             * 方法2：使用优化的滑动窗口
             * 用i，j两个指针维护一个滑动窗口(i记录左边界，j记录右边界)，
             * j和i最大的差值就是最长的不重复子串
             * j指针从最左边遍历到最右边，在遍历过程中，用map记录元素最后出现的位置，当同样元素出现时，可以通过map找到该元素上次出现的位置，此位置与i进行比较，取大者作为左边界(赋值给i)
             * 如果 s[j] 在 [i,j) 范围内有与 j′ 重复的字符，我们不需要逐渐增加 i 。 我们可以直接跳过 [i，j′]范围内的所有元素，并将 i 变为 j′+1。
             */
            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>(); // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                if (map.containsKey(s.charAt(j))) {
                    // 发现存在与j相同元素时，将i置为j+1的位置，变成新的没有重复元素的窗口
                    i = Math.max(map.get(s.charAt(j)) + 1, i);
                }
                map.put(s.charAt(j), j);
                ans = Math.max(ans, j - i + 1);

            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}