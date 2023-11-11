package three.two;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("请输入字符串：");
        System.out.print("数字的个数为：" + countStrNum(scan.nextLine()));
    }

    public static int countStrNum(String input){
        int num = 0;
        for (char inputStr : input.toCharArray()) {
            if (Character.isDigit(inputStr)) {
                num++;
            }
        }
        return num;
    }
}
