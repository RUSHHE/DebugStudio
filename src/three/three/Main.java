package three.three;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("请输入字符串：");
        System.out.print("反转后的字符串为：" + reverse(scan.nextLine()));
    }

    public static String reverse(String input){
        return new StringBuilder(input).reverse().toString();
    }
}