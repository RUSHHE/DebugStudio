package two.one;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("摄氏度：");
        double celsius = scan.nextDouble();
        double fahrenheit = (9d / 5d) * celsius + 32;

        System.out.printf("%.1f 摄氏度 equals %.1f 华氏度", celsius, fahrenheit);
    }
}
