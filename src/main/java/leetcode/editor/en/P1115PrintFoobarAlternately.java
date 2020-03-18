//Suppose you are given the following code: 
//
// 
//class FooBar {
//  public void foo() {
//    for (int i = 0; i < n; i++) {
//      print("foo");
//    }
//  }
//
//  public void bar() {
//    for (int i = 0; i < n; i++) {
//      print("bar");
//    }
//  }
//}
// 
//
// The same instance of FooBar will be passed to two different threads. Thread A
// will call foo() while thread B will call bar(). Modify the given program to out
//put "foobar" n times. 
//
// 
//
// Example 1: 
//
// 
//Input: n = 1
//Output: "foobar"
//Explanation: There are two threads being fired asynchronously. One of them cal
//ls foo(), while the other calls bar(). "foobar" is being output 1 time.
// 
//
// Example 2: 
//
// 
//Input: n = 2
//Output: "foobarfoobar"
//Explanation: "foobar" is being output 2 times.
// 
//

package leetcode.editor.en;

//Java：Print FooBar Alternately
public class P1115PrintFoobarAlternately {
    public static void main(String[] args) {
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class FooBar {
        /**
         * 思路：用一个标识符表示哪个线程可以运行，用锁来控制线程
         * 1. 可以用yield让线程让步，yeild不释放锁，所以要使用while控制
         * 2. 可以使用lock.wait()在同步代码块里让线程让出锁。
         */
        private volatile boolean flag = true; // true的时候打印foo，false时候打印bar
        private int n;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (!flag) {
                    Thread.yield();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = false;
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (flag) {
                    Thread.yield();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = true;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}