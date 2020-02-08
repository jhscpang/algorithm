//Given a linked list, remove the n-th node from the end of list and return its 
//head. 
//
// Example: 
//
// 
//Given linked list: 1->2->3->4->5, and n = 2.
//
//After removing the second node from the end, the linked list becomes 1->2->3->
//5.
// 
//
// Note: 
//
// Given n will always be valid. 
//
// Follow up: 
//
// Could you do this in one pass? 
// Related Topics Linked List Two Pointers

package leetcode.editor.en;

//Java：Remove Nth Node From End of List

public class P19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            /**
             * 思路：题目提到n是有效的，因此可以不考虑n超过链表长度的情况，否则需要考虑
             * 题目要求一次遍历，因此你定义两个指针，相距n步之后同时向后移动，当先走的指针到达尾节点时，
             * 后走的指针到达要删除节点的前一个节点，此时删除节点。
             */
            ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode start = pre;
            ListNode end = pre;
            while (n != 0) { // 第一个指针先走n步
                start = start.next;
                n--;
            }
            while (start.next != null) { // 两个指针同时向后走，直到第一个指针到达尾节点
                start = start.next;
                end = end.next;
            }
            end.next = end.next.next; // 删除节点
            return pre.next; // 这里不能直接返回head，因此被删除的可能是head
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}