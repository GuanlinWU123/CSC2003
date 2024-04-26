import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class ASS3_WordSearching {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            board[i] = line.toCharArray();
        }

        int T = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        while (T-- > 0) {
            String word = scanner.nextLine();
            System.out.println(findWord(board, word) ? "true" : "false");
        }
        scanner.close();
    }

    private static boolean findWord(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == word.charAt(0)) {
                    Set<String> visited = new HashSet<>();
                    if (search(board, word, row, col, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean search(char[][] board, String word, int row, int col, int index, Set<String> visited) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index) || !visited.add(row + ":" + col)) {
            return false;
        }

        // The use of Java 8 Streams can make the directional checks more elegant,
        // but for the sake of clarity and performance, let's keep it simple.

        char originalValue = board[row][col];
        board[row][col] = '#'; // Mark this cell as visited

        boolean found = search(board, word, row + 1, col, index + 1, visited) ||
                search(board, word, row - 1, col, index + 1, visited) ||
                search(board, word, row, col + 1, index + 1, visited) ||
                search(board, word, row, col - 1, index + 1, visited);

        board[row][col] = originalValue; // Restore the original value
        visited.remove(row + ":" + col); // Backtrack: unmark this cell as visited
        return found;
    }
}