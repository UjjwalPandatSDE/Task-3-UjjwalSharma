import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {

    // A static map to store our predefined exchange rates relative to a base currency (USD)
    private static final HashMap<String, Double> exchangeRates = new HashMap<>();

    static {
        // Exchange rates relative to 1 USD (Base reference)
        exchangeRates.put("USD", 1.0);      // US Dollar
        exchangeRates.put("EUR", 0.92);     // Euro
        exchangeRates.put("INR", 83.50);    // Indian Rupee
        exchangeRates.put("GBP", 0.79);     // British Pound
        exchangeRates.put("JPY", 155.20);   // Japanese Yen
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("       💱 CURRENCY CONVERTER CLI 💱       ");
        System.out.println("=========================================");
        
        // 1. Display available currencies
        System.out.println("Available Currencies: " + exchangeRates.keySet());
        System.out.println("-----------------------------------------");

        // 2. Get and validate Base Currency
        String baseCurrency = "";
        while (true) {
            System.out.print("Enter Base Currency (from): ");
            baseCurrency = scanner.next().toUpperCase();
            if (exchangeRates.containsKey(baseCurrency)) {
                break;
            }
            System.out.println("❌ Invalid currency. Please choose from the list.");
        }

        // 3. Get and validate Target Currency
        String targetCurrency = "";
        while (true) {
            System.out.print("Enter Target Currency (to): ");
            targetCurrency = scanner.next().toUpperCase();
            if (exchangeRates.containsKey(targetCurrency)) {
                break;
            }
            System.out.println("❌ Invalid currency. Please choose from the list.");
        }

        // 4. Get and validate Amount
        double amount = 0;
        while (true) {
            System.out.print("Enter the amount to convert: ");
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (amount >= 0) {
                    break;
                }
                System.out.println("❌ Amount cannot be negative.");
            } else {
                System.out.println("❌ Invalid input. Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        }

        // 5. Perform the Conversion Arithmetic
        // Formula: Amount in Target = Amount * (Rate of Target / Rate of Base)
        double amountInUSD = amount / exchangeRates.get(baseCurrency);
        double convertedAmount = amountInUSD * exchangeRates.get(targetCurrency);

        // 6. Display Output Clearly
        System.out.println("-----------------------------------------");
        System.out.printf("🎉 Success: %.2f %s = %.2f %s\n", amount, baseCurrency, convertedAmount, targetCurrency);
        System.out.println("=========================================");

        scanner.close();
    }
}
