//Merge two sorted linked lists and return it as a new list. The new list should
// be made by splicing together the nodes of the first two lists. 
//
// Example:
// 
//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4
// 
// Related Topics Linked List

package leetcode.editor.en;

//Java：Merge Two Sorted Lists

public class P21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            /**
             * 思路：依次比较两个链表的节点，将较小的链到新链表上，最后把剩下的再全链到尾部
             */
            ListNode head = new ListNode(-1);
            ListNode tmp = head;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    tmp.next = l1;
                    l1 = l1.next;
                } else {
                    tmp.next = l2;
                    l2 = l2.next;
                }
                tmp = tmp.next;
            }
            // 如果有剩余的链，把剩余的全链到后面
            tmp.next = l1 == null ? l2 : l1;
            return head.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}