import java.util.HashSet;
import java.util.Random;

public class Book {

    private int Unique_bookID;

    private String Title;
    private String Author;
    private boolean Availability_status;
    private String Description;

    private HashSet<Integer> UsedID = new HashSet<>();

    public Book(int Unique_bookID , String Title , String Author , boolean Availability_status ,String Deccription ){

        this.Unique_bookID = generateUniqueId();
        this.Author = Author;
        this.Availability_status = true;
        this.Description = Deccription;
    }


    public int generateUniqueId() {
        Random rand = new Random();
        Integer newID;
        do {
            newID = rand.nextInt(100, 9999);
        } while (UsedID.contains(newID));
        UsedID.add(newID);
        return newID;
    }
}

