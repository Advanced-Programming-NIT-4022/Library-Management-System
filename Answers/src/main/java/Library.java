import java.time.LocalTime;
import java.util.ArrayList;

public class Library {
    String library_name;
    int capacity ;
    int operating_hours1;
    int operating_hours2;
     ArrayList<Book> book_repository = new ArrayList<Book>();
    ArrayList<NormalUser> userArray = new ArrayList<NormalUser>();
    ArrayList<Rent> rental_registries = new ArrayList<Rent>();
    ArrayList<Admin> adminArray = new ArrayList<Admin>();
    ArrayList<User> usersArray = new ArrayList<User>();

    public Library (String library_name , int capacity, int operating_hours1 , int operating_hours2){
        this.library_name = library_name;
        this.capacity = capacity;
        this.operating_hours1 = operating_hours1;
        this.operating_hours2 = operating_hours2;
        this.book_repository = new ArrayList<>();
        this.userArray = new ArrayList<>();
        this.rental_registries = new ArrayList<>();
        this.adminArray = new ArrayList<>();
        this.usersArray = new ArrayList<>();

    }

    public String getLibrary_name() {
        return library_name;
    }
    public void setLibrary_name(String library_name) {
        this.library_name = library_name;
    }

    public int getOperating_hours1(){
        return operating_hours1;
    }

    public void setOperating_hours1(int operating_hours1) {
        this.operating_hours1 = operating_hours1;
    }

    public int getOperating_hours2() {
        return operating_hours2;
    }

    public void setOperating_hours2(int operating_hours2) {
        this.operating_hours2 = operating_hours2;
    }
}
