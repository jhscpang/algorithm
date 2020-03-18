//There are two kinds of threads, oxygen and hydrogen. Your goal is to group the
//se threads to form water molecules. There is a barrier where each thread has to 
//wait until a complete molecule can be formed. Hydrogen and oxygen threads will b
//e given releaseHydrogen and releaseOxygen methods respectively, which will allow
// them to pass the barrier. These threads should pass the barrier in groups of th
//ree, and they must be able to immediately bond with each other to form a water m
//olecule. You must guarantee that all the threads from one molecule bond before a
//ny other threads from the next molecule do. 
//
// In other words: 
//
// 
// If an oxygen thread arrives at the barrier when no hydrogen threads are prese
//nt, it has to wait for two hydrogen threads. 
// If a hydrogen thread arrives at the barrier when no other threads are present
//, it has to wait for an oxygen thread and another hydrogen thread. 
// 
//
// We don’t have to worry about matching the threads up explicitly; that is, the
// threads do not necessarily know which other threads they are paired up with. Th
//e key is just that threads pass the barrier in complete sets; thus, if we examin
//e the sequence of threads that bond and divide them into groups of three, each g
//roup should contain one oxygen and two hydrogen threads. 
//
// Write synchronization code for oxygen and hydrogen molecules that enforces th
//ese constraints. 
//
// 
// 
// 
//
// 
// Example 1: 
//
// 
//Input: "HOH"
//Output: "HHO"
//Explanation: "HOH" and "OHH" are also valid answers.
// 
//
// 
// Example 2: 
//
// 
//Input: "OOHHHH"
//Output: "HHOHHO"
//Explanation: "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHO
//HH" and "OHHOHH" are also valid answers.
// 
// 
// 
//
// 
// Constraints: 
//
// 
// Total length of input string will be 3n, where 1 ≤ n ≤ 20. 
// Total number of H will be 2n in the input string. 
// Total number of O will be n in the input string. 
// 
//

package leetcode.editor.en;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

//Java：Building H2O
public class P1117BuildingH2o {
    public static void main(String[] args) {
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class H2O {
        /**
         * 思路：使用信号量控制，还可以使用信号量+栅栏
         */
        private Semaphore o = new Semaphore(1); // 一个氧
        private Semaphore h = new Semaphore(2); // 两个氢
        private CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                o.release(1);
                h.release(2);
            }
        });

        public H2O() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            h.acquire();
            releaseHydrogen.run();
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {

            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            o.acquire();
            releaseOxygen.run();
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}