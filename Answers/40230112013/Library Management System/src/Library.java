import java.util.*;

public class Library {
    private static Map<User, Rent> rentRecords = new HashMap<User, Rent>();
    static String LibraryName;
    int Capacity;
    String Operating_hours;
    private static List<Book> repository = new ArrayList<Book>();
    private static List<User> users = new ArrayList<User>();

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

    public static void rentBook(Book book, User user, int rentDays) {
        if (repository.contains(book)) {
            Rent rent = new Rent(book, user, rentDays);
            rentRecords.put(user, rent);
            repository.remove(book);
            System.out.println("Book" + book.getTitle() + "from" + user.getName() + "Rented");
        } else {
            System.out.println("********************\nBook is not available");
        }
    }

    public static void returnBook(User user) {
        Rent rent = rentRecords.get(user);
        if (rent != null) {
            repository.add(rent.getBook());
            rentRecords.remove(user);
            System.out.println("The book " + rent.getBook().getTitle() + "ّ From " + user.getName() + " taken back.");
        } else {
            System.out.println("********************\nreturn book is faild");
        }
    }

    public static void showBook() {
        int i = 1;
        for (Book x : repository) {
            String p = x.toString1();
            System.out.println(i + "-" + p);
            i++;
        }
    }

    public static void showUser() {
        int i = 1;
        for (User x : users) {
            String p = x.toString2();
            System.out.println(i + "-" + p);
            i++;
        }
    }
}
