//Reverse a singly linked list. 
//
// Example: 
//
// 
//Input: 1->2->3->4->5->NULL
//Output: 5->4->3->2->1->NULL
// 
//
// Follow up: 
//
// A linked list can be reversed either iteratively or recursively. Could you im
//plement both? 
// Related Topics Linked List

package leetcode.editor.en;

//Java：Reverse Linked List

public class P206ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new P206ReverseLinkedList().new Solution();
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
        public ListNode reverseList(ListNode head) {
            /**
             * 思路：用一个next指针记录即将被处理的节点，
             * 同时需要一个pre指针记录前一个节点
             */
            ListNode pre = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}