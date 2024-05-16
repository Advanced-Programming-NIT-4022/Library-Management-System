import java.util.ArrayList;
import java.util.List;

public class library {
  private String libraryName;
  private int capacity;
  private String operatingHours;
  private List<book> books;
  private List<normalUser> users;
  private List<rent> rentals;
  public library(String libraryName, int capacity, String operatingHours) {
      this.libraryName = libraryName;
      this.capacity = capacity;
      this.operatingHours = operatingHours;
      this.books = new ArrayList<>();
      this.users = new ArrayList<>();
      this.rentals = new ArrayList<>();
  }
  public String getLibraryName() {
    return libraryName;
  }
  public int getCapacity() {
    return capacity;
  }
  public String getOperatingHours() {
    return operatingHours;
  }
  public void addBook(book book) {
    if (books.size() < capacity) {
        books.add(book);
        System.out.println("Book added successfully!");
        System.out.println(book.getBookId());
    } else {
        System.out.println("Library at full capacity. Book cannot be added.");
    }
}
public book removeBook(int bookId) {
  book removedBook = null;
  for (int i = 0; i < books.size(); i++) {
      if (books.get(i).getBookId() == bookId) {
          removedBook = books.remove(i);
          break;
      }
  }
  if (removedBook != null) {
      System.out.println("Book removed successfully!");
  } else {
      System.out.println("Book with ID " + bookId + " not found.");
  }
  return removedBook;
}
public void addUser(normalUser user) {
  users.add(user);
  System.out.println("Member added successfully!");
}
public normalUser removeUser(int memberId) {
  normalUser removedUser = null;
  for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getId() == memberId) {
          removedUser = users.remove(i);
          break;
      }
  }
  if (removedUser != null) {
      System.out.println("Member removed successfully!");
  } else {
      System.out.println("Member with ID " + memberId + " not found.");
  }
  return removedUser;
}
public void rentBook(normalUser user, book book) {
  if (book.isAvailabilityStatus()) {
      rent rent = new rent(book, user);
      rentals.add(rent);
      book.setAvailabilityStatus(false);
      System.out.println("Book rented successfully for " + user.getName() + "!");
  } else {
      System.out.println("Book is not available for rent.");
  }
}
public void returnBook(book book) {
  boolean bookReturned = false;
  for (rent rent : rentals) {
      if (rent.getBook().equals(book)) {
          rentals.remove(rent);
          book.setAvailabilityStatus(true);
          bookReturned = true;
          System.out.println("Book returned successfully!");
          break;
      }
  }
  if (!bookReturned) {
      System.out.println("Book not found or not currently rented.");
  }
}

public book getBook(String bookTitle) {
  for (book book : books) {
      if (book.getTitle().equalsIgnoreCase(bookTitle)) {
          return book;
      }
  }
  return null;
}
public List<book> getAvailableBooks() {
  List<book> availableBooks = new ArrayList<>();
  for (book book : books) {
      if (book.isAvailabilityStatus()) {
          availableBooks.add(book);
      }
  }
  return availableBooks;
}
public book getAvailableBook(String bookTitle) {
  for (book book : books) {
      if (book.getTitle().equalsIgnoreCase(bookTitle) && book.isAvailabilityStatus()) {
          return book;
      }
  }
  return null;
}
public book getBorrowedBook(normalUser user, String bookTitle) {
  for (rent rent : rentals) {
      if (rent.getBook().getTitle().equalsIgnoreCase(bookTitle) && rent.getUser().equals(user)) {
          return rent.getBook();
      }
  }
  return null;
}
public admin getAdmin(String name, int id, String phoneNumber, int password) {
  admin admin1 = new admin("Navid", 123456789, "9204201533", 12345);
  
      if (admin1 instanceof admin && admin1.getName().equals(name) && admin1.getId() == id && ((admin) admin1).getPassword() == password) {
          return (admin) admin1;
      }
  return null;
}
public normalUser getNormalUser(String name, String phoneNumber, int id) {
  for (user user : users) {
      if (user instanceof normalUser && user.getName().equals(name) && user.getId() == id) {
          return (normalUser) user;
      }
      
  }
  return null;
}
}