package five.five;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Tiger();
        Animal animal1 = new Lion();

        animal.show();
        animal1.show();
    }
}

class Animal {
    public void show() {
        System.out.println("我是动物");
    }
}

class Tiger extends Animal {
    @Override
    public void show() {
        System.out.println("我是老fu");
    }
}

class Lion extends Animal {
    @Override
    public void show() {
        System.out.println("我是狮子");
    }
}