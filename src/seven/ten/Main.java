package seven.ten;

public class Main {
    public static void main(String[] args) {
        OneByOne one1 = new OneByOne("a");
        OneByOne one2 = new OneByOne("b");
        one1.run();
        one2.run();
    }
}

class OneByOne extends Thread {
    private final String name;
    public OneByOne(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(name + ":" + i);
        }
    }
}
