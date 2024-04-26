import java.util.*;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

abstract class SortStrategy {
    abstract void sort(String[] items, char c);
}

class AlphabeticalSort extends SortStrategy {
    @Override
    void sort(String[] items, char c) {
        Arrays.sort(items);
    }
}

class LengthOrderSort extends SortStrategy {
    @Override
    void sort(String[] items, char c) {
        Arrays.sort(items, Comparator.comparingInt(s -> s.length()));

    }
}


class CharacterFrequencySort extends SortStrategy {
    @Override
    void sort(String[] items, char c) {
        Arrays.sort(items, (s1, s2) -> {
            long count1 = s1.chars().filter(ch -> ch == c).count();
            long count2 = s2.chars().filter(ch -> ch == c).count();
            if (count1 == count2) {
                return 0;
            }
            return Long.compare(count1, count2);
        });
    }
}

class StringSorter {

    private SortStrategy strategy;

    public StringSorter(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sortContent(String[] strings, char c) {
        strategy.sort(strings, c);
    }
}

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        int t = Integer.parseInt(firstLine.split(" ")[0]);
        int n = Integer.parseInt(firstLine.split(" ")[1]);
        String[] items = new String[n];
        for (int i = 0; i < n; i++) items[i] = scanner.nextLine();
        char c = ' ';
        if (t == 3) c = scanner.nextLine().charAt(0);
        StringSorter sorter;
        switch (t) {
            case 1:
                sorter = new StringSorter(new AlphabeticalSort());
                break;
            case 2:
                sorter = new StringSorter(new LengthOrderSort());
                break;
            case 3:
                sorter = new StringSorter(new CharacterFrequencySort());
                break;
            default:
                sorter = new StringSorter(new AlphabeticalSort());
                break;
        }
        sorter.sortContent(items, c);
        for (String item : items) {
            System.out.println(item);
        }
        scanner.close();
    }

}