import java.io.*;
import java.util.*;

public class Library {
    static String LibraryName;
    int Capacity;
    String Operating_hours;
    private List<Book> repository = new ArrayList<>();

    public void addBook(Book book) {
        repository.add(book);
    }

    public void saveRepository() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("LibRepo.txt"))) {
            out.writeObject(repository);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadRepository() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("LibRepo.txt"))) {
            repository = (List<Book>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
