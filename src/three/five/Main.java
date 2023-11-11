package three.five;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        System.out.print("请输入数组长度：");
        int n = scan.nextInt();
        int[] a = new int[n];
        System.out.print("原数组：");
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(10);
            System.out.print(a[i] + " ");
        }
        System.out.print("\n数组反转后：");
        for (int i : reverse(a)) {
            System.out.print(i + " ");
        }
    }

    public static int[] reverse(int[] a){
        int[] newA = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            newA[i] = a[a.length - i - 1];
        }
        return newA;
    }
}
