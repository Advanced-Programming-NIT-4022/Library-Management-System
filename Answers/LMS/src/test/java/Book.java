public class Book {
    private int bookID;
    private String Title;
    private String Author;
    private boolean Availability;
    private String Description;

    public Book(String Title, String Author, String Description , int bookID) {
        this.Title = Title;
        this.Author = Author;
        this.Description = Description;
        this.Availability = true;
        this.bookID = bookID;
    }

    public int getBookID() {

        return bookID;
    }
    public String getTitle(){

        return Title;
    }
    public String getAuthor(){
        return  Author;
    }
    public boolean isAvailable(){

        return Availability;
    }
    public void setAvailable(boolean Availability){

        this.Availability = Availability;
    }
    public String getDescription(){

        return Description;
    }
}
