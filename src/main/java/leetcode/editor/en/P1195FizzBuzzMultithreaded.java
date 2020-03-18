//Write a program that outputs the string representation of numbers from 1 to n,
// however: 
//
// 
// If the number is divisible by 3, output "fizz". 
// If the number is divisible by 5, output "buzz". 
// If the number is divisible by both 3 and 5, output "fizzbuzz". 
// 
//
// For example, for n = 15, we output: 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, bu
//zz, 11, fizz, 13, 14, fizzbuzz. 
//
// Suppose you are given the following code: 
//
// 
//class FizzBuzz {
//  public FizzBuzz(int n) { ... }               // constructor
//  public void fizz(printFizz) { ... }          // only output "fizz"
//  public void buzz(printBuzz) { ... }          // only output "buzz"
//  public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
//  public void number(printNumber) { ... }      // only output the numbers
//} 
//
// Implement a multithreaded version of FizzBuzz with four threads. The same ins
//tance of FizzBuzz will be passed to four different threads: 
//
// 
// Thread A will call fizz() to check for divisibility of 3 and outputs fizz. 
// Thread B will call buzz() to check for divisibility of 5 and outputs buzz. 
// Thread C will call fizzbuzz() to check for divisibility of 3 and 5 and output
//s fizzbuzz. 
// Thread D will call number() which should only output the numbers. 
// 
//

package leetcode.editor.en;

import java.util.concurrent.Semaphore;

//Java：Fizz Buzz Multithreaded
public class P1195FizzBuzzMultithreaded {
    public static void main(String[] args) {
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class FizzBuzz {
        /**
         * 思路：使用信号量控制打特殊字符的三个线程，由number线程决定释放哪个信号
         */
        private int n;
        private Semaphore number = new Semaphore(1);
        private Semaphore fizz = new Semaphore(0);
        private Semaphore buzz = new Semaphore(0);
        private Semaphore fizzbuzz = new Semaphore(0);

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 != 0) {
                    fizz.acquire();
                    printFizz.run();
                    number.release();
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 != 0 && i % 5 == 0) {
                    buzz.acquire();
                    printBuzz.run();
                    number.release();
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    fizzbuzz.acquire();
                    printFizzBuzz.run();
                    number.release();
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                boolean by3 = i % 3 == 0;
                boolean by5 = i % 5 == 0;
                if (by3 && by5) {
                    fizzbuzz.release();
                } else if (by3) {
                    fizz.release();
                } else if (by5) {
                    buzz.release();
                } else {
                    number.acquire();
                    printNumber.accept(i);
                    number.release();
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}