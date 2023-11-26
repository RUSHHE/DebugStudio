package five.two;

public class Main {
    public static void main(String[] args) {
        Bird bird = new Bird(3, "粉");
        bird.info();

        Fish fish = new Fish(2, 10);
        fish.info();
    }

}

class Animal {
    public int age;
    public void info(){}

}

class Bird extends Animal {
    String color;
    public Bird(int age, String color) {
        this.age = age;
        this.color = color;
    }
    @Override
    public void info() {
        System.out.println("芝士一只" + color + "色的鸟，已经" + age + "岁了");
    }
}

class Fish extends Animal {
    double weight;
    public Fish(int age, double weight) {
        this.age = age;
        this.weight = weight;
    }

    @Override
    public void info() {
        System.out.println("芝士一条" + weight + "斤的鱼，已经" + age + "岁了");
    }
}