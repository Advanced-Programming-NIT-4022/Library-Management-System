import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Rent {
    public static void rent(int bookID, int userID) {
        NormalUsers.normalUsersArray.get(userID).rentBooks = NormalUsers.normalUsersArray.get(userID).rentBooks + Book.booksArray.get(bookID).title + "#";
        Book.booksArray.get(bookID).availabilityStatus = false;
    }
    public static  void  copyRentFile() {
        try {
            ArrayList<String> rentArray = new ArrayList<>();
            File rent = new File("C:\\Users\\MSI\\OneDrive\\Desktop\\Lib\\Library-Management-System\\Answers\\Library\\src\\rent.txt");
            Scanner reader = new Scanner(rent);
            while (reader.hasNextLine()) {
                rentArray.add(reader.nextLine());
            }
        } catch (Exception e) {
            System.out.println("sorry");
        }
    }
    public static boolean checkRent(int bookID) {
        return Book.booksArray.get(bookID).availabilityStatus;
    }
    public static boolean returnRent(String bookName){
        int bookID=Book.getBookID(bookName);
        if(bookID == (-1)){
            System.out.println("The desired book was not found");
            return false;
        }
        if (Book.booksArray.get(bookID).availabilityStatus){
            System.out.println("This book had not been rented");
            return false;
        }
        Book.booksArray.get(bookID).availabilityStatus = true;
        for ( int i=0 ; i< NormalUsers.normalUsersArray.size() ;i++){
            String[] rentbook = NormalUsers.normalUsersArray.get(i).rentBooks.split("#");
            for (int j=0 ; j < rentbook.length ; j++){
                if (rentbook[j].equals(bookName)){
                    NormalUsers.normalUsersArray.get(i).rentBooks = NormalUsers.normalUsersArray.get(i).rentBooks.replace(bookName,"");
                    return true;
                }
            }
        }
        System.out.println("eror rented book not found");
        return false;
    }

    public static void returnAllBooks(int userID){
        int rentbooks = NormalUsers.normalUsersArray.get(userID).rentBooks.split("#").length;
        int rentedbooks = Book.booksArray.size();
        for (int i=0 ; i< rentbooks ; i++){
            for(int j=0 ; j< rentedbooks;j++){
                if (NormalUsers.normalUsersArray.get(userID).rentBooks.split("#")[i].equals(Book.booksArray.get(j).title)){
                    Book.booksArray.get(j).availabilityStatus = true;
                }
            }
        }
    }
}

