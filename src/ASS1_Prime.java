import java.util.*;
public class ASS1_Prime {
    static Scanner input = new Scanner(System.in);

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false; // 0 and 1 are not prime numbers
        }
        if (number == 2) {
            return true; // 2 is the only even prime number
        }
        if (number % 2 == 0) {
            return false; // Check for even number
        }
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false; // Check for factors
            }
        }
        return true; // No factors found, number is prime
    }

    // Function to parse the input and print all primes up to N
    public static void parse(int N) {
        // Handle edge cases
        if (N < 2 || N > 500) {
            System.out.println("Error: The number must be between 2 and 500.");
            return;
        }

        // Print prime numbers up to and including N
        for (int i = 2; i <= N; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println(); // Ensure output ends with a new line
    }

    public static void main(String[] args) {
        try {
            // Read the input as an integer
            int N = Integer.parseInt(input.nextLine());
            // Process and output the prime numbers
            parse(N);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter an integer.");
        } catch (Exception e) {
            System.out.println("Error: An unexpected error occurred. " + e.getMessage());
        } finally {
            // Close the scanner
            input.close();
        }
    }
}
