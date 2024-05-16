import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Rent extends Library {
    int registered_rentID = 4000;
    Book book = new Book();
    User user = new User();
    public void rent(int userID) {
        String bookname = "";
        do{
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter the name of the book.");
                bookname = sc.nextLine();
            }catch (Exception e) {
                System.out.println("Please try again.");
            }
        }while (bookname.isEmpty());
        if (book.checkIfAvailable(bookname)) {
            System.out.println("Please enter the ID of the desired book :");
            ArrayList<Integer> availablBookID = new ArrayList<>();
            availablBookID = book.availableIDs(bookname);
            int bookID = 0;
            do {
                try {
                    Scanner sc = new Scanner(System.in);
                    bookID = sc.nextInt();
                }catch (Exception e) {
                    System.out.println("Please enter a valid book ID :");
                }
            }while (bookID == 0 || !availablBookID.contains(bookID));
            rentalID_bookID.put(registered_rentID,bookID);
            rentalID_userID.put(registered_rentID,userID);
            rentalID_date.put(registered_rentID, LocalDateTime.now());
            //-----------------------------------------------------//
            permanentRentalID_bookID.put(registered_rentID,bookID);
            permanentRentalID_userID.put(registered_rentID,userID);
            permanentRentalID_date.put(registered_rentID,LocalDateTime.now());
            book.changeAvailability(bookID);
            registered_rentID++;
        }else {
            System.out.println("This book is currently unavailable.");
        }
    }
    public void rentForSb(String bookname) {
        if (book.checkIfAvailable(bookname)) {
            System.out.println("Please enter the ID of the desired book and the ID of the other member :");
            ArrayList<Integer> availablBookID = new ArrayList<>();
            availablBookID = book.availableIDs(bookname);
            int bookID = 0;
            int userID = 0;
            do {
                try {
                    Scanner sc = new Scanner(System.in);
                    Scanner bc = new Scanner(System.in);
                    System.out.println("Book ID :");
                    bookID = sc.nextInt();
                    System.out.println("User ID :");
                    userID = bc.nextInt();
                }catch (Exception e) {
                    System.out.println("Please enter a valid book ID or user ID :");
                }
            }while (bookID == 0 || userID==0 || !availablBookID.contains(bookID) || !user.userID_NameList.containsKey(userID));
            rentalID_bookID.put(registered_rentID,bookID);
            rentalID_userID.put(registered_rentID,userID);
            rentalID_date.put(registered_rentID,LocalDateTime.now());
            //-----------------------------------------------------//
            permanentRentalID_bookID.put(registered_rentID,bookID);
            permanentRentalID_userID.put(registered_rentID,userID);
            permanentRentalID_date.put(registered_rentID,LocalDateTime.now());
            registered_rentID++;
        }else {
            System.out.println("This book is currently unavailable.");
        }
    }
    public void returnBook(int userID) {
        System.out.println("Which book do you wish to return?");
        if (rentalID_userID.containsValue(userID)) {
            int rentID = getKey(userID,rentalID_userID);
            System.out.println("Rental ID | Book ID | Name | Date\n---------------------------------");
            for (int rid : rentalID_userID.keySet()) {
                if (rentalID_userID.get(rid) == userID) {
                    int bookID = rentalID_bookID.get(rid);
                    System.out.println(rid + " | " + bookID + " | " + book.getTitle(bookID) + " | " + rentalID_date.get(rentID));
                    System.out.println("---------------------------------");
                }
            }
            int selected = 0;
            do {
                try {
                    Scanner sc = new Scanner(System.in);
                    selected = sc.nextInt();
                }catch (Exception e) {
                    System.out.println("Error : Illegal entry.");
                }
            }while (selected == 0 || !rentalID_userID.containsKey(selected) || userID != rentalID_userID.get(selected));
            book.changeAvailability(rentalID_bookID.get(selected));
            rentalID_userID.remove(selected);
            rentalID_bookID.remove(selected);
            rentalID_date.remove(selected);
            System.out.println("Book returned successfully.");
        }else {
            System.out.println("You haven't rented a book yet ");
        }
    }
}
