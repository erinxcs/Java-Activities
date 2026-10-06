// CARL JAYSON ELI BONAOBRA
// CPE2A
// Activity: Find the greatest value among 10 user-entered numbers

import java.util.Scanner;

public class GreatestNumber {
    private static final int NUMBER_COUNT = 10;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int greatestNumber = Integer.MIN_VALUE;

            System.out.println("Please enter " + NUMBER_COUNT + " integers:");

            for (int count = 1; count <= NUMBER_COUNT; count++) {
                int currentNumber = readInteger(scanner, count);

                if (currentNumber > greatestNumber) {
                    greatestNumber = currentNumber;
                }
            }

            System.out.println("\nThe greatest number you entered is: " + greatestNumber);
        }
    }

    private static int readInteger(Scanner scanner, int numberPosition) {
        while (true) {
            System.out.print("Enter number " + numberPosition + ": ");

            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            }

            System.out.println("Invalid input. Please enter a whole number.");
            scanner.nextLine();
        }
    }
}
