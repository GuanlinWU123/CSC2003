import java.util.Scanner;
public class ASS2_Power {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.close();

        System.out.println(isPowerOf(m, n));
    }

    public static boolean isPowerOf(int m, int n) {
        // base case: n to the power of 0 is always 1
        if (m == 1) {
            return true;
        }

        // base case: if n is 0 or 1, m must be 1 to return true
        if (n == 0 || n == 1) {
            return m == 1;
        }

        // if m is divisible by n, recursively check for m/n
        if (m % n == 0) {
            return isPowerOf(m / n, n);
        }

        // if none of the above, m is not a power of n
        return false;
    }
}
