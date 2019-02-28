package com.li.thead;

/*多线程之间的通信
 *  生产者生产 商品
 *
 *  消费者消费商品
 *
 *  商品有自己的 生产方法和消费方法
 *
 **/
public class ThreadDeamo {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //创建商品对象
        Good g = new Good();
        // 创建生产者对象
        PorduterDemo p = new PorduterDemo(g);
        // 创建消费者对象
        ConsumerDemo c = new ConsumerDemo(g);
        // 创建生产者线程
        new Thread(p).start();
        new Thread(p).start();
        //  创建消费者线程
        new Thread(c).start();
        new Thread(c).start();
    }
}

/*商品类
 *   属性  名称
 *        编号
 *        标记变量
 *    方法    生产的方法
 *          消费的方法
 * */
class Good {
    private String name;
    private int count = 1;
    private boolean flag = false;

    // 生产的方法
    public synchronized void set(String name) {
        while (flag)
            try {
                this.wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        this.name = name + "-生产者-" + count++;
        System.out.println(Thread.currentThread().getName() + "生产者" + this.name);
        flag = true;
        this.notifyAll();
    }

    //  消费的方法
    public synchronized void out() {
        while (!flag)
            try {
                this.wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        System.out.println(Thread.currentThread().getName() + "消费者" + this.name);
        flag = false;
        this.notifyAll();
    }
}

//生产者  调用商品的生产方法
class PorduterDemo implements Runnable {
    private Good g;

    PorduterDemo(Good g) {
        this.g = g;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            g.set("商品");
        }
    }
}

//消费者调用  商品的消费方法
class ConsumerDemo implements Runnable {

    private Good g;

    ConsumerDemo(Good g) {
        this.g = g;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            g.out();
        }
    }
}