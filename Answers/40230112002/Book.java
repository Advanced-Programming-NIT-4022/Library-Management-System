import java.util.HashSet;
import java.util.Random;

public class Book {

    private int Unique_bookID;

    private String Title;
    private String Author;
    private boolean Availability_status = true;
    private String Description;

    private HashSet<Integer> UsedID = new HashSet<>();

    public Book(int Unique_bookID , String Title , String Author , boolean Availability_status ,String Deccription ){

        this.Unique_bookID = Unique_bookID;
        this.Author = Author;
        this.Availability_status = Availability_status;
        this.Description = Deccription;
    }
