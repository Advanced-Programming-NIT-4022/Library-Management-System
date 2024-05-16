import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    private String Name;
    private int Capacity;
    private String OperatingHours;
    private ArrayList<Book> BookRepository;
    private ArrayList<Admin> AllAdmins;
    private ArrayList<NormalUser> AllNormalUsers;

    private ArrayList<Rent> RentalRegistry;

    public Library(String Name, int Capacity, String OperatingHours) {
        this.Name = Name;
        this.Capacity = Capacity;
        this.OperatingHours = OperatingHours;
        this.BookRepository = new ArrayList<>();
        this.AllAdmins = new ArrayList<>();
        this.AllNormalUsers=new ArrayList<>();
        this.RentalRegistry = new ArrayList<>();
    }

    public String getName() {
        return Name;
    }

    public int getCapacity() {
        return Capacity;
    }

    public String getOperatingHours() {
        return OperatingHours;
    }

    public void addNewBook(Book book) {
        if(Capacity>BookRepository.size()) {
            BookRepository.add(book);
        }
    }

    public ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> AvailableBooks = new ArrayList<>();
        for (Book book : BookRepository) {
            if (book.getAvailibilityStatus()) {
                AvailableBooks.add(book);
            }
        }
        return AvailableBooks;
    }


    public void addNewAdmin(Admin user){
        AllAdmins.add(user);
    }
    public void addNewNormalUser(NormalUser user){
        AllNormalUsers.add(user);
    }
     public void removeNormalUser(NormalUser user){
        AllNormalUsers.remove(user);
     }
     public ArrayList<Admin> getAllAdmins(){
        return AllAdmins;
     }
     public ArrayList<NormalUser> getAllNormalUsers(){
        return AllNormalUsers;
     }
     public void newRent(NormalUser normalUser, Book book){
        if (book.getAvailibilityStatus()){
//            String rentalDate = LocalDate.now().toString();
            book.setAvailibilityStatus();
            Rent rent = new Rent(LocalDate.now().toString(),book,normalUser);
            RentalRegistry.add(rent);
        }
     }
    public void returnBook(Book book) {
        for (Rent rent : RentalRegistry) {
            if (rent.getBook().equals(book)) {
                RentalRegistry.remove(rent);
                book.setAvailibilityStatus();
            }
        }
    }
}
