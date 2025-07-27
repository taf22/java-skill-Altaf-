// Main class to run the program
public class Library {
    public static void main(String[] args) {
        // Create 2 regular books
        Book book1 = new Book("The Alchemist", "Paulo Coelho", 200);
        Book book2 = new Book("1984", "George Orwell", 328);

        // Create 1 textbook
        Textbook textbook1 = new Textbook("Java Programming", "James Gosling", 500, "Computer Science", 3);

        // Borrow and return books
        book1.borrowBook(); // should borrow
        book1.borrowBook(); // already borrowed
        book1.returnBook(); // return

        // Display all info
        System.out.println("\n--- Book 1 Info ---");
        book1.displayInfo();

        System.out.println("\n--- Book 2 Info ---");
        book2.displayInfo();

        System.out.println("\n--- Textbook Info ---");
        textbook1.displayInfo();
    }
}

// Base class
class Book {
    protected String title;
    protected String author;
    protected int pages;
    protected boolean isAvailable;

    // Constructor
    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.isAvailable = true; // default to available
    }

    // Basic methods
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println(title + " has been returned.");
    }

    public void displayInfo() {
        System.out.println(" Title: " + title);
        System.out.println("️ Author: " + author);
        System.out.println("Pages: " + pages);
        System.out.println(" Available: " + isAvailable);
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPages() { return pages; }
    public boolean getIsAvailable() { return isAvailable; }
}

// Child class
class Textbook extends Book {
    private String subject;
    private int edition;

    // Constructor
    public Textbook(String title, String author, int pages, String subject, int edition) {
        super(title, author, pages); // call parent constructor
        this.subject = subject;
        this.edition = edition;
    }

    // Override displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo(); // show basic book info
        System.out.println(" Subject: " + subject);
        System.out.println(" Edition: " + edition);
    }

    // Getters
    public String getSubject() { return subject; }
    public int getEdition() { return edition; }
}
