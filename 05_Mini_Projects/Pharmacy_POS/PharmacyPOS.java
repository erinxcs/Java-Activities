// CARL JAYSON ELI BONAOBRA
// CPE2A
// Mini Project: Pharmacy Point-of-Sale (POS) System

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PharmacyPOS {

    private static final double VAT_RATE = 0.12;
    private static final double DISCOUNT_RATE = 0.20;

    static class Medicine {
        private final String name;
        private final double price;
        private final boolean vatExempt;

        Medicine(String name, double price, boolean vatExempt) {
            this.name = name;
            this.price = price;
            this.vatExempt = vatExempt;
        }
    }

    static class CartItem {
        private final Medicine medicine;
        private final int quantity;

        CartItem(Medicine medicine, int quantity) {
            this.medicine = medicine;
            this.quantity = quantity;
        }
    }

    public static void main(String[] args) {
        Map<String, Medicine> inventory = createInventory();
        List<CartItem> cart = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Welcome to Botika POS ===");
            displayInventory(inventory);
            collectItems(scanner, inventory, cart);

            if (cart.isEmpty()) {
                System.out.println("\nNo items were added. Transaction cancelled.");
                return;
            }

            boolean hasDiscount = readYesNo(
                    scanner,
                    "\nIs the customer a PWD/Senior Citizen? (yes/no): "
            );

            double subtotal = printReceiptAndGetSubtotal(cart);
            double discount = hasDiscount ? subtotal * DISCOUNT_RATE : 0.0;
            double total = subtotal - discount;

            System.out.printf("%nSubtotal: Php %.2f%n", subtotal);
            System.out.printf("PWD/Senior Discount: -Php %.2f%n", discount);
            System.out.printf("Total: Php %.2f%n", total);
            System.out.println("====================");

            double payment = readPayment(scanner, total);
            double change = payment - total;

            System.out.printf("Change: Php %.2f%n", change);
            System.out.println("====================");
        }
    }

    private static Map<String, Medicine> createInventory() {
        Map<String, Medicine> inventory = new LinkedHashMap<>();

        inventory.put("biogesic", new Medicine("Biogesic (Paracetamol)", 5.00, true));
        inventory.put("amoxil", new Medicine("Amoxil (Amoxicillin)", 12.00, false));
        inventory.put("glucophage", new Medicine("Glucophage (Metformin)", 8.50, true));
        inventory.put("alerfed", new Medicine("Alerfed (Cetirizine)", 6.25, false));
        inventory.put("cozaar", new Medicine("Cozaar (Losartan)", 10.75, true));
        inventory.put("losec", new Medicine("Losec (Omeprazole)", 7.00, false));
        inventory.put("lipitor", new Medicine("Lipitor (Atorvastatin)", 11.50, true));
        inventory.put("ventolin", new Medicine("Ventolin Inhaler", 28.00, false));
        inventory.put("norvasc", new Medicine("Norvasc (Amlodipine)", 9.25, true));
        inventory.put("diatabs", new Medicine("Diatabs (Loperamide)", 4.00, false));

        return inventory;
    }

    private static void displayInventory(Map<String, Medicine> inventory) {
        System.out.println("\nAvailable Medicines:");
        System.out.printf("%-15s %-30s %-12s%n", "Keyword", "Brand Name", "Price");
        System.out.println("------------------------------------------------------------");

        for (Map.Entry<String, Medicine> entry : inventory.entrySet()) {
            Medicine medicine = entry.getValue();
            System.out.printf(
                    "%-15s %-30s Php %-8.2f%n",
                    entry.getKey(),
                    medicine.name,
                    medicine.price
            );
        }
    }

    private static void collectItems(
            Scanner scanner,
            Map<String, Medicine> inventory,
            List<CartItem> cart
    ) {
        while (true) {
            System.out.print("\nEnter medicine keyword (or 'done' to finish): ");
            String keyword = scanner.nextLine().trim().toLowerCase();

            if (keyword.equals("done")) {
                break;
            }

            Medicine medicine = inventory.get(keyword);
            if (medicine == null) {
                System.out.println("Medicine not found. Please use a keyword from the list.");
                continue;
            }

            int quantity = readPositiveInteger(scanner, "Enter quantity: ");
            cart.add(new CartItem(medicine, quantity));
            System.out.println("Added: " + medicine.name + " x" + quantity);
        }
    }

    private static double printReceiptAndGetSubtotal(List<CartItem> cart) {
        double subtotal = 0.0;

        System.out.println("\n=== RECEIPT ===");

        for (CartItem item : cart) {
            Medicine medicine = item.medicine;
            double linePrice = medicine.price * item.quantity;

            // Preserve the original activity's behavior for non-VAT-exempt items.
            double vatDeduction = medicine.vatExempt ? 0.0 : linePrice * VAT_RATE;
            double lineTotal = linePrice - vatDeduction;

            System.out.printf(
                    "%-30s x%-2d Php %.2f",
                    medicine.name,
                    item.quantity,
                    lineTotal
            );

            if (!medicine.vatExempt) {
                System.out.print(" (VAT deducted)");
            }

            System.out.println();
            subtotal += lineTotal;
        }

        return subtotal;
    }

    private static int readPositiveInteger(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                int value = Integer.parseInt(input);
                if (value > 0) {
                    return value;
                }
            } catch (NumberFormatException ignored) {
                // Continue to the validation message below.
            }

            System.out.println("Invalid quantity. Please enter a positive whole number.");
        }
    }

    private static boolean readYesNo(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String answer = scanner.nextLine().trim();

            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                return true;
            }

            if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                return false;
            }

            System.out.println("Please answer yes or no.");
        }
    }

    private static double readPayment(Scanner scanner, double total) {
        while (true) {
            System.out.print("\nEnter payment amount: Php ");
            String input = scanner.nextLine().trim();

            try {
                double payment = Double.parseDouble(input);
                if (payment >= total) {
                    return payment;
                }
            } catch (NumberFormatException ignored) {
                // Continue to the validation message below.
            }

            System.out.printf(
                    "Invalid or insufficient payment. Enter at least Php %.2f.%n",
                    total
            );
        }
    }
}
