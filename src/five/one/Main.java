package five.one;

public class Main {
    public static void main(String[] args) {
        new Dog().set("玛奇多");
        new Dog().set("八公", 10);
    }
}

class Dog {
    public void set(String name) {
        System.out.println("这条狗的名字叫" + name);
    }

    public void set(String name, int age) {
        System.out.println(name + "是条狗，已经" + age + "岁了");
    }
}