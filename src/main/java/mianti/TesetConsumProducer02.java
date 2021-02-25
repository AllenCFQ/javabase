package mianti;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1. 2个生产者 ，1个消费者
 * 2021-02-02 18:51:14
 * <p>
 * <p>
 * 1. 需要容器保存商品
 * 2. 2个线程负责生产
 * 3. 3个消费负责消费
 *
 * 可以多个condition
 */
public class TesetConsumProducer02 {


    public static final int N = 10;
    public static List<String> queue = new ArrayList<>(N);

    public static Object lockP = new Object();
    public static Object lockC = new Object();

    public static void main(String[] args) throws IOException {
        TesetConsumProducer02 test = new TesetConsumProducer02();
        Producer producer01 = test.new Producer();
        Producer producer02 = test.new Producer();

        Consumer consumer01 = test.new Consumer();
        Consumer consumer02 = test.new Consumer();
        Consumer consumer03 = test.new Consumer();

        new Thread(producer01).start();
        new Thread(producer02).start();

        new Thread(consumer01).start();
        new Thread(consumer02).start();
        new Thread(consumer03).start();

        new Thread(test.new Monnitor()).start();

        System.in.read();


    }

    class Monnitor implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("队列大小" + queue.size());
            }
        }
    }


    class Producer implements Runnable {
        Random random = new Random(6);

        @Override
        public void run() {
            while (true) {

                synchronized (lockP) {

                    while (queue.size() == N) {
                        try {
                            lockP.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    String goods = "goods" + random.nextInt();
                    queue.add(goods);
                    System.out.println("生产" + goods);
                    lockP.notifyAll();
                }




                try {
                    Thread.sleep(500);
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
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                synchronized (lockP) {

                    while (queue.size() == 0) {
                        try {
                            lockP.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int i = queue.size() - 1;
                    System.out.println("消费" + queue.get(0));
                    queue.remove(0);
                    lockP.notifyAll();

                }


            }
        }


    }
}
