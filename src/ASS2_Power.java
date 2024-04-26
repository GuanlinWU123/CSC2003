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
        if (m == 1) {
            return true;
        }
        if (n == 0 || n == 1) {
            return m == 1;
        }

        if (m % n == 0) {
            return isPowerOf(m / n, n);
        }

        return false;
    }
}
