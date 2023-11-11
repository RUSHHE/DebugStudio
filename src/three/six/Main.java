package three.six;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[random.nextInt(5) + 5];
        int[] b = new int[random.nextInt(5) + 5];
        System.out.println("数组a的内容：");
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(89) + 10;
            System.out.print(a[i] + " ");
        }
        System.out.println("\n数组b的内容：");
        for (int i = 0; i < b.length; i++) {
            b[i] = random.nextInt(89) + 10;
            System.out.print(b[i] + " ");
        }
        System.out.println("\n数组c的内容：");
        for (int i : combine(a, b)) {
            System.out.print(i + " ");
        }
    }

    public static int[] combine(int[] a, int[] b){
        int[] c = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            c[a.length + i] = b[i];
        }
        //更简便
//        System.arraycopy(a, 0, c, 0, a.length);
//        System.arraycopy(b, 0, c, a.length, b.length);
        return c;
    }
}
