package two.three;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("输入一个在 0 和 1000 之间的整数: ");
        int num = scan.nextInt();
        int sum = 0;

        do {
            sum += num % 10;
        } while ((num /= 10) != 0);

        System.out.println("各位数字之和为: " + sum);
    }
}
