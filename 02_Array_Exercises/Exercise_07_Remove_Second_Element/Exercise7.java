// CARL JAYSON ELI BONAOBRA
// CPE2A
// Exercise 7: Remove the second element from an array

import java.util.Arrays;

public class Exercise7 {
    public static void main(String[] args) {
        int[] originalArray = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        int removeIndex = 1; // Second element (value 14)

        System.out.println("Original array: " + Arrays.toString(originalArray));

        // Java arrays have a fixed size, so create a new array with one less element.
        int[] updatedArray = new int[originalArray.length - 1];

        for (int sourceIndex = 0, destinationIndex = 0;
             sourceIndex < originalArray.length;
             sourceIndex++) {

            if (sourceIndex == removeIndex) {
                continue;
            }

            updatedArray[destinationIndex] = originalArray[sourceIndex];
            destinationIndex++;
        }

        System.out.println("After removing the second element: "
                + Arrays.toString(updatedArray));
    }
}
