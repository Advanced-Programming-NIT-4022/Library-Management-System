public class Book
{
    private String Title;
    private String Description;
    private Boolean IsAvailable;
    private String Author;
    private int BookID=1000;
    
    public Book(String Title , String Description , Boolean IsAvailable , String Author , int BookID)
    {
        this.Author=Author;
        this.Description=Description;
        this.BookID=BookID++;
        this.IsAvailable=IsAvailable;
        this.Title=Title;
    }
    public String getTitle()
    {
        return Title;
    }
    public String getDescription()
    {
        return Description;
    }
    public String getAuthor()
    {
        return Author;
    }
    public Boolean getIsAvailable()
    {
        return IsAvailable;
    }
    public int getBookID()
    {
        return BookID;
    }
}
