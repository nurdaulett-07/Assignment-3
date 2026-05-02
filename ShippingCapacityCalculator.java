import java.util.Scanner;

public class ShippingCapacityCalculator {

    static boolean canShip(int[] weights, int daysLimit, int capacity) {
        int daysNeeded = 1;
        int currentLoad = 0;

        for (int weight : weights) {
            // Cannot ship if a single package exceeds truck capacity
            if (weight > capacity) {
                return false;
            }
            // Move to the next day if adding this package exceeds daily capacity
            if (currentLoad + weight > capacity) {
                daysNeeded++;
                currentLoad = 0;
            }
            currentLoad += weight;
        }
        return daysNeeded <= daysLimit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of packages: ");
        int count = scanner.nextInt();
        int[] weights = new int[count];

        System.out.println("Enter weights:");
        int maxWeight = 0;
        int totalWeight = 0;

        // Setup binary search boundaries
        for (int i = 0; i < count; i++) {
            weights[i] = scanner.nextInt();

            if (weights[i] > maxWeight) {
                maxWeight = weights[i];
            }
            totalWeight += weights[i];
        }

        System.out.print("Enter number of days: ");
        int daysLimit = scanner.nextInt();

        // Binary search for minimum valid capacity
        int minCapacity = maxWeight;
        int maxCapacity = totalWeight;

        while (minCapacity < maxCapacity) {
            int midCapacity = (minCapacity + maxCapacity) / 2;

            if (canShip(weights, daysLimit, midCapacity)) {
                maxCapacity = midCapacity;
            } else {
                minCapacity = midCapacity + 1;
            }
        }

        System.out.println(minCapacity);
        scanner.close();
    }
}