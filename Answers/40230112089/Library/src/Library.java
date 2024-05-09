import java.io.*;
import java.util.*;
public class Library {
    String libraryName;
    String libraryPassword;
    String workingHours;
    ArrayList<User> userArray = new ArrayList<>();
    ArrayList<Book> bookArray = new ArrayList<>();
    ArrayList<Rent> rentArray = new ArrayList<>();
    int usersId = 1;
    int booksId = 1;
    int rentsId = 1;
    public Library(String libraryName, String workingHours, String libraryPassword) {
        this.libraryName = libraryName;
        this.workingHours = workingHours;
        this.libraryPassword = libraryPassword;
        CheckFiles();
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
    public void CheckFiles() {
        try {
            File file1 = new File("rents.txt");
            File file2 = new File("Users.txt");
            File file3 = new File("Books.txt");
            boolean f1 = file1.createNewFile();
            boolean f2 = file2.createNewFile();
            boolean f3 = file3.createNewFile();
        } catch (Exception ignored) {
        }
    }
    public void fileSaver() {
        try {
            //کلاس FileOutputStream یک جریان خروجی برای نوشتن داده‌ها به یک فایل فراهم می‌کند.
            FileOutputStream fileOutput1 = new FileOutputStream("Books.txt");
            //کلاس ObjectOutputStream در جاوا یک جریان خروجی است که می‌تواند اشیاء جاوا را به یک جریان خروجی باینری بنویسد
            ObjectOutputStream objOutput1 = new ObjectOutputStream(fileOutput1);
            //به فایل می نویسد ان جریان باینری را
            objOutput1.writeObject(this.bookArray);
            FileOutputStream fileOutput2 = new FileOutputStream("Users.txt");
            ObjectOutputStream objOutput2 = new ObjectOutputStream(fileOutput2);
            objOutput2.writeObject(this.userArray);
            FileOutputStream fileOutput3 = new FileOutputStream("Rents.txt");
            ObjectOutputStream objOutput3 = new ObjectOutputStream(fileOutput3);
            objOutput3.writeObject(this.rentArray);
        } catch (Exception ignored) {
        }
    }
}
