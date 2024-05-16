import jdk.jfr.Description;

public class Book {
    private int BookID;
    private String Title, Author, Description;
    private boolean AvailibilityStatus;
    public Book(String Title, String Author,String Description){
        BookID=1;
        this.Title=Title;
        this.Author=Author;
        this.Description=Description;
        this.AvailibilityStatus=true;
    }

    public int getBookID() {
        return BookID;
    }

    public String getAuthor() {
        return Author;
    }

    public String getDescription() {
        return Description;
    }

    public String getTitle() {
        return Title;
    }
    public void setAvailibilityStatus(){
        this.AvailibilityStatus=(!AvailibilityStatus);
    }
    public boolean getAvailibilityStatus(){
        return AvailibilityStatus;
    }
}
