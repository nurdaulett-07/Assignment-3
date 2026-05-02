import java.util.Scanner;

public class MedianFinder {

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

        sortAscending(numbers);

        // Handles both odd and even sized arrays correctly
        if (size % 2 != 0) {
            System.out.println(numbers[size / 2]);
        } else {
            double median = (numbers[(size - 1) / 2] + numbers[size / 2]) / 2.0;
            System.out.println(median);
        }

        scanner.close();
    }
}