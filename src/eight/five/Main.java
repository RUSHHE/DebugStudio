package eight.five;

public class Main {
    public static void main(String[] args) {
        Restaurant res = new Restaurant();
        Thread t1 = new Thread(() -> {
            while (true) {
                try {
                    res.print1();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    res.print2();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
    }
}

class Restaurant {
    boolean flag = false;
    int count = 0;

    public synchronized void print1() throws InterruptedException {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("生产者生产10个汉堡，还剩" + (count += 10) + "个汉堡");
            Thread.sleep(2000);
        }
        flag = true;
        notifyAll();
    }

    public synchronized void print2() throws InterruptedException {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (count > 0) {
            System.out.println("消费者消费3个汉堡，还剩" + (count -= 3) + "个汉堡");
            Thread.sleep(1000);
        }
        flag = false;
        notifyAll();
    }
}