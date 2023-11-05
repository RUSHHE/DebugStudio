package one.three;

public class GetNum {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            if (isAim(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean isAim(int a) {
        String[] eachNum = String.valueOf(a).split("");
        int sum = 0;
        for (String num : eachNum) {
            sum += (int) Math.pow(Integer.parseInt(num), 3);
        }
        return sum == a;
    }
}