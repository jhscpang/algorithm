package leetcode.editor.en;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by pangchao on 2020/2/6.
 */
public class ProducerAndConsumer3 {
    private int count = 0;
    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    queue.put(1);
                    count++;
                    System.out.println("生产者 " + Thread.currentThread().getName() + " 总共有 " + count + " 个资源");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    queue.take();
                    count--;
                    System.out.println("消费者 " + Thread.currentThread().getName() + " 总共有 " + count + " 个资源");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
