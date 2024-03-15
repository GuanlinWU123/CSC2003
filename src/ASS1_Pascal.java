import java.util.*;
public class ASS1_Pascal {
    static Scanner input = new Scanner(System.in);

    // Function to print Pascal's Triangle
    public static void parse(int N) {
        if (N < 0) {
            System.out.println("Error: N must be a non-negative integer.");
            return;
        }

        for (int line = 0; line < N; line++) {
            for (int i = 0; i <= line; i++) {
                System.out.print(binomialCoeff(line, i) + " ");
            }
            System.out.println();
        }
    }

    // Utility function to calculate binomial coefficient
    public static int binomialCoeff(int n, int k) {
        int res = 1;

        if (k > n - k) {
            k = n - k;
        }

        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        try {
            System.out.println("Enter the number of rows for Pascal's Triangle:");
            String line = input.nextLine();

            // Check for valid integer input
            int N = Integer.parseInt(line);

            // Check for negative integer which is not allowed
            if (N < 0) {
                System.out.println("Error: Number of rows cannot be negative.");
                return;
            }

            parse(N);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter a non-negative integer.");
        } catch (Exception e) {
            System.out.println("Error: An unexpected error occurred. " + e.getMessage());
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }
}
