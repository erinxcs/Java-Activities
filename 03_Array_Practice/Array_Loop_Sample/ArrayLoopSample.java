// CARL JAYSON ELI BONAOBRA
// CPE2A
// Activity: Create, fill, and display an integer array using loops

public class ArrayLoopSample {
    public static void main(String[] args) {
        int[] numbers = new int[10];

        // Assign values 1 to 10 to the array.
        for (int index = 0; index < numbers.length; index++) {
            numbers[index] = index + 1;
        }

        // Display the index and value of each array element.
        for (int index = 0; index < numbers.length; index++) {
            System.out.println("Element index: " + index + ", value: " + numbers[index]);
        }
    }
}
