//Five silent philosophers sit at a round table with bowls of spaghetti. Forks a
//re placed between each pair of adjacent philosophers. 
//
// Each philosopher must alternately think and eat. However, a philosopher can o
//nly eat spaghetti when they have both left and right forks. Each fork can be hel
//d by only one philosopher and so a philosopher can use the fork only if it is no
//t being used by another philosopher. After an individual philosopher finishes ea
//ting, they need to put down both forks so that the forks become available to oth
//ers. A philosopher can take the fork on their right or the one on their left as 
//they become available, but cannot start eating before getting both forks. 
//
// Eating is not limited by the remaining amounts of spaghetti or stomach space;
// an infinite supply and an infinite demand are assumed. 
//
// Design a discipline of behaviour (a concurrent algorithm) such that no philos
//opher will starve; i.e., each can forever continue to alternate between eating a
//nd thinking, assuming that no philosopher can know when others may want to eat o
//r think. 
//
// 
//
// The problem statement and the image above are taken from wikipedia.org 
//
// 
//
// The philosophers' ids are numbered from 0 to 4 in a clockwise order. Implemen
//t the function void wantsToEat(philosopher, pickLeftFork, pickRightFork, eat, pu
//tLeftFork, putRightFork) where: 
//
// 
// philosopher is the id of the philosopher who wants to eat. 
// pickLeftFork and pickRightFork are functions you can call to pick the corresp
//onding forks of that philosopher. 
// eat is a function you can call to let the philosopher eat once he has picked 
//both forks. 
// putLeftFork and putRightFork are functions you can call to put down the corre
//sponding forks of that philosopher. 
// The philosophers are assumed to be thinking as long as they are not asking to
// eat (the function is not being called with their number). 
// 
//
// Five threads, each representing a philosopher, will simultaneously use one ob
//ject of your class to simulate the process. The function may be called for the s
//ame philosopher more than once, even before the last call ends. 
//
// 
// Example 1: 
//
// 
//Input: n = 1
//Output: [[4,2,1],[4,1,1],[0,1,1],[2,2,1],[2,1,1],[2,0,3],[2,1,2],[2,2,2],[4,0,
//3],[4,1,2],[0,2,1],[4,2,2],[3,2,1],[3,1,1],[0,0,3],[0,1,2],[0,2,2],[1,2,1],[1,1,
//1],[3,0,3],[3,1,2],[3,2,2],[1,0,3],[1,1,2],[1,2,2]]
//Explanation:
//n is the number of times each philosopher will call the function.
//The output array describes the calls you made to the functions controlling the
// forks and the eat function, its format is:
//output[i] = [a, b, c] (three integers)
//- a is the id of a philosopher.
//- b specifies the fork: {1 : left, 2 : right}.
//- c specifies the operation: {1 : pick, 2 : put, 3 : eat}. 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 60 
// 
//

package leetcode.editor.en;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

//Java：The Dining Philosophers
public class P1226TheDiningPhilosophers {
    public static void main(String[] args) {
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class DiningPhilosophers {
        /**
         * 思路：哲学家问题是经典的解决死锁的问题。
         * 死锁的四个必要条件：
         * 1. 互斥条件
         * 2. 请求与保持条件
         * 3. 不可剥夺条件
         * 4. 循环等待条件
         * 打破死锁也是通过打破以上任何一个条件入手。
         * 互斥条件此题里不可打破
         * 请求与保持可以采用尝试请求的方式，如果请求不到就释放现有资源
         * 不可剥夺条件此题里不可打破
         * 循环等待条件可以通过控制至少让一个资源多余，使至少一个哲学家可以吃饭来打破，下面以这个实现
         * 循环等待条件还可以通过改变循环抢筷子顺序来打破
         */
        private ReentrantLock[] lockList = {new ReentrantLock(), // 定义五个锁, 分别对应
                new ReentrantLock(),
                new ReentrantLock(),
                new ReentrantLock(),
                new ReentrantLock()};

        private Semaphore eatLimit = new Semaphore(4); // 限制最多4个哲学家抢筷子，以此保证至少有一个哲学家可以同时抢到左右筷子

        public DiningPhilosophers() {

        }

        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
            int leftFork = (philosopher + 1) % 5;// 左边的叉子的编号
            int rightFork = philosopher;// 右边的叉子的编号

            eatLimit.acquire();// 限制的人数 -1

            lockList[leftFork].lock();// 拿起左边的叉子
            lockList[rightFork].lock();// 拿起右边的叉子

            pickLeftFork.run();// 拿起左边的叉子的具体执行
            pickRightFork.run();// 拿起右边的叉子的具体执行

            eat.run();// 吃面

            putLeftFork.run();// 放下左边的叉子的具体执行
            putRightFork.run();// 放下右边的叉子的具体执行

            lockList[rightFork].unlock();// 放下右边的叉子，是否锁的顺序应该没关系
            lockList[leftFork].unlock();// 放下左边的叉子

            eatLimit.release();// 限制的人数 +1
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}