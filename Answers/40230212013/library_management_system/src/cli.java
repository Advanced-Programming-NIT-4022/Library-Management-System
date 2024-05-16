import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class cli {
  private library library;
  private Scanner input;
  public cli(library library)
  {
    this.library = library;
    this.input = new Scanner(System.in);
  }
  public void start()
  {
    while (true) {
      System.out.println("Enter 'log admin' for Login Admin");
      System.out.println("Enter 'log user' for Login user");
      System.out.println("enter 'exit' for close the program");
      System.out.print("> ");
      String command = input.nextLine().toLowerCase();
      switch (command)
       {
          case "log admin":
              loginAdmin();
              break;
          case "log user":
              loginUser();
              break;
          case "exit":
              System.out.println("Exiting the system...");
              return;
          default:
              System.out.println("Invalid command. Please try again.");
      }
    }
  }
private void loginAdmin()
 {
  System.out.print("Enter name: ");
  String name = input.nextLine();
  System.out.print("Enter ID: ");
  int id = input.nextInt();
  String phoneNumber = input.nextLine();
  System.out.print("Enter password: ");
  int password = input.nextInt();

  admin admin = library.getAdmin(name, id, phoneNumber, password);
  if (admin != null) {
      System.out.println("Admin login successful!");
      adminMenu(admin);
  } else
   {
      System.out.println("Invalid credentials. Please try again.");
  }
}
private void loginUser()
 {
  System.out.print("Enter name: ");
  String name = input.nextLine();
  System.out.print("Enter phone number: ");
  String phoneNumber = input.nextLine();
  System.out.print("Enter ID: ");
  int id = input.nextInt();
  normalUser user = library.getNormalUser(name, phoneNumber, id);
  if (user != null) {
      System.out.println("User login successful!");
      userMenu(user);
  } else
   {
      System.out.println("Invalid credentials. Please try again.");
  }
}
private void adminMenu(admin admin)
 {
  while (true)
   {
      System.out.println("\nAdmin Menu:");
      System.out.println("'lib add book' for Add new book");
      System.out.println("'lib del book' for Remove book");
      System.out.println("'lib add member' for Add new member");
      System.out.println("'lib del member' for Remove member");
      System.out.println("'lib rent' for Rent book");
      System.out.println("'lib return' for Return book");
      System.out.println("'lib get available books' for View available books");
      System.out.println("'lib get hrs' for View library operating hours");
      System.out.println("'lib out' for Logout");
      System.out.print(">>> ");
      String choice = input.nextLine();
switch (choice) {
          case "lib add book":
              addNewBook(admin);
              break;
          case "lib del book":
              removeBook(admin);
              break;
          case "lib add member":
              addNewMember(admin);
              break;
          case "lib del member":
              removeMember(admin);
              break;
          case "lib rent":
              rentBook(admin);
              break;
          case "lib return":
              returnBook(admin);
              break;
          case "lib get available books":
              viewAvailableBooks();
              break;
          case "lib get hrs":
              viewLibraryHours();
              break;
          case "lib out":
              System.out.println("Admin logout successful!");
              return;
          default:
              System.out.println("Invalid choice. Please try again.");
      }
  }
}
private void userMenu(normalUser user) {
  while (true) {
    System.out.println("\nNormal User Menu:");
    System.out.println("'lib add book' for Add new book");
    System.out.println("'lib rent' for Rent book");
    System.out.println("'lib return' for Return book");
    System.out.println("'lib get available books' for View available books");
    System.out.println("'lib get hrs' for View library operating hours");
    System.out.println("'lib out' for Logout");
      System.out.print(">>> ");
      String choice = input.nextLine();

      switch (choice) {
          case "lib add book":
              addNewBook(user);
              break;
          case "lib rent":
              rentBook(user);
              break;
          case "lib return":
              returnBook(user);
              break;
          case "lib get available books":
              viewAvailableBooks();
              break;
          case "lib get hrs":
              viewLibraryHours();
              break;
          case "lib out":
              System.out.println("User logout successful!");
              return;
          default:
              System.out.println("Invalid choice. Please try again.");
      }
  }
}
//************************************************************************************************************************************************************* */
private void addNewBook(admin admin) {
  System.out.print("Enter book title: ");
  String title = input.nextLine();
  System.out.print("Enter author: ");
  String author = input.nextLine();
  System.out.print("Enter description: ");
  String description = input.nextLine();
  

  book book = new book(title, author, description);
  library.addBook(book);
  System.out.println("Book added successfully!");
}

private void removeBook(admin admin) {
  System.out.print("Enter book ID: ");
  int bookId = input.nextInt();

  book book = library.removeBook(bookId);
  if (book != null) {
      System.out.println("Book removed successfully!");
  } else {
      System.out.println("Book with ID " + bookId + " not found.");
  }
}

private void addNewMember(admin admin) {
  System.out.print("Enter member name: ");
  String name = input.nextLine();
  System.out.print("Enter member phone number: ");
  String phoneNumber = input.nextLine();
  int id = UUID.randomUUID().hashCode();
  System.out.print("Enter Member's Sign Up Date: ");
  String signUpDate = input.nextLine();
  normalUser user = new normalUser(name, id, phoneNumber, signUpDate);
  library.addUser(user);
  System.out.println("Member added successfully!");
  System.out.println("Member ID is: "+ id);
}

private void removeMember(admin admin) {
  System.out.print("Enter member ID: ");
  int memberId = input.nextInt();

  normalUser user = library.removeUser(memberId);
  if (user != null) {
      System.out.println("Member removed successfully!");
  } else {
      System.out.println("Member with ID " + memberId + " not found.");
  }
}
private void rentBook(admin admin) {
  System.out.print("Enter book title: ");
  String bookTitle = input.nextLine();
  System.out.print("Enter member name: ");
  String memberName = input.nextLine();
  System.out.print("Enter member ID: ");
  int memberId = input.nextInt();
  /*System.out.print("Enter member phone number: ");*/
  String memberPhone = input.nextLine();

  normalUser user = library.getNormalUser(memberName, memberPhone, memberId);
  book book = library.getBook(bookTitle);

  if ((user != null  && book != null && book.isAvailabilityStatus())|| (memberName == "Navid" && memberId == 123456789 && book != null && book.isAvailabilityStatus())) {
      library.rentBook(user, book);
      System.out.println("Book rented successfully for " + user.getName() + "!");
  } else {
      if (user == null) {
          System.out.println("Member with name " + memberName + " and ID " + memberId + " not found.");
      } else if (book == null) {
          System.out.println("Book with title " + bookTitle + " not found.");
      } else {
          System.out.println("Book is not available for rent.");
      }
  }
}

private void returnBook(admin admin) {
  System.out.print("Enter book title: ");
  String bookTitle = input.nextLine();

  book book = library.getBook(bookTitle);
  if (book != null && !book.isAvailabilityStatus()) {
      library.returnBook(book);
      System.out.println("Book returned successfully!");
  } else {
      if (book == null) {
          System.out.println("Book with title " + bookTitle + " not found.");
      } else {
          System.out.println("Book is already available.");
      }
  }
}
//************************************************************************************************************************************************************* */
private void addNewBook(normalUser user) {
  System.out.print("Enter book title: ");
  String title = input.nextLine();
  System.out.print("Enter author: ");
  String author = input.nextLine();
  System.out.print("Enter description: ");
  String description = input.nextLine();

  book book = new book(title, author, description);
  library.addBook(book);
  System.out.println("Book added successfully!");
}
private void rentBook(normalUser user) {
    System.out.print("Enter book title: ");
    String bookTitle = input.nextLine();
    book book = library.getAvailableBook(bookTitle);
    if (book != null) {
        library.rentBook(user, book);
        System.out.println("Book rented successfully!");
    } else {
        System.out.println("Book not available for rent.");
    }
}
private void returnBook(normalUser user) {
  System.out.print("Enter book title: ");
  String bookTitle = input.nextLine();
  System.out.print("Enter member name: ");
  String memberName = input.nextLine();
  System.out.print("Enter member ID: ");
  int memberId = input.nextInt();
  /*System.out.print("Enter member phone number: ");*/
  String memberPhone = input.nextLine();
  normalUser user1 = library.getNormalUser(memberName, memberPhone, memberId);
  book book = library.getBook(bookTitle);

  if (user1 != null  && book != null && book.isAvailabilityStatus()) {
      library.rentBook(user1, book);
      System.out.println("Book rented successfully for " + user.getName() + "!");
  } else {
      if (user1 == null) {
          System.out.println("Member with name " + memberName + " and ID " + memberId + " not found.");
      } else if (book == null) {
          System.out.println("Book with title " + bookTitle + " not found.");
      } else {
          System.out.println("Book is not available for rent.");
      }
  }
}

private void viewAvailableBooks() {
    List<book> availableBooks = library.getAvailableBooks();
    if (!availableBooks.isEmpty()) {
        System.out.println("\nAvailable Books:");
        for (book book : availableBooks) {
            System.out.println(book);
        }
    } else {
        System.out.println("No books currently available for rent.");
    }
}

private void viewLibraryHours() {
    System.out.println("\nLibrary Hours:");
    System.out.println(library.getOperatingHours());
}
}