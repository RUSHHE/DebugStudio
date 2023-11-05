package one.one;

public class Fib {
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            System.out.print(new Solution().fib(i) + " ");
        }
    }
}

class Solution {
    public int fib(int n) {
        int[] fib = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == 1) {
                fib[i] = 1;
            } else {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        }
        return fib[n - 1];
    }
}