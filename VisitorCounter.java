public class VisitorCounter {
    // Static variable to count total visitors (shared between all objects)
    private static int totalVisitors = 0;

    // Non-static variables for each visitor
    private int sessionVisits;
    private String visitorName;

    // Constructor
    public VisitorCounter(String name) {
        this.visitorName = name;
        this.sessionVisits = 0;
        totalVisitors++; // Increases the total number of visitors when a new one is created
    }

    // Non-static method to record a visit
    public void recordVisit() {
        sessionVisits++;
        System.out.println(visitorName + " visited. Session visits: " + sessionVisits);
    }

    // Static method to display the total visitors
    public static void displayTotalVisitors() {
        System.out.println("Total visitors today: " + totalVisitors);
    }

    // Static method to get total visitors (getter)
    public static int getTotalVisitors() {
        return totalVisitors;
    }

    // Main method to test everything
    public static void main(String[] args) {
        // Creating 3 visitors
        VisitorCounter visitor1 = new VisitorCounter("Sara");
        VisitorCounter visitor2 = new VisitorCounter("Ali");
        VisitorCounter visitor3 = new VisitorCounter("Mona");

        // Recording visits
        visitor1.recordVisit();
        visitor1.recordVisit();

        visitor2.recordVisit();

        visitor3.recordVisit();
        visitor3.recordVisit();
        visitor3.recordVisit();

        // Displaying total number of visitors
        VisitorCounter.displayTotalVisitors();
    }
}
