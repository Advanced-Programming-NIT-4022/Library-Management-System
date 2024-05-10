import java.util.*;

public class Library {
    private Map<User, Rent> rentRecords;
    static String LibraryName;
    int Capacity;
    String Operating_hours;
    private static List<Book> repository = new ArrayList<>();
    private static List<User> users = new ArrayList<>();

    public Library() {
        @SuppressWarnings({ "rawtypes", "unused" })
        HashMap rentRecords = new HashMap<>();
    }

    public static void addBook(Book book) {
        repository.add(book);
    }

    public static void removeBook(Book book) {
        repository.remove(book);
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public static void removeUser(User user) {
        users.remove(user);
    }

    public static List<Book> getrepo() {
        return repository;
    }

    public static List<User> getuser() {
        return users;
    }

    public void rentBook(Book book, User user, int rentDays) {
        if (repository.contains(book)) {
            Rent rent = new Rent(book, user, rentDays);
            rentRecords.put(user, rent);
            repository.remove(book);
            System.out.println("Book" + book.getTitle() + "from" + user.getName() + "Rented");
        } else {
            System.out.println("********************\nBook is not available");
        }
    }

    public void returnBook(User user) {
        Rent rent = rentRecords.get(user);
        if (rent != null) {
            repository.add(rent.getBook());
            rentRecords.remove(user);
            System.out.println("The book" + rent.getBook().getTitle() + "ّFrom" + user.getName() + "taken back.");
        } else {
            System.out.println("********************\nreturn book is faild");
        }
    }
}
