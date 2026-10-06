// CARL JAYSON ELI BONAOBRA
// CPE2A
// Exercise 5: Check whether an array contains a specific value

public class Exercise5 {
    public static boolean contains(int[] array, int target) {
        for (int value : array) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {
            1789, 2035, 1899, 1456, 2013, 1458, 2458,
            1254, 1472, 2365, 1456, 2265, 1475, 2456
        };

        System.out.println("Contains 2013: " + contains(numbers, 2013));
        System.out.println("Contains 2015: " + contains(numbers, 2015));
    }
}
