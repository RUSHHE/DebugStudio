/**
 * 请输入n：6
 * 请输入6个数字：3 5 1 7 8 4
 * 排序前：3 5 1 7 8 4
 * 排序后：1 3 4 5 7 8
 */
package three.four;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("请输入n：");
        int n = scan.nextInt();
        System.out.print("请输入" + n + "个数字：");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        System.out.print("排序前：");
        for (int j : a) {
            System.out.print(j + " ");
        }
        System.out.print("\n排序后：");
        sort(a);
        for (int j : a) {
            System.out.print(j + " ");
        }
    }

//    public static int[] sort(int[] a) {
    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int temp;
            temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
//        return a;
    }
}