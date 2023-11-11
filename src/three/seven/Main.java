/**
 * 请输入n：6
 * 请输入6个数字：4，3，7，8，1，6
 * 最小数为：1
 */
package three.seven;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("请输入n：");
        int n = scan.nextInt();
        System.out.print("请输入" + n + "个数字：");
        int[] a = new int[n];
        int index = 0;
        for (String str : scan.next().split("，")) { // 测试用例为中文逗号(，)
            a[index++] = Integer.parseInt(str);
        }
        System.out.print("最小数为：" + minArray(a));
    }

    public static int minArray(int[] a){
        int min = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[min]) {
                min = i;
            }
        }
        return a[min];
    }
}
