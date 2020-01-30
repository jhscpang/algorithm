//Write a program to find the node at which the intersection of two singly linke
//d lists begins. 
//
// For example, the following two linked lists: 
//
//
// begin to intersect at node c1. 
//
// 
//
// Example 1: 
//
//
// 
//Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2
//, skipB = 3
//Output: Reference of the node with value = 8
//Input Explanation: The intersected node's value is 8 (note that this must not 
//be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. F
//rom the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the inter
//sected node in A; There are 3 nodes before the intersected node in B. 
//
// 
//
// Example 2: 
//
//
// 
//Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skip
//B = 1
//Output: Reference of the node with value = 2
//Input Explanation: The intersected node's value is 2 (note that this must not 
//be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. F
//rom the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected
// node in A; There are 1 node before the intersected node in B.
// 
//
// 
//
// Example 3: 
//
//
// 
//Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//Output: null
//Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B
//, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 
//0, while skipA and skipB can be arbitrary values.
//Explanation: The two lists do not intersect, so return null.
// 
//
// 
//
// Notes: 
//
// 
// If the two linked lists have no intersection at all, return null. 
// The linked lists must retain their original structure after the function retu
//rns. 
// You may assume there are no cycles anywhere in the entire linked structure. 
// Your code should preferably run in O(n) time and use only O(1) memory. 
// 
// Related Topics Linked List

package leetcode.editor.en;

//Java：Intersection of Two Linked Lists

public class P160IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        Solution solution = new P160IntersectionOfTwoLinkedLists().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            /**
             * 思路：
             * 解法一：常规思路是先遍历两个链表并记录长度，然后将长的链表先走几步，在长度相同的位置同时往后走
             * 解法二：在解法一基础上，还可以更巧妙一些，把两个链表看做一个整体，这样两个链表是同长度的，
             * 所以如果有交点，则会在交点处相遇，如果没有交点，则会在结尾处相遇
             */
            // 以下是解法二
            if (headA == null || headB == null) {
                return null;
            }
            ListNode pa = headA;
            ListNode pb = headB;
            while (pa != pb) {
                pa = pa == null ? headB : pa.next; // pa和pb在走到自己链表尾部后，再从另一条头部走一遍，相当于将两个链表做一个整体
                pb = pb == null ? headA : pb.next;
            }
            return pa;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}