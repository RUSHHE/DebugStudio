package two.four;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("请输入字符串str: ");
        String str = scan.next();
        System.out.print("请输入字符s: ");
        String s = scan.next();

        System.out.println("字符 " + s + " 在字符串 " + str + " 的位置为" + indexOf(str, s));
    }

    private static int indexOf(String str,String s){
        return str.indexOf(s);
    }
}