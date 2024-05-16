import java.util.ArrayList;
import java.util.List;

class Library {
    private String name;
    private int capacity;
    private String operatingHours;
    private static List<Book> books;
    private List<Rent> rents;
    private List<User> users;

    public Library(String name, int capacity, String operatingHours) {
        this.name = name;
        this.capacity = capacity;
        this.operatingHours = operatingHours;
        this.books = new ArrayList<>();
        this.rents = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (books.size() < capacity) {
            books.add(book);
            System.out.println("Book added to the library: " + book.getTitle());
        } else {
            System.out.println("Library is at full capacity. Cannot add more books.");
        }
    }
        public static Book findBookById(int Id){
        for (Book book : books){
            if(book.getBookID() == Id){
                book.setAvailability(false);
                System.out.println("Book found "+book.getTitle());
                return book;
            }
        }
        System.out.println("Book not found in library");
        return null;
    }

    public static void lendBook(int bookId, String borrower) {
        Book book = findBookById(bookId);
        if (book != null && !book.isOnLoan()) {
            book.setOnLoan(true, borrower);
            System.out.println("Book with ID " + bookId + " has been lent to " + borrower);
        } else if (book != null && book.isOnLoan()) {
            System.out.println("Book with ID " + bookId + " is already on loan");
        } else {
            System.out.println("Book with ID " + bookId + " not found in the library");
        }
    }
    public static Book returnBook(int bookId) {
        for (Book book : books){
            if(book.getBookID() == bookId){
                book.setAvailability(true);
                System.out.println("Book found "+book.getTitle());
                return book;
            }
        }
        System.out.println("Book not found in library");
        return null;
    }
}

