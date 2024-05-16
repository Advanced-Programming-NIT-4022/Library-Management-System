public class Book {
    private String Title;
    private String Author;

    private int ID ;

    public Book(String Title , String Author , int countID)
    {
        this.Author=Author;
        this.Title=Title;
        this.ID=countID;
    }
    public String getTitle()
    {
        return Title;
    }
    public void setTitle(String title)
    {
        this.Title=title;
    }
    public String getAuthor()
    {
        return Author;
    }
    public void setAuthor(String author)
    {
        this.Author=author;
    }
    public int getID()
    {
        return ID;
    }
    public void setAuthor(int ID)
    {
        this.ID=ID;
    }

}
