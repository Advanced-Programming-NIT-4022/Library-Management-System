import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Library {
     private final List<Book> books = new ArrayList<>();
     private final List<Admin> admins = new ArrayList<>();
     private final List<User> users = new ArrayList<>();
     private final List<Rent> rents = new ArrayList<>();


     private static final String Book_FILE_NAME = "Books.dat";
     private static final String Admin_FILE_NAME = "Admins.dat";
     private static final String User_FILE_NAME = "Users.dat";
     private static final String Rent_FILE_NAME = "Rents.dat";


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
          loadBooks();
          loadAdmins();
          loadUsers();
          loadRents();
     }
     public boolean isAdminEmpty(){
          return admins.isEmpty();
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
     public void rentSpecificBook(String bookName,String memberName,String memberID){
          int x=0,y=0;
          boolean bookFound =false;
          boolean userFound =false;
          for (int i = 0; i < books.size(); i++) {
               if (books.get(i).getTitle().equalsIgnoreCase(bookName)){
                    x = i;
               bookFound = true;
               }

          }
          for (int i = 0; i < users.size(); i++) {
               if (users.get(i).getID().equalsIgnoreCase(memberID)) {
                    y = i;
                    userFound = true;
               }
          }
          if (bookFound && userFound){
          createRent(books.get(x),users.get(y));
     } else {
               System.out.println("Error renting book!");
          }
     }
     public void returnBook(String title) {
               boolean found = false;
               for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).getTitle().equalsIgnoreCase(title)){
                         books.get(i).setAvailability(true);
                         saveBooks();
                         System.out.println("Book returned successfully.");
                         deleteRent(title);
                         found = true;
                         break;
                    }
               }
               if (!found) {
                    System.out.println("error returning book!");
               }
     }

     public void getAvailableBooks(){
          for (int i = 0; i < books.size(); i++) {
               if (books.get(i).isAvailability()){
                    System.out.println(books.get(i).toString());
               }
          }
     }
     private void saveBooks() {
          try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Book_FILE_NAME))) {
               oos.writeObject(books);
          } catch (IOException e) {
               System.out.println("Error saving books: " + e.getMessage());
          }
     }
     @SuppressWarnings("unchecked")
     private void loadBooks(){
          File file = new File(Book_FILE_NAME);
          if (file.exists()){
               try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Book_FILE_NAME))){
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
     public boolean checkUser(String fullName,String ID){
          boolean found = false;
          for (int i = 0; i < users.size(); i++) {
               if (users.get(i).getFullName().equalsIgnoreCase(fullName) && users.get(i).getID().equalsIgnoreCase(ID))
                    found = true;
          }
          return found;
     }
     private void saveUsers(){
          try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(User_FILE_NAME))){
               oos.writeObject(users);
          } catch (IOException e) {
               System.out.println("Error saving users: " + e.getMessage());
          }
     }
     @SuppressWarnings("unchecked")
     private void loadUsers(){
          File file = new File(User_FILE_NAME);
          if (file.exists()){
               try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(User_FILE_NAME))){
                    Object object = ois.readObject();
                    if (object instanceof List) {
                         users.addAll((List<User>) object);
                    }
               } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Error loading users: " + e.getMessage());
               }
          }
     }
     //----------------------------------------------------------------------------------------------------------
     //Admin registries
     public void addAdmin(String fullName,String phoneNumber,String password){
          admins.add(new Admin(fullName,phoneNumber,password));
          admins.sort(Comparator.comparing(Admin::getFullName));
          saveAdmins();
          System.out.println("Admin " + fullName + " added successfully.");
     }
     public void removeAdmin(String ID){
          boolean found = false;
          for (int i = 0; i < admins.size(); i++) {
               if (admins.get(i).getID().equalsIgnoreCase(ID)){
                    admins.remove(admins.get(i));
                    saveUsers();
                    System.out.println("Admin " + admins.get(i).getFullName() + " removed successfully.");
                    found = true;
                    break;
               }
          }
          if (!found){
               System.out.println("Error removing admin!");
          }
     }
     public boolean checkAdmin(String fullName,String ID,String Password){
          boolean found = false;
          for (int i = 0; i < admins.size(); i++) {
               if (admins.get(i).getFullName().equalsIgnoreCase(fullName) && admins.get(i).getID().equalsIgnoreCase(ID) && admins.get(i).getPassword().equalsIgnoreCase(Password))
               found = true;
          }
          return found;
     }

     private void saveAdmins(){
          try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Admin_FILE_NAME))){
               oos.writeObject(admins);
          } catch (IOException e) {
               System.out.println("Error saving admins: " + e.getMessage());
          }
     }
     @SuppressWarnings("unchecked")
     private void loadAdmins(){
          File file = new File(Admin_FILE_NAME);
          if (file.exists()){
               try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Admin_FILE_NAME))){
                    Object object = ois.readObject();
                    if (object instanceof List) {
                         admins.addAll((List<Admin>) object);
                    }
               } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Error loading admins: " + e.getMessage());
               }
          }
     }

     //----------------------------------------------------------------------------------------------------------
     //Rents registries

     public void createRent(Book book,User user){
          rents.add(new Rent(book,user));
          rentBook(book.getTitle());
          saveRents();
     }
     public void deleteRent(String title){
          for (int i = 0; i < rents.size(); i++) {
               if (rents.get(i).getBook().getTitle().equalsIgnoreCase(title)){
                    rents.remove(rents.get(i));
                    saveRents();
                    break;
               }
          }
     }
     public void showRents(){
          for (int i = 0; i < rents.size(); i++) {
               System.out.println(rents.get(i).toString());
          }
     }

     private void saveRents(){
          try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Rent_FILE_NAME))){
               oos.writeObject(rents);
          } catch (IOException e) {
               System.out.println("Error saving rents: " + e.getMessage());
          }
     }

     @SuppressWarnings("unchecked")
     private void loadRents(){
          File file = new File(Rent_FILE_NAME);
          if (file.exists()){
               try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Rent_FILE_NAME))){
                    Object object = ois.readObject();
                    if (object instanceof List) {
                         rents.addAll((List<Rent>) object);
                    }
               } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Error loading rents: " + e.getMessage());
               }
          }
     }

}