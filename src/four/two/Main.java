package four.two;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.setSpeed(123.12);
        vehicle.move();
        vehicle.speedUp(30.0);
        vehicle.move();
        vehicle.speedDown(50.0);
        vehicle.move();
    }
}

class Vehicle {
    double speed;
    String carType;

    public Vehicle() {
        this.speed = 0;
        this.carType = "兰博基尼";
    }

    public void move() {
        System.out.println(carType + "速度" + speed + "迈～～～");
    }

    public void setSpeed(double speed) {
        if (speed < 0) {
            System.out.println("不支持倒车捏");
        } else {
            this.speed = speed;
        }
    }

    public void speedUp(double speed) {
        if (speed < 0) {
            System.out.println("怎么加速能是负的捏");
        } else {
            this.speed += speed;
        }
    }

    public void speedDown(double speed) {
        if (speed < 0) {
            System.out.println("你搁着负负得正呢");
        } else if (speed > this.speed) {
            System.out.println("别减速辣，隔着倒车呢");
        } else {
            this.speed -= speed;
        }
    }
}