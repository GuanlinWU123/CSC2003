import java.util.Scanner;

public class ASS3_MathExpression {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int T = Integer.parseInt(scanner.nextLine()); // Use nextLine and then parse

            for (int i = 0; i < T; i++) {
                String expression = scanner.nextLine().replaceAll("\\s+", "");
                ExpressionParser parser = new ExpressionParser(expression);
                System.out.println((int) Math.round(parser.evaluate()));
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

class ExpressionParser {
    private final String input;
    private int index = 0;

    public ExpressionParser(String input) {
        this.input = input;
    }

    public double evaluate() {
        double result = parseExpression();
        if (index < input.length()) {
            throw new IllegalArgumentException("Unexpected character: " + peek());
        }
        return result;
    }

    private double parseExpression() {
        double result = parseTerm();
        while (true) {
            if (match('+')) result += parseTerm();
            else if (match('-')) result -= parseTerm();
            else return result;
        }
    }

    private double parseTerm() {
        double result = parseFactor();
        while (true) {
            if (match('*')) result *= parseFactor();
            else if (match('/')) result /= parseFactor();
            else return result;
        }
    }

    private double parseFactor() {
        if (match('-')) return -parseFactor();

        if (match('(')) {
            double result = parseExpression();
            expect(')');
            return result;
        }

        for (String func : new String[]{"sin", "cos", "tan", "sqrt"}) {
            if (match(func)) return parseFunction(func);
        }

        if (Character.isDigit(peek()) || peek() == '.') return parseNumber();

        throw new RuntimeException("Unexpected character: " + peek());
    }

    private double parseFunction(String func) {
        expect('(');
        double argument = parseExpression();
        expect(')');
        switch (func) {
            case "sin": return Math.sin(argument);
            case "cos": return Math.cos(argument);
            case "tan": return Math.tan(argument);
            case "sqrt": return Math.sqrt(argument);
            default: throw new IllegalArgumentException("Unknown function: " + func);
        }
    }

    private double parseNumber() {
        int start = index;
        while (index < input.length() && (Character.isDigit(peek()) || peek() == '.')) next();
        return Double.parseDouble(input.substring(start, index));
    }

    private void expect(char expected) {
        if (peek() != expected) throw new RuntimeException("Expected " + expected + " but found " + peek());
        next();
    }

    private boolean match(String str) {
        int end = index + str.length();
        if (end <= input.length() && input.substring(index, end).equals(str)) {
            index = end;
            return true;
        }
        return false;
    }

    private boolean match(char expected) {
        if (peek() == expected) {
            next();
            return true;
        }
        return false;
    }

    private void next() {
        ++index;
    }

    private char peek() {
        return index < input.length() ? input.charAt(index) : '\0';
    }
}
