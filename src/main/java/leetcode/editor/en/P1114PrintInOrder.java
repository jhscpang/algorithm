//Suppose we have a class: 
//
// 
//public class Foo {
//  public void first() { print("first"); }
//  public void second() { print("second"); }
//  public void third() { print("third"); }
//}
// 
//
// The same instance of Foo will be passed to three different threads. Thread A 
//will call first(), thread B will call second(), and thread C will call third(). 
//Design a mechanism and modify the program to ensure that second() is executed af
//ter first(), and third() is executed after second(). 
//
// 
//
// Example 1: 
//
// 
//Input: [1,2,3]
//Output: "firstsecondthird"
//Explanation: There are three threads being fired asynchronously. The input [1,
//2,3] means thread A calls first(), thread B calls second(), and thread C calls t
//hird(). "firstsecondthird" is the correct output.
// 
//
// Example 2: 
//
// 
//Input: [1,3,2]
//Output: "firstsecondthird"
//Explanation: The input [1,3,2] means thread A calls first(), thread B calls th
//ird(), and thread C calls second(). "firstsecondthird" is the correct output. 
//
// 
//
// Note: 
//
// We do not know how the threads will be scheduled in the operating system, eve
//n though the numbers in the input seems to imply the ordering. The input format 
//you see is mainly to ensure our tests' comprehensiveness. 
//

package leetcode.editor.en;

import java.util.concurrent.CountDownLatch;

//Java：Print in Order
public class P1114PrintInOrder {
    public static void main(String[] args) {
        Foo solution = new P1114PrintInOrder().new Foo();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Foo {
        /**
         * 思路：有多种方法可以实现线程顺序
         * 1. 信号量
         * 2. countDownLatch
         * 3. join
         * 4. volatile维护个变量
         * 5. 单线程的线程池
         * 6. 自己维护队列
         */
        private CountDownLatch lock1;
        private CountDownLatch lock2;

        public Foo() {
            lock1 = new CountDownLatch(1);
            lock2 = new CountDownLatch(1);
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            lock1.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock1.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            lock2.countDown();

        }

        public void third(Runnable printThird) throws InterruptedException {
            lock2.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}