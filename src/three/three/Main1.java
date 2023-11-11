package three.three;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("请输入字符串：");
        System.out.print("反转后的字符串为：" + reverse(scan.nextLine()));
    }

    public static String reverse(String input){
        char[] oldStr = input.toCharArray();
        char[] newStr = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            newStr[i] = oldStr[input.length() - i - 1];
        }
        return String.valueOf(newStr);
    }
}