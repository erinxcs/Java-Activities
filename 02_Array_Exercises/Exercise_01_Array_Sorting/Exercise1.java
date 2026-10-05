// CARL JAYSON ELI BONAOBRA
// CPE2A
// Exercise 1: Sort numeric and string arrays

import java.util.Arrays;

public class Exercise1 {
    public static void main(String[] args) {
        int[] numericArray = {
            1789, 2035, 1899, 1456, 2013, 1458, 2458,
            1254, 1472, 2365, 1456, 2165, 1457, 2456
        };

        String[] stringArray = {
            "Java", "Python", "PHP", "C#", "C Programming", "C++"
        };

        System.out.println("Original numeric array: " + Arrays.toString(numericArray));
        Arrays.sort(numericArray);
        System.out.println("Sorted numeric array:   " + Arrays.toString(numericArray));

        System.out.println("\nOriginal string array: " + Arrays.toString(stringArray));
        Arrays.sort(stringArray);
        System.out.println("Sorted string array:   " + Arrays.toString(stringArray));
    }
}
