//Write a function to delete a node (except the tail) in a singly linked list, g
//iven only access to that node. 
//
// Given linked list -- head = [4,5,1,9], which looks like following: 
//
// 
//
// 
//
// Example 1: 
//
// 
//Input: head = [4,5,1,9], node = 5
//Output: [4,1,9]
//Explanation: You are given the second node with value 5, the linked list shoul
//d become 4 -> 1 -> 9 after calling your function.
// 
//
// Example 2: 
//
// 
//Input: head = [4,5,1,9], node = 1
//Output: [4,5,9]
//Explanation: You are given the third node with value 1, the linked list should
// become 4 -> 5 -> 9 after calling your function.
// 
//
// 
//
// Note: 
//
// 
// The linked list will have at least two elements. 
// All of the nodes' values will be unique. 
// The given node will not be the tail and it will always be a valid node of the
// linked list. 
// Do not return anything from your function. 
// 
// Related Topics Linked List

package leetcode.editor.en;

//Java：Delete Node in a Linked List

public class P237DeleteNodeInALinkedList {
    public static void main(String[] args) {
        Solution solution = new P237DeleteNodeInALinkedList().new Solution();
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
        public void deleteNode(ListNode node) {
            /**
             * 思路：题目说被删除的不是未节点，因此可以与下一个节点交换，将自己覆盖
             */
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}