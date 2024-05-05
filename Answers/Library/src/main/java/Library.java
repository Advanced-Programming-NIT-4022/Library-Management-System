import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Library {
     private final List<Book> books = new ArrayList<>();
     private final List<User> users = new ArrayList<>();
     private static final String FILE_NAME = "Library.dat";
     private String libName = "NIT";
     private static int capacity = 1250;
     private String operatinghours = "NIT library is open from 8 AM to 6 PM";
     public String getOperatinghours() {
          return operatinghours;
     }
     public String getLibName(){
          return libName;
     }
     public Library(){
          loadUsers();
          loadBooks();
     }
     public void addBook(String title, String author, String description){
          if (capacity > 0){
          books.add(new Book(title,author,description));
          capacity --;
          books.sort(Comparator.comparing(Book::getTitle));
          saveBooks();
          System.out.println("Book added to library successfully.");
          }else {
               System.out.println("There is no capacity to add books!");
          }
     }
     public void rentBook(String title){
          boolean found = false;
          for (int i = 0; i < books.size(); i++) {
               if (title.equalsIgnoreCase(books.get(i).getTitle()) && books.get(i).isAvailability()){
                    books.get(i).setAvailability(false);
                    saveBooks();
                    System.out.println(title + " book rented successfully.");
                    found = true;
                    break;
               }
          } if (!found){
                    System.out.println(title + " book is not available now!");
          }
     }
     public void returnBook() {
          Scanner scanner = new Scanner(System.in);
          while (true) {
               System.out.println("Please enter the title of the book you want to return:");
               String title = scanner.nextLine();
               boolean found = false;
               for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).getTitle().equalsIgnoreCase(title)){
                         books.get(i).setAvailability(true);
                         saveBooks();
                         System.out.println("Book returned successfully.");
                         found = true;
                         break;
                    }
               }
               if (!found) {
                    System.out.println("Book not found. Would you like to:");
                    System.out.println("1. Try again");
                    System.out.println("2. Cancel operation");
                    System.out.print("Enter option (1 or 2): ");
                    String option = scanner.nextLine();
                    if ("2".equals(option)) {
                         System.out.println("Operation cancelled.");
                         break;
                    }
               } else {
                    break;
               }
          }
          scanner.close();
     }

     public void getAvailableBooks(){
          for (int i = 0; i < books.size(); i++) {
               if (books.get(i).isAvailability()){
                    System.out.println(books.get(i).getTitle());
               }
          }
     }
     private void saveBooks() {
          try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
               oos.writeObject(books);
          } catch (IOException e) {
               System.out.println("Error saving books: " + e.getMessage());
          }
     }
     @SuppressWarnings("unchecked")
     private void loadBooks(){
          File file = new File(FILE_NAME);
          if (file.exists()){
               try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))){
                    Object object = ois.readObject();
                    if (object instanceof List) {
                         books.addAll((List<Book>) object);
                    }
               } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Error loading books: " + e.getMessage());
               }
          }
     }
     //----------------------------------------------------------------------------------------------------------
     //User registries
     public void addUser(String fullName,String phoneNumber){
          users.add(new User(fullName,phoneNumber));
          users.sort(Comparator.comparing(User::getFullName));
          saveUsers();
          System.out.println("User " + fullName + " added successfully.");
     }

     public void removeUser(String ID){
          boolean found = false;
          for (int i = 0; i < users.size(); i++) {
               if (users.get(i).getID().equalsIgnoreCase(ID)){
                    users.remove(users.get(i));
                    saveUsers();
                    System.out.println("User " + users.get(i).getFullName() + " removed successfully.");
                    found = true;
                    break;
               }
          }
          if (!found){
               System.out.println("Error removing user!");
          }
     }
     private void saveUsers(){
          try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
               oos.writeObject(users);
          } catch (IOException e) {
               System.out.println("Error saving users: " + e.getMessage());
          }
     }
     @SuppressWarnings("unchecked")
     private void loadUsers(){
          File file = new File(FILE_NAME);
          if (file.exists()){
               try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))){
                    Object object = ois.readObject();
                    if (object instanceof List) {
                         users.addAll((List<User>) object);
                    }
               } catch (IOException |ClassNotFoundException e) {
                    System.out.println("Error loading users: " + e.getMessage());
               }
          }
     }
}
