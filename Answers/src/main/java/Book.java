public class Book {
    private int bookId;
    private String Title;
    private String Author;
    private boolean Availability_status;
    private String Description;

    public Book(int bookId , String Title , String Author , boolean Availability_status, String Description){
        this.bookId = bookId;
        this.Author = Author;
        this.Title = Title;
        this.Availability_status = Availability_status;
        this.Description = Description;

    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public boolean getAvailability_status() {
        return Availability_status;
    }

    public void setAvailability_status(boolean availability_status) {
        Availability_status = availability_status;
    }
}
