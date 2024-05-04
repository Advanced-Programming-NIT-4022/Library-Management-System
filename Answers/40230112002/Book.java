public class Book {


    private String Author;
    private String Title;
    private Boolean Availability_status = true;
    private String Description;
    private Integer BookID;
    public static Integer LastBookID = 0;


    public Book( String Title, String Author, String Deccription) {
        this.BookID = ++LastBookID;
        this.Title = Title;
        this.Author = Author;
        this.Description = Deccription;
    }


    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }


    public Boolean getAvailability_status() {
        return Availability_status;
    }

    public void setAvailability_status(Boolean availability_status) {
        Availability_status = availability_status;
    }

    public String getDescription() {
        return Description;
    }


    public String toString(){
        return BookID + " " + this.Title + " " +  this.Author + " " +this.Description  +
                this.Availability_status;
    }

}

