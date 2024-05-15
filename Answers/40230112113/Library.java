import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Library
{
    static Scanner sc = new Scanner(System.in);

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String BLUE = "\u001B[34m";

    static Pattern pattern = Pattern.compile("exit", Pattern.CASE_INSENSITIVE);

    private String LibName;
    private int capacity;
    private String Workinghours;
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Rent> rents = new ArrayList<>();


    public Library(String LibName , int capacity , String Workinghours)
    {
        this.LibName=LibName;
        this.capacity=capacity;
        this.Workinghours=Workinghours;
        this.books=new ArrayList<Book>();
        this.users=new ArrayList<User>();
        this.rents=new ArrayList<Rent>();
    }
    int BookID=1;
    int UserID=1;
    int RentID=1;
    public String getWorkinghours()
    {
        return Workinghours;
    }

    public void addbook()
    {
        String title=sc.nextLine();
        String description=sc.nextLine();
        String author=sc.nextLine();
        Boolean availability=sc.nextBoolean();
        Book newbook = new Book(title, description, availability, author, BookID++);
        books.add(newbook);
    }

    public void showbooks()
    {
        for (Book showbook : books)
        {
            if(showbook.getIsAvailable())
            {
                System.out.println(showbook.getTitle()+"by"+showbook.getAuthor());
            }
        }
    }
    
    public void returnbook()
    {

    }

    public void Rentbook()
    {

    }

    public void Removebook()
    {
        String booktitle=sc.nextLine();
        int a = books.indexOf(booktitle);
        books.remove(a);
    }



    //***************** checking system******************//
    public Boolean CheckPassword(String password, Admin admin)
    {
        boolean hm=false;
        for (User i : users)
        {
            if (password.equals(admin.getPassword()))
            {
                hm=true;
                break;
            }
        }
        return hm;
    }

    public Boolean CheckName(String name)
    {
        boolean hm=false;
        for (User i : users)
        {
            if (name.equalsIgnoreCase(i.getName()))
            {
                hm=true;
                break;
            }
        }
        return hm;
    }

    public Boolean Checknumber(String num)
    {
        Boolean haha=true;
        if ((num.length()==11)&&((num.charAt(0)=='0')&&(num.charAt(1)=='9')))
        {
            haha=true;
        }
        else if ((num.length()==10)&&(num.charAt(0)=='9'))
        {
            num=0+num;
            haha=true;
        }
        else
        {
            System.out.println("Wrong entry. Try again.");
            haha=false;
        }
        return haha;
    }

    //**************************************************//
}
