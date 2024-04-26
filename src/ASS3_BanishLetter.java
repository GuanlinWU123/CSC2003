import java.util.*;
import java.util.stream.Collectors;
public class ASS3_BanishLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the characters to banish and store them in a HashSet for quick lookup.
        Set<String> charsToBanish = new HashSet<>(Arrays.asList(scanner.nextLine().trim().split("\\s+")));

        // Read the number of test cases.
        int T = scanner.hasNextInt() ? scanner.nextInt() : 0;
        scanner.nextLine(); // consume the rest of the line after reading the integer

        for (int i = 0; i < T; i++) {
            if (scanner.hasNextLine()) {
                String inputString = scanner.nextLine();

                // Use streams to filter out the banished characters and collect the result into a string.
                String result = inputString.chars() // creates an IntStream
                        .mapToObj(c -> String.valueOf((char) c)) // convert int to String
                        .filter(c -> !charsToBanish.contains(c)) // filter out banished characters
                        .collect(Collectors.joining()); // concatenate the remaining characters

                System.out.println(result);
            }
        }

        scanner.close();
    }

}
