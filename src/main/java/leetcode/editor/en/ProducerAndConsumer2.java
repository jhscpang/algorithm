package leetcode.editor.en;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by pangchao on 2020/2/6.
 */
public class ProducerAndConsumer2 {
    private int count = 0;
    private final int MAX_COUNT = 10;
    private Lock lock = new ReentrantLock();
    private Condition notEmptyCondition = lock.newCondition();
    private Condition notFullCondition = lock.newCondition();

    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (count == MAX_COUNT) {
                        try {
                            notFullCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println("生产者 " + Thread.currentThread().getName() + " 总共有 " + count + " 个资源");
                    notEmptyCondition.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (count == 0) {
                        try {
                            notEmptyCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println("消费者 " + Thread.currentThread().getName() + " 总共有 " + count + " 个资源");
                    notFullCondition.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
