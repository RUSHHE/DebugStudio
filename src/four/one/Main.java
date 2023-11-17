package four.one;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("圆的半径为");
        Circle circle = new Circle(scan.nextDouble());

        System.out.println("圆的面积为" + circle.getArea());
        System.out.println("圆的周长为" + circle.getGirth());
    }
}

class Circle {
    private double radius;

    public Circle(double radius) {
        setRadius(radius);
    }

    public void setRadius(double radius) {
        if (!(radius > 0)) {
            System.out.println("输入错误");
        } else {
            this.radius = radius;
        }
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Double.parseDouble(new DecimalFormat("#.00").format(Math.pow(radius, 2) * Math.PI));
    }

    public double getGirth() {
        return Double.parseDouble(new DecimalFormat("#.00").format(2 * Math.PI * radius));
    }
}