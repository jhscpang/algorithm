//Suppose you are given the following code: 
//
// 
//class ZeroEvenOdd {
//  public ZeroEvenOdd(int n) { ... }      // constructor
//  public void zero(printNumber) { ... }  // only output 0's
//  public void even(printNumber) { ... }  // only output even numbers
//  public void odd(printNumber) { ... }   // only output odd numbers
//}
// 
//
// The same instance of ZeroEvenOdd will be passed to three different threads: 
//
// 
// Thread A will call zero() which should only output 0's. 
// Thread B will call even() which should only ouput even numbers. 
// Thread C will call odd() which should only output odd numbers. 
// 
//
// Each of the threads is given a printNumber method to output an integer. Modif
//y the given program to output the series 010203040506... where the length of the
// series must be 2n. 
//
// 
//
// Example 1: 
//
// 
//Input: n = 2
//Output: "0102"
//Explanation: There are three threads being fired asynchronously. One of them c
//alls zero(), the other calls even(), and the last one calls odd(). "0102" is the
// correct output.
// 
//
// Example 2: 
//
// 
//Input: n = 5
//Output: "0102030405"
// 
//

package leetcode.editor.en;

import java.util.concurrent.Semaphore;

//Java：Print Zero Even Odd
public class P1116PrintZeroEvenOdd {
    public static void main(String[] args) {
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class ZeroEvenOdd {
        /**
         * 思路：定义三个信号量控制控制三个线程
         */
        private int n;
        private Semaphore zeroRun = new Semaphore(1); // 控制0线程
        private Semaphore evenRun = new Semaphore(0); // 控制偶数线程
        private Semaphore oddRun = new Semaphore(0); // 控制奇数线程

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) { // 从1开始，便于让奇数线程先于偶数线程打印
                zeroRun.acquire(); // 获取可运行信号量
                printNumber.accept(0);
                if (i % 2 == 0) {
                    evenRun.release();
                } else {
                    oddRun.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) { // 偶数从2开始
                evenRun.acquire(); // 获取可运行信号量
                printNumber.accept(i);
                zeroRun.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) { // 奇数从1开始
                oddRun.acquire(); // 获取可运行信号量
                printNumber.accept(i);
                zeroRun.release();
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}