import java.util.HashSet;
import java.util.Random;

public class Book {

    private int Unique_bookID;

    private String Title;
    private String Author;
    private boolean Availability_status = true;
    private String Description;

    private HashSet<Integer> UsedID = new HashSet<>();

    public Book( String Title, String Author, String Deccription) {
        Unique_bookID = generateUniqueId();
        this.Title = Title;
        this.Author = Author;
        this.Availability_status = Availability_status;
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

    public String toString(){
        return this.Unique_bookID + " " + this.Title + " " +  this.Author + " " + "\n" +this.Description + "\n" +
                this.Availability_status;
    }

    public void setAvailability_status(boolean Status){
        Availability_status = Status;
    }
}

