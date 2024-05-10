import java.util.ArrayList;

public class Library{
    private String libraryName = "myLibrary";
    private int capacity = 350 ;

    private String operatingHours = "8:00 _ 21:00";

    String[] bookRepository;

    private ArrayList<Book> bookList = new ArrayList<>();
    private  ArrayList<User> userList = new ArrayList<>();
    private ArrayList<Rent> rentList = new ArrayList<>();


    public String getHours() {
        return operatingHours;
    }

    public void addBook(String name, String Id, String subtitle){
        Book book = new Book(name, Id, subtitle);
        bookList.add(book);
    }

    public void addMember(String name, String password){
        Admin admin = new Admin(name, password);
        userList.add(admin);
    }

    public void rentBook(String bookName){
        for (int i = 0; i < bookList.size(); i++){
            if (bookList.get(i).title == bookName){
                if (bookList.get(i).availabilityStatus){
                    Rent rent = new Rent(bookName);
                    rentList.add(rent);
                    return;
                }
                else {
                    System.out.println("Book Is Unavailable");
                    return;
                }
            }
        }
        System.out.println("book not found");
    }

    public void removeMember(String memberId){
        for (int i = 0; i < userList.size(); i++){
            if (userList.get(i).Id == memberId){
                userList.remove(i);
                return;
            }
        }
        System.out.println("member not found");
    }

    public void returnBook(String bookName){
        for (int i = 0; i < bookList.size(); i++){
            if(bookList.get(i).title == bookName){
                bookList.get(i).availabilityStatus = true;
            }
        }
        for (int i = 0; i < rentList.size(); i++){
            if (rentList.get(i).bookObject == bookName){
                rentList.remove(i);
                return;
            }
        }
        System.out.println("book not found");
    }

    public void availableBooks(){
        for (int i = 0; i < bookList.size(); i++){
            if(bookList.get(i).availabilityStatus){
                System.out.println(bookList.get(i).title + "\n");
            }
        }
    }


}
