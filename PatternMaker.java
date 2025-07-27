public class PatternMaker {

    // Print a number triangle
    public static void printNumberTriangle(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println(); // new line after each row
        }
    }

    // Print multiplication table
    public static void printMultiplicationTable(int number, int limit) {
        for (int i = 1; i <= limit; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
    }

    public static void main(String[] args) {
        printNumberTriangle(5); // Example output: 1 to 1 2 3 4 5 triangle
        System.out.println();
        printMultiplicationTable(7, 10); // Table from 7x1 to 7x10
    }
}

