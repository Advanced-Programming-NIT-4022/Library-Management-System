import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Book {
    enum availability {
        available,unavailable;
    }
    private static HashMap<Integer,String> bookID_title = new HashMap<>();
    private static HashMap<Integer,String> bookID_author = new HashMap<>();
    private static HashMap<Integer,String> bookID_description = new HashMap<>();
    private static HashMap<Integer,availability> bookID_availability = new HashMap<>();
    public void add_book(int newbookID) {
        Scanner sc = new Scanner(System.in);
        String title = "";
        String author = "";
        String description = "";
        do{
            try {
                System.out.println("Please enter the name of the book.");
                title = sc.nextLine();
                System.out.println("Please enter the name of the author.");
                author = sc.nextLine();
                System.out.println("Please enter a description of the book.");
                description = sc.nextLine();
            }catch (Exception e) {
                System.out.println("Please try again.");
            }
        }while(title.isEmpty() || author.isEmpty() || description.isEmpty());
        bookID_title.put(newbookID,title);
        bookID_author.put(newbookID,author);
        bookID_description.put(newbookID,description);
        bookID_availability.put(newbookID,availability.available);
        System.out.println("Book added successfully.");
    }
    public void remove_book() {
        Scanner sc = new Scanner(System.in);
        int bookID = 0;
        do {
            System.out.println("Please enter ID of the book.");
            try {
                bookID = sc.nextInt();
            }catch (Exception e) {
                System.out.println("Error : Illegal entry.");
            }
        }while (bookID == 0 || !bookID_title.containsKey(bookID));
        bookID_title.remove(bookID);
        bookID_author.remove(bookID);
        bookID_description.remove(bookID);
        bookID_description.remove(bookID);
        bookID_availability.remove(bookID);
    }
    public void viewBooks() {
        System.out.println("Books :");
        System.out.println("ID | title | author | availability | description | date");
        System.out.println("---------------------------------");
        for (int i : bookID_title.keySet()) {
            System.out.println(i + " | " + bookID_title.get(i) + " | " + bookID_author.get(i) + " | " + bookID_availability.get(i) +" | " + bookID_description.get(i));
            System.out.println("---------------------------------");
        }
    }
    public void viewAvailableBooks() {
        System.out.println("Books :");
        System.out.println("ID | title | author | description");
        System.out.println("---------------------------------");
        for (int i : bookID_title.keySet()) {
            if (bookID_availability.get(i) == availability.unavailable) {
                continue;
            }
            System.out.println(i + " | " + bookID_title.get(i) + " | " + bookID_author.get(i) + " | " + bookID_description.get(i));
            System.out.println("---------------------------------");
        }
    }
    public boolean checkIfAvailable(String bookname) {
        int bookID = 3000;
        boolean answear = false;
        ArrayList<Integer> availabeBookID = new ArrayList<>();
        for (int i=0 ; i<bookID_title.size() ; i++) {
            if (bookname.equalsIgnoreCase(bookID_title.get(bookID))) {
                if (bookID_availability.get(bookID) == availability.available) {
                    availabeBookID.add(bookID);
                    answear = true;
                }
            }
            bookID++;
        }
        if(answear) {
            System.out.println("Available books with the given title:");
            System.out.println("ID | title | author | description");
            System.out.println("---------------------------------");
            for (int i : availabeBookID) {
                System.out.println(i + " | " + bookID_title.get(i) + " | " + bookID_author.get(i) + " | " + bookID_description.get(i));
                System.out.println("---------------------------------");
            }
        }
        return answear;
    }
    public ArrayList<Integer> availableIDs(String bookname) {
        int bookID = 3000;
        ArrayList<Integer> availabeBookID = new ArrayList<>();
        for (int i=0 ; i<bookID_title.size() ; i++) {
            if (bookname.equalsIgnoreCase(bookID_title.get(bookID))) {
                if (bookID_availability.get(bookID) == availability.available) {
                    availabeBookID.add(bookID);
                }
            }
            bookID++;
        }
        return availabeBookID;
    }
    public void changeAvailability(int bookID) {
        if (bookID_availability.get(bookID) == availability.available) {
            bookID_availability.replace(bookID, availability.unavailable);
        }else {
            bookID_availability.replace(bookID, availability.available);
        }
    }
    public String getTitle(int id) {
        return bookID_title.get(id);
    }
}