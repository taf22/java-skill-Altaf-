public class ShoppingCart {

    // Calculate total price with discounts
    public static double calculateTotal(double[] prices, String customerType) {
        double total = 0;

        // Calculate sum of all prices using a loop
        for (double price : prices) {
            total += price;
        }

        // Apply discount based on customer type
        switch (customerType.toUpperCase()) {
            case "PREMIUM":
                total *= 0.9; // 10% discount
                break;
            case "VIP":
                total *= 0.8; // 20% discount
                break;
            case "REGULAR":
            default:
                // No discount
                break;
        }

        return total;
    }

    // Find most expensive item
    public static double findMostExpensive(double[] prices) {
        if (prices.length == 0) {
            return 0; // Handle empty array
        }

        double max = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > max) {
                max = prices[i];
            }
        }

        return max;
    }

    // Count items above a certain price
    public static int countExpensiveItems(double[] prices, double threshold) {
        int count = 0;
        for (double price : prices) {
            if (price > threshold) {
                count++;
            }
        }
        return count;
    }

    // Main method to test everything
    public static void main(String[] args) {
        double[] cart = {25.99, 45.50, 12.99, 89.99, 15.75};

        // Test with different customer types
        System.out.println("Regular customer total: $" + calculateTotal(cart, "REGULAR"));
        System.out.println("Premium customer total: $" + calculateTotal(cart, "PREMIUM"));
        System.out.println("VIP customer total: $" + calculateTotal(cart, "VIP"));

        // Find most expensive item
        System.out.println("Most expensive item: $" + findMostExpensive(cart));

        // Count items over $30
        System.out.println("Items over $30: " + countExpensiveItems(cart, 30.0));
    }
}

