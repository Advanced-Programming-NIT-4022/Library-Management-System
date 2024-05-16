import java.util.ArrayList;

class Lib {
    // Attributes
    private String operatingHrs;
    private ArrayList<Book> books;
    private ArrayList<User> users;

    // Constructor
    public Lib(String operating_hrs) {
        operatingHrs = operating_hrs;
        books = new ArrayList<Book>();
        users = new ArrayList<User>();
    }

    // Methods
    public String getOperatingHrs() {
        return operatingHrs;
    }

    public void addBook(Book b) {
        books.add(b);
    }

    public Book getBook(String name) {
        for (Book b : books) {
            if (b.getTitle().equals(name)) {
                return b;
            }
        }
        return null;
    }

    public void showBooks() {
        for (Book b : books) {
            b.showBook();
        }
    }
}
