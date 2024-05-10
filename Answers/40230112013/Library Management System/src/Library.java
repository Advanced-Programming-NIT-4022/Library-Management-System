import java.io.*;
import java.util.*;

public class Library {
    static String LibraryName;
    int Capacity;
    String Operating_hours;
    private static List<Book> repository = new ArrayList<>();
    private static List<User> users = new ArrayList<>();
    
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
    public static List<Book> getrepo(){
        return repository;
    }
    public static List<User> getuser(){
        return users;
    }

    public static void saveRepository() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("LibRepo.txt" , true))) {
            out.writeObject(repository);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void loadRepository() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("LibRepo.txt"))) {
            repository = (List<Book>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void saveusers() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Libuser.txt" , true))) {
            out.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void loadusers() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Libuser.txt"))) {
            users = (List<User>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
