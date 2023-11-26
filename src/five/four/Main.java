package five.four;

public class Main {
    public static void main(String[] args) {
        new B().show();
    }
}

class A {
    public void show() {
        System.out.println("我是父类A");
    }
}

class B extends A {
    public void show() {
        System.out.println("我是子类B");
        super.show();
    }
}