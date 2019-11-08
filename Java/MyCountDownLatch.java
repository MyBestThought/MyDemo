package review;

/**
 * 应用场景一：有十个线程去执行各自的任务，任务分为两个部分：
 *           前半部分线程开启就可以执行，后半部分需要满足某个条件才能继续向下执行。
 *           如果条件不满足，则等待，直到条件满足方可执行；
 *           如果条件满足，则向下执行，等十个任务做完方可在当前线程做其他的事
 * 解决方案：使用CountDownLatch
 *
 * CountDownLatch的构造函数需要传入一个数，假定为count，这个数意味着可以调用countDown()多少次。
 * 每调用一次countDown()，count就会减一，直到count减为0，调用await()就不再阻塞线程了。
 * 也就是说，在count减为0之前，会一直阻塞线程
 *
 * CountDownLatch：同步工具类，用来协调多个线程之间的同步。这个工具通常用来控制线程等待，可以让某个线程等待直到计数器结束再开始执行
 *
 * CountDownLatch的两种用法：
 * 1，某一线程在开始运行前等待n个线程执行完毕，将CountDownLatch的计数器初始化为n：new CountDownLatch(n)；
 * 每当一个任务线程执行完毕，就将计数器-1，CountDownLatch。CountDown；
 * 当计数器的值变为0时，再CountDownLatch上await()的线程就会被唤醒。
 * 一个典型应用场景就是启动一个服务时，主线程需要等待多个组件加载完毕
 *
 * 2，实现多个线程开始自行任务的最大并行性，注意是并行性，而不是并发性；
 * 强调的是多个线程在某一时刻同时执行，类似于赛跑，将多个线程放到起点，等待发令枪响，然后同时开跑；
 * 做法是初始化一个共享的CountDownLatch对象；将其计数器初始化为1：new CountDownLatch(1)
 * 多个线程在开始执行任务前首先CountDownLatch.await()，当主线程调用countdown时，计数器变为0.多个线程同时被唤醒
 *
 * CountDownLatch的不足：
 * CountDownLatch是一次性的，计数器的值只能在构造方法中初始化一次，之后没有任何机制再次对其设置值；
 * 当CountDownLatch使用完毕后，不能再次使用，即：不支持重用
 *
 *
 */


import java.util.concurrent.CountDownLatch;


class Worker implements Runnable{
    CountDownLatch start, end;

    public Worker(CountDownLatch start, CountDownLatch end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        System.out.println("执行前半部分 : " + Thread.currentThread().getName());
        try {
            start.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行后半部分 : " + Thread.currentThread().getName());
        end.countDown();
        System.out.println();
    }
}


public class MyCountDownLatch {
    public static void main(String[] args) {
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(5);
        for(int i=0; i < 5; i++){
            new Thread(new Worker(start, end), "thread--"+i).start();
        }
        try{
            if(true){
                start.countDown();
            }
            end.await();
            System.out.println("所有任务结束，去执行自己的任务了……");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
