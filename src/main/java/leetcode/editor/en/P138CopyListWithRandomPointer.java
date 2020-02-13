//A linked list is given such that each node contains an additional random point
//er which could point to any node in the list or null. 
//
// Return a deep copy of the list. 
//
// The Linked List is represented in the input/output as a list of n nodes. Each
// node is represented as a pair of [val, random_index] where: 
//
// 
// val: an integer representing Node.val 
// random_index: the index of the node (range from 0 to n-1) where random pointe
//r points to, or null if it does not point to any node. 
// 
//
// 
// Example 1: 
//
// 
//Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// Example 2: 
//
// 
//Input: head = [[1,1],[2,1]]
//Output: [[1,1],[2,1]]
// 
//
// Example 3: 
//
// 
//
// 
//Input: head = [[3,null],[3,0],[3,null]]
//Output: [[3,null],[3,0],[3,null]]
// 
//
// Example 4: 
//
// 
//Input: head = []
//Output: []
//Explanation: Given linked list is empty (null pointer), so return null.
// 
//
// 
// Constraints: 
//
// 
// -10000 <= Node.val <= 10000 
// Node.random is null or pointing to a node in the linked list. 
// Number of Nodes will not exceed 1000. 
// 
// Related Topics Hash Table Linked List

package leetcode.editor.en;

//Java：Copy List with Random Pointer

public class P138CopyListWithRandomPointer {
    public static void main(String[] args) {
        Solution solution = new P138CopyListWithRandomPointer().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

    class Solution {
        public Node copyRandomList(Node head) {
            /**
             * 思路：
             * 第一步：先复制节点，把链表变成1->1'->2->2'->3->3'->null
             * 第二步：复制连接指针
             * 第三步：分离复制链表和源链表
             */
            if (head == null) {
                return null;
            }
            Node cur = head;
            Node next = null;
            // 1. 先复制节点, 然后放在右边
            while (cur != null) {
                next = cur.next;
                Node newNode = new Node(cur.val);
                newNode.next = cur.next;
                cur.next = newNode;
                cur = next;
            }
            // 2. 复制random指针
            cur = head;
            while (cur != null) {
                next = cur.next.next;
                cur.next.random = cur.random == null ? null : cur.random.next;
                cur = next;
            }
            // 3. 把复制链表和源链表分开
            cur = head;
            Node newHead = cur.next;
            Node copyCur = null;
            while (cur != null) {
                //record the next node
                next = cur.next.next;
                copyCur = cur.next;
                cur.next = next;
                copyCur.next = next == null ? null : next.next;
                cur = next;
            }
            return newHead;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}