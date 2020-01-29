//Write a function that reverses a string. The input string is given as an array
// of characters char[]. 
//
// Do not allocate extra space for another array, you must do this by modifying 
//the input array in-place with O(1) extra memory. 
//
// You may assume all the characters consist of printable ascii characters. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]
// 
//
// 
// Example 2: 
//
// 
//Input: ["H","a","n","n","a","h"]
//Output: ["h","a","n","n","a","H"]
// 
// 
// Related Topics Two Pointers String

package leetcode.editor.en;

//Java：Reverse String

public class P344ReverseString {
    public static void main(String[] args) {
        Solution solution = new P344ReverseString().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            /**
             * 思路：使用双指针，交换两个指针指向的元素，并向中间移动，直到两个指针相遇
             */
            if (s == null) {
                return;
            }
            int low = 0;
            int high = s.length - 1;
            while (low < high) {
                char tmp = s[low];
                s[low] = s[high];
                s[high] = tmp;
                low++;
                high--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}