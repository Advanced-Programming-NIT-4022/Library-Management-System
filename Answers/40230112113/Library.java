import java.util.ArrayList;

public class Library
{
    private String LibName;
    private int capacity;
    private int hours;
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Rent> rents = new ArrayList<Rent>();

    public Library(String LibName , int capacity , int hours , ArrayList<Book> books , ArrayList<User> users , ArrayList<Rent> rents)
    {
        this.LibName=LibName;
        this.capacity=capacity;
        this.hours=hours;
        this.books=books;
        this.users=users;
        this.rents=rents;
    }
}
