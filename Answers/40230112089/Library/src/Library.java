import java.util.*;
public class Library {
    String libraryName;
    String libraryPassword;
    String workingHours;
    ArrayList<User> userArray = new ArrayList<>();
    ArrayList<Book> bookArray = new ArrayList<>();
    ArrayList<Library> libArray = new ArrayList<>();
    ArrayList<Rent> rentArray = new ArrayList<>();
    int usersId = 0;
    int booksId = 0;
    int rentsId = 0;
    public Library(String libraryName, String workingHours, String libraryPassword) {
        this.libraryName = libraryName;
        this.workingHours = workingHours;
        this.libraryPassword = libraryPassword;
        if (!this.bookArray.isEmpty()) {
            booksId = this.bookArray.size() + 1;
        }
        if (!this.userArray.isEmpty()) {
            usersId = this.userArray.size() + 1;
        }
        if (!this.rentArray.isEmpty()) {
            rentsId = this.rentArray.size() + 1;
        }
    }
}
