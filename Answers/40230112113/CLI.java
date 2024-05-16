import java.util.Scanner;

public class CLI
{
    //i shouldn't have written this class. using only the library class was sufficient :')

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String BLACK = "\u001B[30m";

    static boolean IsAdmin=false;

    static Scanner sc = new Scanner(System.in);

    Library library;
    public CLI(Library library)
    {
        this.library=library;
    }

    Boolean First_Run=true;
    public void Run()
    {
        if(First_Run)
        {
            System.out.println(BLUE+"WELCOME"+RESET);
            First_Run=false;
        }
        System.out.println(PURPLE+"1-ADMIN\n"+"2-NORMAL USER\n"+"3-Exit\n"+RESET);
        int a = sc.nextInt();
        switch(a)
        {
            case 1:
                AdminPanel();
                break;
            case 2:
                NormalUserPanel();
                break;
            case 3:
                System.out.println(GREEN+"Have a nice day!"+RESET);
                break;
            default:
                System.out.println("wrong entry. please try again.");
                Run();
        }
    }


    Boolean First_time_ad=true;
    public void AdminPanel()
    {
        System.out.println(BLUE+"WELCOME TO ADMIN PANEL"+RESET);
        System.out.println("please enter your name and password");
        System.out.print("Name: ");
        String AdminName = sc.nextLine();
        
        if(AdminName.equalsIgnoreCase("exit"))
        {
            Run();
        }
        if(First_time_ad)
        {
            First_time_ad=false;
            IsAdmin=true;
            library.First_admin();
            AllCommands();
        }
        else if(First_time_ad==false)
        {
            Admin admin = null;
            if(library.CheckName(AdminName)==AdminName)
            {
                
                System.out.print("password: ");
                String password=sc.nextLine();
                if(library.CheckPassword(password,AdminName))
                {
                    System.out.println("welcome "+AdminName);
                    IsAdmin=true;
                    AllCommands();
                }
            }
            else
            {
                System.out.println("no match found. please try again.");
                AdminPanel();
            }
        }
    }


    Boolean First_time_us=true;
    public void NormalUserPanel()
    {
        if(First_time_us)
        {
            System.out.println("WELCOME TO RAIN LIBRARY");
            First_time_us=false;
        }
        System.out.println("Please enter your Name and Phone Number");
        System.out.println("to go back to the main menu please enter \"exit\" ");
        String name = sc.nextLine();
        if(true)
        {
            System.out.print("Phone Number: ");
            String phonenumber = sc.nextLine();
            if(library.Checknumber(phonenumber))
            {
                System.out.println("welcome "+name);
                IsAdmin=false;
                AllCommands();
            }
        }
    }


    public void AllCommands()
    {
        System.out.println("input \"lib help\" to see all the commands available");
        System.out.print("enter the command: ");
        String command = sc.nextLine();
        command.replaceAll("[^a-zA-Z0-9]", "");
        String[] splitted = command.split(" ");
        //boolean isCorrect=true;
        //while(isCorrect)
        //{
            if(splitted[0].equals("lib"))
            {
                switch(splitted[1].toLowerCase())
                {
                    case "add":
                    {
                        if(IsAdmin==true)
                        {
                            if(splitted[2].equalsIgnoreCase("book"))
                            {
                                String s="";
                                int i=5;
                                for(;;)
                                {
                                    s+=splitted[i].toString();
                                    i++;
                                    if(splitted[i]==null)
                                        break;
                                }
                                library.addbook(splitted[3],splitted[4],s);
                                AllCommands();
                            }
                            else if(splitted[2].equalsIgnoreCase("admin"))
                            {
                                library.addAdmin(splitted[3],splitted[4]);
                                AllCommands();
                            }
                        }
                        else
                        {
                            System.out.println("Permission not granted. you are not an admin. please try again.");
                            AllCommands();
                        }
                    }
                    case "get":
                    {
                        if(splitted[2].equalsIgnoreCase("available"))
                        {
                            if((splitted[3].equalsIgnoreCase("books"))||(splitted[3].equalsIgnoreCase("book")))
                            {
                                library.showbooks();
                                AllCommands();
                            }
                            else
                            {
                                System.out.println("wrong entry. please try again.");
                                AllCommands();
                            }
                        }
                        else if((splitted[2].equalsIgnoreCase("hrs"))||(splitted[2].equalsIgnoreCase("hours"))||(splitted[2].equalsIgnoreCase("hour")))
                        {
                            System.out.println(library.getWorkinghours());
                            AllCommands();
                        }
                        else
                        {
                            System.out.println("wrong entry. please try again.");
                            AllCommands();
                        }
                    }
                    case "rent":
                    {
                        library.Rentbook(splitted[2], splitted[3], splitted[4]);
                        AllCommands();
                    }
                    case "remove":
                    {
                        if(splitted[2].equalsIgnoreCase("admin"))
                        {
                            library.RemoveAdmin(splitted[3]);
                        }
                        else if(splitted[2].equalsIgnoreCase("book"))
                        {
                            library.Removebook();
                        }
                        else
                        {
                            System.out.println("wrong entry. please try again.");
                            AllCommands();
                        }
                    }
                    case "return":
                    {
                        library.returnbook(splitted[2]);
                        AllCommands();
                    }
                    case "help":
                    {
                        HelpCommand();
                        AllCommands();
                    }
                    default:
                    {
                        System.out.println("wrong entry. please try again.");
                        AllCommands();
                    }
                }
            }
            else if(splitted[0].equalsIgnoreCase("exit"))
            {
                Run();
            }
            else
            {
                System.out.println("wrong entry. please try again.");
                AllCommands();
            }
        //}
    }
    public void HelpCommand()
    {
        System.out.println(RED+"lib add book <name> <author> <subtitle>: Add a new book to the library."+RESET);
        System.out.println(RED+"lib get hrs: Retrieve library operating hours."+RESET);
        System.out.println(YELLOW+"lib remove book <bookName>: Remove a book from the library."+RESET);
        System.out.println(GREEN+"lib add admin <name> <password>: Add a new member to the library (admin privilege required)."+RESET);
        System.out.println(GREEN+"lib rent <name> <bookName> <memberID>: Rent a book for a specific member."+RESET);
        System.out.println(CYAN+"lib get available books: View available books for rental."+RESET);
        System.out.println(BLUE+"lib remove admin <adminID>: Remove a member from the library (admin privilege required)."+RESET);
        System.out.println(PURPLE+"lib return <bookName>: Return a rented book to the library."+RESET);
        System.out.println(PURPLE+"exit: Go back to MainMenu"+RESET);
    }
}