package eight.five;

public class PC {
    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();
        new Thread(new Producer(synContainer)).start();
        new Thread(new Consumer(synContainer)).start();
    }
}

class Hamburger {
    int count;

    public Hamburger(int count) {
        this.count = count;
    }
}

class Producer implements Runnable {
    SynContainer synContainer;

    public Producer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                synContainer.produce(new Hamburger(10));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer implements Runnable {
    SynContainer synContainer;

    public Consumer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                synContainer.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class SynContainer {
    Hamburger[] container = new Hamburger[10];
    int num = 0;
    int index = 0;
    int second = 0;

    public synchronized void produce(Hamburger hamburger) throws InterruptedException {
        if (second == 6) {
            this.notifyAll();
            second = 0;
            index -= 1;
            this.wait();
        }
//        if (num == container.length) {
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        container[index++] = hamburger;
        System.out.println("生产10个，剩余" + (index * 10) + "个");
        second += 2;
        Thread.sleep(2000);
    }

    public synchronized void consume() throws InterruptedException {
        this.wait();
        if (index == 0 && container[index].count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (container[index].count > 3) {
            container[index].count -= 3;
            System.out.println("消费3个，剩余" + (Math.max(index - 1, 0) * 10) + container[index].count);
            Thread.sleep(1000);
        } else if (container[index].count > 0 && container[index].count < 3) {
            System.out.println("消费" + container[index].count + "个，剩余0个");
            container[index].count -= container[index].count;
            index--;
        }
    }
}
