/**
 * 输入半径和高是: 5.5 12
 * 它的面积是: 95.0331
 * 它的体积是: 1140.4
 */
package two.two;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("输入半径和高是:");
        double radius = scan.nextDouble();
        double height = scan.nextInt();

        double area = Math.PI * Math.pow(radius, 2); // 精度不同，将Math.PI换成3.14159答案即可相同
//        double area = 3.14159 * Math.pow(radius, 2);
        double volume = area * height;

        System.out.printf("它的面积是:%.4f\n", area);
        System.out.printf("它的体积是:%.1f\n", volume);
    }
}
