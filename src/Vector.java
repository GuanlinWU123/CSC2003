import java.util.Arrays;
import java.util.stream.Collectors;

public class Vector {

    private int[] elements;

    public Vector(int[] elements) {
        this.elements = elements.clone();
    }

    public static Vector plus(Vector v1, Vector v2) {
        int[] result = new int[v1.elements.length];
        for (int i = 0; i < v1.elements.length; i++) {
            result[i] = v1.elements[i] + v2.elements[i];
        }
        return new Vector(result);
    }

    public static Vector subtract(Vector v1, Vector v2) {
        int[] result = new int[v1.elements.length];
        for (int i = 0; i < v1.elements.length; i++) {
            result[i] = v1.elements[i] - v2.elements[i];
        }
        return new Vector(result);
    }

    public Vector multiply(int a) {
        int[] result = new int[this.elements.length];
        for (int i = 0; i < this.elements.length; i++) {
            result[i] = this.elements[i] * a;
        }
        return new Vector(result);
    }

    public double norm(int p) {
        double sum = 0;
        for (int element : this.elements) {
            sum += Math.pow(Math.abs(element), p);
        }
        return Math.pow(sum, 1.0 / p);
    }

    public double norm() {
        double max = Double.NEGATIVE_INFINITY;
        for (int element : this.elements) {
            max = Math.max(max, Math.abs(element));
        }
        return max;
    }

    public static int dot(Vector v1, Vector v2) {
        int dotProduct = 0;
        for (int i = 0; i < v1.elements.length; i++) {
            dotProduct += v1.elements[i] * v2.elements[i];
        }
        return dotProduct;
    }

    public static double angle(Vector v1, Vector v2) {
        double dotProduct = dot(v1, v2);
        double normV1 = v1.norm(2); // Euclidean norm
        double normV2 = v2.norm(2); // Euclidean norm
        return Math.acos(dotProduct / (normV1 * normV2));
    }

    @Override
    public String toString() {
        return Arrays.stream(this.elements)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", ", "(", ")"));
    }
}