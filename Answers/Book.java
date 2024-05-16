public class Book {
    private int bookID;
    private String title;
    private String author;
    private boolean availability;
    private String description;
    private boolean onLoan;
    private String borrower;
    private static int nextid = 1;

    public Book(String title, String author, String description) {
        this.bookID = nextid++;
        this.title = title;
        this.author = author;
        this.availability = true;
        this.description = description;
        this.onLoan = false;
        this.borrower = null;
    }

    public int getBookID() {
        return bookID;
    }

    public int getUniqueId() {
        return bookID;
    }
    public void setUniqueId(int bookID){
        this.bookID = bookID;
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability){
        this.availability = availability;
    }
    public String getDescription() {
        return description;
    }

    public boolean isOnLoan() {
        return onLoan;
    }

    public String getBorrower() {
        return borrower;
    }
    public void setOnLoan(boolean onLoan, String borrower) {
        this.onLoan = onLoan;
        this.borrower = borrower;
    }
    public String toString() {
        return "ID: "+bookID+ "\nTitle: " + title + "\nAuthor: " + author + "\nSubtitle: " + description +
                "\nAvailability: " + availability;
    }
}

