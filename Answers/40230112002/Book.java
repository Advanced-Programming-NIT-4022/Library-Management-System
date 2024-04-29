
public class Book{

    private static Integer Unique_bookID = 0;

    private String Title;
    private String Author;
    private boolean Availability_status = true;
    private String Description;

    public Book( String Title, String Author, String Deccription) {
        this.Unique_bookID = generateUniqueBookID();
        this.Title = Title;
        this.Author = Author;
        this.Availability_status = Availability_status;
        this.Description = Deccription;
    }
    private static int generateUniqueBookID() {
        return ++Unique_bookID;
    }


    public String toString(){
        return this.Unique_bookID + " " + this.Title + " " +  this.Author + " " + "\n" +this.Description + "\n" +
                this.Availability_status;
    }

    public void setAvailability_status(boolean Status){
        Availability_status = Status;
    }
    public int getUnique_BookID(){
        return Unique_bookID;
    }
}

