// CARL JAYSON ELI BONAOBRA
// CPE2A
// Activity: Display days of the week using while, do-while, and for loops

public class DaysOfWeek {
    public static void main(String[] args) {
        String[] days = {
            "Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday", "Saturday", "Sunday"
        };

        System.out.println("## Printing with a while-loop:");
        int whileIndex = 0;
        while (whileIndex < days.length) {
            System.out.println(days[whileIndex]);
            whileIndex++;
        }

        System.out.println("\n## Printing with a do-while-loop:");
        int doWhileIndex = 0;
        if (days.length > 0) {
            do {
                System.out.println(days[doWhileIndex]);
                doWhileIndex++;
            } while (doWhileIndex < days.length);
        }

        System.out.println("\n## Printing with a for-loop:");
        for (int forIndex = 0; forIndex < days.length; forIndex++) {
            System.out.println(days[forIndex]);
        }
    }
}
