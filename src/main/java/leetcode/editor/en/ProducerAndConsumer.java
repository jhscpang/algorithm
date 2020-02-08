package leetcode.editor.en;

/**
 * Created by pangchao on 2020/2/6.
 */
public class ProducerAndConsumer {
    private final static String LOCK = "lock";
    private int count = 0;
    private final int MAX_COUNT = 10;

    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized(LOCK) {
                    // 池子满了，生产者停止生产
                    while (count == MAX_COUNT) {
                        try {
                            System.out.println("pool is full, wating...");
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 干活
                    count++;
                    System.out.println("produce number:" + count);
                    // 通知
                    LOCK.notifyAll();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized(LOCK) {
                    // 池子空了，消费者停止消费
                    while (count == 0) {
                        try {
                            System.out.println("pool is empty, wating...");
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 干活
                    count--;
                    System.out.println("comsume number:" + count);
                    // 通知
                    LOCK.notifyAll();
                }
            }
        }
    }
}
