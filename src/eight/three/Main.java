package eight.three;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1(0, 20);
        Thread1 t2 = new Thread1(21, 40);
        Thread1 t3 = new Thread1(41, 60);
        Thread1 t4 = new Thread1(61, 80);
        Thread1 t5 = new Thread1(81, 100);
        System.out.println(t1.call() + t2.call() + t3.call() + t4.call() + t5.call());
    }
}

class Thread1 implements Callable<Integer> {
    int start;
    int end;

    public Thread1(int start, int end)
    {
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }
}