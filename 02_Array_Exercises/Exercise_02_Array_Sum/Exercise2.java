// CARL JAYSON ELI BONAOBRA
// CPE2A
// Exercise 2: Find the sum of all values in an array

public class Exercise2 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        System.out.println("The sum is " + sum);
    }
}
