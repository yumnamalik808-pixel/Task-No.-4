import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        // Mocked exchange rates
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("JPY", 110.0);
        exchangeRates.put("GBP", 0.75);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Currency selection
        System.out.println("Available currencies: USD, EUR, JPY, GBP");
        System.out.print("Select the base currency (e.g., USD): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Select the target currency (e.g., EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        // Amount input
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        // Currency conversion
        if (exchangeRates.containsKey(baseCurrency) && exchangeRates.containsKey(targetCurrency)) {
            double baseRate = exchangeRates.get(baseCurrency);
            double targetRate = exchangeRates.get(targetCurrency);
            double convertedAmount = (amount / baseRate) * targetRate;

            // Display result
            System.out.printf("%.2f %s is equal to %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);
        } else {
            System.out.println("Invalid currency selection.");
        }

        scanner.close();
    }
}
