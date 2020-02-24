//Given a linked list and a value x, partition it such that all nodes less than 
//x come before nodes greater than or equal to x. 
//
// You should preserve the original relative order of the nodes in each of the t
//wo partitions. 
//
// Example: 
//
// 
//Input: head = 1->4->3->2->5->2, x = 3
//Output: 1->2->2->4->3->5
// 
// Related Topics Linked List Two Pointers

package leetcode.editor.en;

//Java：Partition List

public class P86PartitionList {
    public static void main(String[] args) {
        Solution solution = new P86PartitionList().new Solution();
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
        public ListNode partition(ListNode head, int x) {
            /**
             * 思路：定义两个头节点，分别用来挂接less和more
             * 最后将两个链表串起来，注意需要处理尾节点
             */
            if (head == null || head.next == null) {
                return head;
            }
            ListNode more = new ListNode(-1);
            ListNode moreHead = more;
            ListNode less = new ListNode(-1);
            ListNode lessHead = less;

            while (head != null) {
                if (head.val < x) {
                    less.next = head;
                    less = less.next;
                } else {
                    more.next = head;
                    more = more.next;
                }
                head = head.next;
            }
            // 尾节点一定要设置null
            more.next = null;
            less.next = moreHead.next;
            return lessHead.next;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}