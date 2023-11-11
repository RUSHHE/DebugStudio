package three.nine;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Hero("盖伦", 616, 27, 350));
        System.out.println(new Hero("提莫", 383, 14, 330));
    }
}

class Hero {
    private String name;
    private int health;
    private int armor;
    private int speed;

    public Hero(String name, int health, int armor, int speed) {
        this.name = name;
        this.health = health;
        this.armor = armor;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{name = " + name + ", health = " + health + ", armor = " + armor + ", speed = " + speed + "}";
    }
}