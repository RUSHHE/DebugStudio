package eight.two;

public class Main {
    public static void main(String[] args) {
        Tool tool = new Tool();
        Thread t1 = new Thread(() -> {
            while (tool.count <= 52) {
                tool.print1();
            }
        });
        Thread t2 = new Thread(() -> {
            while (tool.letter <= 'Z') {
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
    char letter = 'A';

    public synchronized void print1() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(count++);
        System.out.print(count++);
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
        System.out.print(letter++);
        flag = false;
        notifyAll();
    }
}