import java.util.ArrayList;

public class Library{
    private String libraryName = "myLibrary";
    private int capacity = 350 ;

    private String operatingHours = "8:00 _ 21:00";


    private ArrayList<Book> bookList = new ArrayList<>();
    private  ArrayList<NormalUser> userList = new ArrayList<>();
    private ArrayList<Rent> rentList = new ArrayList<>();


    public String getHours() {
        return operatingHours;
    }
    public String getLibraryName(){
        return libraryName;
    }

    public int getCapacity(){
        return capacity;
    }

    public void addBook(String name, String author, String subtitle){
        Book book = new Book(name, author, subtitle);
        bookList.add(book);
    }

    public void addMember(String name, String phoneNumber){
        NormalUser normalUser = new NormalUser( name,  phoneNumber);
        userList.add(normalUser);
    }

    public void rentBook(String bookName, String userName){
        for (int i = 0; i < userList.size(); i++){
            if (userList.get(i).getName() == userName){
                for (int j = 0; j < bookList.size(); j++){
                    if (bookList.get(j).getTitle() == bookName){
                        if (bookList.get(j).getAvailabilityStatus()){
                            Rent rent = new Rent(userList.get(i), bookList.get(j));
                            rentList.add(rent);
                            System.out.println("successful");
                            return;
                        }
                        else {
                            System.out.println("Book Is Unavailable");
                            return;
                        }
                    }
                }
                System.out.println("book not found");
                return;
            }
        }
        System.out.println("user not found");
    }

    public void removeMember(String memberId){
        for (int i = 0; i < userList.size(); i++){
            if (userList.get(i).getId() == memberId){
                userList.remove(i);
                System.out.println("successful");
                return;
            }
        }
        System.out.println("member not found");
    }

    public void returnBook(String bookName){
        for (int i = 0; i < bookList.size(); i++){
            if(bookList.get(i).getTitle() == bookName){
                bookList.get(i).setAvailabilityStatus(true);
                for (int j = 0; j < rentList.size(); j++){
                    if (rentList.get(j).getBookObject().getTitle() == bookName){
                        rentList.remove(j);
                        System.out.println("successful");
                        return;
                    }
                }
                System.out.println("book not found");
            }
        }
        System.out.println("book not found");
    }


    public void availableBooks(){
        for (int i = 0; i < bookList.size(); i++){
            if(bookList.get(i).getAvailabilityStatus()){
                System.out.println(bookList.get(i).getTitle() + "\n");
            }
        }
    }


}
