package eight.one;

public class Main {
    public static void main(String[] args) {
        Tool tool = new Tool();
        Thread t1 = new Thread(() -> {
            while (tool.count < 50) {
                tool.print1();
            }
        });
        Thread t2 = new Thread(() -> {
            while (tool.count < 50) {
                tool.print2();
            }
        });
        t1.start();
        t2.start();
    }
}

class Tool {
    boolean flag = false;
    int count = 1;

    public synchronized void print1() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("线程t1:count=" + count++);
        flag = true;
        notifyAll();
    }

    public synchronized void print2() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("线程t2:count=" + count++);
        flag = false;
        notifyAll();
    }
}