// CARL JAYSON ELI BONAOBRA
// CPE2A
// Activity: Search for a name inside a string array

import java.util.Scanner;

public class StringArraySample {
    public static void main(String[] args) {
        String[] names = {"john", "peter", "mary", "paul", "joseph"};

        // Display all names and their indexes.
        for (int index = 0; index < names.length; index++) {
            System.out.println("[" + index + "] " + names[index]);
        }

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("\nEnter name to search: ");
            String nameToSearch = scanner.nextLine().trim();

            int foundIndex = -1;

            for (int index = 0; index < names.length; index++) {
                if (nameToSearch.equalsIgnoreCase(names[index])) {
                    foundIndex = index;
                    break;
                }
            }

            if (foundIndex >= 0) {
                System.out.println(nameToSearch + " is found at index " + foundIndex + ".");
            } else {
                System.out.println(nameToSearch + " was not found in the array.");
            }
        }
    }
}
