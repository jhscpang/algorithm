//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order and each of their nodes contain a sing
//le digit. Add the two numbers and return it as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// Example: 
//
// 
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.
// 
// Related Topics Linked List Math

package leetcode.editor.en;

//Java：Add Two Numbers

public class P2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new P2AddTwoNumbers().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            /**
             * 思路：类似于笔算加法，记录进位
             */
            int carry = 0;
            ListNode head1 = l1;
            ListNode head2 = l2;
            ListNode dummyHead = new ListNode(0);
            ListNode current = dummyHead;
            while (head1 != null || head2 != null) {
                // 位上有值就取当前值，没值的话取0
                int x = head1 == null ? 0 : head1.val;
                int y = head2 == null ? 0 : head2.val;
                int tmpRet = x + y + carry;
                // 计算进位和余位
                int val = tmpRet % 10;
                carry = tmpRet / 10;
                current.next = new ListNode(val);
                current = current.next;
                if (head1 != null) {
                    head1 = head1.next;
                }
                if (head2 != null) {
                    head2 = head2.next;
                }
            }
            // 如何最后还有进位，则还需进一位
            if (carry > 0) {
                current.next = new ListNode(carry);
            }
            return dummyHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}