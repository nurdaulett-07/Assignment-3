import java.util.Scanner;

public class KthSmallestFinder {

    static void sortAscending(int[] numbers) {
        // Manual Insertion Sort
        for (int i = 1; i < numbers.length; i++) {
            int current = numbers[i];
            int prev = i - 1;
            while (prev >= 0 && numbers[prev] > current) {
                numbers[prev + 1] = numbers[prev];
                prev--;
            }
            numbers[prev + 1] = current;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.print("Enter target rank (k): ");
        int rank = scanner.nextInt();

        sortAscending(numbers);

        // Element at index rank-1 is the k-th smallest
        System.out.println(numbers[rank - 1]);
        scanner.close();
    }
}