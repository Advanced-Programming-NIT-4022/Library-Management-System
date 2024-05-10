import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CLI
{
    //i shouldn't have written this class. using only the library class was sufficient :')

    static Pattern pattern = Pattern.compile("exit", Pattern.CASE_INSENSITIVE);

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String BLUE = "\u001B[34m";

    static Scanner sc = new Scanner(System.in);

    Library library;
    public CLI(Library library)
    {
        this.library=library;
    }

    Boolean First_time2=true;
    public void Run()
    {
        if(First_time2)
        {
            System.out.println(BLUE+"WELCOME"+RESET);
            First_time2=false;
        }
        System.out.println(PURPLE+"1-ADMIN\n"+"2-NORMAL USER\n"+"3-Exit\n"+RESET);
        int a = sc.nextInt();
        switch(a)
        {
            case 1:
            {
                AdminPanel();
                break;
            }
            case 2:
                NormalUserPanel();
                break;
            case 3:
                System.out.println(GREEN+"Have a nice day!"+RESET);
                break;
        }
        sc.close();
    }

    Boolean first_time=true;
    public void AdminPanel()
    {
        if(first_time)
            {
                System.out.println("WELCOME TO ADMIN PANEL");
                first_time=false;
            }
            System.out.println("please enter your name and password");
            System.out.print("Name: ");
            String AdminName = sc.nextLine();
            
            Matcher matcher = pattern.matcher(AdminName);
            if(matcher.find()==true)
            {
                Run();
            }

            else if((library.CheckPassword()==true))
            {
                System.out.println("Password: ");
                String Password = sc.nextLine();

                matcher = pattern.matcher(Password);
                if(matcher.find()==true)
                {
                    Run();
                }
                else if(library.CheckName()==true)
                {
                    System.out.println("WELCOME "+AdminName);  

                }
            }
            else
            {
                System.out.println("Name not found. please try again");
                Run();
            }
    }


    Boolean First_time=true;
    public void NormalUserPanel()
    {
        if(First_time)
            {
                System.out.println("WELCOME TO RAIN LIBRARY");
                First_time=false;
            }
        System.out.println("Please enter your Phone Number and Student ID");
        System.out.println("to go back to the main menu please enter \"exit\" ");
        System.out.print("Phone Number: ");
        String phonenumber = sc.nextLine();

        Matcher matcher = pattern.matcher(phonenumber);
        if(matcher.find()==true)
        {
            Run();
        }
        else if((library.Checknumber(phonenumber)==true))
        {
            System.out.print("Student ID: ");
            String StdID = sc.nextLine();

            matcher = pattern.matcher(StdID);
            if(matcher.find()==true)
            {
                Run();
            }
            else if (((StdID.length()>=14)||(StdID.length()<=3)))
            {
                System.out.println("wrong student ID. please try again.");
                NormalUserPanel();
            }   
        }
        else
        {
            System.out.println("Wrong entry. Please try again.");
            NormalUserPanel();
        }
    }


    public void AllCommands()
    {
        System.out.println("1-lib add book <name> <author> <subtitle> \n"+"2-lib get hrs \n"+"3-lib rent <bookName> <memberName> <memberID>\n");
        System.out.println("4-lib get available books\n"+"5-lib get available books\n"+"6-lib add member <studentID> <password>\n");
        System.out.println("7-lib remove member <memberID>\n");
        int a = sc.nextInt();
        switch(a)
        {
            case 1:
                library.addbook();
                AllCommands();
                break;
            case 2:
                System.out.println(library.getWorkinghours());
                AllCommands();
                break;
            case 3:
                library.Rentbook();
                AllCommands();
                break;
            case 4:
                library.showbooks();
                AllCommands();
                break;
            case 5:
                library.returnbook();
                AllCommands();
                break;
            case 6:
            {
                
            }
        }
    }
}
