package review;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 应用场景二：十个线程去执行各自的任务，要求：前半部分执行完之后才可以执行后半部分
 *     同样有十个线程去执行各自的任务，任务也是分为两个部分，
 *     现在要求等所有前半部分执行完后才能开始执行后半部分。
 *
 * 解决方案：使用CyclicBarrier
 *
 * CyclicBarrier的构造函数也是需要传入一个数count，也就是所共有count个栅栏锁。
 * 每调用一次await()方法时，栅栏锁就会少一个，但这时是阻塞线程的。当栅栏锁减为0时，此时线程不再阻塞。
 *
 * CyclicBarrier可以实现线程间的技术等待，但是它的功能比CountDownLatch更加强大和复杂。
 * CyclicBarrier的字面意思是可循环使用的屏障，它要做的事情就是：让一组线程到达一个屏障时被阻塞，
 * 直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续干活。
 * CyclicBarrier默认的构造方法是CyclicBarrier(int parties)，其参数表示屏障拦截的线程数量，
 * 每个线程调用await()方法告诉CyclicBarrier，我已经到达屏障，然后被当前线程阻塞。
 *
 * CyclicBarrier可以用于多线程计算数据，最后合并结果的应用场景。
 * 例如：我们用一个Exce;保存用户所有银行流水，每个sheet保存每一个账户近一年的每一笔银行流水。
 * 现在需要统计用户的日平均银行流水，先用多线程处理每个sheet里的银行流水，都执行完之后，得到每个sheet的日均银行流水。
 * 最后，使用barrierAction用这些线程的计算结果，计算出整个excel的日均银行流水
 *
 */


class MyWorker implements Runnable{
    private int id;
    private CyclicBarrier cyclicBarrier;

    public MyWorker(int id, CyclicBarrier cyclicBarrier) {
        this.id = id;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("前半部分任务正在执行 : " + Thread.currentThread().getName() + ", id = " + id);
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("后半部分任务正在执行 : " + Thread.currentThread().getName() + ", id = " + id);
    }
}

public class MyCyclicBarrier {

    public static void main(String[] args) {
        int num = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(num, new Runnable() {
            @Override
            public void run() {
                System.out.println("前半部分执行完毕，即将执行后半部分……");
            }
        });
        List<Thread> list = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            Thread thread = new Thread(new MyWorker(i, cyclicBarrier), "thread--" + i);
            list.add(thread);
            thread.start();
        }
        for(Thread t : list){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("后半部分执行完毕，可以做自己的事了");
    }
}
