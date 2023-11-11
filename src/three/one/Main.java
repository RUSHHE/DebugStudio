package three.one;

public class Main {
    public static void main(String[] args) {
        for (int i : countPrimeNumber(100)) {
            System.out.print(i + " ");
        }
    }

    public static int[] countPrimeNumber(int n) {
        int[] prime = new int[n];
        int index = 0;
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                prime[index] = i;
                index++;
            }
        }
        int[] newPrime = new int[index];
        System.arraycopy(prime, 0, newPrime, 0, index);
        return newPrime;
    }
}
