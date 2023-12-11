package seven.ten;

public class Main1 {
    public static void main(String[] args) {
        IOneByOne one1 = new IOneByOne("a");
        IOneByOne one2 = new IOneByOne("b");
        one1.run();
        one2.run();
    }
}

class IOneByOne implements Runnable {
    private final String name;
    public IOneByOne(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(name + ":" + i);
        }
    }
}