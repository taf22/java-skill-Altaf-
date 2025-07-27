public class PayrollCalculator {

    // Method to calculate weekly pay based on employee type and hours
    public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate) {
        switch (employeeType.toUpperCase()) {
            case "FULL_TIME":
                if (hoursWorked <= 40) {
                    return hoursWorked * hourlyRate;
                } else {
                    double overtime = (hoursWorked - 40) * hourlyRate * 1.5;
                    return (40 * hourlyRate) + overtime;
                }

            case "PART_TIME":
                if (hoursWorked > 25) {
                    hoursWorked = 25; // Cap at 25 hours
                }
                return hoursWorked * hourlyRate;

            case "CONTRACTOR":
                return hoursWorked * hourlyRate;

            case "INTERN":
                if (hoursWorked > 20) {
                    hoursWorked = 20; // Cap at 20 hours
                }
                return hoursWorked * (hourlyRate * 0.8); // 20% discount

            default:
                System.out.println("Invalid employee type!");
                return 0;
        }
    }

    // Method to calculate tax deduction based on pay brackets
    public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance) {
        double tax;
        if (grossPay <= 500) {
            tax = grossPay * 0.10;
        } else if (grossPay <= 1000) {
            tax = grossPay * 0.15;
        } else if (grossPay <= 2000) {
            tax = grossPay * 0.20;
        } else {
            tax = grossPay * 0.25;
        }

        if (hasHealthInsurance) {
            tax -= 50;
        }

        return Math.max(tax, 0); // Don't allow negative tax
    }

    // Method to process multiple employees and find statistics
    public static void processPayroll(String[] employeeTypes, double[] hours, double[] rates, String[] names) {
        double totalPay = 0;
        double highestPay = Double.MIN_VALUE;
        double lowestPay = Double.MAX_VALUE;
        String highestPaid = "";
        String lowestPaid = "";
        int overtimeCount = 0;

        System.out.println("Employee Payroll Report:");
        System.out.println("-----------------------------------------------------------");
        System.out.printf("%-10s %-12s %-10s %-10s %-10s\n", "Name", "Type", "Hours", "Pay", "Tax");

        for (int i = 0; i < names.length; i++) {
            if (i >= employeeTypes.length || i >= hours.length || i >= rates.length) {
                System.out.println("Data mismatch at index " + i);
                continue;
            }

            double grossPay = calculateWeeklyPay(employeeTypes[i], hours[i], rates[i]);
            double tax = calculateTaxDeduction(grossPay, true);
            double netPay = grossPay - tax;

            System.out.printf("%-10s %-12s %-10.2f %-10.2f %-10.2f\n",
                    names[i], employeeTypes[i], hours[i], grossPay, tax);

            totalPay += netPay;

            if (grossPay > highestPay) {
                highestPay = grossPay;
                highestPaid = names[i];
            }

            if (grossPay < lowestPay) {
                lowestPay = grossPay;
                lowestPaid = names[i];
            }

            if (hours[i] > 40 && employeeTypes[i].equalsIgnoreCase("FULL_TIME")) {
                overtimeCount++;
            }
        }

        double averagePay = totalPay / names.length;

        System.out.println("-----------------------------------------------------------");
        System.out.println("Highest Paid: " + highestPaid + " ($" + highestPay + ")");
        System.out.println("Lowest Paid: " + lowestPaid + " ($" + lowestPay + ")");
        System.out.println("Average Net Pay: $" + averagePay);
        System.out.println("Overtime Employees: " + overtimeCount);
    }

    // MAIN method to test everything
    public static void main(String[] args) {
        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN", "FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};

        processPayroll(types, hours, rates, names);
    }
}
