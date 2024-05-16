import java.util.ArrayList;
import java.util.Scanner;

public class Library
{
    static Scanner sc = new Scanner(System.in);

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String BLUE = "\u001B[34m";


    private String LibName;
    private int capacity;
    private String Workinghours;
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Rent> rents = new ArrayList<>();


    public Library(String LibName , int capacity , String Workinghours)
    {
        this.setname(LibName);
        this.setcapacity(capacity);
        this.Workinghours=Workinghours;
        this.books=new ArrayList<Book>();
        this.users=new ArrayList<User>();
        this.rents=new ArrayList<Rent>();
    }
    int BookID=1;
    int UserID=1;
    int RentID=1;

    public String getLibName()
    {
        return LibName;
    }
    public void setname(String LibName)
    {
        this.LibName=LibName;
    }
    public int getCapacity()
    {
        return capacity;
    }
    public void setcapacity(int capacity)
    {
        this.capacity=capacity;
    }
    public String getWorkinghours()
    {
        return Workinghours;
    }

    public void First_admin()
    {
        System.out.print("please enter your name: ");
        String name = sc.nextLine();
        System.out.print("please enter your password: ");
        String password = sc.nextLine();
        System.out.print("please enter your number: ");
        boolean check_it = false;
        String number="";
        while(!check_it)
        {
            number = sc.nextLine();
            check_it=Checknumber(number);
        }
        Admin admin = new Admin(name, UserID, number, password);
        UserID++;
        users.add(admin);
    }

    public void addAdmin(String name , String password)
    {
        String number="";
        boolean check_it=false;
        while(check_it==false)
        {
            System.out.println("please enter your number");
            number=sc.nextLine();
            check_it=Checknumber(number);
        }
        Admin admin = new Admin(name, UserID, number, password);
        UserID++;
        users.add(admin);
        System.out.println(name+" "+password);
    }

    public void RemoveAdmin(String ID)
    {
        Integer id = Integer.valueOf(ID);
        //to convert string to integer :>
        for(User i : users)
        {
            if(i.getID()==id)
            {
                users.remove(i);
            }
        }
    }


    public void addbook(String title , String author , String description)
    {
        System.out.print("availability: ");
        Boolean availability=sc.nextBoolean();
        Book newbook = new Book(title, description, availability, author, BookID);
        BookID++;
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
    
    public void returnbook(String name)
    {
        for (Book i : books)
        {
            if(i.getTitle().equalsIgnoreCase(name))
            {
                i.setIsAvailable(true);
            }    
        }
    }

    public void Rentbook(String name , String title , String ID)
    {
        NormalUser u = null;
        Book b = null;
        Integer id = Integer.valueOf(ID);
        if(CheckName(name)==name)
        {
            for(User i : users)
            {
                
                if(i.getName().equalsIgnoreCase(name))
                {
                    if(i.getID()==id)
                    {
                        u=(NormalUser) i;
                        break;
                    }
                    else
                    {
                        System.out.println("incorrect id. please try again.");
                        return;
                    }
                }
            }
            
            for(Book i : books)
            {
                if((i.getTitle().equalsIgnoreCase(title)))
                {
                    b=i;
                    break;
                }
                else
                {
                    System.out.println("book not found. please try again.");
                    return;
                }
            }
            Rent rent = new Rent(b, u, RentID);
            RentID++;
            rents.add(rent);
            b.setIsAvailable(false);
        }
        else
        {
            System.out.println("user not found. please try again.");
            return;
        }
    }

    public void Removebook()
    {
        System.out.print("input the book title: ");
        String booktitle=sc.nextLine();
        for(Book i : books)
        {
            if(i.getTitle().equalsIgnoreCase(booktitle))
            {
                books.remove(i);
            }
        }
    }



    //***************** checking system******************//
    public Boolean CheckPassword(String password, String name)
    {
        boolean hm=false;
        for (User i : users)
        {
            if (CheckName(i.getName())==name)
            {
                //Admin admin=null;
                //int admin_id=i.getID();
                if(users.indexOf(password)==users.indexOf(name))
                {
                    hm=true;
                    break;
                }
                else
                {
                    hm=false;
                    break;
                }
            }
        }
        return hm;
    }

    public String CheckName(String name)
    {
        for (User i : users)
        {
            if (i.getName().equalsIgnoreCase(name))
            {
                return name;
            }
        }
        System.out.println("no match found.");
        return "false";
    }

    public Boolean Checknumber(String num)
    {
        Boolean haha=true;
        if ((num.length()==11)&&((num.charAt(0)=='0')&&(num.charAt(1)=='9')))
        {
            for(int i=2;i<num.length();i++)
            {
                if((num.charAt(i)>'9')||(num.charAt(i)<'0'))
                {
                    haha=false;
                    break;
                }
            }
        }
        else if ((num.length()==10)&&(num.charAt(0)=='9'))
        {
            //num=0+num;
            for(int i=1;i<num.length();i++)
            {
                if((num.charAt(i)>'9')||(num.charAt(i)<'0'))
                {
                    haha=false;
                    break;
                }
            }
        }
        else
        {
            haha=false;
        }
        if(!haha)
            System.out.println("Wrong entry. Try again.");

        return haha;
    }

    //**************************************************//
}
