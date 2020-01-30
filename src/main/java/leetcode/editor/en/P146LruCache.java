//Design and implement a data structure for Least Recently Used (LRU) cache. It 
//should support the following operations: get and put. 
//
// get(key) - Get the value (will always be positive) of the key if the key exis
//ts in the cache, otherwise return -1. 
//put(key, value) - Set or insert the value if the key is not already present. W
//hen the cache reached its capacity, it should invalidate the least recently used
// item before inserting a new item. 
//
// The cache is initialized with a positive capacity. 
//
// Follow up: 
//Could you do both operations in O(1) time complexity? 
//
// Example: 
//
// 
//LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // returns 1
//cache.put(3, 3);    // evicts key 2
//cache.get(2);       // returns -1 (not found)
//cache.put(4, 4);    // evicts key 1
//cache.get(1);       // returns -1 (not found)
//cache.get(3);       // returns 3
//cache.get(4);       // returns 4
// 
//
// 
// Related Topics Design

package leetcode.editor.en;

//Java：LRU Cache

import java.util.HashMap;

public class P146LruCache {
    public static void main(String[] args) {
        LRUCache solution = new P146LruCache().new LRUCache();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        /**
         * 思路：此题的思路是使用HashMap+双向链表，其中双向链表的作用是记录元素的淘汰策略
         * java的集合中，LinkedList就是一个双向链表，所以有一种方式的使用HashMap+LinkedList实现，
         * 但是这种方式LinkedList存的是key，当根据Key去LinkedList中删除Key的时候是需要顺序查找的。
         * <p>
         * 更好的方式是模仿LinkedHashMap的实现，自定义双向链表，维护一个前后指针和一个封装的Node，
         * 利用HashMap定位到Node时，直接使用Node的左右指针将Node删掉, 节省了在LinkedList中查找Key的过程
         */
        class Node {
            int k;
            int v;
            Node pre; // 用于维护Node的双向链表
            Node next; // 用于维护Node的双向链表

            Node(int k, int v) {
                this.k = k;
                this.v = v;
            }
        }

        private int capacity;
        private HashMap<Integer, Node> map;
        private Node head;
        private Node tail;

        public LRUCache() {
        }

        /**
         * @param capacity
         */
        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node != null) {
                moveNodeToTail(node);
                return node.v;
            }
            return -1;
        }

        /**
         * 添加元素
         * 1.元素存在，将元素移动到队尾,队首的是要被先删除的
         * 2.不存在，判断链表是否满。
         * 如果满，则删除队首元素，放入队尾元素，删除更新哈希表
         * 如果不满，放入队尾元素，更新哈希表
         */
        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                // 更新值
                node.v = value;
                moveNodeToTail(node);
            } else {
                Node newNode = new Node(key, value);
                // 链表满，需要删除首节点
                if (map.size() == capacity) {
                    Node delHead = removeHead();
                    map.remove(delHead.k);
                }
                addLast(newNode);
                map.put(key, newNode);
            }
        }

        private void addLast(Node newNode) {
            if (newNode == null) {
                return;
            }
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                // 连接新节点
                tail.next = newNode;
                newNode.pre = tail;
                // 更新尾节点指针为新节点
                tail = newNode;
            }
        }

        private void moveNodeToTail(Node node) {
            if (tail == node) {
                return;
            }
            if (head == node) {
                head = node.next;
                head.pre = null;
            } else {
                // 调整双向链表指针
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            node.pre = tail;
            node.next = null;
            tail.next = node;
            tail = node;
        }

        private Node removeHead() {
            if (head == null) {
                return null;
            }
            Node res = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = res.next;
                head.pre = null;
                res.next = null;
            }
            return res;
        }

    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}