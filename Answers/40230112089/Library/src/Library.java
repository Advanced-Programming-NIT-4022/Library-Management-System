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
        checkFiles();
        fileUpdater();
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
    public void checkFiles() {
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
            fileOutput1.close();
            objOutput1.close();
            FileOutputStream fileOutput2 = new FileOutputStream("Users.txt");
            ObjectOutputStream objOutput2 = new ObjectOutputStream(fileOutput2);
            objOutput2.writeObject(this.userArray);
            fileOutput2.close();
            objOutput2.close();
            FileOutputStream fileOutput3 = new FileOutputStream("Rents.txt");
            ObjectOutputStream objOutput3 = new ObjectOutputStream(fileOutput3);
            objOutput3.writeObject(this.rentArray);
            fileOutput3.close();
            objOutput3.close();
        } catch (Exception ignored) {
        }
    }
    public void fileUpdater() {
        try {
            //داده ها را از فایل باینری میخوانیم
            FileInputStream fileInput1 = new FileInputStream("Books.txt");
            //خواندن اشیا سریالیزه از جریان ورودی
            ObjectInputStream objInput1 = new ObjectInputStream(fileInput1);
            this.bookArray = (ArrayList<Book>) objInput1.readObject();
            //دستورات ObjectInputStream را بسته و فایل را ازاد میکند
            fileInput1.close();
            objInput1.close();
            FileInputStream fileInput2 = new FileInputStream("Users.txt");
            ObjectInputStream objInput2 = new ObjectInputStream(fileInput2);
            this.userArray = (ArrayList<User>) objInput2.readObject();
            fileInput2.close();
            objInput2.close();
            FileInputStream fileInput3 = new FileInputStream("Rents.txt");
            ObjectInputStream objInput3 = new ObjectInputStream(fileInput3);
            this.rentArray = (ArrayList<Rent>) objInput3.readObject();
            fileInput3.close();
            objInput3.close();
        } catch (Exception ignored) {
        }
    }
    public boolean checkUserId(int userId) {
        boolean result = false;
        for (int i = 0; i < this.userArray.size(); i++) {
            if (this.userArray.get(i).userId == userId) {
                result = true;
            }
        }
        return result;
    }

    public boolean checkPassword() {
        Scanner input = new Scanner(System.in);
        System.out.print("enter Library password : ");
        String password = input.nextLine();
        return libraryPassword.equals(password);
    }
    public boolean userCheckPassword(int userid) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter User password: ");
        String userPassword = input.nextLine();
        return this.userArray.get(userid - 1).password.equals(userPassword);
    }
    public boolean checkBookId(int bookId) {
        boolean result = false;
        for (int i = 0; i < this.bookArray.size(); i++) {
            if (this.bookArray.get(i).bookId == bookId) {
                result = true;
                break;
            }
        }
        return result;
    }
    public void addBook(String bookName, String bookAuthor) {
        if (!checkPassword()) {
            System.out.println("Wrong Password");
            return;
        }
        Book book = new Book(bookName, bookAuthor, this.booksId, true);
        this.booksId++;
        this.bookArray.add(book);
        System.out.println("Book id : " + book.bookId);
        System.out.println(" Book added");
        fileSaver();
    }
    public void removeBook(int bookId) {
        if (!checkBookId(bookId)) {
            System.out.println("Wrong Book");
            return;
        }
        if (!checkPassword()) {
            System.out.println("Wrong Password");
            return;
        }
        for (int i = 0; i < this.bookArray.size(); i++) {
            if (this.bookArray.get(i).bookId == bookId) {
                this.bookArray.remove(i);
                break;
            }
        }
        System.out.println(" Book removed");
        fileSaver();
    }
}
