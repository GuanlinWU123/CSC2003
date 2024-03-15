//import java.util.Scanner;
import java.util.*;
public class ASS1_MathExpression {
    static Scanner input = new Scanner(System.in);

    public static void parse_line(String s1, String s2, String s3) {
        try {
            // Parse the operands
            int a = Integer.parseInt(s1);
            int b = Integer.parseInt(s3);
            char operator = s2.charAt(0);
            int result = 0;

            // Evaluate the expression based on the operator
            switch (operator) {
                case '+':
                    result = a + b;
                    break;
                case '-':
                    result = a - b;
                    break;
                case '*':
                    result = a * b;
                    break;
                case '/':
                    // Check for division by zero
                    if (b == 0) {
                        System.out.println("Error: Division by zero");
                        return;
                    }
                    result = a / b; // Integer division automatically rounds down
                    break;
                default:
                    System.out.println("Error: Unknown operator '" + operator + "'");
                    return;
            }

            // Print the result
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format");
        } catch (Exception e) {
            System.out.println("Error: An unexpected error occurred");
        }
    }

    public static void main(String[] args) {
        try {
            int line_number = Integer.parseInt(input.nextLine());
            for (int i = 0; i < line_number; i++) {
                String s = input.nextLine();
                String[] t = s.split(" ");
                if (t.length != 3) {
                    System.out.println("Error: Incorrect input format");
                    continue; // Skip this iteration and move to the next one
                }
                parse_line(t[0], t[1], t[2]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: The first line must be a valid integer representing the number of lines to follow.");
        } catch (Exception e) {
            System.out.println("Error: An unexpected error occurred while reading input");
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }
}
