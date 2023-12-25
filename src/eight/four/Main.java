package eight.four;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Thread t1 = new Thread(() -> {
            while (animal.rabbitRace < 20 && !animal.winner) {
                try {
                    animal.printRabbitRace();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (animal.turtleRace < 20 && !animal.winner) {
                try {
                    animal.printTurtleRace();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
    }
}

class Animal {
    double rabbitSpeed = 0.5;
    double turtleSpeed = 0.1;
    double rabbitRace = 0;
    double turtleRace = 0;
    boolean winner = false;
    final double totalRace = 20;

    public void printRabbitRace() throws InterruptedException {
        rabbitRace += rabbitSpeed;
        if (rabbitRace == 20 && !winner) {
            winner = true;
        }
        if (rabbitRace % 2 == 0 && rabbitRace != 0) {
            System.out.println("兔子开始睡觉10秒种");
            Thread.sleep(10000);
            System.out.println("兔子醒了");
        }
        Thread.sleep(1000);
    }

    public void printTurtleRace() throws InterruptedException {
        turtleRace += turtleSpeed;
        if (turtleRace == 20 && !winner) {
            winner = true;
        }
        System.out.printf("兔子当前跑了%.1f米，离终点还有%.1f米\n", rabbitRace, totalRace - rabbitRace);
        System.out.printf("乌龟当前跑了%.1f米，离终点还有%.1f米\n", turtleRace, totalRace - turtleRace);
        if (rabbitRace >= turtleRace) {
            System.out.printf("当前兔子领先乌龟%.1f米\n", rabbitRace - turtleRace);
        } else {
            System.out.printf("当前乌龟领先兔子%.1f米\n", turtleRace - rabbitRace);
        }
        Thread.sleep(1000);
    }
}